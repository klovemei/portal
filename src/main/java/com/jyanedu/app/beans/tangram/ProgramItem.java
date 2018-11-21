package com.jyanedu.app.beans.tangram;

import com.jyanedu.app.beans.Program;

/**
 * Created by liu_kai on 2018/2/9.
 */
public class ProgramItem extends BaseItem{
    private static final String type = "Program";
    private Program program;
    public ProgramItem() {
        super(type);
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
}
