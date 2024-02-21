package jp.co.cyzennt.bbs.BBS_Spring_Alier.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * Class that defines a SecuritySession component for obtaining the username from the current security context using SecurityContextHolder.
 * @author Alier Torrenueva
 * 01/16/2024
*/
@Component
public class SecuritySession {
	
	/**
	 * Method that returns the username of the currently authenticated user, retrieved from the security context.
	 * @return either null or 
	 */
	public String getUsername() {
		
		// retrieves the current user
	    Authentication authentication = SecurityContextHolder.getContext()							
	            .getAuthentication();							
	    
	    // validate if the current user is null
	    if (authentication != null) {			
	    	
	    	// This code retrieves the principal (user) object from the authentication information.
	        Object principal = authentication.getPrincipal();							
	        
	        // This condition checks if the principal object is an instance of UserDetails.
	        if (principal instanceof UserDetails) {							
	        	
	        	// This returns the username associated with the UserDetails object in the principal.
	            return ((UserDetails) principal).getUsername();	
	            
	        }			
	        
	        // This returns the string representation of the principal if it is not an instance of UserDetails.
	        return (String) principal.toString();							
	    }	
	    
	    // returns null
	    return null;							

	}

}
