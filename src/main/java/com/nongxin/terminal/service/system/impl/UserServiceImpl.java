package com.nongxin.terminal.service.system.impl;

import com.nongxin.terminal.dao.file.PictureInfoMapper;
import com.nongxin.terminal.dao.system.UserMapper;
import com.nongxin.terminal.dao.system.UserRoleMapper;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.system.Role;
import com.nongxin.terminal.entity.system.User;
import com.nongxin.terminal.entity.system.UserRole;
import com.nongxin.terminal.service.system.UserService;
import com.nongxin.terminal.util.ImgUpload;
import com.nongxin.terminal.util.enumUtil.file.ImgRelationTypeEnum;
import com.nongxin.terminal.util.enumUtil.file.ImgTypeEnum;
import com.nongxin.terminal.util.enumUtil.system.RoleTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.File;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired(required = false)
    private UserRoleMapper userRoleMapper;
    @Autowired(required = false)
    private PictureInfoMapper pictureInfoMapper;
    @Autowired
    private ImgUpload imgUpload;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(User user) {
        try {
            userMapper.insertSelective(user);
            PictureInfo headPic = user.getHeadPic();
            if (headPic != null){
                headPic.setRelationId(user.getUid());
                pictureInfoMapper.updateByPrimaryKeySelective(headPic);
            }
            PictureInfo hukouPic = user.getHukouPic();
            if (hukouPic != null){
                hukouPic.setRelationId(user.getUid());
                pictureInfoMapper.updateByPrimaryKeySelective(hukouPic);
            }
            PictureInfo identifyCodePic = user.getIdentifyCodePic();
            if (identifyCodePic != null){
                identifyCodePic.setRelationId(user.getUid());
                pictureInfoMapper.updateByPrimaryKeySelective(identifyCodePic);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(Integer id) {
        try {
            userMapper.deleteByPrimaryKey(id);
            PictureInfo headPic = pictureInfoMapper.getUserHeadPic(id);
            if (headPic != null){
                File headFile = new File(imgUpload.getPath(headPic.getPictureUrl()));
                headFile.delete();
            }

            PictureInfo hukouPic = pictureInfoMapper.getUserHuKOuPic(id);
            if (hukouPic != null){
                File hukouFile = new File(imgUpload.getPath(headPic.getPictureUrl()));
                hukouFile.delete();
            }
            PictureInfo identifyCodePic = pictureInfoMapper.getIdentifyCodePic(id);
            if (identifyCodePic != null){
                File identifyCodeFile = new File(imgUpload.getPath(identifyCodePic.getPictureUrl()));
                identifyCodeFile.delete();
            }
            pictureInfoMapper.deleteByRelation(id, ImgRelationTypeEnum.USER_HEAD.getValue().intValue());
            pictureInfoMapper.deleteByRelation(id, ImgRelationTypeEnum.USER_HUKOU.getValue().intValue());
            pictureInfoMapper.deleteByRelation(id, ImgRelationTypeEnum.IDENTIFY_CODE.getValue().intValue());
            return true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(User user) {
        try {
            PictureInfo headPic = user.getHeadPic();
            if (headPic!=null){
                PictureInfo oldHeadPic = pictureInfoMapper.getUserHeadPic(user.getUid());
                if (oldHeadPic != null){
                    File file = new File(imgUpload.getPath(oldHeadPic.getPictureUrl()));
                    file.delete();
                    pictureInfoMapper.deleteByPrimaryKey(oldHeadPic.getId());
                }
                headPic.setRelationId(user.getUid());
                pictureInfoMapper.updateByPrimaryKeySelective(headPic);
            }
            PictureInfo hukouPic = user.getHukouPic();
            if (hukouPic != null){
                PictureInfo oldhukouPic = pictureInfoMapper.getUserHuKOuPic(user.getUid());
                if (oldhukouPic != null){
                    File file = new File(imgUpload.getPath(oldhukouPic.getPictureUrl()));
                    file.delete();
                    pictureInfoMapper.deleteByPrimaryKey(oldhukouPic.getId());
                }
                hukouPic.setRelationId(user.getUid());
                pictureInfoMapper.updateByPrimaryKeySelective(hukouPic);
            }
            PictureInfo identifyCodePic = user.getIdentifyCodePic();
            if (identifyCodePic != null){
                PictureInfo oldPic = pictureInfoMapper.getIdentifyCodePic(user.getUid());
                if (oldPic != null){
                    File file = new File(imgUpload.getPath(oldPic.getPictureUrl()));
                    file.delete();
                    pictureInfoMapper.deleteByPrimaryKey(oldPic.getId());
                }
                identifyCodePic.setRelationId(user.getUid());
                pictureInfoMapper.updateByPrimaryKeySelective(identifyCodePic);
            }
            userMapper.updateByPrimaryKeySelective(user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    public List<User> getUserList(User user) {
        return userMapper.getUserList(user);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public User getUserByUserName(String userName,Integer status) {
        return userMapper.getUserByUserName(userName,status);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addRoleToUser(User user) {
        try {
            userRoleMapper.deleteByUid(user.getUid());
            UserRole userRole = new UserRole();
            userRole.setUserId(user.getUid());
            for (Role role : user.getRoleList()){
                userRole.setRoleId(role.getId());
                userRoleMapper.insert(userRole);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    public boolean updateUserStatus(Integer id) {
        return userMapper.updateUserStatus(id)==1;
    }

    @Override
    public List<User> getUserAndRole(String realName) {
        return userMapper.getUserAndRole(realName);
    }

    @Override
    public User getUserAndRoleByUserName(String username) {
        return userMapper.getUserAndRoleByUserName(username);
    }

    @Override
    public List<User> getFarmer(RoleTypeEnum type,String realName) {
        return userMapper.getFarmer(type,realName);
    }

    @Override
    public User checkUser(String userName,String phone) {
        return userMapper.checkUser(userName,phone);
    }

    @Override
    public Map<String, Object> getUserCount() {
        return userMapper.getUserCount();
    }

    @Override
    public List<Map<String, Object>> getRoleAndUserCount() {
        return userMapper.getRoleAndUserCount();
    }
}
