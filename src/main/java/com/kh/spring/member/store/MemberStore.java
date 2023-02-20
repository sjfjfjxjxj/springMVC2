package com.kh.spring.member.store;

import org.apache.ibatis.session.SqlSession;

import com.kh.spring.member.domain.Member;

public interface MemberStore {

	/**
	 * 멤버등록 Store
	 * @param session
	 * @param member
	 * @return int
	 */
	public int insertMember(SqlSession session, Member member);

	/**
	 * 멤버로그인 Store
	 * @param session
	 * @param mLogin
	 * @return Member
	 */
	public Member loginMember(SqlSession session, Member mLogin);

	/**
	 * 아이디로 멤버 상세조회
	 * @param session
	 * @param memberId
	 * @return Member
	 */
	public Member selectOneById(SqlSession session, String memberId);
	
}
