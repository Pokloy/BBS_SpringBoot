package jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.board.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.board.model.MBoard;
import jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.board.service.BoardService;
import jp.co.cyzennt.bbs.BBS_Spring_Alier.repository.MboardDao;

/**
 * Class that interact with DAO that performs delete and adding.
 * @author Alier Torrenueva
 * 01/11/2024
*/


@Service
public class BoardServiceImpl implements BoardService {
	
	// Declare BoardDao
  	@Autowired
    private MboardDao mBoardDao;
	
	/**
	 * This method perform to save the paramater board by using the DAO of save.
	 * @params board
	 */
	@Override
	public void postText(MBoard board) {
		
		// Saves the "board" param using the mBoardDao.
		mBoardDao.save(board);
	}
	
	/**
	 * This method performs deletion with the parameters of id and userId as references with the use of method DAO of deletion.
	 * @params id
	 * @params userId
	 * @return deleteCount(int)
	 */
	@Override
	public int deleteBoardOne(int id, String userId) {

		// Deletes a record from the database using mBoardDao, with specified "id" and "userId". The number of deleted records is stored in "deleteCount".
		int deleteCount = mBoardDao.deleteOne(id, userId);
		

		// Returns the count of records deleted, typically used as an indicator of the success of the deletion operation.
		return deleteCount;
	}
	
}
