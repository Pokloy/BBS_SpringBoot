package jp.co.cyzennt.bbs.BBS_Spring_Alier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * Class for user log-out
 * @author Alier Torrenueva
 * 01/10/2024
*/

@Controller
public class LogoutController {
	
	/**
	 *  @return when user logs-out he will redirected to login
	 */
	@PostMapping(value = "/logout")
	public String postLogout() {
		
		// redirects to the login page.
		return "redirect:/login";
	}
}
