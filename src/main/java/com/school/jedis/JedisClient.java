package com.school.jedis;

import java.util.List;

/**
 * @author
 * @date
 */
public interface JedisClient {

    /**
     * redis的set语句
     *
     * @param key
     * @param value
     * @return String
     */
    String set(String key, String value);

    /**
     * redis的get语句
     *
     * @param key
     * @return String
     */
    String get(String key);

    /**
     * 判空
     *
     * @param key
     * @return Boolean
     */
    Boolean exists(String key);

    /**
     * 设置过期时间
     *
     * @param key
     * @param seconds
     * @return Long
     */
    Long expire(String key, int seconds);

    /**
     * 剩余时间
     *
     * @param key
     * @return Long
     */
    Long ttl(String key);

    /**
     * 自增长
     * @param key
     * @return Long
     */
    Long incr(String key);

    /**
     * redis的hset
     * @param key
     * @param field
     * @param value
     * @return Long
     */
    Long hset(String key, String field, String value);

    /**
     * redis的hget
     * @param key
     * @param field
     * @return Long
     */
    String hget(String key, String field);

    /**
     * redis的hdel
     * @param key
     * @param field
     * @return Long
     */
    Long hdel(String key, String... field);

    /**
     * hash的判空
     * @param key
     * @param field
     * @return Boolean
     */
    Boolean hexists(String key, String field);

    /**
     * 获取hash中key所对应的所有值
     * @param key
     * @return List<String>
     */
    List<String> hvals(String key);

    /**
     * del操作
     * @param key
     * @return Long
     */
    Long del(String key);
}
