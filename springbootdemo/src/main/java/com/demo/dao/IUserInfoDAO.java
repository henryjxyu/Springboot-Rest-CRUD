package com.demo.dao;

import com.demo.entity.UserInfo;

public interface IUserInfoDAO {
	UserInfo getActiveUser(String userName);
}