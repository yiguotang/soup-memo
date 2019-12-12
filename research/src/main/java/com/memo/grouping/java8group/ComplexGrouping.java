package com.memo.grouping.java8group;

import com.google.common.collect.Lists;
import com.memo.grouping.entity.ProductBean;
import com.memo.grouping.entity.ProductBeanResult;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 复杂分组
 *
 * @author 19041060
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Slf4j
public class ComplexGrouping {

    public static void main(String[] args) {
        // 初始化排序数据
        List<ProductBean> productBeans = Lists.newArrayList(
                new ProductBean("Product A", 40.00, "Info1", 65),
                new ProductBean("Product A", 50.00, "Info2", 67),
                new ProductBean("Product A", 100.00, "Info3", 87),
                new ProductBean("Product B", 45.00, "Info4", 86),
                new ProductBean("Product D", 459.00, "Info5", 7),
                new ProductBean("Product B", 50.00, "Info6", 8)
        );

        // 按产品名称进行分组
        Map<String, List<ProductBean>> groupByProductName = productBeans.stream().collect(Collectors.groupingBy(item -> item.getName()));
        groupByProductName.forEach((k, v) -> log.info("groupKey: {}, groups: {}", k, v));

        log.info("==========================================================================");

        List<ProductBeanResult> results = productBeans.stream()
                .collect(Collectors.groupingBy(ProductBean::getName))
                .entrySet()
                .stream()
                .map(ComplexGrouping::mapToResultSet)
                .collect(Collectors.toList());
        results.forEach(item -> log.info("{}", item));
    }

    private static ProductBeanResult mapToResultSet(Map.Entry<String, List<ProductBean>> entry) {
        log.info("group key: {}", entry.getKey());
        ProductBeanResult result = new ProductBeanResult();
        Double sum = entry.getValue().stream().map(ProductBean::getAmount).reduce(0.0, (temp, e) -> temp + e);
        result.setName(entry.getKey());
        result.setAmount(sum);
        result.setProductBeans(entry.getValue());
        return result;
    }
}
