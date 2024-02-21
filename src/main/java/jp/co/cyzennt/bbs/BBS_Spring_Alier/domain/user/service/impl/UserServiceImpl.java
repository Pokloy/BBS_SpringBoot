package jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.user.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.user.model.MUser;
import jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.user.service.UserService;
import jp.co.cyzennt.bbs.BBS_Spring_Alier.repository.MUserDao;


/**
 * Class that interact with DAO that performs on finding the user details.
 * @author Alier Torrenueva
 * 01/12/2024
*/
@Service
public class UserServiceImpl implements UserService {
	
	// Autowired MUserDao dependency injection.
	@Autowired
	private MUserDao userDao;
	
	/**
	 * This method will get the users login by activating the userDao
	 * @params userId
	 * @return userDao.findLoginUser's return
	 */
	@Override
    public MUser getLoginUser(String userId) {
		// Return user details using userId.
        return userDao.findLoginUser(userId);
    }
}
