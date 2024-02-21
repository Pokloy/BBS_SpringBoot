package jp.co.cyzennt.bbs.BBS_Spring_Alier.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * JavaConfig class with a method for creating and returning ModelMapper.
 * @author Alier Torrenueva
 * 01/17/2024
 */

@Configuration
public class JavaConfig {
	
	
	/**
	 * This method will Instantiate and return a new instance of ModelMapper
	 * @return ModelMapper
	 */
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	} 
}
