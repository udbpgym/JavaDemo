package daoimpl;

import dao.UserDao;
import utail.JDBCInitUtail;

/*
 *
 *
 * */
public class UserDaoImpl implements UserDao {
    //查询所有
    @Override
    public void findAll() {
        JDBCInitUtail.resultSet("user_login", "");
    }

    // 查找
    @Override
    public void login(String name, String psw) {
        // JDBCInitUtail.resultSet("user_login", " WHERE name = '" + name + "' and passward= '" + psw + "'");
        JDBCInitUtail.resultSetPrepareStament("select * from user_login WHERE name = ? and passward= ? ", name, psw);
    }

    //增加
    @Override
    public void insert(String name, String psw) {
        JDBCInitUtail.statementPrepareStament("insert into user_login values (null,?,?)", name, psw);

    }

    @Override
    public void upData(String name, String psw) {

        JDBCInitUtail.statementPrepareStament("update user_login set name = ? where passward = ? ", name, psw);
    }

    //删除
    @Override
    public void delete(String name) {
        JDBCInitUtail.statementPrepareStament("delete from user_login where name=?", name, "");
    }

}
