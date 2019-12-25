package com.hp.controller;

import com.hp.mapper.UserMapper;
import com.hp.pojo.User;
import com.hp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("word")
    @ResponseBody
    public String sayHello(){
        System.out.println("haha");
        return "success";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User queryUserById(@PathVariable("id") Long i){
        User u = userService.queryUserById(i);
        System.out.println("ccccc:"+u);
        return u;
    }

    @DeleteMapping("/del/{ids}")
    @ResponseBody
    public String deleteUserById(@PathVariable("ids") Long id){
        int x=userService.deleteUserById(id);
        if(x==1){
            return "success";
        }else{
            return "error";
        }
    }

    @GetMapping("/queryAll")
    public String queryAllUser(Model model){
        List<User> users=userService.queryAllUser();
        model.addAttribute("users",users);
        return "item";
    }
}
