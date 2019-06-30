package cn.itlhd.dao;

import cn.itlhd.pojo.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDao {
    Admin findByUserAndPassword(@Param("adminName") String username, @Param("password")String password);
}
