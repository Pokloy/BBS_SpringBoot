package jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.user.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

/**
 * Class for model of user to be used on Controller and DAO. More like the inner model.
 * @author Alier Torrenueva
 * 01/11/2024
*/

@Data
@Entity
//Specifies the database table name "user" for JPA entity mapping.
@Table(name = "user")
public class MUser {
	

	// Represents the primary key field "userId" and additional fields "password" and "userName"
	@Id
	private String userId;							
	private String password;							
	private String userName;							

}
