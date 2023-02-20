package com.kh.spring.member.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.spring.member.domain.Member;
import com.kh.spring.member.store.MemberStore;

//No qualifying bean of type 'com.kh.spring.member.store.MemberStore' 이러면 @안한거얌
@Repository
public class MemberStoreLogic implements MemberStore{

	@Override
	public int insertMember(SqlSession session, Member member) {
		int result = session.insert("MemberMapper.insertMember", member);
		return result;
	}

	@Override
	public Member loginMember(SqlSession session, Member mLogin) {
		Member member = session.selectOne("MemberMapper.loginMember", mLogin);
		return member;
	}

	@Override
	public Member selectOneById(SqlSession session, String memberId) {
		Member member = session.selectOne("MemberMapper.selectOneById", memberId);
		return member;
	}

}
