# BANK ATM Teller Machine
## Deposit, Withdraw, Check Balance and give suggestions

Topgyal Gurung

MAC 190-5425

Individual Project: Java GUI application

Created by Topgyal Gurung on DEC 1, 2016.

Copyright © 2016 Topgyal Gurung. All rights reserved

#### TODO 
- JDBC connection 
    - register driver
    - create connection
    - create statement
    - execute queries
    - close connection
```
/**
	 * Class.forName=("com.mysql.jdbc.Driver"); // sql driver to establish database connection
	 * Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase","root","password");
	 * Statement stmt=con.createStatement() #object of statement responsible to execute queries wiht db
	 * ResultSet rs=stmt.executeQuery("SELECT a,b,c, FROM Table1");
	 * 
	 * while(rs.next()){
	 * 	int x=rs.getInt("a");
	 * 	String s=rs.getString("b");
	 * 	float f=rs.getFloat("c");
	 * }
	 * 
	 * con.close()
	 */
 ```