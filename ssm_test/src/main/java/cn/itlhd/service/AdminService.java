package cn.itlhd.service;

import cn.itlhd.pojo.Admin;

public interface AdminService {
    Admin login(String username, String password);
}
