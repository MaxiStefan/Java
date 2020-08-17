package ro.ase.cts.assignment3.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.plaf.synth.SynthSeparatorUI;

import ro.ase.cts.assignment3.exceptions.InvalidProductNameCharactersException;
import ro.ase.cts.assignment3.exceptions.InvalidProductNameLengthException;
import ro.ase.cts.assignment3.exceptions.InvalidProductPriceException;
import ro.ase.cts.assignment3.exceptions.InvalidSalesValuesException;
import ro.ase.cts.assignment3.exceptions.NullProductNameReferenceException;
import ro.ase.cts.assignment3.exceptions.NullSalesReferenceExpcetion;
import ro.ase.cts.assignment3.exceptions.SalesVectorOutOfBoundException;

public class Main {

	public static void main(String[] args)
			throws InvalidProductPriceException, InvalidProductNameLengthException, InvalidProductNameCharactersException, NullSalesReferenceExpcetion, NullProductNameReferenceException, InvalidSalesValuesException, SalesVectorOutOfBoundException {

//		addWeek(), getSoldItems() and getNoWeeksAboveLimit()
		
		String name = "John Doe";
		float price = 25;
		ArrayList<Integer> sales = new ArrayList<>(Arrays.asList(5,2,5,600));
		Product p = new Product(name,price,sales);
//		System.out.println(p.toString());
//		p.addWeekSales(115);
//		System.out.println(p.toString());
////		System.out.println(p.getSoldItems(3));
////		System.out.println(p.getNoWeeksAboveLimit(250));
//		
//		ArrayList<Integer> sales1 = new ArrayList<>(Arrays.asList(1000,850,250,600));
//		p.setSales(sales1);
//		
//		int count = 0;
//		int min = 250 ;
//		
//		for(int i = 0 ; i < p.getNoSales(); i++) {
//			if(p.getSoldItems(i) > min)
//				count++;
//		}
//		System.out.println(count);
		
	ArrayList<Integer> sales2 = new ArrayList<>(1000);
		
	    
		for(int i = 0 ; i < 1000; i ++)
			sales2.add(new Random().nextInt(89) + 1);
		
		p.setSales(sales2);
		System.out.println(sales2.size());
		System.out.println(p.toString());
		System.out.println(p.getWeeksIndexWithMaxSales());
	}

}
