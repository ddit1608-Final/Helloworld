package com.hello.world.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Source;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.hello.world.dto.WantedRoot;
import com.hello.world.dto.WantedRoot.Wanted;


@Controller
@RequestMapping("/worknet")
public class WorknetController {
//	@Inject
//	RestTemplate template; 
	@RequestMapping("/worknet.do")
	   public String worknet(HttpSession session) throws ServletException, IOException {
	      String url = "worknet/worknet";

	      return url;
	}
	// 서버로 workNetAPI 접근하여  IP관련 직종의 전체 List
	@RequestMapping(value="/workNetList")
	@ResponseBody
	public Source worknet2(HttpSession session,HttpServletRequest req) throws RestClientException, URISyntaxException {
		
		RestTemplate template = new RestTemplate(); 
		Map<String, String> paramMap = new HashMap<String, String>();
		// 인증키
		paramMap.put("authKey", "WNIY9NMDKR331VMNQ8IZS2VR1HK");
		// 호출할 페이지 타입 		L목록,D 상세
		paramMap.put("callTp", "L");
		// 리턴타입은 반드시 XML
		paramMap.put("returnType", "XML");
		// 기본값 1 최대 1000까지 가능함
		paramMap.put("startPage", "1");
		// 출력 건수 기본값: 10 , 최대: 100
		paramMap.put("display", "10");
		// 직종 코드 (액셀 파일 참고 -직종코드.xls)
		paramMap.put("occupation", "203100|203101|203102|203200|203201|203202|203203|203204|203205|203206|"
				+ "085500|085501|085502|085503|085504|203206|204100|204101|204102|204200|204201|204202|204203"
				+ "|205100|205200|205201|205202|205203");
		// api url이며 parameter값들은 {}로 구분하여 맵에 입력한 값들로 대입하여 사용한다.
		ResponseEntity<Source> re = template.getForEntity(
				"http://openapi.work.go.kr/opi/opi/opia/wantedApi.do?authKey={authKey}&callTp={callTp}&returnType={returnType}&startPage={startPage}&display={display}&occupation={occupation}", 
				Source.class, paramMap);
		return re.getBody();
	}
	
	@RequestMapping(value="/addScrap")
	public String ScrapWorkNet(Wanted wanted) throws ServletException, IOException {
		String url = "worknet/worknet";
		
		return url;
	}
	
/*	@RequestMapping(value="/test.do", produces="text/html;charset=UTF-8")
	@ResponseBody
	public Source worknet2(HttpSession session) throws RestClientException, URISyntaxException {
		RestTemplate template = new RestTemplate(); 
		SourceHttpMessageConverter<Source> mc = new SourceHttpMessageConverter<Source>();
		mc.setSupportedMediaTypes(Arrays.asList(MediaType.TEXT_HTML));
		List<HttpMessageConverter<?>> mcList = new ArrayList<HttpMessageConverter<?>>();
		mcList.add(mc);
		
		template.setMessageConverters(mcList);
		ResponseEntity<Source> re = template.getForEntity(
				new URI("http://www.work.go.kr/jobyoung/empSrch/retriveJobsCodeList.do?"
						+ "depth=3&code=134&superCode=13&isOffer=Y"), Source.class);
		return re.getBody();
	}*/

}
