package com.community.cafe.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.community.member.contants.Member;

@Controller
public class CommunityCafeController {

	@RequestMapping(value = "/")
	public ModelAndView viewMainPage(HttpSession session) {

		ModelAndView view = new ModelAndView();
		
		view.setViewName("community/main");
		return view;
		
	}
	
}
