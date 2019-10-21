package com.soup.memo.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author zhaoyi
 */
@Slf4j
public class Pool {

    private static final int COUNT_BITS = Integer.SIZE - 3;

    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;

    // Packing and unpacking ctl
    public static int runStateOf(int c)     { return c & ~CAPACITY; }

    public static void main(String[] args) {
        System.out.println(Integer.valueOf(RUNNING));
        System.out.println(runStateOf(1));
    }
}
