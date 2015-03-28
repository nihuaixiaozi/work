import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
//jdbc:oracle:thin:@localhost:1521:sjbitdb
public class MasterManager {
	/**
	 * 登录。
	 * @param loginId  用户名
	 * @param password  密码
	 * @return
	 */
	private boolean login(String loginId, String password) {
		boolean ret = false;
		// 1、数据库连接信息
		String driverClassName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:sjbitdb";
		String user = "epet";
		String dbPassword = "bdqn";
		// 2、根据查询结果判断登录是否成功
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
		// 3、返回登录结果
		return ret;
	}
	/**
	 * 登录。
	 */
	public void login() {
		// 1、获得输入对象
		Scanner input = new Scanner(System.in);
		// 2、打印欢迎信息
		System.out.println("---- 欢迎光临宠物乐园 ----");
		// 3、获取用户输入的登录名、密码
		System.out.print("请输入登录名：");
		String loginId = input.next();
		System.out.print("请输入密码：");
		String password = input.next();
		// 4、检查登录名、密码是否合法，并输出提示信息
		if (this.login(loginId, password)) {
			System.out.println("登录成功！");
		} else {
			System.out.println("用户名或密码错误，登录失败！");
		}
	}
}
