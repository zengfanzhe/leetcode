package com.coding.pkgfortest.redis;

import redis.clients.jedis.Jedis;


public class RedisTest {
    public static void main(String[] args) {
        Jedis client=new Jedis("192.168.159.134",6379); // 创建客户端 设置IP和端口
        client.auth("admin");
        if(client.isConnected()){
            client.set("message", "helloWorld");
            System.out.println(client.get("message"));
            client.close();
        }else{
            System.out.println("redis is not connected....");
        }
    }
}
