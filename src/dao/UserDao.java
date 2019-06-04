package dao;

/*
 * 定义操作数据库的接口
 * */
public interface UserDao {
    /*
     * 查询所有
     * */
    void findAll();

    void login(String name ,String psw);
}
