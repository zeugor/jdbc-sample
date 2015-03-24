References
----------
http://www.adictosaltrabajo.com/tutoriales/tutoriales.php?pagina=tutorial_basico_jdbc
http://www.tutorialspoint.com/jdbc

>> import java.sql.*;

Load the driver
---------------
In previous versions of JDBC, to obtain a connection, you first had to load your JDBC driver by calling the method 

Example
-------
>> Class.forName("com.mysql.jdbc.Driver"); // this could be ommited with JDBC 4.0 
>> Connection conn = DriverManager.getConnection(url + dbName, user, password);
>> String sql = "SELECT id, first, last, age FROM Employees";
>> ResultSet rs = stmt.executeQuery(sql);
or 
>> ResultSet rs = stmt.executeUpdate(sql);
>> conn.close();
Any JDBC 4.0 drivers that are found in your class path are automatically loaded.

Statements
----------
- Statement
Use for general-purpose access to your database. Useful when you are using static SQL statements at runtime. The Statement interface cannot accept parameters.

- PreparedStatement
Use when you plan to use he SQL statements many times. The PreparedStatement interface accepts input parameters at runtime.
>> PreparedStatement stmt = conn.prepareStatement("querySQL");
>> stmt.setString(1, valueStringIndex1);
>> stmt.close();

- CallableStatement
Use when you want to access database stored procedures. 

Clean up
--------
rs.close();
stmt.close();
conn.close();