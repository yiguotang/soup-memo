package com.memo.grouping.java8group;

import com.google.common.collect.Lists;
import com.memo.grouping.entity.ScprsScpOrderItem;

import java.util.List;

/**
 * 订单分组
 *
 * @author 19041060
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class OrderGroup {



    public static void main(String[] args) {

        List<ScprsScpOrderItem> orderItems = initData();



    }

    // 按照数量分组
    public static String groupByItemNum(ScprsScpOrderItem item) {
        return item.getCmmdtyCode();
    }

    // 初始化数据
    public static List<ScprsScpOrderItem> initData() {
        List<ScprsScpOrderItem> itmeList = Lists.newArrayList();

        // 可选四要素数据
        String[] cmmdtyCodes = new String[] {"101011872", "140030662", "101011880", "101011880"};
        String[] depotCodes = new String[] {"D025", "7610", "7611", "DX01"};
        String[] locationCodes = new String[] {"0001", "0003", "0005", "0006"};
        String[] supplierCodes = new String[] {"10000179", "10000179", "10046759", "10000160"};

        for (int i = 0; i < 1000; i++) {
            ScprsScpOrderItem item = new ScprsScpOrderItem();




            itmeList.add(item);
        }

        return itmeList;
    }
}
