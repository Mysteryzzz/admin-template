package com.mlearn.mapper;

import com.mlearn.entity.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * @author rezero
 */
public interface AdminMapper {


    Admin selectByEmail(@Param("email") String email);

    void updateSalt(@Param("id") Integer id, @Param("salt") String salt);

    void updatePassword(@Param("id") Integer id, @Param("password") String password);
}
