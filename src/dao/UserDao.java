package dao;

/*
 * 定义操作数据库的接口
 * */
public interface UserDao {
    /*
     * 查询所有
     * */
    void findAll();

    /*
     * 查询
     * */
    void login(String name, String psw);

    /*
     *
     * 增加
     * */
    void insert(String name, String psw);

    /*
     * 更新
     * */
    void upData(String name, String psw);

    /*
     *
     * 删除
     * */
    void delete(String name);
}
