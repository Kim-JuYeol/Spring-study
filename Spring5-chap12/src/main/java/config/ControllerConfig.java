package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.RegisterController;
import controller.SurveyController;
import spring.MemberRegisterService;


@Configuration
public class ControllerConfig 
{
	@Autowired
	private MemberRegisterService memberRegsvc;
	
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
}
