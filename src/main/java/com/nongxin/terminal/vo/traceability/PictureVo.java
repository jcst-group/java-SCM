package com.nongxin.terminal.vo.traceability;

import com.nongxin.terminal.entity.file.PictureInfo;

public class PictureVo {

    //土壤检测图片
    private PictureInfo soilPic;

    //大气检测图片
    private PictureInfo airPic;

    //水源检测图片
    private PictureInfo waterPic;

    //种子种苗检测图片
    private PictureInfo seedDetectionPic;

    //采收检测图片
    private PictureInfo recDetectionPic;

    //初加工检测图片
    private PictureInfo initDetectionPic;

    public PictureInfo getRecDetectionPic() {
        return recDetectionPic;
    }

    public void setRecDetectionPic(PictureInfo recDetectionPic) {
        this.recDetectionPic = recDetectionPic;
    }

    public PictureInfo getInitDetectionPic() {
        return initDetectionPic;
    }

    public void setInitDetectionPic(PictureInfo initDetectionPic) {
        this.initDetectionPic = initDetectionPic;
    }

    public PictureInfo getSoilPic() {
        return soilPic;
    }

    public void setSoilPic(PictureInfo soilPic) {
        this.soilPic = soilPic;
    }

    public PictureInfo getAirPic() {
        return airPic;
    }

    public void setAirPic(PictureInfo airPic) {
        this.airPic = airPic;
    }

    public PictureInfo getWaterPic() {
        return waterPic;
    }

    public void setWaterPic(PictureInfo waterPic) {
        this.waterPic = waterPic;
    }

    public PictureInfo getSeedDetectionPic() {
        return seedDetectionPic;
    }

    public void setSeedDetectionPic(PictureInfo seedDetectionPic) {
        this.seedDetectionPic = seedDetectionPic;
    }
}
