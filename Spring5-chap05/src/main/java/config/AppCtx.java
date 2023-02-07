package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
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
@ComponentScan(basePackages = {"spring"})
public class AppCtx 
{
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
	 public VersionPrinter versionPrinter()
	 {
		 VersionPrinter versionPrinter = new VersionPrinter();
		 versionPrinter.setMajorVersion(5);
		 versionPrinter.setMinorVersion(0);
		 return versionPrinter;
	 }
}