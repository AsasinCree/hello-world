package com.gc.action;

import com.gc.impl.Regedit;

public class RegeditImpl implements Regedit {
private String msg;
	
	@Override
	public String saveUser(User user) {
		if("un".equals(user.getName())&&"ps".equals(user.getPassword())){
			msg = "register success";
		}else {
			msg = "fail";
		}
		return msg;
	}

}
