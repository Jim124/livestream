package com.maindark.livestream.dao;

import com.maindark.livestream.domain.LiveStreamUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface LiveStreamUserDao {
    @Select("select * from live_stream_user where id=#{id}")
    public LiveStreamUser getById(@Param("id") long id);

    @Update("update live_stream_user set password = #{password} where id = #{id}")
    public void update(LiveStreamUser toBeUpdate);
}
