package com.community.member.web;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.community.member.contants.Member;
import com.community.member.service.CommunityMemberService;
import com.community.member.vo.CommunityMemberVO;


@Controller
public class CommunityMemberController {
	
	private CommunityMemberService communityMemberService;

	public void setCommunityMemberService(CommunityMemberService communityMemberService) {
		this.communityMemberService = communityMemberService;
	}	
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String viewJoinPage(HttpSession session) {

		if (session.getAttribute(Member.USER) != null) {

			return "redirect:/";
		}

		return "member/join";
	}
	
	@RequestMapping(value ="/join", method = RequestMethod.POST)
	public ModelAndView doJoinAction(CommunityMemberVO communityMemberVO
			, HttpSession session) {
		
		if (session.getAttribute(Member.USER) != null) {
			return new ModelAndView("redirect:/");
		}
		
		System.out.println("여기까진왔따따");
		System.out.println(communityMemberVO.getUserId());
		System.out.println(communityMemberVO.getUserPassword());
		System.out.println(communityMemberVO.getUserNickname());
		System.out.println(communityMemberVO.getPhoneNumber());
		System.out.println(communityMemberVO.getMemberId());
		System.out.println(communityMemberVO.getUserLevel());
		
		
		communityMemberService.createCommunityMember(communityMemberVO);
				
		System.out.println("뿌아아아앙");
		
//		if ( isSuccess ) {
//			return new ModelAndView("redirect:/");
//		}
//		
		return new ModelAndView("redirect:/login");
	
	}
	/*
	 * 카페 멤버 삭제 view page
	 */
	@RequestMapping("/delete/process1")
	public String viewRemoveMemberPage(HttpSession session) {
		return "member/remove/process1";
	}
	
	@RequestMapping("/delete/process2")
	public ModelAndView viewRemoveCheckPage
	(@RequestParam(required = false, defaultValue = "")
	String password, HttpSession session) {
		
		if( password.length()  == 0) {
			return new ModelAndView("error/404");
		}
		
		
		CommunityMemberVO member = (CommunityMemberVO) session.getAttribute(Member.USER);
		member.setUserPassword(password);
		
		CommunityMemberVO verifyMember = communityMemberService.readCommunityMember(member);
		if( verifyMember == null ) {
			return new ModelAndView("redirect:/remove/process1");
		}
		
		//TODO 내가 작성한 게시글의 개수 가져오기
		
		//int myCommunitiesCount = communityMemberService.readMyCommunitiesCount(verifyMember.getId());
		
		ModelAndView view = new ModelAndView();	
		view.setViewName("member/remove/process2");
		//view.addObject("myCommunitiesCount", myCommunitiesCount);
		
		String uuid = UUID.randomUUID().toString();
		session.setAttribute("__TOKEN__", uuid);
		view.addObject("token", uuid);
		return view;
	}

	@RequestMapping(value = "/remove/process2", method = RequestMethod.GET)
	public String RemoveMemberPage(HttpSession session) {

		if (session.getAttribute(Member.USER) != null) {

			return "redirect:/";
		}

		return "member/remove/delete";		
	}	
	
	@RequestMapping(value = "/removemember/{deleteFlag}")
	public String removeMember(@PathVariable String deleteFlag, 
									@RequestParam(required=false, defaultValue="") String token, HttpSession session) {
		
		String sessionToken = (String) session.getAttribute("__TOKEN__");
		if( sessionToken == null || !sessionToken.equals(token) ) {
			return "errpr/404";
					
		}
		
		
		CommunityMemberVO member = (CommunityMemberVO) session.getAttribute(Member.USER);	
		if( member == null ) {
			return "redirect:/login";
		}
		
		int id = member.getMemberId();
		
		if( communityMemberService.removeCommunityMember(id, deleteFlag) ) {
			session.invalidate();
		}

		return "member/remove/delete";
	}
	
}
