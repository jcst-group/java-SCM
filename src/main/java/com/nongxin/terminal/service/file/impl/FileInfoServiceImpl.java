package com.nongxin.terminal.service.file.impl;

import com.nongxin.terminal.dao.file.FileInfoMapper;
import com.nongxin.terminal.entity.file.FileInfo;
import com.nongxin.terminal.service.file.FileInfoService;
import com.nongxin.terminal.util.FileUpload;
import com.nongxin.terminal.vo.FileInfoVo;
import com.nongxin.terminal.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class FileInfoServiceImpl implements FileInfoService {

    @Autowired(required = false)
    private FileInfoMapper fileInfoMapper;
    @Autowired
    private FileUpload fileUpload;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result insertFile(MultipartFile file, FileInfo fileInfo) {
        Result result = new Result<>();
        Result<FileInfoVo> result1 = fileUpload.listSample(file);
        if (result1.isSuccess()){
            try {
                fileInfo.setFileUrl(result1.getResult().getPath());
                fileInfo.setFileName(result1.getResult().getFileName());
                fileInfo.setFileSize(result1.getResult().getFileSize().longValue());
                if (result1.getResult().getDuration() != null){
                    fileInfo.setRemark(result1.getResult().getDuration().toString());
                }
                result.setSuccess(fileInfoMapper.insertSelective(fileInfo)==1);
                result.setMessage("上传文件成功");
                result.setResult(fileInfo);
                return result;
            }catch (Exception e){
                String path = fileUpload.getPath(result1.getResult().getPath());
                File file1 = new File(path);
                if (file1.exists()){
                    file1.delete();
                }
                e.printStackTrace();
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }
        return result1;
    }

    @Override
    public boolean deleteByPrimaryKey(Integer id) {
        fileInfoMapper.selectByPrimaryKey(id);
        File file1 = new File(fileUpload.getPath(fileInfoMapper.selectByPrimaryKey(id).getFileUrl()));
        if (file1.exists()){
            file1.delete();
        }
        fileInfoMapper.deleteByPrimaryKey(id);
        return true;
    }

}
