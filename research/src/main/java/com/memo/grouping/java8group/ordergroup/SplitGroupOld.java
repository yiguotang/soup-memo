package com.memo.grouping.java8group.ordergroup;

import com.google.common.base.Stopwatch;
import com.memo.grouping.entity.ScprsScpOrderItem;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.memo.grouping.java8group.ordergroup.GroupMain.initData;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 19041060
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Slf4j
public class SplitGroupOld {

    public static void splitGroup() {
        // 初始化测试数据
        List<ScprsScpOrderItem> orderItems = initData();

        Stopwatch stopwatch = Stopwatch.createStarted();
        // 处理时长
        log.info("group data completed, time comsume: {}ms", stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}
