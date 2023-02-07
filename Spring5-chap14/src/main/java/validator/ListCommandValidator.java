package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import controller.ListCommand;

public class ListCommandValidator implements Validator
{
	@Override
	public boolean supports(Class<?> clazz)
	{
		return ListCommand.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors)
	{
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "from", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "to", "required");
	}
}
