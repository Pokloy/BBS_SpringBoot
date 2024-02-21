package jp.co.cyzennt.bbs.BBS_Spring_Alier.rest;

import java.util.HashMap;

import lombok.Data;


/**
 * Class that stores result of REST API and errors
 * @author Alier Torrenueva
 * 01/16/2024
*/
@Data
public class RestResult {
	
	// declares int named resultCode
 	private int resultCode;
 	
 	// declares HashMap named errors 
    private HashMap<String, String> errors;
    
    // declares String named redirecURL
    private String redirectUrl;
    
	/**
	 * Method that receives html status code and errors
	 * @param resultCode
	 * @param errors
	 */
    public RestResult(int resultCode, HashMap<String, String> errors) {
        this.setResultCode(resultCode);
        this.setErrors(errors);
    }
    
	/**
	 * Method that receives html status code and URL route
	 * @param resultCode
	 * @param redirectUrl
	 */
    public RestResult(int resultCode, String redirectUrl) {
        this.setResultCode(resultCode);
        this.setRedirectUrl(redirectUrl);
    }

}















