package com.nanshuo.project.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.nanshuo.apicommon.model.entity.UserInterfaceInfo;

/**
* @author dell
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2024-04-15 14:46:49
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    /**
     * 有效用户界面信息
     *
     * @param userInterfaceInfo 用户界面信息
     * @param add               添加
     */
    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    /**
     * 调用计数
     *
     * @param interfaceInfoId 接口信息id
     * @param userId          用户id
     * @return boolean
     */
    boolean invokeCount(long interfaceInfoId, long userId);


}
