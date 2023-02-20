package com.kh.spring.member.service.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.member.domain.Member;
import com.kh.spring.member.service.MemberService;
import com.kh.spring.member.store.MemberStore;
@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private SqlSession session;
	@Autowired
	public MemberStore mStore;
	
	@Override
	public int insertMember(Member member) {
		int result = mStore.insertMember(session, member);
		//session.commit();
		//session.close();
		//Manual commit is not allowed over a Spring managed SqlSessionㅋㅋㅋㅋㅋ
		return result;
	}

	@Override
	public Member loginMember(Member mLogin) {
		Member member = mStore.loginMember(session, mLogin);
		return member;
	}

	@Override
	public Member selectOneById(String memberId) {
		Member member = mStore.selectOneById(session, memberId);
		return member;
	}

}
