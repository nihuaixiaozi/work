import java.sql.*;
public class Testupdate {

	public static void main(String[] args) {
	//�������Ӷ���
		Connection conn=null;
		//����ִ�ж���
		PreparedStatement pst=null;
		try{
			//��������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:sjbitdb", "epet",
			"bdqn");
			//��дSQL���
			String sql=("delete from student where stuno=? ");
			pst=conn.prepareStatement(sql);
			//���ò���
			pst.setString(1, "at003");
			//ִ��SQL���
			int row=pst.executeUpdate();
			if(row>0){
				System.out.println("ɾ���ɹ���");
			}else{
				System.out.println("û�и�ѧ����ţ�");
			}
		}catch(ClassNotFoundException e){
			System.out.println("��������ʧ�ܣ�"+e.getMessage());
		}catch(SQLException e){
			System.out.println("���ӻ�SQL����д���"+e.getMessage());
		}finally{
			try{
				conn.close();
			}catch(SQLException e){
				System.out.println("�ر����Ӵ���"+e.getMessage());
			}
		}

	}

}
