import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 * 纯java连接sqlserver数据库
 * @author Administrator
 *
 */
public class Oracle2 {

	private static Logger logger = Logger.getLogger(Oracle.class.getName());

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			logger.error(e);
		}
		// 简历连接
		try {
			conn = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;DatabaseName=Student",
					"jbit", "bdqn");
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
