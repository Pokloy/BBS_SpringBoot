package jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.userboard.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * Class for All boards display settings and different conditions.
 * @author Alier Torrenueva
 * 01/12/2024
*/

@Data
public class MUserBoardDisplay {
	
	// declaration of ID, userID, textList, registerDateDisplay, userName, isDeleteDisplay for MUserBoardDIsplay to be used.
	private int id;	
	private String userId;		
	private List<String> textList;		
	private String registerDateDisplay;		
	private String userName;
	private boolean isDeleteDisplay;		
	
	/**
	 * Method that sets the Board based on userId
	 * @params mUserBoard
	 * @params sessionUserId
	 */
	public MUserBoardDisplay(MUserBoard mUserBoard, String sessionUserId) {				
    	// ID Settings			
    	this.id = mUserBoard.getId();			
    				
    	// User ID Settings			
    	this.userId = mUserBoard.getUserId();			
    				
    	// Post Content Settings		
    	// Place the response of sqlquery/DAO to Array and remove the \r\n = Filter
    	String[] textListTmp = mUserBoard.getText().replace("\r\n", "\n").split("\r|\n");			
    	
    	// declare textlist as ArrayList = instantiate
    	this.textList = new ArrayList<String>();			
    	
    	//Iterate all value of array of textListTmp and store all of it at once to textlist = bundled
    	for (String text : textListTmp) {
    		this.textList.add(text); 
    	}			
    				
    	// Set registration date and time			
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");			
    	this.registerDateDisplay = dateFormat.format(mUserBoard.getRegisterDate());			
    				
    	// Username Settings			
    	this.userName = mUserBoard.getUsername();			
    				
    	// Delete button display setting			
    	if (this.userId.equals(sessionUserId)) {			
    		this.isDeleteDisplay = true;		
    	} else {			
    		this.isDeleteDisplay = false;		
    	}					
	}				
}
