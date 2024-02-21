package jp.co.cyzennt.bbs.BBS_Spring_Alier.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.board.service.BoardService;
import jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.user.model.MUser;
import jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.user.service.UserService;
import jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.userboard.model.MUserBoard;
import jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.userboard.model.MUserBoardDisplay;
import jp.co.cyzennt.bbs.BBS_Spring_Alier.domain.userboard.service.UserBoardService;
import jp.co.cyzennt.bbs.BBS_Spring_Alier.form.BoardForm;
import jp.co.cyzennt.bbs.BBS_Spring_Alier.form.MainForm;
import jp.co.cyzennt.bbs.BBS_Spring_Alier.util.SecuritySession;


/**
 * Class for displaying all data on the main page and deletion and addition of data in the main page.
 * @author Alier Torrenueva
 * 01/10/2024
*/

@Controller
@RequestMapping(value="/main")
public class MainController {
	
	// Declare UserService
	@Autowired
	private UserService userService;
	// Declare BoardService
	@Autowired
	private BoardService boardService;
	// Declare SecuritySession
	@Autowired
	private SecuritySession secSession;
	// Declare UserBoardService
	@Autowired
	private UserBoardService userBoardService;
	
	/**
	 * @return calls all of the board, route him to the /main and displays the current user 
	 * @params model
	 * @params locale
	 * @params mainForm
	 */
	@GetMapping(value="/main")
	public String getMain(Model model, Locale locale, @ModelAttribute MainForm mainForm) 
	{
		// Declares MUser and stores the result of secSession.getUsername to the userService.getLoginUser then transfers the data to Model User(MUser)
		MUser user = userService.getLoginUser(secSession.getUsername());
		
		// Transfers data from user to "user" object
		model.addAttribute("user", user);
		
		// Declares a List of MUserBoard then get the return of userBoardService.getBoardAll()
		List<MUserBoard> mUserBoard = userBoardService.getBoardAll();
		
		// Declares a List of MUserBoard as new ArrayList
		List<MUserBoardDisplay> userBoardDisplayList = new ArrayList<>();
		
		// iterates mUserBoard's data and give an alias of userBoard
	    for (MUserBoard userBoard : mUserBoard) {
	    	// Stores the data of MUserBoardDisplay which uses two parameters of iterated userBoard and secSssion.getUsername
	        MUserBoardDisplay userBoardDisplay = new MUserBoardDisplay(userBoard, secSession.getUsername());

	        // Adds userBoardDisplay to userBoardDisplayList.
	        userBoardDisplayList.add(userBoardDisplay);
	    }
	    
	    // Adds userBoardDisplayList to the model as "userBoardList".
	    model.addAttribute("userBoardList", userBoardDisplayList);
	    

	    // Returns the view "/main/main".
	    return "/main/main";
	}
	
	
	
	/**
	 * @return will delete a certain board using boardId and direct him to /main/main
	 * @params boardForm
	 * @params model
	 */
	@PostMapping(value="/delete")
	public String deleteBoard(BoardForm boardForm, Model model) {
		// declares the boardId and store it on boardFormId as int
	    int boardFormId = boardForm.getId();
	    
	    // converts the boardFormId to String and stores it to boardId
	    String boardId = String.valueOf(boardFormId);
	    
	    // gets the username of securesession and store it to username
	    String username = secSession.getUsername();
	    
	    // adds the value of boardId to the object "boardId"
	    model.addAttribute("boardId", boardId);
	    
	    // runs the boardService.deleteBoardOne with the parameters boardFormId, username
	    boardService.deleteBoardOne(boardFormId, username);
	    
	    // redirect the return to the main page.
	    return "redirect:/main/main";
	}


	
	
}
