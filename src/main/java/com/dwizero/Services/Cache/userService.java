package com.dwizero.Services.Cache;

import com.dwizero.Bean.VO.userInfo;
import com.dwizero.Mapper.userInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "users")
public class userService
{
    @Autowired
    userInfoMapper userInfoMapper;

    //    @Cacheable(key = "#p0",condition="#uid%2==0")
    @Cacheable(key = "'user:'+#uid", condition = "#uid%2==0")
    public userInfo findUser(Integer uid)
    {
        return userInfoMapper.selectByPrimaryKey(uid);
    }

    @CacheEvict(key = "'user:'+#p0")
    public int delUser(Integer uid)
    {
        return userInfoMapper.deleteByPrimaryKey(uid);
    }
}
