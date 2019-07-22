package lab.board.model;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class ProductDAO {
	public ArrayList<ProductVO> getProductList() {
		ArrayList<ProductVO> Products = new ArrayList<ProductVO>();
		Connection con = null;
		PreparedStatement stat = null;
		ResultSet rs = null;

		String sql = "select * from product";
		
		try {
			con = dbCon();
			stat = con.prepareStatement(sql.toString());
			rs = stat.executeQuery();
			while (rs.next()) {
				ProductVO pb = new ProductVO();

				pb.setProductid(rs.getString("ProductId"));
				pb.setPname(rs.getString("pname"));
				pb.setUnitPrice(rs.getInt("unitPrice"));
				pb.setDescription(rs.getString("description"));
				pb.setCategory(rs.getString("category"));
				pb.setCondition (rs.getString("condition"));
				pb.setFilename(rs.getString("filename"));
				Products.add(pb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(con, stat, rs);
		}
		return Products;
	}
	
	public ProductVO getProduct(String pid) {
		ProductVO pb = new ProductVO();
		Connection con = null;
		PreparedStatement stat = null;
		ResultSet rs = null;

		String sql = "select * from product where PRODUCTID = ?";
		
		try {
			con = dbCon();
			stat = con.prepareStatement(sql.toString());
			stat.setString(1, pid);
			rs = stat.executeQuery();
			
			
			if(rs.next()) {
			

				pb.setProductid(rs.getString("ProductId"));
				pb.setPname(rs.getString("pname"));
				pb.setUnitPrice(rs.getInt("unitPrice"));
				pb.setDescription(rs.getString("description"));
				pb.setCategory(rs.getString("category"));
				pb.setCondition (rs.getString("condition"));
				pb.setFilename(rs.getString("filename"));
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(con, stat, rs);
		}
		return pb;
	}
	
	
	public Connection dbCon() {
		Connection con = null;
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("C:/workspace2/BBS/WebContent/WEB-INF/db.properties"));
			Class.forName(prop.getProperty("driver"));
			con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
					prop.getProperty("pwd"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public void dbClose(Connection con, Statement stat, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (stat != null)
				stat.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
