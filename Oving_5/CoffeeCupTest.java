package objectstructures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CoffeeCupTest {

	CoffeeCup cup;
	CoffeeCup cup2;
	CoffeeCup cup3;
	
	@Before
	public void setUp() throws Exception {
		cup = new CoffeeCup();
	}
	
	@Test
	public void testConstructor() {
		cup2 = new CoffeeCup(100.5, 50.5);
		assertEquals(0, cup.getCapacity(),0);
		assertEquals(0, cup.getCurrentVolume(),0);	
		assertEquals(100.5, cup2.getCapacity(),0);
		assertEquals(50.5, cup2.getCurrentVolume(),0);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorNeg() {
		cup3 = new CoffeeCup(-100.5, 50.5);
		assertEquals(0, cup.getCapacity(),0);
		assertEquals(0, cup.getCurrentVolume(),0);	
		assertEquals(100.5, cup2.getCapacity(),0);
		assertEquals(50.5, cup2.getCurrentVolume(),0);	
	}
	
	
	@Test (expected = IllegalArgumentException.class)
	public void testFillCupWhenNoCap() {
		cup.fillCoffee(50);
		assertEquals(0, cup.getCapacity(),0);
		assertEquals(0, cup.getCurrentVolume(),0);	
	}
	
	@Test
	public void negativeCap() {
		cup.increaseCupSize(-50);
		assertEquals(0, cup.getCapacity(),0);
		assertEquals(0, cup.getCurrentVolume(),0);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void negativeVol() {
		cup.increaseCupSize(50);
		cup.fillCoffee(-25);
		assertEquals(50, cup.getCapacity(),0);
		assertEquals(0, cup.getCurrentVolume(),0);	
	}
	
	@Test
	public void testFillCup() {
		cup.increaseCupSize(100.5);
		cup.fillCoffee(50.5);
		assertEquals(100.5, cup.getCapacity(),0);
		assertEquals(50.5, cup.getCurrentVolume(),0);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testDrinkMoreThanVolume() {
		cup.increaseCupSize(100.5);
		cup.fillCoffee(50.5);
		assertEquals(100.5, cup.getCapacity(),0);
		assertEquals(50.5, cup.getCurrentVolume(),0);	
		cup.drinkCoffee(75);
	}
	
	@Test
	public void testDrink() {
		cup.increaseCupSize(100.5);
		cup.fillCoffee(50.5);
		assertEquals(100.5, cup.getCapacity(),0);
		assertEquals(50.5, cup.getCurrentVolume(),0);	
		cup.drinkCoffee(25.5);
		assertEquals(100.5, cup.getCapacity(),0);
		assertEquals(25, cup.getCurrentVolume(),0);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testNegDrink() {
		cup.increaseCupSize(100.5);
		cup.fillCoffee(50.5);
		assertEquals(100.5, cup.getCapacity(),0);
		assertEquals(50.5, cup.getCurrentVolume(),0);	
		cup.drinkCoffee(-25.5);
	}
}