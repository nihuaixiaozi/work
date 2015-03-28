import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import java.sql.*;
/**
 * jdbc连接orcale数据库
 * @author Administrator
 * yangliesheng---add--update 51168 123456 123451168  rttiutu
 * 123123
 */
public class Oracle {

    private static Logger logger = Logger.getLogger(Oracle.class.getName());

    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        } catch (ClassNotFoundException e) {
            logger.error(e);
        }
        // 简历连接
        try {
            conn = DriverManager.getConnection("jdbc:odbc:localhost", "system",
                    "Ss19901012");
            System.out.println("建立连接成功！");
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            // 关闭连接
            try {
                if (null != conn) {
                    conn.close();
                    System.out.println("关闭连接成功！");
                }
            } catch (SQLException e) {
                logger.error(e);
            }
        }
    }

}
