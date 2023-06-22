package com.poo.exhibitor.controllers;

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

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository; 
	
	@GetMapping("/")
    public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/login");
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
		userRepository.saveAndFlush(user);
		ModelAndView mv = new ModelAndView();	
		mv.setViewName("redirect:/");
		
		return getList(new UserModel());
	}
}
