package service;

import java.util.List;

import member.Member;

public class MemberValidation {

    private Member member = null;
    private boolean memberExist = false;

    public void memberValidation(List<Member> members, String memberId) {
	for (int i = 0; i < members.size(); i++) {
	    if (members.get(i).getMemberId().equalsIgnoreCase(memberId)) {
		setMemberExist(true);
		setMember(members.get(i));
	    }
	}
    }

    public Member getMember() {
	return member;
    }

    public void setMember(Member member) {
	this.member = member;
    }

    public boolean isMemberExist() {
	return memberExist;
    }

    public void setMemberExist(boolean memberExist) {
	this.memberExist = memberExist;
    }

}
