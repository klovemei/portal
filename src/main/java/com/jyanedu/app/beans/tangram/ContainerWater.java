package com.jyanedu.app.beans.tangram;

/**
 * Created by liu_kai on 2018/2/9.
 */
public class ContainerWater extends BaseContainer{
    private static final String type = "container-waterfall";
    private Style style = new Style();
    public ContainerWater() {
        super(type);
    }

    public ContainerWater(String id) {
        super(type, id);
    }

    public ContainerWater(String id,int column) {
        super(type, id);
        style.setColumn(column);
    }
    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public class Style{
        private int column=1;
        private int vGap = 10;
        private int hGap = 10;

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

        public int getColumn() {
            return column;
        }

        public void setColumn(int column) {
            this.column = column;
        }
    }
}
