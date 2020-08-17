package ro.ase.cts.assignment3.classes;

import java.util.ArrayList;
import java.util.Iterator;

import ro.ase.cts.assignment3.exceptions.InvalidProductNameCharactersException;
import ro.ase.cts.assignment3.exceptions.InvalidProductNameLengthException;
import ro.ase.cts.assignment3.exceptions.InvalidProductPriceException;
import ro.ase.cts.assignment3.exceptions.InvalidSalesValuesException;
import ro.ase.cts.assignment3.exceptions.NullProductNameReferenceException;
import ro.ase.cts.assignment3.exceptions.NullSalesReferenceExpcetion;
import ro.ase.cts.assignment3.exceptions.SalesVectorOutOfBoundException;

/*
 * 
 * DISCLAIMER
 * Most of the given methods are implemented with bugs
 * Cele mai multe dintre metodele date au bug-uri 
 * 
 * 
 * SPECS
 * 
 * name - between 5 and 200 alpha-numeric chars (no special chars)
 * price - between [0.01, 100000)
 * soldItems - between [0, 1000]
 * 
 * 
 */
public class Product {
	
	private String productName;
	private float productPRice;
	private ArrayList<Integer> weeklySoldItems;		//number of items sold each week
	
	public static final int MIN_SOLD_ITEMS = 0;
	public static final int MAX_SOLD_ITEMS = 1000;
	public static final float MIN_PRICE = 0.01f;
	public static final int MAX_PRICE = 100000;
	public static final int MIN_NAME_LENGTH = 5;
	public static final int MAX_NAME_LENGTH = 200;


	public Product(String name, float price) throws InvalidProductNameLengthException, InvalidProductPriceException, InvalidProductNameCharactersException, NullProductNameReferenceException {
		this.setProductName(name);
		this.setProductPRice(price);
		this.weeklySoldItems = new ArrayList<Integer>();
	}

	public Product(String name, float price, ArrayList<Integer> soldItems) throws InvalidProductPriceException, InvalidProductNameLengthException, InvalidProductNameCharactersException, NullSalesReferenceExpcetion, NullProductNameReferenceException, InvalidSalesValuesException {
		this.setProductName(name);;
		this.setProductPRice(price);;
		this.setSales(soldItems);
	}

	public void setProductPRice(float productPRice) throws InvalidProductPriceException {
		
		if(productPRice < MIN_PRICE || productPRice > MAX_PRICE)
			throw new InvalidProductPriceException("Price between 0.01 & 100000");
		
		this.productPRice = productPRice;
	}

	public void setProductName(String productName)
			throws InvalidProductNameLengthException,InvalidProductNameCharactersException, NullProductNameReferenceException {
		
		if(productName == null)
			throw new NullProductNameReferenceException();
		
		if(productName.length() < MIN_NAME_LENGTH || productName.length() > MAX_NAME_LENGTH)
			throw new InvalidProductNameLengthException("Name len >= 5 && <= 200");
		
	    String str = productName.toLowerCase();
        char[] charArray = str.toCharArray();
	      for (int i = 0; i < charArray.length; i++) {
	         char ch = charArray[i];
	         if (!((ch >= 'a' && ch <= 'z') || ch == ' ')) 
	        	 throw new InvalidProductNameCharactersException("Name must have only letters & space");
	      }
	         this.productName = productName;
	}

	public void setSales(ArrayList<Integer> soldItems) throws NullSalesReferenceExpcetion, InvalidSalesValuesException  {
		if(soldItems == null)
			throw new NullSalesReferenceExpcetion();
		
		for(int sold : soldItems)
			if(sold < MIN_SOLD_ITEMS || sold > MAX_SOLD_ITEMS)
				throw new InvalidSalesValuesException("Week sales must be between 0 & 1000");
			
		this.weeklySoldItems = (ArrayList<Integer>) soldItems.clone();
	}
	
	public String getName() {
		return this.productName;
	}
	
	public float getPrice() {
		return this.productPRice;
	}
	
	public void addWeekSales(int soldItems) throws InvalidSalesValuesException{
		if(soldItems < MIN_SOLD_ITEMS || soldItems > MAX_SOLD_ITEMS)
			throw new InvalidSalesValuesException("Week sales must be between 0 & 1000");
		
		this.weeklySoldItems.add(soldItems);
	}
	public int getNoSales() {
		return this.weeklySoldItems.size();
	}
	
	public int getSoldItems(int i) throws SalesVectorOutOfBoundException{
		if( i < 0 || i >= this.weeklySoldItems.size())
			throw new SalesVectorOutOfBoundException();
		
		return this.weeklySoldItems.get(i);
	}
	
	/*
	 * 
	 * determines the number of weeks with sales above the given limit
	 * determina numarul de saptamani in care au fost vandute un numar de produse peste limita data
	 * 
	 */
	public int getNoWeeksAboveLimit(int minLimit) throws InvalidSalesValuesException{
		if(minLimit < MIN_SOLD_ITEMS || minLimit > MAX_SOLD_ITEMS)
			throw new InvalidSalesValuesException("Week sales must be between 0 & 1000. Verify the limit.");
		int noWeeks = 0;
		
		for(int soldItems : weeklySoldItems)
			if(soldItems > minLimit)
				noWeeks++;
		
		return noWeeks;
	}
	
	/*
	 * 
	 * determines the percentage (%) of weeks with sales under the given limit from total number of weeks
	 * determina procentul saptamanilor (din total saptamani) care au avut vanzari sub limita data
	 * 
	 */
	public float getPercentOfBadWeeks(int minLimit) throws InvalidSalesValuesException{
		if(minLimit < MIN_SOLD_ITEMS || minLimit > MAX_SOLD_ITEMS)
			throw new InvalidSalesValuesException("Week sales must be between 0 & 1000. Verify the limit.");
		
		float noBadWeeks = 0;
		
		for(int soldItems: this.weeklySoldItems)
			if(soldItems < minLimit)
				noBadWeeks += 1;
		
		float percentageBadWeeks = noBadWeeks / this.weeklySoldItems.size();
		
		return   (100 * percentageBadWeeks) / 100.0f ;
	}
	
	/*
	 * 
	 * 
	 * determines the index of the weeks with maximum sales (multiple weeks can have maximum sales)
	 * determina indexul saptamanilor cu vanzari maxime (mai multe saptamani pot avea vanzari la nivel maxim)
	 * 
	 * 
	 */
	
	public ArrayList<Integer> getWeeksIndexWithMaxSales(){
		ArrayList<Integer> maxWeeks = new ArrayList<>();
		int max = this.weeklySoldItems.get(0);
		
		for(int i = 0; i < this.weeklySoldItems.size(); i++)
			if(this.weeklySoldItems.get(i) > max)
				max = this.weeklySoldItems.get(i);
		
		for(int i = 0; i < this.weeklySoldItems.size(); i++)
			if(this.weeklySoldItems.get(i) == max)
				maxWeeks.add(i);
		
		return maxWeeks;
	}
	
	@Override
	public String toString() {
		String output = this.productName + " weekly sales: ";
		for(int soldItems: weeklySoldItems)
			output += soldItems + " ";
		return output;
	}
}
