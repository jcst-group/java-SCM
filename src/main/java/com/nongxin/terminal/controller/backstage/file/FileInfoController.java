package com.nongxin.terminal.controller.backstage.file;

import com.nongxin.terminal.entity.file.FileInfo;
import com.nongxin.terminal.service.file.FileInfoService;
import com.nongxin.terminal.util.FileUpload;
import com.nongxin.terminal.util.enumUtil.file.FileRelationTypeEnum;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/fileInfo")
public class FileInfoController {

    @Autowired
    private FileUpload fileUpload;
    @Autowired
    private FileInfoService fileInfoService;

    /*@PostMapping("/uploadSeedFile")
    @ApiOperation(value = "上传种子检测文件")
    public Result uploadSeedFile(@RequestParam("file") MultipartFile file, FileInfo fileInfo){
        short status = 1;
        fileInfo.setStatus(status);
        fileInfo.setRelationType(FileRelationTypeEnum.SEED_DETECTION);
        Result result = fileInfoService.insertFile(file,fileInfo);
        return result;
    }*/

    /*@PostMapping("/uploadMaterialFile")
    @ApiOperation(value = "上传物料信息文件")
    public Result uploadMaterialFile(@RequestParam("file") MultipartFile file, FileInfo fileInfo){
        short status = 1;
        fileInfo.setStatus(status);
        fileInfo.setRelationType(FileRelationTypeEnum.MATERIALINFO);
        Result result = fileInfoService.insertFile(file,fileInfo);
        return result;
    }*/

    @PostMapping("/uploadOrderFile")
    @ApiOperation(value = "上传工单音频")
    public Result uploadSeedFile(@RequestParam("file") MultipartFile file){
        FileInfo fileInfo = new FileInfo();
        fileInfo.setStatus((short)1);
        fileInfo.setRelationType(FileRelationTypeEnum.WORKORDER);
        Result result = fileInfoService.insertFile(file,fileInfo);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation(value = "删除文件",notes = "删除文件")
    public Result deleteFileInfo(@RequestParam(required = true)Integer id){
        Result result = new Result();
        boolean isSuccess = fileInfoService.deleteByPrimaryKey(id);
        if (isSuccess){
            result.setMessage("删除成功");
        }else{
            result.setMessage("删除失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/downFile")
    @ApiOperation(value = "文件下载",notes = "根据传入文件的路径下载文件")
    public void downBatchFile(@RequestParam(required = true) String fileUrl,@RequestParam(required = true) String fileName,
                              HttpServletResponse response){
        fileUpload.downloadFile(fileUrl,fileName,response);
    }

    @GetMapping("/getAudio")
    @ApiOperation(value = "音频播放")
    public void getAudio(@RequestParam(required = true) String fileUrl,
                         HttpServletResponse response) throws Exception {
        fileUpload.getAudio(fileUrl,response);
    }

    @GetMapping("/getVideo")
    @ApiOperation(value = "视频播放")
    public void getVideo(@RequestParam(required = true) String fileUrl,
                         HttpServletResponse response) throws Exception {
        fileUpload.getVideo(fileUrl,response);
    }

}
