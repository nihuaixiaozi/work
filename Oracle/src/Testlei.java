//第一步：导包
import java.sql.*;

public class Testlei {

	public static void main(String[] args) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			// 第二步:加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 第三步:创建连接对象
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:sjbitdb", "epet", "bdqn");
			// 第四步:创建执行对象
			String sql = "select * from test";
			ps = conn.prepareStatement(sql);
			// 第五步:执行SQL语句，并获得结果
			rs = ps.executeQuery();
			// 输出结果rs.next()表示判断是否有下一条记录，有，则读取下一条记录
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				System.out.println(id + "\t" + name);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动失败！");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("连接或SQL语句有错！");
			e.printStackTrace();
		} finally {
			//关闭连接
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
				System.out.println("关闭有错误！");
				e.printStackTrace();
			}
		}

	}
}
