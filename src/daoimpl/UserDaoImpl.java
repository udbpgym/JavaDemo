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
        JDBCInitUtail.resultSet("user_login");
    }
}
