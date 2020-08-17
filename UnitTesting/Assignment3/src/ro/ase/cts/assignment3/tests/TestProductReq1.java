package ro.ase.cts.assignment3.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import ro.ase.cts.assignment3.classes.Product;
import ro.ase.cts.assignment3.exceptions.InvalidProductNameCharactersException;
import ro.ase.cts.assignment3.exceptions.InvalidProductNameLengthException;
import ro.ase.cts.assignment3.exceptions.InvalidProductPriceException;
import ro.ase.cts.assignment3.exceptions.InvalidSalesValuesException;
import ro.ase.cts.assignment3.exceptions.NullProductNameReferenceException;
import ro.ase.cts.assignment3.exceptions.NullSalesReferenceExpcetion;
import ro.ase.cts.assignment3.exceptions.SalesVectorOutOfBoundException;
import ro.ase.cts.assignment3.testCategories.CategoryImportantProductTest;


public class TestProductReq1 {
	//test fixture
	Product productWithoutSales, productWithSales;
	
	public static final String NAME = "Johnny";
	public static final float PRICE = Product.MIN_PRICE;
	public static final ArrayList<Integer> WEEKLY_SALES;
	
	static {
		WEEKLY_SALES = new ArrayList<>();
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		int numberOfGrades = 3;
		for (int i = 0; i< numberOfGrades; i++)
			WEEKLY_SALES.add(Product.MAX_SOLD_ITEMS);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		productWithSales = new Product(NAME,PRICE,WEEKLY_SALES);
		productWithoutSales = new Product(NAME,PRICE);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Ignore
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
//(3p) Requirement 1.Write a TestCast that contains:
//
//	at least 1 Right/Conformance test for each constructor
//
//	at least 2 Error Condition tests for each constructor
//
//	1 Reference test for the constructor that receives the ArrayList
//
//	1 Existence test  for the constructor that receives the ArrayList
//
//	1 Reference test for setSales()
//
//	1 Existence test for setSales()
	
	//Right - constructor without vector
	@Test
	public void testConstructorWithoutVectorRightNameLen()throws InvalidProductNameLengthException, InvalidProductPriceException, InvalidProductNameCharactersException, NullProductNameReferenceException {
		String name = "Doe DOe";
		Product p = new Product(name, PRICE);
		
		String expectedName = name;
		String receivedName = p.getName();
	
		assertEquals(expectedName, receivedName);
	}
	
	//Right - constructor price without vector
	@Category({CategoryImportantProductTest.class})
	@Test
	public void testConstructorWithoutVectorRightPrice() throws InvalidProductPriceException, InvalidProductNameLengthException, InvalidProductNameCharactersException, NullProductNameReferenceException {
		float price = Product.MIN_PRICE;
		Product p = new Product(NAME,price);
		
		float expectedPrice = price;
		float receivedPrice = p.getPrice();
		
		assertEquals(expectedPrice, receivedPrice,0);
	}
	
	//Right - constructor nameChars without vector
	@Test
	public void testConstructorWithoutVectorRightNameCharacters() throws InvalidProductNameLengthException, InvalidProductPriceException, InvalidProductNameCharactersException, NullProductNameReferenceException {
		String name = "John Doe";
		Product p = new Product(name, PRICE);
		
		String expectedName = name;
		String receivedName = p.getName();
		assertEquals(expectedName, receivedName);

	}
	
	//Right - constructor nameLen with vector
	@Test
	public void testConstructorWithVectorRightNameLen() throws InvalidProductNameLengthException, InvalidProductPriceException, InvalidProductNameCharactersException, NullSalesReferenceExpcetion, NullProductNameReferenceException, InvalidSalesValuesException {
		String name = "Doe DOe";
		Product p = new Product(name, PRICE,WEEKLY_SALES);
		
		String expectedName = name;
		String receivedName = p.getName();
	
		assertEquals(expectedName, receivedName);
	}
	
	@Test
	public void testConstructorWithVectorRightPrice() throws InvalidProductNameLengthException, InvalidProductPriceException, InvalidProductNameCharactersException, NullSalesReferenceExpcetion, NullProductNameReferenceException, InvalidSalesValuesException {
		float price = Product.MIN_PRICE;
		Product p = new Product(NAME, price,WEEKLY_SALES);
		
		float expectedPrice = price;
		float receivedPrice = p.getPrice();
		
		assertEquals(expectedPrice, receivedPrice,0);
	}
	@Category({CategoryImportantProductTest.class})
	@Test
	public void testConstructorWithVectorRightWeeklySale() throws InvalidProductPriceException, InvalidProductNameLengthException, InvalidProductNameCharactersException, NullSalesReferenceExpcetion, NullProductNameReferenceException, InvalidSalesValuesException, SalesVectorOutOfBoundException {
		ArrayList<Integer> sales = new ArrayList<>(Arrays.asList(10,20,150));
		Product p = new Product(NAME, PRICE,sales);
		
		ArrayList<Integer> expectedArray = new ArrayList<>();
		for(int i = 0; i < p.getNoSales(); i ++) {
			expectedArray.add(p.getSoldItems(i));
		}
		
//		ArrayList<Integer> expectedArray = sales;

		sales.set(0, 100);
		
		for(int i = 0; i < p.getNoSales(); i ++)
		assertEquals((int)expectedArray.get(i), p.getSoldItems(i));
	
	}
	
	//Right - constructor nameChars with vector
	@Test
	public void testConstructorWithVectorRightNameCharacters() throws InvalidProductNameLengthException, InvalidProductPriceException, InvalidProductNameCharactersException, NullSalesReferenceExpcetion, NullProductNameReferenceException, InvalidSalesValuesException {
		String name = "John Doe";
		Product p = new Product(name, PRICE,WEEKLY_SALES);
		
		String expectedName = name;
		String receivedName = p.getName();
		assertEquals(expectedName, receivedName);

	}

	//ErrorCondition - name without vector
	//if there's no name throw exception => Error Condition Test
	@Category({CategoryImportantProductTest.class})
	@Test(expected = NullProductNameReferenceException.class)
	public void testConstructorWithoutVectorNameRefError() throws InvalidProductNameLengthException, InvalidProductPriceException, InvalidProductNameCharactersException, NullProductNameReferenceException {
		String name = null;		
		Product p = new Product(name, PRICE);
	}
	
	//ErrorCondition - name without vector
		//if there's no name throw exception => Error Condition Test
		@Test(expected = InvalidProductPriceException.class)
		public void testConstructorWithoutVectorInvalidPriceError() throws InvalidProductNameLengthException, InvalidProductPriceException, NullProductNameReferenceException, InvalidProductNameCharactersException  {
			String name = "John Doe";
			float price = -5;
			
			Product p = new Product(name, price);
		}

	//ErrorCondition - name with vector
	//if there's no name throw exception => Error Condition Test
	@Test(expected = NullProductNameReferenceException.class)
	public void testConstructorWithVectorNameError() throws InvalidProductNameLengthException, InvalidProductPriceException, InvalidProductNameCharactersException, NullProductNameReferenceException, NullSalesReferenceExpcetion, InvalidSalesValuesException {
		String name = null;		
		Product p = new Product(name, PRICE,WEEKLY_SALES);	
	}
	
	//ErrorCondition - sales
	@Category({CategoryImportantProductTest.class})
	@Test(expected = InvalidSalesValuesException.class)
	public void testConstructorWithVectorSalesArrayValueError() throws InvalidProductPriceException, InvalidProductNameLengthException, InvalidProductNameCharactersException, NullSalesReferenceExpcetion, NullProductNameReferenceException, InvalidSalesValuesException {
		ArrayList<Integer> sales = new ArrayList<>(Arrays.asList(200,5,-350));
		Product p = new Product(NAME, PRICE, sales);
	}
	
	//Existence - we do not have a collection
	//if there's no collection throw exception => Error Condition Test
	@Test(expected = NullSalesReferenceExpcetion.class)
	public void testConstructorWithVectorExistence() throws InvalidProductNameLengthException, InvalidProductPriceException, InvalidProductNameCharactersException, NullProductNameReferenceException, NullSalesReferenceExpcetion, InvalidSalesValuesException {
		ArrayList<Integer> sales = null;
		Product p = new Product(NAME, PRICE,sales);	
	}
	
	//Reference - check shallow copy vs deep copy
	//changing external array will not affect the Product
	@Category({CategoryImportantProductTest.class})
	@Test
	public void testConstructorWithVectorReference() throws NullSalesReferenceExpcetion, InvalidSalesValuesException, SalesVectorOutOfBoundException   {
		ArrayList<Integer> initialSales = new ArrayList<>(Arrays.asList(800,999,10));
		productWithSales.setSales(initialSales);
		
		ArrayList<Integer> weeklySales = new ArrayList<>();
		for(int i = 0; i < productWithSales.getNoSales(); i ++) {
			weeklySales.add(productWithSales.getSoldItems(i));
		}
		
		//change a value in the external collection
		initialSales.set(0, 50);
		
		for(int i = 0; i < productWithSales.getNoSales(); i++) {
			assertEquals((int)weeklySales.get(i),
					productWithSales.getSoldItems(i));
		}
	
	}
	
	//Reference - setSales
	@Category({CategoryImportantProductTest.class})
	@Test
	public void testSetSalesReference() throws NullSalesReferenceExpcetion, InvalidSalesValuesException, SalesVectorOutOfBoundException {
		ArrayList<Integer> sales = new ArrayList<>(Arrays.asList(10,20,150));
		productWithSales.setSales(sales);
		
		ArrayList<Integer> expectedArray = new ArrayList<>();
		for(int i = 0; i < productWithSales.getNoSales(); i ++) {
			expectedArray.add(productWithSales.getSoldItems(i));
		}
		
//		ArrayList<Integer> expectedArray = sales;

		sales.set(0, 100);
		
		for(int i = 0; i < productWithSales.getNoSales(); i ++)
		assertEquals((int)expectedArray.get(i), productWithSales.getSoldItems(i));
	}
	
	//Existence - setSales
	@Test(expected = NullSalesReferenceExpcetion.class)
	public void testSetSalesExistence() throws  InvalidSalesValuesException, NullSalesReferenceExpcetion {
		ArrayList<Integer> sales = null;
		productWithSales.setSales(sales);
		
	}



}
