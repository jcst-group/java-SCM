package com.nongxin.terminal.controller.backstage.file;

import com.nongxin.terminal.service.file.PictureInfoService;
import com.nongxin.terminal.util.ImgUpload;
import com.nongxin.terminal.util.enumUtil.file.ImgRelationTypeEnum;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.File;

@RestController
@RequestMapping("/pictureInfo")
public class PictureInfoController {

    @Autowired
    private PictureInfoService pictureInfoService;
    @Autowired
    private ImgUpload imgUpload;

    private final ResourceLoader resourceLoader;
    @Autowired
    public PictureInfoController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    //tb：Thumbnails压缩方法，4：压缩之后的质量为0.4
    private final String suffix = "_gzip4tb";

    @GetMapping("/delete")
    @ApiOperation("删除图片")
    public Result deletePic(@RequestParam(required = true)Integer id){
        Result result = new Result();
        boolean isSuccess = pictureInfoService.delete(id);
        if (isSuccess){
            result.setMessage("删除图片成功");
        }else {
            result.setMessage("删除图片失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/addUserHeadPic")
    @ApiOperation("添加用户头像图片")
    public Result addUserHeadPic(MultipartFile file, Integer recordId){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.USER_HEAD);
    }

    @PostMapping("/addUserHukouPic")
    @ApiOperation("添加用户户口图片")
    public Result addUserHukouPic(MultipartFile file, Integer recordId){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.USER_HUKOU);
    }

