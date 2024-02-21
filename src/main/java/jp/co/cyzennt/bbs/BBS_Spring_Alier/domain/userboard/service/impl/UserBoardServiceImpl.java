package jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.userboard.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.userboard.model.MUserBoard;
import jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.userboard.service.UserBoardService;
import jp.co.cyzennt.bbs.BBS_Spring_Alier.repository.MUserDao;

/**
 * Class that interact with DAO that finds all post.
 * @author Alier Torrenueva
 * 01/15/2024
*/

@Service
public class UserBoardServiceImpl implements UserBoardService {
	
	// Declaration of MUserDao.
	@Autowired
	private MUserDao mUserDao;
	
	/**
	 * Method that sets the Board based on userId
	 * @return the result of MuserDao findboardall
	 */
	@Override
	public List<MUserBoard> getBoardAll() {
		return mUserDao.findBoardAll();
	}

}
