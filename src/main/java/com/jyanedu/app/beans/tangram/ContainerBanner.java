package com.jyanedu.app.beans.tangram;

/**
 * Created by liu_kai on 2018/2/8.
 */
public class ContainerBanner extends BaseContainer{
    private static final String type = "container-banner";
    private Style style = new Style();
    public ContainerBanner(){
        super(type);
    }
    public ContainerBanner(String id) {
        super(type,id);
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public class Style{

        private String indicatorImg1 = "https://gw.alicdn.com/tps/TB16RaxLpXXXXbIXFXXXXXXXXXX-14-14.png";
        private String indicatorImg2 = "https://gw.alicdn.com/tps/TB1m79uLpXXXXXUXVXXXXXXXXXX-18-16.png";

        public String getIndicatorImg1() {
            return indicatorImg1;
        }

        public void setIndicatorImg1(String indicatorImg1) {
            this.indicatorImg1 = indicatorImg1;
        }

        public String getIndicatorImg2() {
            return indicatorImg2;
        }

        public void setIndicatorImg2(String indicatorImg2) {
            this.indicatorImg2 = indicatorImg2;
        }

        public String getIndicatorPosition() {
            return indicatorPosition;
        }

        public void setIndicatorPosition(String indicatorPosition) {
            this.indicatorPosition = indicatorPosition;
        }

        public String getIndicatorGravity() {
            return indicatorGravity;
        }

        public void setIndicatorGravity(String indicatorGravity) {
            this.indicatorGravity = indicatorGravity;
        }

        public int getIndicatorMargin() {
            return indicatorMargin;
        }

        public void setIndicatorMargin(int indicatorMargin) {
            this.indicatorMargin = indicatorMargin;
        }

        public int getIndicatorGap() {
            return indicatorGap;
        }

        public void setIndicatorGap(int indicatorGap) {
            this.indicatorGap = indicatorGap;
        }

        public int getScrollMarginLeft() {
            return scrollMarginLeft;
        }

        public void setScrollMarginLeft(int scrollMarginLeft) {
            this.scrollMarginLeft = scrollMarginLeft;
        }

        public int getScrollMarginRight() {
            return scrollMarginRight;
        }

        public void setScrollMarginRight(int scrollMarginRight) {
            this.scrollMarginRight = scrollMarginRight;
        }

        public int gethGap() {
            return hGap;
        }

        public void sethGap(int hGap) {
            this.hGap = hGap;
        }

        public int getPageRatio() {
            return pageRatio;
        }

        public void setPageRatio(int pageRatio) {
            this.pageRatio = pageRatio;
        }

        private String indicatorPosition = "inside";
        private String indicatorGravity = "center";
        private int indicatorMargin = 10;
        private int indicatorGap= 2;
        private int scrollMarginLeft= 0;
        private int scrollMarginRight= 0;
        private int hGap = 0;
        private int pageRatio = 1;
        private int autoScroll = 2000;

        public int getAutoScroll() {
            return autoScroll;
        }

        public void setAutoScroll(int autoScroll) {
            this.autoScroll = autoScroll;
        }
    }
}
