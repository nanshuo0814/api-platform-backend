package com.nanshuo.project.model.dto.UserInterfaceInfo;

import com.nanshuo.project.model.dto.page.PageBaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 查询请求
 *
 * @author nanshuo
 * @date 2024/04/15 14:54:01
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserInterfaceInfoQueryRequest extends PageBaseRequest implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 调用用户 id
     */
    private Long userId;

    /**
     * 接口 id
     */
    private Long interfaceInfoId;

    /**
     * 总调用次数
     */
    private Integer totalNum;

    /**
     * 剩余调用次数
     */
    private Integer leftNum;

    /**
     * 0-正常，1-禁用
     */
    private Integer status;

}