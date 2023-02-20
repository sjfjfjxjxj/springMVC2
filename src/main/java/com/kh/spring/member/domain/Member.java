package com.kh.spring.member.domain;

import java.sql.Timestamp;

public class Member {

	// 멤버변수
		// 캡슐화의 원칙, getter/setter
		private String memberId;
		private String memberPw;
		private String memberName;
		private String memberEmail;
		private String memberPhone;
		private String memberAddr;
		private Timestamp enrollDate;
		private Timestamp updateDate;
		private String mStatus;
		
		public Member() {}
		
		public Member(String memberId, String memberPw) {
			this.memberId = memberId;
			this.memberPw = memberPw;
		}
		
		public Member(String memberId, String memberPw, String memberName, String memberEmail, String memberPhone,
				String memberAddr) {
			super(); //부모의 매개변수 없는 생성자를 불러옴. 생략가능.
			this.memberId = memberId;
			this.memberPw = memberPw;
			this.memberName = memberName;
			this.memberEmail = memberEmail;
			this.memberPhone = memberPhone;
			this.memberAddr = memberAddr;
		}

		public String getMemberId() {
			return memberId;
		}

		public void setMemberId(String memberId) {
			this.memberId = memberId;
		}

		public String getMemberPw() {
			return memberPw;
		}

		public void setMemberPw(String memberPw) {
			this.memberPw = memberPw;
		}

		public String getMemberName() {
			return memberName;
		}

		public void setMemberName(String memberName) {
			this.memberName = memberName;
		}

		public String getMemberEmail() {
			return memberEmail;
		}

		public void setMemberEmail(String memberEmail) {
			this.memberEmail = memberEmail;
		}

		public String getMemberPhone() {
			return memberPhone;
		}

		public void setMemberPhone(String memberPhone) {
			this.memberPhone = memberPhone;
		}

		public String getMemberAddr() {
			return memberAddr;
		}

		public void setMemberAddr(String memberAddr) {
			this.memberAddr = memberAddr;
		}

		public Timestamp getEnrollDate() {
			return enrollDate;
		}

		public void setEnrollDate(Timestamp enrollDate) {
			this.enrollDate = enrollDate;
		}

		public Timestamp getUpdateDate() {
			return updateDate;
		}

		public void setUpdateDate(Timestamp updateDate) {
			this.updateDate = updateDate;
		}

		public String getmStatus() {
			return mStatus;
		}

		public void setmStatus(String mStatus) {
			this.mStatus = mStatus;
		}

		@Override
		public String toString() {
			return "Member [memberId=" + memberId + ", memberPw=" + memberPw + ", memberName=" + memberName
					+ ", memberEmail=" + memberEmail + ", memberPhone=" + memberPhone + ", memberAddr=" + memberAddr
					+ ", enrollDate=" + enrollDate + ", updateDate=" + updateDate + ", mStatus=" + mStatus + "]";
		}
		
		
}
