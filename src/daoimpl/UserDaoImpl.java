package daoimpl;

import dao.UserDao;
import utail.JDBCInitUtail;

/*
 *
 *
 * */
public class UserDaoImpl implements UserDao {

    @Override
    public void findAll() {
        JDBCInitUtail.resultSet("user_login", "");
    }

    @Override
    public void login(String name, String psw) {
        JDBCInitUtail.resultSet("user_login", " WHERE name = '" + name + "' and passward= '" + psw + "'");

    }
}
