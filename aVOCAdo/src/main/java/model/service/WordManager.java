package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.WordBookDAO;
import model.dao.WordDAO;
import model.Word;
import model.WordBook;

/**
 * 단어 관리 API를 사용하는 개발자들이 직접 접근하게 되는 클래스.
 * WordDAO를 이용하여 데이터베이스에 데이터 조작 작업이 가능하도록 하며,
 * 데이터베이스의 데이터들을 이용하여 비지니스 로직을 수행하는 역할을 한다.
 * 비지니스 로직이 복잡한 경우에는 비지니스 로직만을 전담하는 클래스를 
 * 별도로 둘 수 있다.
 */
public class WordManager {
	private static WordManager wordMan = new WordManager();
	private WordDAO wordDAO;
	private WordBookDAO wordBookDAO;
	
	
	private WordManager() {
		try {
			wordDAO = new WordDAO();
			wordBookDAO = new WordBookDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static WordManager getInstance() {
		return wordMan;
	}
	
	public List<Word> findWordList() throws SQLException {
		return wordDAO.findWordList();
	}
	
	public Word findWord(String wordsEng) throws SQLException{
			Word word = wordDAO.findWord(wordsEng);
					
			return word;
		}
	
	public List<Word> findWordListInWordBook() throws SQLException {
		return wordBookDAO.findWordListInWordBook();
	}
	
	public WordBook addWordToWordBook(Word word, WordBook wordBook) throws SQLException{
//		if (wordBookDAO.existingWord(word.getWordId()) == true) {
//			throw new ExistingWordException(word.getWordId() + "는 존재하는 단어입니다.");
//		}
		return wordBookDAO.add(word, wordBook);
	}

	public int remove(String wordId) throws SQLException {
		return wordBookDAO.remove(wordId);
	}

}