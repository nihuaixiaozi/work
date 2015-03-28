import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class TestAdd {

	
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
			String sql=("insert into student values(?,?,?,?,?) ");
			pst=conn.prepareStatement(sql);
			//���ò���
			pst.setString(1, "at003");
			pst.setString(2, "����");
			pst.setString(3, "Ů");
			pst.setInt(4, 20);
			pst.setString(5, "����");
			//ִ��SQL���
			int row=pst.executeUpdate();
			if(row>0){
				System.out.println("����ɹ���");
			}
//			else{
//				System.out.println("����ʧ��");
//			}
		}catch(ClassNotFoundException e){
			System.out.println("��������ʧ�ܣ�"+e.getMessage());
		}catch(SQLException e){
			System.out.println("���ӻ�SQL����д���"+e.getMessage());
		}finally{
			try{
				conn.close();
				pst.close();
			}catch(SQLException e){
				System.out.println("�ر����Ӵ���"+e.getMessage());
			}
		}

	
	}

}
