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
import ro.ase.cts.assignment3.exceptions.SalesVectorOutOfBoundException;
import ro.ase.cts.assignment3.testCategories.CategoryImportantProductTest;


//(3p) Requirement 2. Test if  the addWeek(), getSoldItems() and getNoWeeksAboveLimit() methods are correctly implemented for different input data sets.
//	Otherwise, the methods will be corrected. The test case must contain, at the level of each tested method, at least:
//
//
//
//	2 tests of your choice to verify other criteria (other than the above) for any method.
	
public class TestProductReq2 {
	//test fixture
		Product productWithSales;
		
		public static final String NAME = "Johnny";
		public static final float PRICE = Product.MIN_PRICE;
		public static final ArrayList<Integer> WEEKLY_SALES;
		
		
		//performance test
			public static final int nrWeeks = 1000;
			public static final ArrayList<Integer> sales;
			
			static {
				sales = new ArrayList<>(nrWeeks);
				for(int i = 0 ; i < nrWeeks; i ++)
					sales.add(new Random().nextInt(89)+1);
			}		
		
			static {
				WEEKLY_SALES = new ArrayList<>(Arrays.asList(90,550,255));
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
	
	//Right Test - addWeek
	@Category({CategoryImportantProductTest.class})
	@Test
	public void testAddWeekRightValue() throws InvalidSalesValuesException, SalesVectorOutOfBoundException{
		
		int newWeek = 750;
		productWithSales.addWeekSales(newWeek);
		
		int expectedValue = newWeek;
		int receivedValue = productWithSales.getSoldItems(productWithSales.getNoSales() - 1);
		assertEquals(expectedValue, receivedValue,0);
	}
	
	//Right Test - getSoldItems
	@Test
	public void testGetSoldItemsRightValue() throws SalesVectorOutOfBoundException{
		
		int expectedValue = WEEKLY_SALES.get(WEEKLY_SALES.size() / 2);
		int receivedValue = productWithSales.getSoldItems(productWithSales.getNoSales() / 2);
		assertEquals(expectedValue, receivedValue,0);
	}
		
	//Right Test - noWeeksAboveLimit
	@Category({CategoryImportantProductTest.class})
	@Test
	public void testNoWeeksAboveLimitRightValue() throws InvalidSalesValuesException {
				
		
		int min = 200;
		int count = 0;
		
		for(int sale : WEEKLY_SALES) {
			if(sale > min)
				count ++;
		}
		
		int expectedValue = count;
		int receivedValue = productWithSales.getNoWeeksAboveLimit(min);
		assertEquals(expectedValue, receivedValue,0);
	}

	//Range Test - addWeek
	@Test(expected = InvalidSalesValuesException.class)
	public void testAddWeekInvalidRangeValue() throws InvalidSalesValuesException   {
		int newWeek = Product.MIN_SOLD_ITEMS - 250;
		productWithSales.addWeekSales(newWeek);	
	}
	
	//Range test - getSoldItems
	@Test(expected = SalesVectorOutOfBoundException.class)
	public void testGetSoldItemsInvalidRangeValue() throws SalesVectorOutOfBoundException {
		productWithSales.getSoldItems(productWithSales.getNoSales());
	}
	
	//Range test - getNoWeeksAboveLimit
	@Category({CategoryImportantProductTest.class})
	@Test(expected = InvalidSalesValuesException.class)
	public void testGetNoWeeksAboveLimitInvalidRangeValue() throws InvalidSalesValuesException {
		int limit = Product.MAX_SOLD_ITEMS + 50;
		productWithSales.getNoWeeksAboveLimit(limit);
	}
	
	//Cardinality test getNoWeeksAboveLimit
	// 0
	@Category({CategoryImportantProductTest.class})
	@Test
	public void testGetNoWeeksAboveLimitCardinalityZero() throws NullSalesReferenceExpcetion, InvalidSalesValuesException {
		ArrayList<Integer> sales = new ArrayList<>();
		productWithSales.setSales(sales);
		
		int expectedValue = 0;
		int computedValue = productWithSales.getNoWeeksAboveLimit(200);
		
		assertEquals(expectedValue, computedValue,0);
	}
	@Test
	public void testGetNoWeeksAboveLimitCardinalityThree() throws InvalidSalesValuesException {
		int min = 200;
		int count = 0;
		
		for(int sale : WEEKLY_SALES) {
			if(sale > min)
				count ++;
		}
		
		int expectedValue = count;
		int receivedValue = productWithSales.getNoWeeksAboveLimit(min);
		assertEquals(expectedValue, receivedValue,0);
	}
	
	//Ordering test getNoWeeksAboveLimit
	@Category({CategoryImportantProductTest.class})
	@Test
	public void testGetNoWeeksAboveLimitOrderingAsc() throws InvalidSalesValuesException {
		int min = 5;
		int count = 0;
		
		for(int sale : WEEKLY_SALES) {
			if(sale > min)
				count ++;
		}
		
		int expectedValue = count;
		int receivedValue = productWithSales.getNoWeeksAboveLimit(min);
		assertEquals(expectedValue, receivedValue,0);
	}
	//Ordering test getNoWeeksAboveLimit
	@Test
	public void testGetNoWeeksAboveLimitOrderingDesc() throws InvalidSalesValuesException, NullSalesReferenceExpcetion, SalesVectorOutOfBoundException {
		ArrayList<Integer> sales = new ArrayList<>(Arrays.asList(1000,850,250,600));
		productWithSales.setSales(sales);
		
		int min = 250;
		int count = 0;
		
		for(int i = 0 ; i < productWithSales.getNoSales(); i++) {
			if(productWithSales.getSoldItems(i) > min)
				count++;
		}
		
		int expectedValue = count;
		int receivedValue = productWithSales.getNoWeeksAboveLimit(min);
		assertEquals(expectedValue, receivedValue,0);
	}
	
	//Performance test  getNoWeeksAboveLimit
	@Test(timeout = 3000)
	public void testGetNoWeeksAboveLimitPerformanceUnderThreeSec() throws NullSalesReferenceExpcetion, InvalidSalesValuesException {
		
		productWithSales.setSales(sales);
		
		productWithSales.getNoWeeksAboveLimit(20);
	}
	
	//Boundary test  addWeek
	@Test
	public void testAddWeekBoundaryMin() throws InvalidSalesValuesException {
		productWithSales.addWeekSales(Product.MIN_SOLD_ITEMS);
	}
	//Boundary test  addWeek
	@Test
	public void testAddWeekBoundaryMax() throws InvalidSalesValuesException {
		productWithSales.addWeekSales(Product.MAX_SOLD_ITEMS);
	}
	
	//Boundary test  getSoldItem
	@Test
	public void testGetSoldItemsBoundaryMin() throws SalesVectorOutOfBoundException   {
		productWithSales.getSoldItems(0);
	}
	//Boundary test  addWeek
	@Category({CategoryImportantProductTest.class})
	@Test
	public void testGetSoldItemsBoundaryMax() throws SalesVectorOutOfBoundException   {
		productWithSales.getSoldItems(WEEKLY_SALES.size() - 1);
	}
		//Boundary test  addWeek
	@Test
	public void testGetNoWeeksAboveLimitBoundaryMin() throws InvalidSalesValuesException   {
		productWithSales.getNoWeeksAboveLimit(Product.MIN_SOLD_ITEMS);
	}
		//Boundary test  addWeek
	@Category({CategoryImportantProductTest.class})
	@Test
	public void testGetNoWeeksAboveLimitBoundaryMax() throws InvalidSalesValuesException   {
		productWithSales.getNoWeeksAboveLimit(Product.MAX_SOLD_ITEMS);
	}
	
	//CrossCreck getNoWeeksAboveLimit()
	@Category({CategoryImportantProductTest.class})
	@Test
	public void testgetNoWeeksAboveLimitCrossCheck() throws NullSalesReferenceExpcetion, InvalidSalesValuesException, SalesVectorOutOfBoundException {
		ArrayList<Integer> sales = new ArrayList<>(Arrays.asList(1000,850,250,600));
		productWithSales.setSales(sales);
		
		int min = 250;
		int count = 0;
		
		for(int i = 0 ; i < productWithSales.getNoSales(); i++) {
			if(productWithSales.getSoldItems(i) > min)
				count++;
		}
		
		int expectedValue = count;
		int receivedValue = productWithSales.getNoWeeksAboveLimit(min);
		assertEquals(expectedValue, receivedValue,0);
	}
	//InverseRElation GetNoWeeksAboveLimit
	@Test
	public void testGetNoWeeksAboveLimitInverse() throws SalesVectorOutOfBoundException, NullSalesReferenceExpcetion, InvalidSalesValuesException {
		ArrayList<Integer> sales = new ArrayList<>(Arrays.asList(1000,850,250,600,150));
		productWithSales.setSales(sales);
		
		int min = 250;
		int count = 0;
		
		for(int i = 0 ; i < productWithSales.getNoSales(); i++) {
			if(productWithSales.getSoldItems(i) < min || productWithSales.getSoldItems(i) == min )
				count++;
		}
		
		int expectedValue = count;
		int receivedValue = (sales.size() - productWithSales.getNoWeeksAboveLimit(min));
		assertEquals(expectedValue, receivedValue,0);
	}
}	

