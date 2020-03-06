package com.nongxin.terminal.service.crop;

import com.nongxin.terminal.entity.crop.Crop;

import java.util.List;

public interface CropService {

    boolean add(Crop crop);

    boolean delete(Integer id);

    boolean update(Crop crop);

    List<Crop> getCropList();

    List<Crop> getAllCropList();

    Crop getIdAndNameById(Integer id);

}
