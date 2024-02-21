package jp.co.cyzennt.bbs.BBS_Spring_Alier.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.board.model.MBoard;

/**
 * DAO of Board which is for querying the needed data results for the system to retrieve
 * @author Alier Torrenueva
 * 01/16/2024
*/
public interface MboardDao extends JpaRepository<MBoard,Integer> {			
	
	/* JPQL Constants */		
	final String JPQL_DELETE_BOARD_ONE = "DELETE FROM MBoard b "
        								+ "WHERE b.id = :id "
    									+ "AND b.userId = :userId";
	
	
			
	/** Deleted (1) */		
	@Modifying		
	@Query(JPQL_DELETE_BOARD_ONE)		
	public int deleteOne(int id, String userId) throws DataAccessException;	
}			


