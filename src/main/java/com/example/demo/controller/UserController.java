package com.example.demo.controller;

import com.example.demo.entity.JsonData;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {
    @Resource
    private UserMapper userMapper;
    @RequestMapping("findAll")
    public String findAll(Model model) {
        List<User> list = userMapper.findAll();
        model.addAttribute("list",list);
        return "list";
    }
    @RequestMapping("add")
    public String add(){
        return "add";
    }
    @RequestMapping("addUser")
    public String addUser(User user,Model model){
        try {
            userMapper.addUser(user);
            return "redirect:findAll";
        } catch (Exception e) {
        }
        model.addAttribute("msg","添加失败");
        return "add";
    }

    @RequestMapping("delete")
    public String  delUser(@RequestParam(name="id")int id) {
        try {
            userMapper.deleteUser(id);
            return "redirect:findAll";
        } catch (Exception e) {
            e.getMessage();
        }
          return "list";
    }
    @RequestMapping("update")
    public String update(User user){
        try {
            userMapper.updateUser(user);
            return "redirect:findAll";

        } catch (Exception e) {
        }
        return "list";

    }
    @RequestMapping("edit")
    public String edit(@RequestParam(name="id") Integer id,Model model){
        User user=userMapper.selectUserById(id);
        if(user!=null) {
            model.addAttribute("user", user);
            return "edit";
        }
        model.addAttribute("msg","编辑失败");
        return "list";

    }
}