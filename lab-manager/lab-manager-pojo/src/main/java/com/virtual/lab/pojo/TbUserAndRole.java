package com.virtual.lab.pojo;

import java.io.Serializable;
import java.util.List;

public class TbUserAndRole extends TbUser implements Serializable{
	//角色
    private List<AuthRole> authRole;
    
    public String getRoleNames(){
    	String roleNames = "";
    	for (AuthRole role : authRole) {
			String name = role.getName();
			roleNames += name + " ";
		}
    	return roleNames;
    }

	public List<AuthRole> getAuthRole() {
		return authRole;
	}

	public void setAuthRole(List<AuthRole> authRole) {
		this.authRole = authRole;
	}
    
    
}
