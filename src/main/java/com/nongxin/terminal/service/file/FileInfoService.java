package com.nongxin.terminal.service.file;

import com.nongxin.terminal.entity.file.FileInfo;
import com.nongxin.terminal.vo.Result;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileInfoService {

    //新增报告
    Result insertFile(MultipartFile file, FileInfo fileInfo);

    //删除报告
    boolean deleteByPrimaryKey(Integer id);

}
