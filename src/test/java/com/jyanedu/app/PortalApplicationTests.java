package com.jyanedu.app;

import com.jyanedu.app.dao.CatalogDao;
import com.jyanedu.app.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PortalApplicationTests {
	@Autowired
	CatalogDao catalogDao;
	@Test
	public void contextLoads() {
	}

}
