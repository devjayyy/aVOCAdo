package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Word;

/**
 * 단어 관리를 위해 데이터베이스 작업을 전담하는 DAO 클래스
 * Word 테이블에서 단어 정보를 검색 수행 
 */
public class WordDAO {
	private JDBCUtil jdbcUtil = null;
	
	public WordDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
	
	/**
	 * 주어진 단어 ID에 해당하는 단어 정보를 데이터베이스에서 찾아 Word 도메인 클래스에 
	 * 저장하여 반환.
	 */
	public Word findWord(String wordsEng) throws SQLException {
        String sql = "SELECT wordId, wordsKor "
     		   		+ "FROM WORD "
        			+ "WHERE wordsEng=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {wordsEng});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// 단어 정보 발견
				Word word = new Word(			// Word 객체를 생성하여 현재 행의 정보를 저장
						rs.getInt("wordId"),
						wordsEng,
						rs.getString("wordsKor"));
				return word;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	/**
	 * 전체 단어 정보를 검색하여 List에 저장 및 반환
	 */
	public List<Word> findWordList() throws SQLException {
        String sql = "SELECT wordId, wordsEng, wordsKor "
        		   + "FROM WORD "
        		   + "ORDER BY wordId";        
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<Word> wordList = new ArrayList<Word>();	// Word들의 리스트 생성
			while (rs.next()) {
				Word word = new Word(			// Word 객체를 생성하여 현재 행의 정보를 저장
						rs.getInt("wordId"),
						rs.getString("wordsEng"),
						rs.getString("wordsKor"));					
				wordList.add(word);				// List에 Word 객체 저장
			}		
			return wordList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	
}