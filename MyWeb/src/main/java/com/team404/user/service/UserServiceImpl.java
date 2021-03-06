package com.team404.user.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team404.command.UserVO;
import com.team404.user.mapper.UserMapper;
@Service("UserService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper usermapper;
	@Override
	public int idCheck(String userId) {
		
		
		
		return usermapper.idCheck(userId); 
	}
	@Override
	public int Join(UserVO vo) {
		
		return usermapper.Join(vo);
	}
	@Override
	public UserVO Login(UserVO vo) {
		
		return usermapper.Login(vo);
	}
	@Override
	public UserVO getInfo(String userId) {
		
		return usermapper.getInfo(userId);
	}


}
