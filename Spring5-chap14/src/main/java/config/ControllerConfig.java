package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.RegisterController;
import controller.SurveyController;
import controller.LoginController;
import controller.ChangePwdController;
import controller.LogoutController;
import controller.MemberListController;
import controller.MemberDetailController;

import spring.AuthService;
import spring.MemberRegisterService;
import spring.ChangePasswordService;
import spring.MemberDao;

@Configuration
public class ControllerConfig 
{
	@Autowired
	private MemberRegisterService memberRegsvc;
	@Autowired
	private AuthService authService;
	@Autowired
	private ChangePasswordService changePasswordService;
	@Autowired
	private MemberDao memberDao;
	
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
	@Bean
	public MemberListController memberListController()
	{
		MemberListController controller = new MemberListController();
		controller.SetMemberDao(memberDao);
		return controller;
	}
	
	@Bean
	public MemberDetailController memberDetailController()
	{
		MemberDetailController controller = new MemberDetailController();
		controller.setMemberDao(memberDao);
		return controller;
	}
}
