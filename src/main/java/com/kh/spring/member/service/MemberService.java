package com.kh.spring.member.service;

import com.kh.spring.member.domain.Member;

public interface MemberService {

	/**
	 * 멤버등록 service
	 * @param member
	 * @return int
	 */
	public int insertMember(Member member);

	/**
	 * 멤버 로그인 service
	 * @param mLogin
	 * @return Member
	 */
	public Member loginMember(Member mLogin);

	/**
	 * 아이디로 멤버 상세조회
	 * @param memberId
	 * @return
	 */
	public Member selectOneById(String memberId);

}
