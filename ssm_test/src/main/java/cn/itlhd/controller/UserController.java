package cn.itlhd.controller;

import cn.itlhd.entity.PageResult;
import cn.itlhd.entity.QueryPageBean;
import cn.itlhd.entity.Result;
import cn.itlhd.pojo.User;
import cn.itlhd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

   @RequestMapping(value = "/findPage")
    public PageResult findAll(@RequestBody QueryPageBean queryPageBean){
        //System.out.println(queryPageBean);
        //测试能取到前台数据
        //调用service层的分页功能
     PageResult pageResult=   userService.findPage(
                queryPageBean.getCurrentPage(),
                queryPageBean.getPageSize(),
                queryPageBean.getQueryString()
        );
        System.out.println(pageResult);

        return pageResult;
    }

    //添加用户
    @RequestMapping(value = "/add")
    public Result add(@RequestBody User user){
        System.out.println(user);

        //调用service层添加功能
        try {
            userService.add(user);
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
            userService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            //删除用户失败
            return new Result(false,"删除失败");
        }
        //刪除成功
        return new Result(true,"刪除成功");
    }

    //根据ID查询用户信息
    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public Result findById(Integer id) {
        try {
            User user = userService.findById(id);
            return new Result(true, "查詢用戶成功",user);
        }catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"查詢用戶失敗" );
        }
    }

    //更新用戶
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public Result edit(@RequestBody User user) {
        try {
            userService.edit(user);
            return new Result(true, "修改用户信息成功");
        }catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改用户信息失败");
        }
    }

}
