package cn.itlhd.dao;

import cn.itlhd.pojo.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {

    //分页查询所有用户
    Page<User> selectByCondition(@Param("username")String queryString);

    //查询所有用户
    Page<User> findAll();

    User findUserById(int id);

    void add(User user);

    //删除账号
    void delete(Integer id);

    //修改用戶信息
    void edit(User user);
}
