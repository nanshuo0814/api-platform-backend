package com.nanshuo.project.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nanshuo.apicommon.model.entity.UserInterfaceInfo;

import java.util.List;

/**
* @author dell
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Mapper
* @createDate 2024-04-15 14:46:49
* @Entity com.nanshuo.project.model.domain.UserInterfaceInfo
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {

    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);

}




