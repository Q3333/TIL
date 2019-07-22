## JDBC(Java Database Connectivity)

#### JDBC란?

- java apl 와 DB가 직접적으로 연결이 되면 종속적이 되기 때문에, 중간에 API를 하나 만들어주는데 그게 바로 JDBC
- 모든DB가 공통적으로 처리하는 것들을 모아놓은 Interface들의 집합, API다.
- JDBC의 역할은 Application과 DBMS의 **Bridge** 역할을 하게 된다.



#### Tier 

물리적으로 떨어져있음, 거리가 있음

ex) 클라이언트 <---> 데이터베이스 서버



**2Tier**

- 자바애플리케이션이 JDBC 드라이버를 통해서 직접 데이터베이스를 접근하는 형식이다.



자바어플리케이션 + JDBC 	<ㅡㅡㅡㅡㅡㅡㅡㅡㅡ> 			DBMS

클라이언트								DBMS 프로토콜 				데이터 베이스 서버



**3Tier**

- 3tier 모델은 2tier 모델에 미들웨어 계층이 추가된 형태이며, 미들웨어에서 DBMS에 직접 질의하게 된다.



자바어플리케이션

또는 애플릿			<ㅡㅡㅡㅡㅡㅡㅡㅡㅡ> 애플리케이션 서버 + JDBC  <ㅡㅡㅡㅡㅡㅡㅡㅡㅡ> DBMS

또는 브라우저

-클라이언트-											     		-미들웨어-												-데이터베이스 서버-







#### Layer 

계층이 나누어져있음

ex) TCP/IP 4 Layer





#### Statement 객체

SQL을 DB에 전송하는 객체 +

DB에서 수행한 결과를 가져와서 java aplication 에 전달하는 객체



즉 SQL 대행 객체다.



**Statement의 상속관계**

Statement (SQL 완전 문장을 전송할 때 사용)  : 반복 내용이 있어도 계속 Hard parsing을 하기 때문에 좋지 않음.

↑

PreparedStatement : 반복 내용을 파라미터화 해서 보내고, Soft parsing이 되서 성능이 좋아진다.(성능개선)

↑

CallableStatement



## 데이터베이스 구문 사용

executeQuery(String sql) – SQL문이 select 일 경우

return 값이 ResultSet



executeUpdate(String sql) – SQL문이 insert, update, delete문 등일 경우

return 값이 int



예제) **Select**

```sql
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {

	public static void main(String[] args) {
		Connection con = null; // DB 연결상태 세션 정보 저장
		Statement stat = null;
		ResultSet rs = null;
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String sql = "select * from dept";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			//System.out.println("driver loading 성공");
			con = DriverManager.getConnection(url,"scott","oracle");
			//System.out.println("db connect 성공");
			stat = con.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()) {
				System.out.print(rs.getInt("deptno")+"_"); // int값이라 getint
				//System.out.print(rs.getInt(1));
				System.out.print(rs.getString("dname")+"_"); // 이름은 String
				//System.out.print(rs.getString(2));
				System.out.println(rs.getString("loc")); 
				//System.out.print(rs.getString(3));
				
			}
			
			
		}catch(ClassNotFoundException e) {
			System.out.println("driver 없음");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			//db 연결 실패
		}finally {
			try {
			if(rs!=null) rs.close();	//DB자원은 귀중하기 때문에 꼭 닫아줘야댐
			if(stat!=null)stat.close();
			if(con!=null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}// try end
		}// finally end
		
	}// main end
}// class end
```





예제) Insert + File(properties)을 만들어서 연동

- **properties**

```properties
driver=oracle.jdbc.OracleDriver
url=jdbc:oracle:thin:@localhost:1521:orcl
user=scott
pwd=oracle
```



- **Insert**

```sql
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class InsertTest {

	public static void main(String[] args) {
		Connection con = null; // DB 연결상태 세션 정보 저장
		PreparedStatement stat = null; 
		// 물음표 들어간 sql을 쓰기 때문에 PreparedStatement를 써야함.
		
		String sql = "insert into dept values (?,?,?) "; // 아직 값이 저장되지 않음
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("c:/workspace/day13/src/lab/java/core/dbinfo.properties"));
			
			Class.forName(prop.getProperty("driver")); // driver에 써져있는 키를 가져옴
			con = DriverManager.getConnection(prop.getProperty("url"),
					prop.getProperty("user"),
					prop.getProperty("pwd"));
			System.out.println("db connect 성공");
			
			stat = con.prepareStatement(sql); // create와 달리 sql을 미리 보내야한다.
			stat.setInt(1, 70);
			stat.setString(2,"BigData");
			stat.setString(3, "Seoul");
			
			int rows = stat.executeUpdate();
			if(rows>0) {
				System.out.println("Insert 성공");
			}
			
		}catch(ClassNotFoundException e) {
			System.out.println("driver 없음");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			//db 연결 실패
		}catch(IOException e) {
			System.out.println(e.getMessage()); // properties 파일의 경로, 존재 오류시
		}finally {
			try {	
			if(stat!=null)stat.close();	//DB자원은 귀중하기 때문에 꼭 닫아줘야댐
			if(con!=null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}// try end
		}// finally end
		
	}// main end
}// class end
```

