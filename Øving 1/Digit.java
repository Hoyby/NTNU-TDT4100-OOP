package stateandbehavior;

public class Digit {
	
	int base;
	int value;
	
	public Digit(int base) {
		super();
		this.base = base;
		this.value = 0;
	}
	
	public boolean increment() {
		if (value < base - 1) {
			this.value ++;
			return false;
		}else {
			value = 0;
			return true;
		}
	}
	
	public int getValue() {
		return value;
	}
	
	public int getBase() {
		return base;
	}
	
	public String toString() {
		return value > 9 && value < 36 ? String.valueOf((char)(value + 55)) : String.valueOf(value);
	}

	public static void main(String[] args) {
		Digit d1 = new Digit(15);
		System.out.println("Base: " + d1.getBase());
		System.out.println(d1.toString());
		d1.increment();
		System.out.println(d1.toString());
		for (int i = 0 ; i < 11; i++) {
			d1.increment();
			System.out.println(d1.toString());
		}
		System.out.println("--------");
		System.out.println("Current value = " + d1.getValue());
		System.out.println("--------");
		for (int i = 0 ; i < 5; i++) {
			d1.increment();
			System.out.println(d1.toString());
		}
		
		
		
	}

}
