package com.memo.grouping.java8group.ordergroup;

import cn.hutool.core.bean.BeanUtil;
import com.memo.grouping.entity.ScprsScpOrderItem;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * 订单拆分：按订单限额拆分订单行
 *
 * @author 19041060
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Slf4j
public class BillLimitSplitHandler extends AbstractHandler<ScprsScpOrderItem> {

    public BillLimitSplitHandler() {
        super(HandlerType.split);
    }

    @Override
    protected Stream<ScprsScpOrderItem> split(Stream<ScprsScpOrderItem> stream) {
        log.info("split order item by bill limit.");

        Stream<ScprsScpOrderItem> handlerStream = null;
        if (null != stream) {
            handlerStream = stream.flatMap(BillLimitSplitHandler::splitByBillLimit);
        }

        return handlerStream;
    }

    /**
     * 根据订单限额拆分出订单行
     *
     * @return 新拆分的订单行对象
     */
    private static Stream<ScprsScpOrderItem> splitByBillLimit(ScprsScpOrderItem orderItem) {
        // 根据入参只生成一个新订单行，加上入参对象，stream中最多只有2个元素
        return Stream.iterate(orderItem, BillLimitSplitHandler::generate).limit(2).filter(Objects::nonNull);
    }

    /**
     * 根据开票限额拆分新订单
     *
     * @param item 拆分订单依据
     * @return 拆分的新订单对象，如果是null表示不满足拆单业务，不进行拆单
     */
    private static ScprsScpOrderItem generate(ScprsScpOrderItem item) {
        // 供价
        BigDecimal supplyPrice = parseBigDecimal(item.getSupplyPrice(), null);
        boolean splitFlag = "0".equals(item.getFreeFlag()) || supplyPrice.compareTo(BigDecimal.ZERO) == 0
                || !"0".equals(item.getBsnMode());

        ScprsScpOrderItem standItem = null;
        if (!splitFlag) {
            // TODO 开票限额拆单逻辑

            standItem = new ScprsScpOrderItem();
            BeanUtil.copyProperties(item, standItem);
        }

        return standItem;
    }

    /**
     *
     * 功能描述: <br>
     * 〈String转Bigdecimal〉
     *
     * @param numberStr 数字字符串
     * @param defaultValue 默认值
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static BigDecimal parseBigDecimal(String numberStr, BigDecimal defaultValue) {
        if (StringUtils.isNotEmpty(numberStr)) {
            if (numberStr.matches("(-)?\\d+(\\.\\d+)?")) {
                return new BigDecimal(numberStr);
            } else if (numberStr.contains(",")) {
                numberStr = numberStr.replace(",", "");
                if (numberStr.matches("(-)?\\d+(\\.\\d+)?")) {
                    return new BigDecimal(numberStr);
                }
            }
        }
        return defaultValue;
    }
}
