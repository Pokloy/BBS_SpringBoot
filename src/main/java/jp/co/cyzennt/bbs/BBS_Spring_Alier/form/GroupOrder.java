package jp.co.cyzennt.bbs.BBS_Spring_Alier.form;

import javax.validation.GroupSequence;

/**
 * Class for model Specifies validation group sequence for ordered validation checks.
 * @author Alier Torrenueva
 * 01/16/2024
*/

@GroupSequence({ ValidGroup1.class, ValidGroup2.class})
public interface GroupOrder {

}
