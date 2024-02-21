package jp.co.cyzennt.bbs.BBS_Spring_Alier.rest;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.board.model.MBoard;
import jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.board.service.BoardService;
import jp.co.cyzennt.bbs.BBS_Spring_Alier.form.GroupOrder;
import jp.co.cyzennt.bbs.BBS_Spring_Alier.form.MainForm;
import jp.co.cyzennt.bbs.BBS_Spring_Alier.util.SecuritySession;



/**
 * Class that controls data insertion thru thymeleaf then to domain package
 * @author Alier Torrenueva
 * 01/16/2024
*/
@RestController
@RequestMapping(value = "main")
public class MainRestController {
	
	// Declares BoardService
	@Autowired
	BoardService boardService;
	
	// Declares ModelMapper
	@Autowired
	ModelMapper modelMapper;
	
	// Declares SecuritySession
	@Autowired
	SecuritySession secSession;
	
	// Declares MessageSource
	@Autowired
	MessageSource messageSource;
	
	/**
	 * Method that Controls data insertion from thymeleaf to Domain
	 * @param model
	 * @param locale
	 * @param mainForm
	 * @param bindingResult
	 * @return REST API CODE and an HashMap of errors
	 */
	@PostMapping(value = "/insert/rest")
	public RestResult insertRest(Model model, Locale locale, @ModelAttribute @Validated(GroupOrder.class) MainForm mainForm, BindingResult bindingResult) {
	    
		// conditionally finds errors on validations
		if (bindingResult.hasErrors()) {
			// declare a hashmap
	    	HashMap<String, String> errors = new HashMap<>();
	    	
	    	// Gets the current locale from the LocaleContextHolder.
	    	Locale currentLocale = LocaleContextHolder.getLocale();
	    	
	    	// Iterates over field validation errors in Spring's bindingResult.
	    	 for (FieldError error : bindingResult.getFieldErrors()) {
	    		 
	    		 	//  Gets error message from messageSource using currentLocale.
	                String errorMessage = messageSource.getMessage(error, currentLocale);
	                
	                // Maps field and corresponding error message into errors collection.
	                errors.put(error.getField(), errorMessage);
	            }
	    	 
	    	 // Returns a REST result with a 404 status and error details.
	    	 return new RestResult(404, errors);
	    }
		// Sets the user ID in the main form using the username from the security session.
	    mainForm.setUserId(secSession.getUsername());
	    
	    // Sets the registration date in the main form to the current date.
	    mainForm.setRegisterDate(new Date());
	    
	    // Maps data from mainForm to a new MBoard object using modelMapper.
	    MBoard board = modelMapper.map(mainForm, MBoard.class);
	    
	    // Calls postText method of boardService, passing board as a parameter.
	    boardService.postText(board);
	    
	    // Returns a RestResult object with status 200 and the string "/main/main".
	    return new RestResult(200, "/main/main");
	}
}
