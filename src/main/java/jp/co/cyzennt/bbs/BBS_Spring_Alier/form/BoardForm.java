package jp.co.cyzennt.bbs.BBS_Spring_Alier.form;

import java.util.List;

import lombok.Data;


/**
 * Class for model of board display to be used on Controller and ThymeLeaf. More like the outer model.
 * @author Alier Torrenueva
 * 01/15/2024
*/
@Data
public class BoardForm {
	
	// Data model with ID, user details, text list, date, username, and delete flag display status.
	private int id;									
	private String userId;											
	private List<String> textList;											
	private String registerDateDisplay;											
	private String username;											
	private boolean isDeleteDisplay;											
}
