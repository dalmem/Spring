package com.team404.user.service;



import com.team404.command.UserVO;

public interface UserService {
	

	public int idCheck(String userId);
	public int Join(UserVO vo);
	public UserVO Login(UserVO vo);
	public UserVO getInfo(String userId);
}
