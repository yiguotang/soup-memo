package com.soup.memo.algorithm.datastructure;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * 数组操作测试
 *
 * @author zhaoyi
 */
@Slf4j
public class AarrayManipulateTest {

    @Test
    public void insertTest() {
        ArrayManipulate<Integer> arrayManipulate = new ArrayManipulate<>(4);
        arrayManipulate.insert(3, 0);
        arrayManipulate.insert(4, 1);
        arrayManipulate.insert(5, 2);
        arrayManipulate.insert(6, 3);
        arrayManipulate.insert(1, 0);
        log.info(Arrays.toString(arrayManipulate.getArray()));
    }

    @Test
    public void deletedTest() {
        ArrayManipulate<Integer> arrayManipulate = new ArrayManipulate<>(4);
        arrayManipulate.insert(3, 0);
        Integer deleteELement = arrayManipulate.delete(0);
        log.info("delete element: {}", deleteELement);
        log.info(Arrays.toString(arrayManipulate.getArray()));
    }

    @Test
    public void deleteNoMoveTest() {
        ArrayManipulate<Integer> arrayManipulate = new ArrayManipulate<>(4);
        arrayManipulate.insert(3, 0);
        arrayManipulate.deleteNoMove(0);
        log.info(Arrays.toString(arrayManipulate.getArray()));
    }

}
