package jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.board.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


/**
 * Class for model of board to be used on Controller and DAO. More like the inner model.
 * @author Alier Torrenueva
 * 01/11/2024
*/

@Data
@Entity
// annotate and named the class "board" as table name
@Table(name = "board")
public class MBoard {
	
	// declare properties of the board
	@Id
	private int id;			
	public String userId;				
	public String text;				
	public Date registerDate;				
}
