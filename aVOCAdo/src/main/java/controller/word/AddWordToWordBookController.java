package controller.word;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;

import model.Word;
import model.WordBook;
import model.service.WordManager;

public class AddWordToWordBookController  implements Controller {
	private static final Logger log = LoggerFactory.getLogger(AddWordToWordBookController.class);

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		Word word = null;
		String wordsEng = request.getParameter("wordsEng");
		WordManager manager = WordManager.getInstance();
		word = manager.findWord(wordsEng);		// 단어 정보 검색					
		
    	WordBook wordBook = new WordBook(0, 0, null); //wordBook 객체 생성
	
		wordBook = manager.addWordToWordBook(word, wordBook);
		
		request.setAttribute("word", word); //단어 정보 저장
		request.setAttribute("wordBook", wordBook);		// 단어장 정보 저장	

		log.debug("Add Word : {}", wordBook);
        return "redirect:/wordBook/list";	// 성공 시 단어장 리스트 화면으로 redirect
	}
}
