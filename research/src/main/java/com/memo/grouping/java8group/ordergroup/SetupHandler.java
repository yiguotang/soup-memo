package com.memo.grouping.java8group.ordergroup;

import com.memo.grouping.entity.ScprsScpOrderItem;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 19041060
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Slf4j
public class SetupHandler extends AbstractHandler<ScprsScpOrderItem> {

    public SetupHandler() {
        super(HandlerType.setup);
    }

    @Override
    protected Stream<ScprsScpOrderItem> setupGroupConfig(Stream<ScprsScpOrderItem> stream) {
        log.info("setup group config.");

        Stream<ScprsScpOrderItem> handlerStream = null;
        if (null != stream) {
            handlerStream = stream.map(SetupHandler::setupConfig);
        }

        return handlerStream;
    }

    /**
     * 根据事业部和供应商信息查询配置的分组信息，设置到
     * @param orderItem 订单行信息
     * @return 设置了分组信息的订单行对象
     */
    private static ScprsScpOrderItem setupConfig(ScprsScpOrderItem orderItem) {
        String buCode = orderItem.getBuCode();
        String supplierCode = orderItem.getSupplierCode();

        // 根据事业部编码和供应商编码查询配置信息
        Map<String, Object> configMap = new HashMap<>();

        // 将配置信息设置到对象中

        // 返回信息
        return orderItem;
    }

}
