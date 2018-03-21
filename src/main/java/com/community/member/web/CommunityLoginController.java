package com.community.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.community.member.contants.Member;
import com.community.member.service.CommunityMemberService;
import com.community.member.vo.CommunityMemberVO;

@Controller
public class CommunityLoginController {

	private CommunityMemberService communityMemberService;
	
	public void setCommunityMemberService(CommunityMemberService communityMemberService) {
		this.communityMemberService = communityMemberService;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String viewLoginPage(HttpSession session) {

		if (session.getAttribute(Member.USER) != null) {

			return "redirect:/";
		}
		return "member/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLoginAction(CommunityMemberVO communityMemberVO, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		System.out.println(communityMemberVO.getUserId());
		System.out.println(communityMemberVO.getUserPassword());
		
		CommunityMemberVO loginMember = communityMemberService.readCommunityMember(communityMemberVO);
	
		System.out.println("여기는 로그인컨트롤러");
		
		if ( loginMember != null ) {
			session.setAttribute(Member.USER, loginMember);
			return "redirect:/";
		}

		return "redirect:/login";	
		
		
		

	}
}
