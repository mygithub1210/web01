package com.atguigu.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @PreAuthorize("hasAuthority('add')")
    @RequestMapping("/add.do")
    public String add(){
        return "success";
    }

    @PreAuthorize("hasAuthority('delete')")
    @RequestMapping("/delete.do")
    public String delete(){
        return "success";
    }

    @PreAuthorize("hasAuthority('upload')")
    @RequestMapping("/upload.do")
    public String upload(){
        return "success";
    }
}
