package com.community.member.dao;

import com.community.member.vo.CommunityMemberVO;

public interface CommunityMemberDao {

	public int insertCommunityMember(CommunityMemberVO communityMemberVO);
	
	public CommunityMemberVO selectCommunityMember(CommunityMemberVO communityMemberVO);
	
	public int updateCummunityMember(int id);
	
	public int deleteCummunityMember(int id);
	
}
