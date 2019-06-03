package utail;


import com.sun.org.apache.regexp.internal.RE;
import crud.CRUDjavaUtai;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public class JDBCInitUtail {
    static String driverClass = null;
    static String url = null;
    static Connection connection;
    static Statement statement;
    static ResultSet resultSet;

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

    //遍历所有
    public static ResultSet resultSet(String tabName) {
        try {
            if (connection == null) {
                connection = JDBCInitUtail.getConn();

            }
            if (statement == null) {
                //创建statemen
                statement = connection.createStatement();
            }
            if (resultSet == null) {

                resultSet = statement.executeQuery(CRUDjavaUtai.selectAll(tabName));
            }
            CRUDjavaUtai.systemDataAll(resultSet);
        } catch (SQLException e) {
            System.out.println("main错误信息=" + e.toString());
        } finally {
            //反顺序关闭，严谨判空
            JDBCInitUtail.closeAll(resultSet, statement, connection);

        }
        return resultSet;
    }

    //根据操作语句增加，删除
    public static Statement statement(String sql) {
        try {
            if (connection == null) {
                connection = JDBCInitUtail.getConn();
            }
            if (statement == null) {
                //创建statemen
                statement = connection.createStatement();
            }
            int result = statement.executeUpdate(sql);
            if (result > 0) {
                System.out.println("操作成功");
            } else {
                System.out.println("操作失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //反顺序关闭，严谨判空
            JDBCInitUtail.closeAll(resultSet, statement, connection);

        }
        return statement;
    }

    public static Connection getConn() {
        Connection connection = null;
        try {
            //注册驱动 1静态代码块注册,jdbc4.0以后可以不需要注册驱动
            //DriverManager.registerDriver(new Driver());
            // Class.forName(driverClass);
            //建立连接
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
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
