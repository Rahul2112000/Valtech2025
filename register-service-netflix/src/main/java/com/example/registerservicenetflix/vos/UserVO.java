package com.example.registerservicenetflix.vos;

import com.example.registerservicenetflix.entities.User;

public record UserVO(long id,String name,int age,String mobile,String email,boolean kid) {
	
	
	public static UserVO from(User user) {
		return new UserVO(user.getId(),user.getName(),user.getAge(),user.getMobileNo(),user.getEmail(),user.isKid());
	}
	
	public User to() {
		return new User(id,name,age,mobile,email,kid);
	}

}
