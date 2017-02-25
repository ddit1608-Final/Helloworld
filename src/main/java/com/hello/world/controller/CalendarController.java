package com.hello.world.controller;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.common.base.Strings;
//수정중 병현
@Controller
public class CalendarController {
    /*static final Logger log = LoggerFactory.getLogger(CalendarController.class);

    private static final String AUTHORIZE_URL = "https://nid.naver.com/oauth2.0/authorize";
    private static final String CREATE_SCHEDULE_API_URL = "https://openapi.naver.com/calendar/createSchedule.json";

    private static final String KEY_STATE = "state";
    private static final String KEY_AUTH_RESPONSE_TYPE = "code";
    private static final String KEY_ACCESS_TOKEN = "access_token";
    private static final String KEY_API_CALL_RESULT = "api_call_result";

     https://developer.naver.com/openapi/register.nhn -> 네이버 로그인 에 등록한 정보로 수정 하셔야 합니다. 
	private static final String CLIENT_ID = "";
	private static final String CLIENT_SECRET = "";
	private static final String CALLBACK_URL = "";

     check variable 
    static {
        if (Strings.isNullOrEmpty(CLIENT_ID) || Strings.isNullOrEmpty(CLIENT_ID) || Strings.isNullOrEmpty(CLIENT_ID)) {
            throw new RuntimeException("서비스별 개별 설정값을 입력 해 주세요!");
        }
    }

    @RequestMapping("/index.nhn")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response, Model model) {
        String authorizationCode = getParam(request, KEY_AUTH_RESPONSE_TYPE);
        String accessToken = getParam(request, KEY_ACCESS_TOKEN);


        // 회원정보 동의얻는 화면으로 이동. 동의를 얻으면 다시 /index.nhn 로 callBack
        if (Strings.isNullOrEmpty(authorizationCode) && Strings.isNullOrEmpty(accessToken)) {
            log.info("인증코드 미확인. 인증획득 화면으로 이동");
            return redirectToAuthPage(response);
        }

        // accessToken 이 없다면, accessToken 을 획득한다.
        if (Strings.isNullOrEmpty(accessToken)) {
            log.info("access_token 획득 시도");
            accessToken = getAccessToken(authorizationCode, getParam(request, KEY_STATE));
            if (Strings.isNullOrEmpty(accessToken)) {
                model.addAttribute(KEY_API_CALL_RESULT, "인증값 획득 실패!");
                return new ModelAndView("callResult");
            }
        }

        model.addAttribute(KEY_ACCESS_TOKEN, accessToken);
        return inputSchedule(request, response, model);
    }

    @RequestMapping("/inputSchedule.nhn")
    public ModelAndView inputSchedule(HttpServletRequest request, HttpServletResponse response, Model model) {
        log.info("일정 등록 화면 로딩");
        return new ModelAndView("inputSchedule");
    }

    @RequestMapping("/createSchedule.nhn")
    public ModelAndView createSchedule(HttpServletRequest request, HttpServletResponse response, Model model) {
        log.info("일정 생성요청 전송");

        Map<String, String> param = new HashMap<String, String>();
        param.put("calendarId", "defaultCalendarId");
        param.put("scheduleIcalString", getParam(request, "scheduleIcalString"));

        String result = callApi(CREATE_SCHEDULE_API_URL, param, getParam(request, KEY_ACCESS_TOKEN));
        log.info("result=" + result);

        model.addAttribute(KEY_API_CALL_RESULT, result);
        return new ModelAndView("callResult");
    }

    private ModelAndView redirectToAuthPage(HttpServletResponse response) {
        String state = "stateVal" + new java.util.Random().nextInt();
        response.addHeader(KEY_STATE, state);

        String authUrl = AUTHORIZE_URL + "?client_id=" + CLIENT_ID + "&response_type=" + KEY_AUTH_RESPONSE_TYPE + "&redirect_uri=" + URLEncoder.encode(CALLBACK_URL) + "&state=" + state;
        log.info(authUrl);

        return new ModelAndView("redirect:" + authUrl);
    }

    private String getAccessToken(String authCode, String state) {
        String authUrl = "https://nid.naver.com/oauth2.0/token?client_id=" + CLIENT_ID + "&client_secret=" + CLIENT_SECRET + "&grant_type=authorization_code&response_type=authorization_code&state=" + state + "&code=" + authCode;
        log.info(authUrl);

        String result = callApiByGet(authUrl);

        Map<String, Object> accessTokenMap;
        try {
            accessTokenMap = new ObjectMapper().readValue(result, HashMap.class);
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
            return null;
        }

        String tokenType = (String) accessTokenMap.get("token_type");
        String accessToken = (String) accessTokenMap.get("access_token");

        log.info("accessToken=" + accessToken);
        log.info("token_type=" + tokenType);

        return accessToken;
    }


    private String callApiByGet(String url) {
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);
        method.setRequestHeader("charset", "UTF-8");
        String result = null;
        try {
            client.executeMethod(method);
            result = IOUtils.toString(method.getResponseBodyAsStream());
        } catch (Exception e) {
            log.warn(e.getMessage() + " url=" + url);
        }
        return result;
    }

    private String callApi(String url, Map<String, String> param, String authorization) {
        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(url);
        method.setRequestHeader("charset", "UTF-8");
        method.setRequestHeader("Authorization", "Bearer " + authorization);

        if (null != param) {
            NameValuePair[] nameValuePairsArr = generateNameValuePairArr(param);
            method.setRequestBody(nameValuePairsArr);
        }

        String result = null;
        try {
            loggingAllInfo(method);
            client.executeMethod(method);
            result = IOUtils.toString(method.getResponseBodyAsStream());
        } catch (Exception e) {
            log.warn(e.getMessage() + " url=" + url + " param=" + param, e);
        }
        return result;
    }

    private void loggingAllInfo(PostMethod method) {
        log.info("########################## logging request Info START ########################## ");
        try {
            log.info("### URI:" + method.getURI().toString());
        } catch (Exception e) {

        }

        log.info("### header ###");
        for (org.apache.commons.httpclient.Header header : method.getRequestHeaders()) {
            log.info(header.getName() + ":" + header.getValue());
        }

        log.info("### body ###");
        for (NameValuePair nvp : method.getParameters()) {
            log.info(nvp.getName() + ":" + nvp.getValue());
        }

        log.info("########################## logging request Info DONE  ########################## ");
    }

    private NameValuePair[] generateNameValuePairArr(Map<String, String> map) {
        List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();
        for (String key : map.keySet()) {
            nameValuePairList.add(new NameValuePair(key, map.get(key)));
        }

        NameValuePair[] nameValuePairsArr = new NameValuePair[nameValuePairList.size()];
        for (int i = 0; i < nameValuePairList.size(); i++) {
            nameValuePairsArr[i] = nameValuePairList.get(i);
        }

        return nameValuePairsArr;
    }

    @SuppressWarnings("unchecked")
    private String getParam(HttpServletRequest request, String key) {
        for (Object e : request.getParameterMap().entrySet()) {
            Map.Entry<String, String[]> entry = (Map.Entry<String, String[]>) e;
            for (String value : entry.getValue()) {
                if (key.equals(entry.getKey())) {
                    return value;
                }
            }
        }
        log.warn("can not find param. key=" + key);
        return null;
    }*/
    
    
}
