package com.poo.exhibitor.controllers;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.poo.exhibitor.model.UserModel;
import com.poo.exhibitor.repository.UserRepository;
import com.poo.exhibitor.service.UserService;
import com.poo.exhibitor.userExceptions.ServiceExc;
import com.poo.exhibitor.util.UserUtil;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	public UserService userService;
	
	@GetMapping("/")
    public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/login");
		mv.addObject("user", new UserModel());
		return mv;
	}  


	@GetMapping("/cadastro")
    public ModelAndView getList(UserModel user){
		ModelAndView mv = new ModelAndView("cadastro");
		return mv;
	}
		
	@PostMapping("/cadastro/form/save")
	public ModelAndView saveUser(@Valid UserModel user, BindingResult result, RedirectAttributes redirect) throws Exception{
		
		if (user.getUsername().isEmpty() || user.getPhoneNumber().isEmpty() || user.getPassword().isEmpty()) {
	        redirect.addFlashAttribute("mensagemErro", "Erro ao cadastrar usuário. Dados inválidos.");
	        throw new Exception("Nao foi possível cadastrar");
	    }
		if(result.hasErrors()) {
			redirect.addFlashAttribute("mensagem","Erro ao cadastrar usuário");
			return getList(user);
		}
		userService.saveUser(user);
		ModelAndView mv = new ModelAndView();	
		mv.setViewName("redirect:/");
		
		return getList(new UserModel());
	}
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/index");
		mv.addObject("userModel", new UserModel());
		return mv;
	}
	
	@PostMapping("/login")
    public ModelAndView login(@Valid UserModel user, BindingResult br, HttpSession session) throws NoSuchAlgorithmException, ServiceExc{

		ModelAndView mv = new ModelAndView();
		mv.addObject("user", new UserModel());
		
		if (br.hasErrors()) {
	        mv.setViewName("/login");
	        return mv;
	    }
		UserModel userLogin = userService.getUserLogin(user.getUsername(), UserUtil.md5(user.getPassword()));
		if(userLogin == null) {
			mv.addObject("msg","User not found");
		}else {
			session.setAttribute("userLogged", userLogin);
			return index();
		}
		return mv;
	}
	
	@PostMapping("/logout")
	public ModelAndView logout(HttpSession session) {	
		session.invalidate();
		return login();
	}
	
}
