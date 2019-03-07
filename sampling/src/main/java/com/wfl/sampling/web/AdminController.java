package com.wfl.sampling.web;

import com.wfl.sampling.entity.Admin;
import com.wfl.sampling.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @ Author     ：wfl
 * @ Date       ：Created in 16:15 2018/12/20
 * @ Description：
 * @ Modified By：
 */

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/")
    public String login(){
        return "redirect:/admin/login";
    }


    /**
     * 登录跳转
     *
     * @param model
     * @return
     */

    @GetMapping("/admin/login")
    public String loginGet(Model model) {
        return "login";
    }

    /**
     * 登录
     */
    @PostMapping("/admin/login")
    public String loginPost(Admin admin, Model model, HttpSession httpSession) {
        Admin adminRes = adminService.findAdmin(admin);
        if (adminRes != null) {
            System.out.println(adminRes.getAge());
            httpSession.setAttribute("admin", adminRes);
            return "redirect:orderManage_0_0_0";
        } else {
            model.addAttribute("error", "用户名或密码错误，请重新登录！");
            return "login";
        }
    }

    /**
     * 注册
     *
     * @param model
     * @return
     */
    @GetMapping("/admin/register")
    public String register(Model model) {
        System.out.println("get");
        return "register";
    }

    @PostMapping("/admin/register")
    public String registers(Admin admin, Model model, HttpSession httpSession) {
        //判断后台是否已经有这个用户了
        Admin hasExisted = adminService.hasExisted(admin);
        if (hasExisted != null) {
            model.addAttribute("error", "用户名已存在！");
            return "register";
        }else{
            adminService.addAdmin(admin);
            model.addAttribute("success","注册成功");


            return "register";
        }
    }

    /**
     * 仪表板页面
     *
     * @param model
     * @return
     */
    @GetMapping("/admin/dashboard")
    public String dashboard(Model model) {
        return "dashboard";
    }

    @GetMapping("/admin/editPassword")
    public String editPassword(Model model) {
        return "editPassword";
    }

    @PostMapping("/admin/editPassword")
    public String modifyPassword(Admin admin, Model model, HttpSession httpSession) {
        System.out.println(admin);
        Admin adminRes = adminService.findAdmin(admin);

        if (adminRes != null) {
            adminRes.setPassword(admin.getNewPassword());
            adminRes.setUpdateDate(new Date());
            adminService.modifyAdmin(adminRes);
            return "login";
        } else {
            model.addAttribute("error", "查无此账号！");
            return "editPassword";
        }
    }
}
