import java.sql.*;
public class TestAdd2 {

	public static void main(String[] args) {
	Connection conn=null;
	ResultSet rs=null;
	PreparedStatement ps=null;
   try{
	   //�ڶ���:��������
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   //������:�������Ӷ���
	   conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:sjbitdb", "epet", "bdqn");
	   //���Ĳ�����ִ�ж���
	   String sql="insert into test values(?,?)";
	   ps = conn.prepareStatement(sql);
	   //���ò���
	    ps.setInt(1,1);
	    ps.setString(2, "�ֳ�");
	    //����:ִ��sql���
	    int row=ps.executeUpdate();
	    if(row>0){
	    	System.out.println("����ɹ���");
	    }else{
	    	System.out.println("����ʧ�ܣ�");
	    }
   }catch(ClassNotFoundException e){
	   System.out.println("������������");
	   e.printStackTrace();
   }catch(SQLException e){
	   System.out.println("�����д����SQL����д���");
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
		   System.out.println("�ر��д���");
		   e.printStackTrace();
	   }
   }
	}

}
