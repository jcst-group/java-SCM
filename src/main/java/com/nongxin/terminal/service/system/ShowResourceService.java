package com.nongxin.terminal.service.system;

import com.nongxin.terminal.entity.system.ShowResource;

import java.util.List;

public interface ShowResourceService {

    boolean add(ShowResource showResource);

    boolean delete(Integer id);

    boolean update(ShowResource showResource);

    /**
     * 获取用户看板权限
     * @param uid
     * @param type null:所有权限 1:前台权限 2:后端权限
     * @return
     */
    List<ShowResource> getShowResourceByUid(Integer uid, Integer type);

    /**
     * 获取看板权限
     * @param type null:所有权限 1:前台权限 2:后端权限
     * @return
     */
    List<ShowResource> getShowResourceList(Integer type);

}
