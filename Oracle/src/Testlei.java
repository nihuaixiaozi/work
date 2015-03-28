//��һ��������
import java.sql.*;

public class Testlei {

	public static void main(String[] args) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			// �ڶ���:��������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ������:�������Ӷ���
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:sjbitdb", "epet", "bdqn");
			// ���Ĳ�:����ִ�ж���
			String sql = "select * from test";
			ps = conn.prepareStatement(sql);
			// ���岽:ִ��SQL��䣬����ý��
			rs = ps.executeQuery();
			// ������rs.next()��ʾ�ж��Ƿ�����һ����¼���У����ȡ��һ����¼
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				System.out.println(id + "\t" + name);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("��������ʧ�ܣ�");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("���ӻ�SQL����д�");
			e.printStackTrace();
		} finally {
			//�ر�����
			try {
				if (null != conn) {
					conn.close();
				}
				if (null != rs) {
					rs.close();
				}
				if (null != ps) {
					ps.close();
				}
			} catch (SQLException e) {
				System.out.println("�ر��д���");
				e.printStackTrace();
			}
		}

	}
}
