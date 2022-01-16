package controller.word;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.service.WordManager;
import model.Word;

public class ListWordController implements Controller {
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		
    	WordManager manager = WordManager.getInstance();
		List<Word> wordList = manager.findWordList();
		
		// wordList ��ü�� request�� �����Ͽ� �ܾ� ����Ʈ ȭ������ �̵�(forwarding)
		request.setAttribute("wordList", wordList);				
		return "/word/list.jsp";        
    }
}