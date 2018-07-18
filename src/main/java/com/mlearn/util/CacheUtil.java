package com.mlearn.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;


public class CacheUtil {

	@Resource
	private JedisPool pool = null;
	
	public String hashGet(String cacheKey, String field){
		String info = null;
		Jedis jedis = pool.getResource();
		
		try {
			info = jedis.hget(cacheKey, field);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
		return info;
	}
	
	public void hashSet(String cacheKey, String field, String value){
		Jedis jedis = pool.getResource();
		
		try {
			jedis.hset(cacheKey, field, value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
	}
	
}
