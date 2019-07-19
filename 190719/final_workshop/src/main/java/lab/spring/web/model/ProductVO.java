package lab.spring.web.model;

public class ProductVO {
	String pcode;   
	String pname;
	int price;
	int quant;
	String pdesc;
	
	
	
	public ProductVO() {
		super();
	}
	 
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuant() {
		return quant;
	}
	public void setQuant(int quant) {
		this.quant = quant;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	@Override
	public String toString() {
		return "ProductVO [pcode=" + pcode + ", pname=" + pname + ", price=" + price + ", quant=" + quant + ", pdesc="
				+ pdesc + "]";
	}
	
	

	

	
	
	
}
