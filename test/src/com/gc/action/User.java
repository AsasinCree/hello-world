package com.gc.action;

import javax.servlet.ServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class User extends ActionForm{
private String name=null;
private String password=null;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
	public void reset(ActionMapping arg0, ServletRequest arg1) {
		name = null;
		password = null;
	}
}
