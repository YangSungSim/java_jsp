package jsp_20191224.action.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	
	private final static String driver = "oracle.jdbc.OracleDriver";
	private static final String url = "";
	private final String id = "root";
	private final String pw = "1234";
			
	public static Connection connect() {
		
		Connection con = null;
		try {
			Class.forName(driver);
			DriverManager.getConnection(url,id,pw);
		} catch (ClassNotFoundException e){
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
