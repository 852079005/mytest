package cn.itlhd.service.impl;

import cn.itlhd.dao.AccountDao;
import cn.itlhd.dao.UserDao;
import cn.itlhd.entity.PageResult;
import cn.itlhd.pojo.User;
import cn.itlhd.service.UserService;
import cn.itlhd.utils.DateUtil2;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private AccountDao accountDao;



    //分页查询功能
    @Override
    public PageResult findPage(Integer currentPage, Integer pageSize, String queryString) {
        //使用和mybatis框架结合的PageHelper
        //设置分页参数
        PageHelper.startPage(currentPage, pageSize);

        //PageHelper提供的分页对象
        //条件查询
//        PageInfo pageInfo = new PageInfo();
        //Page<User> userPage = userDao.findAll();
        Page<User> userPage = userDao.selectByCondition(queryString);
        return new PageResult(userPage.getTotal(), userPage.getResult());
    }

    @Override
    public void add(User user) {
        try {
            //用户注册时间為系統当前时间
            Date date=new Date();

            //添加进user
            user.setBirthday(date);

        } catch (Exception e) {
            e.printStackTrace();
        }

        //调用dao层
        userDao.add(user);
    }

    //刪除用戶功能
    @Override
    public void delete(Integer id) {
        //調用dao层删除功能
        //首先如果用户关联了账户,先刪除用戶
        accountDao.delete(id);

        userDao.delete(id);
    }

    //修改用户信息
    @Override
    public void edit(User user) {
        userDao.edit(user);
    }

    //根據id查询用户
    @Override
    public User findById(Integer id) {
        return userDao.findUserById(id);
    }
}
