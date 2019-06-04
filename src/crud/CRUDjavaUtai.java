package crud;

import utail.JDBCInitUtail;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDjavaUtai {

    public static String addSQL(String tabName, Integer id, String name, int age) {
        return "insert into user_info values (" + id + ",'" + name + "'," + age + ")";
    }

    //根据条件删除
    public static String deletSQL(String tabName, String name) {
        return "delete from user_info where name = '" + name + "'";
    }

    //更新
    public static String upSQL(String tabName, int age, String name) {
        return "update user_info set age = " + age + " where name = '" + name + "'";
    }

    public static String selectAll(String tabName, String sql) {
        System.out.println("select * from " + tabName + sql);
        return "select * from " + tabName + sql;
    }

    public static void systemDataAll(ResultSet resultSet) {
        //执行操作语句
        try {
            while (resultSet.next()) {
                System.out.println("id=" + resultSet.getInt("id") +
                        "name=" + resultSet.getString("name") + "passward=" +
                        resultSet.getInt("passward"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
