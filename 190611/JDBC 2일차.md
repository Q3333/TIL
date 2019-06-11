# JDBC 2일차	

#######################JDBC 프로그래밍 단계 ########################

0. 연결할 데이터베이스의 driver class 클래스 (~.jar)를 

- 운영체제의 환경변수 classpath에 추가
- JDK또는 JRE의 라이브러리 검색 위치중에 외부 확장 라이브러리 저장위치 (%JAVA_HOME%jre/lib/ext)
- 이클립스(IDE)에서 프로젝트의 bulid path>configure build path>library> add external jar......추가

셋 중 하나만 해도 됨



1. import java.sql.*; 

- JDBC API를 import



2. DriverClass 로딩

   ```
   try{
      Class.forName(" ");  //oracle.jdbc.OracleDriver
   }catch(ClassNotFoundException e){
   
   }
   ```

   

3. Connection 객체 생성

- 로딩된 드라이버 클래스의 static 멤버 객체의 DriverManager.getConnection( dburl, user , pwd ) 이용해서
     DB에 connect한다.

- DB에 세션 생성되고, 세션이 리턴됩니다. => java.sql.Connection객체로 받는다.

- Connection 인터페이스에 주요 메소드 : close(), createStatement(), prepareStatement(),

  callableStatement(), setAutoCommit(false), commit(), rollback(), setSavepoint(),..



※ JAVA에서는 insert, update, delete 등등 전부 AutoCommit이라서 setAutoCommit()함수를 setAutoCommit(false)로 사용해주어야 rollback이 된다.



4. SQL 실행 대행 객체 Statement 객체 생성

- Statement - 완전한 sql문장을 문자열로 전송하므로 매번 hard parsing을 수행한다.

- PreparedStatement - sql문장중에서 변경되는 부분들을 ? (index 파라미터)로 설정해서 미리 sql을 전송하고, 실행할때마다 값만 전송해서 실행(soft parsing수행될 확률이 높다.)

-  CallableStatement - DB에 저장되어 있는 procedure, function을 호출해서 결과를 받을때\

  

5.  SQL문 실행

      executeQuery() -- select문장, ResultSet 객체 리턴
      executeUpdate() -- DML문은 int(변경된 행수) 리턴 , DDL, DCL문
      execute()  - select문, DML문, boolean 리턴(true일때는 select수행, false 일때는 dml수행)



6.  select 수행 결과 처리

   ```
   while(rs.next()) {
        rs.getInt(컬럼position | "컬럼명"),
        rs.getDouble(컬럼position | "컬럼명"),...
        rs.getString(컬럼position | "컬럼명"),
        rs.getDate(컬럼position | "컬럼명"),
         ...
      }
   ```

   ※ getInt, getString 등등은 인수로 컬럼postion(숫자)나 컬럼명(문자열, "컬럼명")을 넣어주어야 한다.



7. SQLException 예외 처리

   try ~ catch 문으로 

   

8. 사용 자원 (Connection, Statement, ResultSet)들 반납 close() ---> 역시 예외처리 필요함



############ 주의 ###########

소스코드에 db연결정보를 hard coding하는것은 보안상..문제가 되므로 **보안 폴더**에 properties파일에 key=value형태로 저장해야한다.

properties 형태 : 

```sql
Properties prop = new Properties();
prop.load(new FileInputStream("경로/이름.."));
String value = prop.getProperty("key");
```







## Transaction

- 트랜잭션이란 여러 개의 오퍼레이션을 하나의 작업 단위로 묶어 주는 것을 말한다.

  ex) 결제 + 주문을 한 Transaction으로 묶어줌.



트랜잭션을 사용하기 위해서는 일단 시작부터 setAutoCommit(false)를 사용해서 AutoCommit을 꺼야 한다.

그 뒤, 성공하면 commit(), 실패하면 rollback()







## JDBC *복습필요

BatchQuery : 여러 개의 SQL문을 한꺼번에 전송하는 일괄 처리 방식.



