package member;

public class Member {
    private String memberId;
    private String memberName;
    private String adress;

    public Member() {
    }

    public Member(String memberId, String memberName, String adress) {
	this.memberId = memberId;
	this.memberName = memberName;
	this.adress = adress;
    }

    public String getMemberId() {
	return memberId;
    }

    public void setMemberId(String memberId) {
	this.memberId = memberId;
    }

    public String getMemberName() {
	return memberName;
    }

    public void setMemberName(String memberName) {
	this.memberName = memberName;
    }

    public String getAdress() {
	return adress;
    }

    public void setAdress(String adress) {
	this.adress = adress;
    }

}
