package com.soup.memo.common.cmpare;

import com.google.common.collect.Lists;
import com.soup.memo.common.compare.User;
import com.soup.memo.common.compare.UserComparaor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * Compare 测试main
 *
 * @author zhaoyi
 */
@Slf4j
public class CompareTest {

    /**
     * 测试Comparaor排序
     */
    @Test
    public void userCompareTest() {
        // 准备数据
        List<User> users = Lists.newArrayList();
        users.add(new User("test", "nanjing", 12));
        users.add(new User("zhansang", "hangzhou", 11));
        users.add(new User("zhansang", "nanjing", 11));
        users.add(new User("wangwu", "wuhu", 18));

        log.info("before sort: {}", users);
        Collections.sort(users, new UserComparaor());
        log.info("after sort: {}", users);
    }
}
