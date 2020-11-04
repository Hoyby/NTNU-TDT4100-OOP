package debugging;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StringMergingIterator implements Iterator<String> {

	private Iterator<String> first;
	private Iterator<String> second;
	private boolean turnSwitch;

	public StringMergingIterator(Iterator<String> first, Iterator<String> second){
		this.first = first;
		this.second = second;
		this.turnSwitch = true;
	}

	@Override
	public boolean hasNext() {
		return first.hasNext() || second.hasNext();
	}

	@Override
	public String next() {

		if(! hasNext()){ throw new NoSuchElementException(); }

		String result = null;

		if(! first.hasNext()){
			result = second.next(); // returnerte segselv
		}
		else if(! second.hasNext()){
			result = first.next(); // returnerte segselv
		}
		else {
			if(turnSwitch){ // var not
				result = first.next();
				turnSwitch = false;
			}
			else if(!turnSwitch){ // var if
				result = second.next();
				turnSwitch = true;
			}

		}

		return result;
	}


}
