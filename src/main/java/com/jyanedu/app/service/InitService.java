package com.jyanedu.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by liu_kai on 2018/2/8.
 */
@Component
public class InitService implements CommandLineRunner{
    @Autowired
    IndexService indexService;
    @Override
    public void run(String... strings) throws Exception {
        indexService.init();
    }
}
