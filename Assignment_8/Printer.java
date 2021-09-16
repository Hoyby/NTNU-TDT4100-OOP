package patterns.delegation.office;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Printer {
	
	private Map<Employee, Collection<String>> printHistory = new HashMap<>();
	
	
	public Printer() {
	}
	
	void printDocument(String document, Employee employee) {
		Collection<String> documents = new ArrayList<String>();
		
		if(document.isEmpty()) {
			throw new IllegalArgumentException("Document is empty");
		}else if(printHistory.containsKey(employee)) {
			documents = printHistory.get(employee); // if employee exists, add the employees history to the list
		}
		
		
		documents.add(document); // Adds the new document to the history
		printHistory.put(employee, documents); // Add the new history to employee
	}
	
	
	Collection<String> getPrintHistory(Employee employee){
		if(printHistory.containsKey(employee)) {
			return printHistory.get(employee);	// If print-history exists for given employee, return the history
		}else {
			return Collections.emptyList();
		}
	}
	
}
