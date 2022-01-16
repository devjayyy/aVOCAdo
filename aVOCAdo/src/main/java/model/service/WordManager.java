package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.WordBookDAO;
import model.dao.WordDAO;
import model.Word;
import model.WordBook;

/**
 * �ܾ� ���� API�� ����ϴ� �����ڵ��� ���� �����ϰ� �Ǵ� Ŭ����.
 * WordDAO�� �̿��Ͽ� �����ͺ��̽��� ������ ���� �۾��� �����ϵ��� �ϸ�,
 * �����ͺ��̽��� �����͵��� �̿��Ͽ� �����Ͻ� ������ �����ϴ� ������ �Ѵ�.
 * �����Ͻ� ������ ������ ��쿡�� �����Ͻ� �������� �����ϴ� Ŭ������ 
 * ������ �� �� �ִ�.
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
//			throw new ExistingWordException(word.getWordId() + "�� �����ϴ� �ܾ��Դϴ�.");
//		}
		return wordBookDAO.add(word, wordBook);
	}

	public int remove(String wordId) throws SQLException {
		return wordBookDAO.remove(wordId);
	}

}