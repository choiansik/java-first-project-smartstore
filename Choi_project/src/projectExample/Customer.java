package projectExample;

import java.text.DecimalFormat;

public class Customer  {
	
	int customerNumber;
	String dob;
	int price;
	String gender;
	String phoneNumber;
	String name;
	String nameMember; // String 으로 변경
	
	
	
	Customer(){}
	
	Customer(String dob, int price, String gender, String phoneNumber,
			String name, int customerNumber,String nameMember ){
		this.dob = dob;
		this.price = price;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.customerNumber = customerNumber;
		this.nameMember = nameMember;
		
	}
	
	
	

	public String getNameMember() {
		return nameMember;
	}

	public void setNameMember(String nameMember) {
		this.nameMember = nameMember;
	}

	public int getcustomerNumber() {
		return customerNumber;
	}
	
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getPay() {
        return price;
	}
	public void setPay(int price) {
		this.price = price;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getphoneNumber() {
		return phoneNumber;
	}
	public void setphoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return String.format("◇ 고객 번호 : %d\n◇ 1. 고객 이름 : %s\n◇ 2. 고객 나이 :"
				+ " %s\n◇ 3. 고객 성별 : %s\n◇ 4. 고객 연락처 : %s\n◇ 5. 구매 금액 : %,d원" +
				"\n◇ 6. 멤버쉽 등급 : ◇ %s 등급\n"
				
				 , this.customerNumber, this.name, this.dob, 
				 this.gender, this.phoneNumber, this.price, this.nameMember
				);
	}
	
}
