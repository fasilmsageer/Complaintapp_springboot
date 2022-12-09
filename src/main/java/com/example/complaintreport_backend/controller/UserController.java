package com.example.complaintreport_backend.controller;

import com.example.complaintreport_backend.dao.UserDao;
import com.example.complaintreport_backend.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDao udao;



    @PostMapping(path = "/userreg", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> Userregistration(@RequestBody UserDetails u){
        HashMap<String, String> str = new HashMap<>();
        List<UserDetails> result = (List<UserDetails>) udao.FindUser(u.getUsername());
        if(result.size() !=0){
            str.put("status","failed");
        }else{
            udao.save(u);
            str.put("status","success");
        }
        return str;
    }

    @PostMapping(path = "/userLogin", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> Userlogin(@RequestBody UserDetails u){
        List<UserDetails> result = (List<UserDetails>) udao.UserLogin(u.getUsername(), u.getPassword());
        HashMap<String, String> str = new HashMap<>();
        if(result.size() == 0){
            str.put("status","failed");
        }else{
            str.put("status","success");
        }
        return str;
    }

}
