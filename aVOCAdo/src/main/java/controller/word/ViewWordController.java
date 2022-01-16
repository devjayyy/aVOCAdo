package controller.word;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.WordManager;
import model.Word;
public class ViewWordController implements Controller {
	 @Override
	    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
	    	
	    	Word word = null;
			WordManager manager = WordManager.getInstance();
			String wordsEng = request.getParameter("wordsEng");
			word = manager.findWord(wordsEng);		// 단어 정보 검색			
			
			request.setAttribute("word", word);	// 단어 정보 저장				
			return "/word/view.jsp";				// 단어 보기 화면으로 이동
	    }
}

