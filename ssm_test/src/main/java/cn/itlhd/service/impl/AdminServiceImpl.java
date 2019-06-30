package cn.itlhd.service.impl;

import cn.itlhd.dao.AdminDao;
import cn.itlhd.pojo.Admin;
import cn.itlhd.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin login(String username, String password) {

        return adminDao.findByUserAndPassword(username,password);
    }
}
