/*
 * Copyright (C), 2002-2015, 苏宁易购电子商务有限公司
 * FileName: //文件名
 * Author:   14050589
 * Date:     2015-10-29 上午11:02:16
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.memo.grouping.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 〈一句话功能简述〉 〈功能详细描述〉采购业务订单头表
 * 
 * @author 14050589
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Data
public class ScprsScpOrderHead implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 9200646912455318616L;
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 采购业务订单号
     */
    private String scpOrderNo;
    /**
     * 业务类型1采购2退货3调拨
     */
    private String bsnType;
    /**
     * 订单类型
     */
    private String orderType;
    /**
     * 订单状态10待审批20待确认21部分确认30待预约（待发货）31部分预约40待收货41部分收获50完成
     */
    private String orderStatus;
    /**
     * 供应商编码
     */
    private String supplierCode;
    /**
     * 供应商名称
     */
    private String supplierName;
    /**
     * 创单时间
     */
    private String createOrderTime;
    /**
     * 创建人
     */
    private String createUser;

    /**
     * 系统源
     */
    private String source;

    /**
     * 发起人用户组
     */
    private String userGroup;
    /**
     * 商品编码集合
     */
    private String cmmdtyCodes;
    /**
     * 品牌编码集合
     */
    private String brandCodes;
    /**
     * 仓库编码集合
     */
    private String categoryCodes;
    /**
     * 仓库编码集合
     */
    private String depotCodes;
    /**
     * 调入仓库编码集合
     */
    private String inDepotCodes;
    /**
     * 调入合同政策编码集合
     */
    private String inLocationCodes;
    /**
     * 合同政策编码集合
     */
    private String locationCodes;

    /**
     * 数据状态
     */
    private String dataState;

    /**
     * 流程实例ID
     */
    private String flowInstId;
    /**
     * 流程模版ID
     */
    private String flowId;

    /**
     * 备注
     */
    private String memo;

    /**
     * 特殊标识 1预算订单
     */
    private String specFlag;
    /**
     * 预算流水号 年份后两位+公司四位+MP5/6/7(5采购,6退厂,7调拨)+7位流水
     */
    private String budgetSerrialNo;

    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 是否启动流程 0：不启动 1：启动
     */
    private String startWorkFlow;
    /**
     * 审批意见
     */
    private String remarks;

    /**
     * 订单行项目
     */
    private List<ScprsScpOrderItem> itemList;

    /**
     * excel_id
     */
    private String excelId;
    
    /**
     * 订单创建入口
     */
    private String createOperateType;
    
    /**
     * 总价
     */
    private String totalPrice;
	
	
	 /**
     * 是否依赖R3 0否1是
     */
    private String dependentOnR3;
    
    /**
     * 架构层级
     */
    private String hierarchyCode;
    
    /**
     * 20180828_15040079:SCRPS-368创单业务类型:生鲜中转单-100
     */
    private String createBusinessType;
    
    /**
     * 责任原因
     */
    private String liabilityCause;
    
    /**
     * 终端公司采买标识
     */
    private String terType;
    
    /**
     * 预约类型
     * 1 无需预约 2 自动预约 空 普通预约
     */
    private String bookOrderType;

    /**
     * 拆单原因
     */
    private String newHeadReason;

    /**
     * 风险标签值，"1":存在风险标签内容,"0":无
     */
    private String riskLable;
    
    /**
     * 20191215_19040838:操作方式--->查看详情
     */
    private String operateSeeDetails;
    
    /**
     * 20191215_19040838:操作方式--->全部删除
     */
    private String operateAllDel;
    
    /**
     * 20191215_19040838:操作方式--->全部改期
     */
    private String operateAllChangeDate;
    
    /**
     * 20191215_19040838:操作方式--->全部关闭
     */
    private String operateAllClose;
    
    /**
     * 20191215_19040838:操作方式--->行修改、删除按钮
     */
    private String modifyAndDelButton;

	/**
     * 20191215_19040838:订单名称
     */
    private String orderNameStr;

	/**
     * 20191215_19040838:采购订单管理订单类型是:100PRS中转、101新中转、111菜场中转、115加工要货单汇总、家乐福
     *                   订单行复选框置灰不可选
     */
    private String disableCheckBox;

}
