package jp.co.cyzennt.bbs.BBS_Spring_Alier.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.user.service.UserService;
import jp.co.cyzennt.bbs.BBS_Spring_Alier.form.LoginForm;

/**
 * Class for Login page and its html object access
 * @author Alier Torrenueva
 * 01/10/2024
*/
@Controller
public class LoginController {	
	/**
	 * @return goes to the page of "/login"
	 * @params model
	 * @params locale
	 * @params loginForm
	 */
	 @GetMapping("/login")
	 public String getLogin(Model model, Locale locale, @ModelAttribute("loginForm") LoginForm loginForm) {
		// return to the login page
		return "login/login"; 
	 }
}
