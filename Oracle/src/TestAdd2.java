import java.sql.*;
public class TestAdd2 {

	public static void main(String[] args) {
	Connection conn=null;
	ResultSet rs=null;
	PreparedStatement ps=null;
   try{
	   //第二步:加载驱动
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   //第三步:创建连接对象
	   conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:sjbitdb", "epet", "bdqn");
	   //第四步创建执行对象
	   String sql="insert into test values(?,?)";
	   ps = conn.prepareStatement(sql);
	   //设置参数
	    ps.setInt(1,1);
	    ps.setString(2, "林冲");
	    //第五:执行sql语句
	    int row=ps.executeUpdate();
	    if(row>0){
	    	System.out.println("插入成功！");
	    }else{
	    	System.out.println("插入失败！");
	    }
   }catch(ClassNotFoundException e){
	   System.out.println("加载驱动错误！");
	   e.printStackTrace();
   }catch(SQLException e){
	   System.out.println("连接有错误或SQL语句有错误！");
	   e.printStackTrace();
   }finally{
	   try{
		   if(null!=conn){
			   conn.close();
		   }
		   if(null!=rs){
			   rs.close();
		   }
		   if(null!=ps){
			   ps.close();
		   }
	   }catch(SQLException e){
		   System.out.println("关闭有错误！");
		   e.printStackTrace();
	   }
   }
	}

}
