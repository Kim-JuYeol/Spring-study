package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.RegisterController;
import controller.SurveyController;
import controller.LoginController;
import controller.ChangePwdController;
import controller.LogoutController;

import spring.AuthService;
import spring.MemberRegisterService;
import spring.ChangePasswordService;

@Configuration
public class ControllerConfig 
{
	@Autowired
	private MemberRegisterService memberRegsvc;
	@Autowired
	private AuthService authService;
	@Autowired
	private ChangePasswordService changePasswordService;
	
	@Bean
	public RegisterController registerController()
	{
		RegisterController controller = new RegisterController();
		controller.setMemberRegisterService(memberRegsvc);
		return controller;
	}
	
	@Bean
	public SurveyController surveyController()
	{
		return new SurveyController();
	}
	
	@Bean
	public LoginController loginController()
	{
		LoginController controller = new LoginController();
		controller.setAuthService(authService);
		return controller;
	}
	
	@Bean
	public LogoutController logoutController()
	{
		return new LogoutController();
	}
	
	@Bean
	public ChangePwdController changePwdController()
	{
		ChangePwdController controller = new ChangePwdController();
		controller.setChangePasswordService(changePasswordService);
		return controller;
		
	}
}
