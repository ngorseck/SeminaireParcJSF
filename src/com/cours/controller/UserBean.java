package com.cours.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.SelectEvent;

import com.cours.dao.IUser;
import com.cours.dao.UserImpl;
import com.cours.entities.User;

@ManagedBean(name="userbean")
@RequestScoped
public class UserBean {
	
	private String email;
	private String password;
	private IUser user_dao = new UserImpl();
	private List<User> users = new ArrayList<User>();
	private User user = new User();
	
	public String getAllUsers() {
		users = user_dao.liste();
		return "/view/user/liste.xhtml";
	}
	
	public String getConnexion() {
		String url = "index.xhtml";
		try {
			User u = user_dao.connection(email, password);
			if(u != null)
				url = "accueil.xhtml";
		}catch(Exception ex) {
			ex.printStackTrace();
			url = "index.xhtml";
		}
		return url;
	}
	public String addUser() {
		
		return "/view/user/liste.xhtml";
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
