package com.jyanedu.app.beans.tangram;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu_kai on 2018/2/8.
 */
public class ContainerFlow extends BaseContainer{
    private static final String type="container-flow";

    public ContainerFlow() {
        super(type);
    }

    public ContainerFlow(String id, int colCount) {
        super(type,id);
        int k = 100/colCount;
        for(int i=0;i<colCount-1;i++){
            this.cols.add(k);
        }
    }
    private List<Integer> cols = new ArrayList<>();
    private int vGap = 0;
    private int hGap = 0;

    public int getvGap() {
        return vGap;
    }

    public void setvGap(int vGap) {
        this.vGap = vGap;
    }

    public int gethGap() {
        return hGap;
    }

    public void sethGap(int hGap) {
        this.hGap = hGap;
    }

    public List<Integer> getCols() {
        return cols;
    }

    public void setCols(List<Integer> cols) {
        this.cols = cols;
    }
}
