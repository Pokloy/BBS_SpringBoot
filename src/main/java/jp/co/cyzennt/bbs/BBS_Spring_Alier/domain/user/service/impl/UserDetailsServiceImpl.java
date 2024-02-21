package jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.user.model.MUser;
import jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.user.service.UserService;


/**
 * Class that implements Spring Security and loads it user details for authentication.
 * @author Alier Torrenueva
 * 01/11/2024
*/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	// Autowires the "userservice" bean into the "UserService" field.
	@Autowired
	private UserService userservice;
	
	
	/**
	 * This method will get the username of the log-in user and Authenticate
	 * @params userId
	 * @return userInfo
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// Calls the "getLoginUser" method from the "userservice" bean to retrieve a user by username, and assigns it to the "loginUser" variable of type MUser.
		MUser loginUser = userservice.getLoginUser(username);
		
		// If the retrieved "loginUser" is null, it throws a "UsernameNotFoundException" with the message "User not found."
		if(loginUser == null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		// Creates a security authority named "GENERAL."
		GrantedAuthority authority = new SimpleGrantedAuthority("GENERAL");
		
		// Creates an empty list for security authorities.
        List<GrantedAuthority> authorities = new ArrayList<>();			
        
        
        // Adds a security authority to the list.
        authorities.add(authority);			
			
        // UserDetails Creation			
        UserDetails userDetails = new User(loginUser.getUserId(), loginUser.getPassword(), authorities);			
			
        // Returns the authenticated user details.
        return userDetails;			
	}
}

