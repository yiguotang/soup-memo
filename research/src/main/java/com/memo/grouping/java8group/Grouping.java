package com.memo.grouping.java8group;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import com.memo.grouping.entity.Fruit;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 19041060
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Slf4j
public class Grouping {
    public static void main(String[] args) {

        // 准备数据
        List<Fruit> fruitList = Lists.newArrayList(
                new Fruit("apple", 6), new Fruit("apple", 6),
                new Fruit("apple", 6), new Fruit("apple", 7),
                new Fruit("banana", 7), new Fruit("banana", 7),
                new Fruit("banana", 7), new Fruit("grape",8));

        Stopwatch stopwatch = Stopwatch.createStarted();

        // 单一属性分组
        Map<String, List<Fruit>> groupByName = fruitList.stream().collect(Collectors.groupingBy(Fruit::getName));
        log.info("comsume:{}ms", stopwatch.elapsed(TimeUnit.MILLISECONDS));
        groupByName.forEach((k, v) -> log.info("key:{}, value:{}", k, v));

        log.info("===============================================================");

        // 多字段分组
        Map<String, List<Fruit>> groupByNamePrice = fruitList.stream().collect(Collectors.groupingBy(item -> namePrice(item)));
        groupByNamePrice.forEach((k, v) -> log.info("key:{}, value:{}", k, v));

        log.info("===============================================================");

        // 多字段分组
        Map<Object, List<Fruit>> groups = fruitList.stream().collect(Collectors.groupingBy(Grouping::name));
        groups.forEach((k, v) -> log.info("key:{}, value:{}", k, v));
    }

    private static Object name(Fruit fruit) {
        return "1";
    }

    // 分组key的构建方法
    private static String namePrice(Fruit fruit) {
        return fruit.getName() + "#" + fruit.getPrice();
    }
}
