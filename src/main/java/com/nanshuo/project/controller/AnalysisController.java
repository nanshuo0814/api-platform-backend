package com.nanshuo.project.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nanshuo.apicommon.model.entity.InterfaceInfo;
import com.nanshuo.apicommon.model.entity.UserInterfaceInfo;
import com.nanshuo.project.annotation.Check;
import com.nanshuo.project.common.ApiResponse;
import com.nanshuo.project.common.ApiResult;
import com.nanshuo.project.common.ErrorCode;
import com.nanshuo.project.constant.UserConstant;
import com.nanshuo.project.exception.BusinessException;
import com.nanshuo.project.mapper.UserInterfaceInfoMapper;
import com.nanshuo.project.model.vo.interfaceinfo.InterfaceInfoVO;
import com.nanshuo.project.service.InterfaceInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.xml.ws.Response;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 分析控制器
 *
 * @author nanshuo
 * @date 2024/04/18 20:58:36
 */
@RestController
@RequestMapping("/analysis")
@Slf4j
public class AnalysisController {

    @Resource
    private UserInterfaceInfoMapper userInterfaceInfoMapper;

    @Resource
    private InterfaceInfoService interfaceInfoService;

    @GetMapping("/top/interface/invoke")
    @Check(checkAuth = UserConstant.ADMIN_ROLE)
    public ApiResponse<List<InterfaceInfoVO>> listTopInvokeInterfaceInfo() {
        List<UserInterfaceInfo> userInterfaceInfoList = userInterfaceInfoMapper.listTopInvokeInterfaceInfo(3);
        Map<Long, List<UserInterfaceInfo>> interfaceInfoIdObjMap = userInterfaceInfoList.stream()
                .collect(Collectors.groupingBy(UserInterfaceInfo::getInterfaceInfoId));
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", interfaceInfoIdObjMap.keySet());
        List<InterfaceInfo> list = interfaceInfoService.list(queryWrapper);
        if (CollectionUtils.isEmpty(list)) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        List<InterfaceInfoVO> interfaceInfoVOList = list.stream().map(interfaceInfo -> {
            InterfaceInfoVO interfaceInfoVO = new InterfaceInfoVO();
            BeanUtils.copyProperties(interfaceInfo, interfaceInfoVO);
            int totalNum = interfaceInfoIdObjMap.get(interfaceInfo.getId()).get(0).getTotalNum();
            interfaceInfoVO.setTotalNum(totalNum);
            return interfaceInfoVO;
        }).collect(Collectors.toList());
        return ApiResult.success(interfaceInfoVOList);
    }
}
