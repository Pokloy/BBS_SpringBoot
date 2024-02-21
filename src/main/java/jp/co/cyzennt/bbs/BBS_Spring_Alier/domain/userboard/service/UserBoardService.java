package jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.userboard.service;

import java.util.List;

import jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.userboard.model.MUserBoard;


/**
 * Class interface that create a list of MUserBoard for method getBoardAll.
 * @author Alier Torrenueva
 * 01/12/2024
*/
public interface UserBoardService {
	public List<MUserBoard> getBoardAll();
	
}
