package utail;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public class JDBCInitUtail {
    static String driverClass = null;
    static String url = null;

    //创建一个属性配置对象
    static {

        try {
            Properties properties = new Properties();
            //导入输入流
            //若采用此种方法，jdbc.properties应放在src目录下
            // InputStream inputStream = JDBCInitUtail.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //若采用此种方法，jdbc.properties应放在工程根目录下
            InputStream inputStream = new FileInputStream("jdbc.properties");
            properties.load(inputStream);
            //读取属性
            driverClass = properties.getProperty("driverClass");
            url = properties.getProperty("url");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() {
        Connection connection = null;
        try {
            //注册驱动 1静态代码块注册,jdbc4.0以后可以不需要注册驱动
            //DriverManager.registerDriver(new Driver());
           // Class.forName(driverClass);
            //建立连接
            connection = DriverManager.getConnection(url);
        }  catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeAll(ResultSet resultSet, Statement statement, Connection connection) {
        closeResultSet(resultSet);
        closeStatement(statement);
        closeConnection(connection);
    }

    private static void closeResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            System.out.println("resultSet错误信息=" + e.toString());
        } finally {
            resultSet = null;
        }
    }

    private static void closeStatement(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            System.out.println("statement错误信息=" + e.toString());
        } finally {
            statement = null;
        }
    }


    private static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("connection错误信息=" + e.toString());
        } finally {
            connection = null;
        }
    }
}
