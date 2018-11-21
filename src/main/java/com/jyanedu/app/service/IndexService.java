package com.jyanedu.app.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jyanedu.app.beans.*;
import com.jyanedu.app.beans.tangram.*;
import com.jyanedu.app.dao.MongoDao;
import com.jyanedu.app.dao.ProgramDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by liu_kai on 2018/2/8.
 */
@Service
public class IndexService {
    @Autowired
    private MongoDao mongoDao;
    @Autowired
    private ProgramDao programDao;
    private static Page index;
    public void init(){
//        index = mongoDao.getPage("index");
        if(index==null){
            indexBuild();
//            mongoDao.saveObject(index);
        }
    }
    private void indexBuild(){
        index = new Page("index");
        ContainerBanner top = new ContainerBanner("top");
        index.getContainers().add(top);
        for(int i=0;i<5;i++){
            ImgItem imgItem = new ImgItem();
            imgItem.setImgUrl("https://gw.alicdn.com/tfs/TB1vqF.PpXXXXaRaXXXXXXXXXXX-110-72.png");
            imgItem.setIsMaxWidth(1);
            imgItem.setRatio(1.78);
            imgItem.setOnclick("program");
            imgItem.setOnclickId("926adcf3-1a4d-4ba8-b220-079fde26026a");
            top.getItems().add(imgItem);
        }
        ContainerWater catalogs = new ContainerWater("catalogs",4);
        index.getContainers().add(catalogs);
        for(int i=0;i<8;i++){
            ItemImgText itemImgText = new ItemImgText();
            itemImgText.setImgUrl("https://gw.alicdn.com/tfs/TB1vqF.PpXXXXaRaXXXXXXXXXXX-110-72.png");
            itemImgText.setText("catalog"+i);
            itemImgText.setOnclick("catalog");
            itemImgText.setOnclickId("615ef0fa-3983-4052-b19d-e6e23e272e1a");
            catalogs.getItems().add(itemImgText);
        }
        ContainerOneColumn details = new ContainerOneColumn("details");
        index.getContainers().add(details);
        for(int i=0;i<3;i++){
            SplitItem splitItem = new SplitItem();
            splitItem.setText("catalog"+i);
            splitItem.setOnclick("catalog");
            splitItem.setOnclickId("615ef0fa-3983-4052-b19d-e6e23e272e1a");
            details.getItems().add(splitItem);
            for(int k=0;k<4;k++){
                ProgramItem programItem = new ProgramItem();
                Program program = programDao.findById("926adcf3-1a4d-4ba8-b220-079fde26026a").get();
                try {
                    programItem.setProgram(program);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                details.getItems().add(programItem);
            }
        }
    }
    public Page getIndex(){
        return index;
    }
}
