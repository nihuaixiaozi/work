import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import org.apache.log4j.Logger;

/**
 * ��java����orcale���ݿ�
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
		// ��������
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:sjbitdb", "epet",
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
