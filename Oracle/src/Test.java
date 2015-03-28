import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Test {


	public static void main(String[] args) {
		MasterManager instance=new MasterManager();
		instance.login();
//		   try {
//		        Class.forName("oracle.jdbc.driver.OracleDriver");
//		    } catch (ClassNotFoundException ce) {
//		        System.out.println(ce);
//		    }
//		    try {
//		        String url = "jdbc:odbc:localhost";
//		        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:sjbitdb", "epet",
//				"bdqn");
//		        Statement s = con.createStatement();
//		        ResultSet rs = s.executeQuery("select * from loginuser");
//		        while (rs.next()) {
//		            System.out.print(rs.getString(1) + "\t");
//		            System.out.print(rs.getString(2) + "\t");
//		            System.out.print(rs.getInt(3) + "\t");
//		            System.out.println(" ");
//		        }
//		        rs.close();
//		        s.close();
//		        con.close();
//		    } catch (SQLException ce) {
//		        System.out.println(ce);
//		    }
	    }

}
