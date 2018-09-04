package checkout;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import checkout.Item;

public class SalesTax {
	static ArrayList<Item> loadItems(String fileName) {
		ArrayList<Item> items = new ArrayList<Item>();
		BufferedReader br;
		String line;

		try {
			br = new BufferedReader(new FileReader(fileName));
			line = br.readLine();
			while( line != null  ) {
				int count = Integer.parseInt( line.split(" ")[0] );
				String name = line.split(" at")[0];
				BigDecimal amount = BigDecimal.valueOf( Double.parseDouble((line.split(" at ")[1])) );
				boolean isSalesTax = Tax.isSalesTax( name );
				boolean isImportTax = Tax.isImportTax( name );
				
				Item item = new Item(count, name, amount, isSalesTax, isImportTax);
				items.add(item);
				
				line = br.readLine();
			}
			br.close();
		}
		catch ( IOException exception) {
			System.out.println("loadITems(): Exception occurred: " + exception.getMessage());
		} finally {
			
		}
		return items;
	}
	
	static void calculateTaxes( ArrayList<Item> items){
		for ( Item item: items ) {
			if ( item.isSalesTax() ) item.setSalesTax( Tax.calculateSalesTax( item.getAmount() ) );
			if ( item.isImportTax() ) item.setImportTax( Tax.calculateImportTax( item.getAmount() ) );
			if (item.isSalesTax() || item.isImportTax() ) {
				item.setTotalTax(Tax.roundUpTax(new BigDecimal(item.getSalesTax().doubleValue() + item.getImportTax().doubleValue())));
			}
		}
	}
	
	static void printReceipt( ArrayList<Item> items) {
		System.out.println("*** RECEIPT ***");
		Double totalTaxes = 0d;
		Double totalSales = 0d;
		for ( Item item: items ) {
			Double totalAmount = (item.getAmount().doubleValue() + item.getTotalTax().doubleValue() ) * item.getCount();		
			totalTaxes = (totalTaxes + item.getTotalTax().doubleValue()) * item.getCount();
			totalSales = totalSales + totalAmount;
			
			System.out.println(item.getName() + ": " + String.format("%.02f",totalAmount) );
		}
		System.out.println("Sales Taxes: " + String.format("%.02f",totalTaxes) );
		System.out.println("Total: " + String.format("%.02f",totalSales) );
		System.out.println("===============");
	}
		
	public static void main(String[] args) {
		//testPercents();
		try {
			if ( args.length > 0 ) {
				// get the shopping cart file name
				String fileName = args[0];	
	
				ArrayList<Item> items = loadItems( fileName);
				if ( items.size() > 0 ) {
					calculateTaxes(items);
					printReceipt(items);
				}
				
			} else {
				// write usage message
				System.out.println("SalesTax: usage ");
				System.out.println("java SalesTax item_file_name");
				System.out.println("\titem_file_name - required file containing purchased items.");
			}
		}
		catch (Exception exception) {
			System.out.println("main(): Exception occured: " + exception.getMessage());
		}
		System.exit(0);
	}

}
