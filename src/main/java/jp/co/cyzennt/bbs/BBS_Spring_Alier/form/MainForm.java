package jp.co.cyzennt.bbs.BBS_Spring_Alier.form;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;


import lombok.Data;


/**
 * Class for model of user Log-in to be used on Security Config and ThymeLeaf. More like the outer model.
 * @author Alier Torrenueva
 * 01/16/2024
*/

@Data
public class MainForm {
	
	//Declares id,userId and registerData in a normal validations
	private int id;			
	private String userId;
	private Date registerDate;
	
	
	//Declares text with the validation errors and length numbers.
	@NotBlank(groups = ValidGroup1.class, message = "Please enter submission details")
    @Length(min = 1, max = 50, groups = ValidGroup2.class, message ="Please enter your submission within 50 characters.")
	private String text; 
	
}
