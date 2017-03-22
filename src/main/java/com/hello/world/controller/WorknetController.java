package com.hello.world.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.hello.world.dto.MemVO;
import com.hello.world.dto.WorkVO;
import com.hello.world.dto.testVO;
import com.hello.world.service.WorkNetService;

@Controller
@RequestMapping("/worknet")
public class WorknetController {
	@Autowired
	WorkNetService workNetService;

	// @Inject
	// RestTemplate template;
	@RequestMapping("/worknet.do")
	public String worknet(HttpSession session) throws ServletException,
			IOException {
		String url = "worknet/worknet";

		return url;
	}

	// 서버로 workNetAPI 접근하여 IT관련 직종의 전체 List
	@RequestMapping(value = "/workNetList")
	@ResponseBody
	public Source worknet2(HttpSession session, HttpServletRequest req)
			throws RestClientException, URISyntaxException {

		RestTemplate template = new RestTemplate();
		Map<String, String> paramMap = new HashMap<String, String>();
		// 인증키
		paramMap.put("authKey", "WNIY9NMDKR331VMNQ8IZS2VR1HK");
		// 호출할 페이지 타입 L목록,D 상세
		paramMap.put("callTp", "L");
		// 리턴타입은 반드시 XML
		paramMap.put("returnType", "XML");
		// 기본값 1 최대 1000까지 가능함
		paramMap.put("startPage", req.getParameter("pageNo"));
		// 출력 건수 기본값: 10 , 최대: 100
		paramMap.put("display", "10");
		// 대전 지역 region = 30000
		paramMap.put("region", "30000");
		// 직종 코드 (액셀 파일 참고 -직종코드.xls)
		paramMap.put(
				"occupation",
				"203100|203101|203102|203200|203201|203202|203203|203204|203205|203206|"
						+ "085500|085501|085502|085503|085504|203206|204100|204101|204102|204200|204201|204202|204203"
						+ "|205100|205200|205201|205202|205203");
		// paramMap.put("firstIndex","1");
		// paramMap.put("pageSize","10");
		// paramMap.put("recordCountPerPage","10");

		// api url이며 parameter값들은 {}로 구분하여 맵에 입력한 값들로 대입하여 사용한다.
		ResponseEntity<Source> re = template
				.getForEntity(
						"http://openapi.work.go.kr/opi/opi/opia/wantedApi.do?authKey={authKey}&callTp={callTp}&"
								+ "returnType={returnType}&startPage={startPage}&"
								+ "&display={display}&occupation={occupation}&region={region}",
						// +
						// "firstIndex={firstIndex}&pageSize={pageSize}&recordCountPerPage={recordCountPerPage}"
						// // 추가
						Source.class, paramMap);
		return re.getBody();
	}

	// 게시물 디테일
	@RequestMapping(value = "/workNetDetail")
	@ResponseBody
	public Source worknetDetail(HttpSession session, HttpServletRequest req,@RequestParam String wantedAuthNo)
			throws RestClientException, URISyntaxException {
		RestTemplate template = new RestTemplate();
		Map<String, String> paramMap = new HashMap<String, String>();
		// 인증키
		paramMap.put("authKey", "WNIY9NMDKR331VMNQ8IZS2VR1HK");
		// 호출할 페이지 타입 L목록,D 상세
		paramMap.put("callTp", "D");
		// 리턴타입은 반드시 XML
		paramMap.put("returnType", "XML");
		paramMap.put("wantedAuthNo", wantedAuthNo);
		paramMap.put("infoSvc", "VALIDATION");
		
		// api url이며 parameter값들은 {}로 구분하여 맵에 입력한 값들로 대입하여 사용한다.
		ResponseEntity<Source> re = template
				.getForEntity(
						"http://openapi.work.go.kr/opi/opi/opia/wantedApi.do?authKey={authKey}&callTp={callTp}&returnType={returnType}"+
						"&wantedAuthNo={wantedAutoNO}&infoSvc={infoSvc}",Source.class, paramMap);
/*		ResponseEntity<Source> re = template
				.getForEntity(
						"http://www.work.go.kr/empInfo/empInfoSrch/detail/empDetailAuthView.do?callTp={callTp}&wantedAuthNo{wantedAuthNo}",
						Source.class, paramMap);
*/		
		return re.getBody();
	}

	// 스크랩하기
	@RequestMapping(value = "/addScrap", produces = "application/json")
	@ResponseBody
	public Map<String, Object> ScrapWorkNet(@RequestBody WorkVO[] wanted,
			HttpServletRequest req) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Map<String, Object> jsonBody = null;
		WorkVO workVO = new WorkVO();
		MemVO member = (MemVO) session.getAttribute("loginUser");
		String login = member.getMem_mail();
		workVO.setMem_mail(login);

		if (login == null) {
			System.err.println("로그인후 이용하시길 바랍니다.");
		}
		if (login != null) {
			int sum = 0;
			jsonBody = workNetService.insertScrap(wanted, login);
			if (sum == wanted.length) {
				jsonBody.put("result", true);
			} else {
				jsonBody.put("result", false);
			}
		}
		return jsonBody;

	}

	// 스크랩 리스트 확인하기
	@RequestMapping(value = "/myScrapList")
	public String scrapAllList(HttpSession session, Model model,
			HttpServletRequest req) throws ServletException, IOException {
		String url = "worknet/myScrapList";
		String total = "";
		String key = req.getParameter("key");
		String type = req.getParameter("type");
		String tpage = req.getParameter("tpage");

		if (key == null) {
			key = "";
		}
		if (tpage == null) {
			tpage = "1"; // 현재 페이지 (default 1)
		} else if (tpage.equals("")) {
			tpage = "1";
		}

		testVO testVO = new testVO();
		testVO.setKey(key);
		testVO.setType("wantedAuthNo");
		try {
			total = workNetService.getTotal(testVO) + "";
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		ArrayList<WorkVO> scrapList = null;
		String paging = null;
		try {
			scrapList = workNetService.getScrapList(Integer.parseInt(tpage),
					testVO);
			paging = workNetService.pageNumber(Integer.parseInt(tpage), testVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("scrapList", scrapList);
		model.addAttribute("paging", paging);
		model.addAttribute("searchCnt", total);
		return url;
	}
	@RequestMapping(value="/deleteScrap",produces = "application/json" )
	@ResponseBody
	public String deleteScrap(@RequestBody Map<String, String> wantedAuthNo,HttpServletRequest req) 
			throws ServletException, IOException {
			System.out.println(wantedAuthNo.get("wantedAuthNo"));
			try {
				workNetService.deleteScrap(wantedAuthNo.get("wantedAuthNo"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return wantedAuthNo.get("wantedAuthNo");
		
	}
}
