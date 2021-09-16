package objectstructures;

public class Partner {
	
	private String name;
	private Partner partner;

	public Partner(String name) {
		this.name = name;
		
	}
	
	public String getName() {
		return name;
	}
	
	public Partner getPartner() {
		return partner;
	}
	
	public void setPartner(Partner partner) {
		if (this.partner == partner) {								// If my new partner is already my partner, do nothing.
			return;
		}
		Partner oldPartner = this.partner;
		this.partner = partner;										// My partner is my new partner.
		if (oldPartner != null && oldPartner.partner == this) {		// If my old partner was not null, and his partner was me, remove partner.
			oldPartner.setPartner(null);;
		}if (this.partner != null) {								// If my new partner is not null, his partner is me.
			this.partner.setPartner(this);
		}
		
	}
	
	@Override
	public String toString() {
		return getName();
	}	
	
	public static void main(String[] args) {
		Partner p1 = new Partner("Alex");
		Partner p2 = new Partner("Sunny");
		Partner p3 = new Partner("Nina");
		
		p1.setPartner(p2);
		
		System.out.println("Mitt navn er " + p1 + ", min partner er " + p1.getPartner());
		
		p1.setPartner(p3);
		
		System.out.println("Mitt navn er " + p1 + ", min partner er " + p1.getPartner());
		
		p2.setPartner(p3);
		
		System.out.println("Mitt navn er " + p2 + ", min partner er " + p2.getPartner());
		System.out.println("Mitt navn er " + p1 + ", min partner er " + p1.getPartner());
	}
}
