package com.nongxin.terminal.service.system;

import com.nongxin.terminal.entity.system.AppResource;

import java.util.List;

public interface AppResourceService {

    boolean add(AppResource appResource);

    boolean delete(Integer id);

    boolean update(AppResource appResource);

    /**
     * 获取用户app权限
     * @param uid
     * @param type null:所有权限 1:前台权限 2:后端权限
     * @return
     */
    List<AppResource> getAppResourceByUid(Integer uid, Integer type);

    /**
     * 获取app权限
     * @param type null:所有权限 1:前台权限 2:后端权限
     * @return
     */
    List<AppResource> getAppResourceList(Integer type);

}
