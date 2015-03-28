import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 *jdbc����sqlserver���ݿ�
 * @author Administrator
 *
 */
public class Oracle3 {

	private static Logger logger = Logger.getLogger(Oracle.class.getName());

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException e) {
			logger.error(e);
		}
		// ��������
		try {
			conn = DriverManager.getConnection("jdbc:odbc:host", "jbit",
					"bdqn");
			System.out.println("�������ӳɹ���");
		} catch (SQLException e) {
			logger.error(e);
		} finally {
			// �ر�����
			try {
				if (null != conn) {
					conn.close();
					System.out.println("�ر����ӳɹ���");
				}
			} catch (SQLException e) {
				logger.error(e);
			}
		}
	}

}
