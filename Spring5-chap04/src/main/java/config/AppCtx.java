package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Qualifier;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;
import spring.MemberListPrinter;
import spring.MemberPrinter;
import spring.MemberInfoPrinter;
import spring.VersionPrinter;
import spring.MemberSummaryPrinter;

@Configuration
public class AppCtx 
{
	@Bean
	public MemberDao memberDao()
	{
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc()
	{
		return new MemberRegisterService();
	}
	 @Bean
	 public ChangePasswordService changePwdSvc()
	 {
		 ChangePasswordService pwdSvc = new ChangePasswordService();
		 return pwdSvc;
	 }
	 @Bean
	 @Qualifier("printer")
	 public MemberPrinter memberPrinter()
	 {
		 return new MemberPrinter();
	 }
	 @Bean
	 @Qualifier("summaryPrinter")
	 public MemberSummaryPrinter memberPrinter2()
	 {
		 return new MemberSummaryPrinter();
	 }
	 @Bean
	 public MemberListPrinter listPrinter()
	 {
		 return new MemberListPrinter();
	 }
	 @Bean
	 public MemberInfoPrinter infoPrinter() 
	 {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setPrinter(memberPrinter2());
		return infoPrinter;
	 }
	 @Bean
	 public VersionPrinter versionPrinter()
	 {
		 VersionPrinter versionPrinter = new VersionPrinter();
		 versionPrinter.setMajorVersion(5);
		 versionPrinter.setMinorVersion(0);
		 return versionPrinter;
	 }
}