    @PostMapping("/addIdentifyCodePic")
    @ApiOperation("添加身份证图片")
    public Result addIdentifyCodePic(MultipartFile file, Integer recordId){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.IDENTIFY_CODE);
    }

    @PostMapping("/addBasePic")
    @ApiOperation("添加基地图片")
    public Result addBasePic(MultipartFile file, Integer recordId){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.BASE);
    }






    @PostMapping("/addSoilPic")
    @ApiOperation("添加土壤图片")
    public Result addSoilPic(MultipartFile file,Integer recordId,Integer type){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.SOIL);
    }

    @PostMapping("/addAirPic")
    @ApiOperation("添加大气图片")
    public Result addAirPic(MultipartFile file,Integer recordId,Integer type){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.AIR);
    }

    @PostMapping("/addWaterPic")
    @ApiOperation("添加水源图片")
    public Result addWaterPic(MultipartFile file,Integer recordId,Integer type){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.WATER);
    }

    @PostMapping("/addCropPic")
    @ApiOperation("添加作物图片")
    public Result addCropPic(MultipartFile file,Integer recordId,Integer type){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.CROP);
    }

    @PostMapping("/addEdibleValuePic")
    @ApiOperation("添加食用价值图片")
    public Result addEdibleValuePic(MultipartFile file,Integer recordId,Integer type){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.EDIBLE_VALUE);
    }

    @PostMapping("/addMedicinalValuePic")
    @ApiOperation("添加药用价值图片")
    public Result addMedicinalValuePic(MultipartFile file,Integer recordId,Integer type){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.MEDICINAL_VALUE);
    }

    @PostMapping("/addFarmingItemPic")
    @ApiOperation("添加农事项目指导图片")
    public Result addFarmingPic(MultipartFile file,Integer recordId,Integer type){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.FARMING_ITEM);
    }

    @PostMapping("/addMaterialPic")
    @ApiOperation("添加物料信息图片")
    public Result addMaterialPic(MultipartFile file,Integer recordId,Integer type){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.MATERIALINFO);
    }

    @PostMapping("/addOrderPic")
    @ApiOperation("添加工单图片")
    public Result addOrderPic(MultipartFile file,Integer recordId,Integer type){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.WORKORDER);
    }

    @PostMapping("/addSeedDetectionPic")
    @ApiOperation("添加种子/种苗检测图片")
    public Result addSeedDetectionPic(MultipartFile file,Integer recordId,Integer type){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.SEED_DETECTION);
    }

    @PostMapping("/addSeedDetectionResultPic")
    @ApiOperation("添加种子/种苗检测报告图片")
    public Result addSeedDetectionResultPic(MultipartFile file,Integer recordId,Integer type){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.SEED_DETECTION_RESULT);
    }

    @PostMapping("/addRecDetectionPic")
    @ApiOperation("添加采收检测图片")
    public Result addRecDetection(MultipartFile file,Integer recordId,Integer type){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.RECOVERY_DETECTION);
    }

    @PostMapping("/addRecDetectionResultPic")
    @ApiOperation("添加采收检测结果图片")
    public Result addRecDetectionResultPic(MultipartFile file,Integer recordId,Integer type){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.RECOVERY_DETECTION_RESULT);
    }

    @PostMapping("/addInitProDetectionPic")
    @ApiOperation("添加初加工检测图片")
    public Result addInitProDetectionPic(MultipartFile file,Integer recordId,Integer type){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.INITPRO_DETECTION);
    }



    @PostMapping("/addProCropPic")
    @ApiOperation("添加溯源药材图片")
    public Result addProCropPic(MultipartFile file,Integer recordId,Integer type){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.PRO_CROP);
    }

    @PostMapping("/addProEdiblePic")
    @ApiOperation("添加溯源食用价值图片")
    public Result addProEdiblePic(MultipartFile file,Integer recordId,Integer type){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.PRO_EDIBLE_VALUE);
    }

    @PostMapping("/addProMedicinalPic")
    @ApiOperation("添加溯源药用价值图片")
    public Result addProMedicinalPic(MultipartFile file,Integer recordId,Integer type){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.PRO_MEDICINAL_VALUE);
    }

    @PostMapping("/addLotPic")
    @ApiOperation("添加地块图片")
    public Result addLotPic(MultipartFile file,Integer recordId){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.LOT);
    }

    @PostMapping("/addIllPic")
    @ApiOperation("添加病虫害图片")
    public Result addIllPic(MultipartFile file,Integer recordId){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.ILL);
    }

    @PostMapping("/addTreatmentPic")
    @ApiOperation("添加指导方法图片")
    public Result addTreatmentPic(MultipartFile file,Integer recordId){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.TREATMENT_GUI);
    }

    @PostMapping("/addBasePurchasePic")
    @ApiOperation("添加订单基地采购合同图片")
    public Result addBasePurchasePic(MultipartFile file,Integer recordId){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.BASE_PURCHASE);
    }

    @PostMapping("/addStandardPlanPic")
    @ApiOperation("添加规范化种植图片")
    public Result addStandardPlan(MultipartFile file,Integer recordId){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.STANDARD_PLAN);
    }

    @PostMapping("/addFertilizerPurchasePic")
    @ApiOperation("添加肥料采购合同图片")
    public Result addFertilizerPurchase(MultipartFile file,Integer recordId){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.FERTILEZER_PURCHASE);
    }

    @PostMapping("/addLaborDispatchPic")
    @ApiOperation("添加劳务派遣合同图片")
    public Result addLaborDispatchPic(MultipartFile file,Integer recordId){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.LABOR_DISPATCH);
    }

    @PostMapping("/addOrderContractPic")
    @ApiOperation("添加订单合同图片")
    public Result addOrderContractPic(MultipartFile file,Integer recordId){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.ORDER_CONTRACT);
    }

    @PostMapping("/addInsuranceContractPic")
    @ApiOperation("添加保险合同图片")
    public Result addInsuranceContractPic(MultipartFile file,Integer recordId){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.INSURANCE_CONTRACT);
    }

    @PostMapping("/addPledgeGoodsPic")
    @ApiOperation("添加质押物权图片")
    public Result addPledgeGoodsPic(MultipartFile file,Integer recordId){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.PLEDGE_GOODS);
    }

    @PostMapping("/addLoanContractPic")
    @ApiOperation("添加贷款图片")
    public Result addLoanContractPic(MultipartFile file,Integer recordId){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.LOAN_CONTRACT);
    }




    /**
     * 显示单张图片(本地，rest请求)
     * @return
     */
    @GetMapping(value="/show/{fileName}")
    @ApiOperation(value = "查看本地图片",notes = "根据文件名查看图片")
    public ResponseEntity showPhoto(@PathVariable String fileName){
        try {
            String compressionFileName = fileName.substring(0,fileName.lastIndexOf("."))+suffix+"."+fileName.substring(fileName.lastIndexOf(".")+1);
            String compressionPath = imgUpload.getPath(compressionFileName);
            File compressionPic = new File(compressionPath);
            if (!compressionPic.exists()){
                File saveFile = new File(compressionPath);
                File oldFile = new File(imgUpload.getPath(fileName));
                if (oldFile.length()/ 1024>200){
                    float quality = 0.4f;
                    ByteArrayOutputStream byteArrayOutputStreamut = new ByteArrayOutputStream();
                    Thumbnails.of(oldFile)
                            .scale(1f)//放大还是缩小
                            .outputQuality(quality)//图片质量
                            .outputFormat("jpg")
                            .toOutputStream(byteArrayOutputStreamut);
                    FileCopyUtils.copy(byteArrayOutputStreamut.toByteArray(), saveFile);
                    return ResponseEntity.ok(byteArrayOutputStreamut.toByteArray());
                }else{
                    return ResponseEntity.ok(resourceLoader.getResource("file:" + imgUpload.getPath(fileName)));
                }
            }
            return ResponseEntity.ok(resourceLoader.getResource("file:" + compressionPath));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * 显示单张图片(本地，rest请求，压缩)
     * @return
     */
    @GetMapping(value="/show/compression/{fileName}/{width}/{height}")
    @ApiOperation(value = "查看本地压缩图片",notes = "根据文件名查看图片")
    public ResponseEntity showCompressionPhoto(@PathVariable String fileName,@PathVariable Integer width,@PathVariable Integer height){
        try {
            ByteArrayOutputStream byteArrayOutputStreamut = new ByteArrayOutputStream();
            Thumbnails.of(imgUpload.getPath(fileName))
                    .size(width,height)    //图片尺寸
                    .outputQuality(1f)      //图片质量
                    .toOutputStream(byteArrayOutputStreamut);
            //LOGGER.info("压缩后文件大小：" + byteArrayOutputStreamut.toByteArray().length / 1024 + "kb;");
            return ResponseEntity.ok(byteArrayOutputStreamut.toByteArray());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * 显示单张图片(本地，rest请求，压缩)
     * @return
     */
    @GetMapping(value="/show/compression/{fileName}")
    @ApiOperation(value = "查看本地压缩图片",notes = "根据文件名查看图片")
    public ResponseEntity showCompressionPic(@PathVariable String fileName){
        try {
            String compressionFileName = fileName.substring(0,fileName.lastIndexOf("."))+suffix+"."+fileName.substring(fileName.lastIndexOf(".")+1);
            String compressionPath = imgUpload.getPath(compressionFileName);
            File compressionPic = new File(compressionPath);
            if (!compressionPic.exists()){
                File saveFile = new File(compressionPath);
                File oldFile = new File(imgUpload.getPath(fileName));
                if (oldFile.length()/ 1024>200){
                    float quality = 0.4f;
                    ByteArrayOutputStream byteArrayOutputStreamut = new ByteArrayOutputStream();
                    Thumbnails.of(oldFile)
                            .scale(1f)//放大还是缩小
                            .outputQuality(quality)//图片质量
                            .outputFormat("jpg")
                            .toOutputStream(byteArrayOutputStreamut);
                    FileCopyUtils.copy(byteArrayOutputStreamut.toByteArray(), saveFile);
                    return ResponseEntity.ok(byteArrayOutputStreamut.toByteArray());
                }else{
                    return ResponseEntity.ok(resourceLoader.getResource("file:" + imgUpload.getPath(fileName)));
                }
            }
            return ResponseEntity.ok(resourceLoader.getResource("file:" + compressionPath));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
