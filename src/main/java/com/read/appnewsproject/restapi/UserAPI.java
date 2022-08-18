package com.read.appnewsproject.restapi;

import com.read.appnewsproject.restapi.responeobject.ResponeObject;
import com.read.appnewsproject.services.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class UserAPI extends ParentAPI{
    @Autowired
    private IUserServices services;

    @GetMapping("/get-All")
    public ResponeObject adminManagement(
                                  @RequestParam(required = false,defaultValue = "0") Integer page,
                                  @RequestParam(defaultValue = "10",required = false) Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        return new ResponeObject(new Date(),200,"Ok",services.getAllUser(pageable));
    }

}
