/*
 * RT MAP, Home of Professional MAP
 * Copyright 2017 Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.rtmap.middle.framework.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * JedisWrapper工具Bean
 *
 * @author maoyun@rtmap.com
 * @project rtmap-scenes
 * @package com.rtmap.rts.common.service.cache.impl
 * @date 5/18/17
 */
@Component("jedisWrapper")
public class JedisWrapper {

    @Autowired
    private JedisPool jedisPool;

    private <T> T execute(CacheExecutor<T> executor) {
        T result;
        Jedis jedis = jedisPool.getResource();
        try {
            result = executor.execute(jedis);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }
    public Boolean scriptExists(String script) {
        return execute(jedis -> jedis.scriptExists(script));
    }

    public String scriptLoad(String script) {
        return execute(jedis -> jedis.scriptLoad(script));
    }
    public Object eval(String script) {
        return execute(jedis -> jedis.eval(script));
    }

    /**
     * 推送元素到集合List中
     *
     * @param key   键
     * @param value 值
     * @return 推送后集合内元素个数
     */
    public Long lpush(String key, String... value) {
        return execute(jedis -> jedis.lpush(key, value));
    }

    public Long rpush(String key, String... value) {
        return execute(jedis -> jedis.rpush(key, value));
    }

    public String lpop(String key) {
        return execute(jedis -> jedis.lpop(key));
    }

    public String rpop(String key) {
        return execute(jedis -> jedis.rpop(key));
    }

    /**
     * 获取所有集合元素
     *
     * @param key 键
     * @return 推送后集合内元素个数
     */
    public List<String> lrange(String key) {
        return execute(jedis -> jedis.lrange(key, 0L, -1L));
    }

    interface CacheExecutor<T> {
        T execute(Jedis jedis);
    }

    public String set(final String key, final String value) {
        return execute(jedis -> jedis.set(key, value));
    }


    public String get(final String key) {
        return execute(jedis -> jedis.get(key));
    }

    public Boolean exists(final String key) {
        return execute(jedis -> jedis.exists(key));
    }

    public Long setnx(final String key, final String value) {
        return execute(jedis -> jedis.setnx(key, value));
    }

    public String setex(final String key, final String value, final int seconds) {
        return execute(jedis -> jedis.setex(key, seconds, value));
    }

    public Long expire(final String key, final int seconds) {
        return execute(jedis -> jedis.expire(key, seconds));
    }

    public Long expireAt(final String key, final int milliseconds) {
        return execute(jedis -> jedis.expireAt(key, milliseconds));
    }

    public Long incr(final String key) {
        return execute(jedis -> jedis.incr(key));
    }

    public boolean hexists(final String key, final String field) {

        return execute(jedis -> jedis.hexists(key, field));
    }

    public Long decr(final String key) {
        return execute(jedis -> jedis.decr(key));
    }

    public Long hset(final String key, final String field, final String value) {
        return execute(jedis -> jedis.hset(key, field, value));
    }

    public String hset(final String key, final Map<String, String> hash) {
        return execute(jedis -> jedis.hmset(key, hash));
    }

    public String hget(final String key, final String field) {
        return execute(jedis -> jedis.hget(key, field));
    }

    public String hmset(final String key, final Map<String, String> hash) {
        return execute(jedis -> jedis.hmset(key, hash));
    }

    public List<String> hmget(final String key, final String... fields) {
        return execute(jedis -> jedis.hmget(key, fields));
    }

    public Long del(final String key) {
        return execute(jedis -> jedis.del(key));
    }

    public Long hdel(final String key, final String... field) {
        return execute(jedis -> jedis.hdel(key, field));
    }

    public Map<String, String> hgetAll(final String key) {
        return execute(jedis -> jedis.hgetAll(key));
    }

    public Long hincrby(final String key, String feild) {
        return hincrby(key, feild, 1);
    }

    public Long decrby(final String key, String feild) {
        return hincrby(key, feild, -1);
    }

    public Long hincrby(final String key, String feild, long value) {
        return execute(jedis -> jedis.hincrBy(key, feild, value));
    }

    /**
     * 与list相关类型的操作
     *
     * @param key
     * @param elements
     * @return
     * @Auth： chengtan@rtmap.com
     */

    public Long lpushx(final String key, final String elements) {
        return execute(jedis -> jedis.lpushx(key, elements));
    }

    public Long lpushx(final String key, final String... elemets) {
        return execute(jedis -> jedis.lpushx(key, elemets));
    }

    public Long lrem(final String key, final Long count, final String value) {
        return execute(jedis -> jedis.lrem(key, count, value));
    }

    public Long ttl(final String key) {
        return execute(jedis -> jedis.ttl(key));
    }

    public List<String> hvals(final String key) {
        return execute(jedis -> jedis.hvals(key));
    }

    public Set<String> keys(final String key) {
        return execute(jedis -> jedis.keys(key));
    }

    public Long setNx(final String key, final String value) {
        return execute(jedis -> jedis.setnx(key, value));
    }

    public String getSet(final String key, final String value) {
        return execute(jedis -> jedis.getSet(key, value));
    }

    private static final String LOCK_SUCCESS = "OK";
    private static final Long RELEASE_SUCCESS = 1L;

    /**
     * 释放分布式锁
     *
     * @param lockKey   锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    public boolean releaseDistributedLock(String lockKey, String requestId) {

        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = execute(jedis -> jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId)));
        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;

    }

    /**
     * 尝试获取分布式锁
     *
     * @param lockKey    锁
     * @param requestId  请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     */
    public boolean tryGetDistributedLock(String lockKey, String requestId, int expireTime) {

        String result = execute(jedis -> jedis.set(lockKey, requestId, "NX", "EX", expireTime));
        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;

    }

    /**
     * 模糊删除
     */
    public void delCachesByKey(String key) {
        Set<String> keysList = keys(key);
        for (String rkey : keysList) {
            Long l = del(rkey);
        }
    }
}
