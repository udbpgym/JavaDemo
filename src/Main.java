
import com.mysql.jdbc.Driver;
import config.NetConfig;
import utail.JDBCInitUtail;


import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class Main {
    static Connection connection;
    static Statement statement;
    static ResultSet resultSet;

    public static void main(String[] args) {

        try {
            connection = JDBCInitUtail.getConn();
            //创建statemen
            statement = connection.createStatement();
            //初始化sql
            String sql = "select * from  user_info";
            resultSet = statement.executeQuery(sql);
            //执行操作语句
            while (resultSet.next()) {
                System.out.println("id=" + resultSet.getInt("id") +
                        "name=" + resultSet.getString("name") + "age=" +
                        resultSet.getInt("age"));
            }

        } catch (SQLException e) {
            System.out.println("main错误信息=" + e.toString());
        } finally {
            //反顺序关闭，严禁判空
            JDBCInitUtail.closeAll(resultSet, statement, connection);

        }
    }
}
