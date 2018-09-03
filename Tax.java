package checkout;

import java.math.BigDecimal;

public class Tax {
	static final int SALES_TAX = 10; // 10%
	static final int IMPORT_TAX = 5; // 5%
	
	static final String[] EXEMPT_ITEMS = {"book","chocolate","pill"};
	static final String IMPORTED_ITEMS = "imported";
	
	static boolean isSalesTax(String name) {
		boolean salesTax = true;
		
		for (String exemptItem: EXEMPT_ITEMS) {
			if ( name.indexOf(exemptItem) > 0 ) {
				salesTax = false;
				break;
			}
		}
		return salesTax;
	}
	
	static boolean isImportTax(String name) {
		return ( name.indexOf(IMPORTED_ITEMS) > 0 ) ? true : false;
	}

	static BigDecimal calculateSalesTax( BigDecimal amount) {
		BigDecimal salesTax;
		if ( amount.doubleValue() > 0) salesTax = new BigDecimal ((SALES_TAX * amount.doubleValue() ) / 100 );
		else salesTax = new BigDecimal(0);
		return salesTax;
	}

	static BigDecimal calculateImportTax( BigDecimal amount) {
		BigDecimal salesTax;
		if ( amount.doubleValue() > 0) salesTax = new BigDecimal ((IMPORT_TAX * amount.doubleValue() ) / 100 );
		else salesTax = new BigDecimal(0);
		return salesTax;
	}

	static BigDecimal roundUpTax( BigDecimal tax) {
		BigDecimal salesTax;
		if ( tax.doubleValue() > 0) salesTax = new BigDecimal( Math.ceil(tax.doubleValue() * 20) / 20);
		else salesTax = new BigDecimal(0);
		return salesTax;
	}

}
