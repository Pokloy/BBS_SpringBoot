package jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.board.service;

import org.springframework.transaction.annotation.Transactional;

import jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.board.model.MBoard;

/**
 * Class that defining methods like postText and deleteBoardOne.
 * @author Alier Torrenueva
 * 01/11/2024
*/

public interface BoardService {
	
	/**
	 * Method that activates the postText with Moboard as parameters
	 * @params board
	 */
	public void postText(MBoard board);
	

	/**
	 * Method that activates the deleteBoardOne with id, userId as parameters
	 * @params id
	 * @params userId
	 */
	@Transactional
    public int deleteBoardOne(int id, String userId);
	
}
