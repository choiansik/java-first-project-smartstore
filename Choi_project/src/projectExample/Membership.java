package projectExample;


// Membership guest
// Membership bronze
// Membership silver
// Membership gold
	public class Membership {
	
	int maxPrice;
	int minPrice;
	
	
	Membership(){}

	Membership( int maxPrice, int minPrice, 
			MembershipType guest, MembershipType bronze,
			MembershipType silver, MembershipType gold){
			// �̰͵��� �� ������?
		this.maxPrice = maxPrice;
		this.minPrice = minPrice;	
		
	}


	public int getMaxPrice(int price) {
		return maxPrice;
	}


	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}


	public int getMinPrice(int price) {
		return minPrice;
	}


	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}

	public String toString() {
		return "�� ���� �ּҰ� : " + this.minPrice + "\n�� ���� �ִ밪 : " + this.maxPrice;
	}
	
	
}
