package stateandbehavior;
  
public class UpOrDownCounter {
 
    int counter;
    int end;
 
    public UpOrDownCounter(int start, int end) throws IllegalArgumentException{
    	if (start == end) {
    		throw new IllegalArgumentException("Start value and end value cannot be the same");
    	}else {
    		this.counter = start;
            this.end = end;
    	}   
    }
 
    public String toString() {
        return String.valueOf(counter);
    }
 
    public int getCounter() {
        return counter;
    }
 
    public boolean count() {
        if (counter < end) {
            counter ++;
        }else if (counter > end){
        	counter --;
        }
        if (counter == end) {
        	return false;
        }else {
        	return true;
        }
    }
    
    public static void main(String[] args) {
		UpOrDownCounter ud1 = new UpOrDownCounter(20, 20);
		System.out.println(ud1.toString());
		while (ud1.count()) { 
			System.out.println(ud1.toString());
		}
	}
 }