Java에서 코딩하는 DB연동



1. 연결

```sql
public Connection dbCon() {
		Connection con = null;
		
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("c:/workspace/day13/src/lab/java/core/dbinfo.properties"));
			
			Class.forName(prop.getProperty("driver")); // driver에 써져있는 키를 가져옴
			con = DriverManager.getConnection(prop.getProperty("url"),
					prop.getProperty("user"),
					prop.getProperty("pwd"));
			//System.out.println("db connect 성공");
			
			}catch(Exception e) {
				e.printStackTrace();
				//System.out.println(e.getMessage()); // properties 파일의 경로, 존재 오류시
			}
		
		return con;
	}
```

 

2. 종료

```sql
public void dbCloase(Connection con, Statement stat, ResultSet rs) {
		try {	
			if(rs!=null)rs.close();	//DB자원은 귀중하기 때문에 꼭 닫아줘야댐
			if(stat!=null)stat.close();
			if(con!=null) con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
```



3. Insert

```sql
	public int insertBook(Book newBook) {
		int rows = 0;
		Connection con = null;
		PreparedStatement stat = null;
		
		String novel = "insert into book (ibsn, title, author, price) values (?,?,?,?)";
		String magazine = "insert into book (ibsn,title,price,category,descript) 				values(?,?,?,?,?)";
		
		try {
			con = dbCon();
			if(newBook.getIsbn().startsWith("N")) {
				stat = con.prepareStatement(novel);
				stat.setString(1, newBook.getIsbn());
				stat.setString(2, newBook.getTitle());
				stat.setString(3, newBook.getAuthor());
				stat.setInt(4, newBook.getPrice());
				
			}else {
				stat = con.prepareStatement(magazine);
				stat.setString(1, newBook.getIsbn());
				stat.setString(2, newBook.getTitle());
				stat.setInt(3, newBook.getPrice());
				stat.setString(4, newBook.getCategory());
				stat.setString(5, newBook.getDescript());
			}
			rows = stat.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose(con,stat,null);
		}
		return rows;
			
	}
```



4. Update

```sql
public int updateBook(Book modifyBook) {
		int rows = 0;
		Connection con = null;
		PreparedStatement stat = null;
		String novel = "update book set price =? where isbn = ?";
		String magazine = "update book set price =?, descript = ? where isbn = ?";
		try {
			con = dbCon();
			if(modifyBook.getIsbn().startsWith("N")) {
				stat = con.prepareStatement(novel);
				stat.setString(2, modifyBook.getIsbn());
				stat.setInt(1, modifyBook.getPrice());
				
			}else {
				stat = con.prepareStatement(magazine);
				stat.setString(3, modifyBook.getIsbn());
				stat.setInt(1, modifyBook.getPrice());
				stat.setString(2, modifyBook.getDescript());
			}
			rows = stat.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose(con,stat,null);
		}
		return rows;
			
	}
```



5. Delete

```sql
public int deleteBook(String isbn) {
		int rows = 0;
		Connection con = null;
		PreparedStatement stat = null;
		String sql = "delete from book where isbn = ?";
		try {
			con = dbCon();
			stat = con.prepareStatement(sql);
			stat.setString(1, isbn);
			rows = stat.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose(con,stat,null);
		}
		return rows;
	}
	
```



각 예제 코드를 보고 복습 필요



Sql을 String 형태로 넣고 PreparedStatement에 넣은 뒤, setString으로 ?에 들어갈 값을 넣어주는 형태로 Sql을 보낸다.



※ SELECT의 경우는 Prepared를 쓸 필요가 없음 -> 그냥 Statement로도 OK



출력 방식 참고

```
Connection con = null;
Statement stat = null;
ResultSet rs = null;
String sql = "select * from dept";
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
```

rs라는 executeQuery를 사용해서 rs.getInt, getString등으로 해당 테이블의 값을 가져온다.

(위의 SetString, SetInt랑 반대로 가져올 때는 get)