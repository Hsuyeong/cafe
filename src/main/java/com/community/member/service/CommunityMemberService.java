package com.community.member.service;

import com.community.member.vo.CommunityMemberVO;

public interface CommunityMemberService {

	public boolean createCommunityMember(CommunityMemberVO communityMemberVO);
	
	public CommunityMemberVO readCommunityMember(CommunityMemberVO communityMemberVO);
	
	public boolean removeCommunityMember(int id, String deleteFlag);
	
	public boolean modifyCommunityMember(int id);
	
}
