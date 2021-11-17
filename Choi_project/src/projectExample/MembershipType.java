package projectExample;

public class MembershipType { // 이건 왜 만든거지..?
	
	// MembershipType type;
	// type.bronze.minPrice
	
	Membership bronze; // max, min
	Membership silver; // max, min
	Membership gold; // max, min
	Membership guest; // max, min
	
	MembershipType(){}
	
	MembershipType(Membership Guest, Membership bronze, 
				   Membership Silver, Membership gold){
		this.guest = guest;
		this.bronze = bronze;
		this.silver = silver;
		this.gold = gold;
	}

	public Membership getBronze(int maxPrice, int minPrice) {
		return bronze;
	}

	public void setBronze(Membership bronze) {
		this.bronze = bronze;
	}

	public Membership getSilver(int maxPrice, int minPrice) {
		return silver;
	}

	public void setSilver(Membership silver) {
		this.silver = silver;
	}

	public Membership getGold(int maxPrice, int minPrice) {
		return gold;
	}

	public void setGold(Membership gold) {
		this.gold = gold;
	}

	public Membership getGuest(int maxPrice, int minPrice) {
		return guest;
	}

	public void setGuest(Membership guest) {
		this.guest = guest;
	}
	
	
	
	
}
