package cn.itlhd.service;

import cn.itlhd.entity.PageResult;
import cn.itlhd.pojo.Account;

public interface AccountService {
    PageResult findPage(Integer currentPage, Integer pageSize, String queryString, String userId);

    void add(Account account, Integer id);

    void delete(Integer id);
}
