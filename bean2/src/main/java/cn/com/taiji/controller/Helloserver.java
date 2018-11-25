package cn.com.taiji.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
@Component
public class Helloserver {
	
	private String name;
	
	public Helloserver(String name) {
		super();
		this.name = name;
	}
	
	public Helloserver() {
		super();
		
	}
	
	public String toString() {
		return "Helloserver [name=" + name + "]";
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
