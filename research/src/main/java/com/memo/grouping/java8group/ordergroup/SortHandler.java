package com.memo.grouping.java8group.ordergroup;

import com.memo.grouping.entity.ScprsScpOrderItem;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

/**
 * 排序
 *
 * @author 19041060
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Slf4j
public class SortHandler extends AbstractHandler<ScprsScpOrderItem> {
    public SortHandler() {
        super(HandlerType.sort);
    }

    @Override
    protected Stream<ScprsScpOrderItem> sort(Stream<ScprsScpOrderItem> stream) {
        log.info("sort orde item");
        return stream.sorted(this::compare);
    }

    private int compare(ScprsScpOrderItem arg0, ScprsScpOrderItem arg1) {
        int result = 0;

        if (!strEquals(arg0.getIsLocation(), arg1.getIsLocation())) {
            result = strCompare(arg0.getIsLocation(), arg1.getIsLocation());
        } else if (!strEquals(arg0.getIsBrand(), arg1.getIsBrand())) {
            result = strCompare(arg0.getIsBrand(), arg1.getIsBrand());
        } else if (!strEquals(arg0.getIsCategory(), arg1.getIsCategory())) {
            result = strCompare(arg0.getIsCategory(), arg1.getIsCategory());
        } else if ("T".equals(arg0.getIsLocation()) && !strEquals(arg0.getLocationCode(), arg1.getLocationCode())) {
            // 按库位
            result = strCompare(arg0.getLocationCode(), arg1.getLocationCode());
        } else if (!strEquals(arg0.getPurchaseGrpCode(), arg1.getPurchaseGrpCode())) {
            // 采购组
            result = strCompare(arg0.getPurchaseGrpCode(), arg1.getPurchaseGrpCode());
        } else if ("T".equals(arg0.getIsBrand()) && !strEquals(arg0.getBrandCode(), arg1.getBrandCode())) {
            // 品牌
            result = strCompare(arg0.getBrandCode(), arg1.getBrandCode());
        } else if ("T".equals(arg0.getIsCategory()) && !strEquals(arg0.getCategoryCode(), arg1.getCategoryCode())) {
            // 商品组
            result = strCompare(arg0.getCategoryCode(), arg1.getCategoryCode());
        } else if (!strEquals(arg0.getDepotCode(), arg1.getDepotCode())) {
            // 仓库地点
            result = strCompare(arg0.getDepotCode(), arg1.getDepotCode());
        } else if (!strEquals(arg0.getFreeFlag(), arg1.getFreeFlag())) {
            // 是否免费
            result = strCompare(arg0.getFreeFlag(), arg1.getFreeFlag());
        } else if (!strEquals(arg0.getObjectSize(), arg1.getObjectSize())) {
            // 大小件标识（商品主数据）
            result = strCompare(arg0.getObjectSize(), arg1.getObjectSize());
        } else if (!strEquals(arg0.getOrderType(), arg1.getOrderType())) {
            // 合同政策/订单类型（常规、特价、包销）
            result = strCompare(arg0.getOrderType(), arg1.getOrderType());
        } else if (!strEquals(arg0.getPlantOrgCode(), arg1.getPlantOrgCode())) {
            // 按公司
            result = strCompare(arg0.getPlantOrgCode(), arg1.getPlantOrgCode());
        } else if (!strEquals(arg0.getRefrigeFlg(), arg1.getRefrigeFlg())) {
            // 冷藏/冷冻标识
            result = strCompare(arg0.getRefrigeFlg(), arg1.getRefrigeFlg());
        } else if (!strEquals(arg0.getSupplierCode(), arg1.getSupplierCode())) {
            // 供应商
            result = strCompare(arg0.getSupplierCode(), arg1.getSupplierCode());
        } else if (!strEquals(arg0.getTaxCateg(), arg1.getTaxCateg())) {
            // 税收分类(商品主数据中)
            result = strCompare(arg0.getTaxCateg(), arg1.getTaxCateg());
        } else if (!strEquals(arg0.getAboveNormal(), arg1.getAboveNormal())) {
            // 是否超标
            result = strCompare(arg0.getAboveNormal(), arg1.getAboveNormal());
        } else if (!strEquals(arg0.getBsnMode(), arg1.getBsnMode())) {
            // 经营模式
            result = strCompare(arg0.getBsnMode(), arg1.getBsnMode());
        } else if (!strEquals(arg0.getScpQty(), arg1.getScpQty())) {
            // 采购数量
            result = strCompare(arg0.getScpQty(), arg1.getScpQty());
        } else if(!strEquals(arg0.getPlanTypeCode(), arg1.getPlanTypeCode())){
            // 采购地点类型
            result = strCompare(arg0.getPlanTypeCode(), arg1.getPlanTypeCode());
        }

        return result;
    }

    private boolean strEquals(String str1, String str2) {
        boolean result = false;
        if (str1 == null && str2 == null) {
            result = true;
        } else if (str1 != null && str2 != null) {
            result = str1.equals(str2);
        }

        return result;
    }

    private int strCompare(String str1, String str2) {
        int result = 0;
        if (str1 == null) {
            if (str2 != null) {
                result = -1;
            }
        } else {
            if (str2 != null) {
                result = str1.compareTo(str2);
            } else {
                result = 1;
            }
        }
        return result;
    }

}
