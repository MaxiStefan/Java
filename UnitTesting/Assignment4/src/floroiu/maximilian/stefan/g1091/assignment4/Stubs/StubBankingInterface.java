package floroiu.maximilian.stefan.g1091.assignment4.Stubs;

import ro.ase.cts.assignment4.external.BankingInterface;
import ro.ase.cts.assignment4.external.PaymentsException;

public class StubBankingInterface implements BankingInterface {

	boolean returnisValidIBAN;
	int returnpayOnline;
	boolean generatePaymentsException = false;
	
	
	
	public void setGeneratePaymentsException(boolean generatePaymentsException) {
		this.generatePaymentsException = generatePaymentsException;
	}

	public void setReturnisValidIBAN(boolean returnisValidIBAN) {
		this.returnisValidIBAN = returnisValidIBAN;
	}

	public void setReturnpayOnline(int returnpayOnline)   {
		this.returnpayOnline = returnpayOnline;
	}

	@Override
	public boolean isValidIBAN(String iban) {
		// TODO Auto-generated method stub
		return returnisValidIBAN;
	}

	@Override
	public int payOnline(String sourceIBAN, String destinationIBAN) throws PaymentsException {
		// TODO Auto-generated method stub
		if(generatePaymentsException)
			throw new PaymentsException();
		
		return returnpayOnline;
	}

}
