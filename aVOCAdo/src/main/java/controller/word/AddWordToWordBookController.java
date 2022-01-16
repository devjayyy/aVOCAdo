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
		word = manager.findWord(wordsEng);		// �ܾ� ���� �˻�					
		
    	WordBook wordBook = new WordBook(0, 0, null); //wordBook ��ü ����
	
		wordBook = manager.addWordToWordBook(word, wordBook);
		
		request.setAttribute("word", word); //�ܾ� ���� ����
		request.setAttribute("wordBook", wordBook);		// �ܾ��� ���� ����	

		log.debug("Add Word : {}", wordBook);
        return "redirect:/wordBook/list";	// ���� �� �ܾ��� ����Ʈ ȭ������ redirect
	}
}
