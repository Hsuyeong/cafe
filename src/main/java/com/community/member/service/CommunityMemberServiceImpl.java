package com.community.member.service;

import com.community.member.dao.CommunityMemberDao;
import com.community.member.vo.CommunityMemberVO;

public class CommunityMemberServiceImpl implements CommunityMemberService {

	// 멤버변수 추가
	private CommunityMemberDao communityMemberDao;
	
	public void setCommunityMemberDao(CommunityMemberDao communityMemberDao) {
		this.communityMemberDao = communityMemberDao;
	}
	
	@Override
	public boolean createCommunityMember(CommunityMemberVO communityMemberVO) {
		
		System.out.println("CommunityMemberServiceImpl까진 왔다");
		
				
		return communityMemberDao.insertCommunityMember(communityMemberVO) > 0;
		
	}

	@Override
	public CommunityMemberVO readCommunityMember(CommunityMemberVO communityMemberVO) {
		
		System.out.println("여기는 여기는 서비스");
		return communityMemberDao.selectCommunityMember(communityMemberVO);
	}

	@Override
	public boolean removeCommunityMember(int id, String deleteFlag) {		
		
		if( deleteFlag.equals("y") ) {
			communityMemberDao.deleteCummunityMember(id);
		}
		
		return communityMemberDao.deleteCummunityMember(id) > 0;
	}
	

	@Override
	public boolean modifyCommunityMember(int id) {
		// TODO Auto-generated method stub
		return false;
	}	
	
	
	
}
