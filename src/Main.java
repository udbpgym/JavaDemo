
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
        // initDao();
        //使用PrepareStatment查询
        //initPrepareStatment();
        //使用PrepareStatment做添加
//        initInsert();
        //使用PrepareStatment做添加
//        initDelete();
        //使用PrepareStatment做更新
        initUpdate();
    }

    private static void initUpdate() {
        UserDao userDao = new UserDaoImpl();
        userDao.upData("韩梅梅","654321");
    }

    private static void initDelete() {
        UserDao userDao = new UserDaoImpl();
        userDao.delete("张三");
    }

    private static void initInsert() {
        UserDao userDao = new UserDaoImpl();
        userDao.insert("方士", "654321");
    }

    private static void initPrepareStatment() {
        UserDao userDao = new UserDaoImpl();
        userDao.login("张三", "123456'or'1=1");
    }

    private static void initDao() {
        UserDao userDao = new UserDaoImpl();
        // userDao.findAll();
        //select * from user_login WHERE name = '张三' and passward= '123456'or'1=1'
        // 后面的passward两个表达式成立一个就会返回true。形成bug
        //前面先拼接SQL语句，如果变量里面带数据库关键字，那么一并认为是关键字而不是普通字符串，例如 or
        //为了解决这个问题，所以用PrepareStatment
        userDao.login("张三", "123456'or'1=1");
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
