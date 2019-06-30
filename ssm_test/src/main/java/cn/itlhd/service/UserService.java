package cn.itlhd.service;

import cn.itlhd.entity.PageResult;
import cn.itlhd.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {



    PageResult findPage(Integer currentPage, Integer pageSize, String queryString);


    void add(User user);

    void delete(Integer id);

    void edit(User user);

    User findById(Integer id);
}
