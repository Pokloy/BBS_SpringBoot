package jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.userboard.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * Class for model of board display
 * @author Alier Torrenueva
 * 01/12/2024
*/
@Data
@AllArgsConstructor
public class MUserBoard {
	
	// Unique identifier.
	private int id;	
	
	// User identification.
	private String userId;		
	
	//  Associated textual data.
	private String text;	
	
	//  Date of registration.
	private Date registerDate;	
	
	// User's chosen username.
	private String username	;

	
	/**
	 * Method that stores all the data to the objects.
	 * @params objects
	 */
	public MUserBoard(Object[] objects) {	
		// Constructor with parameter initialization.
		this(		
				(Integer) objects[0],
				(String) objects[1],
				(String) objects[2],
				(Date) objects[3],
				(String) objects[4]
			);	
	}			


}
