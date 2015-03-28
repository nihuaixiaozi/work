import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
//jdbc:oracle:thin:@localhost:1521:sjbitdb
public class MasterManager {
	/**
	 * ��¼��
	 * @param loginId  �û���
	 * @param password  ����
	 * @return
	 */
	private boolean login(String loginId, String password) {
		boolean ret = false;
		// 1�����ݿ�������Ϣ
		String driverClassName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:sjbitdb";
		String user = "epet";
		String dbPassword = "bdqn";
		// 2�����ݲ�ѯ����жϵ�¼�Ƿ�ɹ�
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, user, dbPassword);
			String sql = "select *from loginuser where  loginid = ? and password = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginId);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				ret = true;
			} else {
				ret = false;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != rs) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (null != pstmt) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (null != conn) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 3�����ص�¼���
		return ret;
	}
	/**
	 * ��¼��
	 */
	public void login() {
		// 1������������
		Scanner input = new Scanner(System.in);
		// 2����ӡ��ӭ��Ϣ
		System.out.println("---- ��ӭ���ٳ�����԰ ----");
		// 3����ȡ�û�����ĵ�¼��������
		System.out.print("�������¼����");
		String loginId = input.next();
		System.out.print("���������룺");
		String password = input.next();
		// 4������¼���������Ƿ�Ϸ����������ʾ��Ϣ
		if (this.login(loginId, password)) {
			System.out.println("��¼�ɹ���");
		} else {
			System.out.println("�û�����������󣬵�¼ʧ�ܣ�");
		}
	}
}
