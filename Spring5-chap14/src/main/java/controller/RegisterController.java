package controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.Errors;

import spring.DuplicateMemberException;
import spring.MemberRegisterService;
import spring.RegisterRequest;

@Controller
public class RegisterController 
{
	
	private MemberRegisterService memebrRegisterService;
	
	public void setMemberRegisterService(MemberRegisterService memebrRegisterService)
	{
		this.memebrRegisterService = memebrRegisterService;
	}
	
	@RequestMapping("/register/step1")
	public String handleStep1() 
	{
		return "register/step1";
	}
	
	@PostMapping("/register/step2")
	public String handleStep2(@RequestParam(value = "agree", defaultValue = "false") Boolean agree, Model model)
	{
		if(!agree)
			return "register/step1";
		model.addAttribute("registerRequest", new RegisterRequest());
		return "register/step2";
	}
	@GetMapping("/register/step2")
	public String handleStep2Get()
	{
		return "redirect:/register/step1";
	}
	
	@PostMapping("/register/step3")
	public String handleStep3(@Valid RegisterRequest regReq, Errors errors)
	{
		try
		{
			memebrRegisterService.regist(regReq);
			return "register/step3";
		}catch(DuplicateMemberException e)
		{
			return "register/step2";
		}
	}
}