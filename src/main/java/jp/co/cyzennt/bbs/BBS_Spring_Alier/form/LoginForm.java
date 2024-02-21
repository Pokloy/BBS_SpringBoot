package jp.co.cyzennt.bbs.BBS_Spring_Alier.form;

//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Pattern;
//import org.hibernate.validator.constraints.Length;



import lombok.Data;

/**
 * Class for model of user Log-in to be used on Security Config and ThymeLeaf. More like the outer model.
 * @author Alier Torrenueva
 * 01/16/2024
*/


@Data
public class LoginForm {
	

	// Declares the userId
	private String userId;	
	
	
	// Declares the password
	private String password;	
}
