import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import org.apache.log4j.Logger;

/**
 * 纯java连接orcale数据库
 * @author Administrator
 *
 */
public class Oracle4 {

	private static Logger logger = Logger.getLogger(Oracle.class.getName());

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			logger.error(e);
		}
		// 简历连接
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:sjbitdb", "epet",
					"bdqn");
			System.out.println("建立连接成功！");
		} catch (SQLException e) {
			logger.error(e);
		} finally {
			// 关闭连接
			try {
				if (null != conn) {
					conn.close();
					System.out.println("关闭连接成功！");
				}
			} catch (SQLException e) {
				logger.error(e);
			}
		}
	}
}
