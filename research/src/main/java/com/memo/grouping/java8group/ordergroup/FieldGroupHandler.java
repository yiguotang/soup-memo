package com.memo.grouping.java8group.ordergroup;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.memo.grouping.entity.ScprsScpOrderItem;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 根据字段分组的处理器
 *
 * @author 19041060
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class FieldGroupHandler extends AbstractHandler<ScprsScpOrderItem> {

    public FieldGroupHandler() {
        super(HandlerType.group);
    }

    @Override
    protected Object group(Object obj) {
        Map<String, List<ScprsScpOrderItem>> fieldGroups = Collections.emptyMap();
        if (obj instanceof Stream) {
            @SuppressWarnings("unchecked")
            Stream<ScprsScpOrderItem> streamHandler = (Stream<ScprsScpOrderItem>) obj;
            fieldGroups = streamHandler.collect(Collectors.groupingBy(this::groupByField));
        }
        
        return fieldGroups;
    }
    
    

    /**
     * 按分组字段设置分组key值
     *
     * @param item 订单行
     * @return 分组key
     */
    private String groupByField(ScprsScpOrderItem item) {

        List<String> groupKeys = Lists.newArrayList();

        Optional.ofNullable(item.getIsLocation()).ifPresent(groupKeys::add);
        Optional.ofNullable(item.getIsBrand()).ifPresent(groupKeys::add);
        Optional.ofNullable(item.getIsCategory()).ifPresent(groupKeys::add);

        if (StringUtils.equals(item.getIsLocation(), "T")) {
            groupKeys.add(item.getLocationCode());
        }
        Optional.ofNullable(item.getPurchaseGrpCode()).ifPresent(groupKeys::add);
        if (StringUtils.equals(item.getIsBrand(), "T")) {
            groupKeys.add(item.getBrandCode());
        }
        if (StringUtils.equals(item.getIsCategory(), "T")) {
            groupKeys.add(item.getCategoryCode());
        }

        Optional.ofNullable(item.getDepotCode()).ifPresent(groupKeys::add);
        Optional.ofNullable(item.getFreeFlag()).ifPresent(groupKeys::add);
        Optional.ofNullable(item.getObjectSize()).ifPresent(groupKeys::add);
        Optional.ofNullable(item.getOrderType()).ifPresent(groupKeys::add);
        Optional.ofNullable(item.getPlantOrgCode()).ifPresent(groupKeys::add);
        Optional.ofNullable(item.getRefrigeFlg()).ifPresent(groupKeys::add);
        Optional.ofNullable(item.getSupplierCode()).ifPresent(groupKeys::add);
        Optional.ofNullable(item.getTaxCateg()).ifPresent(groupKeys::add);
        Optional.ofNullable(item.getAboveNormal()).ifPresent(groupKeys::add);
        Optional.ofNullable(item.getBsnMode()).ifPresent(groupKeys::add);

        Optional.ofNullable(item.getScpQty()).ifPresent(groupKeys::add);

        Optional.ofNullable(item.getPlanTypeCode()).ifPresent(groupKeys::add);

        return Joiner.on("#").join(groupKeys);
    }
}
