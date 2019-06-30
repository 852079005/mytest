package cn.itlhd.dao;

import cn.itlhd.pojo.Account;
import com.github.pagehelper.Page;

public interface AccountDao {
    Page<Account> findAccountByUserid(int userId);

    void delete(Integer userId);

    void add(Account account);

    void deleteById(Integer id);
}
