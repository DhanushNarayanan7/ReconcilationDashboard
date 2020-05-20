package com.model;

public class PremiumDetail {

	@Override
	public String toString() {
		return "PremiumDetail [memberId=" + memberId + ", memberName=" + memberName + ", memberLastName="
				+ memberLastName + ", contactNumber=" + contactNumber + ", salary=" + salary + "]";
	}

	private String memberId;
	private String memberName;
	private String memberLastName;
	private long contactNumber;
	private long salary;

	public String getMemberLastName() {
		return memberLastName;
	}

	public void setMemberLastName(String memberLastName) {
		this.memberLastName = memberLastName;
	}

	

	// GETTER SETTER FOR ID NAME CONT NUM

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

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public PremiumDetail(String memberId, String memberName, String memberLastName, long contactNumber, long salary) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberLastName=memberLastName;
		this.contactNumber = contactNumber;
		this.salary = salary;
	}

	public PremiumDetail() {

	}

}
