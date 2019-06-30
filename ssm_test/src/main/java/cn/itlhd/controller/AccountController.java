package cn.itlhd.controller;

import cn.itlhd.entity.PageResult;
import cn.itlhd.entity.QueryPageBean;
import cn.itlhd.entity.Result;
import cn.itlhd.pojo.Account;
import cn.itlhd.pojo.User;
import cn.itlhd.service.AccountService;
import cn.itlhd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

   @RequestMapping(value = "/findPage")
    public PageResult findAll(@RequestBody QueryPageBean queryPageBean,String userId){
        //System.out.println(queryPageBean);
        //测试能取到前台数据
        //调用service层的分页功能
     PageResult pageResult=   accountService.findPage(
                queryPageBean.getCurrentPage(),
                queryPageBean.getPageSize(),
                queryPageBean.getQueryString(),
                userId
        );
        System.out.println(pageResult);

        return pageResult;
    }

    //添加账户
    @RequestMapping(value = "/add")
    public Result add(@RequestBody Account account,Integer id){
        System.out.println(account+"====="+id);

        //调用service层添加功能
        try {
            accountService.add(account,id);
        } catch (Exception e) {
            e.printStackTrace();
            //添加失敗
            return new Result(false,"添加用戶失敗");
        }

        //添加成功
        return new Result(true,"添加用户成功");
    }

    //删除用户
    @RequestMapping("/delete")
    public Result delete(Integer id){
        try {
            accountService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            //删除用户失败
            return new Result(false,"删除失败");
        }
        //刪除成功
        return new Result(true,"刪除成功");
    }



}
