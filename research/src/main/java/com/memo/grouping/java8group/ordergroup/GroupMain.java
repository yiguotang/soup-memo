package com.memo.grouping.java8group.ordergroup;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import com.memo.grouping.entity.ScprsScpOrderItem;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * 拆单主方法
 *
 * @author 19041060
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Slf4j
public class GroupMain {

    public static void main(String[] args) {

        // 拆单分组
        spiltGroup();

        // 老拆单分组逻辑
        SplitGroupOld.splitGroup();
    }

    private static void spiltGroup() {
        // 初始化测试数据
        List<ScprsScpOrderItem> orderItems = initData();

        Stopwatch stopwatch = Stopwatch.createStarted();

        // 新建各个执行handler
        AbstractHandler<ScprsScpOrderItem> setupHandler = new SetupHandler();
        AbstractHandler<ScprsScpOrderItem> splitHandler = new BillLimitSplitHandler();
        AbstractHandler<ScprsScpOrderItem> sortHandler = new SortHandler();

        // 拆单分组的执行链路: 分组配置 -> 拆分订单行 -> 排序
        setupHandler.setNext(splitHandler).setNext(sortHandler);

        // 执行处理
        Stream<ScprsScpOrderItem> afterHandlerData = setupHandler.handler(orderItems.stream());

        // TODO 分组执行链路：按字段分组 -> 按开票额度 -> 按每组数量上限

        // 处理时长
        log.info("group data completed, time comsume: {}ms", stopwatch.elapsed(TimeUnit.MILLISECONDS));

        log.info("after hander data length: {}", afterHandlerData.count());
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
