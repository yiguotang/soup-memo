package com.memo.distributed.locktest;

import com.memo.distributed.lock.RedisLock;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import redis.clients.jedis.JedisCluster;

import java.util.UUID;

/**
 * 基于Redis实现的分布式锁
 *
 * @author zhaoyi
 */
@Slf4j
public class RedisDistributedLockTest {

    @InjectMocks
    private JedisCluster jedisCluster;

    @Test
    public void redisLockTest() {
        String lockKey = "key";
        String lockValue = UUID.randomUUID().toString();

        Mockito.when(jedisCluster.set(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(),
                Mockito.anyString(), Mockito.anyLong())).thenReturn("OK");

        RedisLock redisLock = new RedisLock();
        boolean lockResult = redisLock.tryLock(lockKey, lockValue);
        log.info("lock result: {}", lockResult);
        Assert.assertTrue(lockResult);

        //check
        Mockito.verify(jedisCluster).set(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(),
                Mockito.anyString(), Mockito.anyLong());
    }
}
