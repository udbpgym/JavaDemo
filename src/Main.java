
import com.mysql.jdbc.Driver;
import config.NetConfig;
import crud.CRUDjavaUtai;
import dao.UserDao;
import daoimpl.UserDaoImpl;
import utail.JDBCInitUtail;


import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class Main {
    private static String sql;


    public static void main(String[] args) {
        //数据库增删查改
        // initCRUD();
        //Dao模式
        UserDao userDao = new UserDaoImpl();
       // userDao.findAll();
        userDao.login("张三","123456");
    }

    private static void initCRUD() {
        //查询所有
        //   JDBCInitUtail.resultSet("user_info");

        //增加
//        sql = CRUDjavaUtai.addSQL("user_info",null, "异人", 18);
        //删除
//        sql = CRUDjavaUtai.deletSQL("user_info","异人");
        //更新
//        sql = CRUDjavaUtai.upSQL("user_info", 19, "张三");
//        System.out.println(sql);
//        JDBCInitUtail.statement(sql);
    }
}
