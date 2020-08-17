package ro.ase.cts.assignment4.StubsTest;

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
import ro.ase.cts.assignment4.external.BankingInterface;
import ro.ase.cts.assignment4.external.PaymentsException;

public class TestCasePayOnline {
	String iban = "121ABC";
	String owner = "Floroiu Maximilian Stefan";
	double balance = 250;
	Account account;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
//		paymentService = new StubBankingInterface();
		account = new Account();

	}

	@After
	public void tearDown() throws Exception {
	}
//	3p. Define a Stub class for the BankingInterface that will allow testing of the 2 methods (the Stub class must allow the control of the result returned by the stub / fake methods). 
//	Solutions based on anonymous classes are not accepted
//	3p. Implement different unit tests to ensure a code coverage of 100% for the 2 tested methods
//	2.5p. The tests must implement at least 4 different conditions from Right-BICEP and CORRECT and each test must meet Single Responsibility (one reason for failure).
//	1.5p. The tests for setIban () and payOnline() are separated into 2 different Test Cases.
//	At your choice, mark some of them as "Important" and make a suite that executes only these important tests from the 2 TestCases (the solutions in which all unit tests from one or both Test Cases are included are NOT considered).


	// Error Condition Test Using stubs
	@Category({CategoryImportantTests.class})
	@Test(expected = NoAvailableFundsException.class)
	public void testStubPayOnlineInsufficientFundsErrort() throws NoAvailableFundsException, NoServiceException, InvalidIBANException, AccountException, PaymentsException {
		
		StubBankingInterface paymentService = new StubBankingInterface();
		account.setBankService(paymentService);
		paymentService.setReturnisValidIBAN(true);
		paymentService.setReturnpayOnline(1);
		account.setBalance(balance);
		
		String destinationIban = "121ABB";
		double amount = balance*2;
		
		account.payOnline(destinationIban, amount);
	}
	
	//Boundary Test using stubs
	@Test
	public void testStubPayOnlineBoundaryMax() throws NoAvailableFundsException, NoServiceException, InvalidIBANException, AccountException, PaymentsException {
		
		StubBankingInterface paymentService = new StubBankingInterface();
		account.setBankService(paymentService);
		paymentService.setReturnisValidIBAN(true);
		paymentService.setReturnpayOnline(1);
		account.setBalance(balance);
		
		String destinationIBAN = "121ABB";
		double amount = balance;
		
		account.payOnline(destinationIBAN, amount);
	}	
	//Boundary Minim
	@Category({CategoryImportantTests.class})
	@Test(expected = AccountException.class)
	public void testStubPayOnlineBoundaryMin() throws NoAvailableFundsException, NoServiceException, InvalidIBANException, AccountException, PaymentsException {
		
		StubBankingInterface paymentService = new StubBankingInterface();
		account.setBankService(paymentService);
		paymentService.setReturnisValidIBAN(true);
		paymentService.setReturnpayOnline(-1);
		account.setBalance(balance);
		
		String destinationIBAN = "112BCA";
		double amount = 0;
		
		account.payOnline(destinationIBAN, amount);
	}
	
	//Performance test using stubs under 1ms
	@Test(timeout = 1)
	public void testStubPayOnlinePerformance() throws NoAvailableFundsException, NoServiceException, InvalidIBANException, AccountException, PaymentsException {
		
		StubBankingInterface paymentService = new StubBankingInterface();
		account.setBankService(paymentService);
		paymentService.setReturnisValidIBAN(true);
		paymentService.setReturnpayOnline(1);
		account.setBalance(balance);
		
		String destinationIBAN = "121ABB";
		double amount = balance;
		
		account.payOnline(destinationIBAN, amount);
	}
	
	//Refference test using stubs
	@Category({CategoryImportantTests.class})
	@Test(expected = InvalidIBANException.class)
	public void testStubPayOnlineNullRefDestinationIBAN() throws NoAvailableFundsException, NoServiceException, InvalidIBANException, AccountException, PaymentsException {
		
		StubBankingInterface paymentService = new StubBankingInterface();
		account.setBankService(paymentService);
		paymentService.setReturnisValidIBAN(false);
		paymentService.setReturnpayOnline(-1);
		account.setBalance(balance);
		
		String destinationIBAN = null;
		double amount = balance;
		
		account.payOnline(destinationIBAN, amount);
	}
	
	//Null reference test using stubs
	@Category({CategoryImportantTests.class})
	@Test(expected = NoServiceException.class)
	public void testStubPayOnlineNullRefService() throws NoAvailableFundsException, NoServiceException, InvalidIBANException, AccountException {
	
		account.setBalance(balance);
		
		String destinationIBAN = "112BCA";
		double amount = 0;
		
		account.payOnline(destinationIBAN, amount);
	}
	
	//Existence test using stubs
	@Test(expected = NoServiceException.class)
	public void testStubPayOnlineUnprocessedTransaction() throws NoAvailableFundsException, NoServiceException, InvalidIBANException, AccountException, PaymentsException {
		
		StubBankingInterface paymentService = new StubBankingInterface();
		account.setBankService(paymentService);
		paymentService.setReturnisValidIBAN(true);
		paymentService.setReturnpayOnline(0);
		account.setBalance(balance);
		
		String destinationIBAN = "112BCA";
		double amount = balance - balance/2;
		
		account.payOnline(destinationIBAN, amount);
	}
	
	//Range test using stubs
	@Test
	public void testStubPayOnlineRange() throws NoAvailableFundsException, NoServiceException, InvalidIBANException, AccountException, PaymentsException {
		
		StubBankingInterface paymentService = new StubBankingInterface();
		account.setBankService(paymentService);
		paymentService.setReturnisValidIBAN(true);
		paymentService.setReturnpayOnline(1);
		account.setBalance(balance);
		
		String destinationIBAN = "112BCA";
		double amount = balance - balance/2;
		
		account.payOnline(destinationIBAN, amount);
	}
	
	@Category({CategoryImportantTests.class})
	@Test(expected = UnsupportedOperationException.class)
	public void testStubPayOnlineDefaultSwitchBranch() throws NoAvailableFundsException, NoServiceException, InvalidIBANException, AccountException, PaymentsException {
		
		StubBankingInterface paymentService = new StubBankingInterface();
		account.setBankService(paymentService);
		paymentService.setReturnisValidIBAN(true);
		paymentService.setReturnpayOnline(3);
		account.setBalance(balance);
		
		String destinationIBAN = "112BCA";
		double amount = balance - balance/2;
		
		account.payOnline(destinationIBAN, amount);
	}
	
	@Test
	(expected = AccountException.class)
	public void testStubPayOnlineWronIban() throws NoAvailableFundsException, NoServiceException, InvalidIBANException, AccountException, PaymentsException {
		
		StubBankingInterface paymentService = new StubBankingInterface();
		account.setBankService(paymentService);
		paymentService.setReturnisValidIBAN(true);
		paymentService.setReturnpayOnline(0);
		paymentService.setGeneratePaymentsException(true);
		account.setBalance(balance);
		
		String destinationIBAN = "112BCA";
		double amount = balance - balance/2;
		
		account.payOnline(destinationIBAN, amount);
	}
}
