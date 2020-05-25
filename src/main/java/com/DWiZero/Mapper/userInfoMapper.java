package com.DWiZero.Mapper;

import com.DWiZero.Bean.VO.userInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface userInfoMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(userInfo record);

    int insertSelective(userInfo record);

    userInfo selectByPrimaryKey(@Param("userId") Integer userId);

    int updateByPrimaryKeySelective(userInfo record);

    int updateByPrimaryKey(userInfo record);
}