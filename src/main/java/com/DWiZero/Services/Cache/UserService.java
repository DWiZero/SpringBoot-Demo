package com.DWiZero.Services.Cache;

import com.DWiZero.Bean.VO.UserInfo;
import com.DWiZero.Mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "users")
public class UserService
{
    @Autowired
    UserInfoMapper userInfoMapper;

    //    @Cacheable(key = "#p0",condition="#uid%2==0")
    @Cacheable(key = "'user:'+#uid", condition = "#uid%2==0")
    public UserInfo findUser(Integer uid)
    {
        return userInfoMapper.selectByPrimaryKey(uid);
    }

    @CacheEvict(key = "'user:'+#p0")
    public int delUser(Integer uid)
    {
        return userInfoMapper.deleteByPrimaryKey(uid);
    }
}
