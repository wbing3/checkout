package checkout;

import java.math.BigDecimal;

public class Item {
	
	private int count;
	private String name;
	private BigDecimal amount;
	private BigDecimal salesTax;
	private BigDecimal importTax;
	private BigDecimal totalTax;
	private boolean isSalesTax;
	private boolean isImportTax;

	
	Item (int count, String name, BigDecimal amount, boolean isSalesTax, boolean isImportTax) {
		this.count = count;
		this.name = name;
		this.amount = amount;
		this.isSalesTax = isSalesTax;
		this.isImportTax = isImportTax;
		this.salesTax = new BigDecimal(0);
		this.importTax = new BigDecimal(0);
		this.totalTax =new BigDecimal(0);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public boolean isSalesTax() {
		return isSalesTax;
	}

	public void setIsSalesTax(boolean salesTax) {
		this.isSalesTax = salesTax;
	}

	public boolean isImportTax() {
		return isImportTax;
	}

	public void setIsImportTax(boolean importTax) {
		this.isImportTax = importTax;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getSalesTax() {
		return salesTax;
	}

	public void setSalesTax(BigDecimal salesTax) {
		this.salesTax = salesTax;
	}

	public BigDecimal getImportTax() {
		return importTax;
	}

	public void setImportTax(BigDecimal importTax) {
		this.importTax = importTax;
	}

	public BigDecimal getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(BigDecimal totalTax) {
		this.totalTax = totalTax;
	}

}
