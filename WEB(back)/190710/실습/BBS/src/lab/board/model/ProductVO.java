package lab.board.model;

public class ProductVO {
	String productid;
	String pname;
	Integer unitPrice;
	String description;
	String manufacturer;
	String category;
	long unitsInStock;
	String condition;
	String filename;
	


	public ProductVO() {
		super();
	}



	public ProductVO(String productid, String pname, Integer unitPrice, String description, String manufacturer,
			String category, long unitsInStock, String condition, String filename) {
		super();
		this.productid = productid;
		this.pname = pname;
		this.unitPrice = unitPrice;
		this.description = description;
		this.manufacturer = manufacturer;
		this.category = category;
		this.unitsInStock = unitsInStock;
		this.condition = condition;
		this.filename = filename;
	}



	public String getProductid() {
		return productid;
	}



	public void setProductid(String productid) {
		this.productid = productid;
	}



	public String getPname() {
		return pname;
	}



	public void setPname(String pname) {
		this.pname = pname;
	}



	public Integer getUnitPrice() {
		return unitPrice;
	}



	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getManufacturer() {
		return manufacturer;
	}



	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public long getUnitsInStock() {
		return unitsInStock;
	}



	public void setUnitsInStock(long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}



	public String getCondition() {
		return condition;
	}



	public void setCondition(String condition) {
		this.condition = condition;
	}



	public String getFilename() {
		return filename;
	}



	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
	
	
	
}