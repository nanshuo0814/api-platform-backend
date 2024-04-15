package com.nanshuo.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nanshuo.project.common.ErrorCode;
import com.nanshuo.project.exception.BusinessException;
import com.nanshuo.project.mapper.UserInterfaceInfoMapper;
import com.nanshuo.project.model.domain.UserInterfaceInfo;
import com.nanshuo.project.service.UserInterfaceInfoService;
import org.springframework.stereotype.Service;

/**
* @author dell
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service实现
* @createDate 2024-04-15 14:46:49
*/
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService {

    /**
     * 有效用户界面信息
     *
     * @param userInterfaceInfo 用户界面信息
     * @param add               添加
     */
    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 创建时，所有参数必须非空
        if (add) {
            if (userInterfaceInfo.getInterfaceInfoId() <= 0 || userInterfaceInfo.getUserId() <= 0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口或用户不存在");
            }
        }
        if (userInterfaceInfo.getLeftNum() < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "剩余次数不能小于 0");
        }
    }

}



