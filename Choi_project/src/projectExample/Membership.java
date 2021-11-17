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
			// 이것들은 왜 들어가있지?
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
		return "◇ 설정 최소값 : " + this.minPrice + "\n◇ 설정 최대값 : " + this.maxPrice;
	}
	
	
}
