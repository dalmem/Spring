package com.team404.user.mapper;

import java.util.ArrayList;

import com.team404.command.UserVO;

public interface UserMapper {
	public int idCheck(String userId);
	public int Join(UserVO vo);
	public UserVO Login(UserVO vo);
	public UserVO getInfo(String id);
}
