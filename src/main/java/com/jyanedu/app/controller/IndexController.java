package com.jyanedu.app.controller;

import com.jyanedu.app.beans.tangram.BaseContainer;
import com.jyanedu.app.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by liu_kai on 2018/2/1.
 */
@RestController
public class IndexController {
    @Autowired
    IndexService indexService;
    @RequestMapping(value = "/index")
    public List<BaseContainer> getIndex(){
        return indexService.getIndex().getContainers();
    }
}
