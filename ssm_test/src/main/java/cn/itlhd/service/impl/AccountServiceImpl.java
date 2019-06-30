package cn.itlhd.service.impl;

import cn.itlhd.dao.AccountDao;
import cn.itlhd.entity.PageResult;
import cn.itlhd.pojo.Account;
import cn.itlhd.service.AccountService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public PageResult findPage(Integer currentPage, Integer pageSize, String queryString, String userIdStr) {
        //使用和mybatis框架结合的PageHelper
        //设置分页参数
        PageHelper.startPage(currentPage, pageSize);

        //PageHelper提供的分页对象
        int userId=Integer.parseInt(userIdStr);
        Page<Account> accountPage=accountDao.findAccountByUserid(userId);

        return new PageResult(accountPage.getTotal(),accountPage.getResult());
    }

    @Override
    public void add(Account account, Integer userId) {
        account.setUserId(userId);

        //调用dao层
        accountDao.add (account);
    }

    @Override
    public void delete(Integer id) {
        accountDao.deleteById(id);
    }
}
