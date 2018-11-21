package com.jyanedu.app.controller;

import com.jyanedu.app.beans.Catalog;
import com.jyanedu.app.beans.Program;
import com.jyanedu.app.common.StaticProp;
import com.jyanedu.app.dao.CatalogDao;
import com.jyanedu.app.dao.ProgramDao;
import com.jyanedu.app.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liu_kai on 2018/2/11.
 */
@Controller
public class AdminController {
    @Autowired
    CatalogDao catalogDao;
    @Autowired
    ImgService imgService;
    @Autowired
    ProgramDao programDao;
    @RequestMapping(value = "/admin/catalogList")
    public String catalogList(Model model){
        model.addAttribute("catalogs",catalogDao.findByIdNotNullOrderByIdAsc());
        return "catalogList";
    }
    @RequestMapping(value = "/admin/catalogEdit")
        public String catalogEdit(String catalogId,Model model){
        if(catalogId!=null){
            model.addAttribute("catalog",catalogDao.getOne(catalogId));
        }else {
            model.addAttribute("catalog",new Catalog());
        }
        model.addAttribute("imgStart", StaticProp.imgUrl);
        return "catalogEdit";
    }
    @RequestMapping(value = "/admin/catalogUpdate")
    public String catalogUpdate(MultipartFile file,String catalogId, String catalogName, Model model) throws IOException {
        Catalog catalog;
        if(catalogId==null||catalogId.trim().equals("")){
            catalog = new Catalog();
        }else {
            catalog = catalogDao.getOne(catalogId);
        }
        catalog.setCatalogName(catalogName);
        if(file!=null){
            String imgUrl = imgService.uploadFile(file);
            if(imgUrl!=null){
                String oldImgUrl = catalog.getCatalogImgUrl();
                imgService.delImgFile(oldImgUrl);
                catalog.setCatalogImgUrl(imgUrl);
            }
        }
        catalogDao.save(catalog);
        model.addAttribute("catalog",catalog);
        model.addAttribute("success",true);
        model.addAttribute("imgStart", StaticProp.imgUrl);
        return "catalogEdit";
    }
    @RequestMapping(value = "/admin/get_program.do")
    public @ResponseBody Object getProgram(int page,int rows){
        if(page==0)page=1;
        Page<Program> programs = programDao.findAll(PageRequest.of(page-1,rows));
        Map<String,Object> result = new HashMap<>();
        result.put("total",programs.getTotalElements());
        result.put("rows",programs.getContent());
        return result;
    }
    @RequestMapping(value = "/admin/save_program.do")
    public @ResponseBody Object saveProgram(Program program){
        program = programDao.saveAndFlush(program);
        return program;
    }
    @RequestMapping(value = "/admin/update_program.do")
    public @ResponseBody Object updateProgram(String id,String name,String desc,String imgUrl,int money){
        Program program = programDao.getOne(id);
        program.setName(name);
        program.setDesc(desc);
        program.setImgUrl(imgUrl);
        program.setMoney(money);
        program = programDao.saveAndFlush(program);
        return program;
    }
    @RequestMapping(value = "/admin/del_program.do")
    public @ResponseBody Object delProgram(String id){
        programDao.deleteById(id);
        return true;
    }
    @RequestMapping(value = "/admin/get_catalog.do")
    public @ResponseBody Object getCatalog(int page,int rows){
        if(page==0)page=1;
        Page<Catalog> catalogs = catalogDao.findAll(PageRequest.of(page-1,rows));
        Map<String,Object> result = new HashMap<>();
        result.put("total",catalogs.getTotalElements());
        result.put("rows",catalogs.getContent());
        return result;
    }
    @RequestMapping(value = "/admin/del_catalog.do")
    public @ResponseBody Object delCatalog(String id){
        catalogDao.deleteById(id);
        return true;
    }
    @RequestMapping(value = "/admin/update_catalog.do")
    public @ResponseBody Object updateCatalog(String id,String catalogName,String catalogImgUrl){
        Catalog catalog = catalogDao.getOne(id);
        catalog.setCatalogName(catalogName);
        catalog.setCatalogImgUrl(catalogImgUrl);
        catalog = catalogDao.saveAndFlush(catalog);
        return catalog;
    }
    @RequestMapping(value = "/admin/save_catalog.do")
    public @ResponseBody Object saveCatalog(String catalogName,String catalogImgUrl){
        Catalog catalog = new Catalog();
        catalog.setCatalogName(catalogName);
        catalog.setCatalogImgUrl(catalogImgUrl);
        catalog = catalogDao.saveAndFlush(catalog);
        return catalog;
    }
}
