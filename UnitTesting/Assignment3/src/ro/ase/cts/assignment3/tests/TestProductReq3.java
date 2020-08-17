package ro.ase.cts.assignment3.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import ro.ase.cts.assignment3.classes.Product;
import ro.ase.cts.assignment3.exceptions.InvalidSalesValuesException;
import ro.ase.cts.assignment3.exceptions.NullSalesReferenceExpcetion;
import ro.ase.cts.assignment3.testCategories.CategoryImportantProductTest;
//(3p) Requirement 3. Write a Test Case to test getPercentOfBadWeeks() and getWeeksIndexWithMaxSales(). For each method, the following unit tests must be implemented:
//
//
//
//
public class TestProductReq3 {
	//test fixture
	Product productWithSales;
	
	public static final String NAME = "Johnny";
	public static final float PRICE = Product.MIN_PRICE;
	public static final ArrayList<Integer> WEEKLY_SALES;
	
	static {
		WEEKLY_SALES = new ArrayList<>(Arrays.asList(90,255,255,500));
	}
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		productWithSales = new Product(NAME,PRICE,WEEKLY_SALES);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Ignore
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	//Right test getWeeksIndexWithMaxSales
	@Test
	public void testGetWeeksIndexWithMaxSalesRight() {		
		ArrayList<Integer> expectedValues = new ArrayList<>(Arrays.asList(3));
		ArrayList<Integer> computedValue = productWithSales.getWeeksIndexWithMaxSales();
		assertEquals(expectedValues, computedValue);
	}
	//Right test getPercentageOfBadWeeks
	@Category({CategoryImportantProductTest.class})
	@Test
	public void testGetPercentageOfBadWeeksRight() throws InvalidSalesValuesException {
		int limit = 300;
		
		float noBadWeeks = 0;
		
		for(int soldItems: WEEKLY_SALES)
			if(soldItems < 300)
				noBadWeeks += 1;
		
		float percentageBadWeeks = noBadWeeks / WEEKLY_SALES.size();
		
		float expectedValue = percentageBadWeeks;
		float computedValue = productWithSales.getPercentOfBadWeeks(limit);
		assertEquals(expectedValue, computedValue,0.01);
	}

	//Range test getWeeksIndexWithMaxSales
	@Category({CategoryImportantProductTest.class})
	@Test(expected = InvalidSalesValuesException.class)
	public void testGetPercentageOfBadWeeksInvalidRangeValue() throws InvalidSalesValuesException {
		int limit = Product.MIN_SOLD_ITEMS - 25;
		productWithSales.getPercentOfBadWeeks(limit);
	}
	//Performance test getWeeksIndexWithMaxSales
	@Category({CategoryImportantProductTest.class})
	@Test(timeout = 30)
	public void testGetWeeksIndexWithMaxSalesPerformance30ms() throws NullSalesReferenceExpcetion, InvalidSalesValuesException {

		ArrayList<Integer> sales = new ArrayList<>(20000);
		
		for(int i = 0 ; i < 20000; i ++)
			sales.add(new Random().nextInt(159)+1);
		
		productWithSales.setSales(sales);
		
		productWithSales.getWeeksIndexWithMaxSales();
	}
	
	//CrossCheck test getPercentageOfBadWeeks
	@Category({CategoryImportantProductTest.class})
	@Test
	public void testGetPercentageOfBadWeeksCrossCheck() throws InvalidSalesValuesException {
		int limit = 300;
		
		float noBadWeeks = 0;
		
		for(int soldItems: WEEKLY_SALES)
			if(soldItems < 300)
				noBadWeeks += 1;
		
		float percentageBadWeeks = noBadWeeks / WEEKLY_SALES.size();
		
		float expectedValue = percentageBadWeeks;
		float computedValue = productWithSales.getPercentOfBadWeeks(limit);
		assertEquals(expectedValue, computedValue,0.01);
	}
	
	//InverseRelation test getPercentageOfBadWeeks
	@Category({CategoryImportantProductTest.class})
	@Test
	public void testGetPercentageOfBadWeeksInverse() throws InvalidSalesValuesException {
		int limit = 300;
		
		float noGoodWeeks = 0;
		
		for(int soldItems: WEEKLY_SALES)
			if(soldItems > 300)
				noGoodWeeks += 1;
		
		float percentageGoodWeeks = noGoodWeeks / WEEKLY_SALES.size();
		
		float expectedValue = percentageGoodWeeks;
		float computedValue = (1- productWithSales.getPercentOfBadWeeks(limit));
		assertEquals(expectedValue, computedValue,0);
	}
	@Category({CategoryImportantProductTest.class})
	//CrossCheck test getWeeksIndexWithMaxSales
	@Test
	public void testGetWeeksIndexWithMaxSalesCrossCheck() throws NullSalesReferenceExpcetion, InvalidSalesValuesException {

		ArrayList<Integer> expectedMaxWeeks = new ArrayList<>();
		int max = WEEKLY_SALES.get(0);
		
		for(int i = 0; i < WEEKLY_SALES.size(); i++)
			if(WEEKLY_SALES.get(i) > max)
				max = WEEKLY_SALES.get(i);
		
		for(int i = 0; i < WEEKLY_SALES.size(); i++)
			if(WEEKLY_SALES.get(i) == max)
				expectedMaxWeeks.add(i);
		
		ArrayList<Integer> computedValue = productWithSales.getWeeksIndexWithMaxSales();
		
		assertEquals(expectedMaxWeeks,computedValue);
	}
}
