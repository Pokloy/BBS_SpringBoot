package jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.user.service;


import jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.user.model.MUser;

/**
 * Class interface that activates a method of MUser.
 * @author Alier Torrenueva
 * 01/12/2024
*/
public interface UserService {
	
	/**
	 * Method that activates the getLoginUser with userId as parameters
	 * @params userId
	 */
	public MUser getLoginUser(String userId);														
														
}
