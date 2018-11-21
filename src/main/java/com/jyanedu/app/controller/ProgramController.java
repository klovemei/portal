package com.jyanedu.app.controller;

import com.jyanedu.app.beans.*;
import com.jyanedu.app.dao.*;
import com.jyanedu.app.exception.DefException;
import com.jyanedu.app.exception.NoAuthException;
import com.jyanedu.app.module.GetProgramListByCatalogResp;
import com.jyanedu.app.module.GetProgramResp;
import com.jyanedu.app.module.UserProgramResp;
import com.jyanedu.app.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu_kai on 2018/2/1.
 */
@RestController
public class ProgramController {
    @Autowired
    ProgramDao programDao;
    @Autowired
    MovieDao movieDao;
    @Autowired
    VideoDao videoDao;
    @Autowired
    CatalogDao catalogDao;
    @Autowired
    TokenService tokenService;
    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/insert")
    public String insertOne(){
        Catalog catalog = new Catalog();
        catalog.setCatalogName("test");
        catalogDao.save(catalog);
        for(int p = 0;p<3;p++){
            Program program = new Program();
            program.setCatalogs(new ArrayList<>());
            program.getCatalogs().add(catalog);
            program.setDesc("programDesc"+p);
            program.setImgUrl("https://gw.alicdn.com/tfs/TB1vqF.PpXXXXaRaXXXXXXXXXXX-110-72.png");
            program.setMoney(p);
            program.setName("program"+p);
            programDao.save(program);
            for(int i=0;i<5;i++){
                Movie movie = new Movie();
                movie.setProgram(program);
                movie.setIndex(i);
                movie.setName("movie"+i);
                movieDao.save(movie);
                Video hd = new Video();
                hd.setMovie(movie);
                hd.setPlayUrl("http://60.205.201.186/live/cl008_1.m3u8");
                hd.setVideoType(VideoType.HD);
                videoDao.save(hd);
                Video md = new Video();
                md.setMovie(movie);
                md.setPlayUrl("http://60.205.201.186/live/cl008_1.m3u8");
                md.setVideoType(VideoType.MD);
                videoDao.save(md);
                Video ld = new Video();
                ld.setMovie(movie);
                ld.setPlayUrl("http://60.205.201.186/live/cl008_1.m3u8");
                ld.setVideoType(VideoType.LD);
                videoDao.save(ld);
            }
        }

        return "success";
    }
    @RequestMapping(value = "/getProgramInfo")
    public GetProgramResp getProgram(String programId, String movieId) throws DefException {
        GetProgramResp getProgramResp = new GetProgramResp();
        if(movieId!=null&&!movieId.trim().isEmpty()&&!movieId.equals("null")){
            //根据movie查询
             Movie movie = movieDao.findById(movieId).get();
             if(movie!=null) {
                 getProgramResp.setCurrMovie(movie);
                 getProgramResp.setProgram(movie.getProgram());
             }else {
                 throw new DefException();
             }
        }else if(programId!=null&&!programId.trim().isEmpty()&&!programId.equals("null")){
            Program program = programDao.findById(programId).get();
            if(program!=null){
                getProgramResp.setProgram(program);
                getProgramResp.setCurrMovie(program.getMovies().get(0));
                getProgramResp.setMovies(program.getMovies());
            }else {
                throw new DefException();
            }
        }else {
            throw new DefException();
        }
        return getProgramResp;
    }
    @RequestMapping(value = "/getProgramListByCatalogId")
    public GetProgramListByCatalogResp getProgramListByCatalog(String catalogId) throws DefException {
        GetProgramListByCatalogResp resp = new GetProgramListByCatalogResp();
        Catalog catalog = catalogDao.findById(catalogId).get();
        if(catalog==null)throw new DefException();
        List<Program> programs = programDao.findByCatalogsContains(catalog);
        resp.setCatalog(catalog);
        resp.setPrograms(programs);
        return resp;
    }
    @RequestMapping(value = "/getUserPrograms")
    public UserProgramResp getUserPrograms(String userId,HttpServletRequest request) throws DefException {
        if(!tokenService.checkToken(request)){
            throw new NoAuthException();
        }
        UserProgramResp userProgramResp = new UserProgramResp();
        User user = userDao.findById(userId).get();
        userProgramResp.setPrograms(user.getPrograms());
        return userProgramResp;
    }
}
