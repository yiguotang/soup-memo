package com.soup.memo.algorithm.datastructure;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * <p>
 *
 * </p>
 *
 * @author zhaoyi
 * @date 2019-12-23 23:16
 * @since 1.0
 */
@Slf4j
public class LinkedListManipulateTest {

    @Test
    public void linkedListTest() {
        LinkedListManipulate linkedList = new LinkedListManipulate();

        linkedList.insert(1, 0);
        linkedList.insert(4, 1);
        linkedList.insert(5, 2);
        linkedList.insert(9, 3);
        linkedList.insert(8, 2);
        linkedList.outPut();

        log.info("=========================================================");
        linkedList.remove(0);
        linkedList.outPut();
    }
}
