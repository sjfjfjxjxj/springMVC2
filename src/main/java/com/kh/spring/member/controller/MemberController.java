package com.kh.spring.member.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring.member.domain.Member;
import com.kh.spring.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired //빼먹으면 널포인트익셉션@!!!!
	private MemberService mService;
	
	///member/register.kh로 접속했을때 동작하는 메소드
	@RequestMapping(value="/member/registerView.kh", method=RequestMethod.GET)
	public String registerView(HttpServletRequest request) {
		return "member/register";
	}
	
	//등록버튼 눌렀을때 동작(멤버등록)
	//리퀘스트.겟파라미터 대신!
	//1. @RequestParam("name값") String 변수명
	//2. 매개변수랑 name값 같을때: @RequestParam("name"값) 생략
	//3. @ModelAttribute 사용하기(조건 ⓐvo 멤버변수==폼태그네임값 ⓑ기본생성자 존재 ⓒ세터메소드 있어야)
		//	만약 ⓐ가 충족 못함-> 마이바티스가 빈값을 null로 인식 못해서 오류남
		//	sql에 낫널 제약조건 해놓은거 아니면 사용자는 그냥 비울수도 있기때문에
		//	mybatis-config.xml에서 세팅해야해
	@RequestMapping(value="/member/register.kh", method=RequestMethod.POST)
	public String memberRegister(
			HttpServletRequest request
			, @ModelAttribute Member member
//			, String memberId
//			, String memberPw
//			, String memberName
//			, String memberEmail
//			, String memberPhone
//			//, @RequestParam("memberAddr") String memberAddr 네임값이랑 변수 같으면 @생략!
//			, String memberAddr
			, Model model) {
		try { //리퀘스트스코프같은 모델! 메세지 보낼라면 필요!
			request.setCharacterEncoding("UTF-8");//얜 스프링어노테이션 하면 안먹음ㅠ 깨짐ㅠ 그래서 방법ⓐweb.xml에 필터등록해주기!
//			String memberId = request.getParameter("member-id");
//			String memberPw = request.getParameter("member-pw");
//			String memberName = request.getParameter("member-name");
//			String memberEmail = request.getParameter("member-email");
//			String memberPhone = request.getParameter("member-phone");
//			String memberAddr = request.getParameter("member-addr");
			
//			Member mParam = new Member(memberId, memberPw, memberName, memberEmail, memberPhone, memberAddr);
			//모델어트리뷰트 쓰면 ㅇ엠파람 쓸필요 없이
			int result = mService.insertMember(member);
			
			if(result>0) {
				return "redirect:/index.jsp";
				//리턴 쌍따옴표 하면 뷰리졸버 태우는거라 유알엘 그대로 가게 하려면 리디렉트 써줘야함
			}else {
				model.addAttribute("msg", "회원가입 미완료!");
				return "common/error";
			}
		} catch (Exception e) {
			//model.addAttribute("msg", e.getMessage());
			e.printStackTrace();
			//창에 에러 메세지 뿌리지 말고 콘솔창에 뿌리자
			return "common/error";
		}
	}
	
	
//	@RequestMapping(value="/member/loginView.kh", method=RequestMethod.GET)
//	public String loginView(HttpServletRequest request) {
//		return "member/login";
//	}
	
	//멤버로그인
	@RequestMapping(value="/member/login.kh", method=RequestMethod.POST)
	public String memberLogin(
			HttpServletRequest request
			, @RequestParam("member-id") String memberId
			, @RequestParam("member-pw") String memberPw
			, Model model) {
		
		
		try {
			//String memberId = request.getParameter("member-id");
			//String memberPw = request.getParameter("member-pw");
			//이걸 위에처럼 변수로 넣어서 어노테이션 넣으면 된대! :스프링 어노테이션ㅇㅇ
			Member mLogin = new Member(memberId, memberPw);
			Member member = mService.loginMember(mLogin);
			HttpSession session = request.getSession(); //세션 가져와서
			if(member != null) {
				session.setAttribute("loginUser", member); //세션에 저장하기!
				return "redirect:/index.jsp";
			}else {
				model.addAttribute("msg", "아이디 비번 확인 要");
				return "common/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}
	
	//멤버로그아웃
	@RequestMapping(value="/member/logout.kh", method=RequestMethod.GET)//겟방식이면 메소드 생략 가능!!!
	public String memberLogout(HttpServletRequest request, Model model) {
		//매개변수로 Httpsession session 받아서 바로 invalidate 때려도 됨
		HttpSession session = request.getSession();
		if(session != null) {
			session.invalidate();
			return "redirect:/index.jsp";
		}else {
			model.addAttribute("msg", "로그아웃불가");
			return "common/error";
		}
	}
	
	@RequestMapping(value="/member/mypage.kh", method= {RequestMethod.GET, RequestMethod.POST})
	public String showMypage(HttpSession session, Model model) {
		try {
			//String memberId = (Member)getAttribute("loginUser").getMemberId(); //키값은 로그인할떄 적었던 값.
			Member mOne = (Member)session.getAttribute("loginUser");
			String memberId= mOne.getMemberId(); //이렇게 두줄로 가능
			Member member  = mService.selectOneById(memberId);
			model.addAttribute("member", member);
			
			return "member/mypage";
			
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}
	
	
}
