package com.fr.springbootdemo1.controller;

import com.fr.pojo.User;
import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author Fr
 * @Date 2019/12/18 20:48
 * @Version 1.0
 */
@RestController
@RequestMapping("ut")
public class UserSwaggerController {

    private List<User> listUser = Collections.synchronizedList(new ArrayList<User>());

    @InitBinder
    private void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addCustomFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
    }
    /***
    * 获取全部用户信息
    * @return
    */
    @GetMapping("/")
    @ApiOperation(value="查询所有用户信息", notes="查询所有用户信息")
    public List<User> getUserList() {
        return listUser;
    }

    /***
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping("/")
    @ApiOperation(value="新增用户信息", notes="根据输入信息新增用户信息")
    @ApiImplicitParam(name = "user", value = "用户信息", required = true, dataType
            = "User")
    public String save(User user){
        listUser.add(user);
        return "success";
    }

    /***
     * 根据id查询一个用户
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation(value="根据指定id查询用户信息", notes="根据id查询用户信息")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType
            = "Integer")
    public User getOneById(@PathVariable("id") Integer id){
        for(User user : listUser){
            if(user.getId()==id){
                return user;
            }
        }
        return null;
    }

    /***
     * 根据指定id更新用户信息
     * @param id
     * @param user
     * @return
     */

    @PutMapping("/{id}")
    @ApiOperation(value="更新指定id用户信息", notes="根据id更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true,
                    dataType = "Integer"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required
                    = true, dataType = "User")
    })
    public String update(@PathVariable("id") Integer id, User user){
        for(User user1 : listUser){
            if(user1.getId()==id){
                user1.setName(user.getName());
                user1.setBir(user.getBir());
                return "success";
            }
        }
        return "fail";
    }

    /***
     * 根据id删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value="删除指定id用户信息", notes="根据id删除用户信息")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType
            = "Integer")
    public String delete(@PathVariable("id") Integer id){
        for(User user2 : listUser){
            if(user2.getId()==id){
                listUser.remove(user2);
                return "success";
            }
        }
        return "fail";
    }



}
