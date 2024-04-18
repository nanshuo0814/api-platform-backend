package com.nanshuo.project.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.nanshuo.apicommon.model.entity.InterfaceInfo;

/**
* @author dell
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2024-04-11 21:03:30
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    /**
     * 校验接口信息
     *
     * @param interfaceInfo 接口信息
     * @param add           添加
     */
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);

}
