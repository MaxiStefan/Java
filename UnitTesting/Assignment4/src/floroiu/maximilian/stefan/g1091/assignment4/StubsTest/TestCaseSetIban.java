package floroiu.maximilian.stefan.g1091.assignment4.StubsTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import ro.ase.cts.assignment4.Account;
import ro.ase.cts.assignment4.CategoryImportantTests;
import ro.ase.cts.assignment4.Stubs.StubBankingInterface;
import ro.ase.cts.assignment4.exceptions.AccountException;
import ro.ase.cts.assignment4.exceptions.InvalidIBANException;
import ro.ase.cts.assignment4.exceptions.NoAvailableFundsException;
import ro.ase.cts.assignment4.exceptions.NoServiceException;
import ro.ase.cts.assignment4.external.PaymentsException;

public class TestCaseSetIban {
	Account account;
	String iban = "121ABC";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		account = new Account();
	}

	@After
	public void tearDown() throws Exception {
	}

	//Right
	@Category({CategoryImportantTests.class})
	@Test
	public void testSetIbanRightStub() throws InvalidIBANException, NoServiceException {
		
		StubBankingInterface paymentService = new StubBankingInterface();
		account.setBankService(paymentService);
		paymentService.setReturnisValidIBAN(true);
		account.setIban(iban);
		
		String computedIban = account.getIban();
		assertEquals(iban, computedIban);
	}
	
	//Refference test using stubs
	@Test(expected = NoServiceException.class)
	public void testStubSetIbanNullService() throws NoServiceException, InvalidIBANException{
		
		account.setIban(iban);	
	}
	
	//Conformance test using stubs
	@Category({CategoryImportantTests.class})
	@Test(expected = InvalidIBANException.class)
	public void testStubSetIbanNullIban() throws NoServiceException, InvalidIBANException  {
		
		String testIBAN = "_121ABC+?}{";
		StubBankingInterface paymentService = new StubBankingInterface();
		account.setBankService(paymentService);
		paymentService.setReturnisValidIBAN(false);
		account.setIban(testIBAN);		
	}
	
	//Existence 
	@Test(expected = InvalidIBANException.class)
	public void testStubSetIBANExistence() throws InvalidIBANException, NoServiceException {
		
		String testIBAN = "";
		StubBankingInterface paymentService = new StubBankingInterface();
		account.setBankService(paymentService);
		paymentService.setReturnisValidIBAN(false);
		
		account.setIban(testIBAN);
	}
	
	//Performance
	@Category({CategoryImportantTests.class})
	@Test(timeout = 1)
	public void testStubSetIBANPerformance() throws InvalidIBANException, NoServiceException {
		
		String testIBAN = "RO123ABC";
		StubBankingInterface paymentService = new StubBankingInterface();
		account.setBankService(paymentService);
		paymentService.setReturnisValidIBAN(true);
		
		account.setIban(testIBAN);
	}
	
	

}
