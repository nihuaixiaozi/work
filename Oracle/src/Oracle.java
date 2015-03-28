import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import java.sql.*;
/**
 * jdbc����orcale���ݿ�
 * @author Administrator
 * yangliesheng
 */
public class Oracle {

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
			conn = DriverManager.getConnection("jdbc:odbc:localhost", "system",
					"Ss19901012");
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