import java.sql.*;
public class Testupdate {

	public static void main(String[] args) {
	//创建连接对象
		Connection conn=null;
		//创建执行对象
		PreparedStatement pst=null;
		try{
			//加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:sjbitdb", "epet",
			"bdqn");
			//编写SQL语句
			String sql=("delete from student where stuno=? ");
			pst=conn.prepareStatement(sql);
			//设置参数
			pst.setString(1, "at003");
			//执行SQL语句
			int row=pst.executeUpdate();
			if(row>0){
				System.out.println("删除成功！");
			}else{
				System.out.println("没有该学生编号！");
			}
		}catch(ClassNotFoundException e){
			System.out.println("加载驱动失败！"+e.getMessage());
		}catch(SQLException e){
			System.out.println("连接或SQL语句有错误！"+e.getMessage());
		}finally{
			try{
				conn.close();
			}catch(SQLException e){
				System.out.println("关闭连接错误！"+e.getMessage());
			}
		}

	}

}
