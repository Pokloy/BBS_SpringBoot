package jp.co.cyzennt.bbs.BBS_Spring_Alier.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.user.model.MUser;
import jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.userboard.model.MUserBoard;


/**
 * DAO of User which is for querying the needed data results for the system to retrieve
 * @author Alier Torrenueva
 * 01/16/2024
*/

public interface MUserDao extends JpaRepository<MUser,String>{																											
	
	/* JPQL Constants */																										
	final String JPQL_FIND_LOGIN_USER = 	" SELECT u "																										
											+ " FROM MUser u " 																
											+ " WHERE u.userId = :userId ";																
																											
	/* SQL Constants */																										
	final String SQL_FIND_BOARD_ALL = " SELECT b.id, "																										
										+ " u.user_id, "																	
										+ " b.text, "																	
										+ " b.register_date, " 																	
										+ " u.user_name " 																	
										+ " FROM user u "																	
										+ " INNER JOIN board b "																	
										+ " ON u.user_id = b.user_id ";																	
																											
	/** Get Logged-In User Information */																										
	@Query(JPQL_FIND_LOGIN_USER)																										
	public MUser findLoginUser(String userId) throws DataAccessException;																										
																											
	/** Bulletin Board All Acquisitions */																										
	@Query(value=SQL_FIND_BOARD_ALL, nativeQuery = true)																										
	public List<Object[]> findBoardAllRaw() throws DataAccessException;																										
																											
	/** BBS all-acquisition type conversion **/																										
	public default List<MUserBoard> findBoardAll(){																										
																											
		return findBoardAllRaw()																									
				.stream() // Converts acquisition results to stream																							
				.map(MUserBoard::new) // Convert stream to MUserBoard type																							
				.collect(Collectors.toList()); // Formed into list																																															
	};																												
}	







