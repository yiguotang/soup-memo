package com.memo.grouping.java8group;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import com.memo.grouping.entity.ScprsScpOrderItem;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 订单分组
 *
 * @author 19041060
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Slf4j
public class OrderGrouping {



    public static void main(String[] args) {

        List<ScprsScpOrderItem> orderItems = initData();
        log.info("init data completed.");

        Stopwatch stopwatch = Stopwatch.createStarted();
        // 分组
        Map<String, List<ScprsScpOrderItem>> groups = orderItems.stream().collect(Collectors.groupingBy(OrderGrouping::groupByItemNum));
        log.info("group data completed, time comsume: {}ms", stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

    // 按照数量分组
    public static String groupByItemNum(ScprsScpOrderItem item) {
        return item.getCmmdtyCode() + "#" + item.getDepotCode() + "#" + item.getLocationCode() + "#" + item.getSupplierCode();
    }

    // 初始化数据
    public static List<ScprsScpOrderItem> initData() {
        List<ScprsScpOrderItem> itmeList = Lists.newArrayList();

        // 可选四要素数据
        String[] cmmdtyCodes = new String[] {"101011872", "140030662", "101011880", "101011880"};
        String[] depotCodes = new String[] {"D025", "7610", "7611", "DX01"};
        String[] locationCodes = new String[] {"0001", "0003", "0005", "0006"};
        String[] supplierCodes = new String[] {"10000179", "10000179", "10046759", "10000160"};

        Random random = new Random();

        for (int i = 0; i < 200; i++) {
            ScprsScpOrderItem item = new ScprsScpOrderItem();

            int randomInt = random.ints(0,4).findAny().getAsInt();
            // 设置四要素信息
            item.setCmmdtyCode(cmmdtyCodes[randomInt]);
            item.setDepotCode(depotCodes[randomInt]);
            item.setLocationCode(locationCodes[randomInt]);
            item.setSupplierCode(supplierCodes[randomInt]);

            item.setBsnMode(randomInt + "");

            item.setBillLimit((randomInt * i) + "");

            itmeList.add(item);
        }

        return itmeList;
    }


}
