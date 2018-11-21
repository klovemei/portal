package com.jyanedu.app.module;

import com.jyanedu.app.beans.Catalog;
import com.jyanedu.app.beans.Program;

import java.util.List;

/**
 * Created by liu_kai on 2018/2/7.
 */
public class GetProgramListByCatalogResp extends BaseResp{
    private Catalog catalog;
    private List<Program> programs;

    public List<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
}
