package com.soup.memo.common.stream;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Stream;

/**
 * stream的 generator() iterate() 生成元素的方法测试
 *
 * @author zhaoyi
 */
@Slf4j
public class GeneratorAndIterate {

    public static void main(String[] args) {
        // 初始测试数据
        List<Demo> list = Lists.newArrayList(
                new Demo("test1", 12),
                new Demo("test2", 13),
                new Demo("test3", 14)
        );

        Stream<Demo> stream;

        // 使用generator()生成元素
        stream = Stream.generate(() -> new Demo("test4", 15)).limit(1);
        stream.forEach(e -> log.info("{}", e));

        log.info("======================================================================");

        // 使用iterate()生成，需要传递一个种子作为参数，来生成一个新的元素，这个产生的结果
        Demo seed = list.get(0);
        // 这里设置生成2个元素，是因为种子元素被设置到了第一个元素，只有第二个是，所以结合使用skip将第一个元素给移除
        stream = Stream.iterate(seed, Demo::generate).limit(2).skip(1).filter(Objects::nonNull);
        // 如果stream进行了消费，则stream就无法操作
        //stream.forEach(e -> log.info("{}", e));

        log.info("======================================================================");

        // 合并流，将新生成的流合并到初始数据list的流中
        Stream contactStream = Stream.concat(list.stream(), stream);
        contactStream.forEach(e -> log.info("{}", e));

        log.info("============================== 裂变 + 聚合 ========================================");
        // 对list中的每个元素进行裂变操作，然后打印所有元素
        list.stream().filter(Objects::nonNull).flatMap(Demo::generateV2).forEach(e -> log.info("{}", e));

    }
}

/**
 * 测试bean
 */
@Data
class Demo {

    private String name;

    private Integer age;

    public Demo(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 通过传递种子参数，生成新的Demo实例
     * @param seed 种子参数
     * @return 新的Demo实例
     */
    public static Demo generate(Demo seed) {
        int randomInt = new Random().ints(0,10).findAny().getAsInt();
        if (randomInt % 2 == 0) {
            return new Demo(seed.getName() + "_" + randomInt, seed.getAge() + randomInt);
        }

        return null;
    }

    public static Stream generateV2(Demo seed) {
        // 根据种子生成,只生成一个，加上种子对象，stream中最多只有2个
        return Stream.iterate(seed, Demo::generate).limit(2).filter(Objects::nonNull);
    }
}