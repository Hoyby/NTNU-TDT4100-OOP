package patterns.delegation.office;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;

public class Manager implements Employee{
	
	private int taskCount;
	private List<Employee> employees = new ArrayList<>();
	private Random rand = new Random();
	
	private Employee selectEmployee() {
		int randInt = rand.nextInt(employees.size()); // Selects random employee
//		if(randInt == 1) {
//			System.out.print("Robin ");
//		}else {
//			System.out.print("Helmer ");
//		}	
		return employees.get(randInt);
	}

	@Override
	public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
		taskCount++;
		return selectEmployee().doCalculations(operation, value1, value2); // Random employee executes the calculation
	}

	@Override
	public void printDocument(String document) {
		selectEmployee().printDocument(document); // Random employee executes the print-job
		taskCount++;
	}

	@Override
	public int getTaskCount() {
		return taskCount;
	}

	@Override
	public int getResourceCount() {
		return employees.size() + 1;
	}
	
	
	public Manager(Collection<Employee> employees) {
		if(employees.isEmpty()) {
			throw new IllegalArgumentException();
		}
		employees.stream().forEach(x -> this.employees.add(x)); // Converts collection to list
	}
	
	public static void main(String[] args) {
		Printer printer = new Printer();
		Clerk Helmer = new Clerk(printer);
		Clerk Robin = new Clerk(printer);
		Collection<Employee> arbeidere = new ArrayList<>();
		arbeidere.add(Helmer);
		arbeidere.add(Robin);
		Manager Victor = new Manager(arbeidere);
		Victor.printDocument("Litt mat");
		Victor.printDocument("Baguette");
		Victor.printDocument("Baguette");
		Victor.printDocument("Baguette");
		System.out.println("");
		System.out.println("regner ut 38 + 20 = " + Victor.doCalculations((a, b) -> a + b, 38, 20));
		System.out.println("regner ut 183 / 6380 = " + Victor.doCalculations((a, b) -> a / b, 183, 6380));
		System.out.println("");
		System.out.println("Robin har printet: " + printer.getPrintHistory(Robin));
		System.out.println("Helmer har printet: " + printer.getPrintHistory(Helmer));
		System.out.println("");
		System.out.println("Victor har gjort: " + Victor.getTaskCount() + " jobber");
		System.out.println("Helmer har gjort: " + Helmer.getTaskCount()+ " jobber");
		System.out.println("Robin har gjort: " + Robin.getTaskCount()+ " jobber");
		
	}
}
