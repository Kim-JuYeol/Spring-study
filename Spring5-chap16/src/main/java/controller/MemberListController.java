package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.Errors;

import spring.Member;
import spring.MemberDao;

import validator.ListCommandValidator;

@Controller
public class MemberListController 
{
	private MemberDao memberDao;
	
	public void SetMemberDao(MemberDao memberDao)
	{
		this.memberDao = memberDao;
	}
	
	@RequestMapping("/members")
	public String list(@ModelAttribute("cmd") ListCommand listCommand,Errors errors, Model model)
	{
		if(errors.hasErrors())
			return "member/memberList";
		if (listCommand.getFrom() != null && listCommand.getTo() != null)
		{
			List<Member> members = memberDao.selectByRegdate(listCommand.getFrom(), listCommand.getTo());
			model.addAttribute("members", members);
		}
		return "member/memberList";
	}
}
