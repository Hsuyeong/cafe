package com.community.member.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.community.member.vo.CommunityMemberVO;

public class CommunityMemberDaoImplForOracle extends SqlSessionDaoSupport implements CommunityMemberDao {

	@Override
	public int insertCommunityMember(CommunityMemberVO communityMemberVO) {
		
		return getSqlSession().insert("CommunityMemberDao.insertCommunityMember", 
										communityMemberVO);

	}

	@Override
	public CommunityMemberVO selectCommunityMember(CommunityMemberVO communityMemberVO) {
		System.out.println("여기는 다오다오");
		return getSqlSession().selectOne("CommunityMemberDao.selectCommunityMember", communityMemberVO);
	}

	@Override
	public int updateCummunityMember(int id) {
		return getSqlSession().update("CommunityMemberDao.updateCummunityMember", id);
	}

	@Override
	public int deleteCummunityMember(int id) {
		return getSqlSession().update("CommunityMemberDao.deleteCummunityMember", id);
	}	
	
	
	
}
