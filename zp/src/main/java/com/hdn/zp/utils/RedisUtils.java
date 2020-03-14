package com.hdn.zp.utils;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by 多多啦 on 2020/3/13 0013.
 * 时间飞逝
 * time goes by
 * 時間が飛ぶ
 */

@Component
public class RedisUtils {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Resource(name = "stringRedisTemplate")
    private ValueOperations<String, String> valueOperations;

    /** 默认过期时长，单位：秒 */
    public final static long DEFAULT_EXPIRE = 60 * 60 * 24;

    /** 不设置过期时长 */
    public final static long NOT_EXPIRE = -1;

    /**
     * 是否存在
     *
     * @param key 键
     */
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 插入缓存默认时间
     *
     * @param key   键
     * @param value 值
     * @author zmr
     */
//    public void set(String key, Object value) {
//        set(key, value, DEFAULT_EXPIRE);
//    }

    /**
     * 插入缓存
     *
     * @param key    键
     * @param value  值
     * @param expire 过期时间(s)
     * @author zmr
     */
    public void set(String key, Object value, long expire) {
        valueOperations.set(key, toJson(value));
        redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    public void setOpsForListValue(String key, Object value, long expire) {
        redisTemplate.opsForList().rightPush(key, value);
        redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    public <T> List<T> getOpsForListValue(String key, Class<T> cls) {
        if (redisTemplate.opsForList().range(key, 0, -1).size() > 0) {
//            String jsonStr = JSON.toJSONString(redisTemplate.opsForList().range(key, 0, -1).get(0));
            String s = com.alibaba.fastjson.JSON.toJSONString(redisTemplate.opsForList().range(key, 0, -1).get(0));
            com.alibaba.fastjson.JSONArray jsonArray = com.alibaba.fastjson.JSONArray.parseArray(s);
            List<T> ts = jsonArray.toJavaList(cls);
            return ts;
        } else {
            return null;
        }
    }

    /**
     * 返回字符串结果
     *
     * @param key 键
     * @return
     * @author zmr
     */
    public String get(String key) {
        return valueOperations.get(key);
    }

    /**
     * 返回指定类型结果
     *
     * @param key   键
     * @param clazz 类型class
     * @return
     * @author zmr
     */
    public <T> T get(String key, Class<T> clazz) {
        String value = valueOperations.get(key);
        return value == null ? null : fromJson(value, clazz);
    }

    /**
     * 删除缓存
     *
     * @param key 键
     * @author zmr
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * redis自增
     */
    public long incr(String key) {
        Long val = redisTemplate.opsForValue().increment(key);
        return val;
    }

    public Boolean setNx(String key, Object value) {
        return redisTemplate.opsForValue().setIfAbsent(key, value);
    }

    public void expire(String key, long seconds) {
        redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
    }

    /**
     * Object转成JSON数据
     */
    private String toJson(Object object) {
        if (object instanceof Integer || object instanceof Long || object instanceof Float || object instanceof Double
                || object instanceof Boolean || object instanceof String) {
            return String.valueOf(object);
        }
        return com.alibaba.fastjson.JSON.toJSONString(object);
    }

    public long getExpireTimeType(String key) {
        long time = redisTemplate.getExpire(key, TimeUnit.SECONDS);
        return time;
    }

    /**
     * JSON数据，转成Object
     */
    private <T> T fromJson(String json, Class<T> clazz) {
//        return JSON.parseObject(json, clazz);
        return com.alibaba.fastjson.JSON.parseObject(json,clazz);
    }


}
