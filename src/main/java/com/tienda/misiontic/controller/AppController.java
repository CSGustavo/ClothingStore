package com.tienda.misiontic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	
	@GetMapping({"/","/login"})
	public String index(){
		return "index";
	}
	
	@GetMapping({"/menu"})
	public String menu(){
		return "menu";
	}
	
	@GetMapping({"/usuario"})
	public String usuario(){
		return "usuario";
	}
	
	@GetMapping({"/admin"})
	public String admin(){
		return "admin";
	}
	
	@GetMapping({"/logout"})
	public String logout(){
		return "logout";
	}
	
	@RequestMapping("/validar")
	public String validar(HttpServletRequest req, HttpServletRequest resp) {
		String usuario=req.getParameter("usuario");
		String password=req.getParameter("password");
		
		if(usuario.equals("admininicial") && password.equals("admin123456")) {
			return "menu";
		} else {
			return "error";
		}
	}
}
	
