package com.jyanedu.app.module;

import com.jyanedu.app.beans.Program;

import java.util.List;

/**
 * Created by liu_kai on 2018/3/7.
 */
public class UserProgramResp extends BaseResp{
    private List<Program> programs;

    public List<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }
}
