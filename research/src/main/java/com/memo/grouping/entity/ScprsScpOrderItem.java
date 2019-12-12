/*
 * Copyright (C), 2002-2015, 苏宁易购电子商务有限公司
 * FileName: //文件名
 * Author:   14050589
 * Date:     2015-10-29 上午11:12:18
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.memo.grouping.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 采购业务订单行表
 * 
 * @author 14050589
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Data
public class ScprsScpOrderItem implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1104838084659746412L;

    /**
     * 主键id
     */
    private String id;
    /**
     * 采购业务订单号
     */
    private String scpOrderNo;
    /**
     * 采购业务订单行项目号
     */
    private String itemNo;
    /**
     * 业务类型1采购2退货3调拨
     */
    private String bsnType;
    /**
     * 经营模式0经销2代销
     */
    private String bsnMode;
    /**
     * 订单状态10待审批20待确认30待预约（待发货）40待收货50完成
     */
    private String orderStatus;
    /**
     * 商品通码
     */
    private String gnrCmmdtyCode;
    /**
     * 通码名称
     */
    private String gnrCmmdtyName;
    /**
     * 商品编码
     */
    private String cmmdtyCode;
    /**
     * 商品名称
     */
    private String cmmdtyName;
    /**
     * 采购组织
     */
    private String pcsO;
    /**
     * 采购组织
     */
    private String orgCode;
    /**
     * 品牌编码
     */
    private String brandCode;
    /**
     * 品牌名称
     */
    private String brandName;
    /**
     * 商品类目编码
     */
    private String categoryCode;
    /**
     * 商品类目名称
     */
    private String categoryName;
    /**
     * 仓库编码
     */
    private String depotCode;
    /**
     * 仓库名称
     */
    private String depotName;
    /**
     * 合同政策编码
     */
    private String locationCode;
    /**
     * 合同政策名称
     */
    private String locationName;
    /**
     * 供应商编码
     */
    private String supplierCode;
    /**
     * 供应商名称
     */
    private String supplierName;
    
	/**
	 * 供应商业务类型
	 */
	private String bizTypeCode;
    
    /**
     * 底价
     */
    private String floorPrice;
    /**
     * 供价
     */
    private String supplyPrice;
    /**
     * 促销供价标识 X-是、空-否
     */
    private String supplyPriceFlag;
    /**
     * 价格时间
     */
    private String priceTime;
    /**
     * 合计价格
     */
    private String totalPrice;
    /**
     * 货币单位
     */
    private String currencyUnit;
    /**
     * 业态
     */
    private String industrySituationCode;
    /**
     * 数量
     */
    private String scpQty;
    /**
     * 单位
     */
    private String unit;
    /**
     * 创单时间
     */
    private String createOrderTime;
    /**
     * 交货时间
     */
    private String deliveryTime;
    /**
     * 收货数量
     */
    private String rcptQty;
    /**
     * 库存类别 X质量控制中的库存 S冻结库存 非限制为空白
     */
    private String stockType;
    /**
     * 创建人
     */
    private String createUser;

    /**
     * 系统源
     */
    private String source;

    /**
     * 调入仓库编码
     */
    private String inDepotCode;
    /**
     * 调入仓库名称
     */
    private String inDepotName;
    /**
     * 调入合同政策编码
     */
    private String inLocationCode;
    /**
     * 调入合同政策名称
     */
    private String inLocationName;
    /**
     * 配送方式
     */
    private String deliveryWay;
    /**
     * 运费
     */
    private String freightRates;
    /**
     * 样机序列号SERIES_NO
     */
    private String seriesNo;
    /**
     * 物流车次
     */
    private String logisticsTime;
    /**
     * 数据状态0无效1有效
     */
    private String dataState;
    /**
     * 发送步骤0001开始
     */
    private String sendStep;
    /**
     * 发送状态0失败1成功
     */
    private String sendStatus;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新时间
     */
    private String updateTime;

    /************************** 14042999 start ********************************/
    /**
     * 经营模式0经销1代销
     */
    private String supplierOperaMode;

    /**
     * 地点所属公司
     */
    private String plantOrgCode;
    
    /**
     * 地点所属公司名称
     */
    private String plantOrgName;

    /**
     * 根据合同政策取得订单类型
     */
    private String orderType;

    /**
     * 是否免费
     */
    private String freeFlag;

    /**
     * 税收分类(商品主数据中)
     */
    private String taxCateg;

    /**
     * 大小件标识（商品主数据）
     */
    private String objectSize;

    /**
     * 冷藏/冷冻标识（待确认来源）
     */
    private String refrigeFlg;

    /**
     * 开票限额
     */
    private String billLimit;

    /**
     * 合同政策
     */
    private String contrType;

    /**
     * 定价类别
     */
    private String priceKind;
    /**
     * 采购模式0 先采后销1 先销后采
     */
    private String pcsMode;
    /**
     * 付款期间 Z000表示预付款
     */
    private String payTime;

    /**
     * 销售属性ABC分类（A畅销、B平销、C不动销）
     */
    private String saleProperty;

    /**
     * 当前存销比
     */
    private String curISR;

    /**
     * 预计存销比
     */
    private String preISR;

    /**
     * 库存周转天数
     */
    private String kczzDay;

    /**
     * 01正常采购02停止采购，有02标识的仅停止采购
     */
    private String cmmdtyStatus;

    /**
     * “采购组”为G00、H00或S00允许无底价且不报错
     */
    private String purchaseGrpCode;

    /**
     * 采购组标记
     */
    private String superMarkerFlag;

    /**
     * 产品层次
     */
    private String cmmdtyHierrarchy;

    /**
     * 合同有效期
     */
    private String contrextenTime;

    /**
     * 采购提前期
     */
    private String purchaseTime;

    /**
     * 订单确认标识
     */
    private String confirmFlag;

    /**
     * 备注
     */
    private String memo;

    /**
     * 特殊标识 1预算订单 2样机订单
     */
    private String specFlag;

    /**
     * 出样类型
     */
    private String sampleType;

    /**
     * 样机类型
     */
    private String protoType;

    /**
     * 最优供应商 0否1是
     */
    private String bestSupplier;

    /**
     * 超标 T不超标F超标
     */
    private String aboveNormal;

    /**
     * 是否启动流程 0：不启动 1：启动
     */
    private String startWorkFlow;

    private String buCode;

    /**
     * 排序标记
     */
    private boolean isOrder;

    private String isBrand;

    private String isCategory;

    private String isLocation;

    private String maxItemno;

    private String demandNo;

    private String purchaseCode;
    /**
     *  箱规
     */
    private String boxRule;
    /**
     *  起订量
     */
    private long floorLimit;
    /**
     *  起订量类型 Q数量 !Q金额
     */
    private String floorType;
    /**
     *  经代销共存启用标识
     */
    private String bsnModeOn;
    /**
     *  供应商主数据：操作模式
     */
    private String operaModeBySupplier;
    /**
     *  合同号
     */
    private String oaDocCode;
    /**
     *  架构层级
     */
    private String hierarchyCode;
    /**
     *  实物地点
     */
    private String actualPlaceCode;
    /**
     * 预测补货系统会输入：YJ+12位流水号 供应链系统不需给值
     */
    private String sourceId;
    /**
     * 创单操作类型,订单创建入口 01-按进销存报表采购 02-指定供应商采购 03-批量导入采购 04-按库存报表调拨/退厂/移库 05-按滞销报表调拨/退厂 06-按临期报表调拨/退厂 07-批量导入调拨单 08-批量导入退厂单
     * 09-自动调拨 10-待处理不良品 11-出样报表 12-样机特例处理-A类样机特例采购出样订单 13-采购创单（预测补货/小店/店家/协同补货）非扫码 14-联营采购/退厂（SCPC） 15-小店退厂 16-小店调拨
     * 17-采购计划转采购订单 18-采购需求转采购订单 19-三星不良品 20-样机扫码 21-预测补货/供应链系统采购订单预警 22-促销品库存清单 23-促销品采购清单 24-零售云样机扫码订单 26-预测补货采购
     */
    private String createOperateType;
    /**
     * 大区编码
     */
    private String areaCode;
    /**
     * 大区名称
     */
    private String areaDesc;
    /**
     * 备注
     */
    private String remarks;

    /**
     * 基本单位(箱规表)
     */
    private String unitName;

    /**
     * 基本单位(箱规表)
     */
    private String basicUnit;
    /**
     * 基本单位(箱规表)
     */
    private String basicUnitDesc;

    /**
     * 包装单位代码(箱规表)
     */
    private String pkgUnitCode;

    /**
     * 包装单位描述(箱规表)
     */
    private String pkgUnitName;
    /**
     * 拆单箱规：如果事业部是“XX事业部不按箱规调整数量”则取老箱规数据
     */
    private long oldBoxRule;
    
    /**
     * 终端公司采买标识
     */
    private String terType;
    
    /**
     * 海信直连计划转采字段 (计划转采的传Y值,其它不传)
     */
    private String planAutomaticPo;
    /**
     * 采购地点类型 1:中心仓 2:门店
     */
    private String planTypeCode;
    /**
     * 建议补货数
     */
    private String advcFillupQty;
    
    /**
     * 安全库存
     */
    private String safeInvDays;
    
    /**
     * 是否机审(T是/F否)
     */
    private String isAutoPass;
    /**
     * 机审值
     */
    private String autoPassValue;
    /**
     * 指标编码
     */
    private String referenceCodes;

    /**
     * 拆单比较原因，如果拆单，则将比较原因的类型设置到该字段
     */
    private String compareReason;

    /**
     * 审批镜像对象
     */
    // private ScprsOrderSpImageItem spImageItem;
    
    /**
     * 	扣点合同号
     */
    private String contCode;
    
    /**
     * 	税码
     */
    private String taxCode;
    
    /**
     * 	不规则扣点
     */
    private String irregularCode;
    
    /**
     * 	不规则类型
     */
    private String irregularType;
    
    /**
     * 	税率
     */
    private String taxRate;
    
    /**
     * 1正向调拨 2逆向调拨 空:其它
     */
    private String quotaSign;
    /**
     * 额度控制功能的价格
     */
    private String quotaPrice;
    /**
     * 当前行的额度
     */
    private String currAmount;
    /**
     * 门店剩余额度
     */
    private String remainAmount;

	/**
     * 	规则返利
     */
    private String returnGain;    

}
