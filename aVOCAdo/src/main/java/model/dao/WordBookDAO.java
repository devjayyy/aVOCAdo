package model.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Word;
import model.WordBook;
import model.service.ExistingUserException;

/**
 * 단어장 관리를 위해 데이터베이스 작업을 전담하는 DAO 클래스
 * WORDBOOK 테이블에 단어 정보를  삭제, 검색 수행 
 */
public class WordBookDAO {
	private JDBCUtil jdbcUtil = null;
	
	public WordBookDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}

	/**
	 * 단어장 테이블에 새로운 행 생성 (PK 값은 Sequence를 이용하여 자동 생성)
	 */
	public WordBook add(Word word, WordBook wordBook) throws SQLException {
		String sql = "INSERT INTO WORDBOOK VALUES (?, ?)";		
		Object[] param = new Object[] {word.getWordId(), word.getWordId()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정
		try {				
			jdbcUtil.executeUpdate();	// insert 문 실행
			return wordBook;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return null;		
//		String key[] = {"wordBookId"};	// PK 컬럼의 이름     
//		try {    
//			jdbcUtil.executeUpdate(key);  // insert 문 실행
//		   	ResultSet rs = jdbcUtil.getGeneratedKeys();
//		   	if(rs.next()) {
//		   		int generatedKey = rs.getInt(1);   // 생성된 PK 값
//		   		wordBook.setWordBookId(generatedKey); 	// id필드에 저장  
//		   	}
//		   	return wordBook;
//		} catch (Exception ex) {
//			jdbcUtil.rollback();
//			ex.printStackTrace();
//		} finally {		
//			jdbcUtil.commit();
//			jdbcUtil.close();	// resource 반환
//		}		
//		return null;			
	}
						
	/**
	 * 단어장 내에서의 단어의 id로 에 해당하는 단어를 삭제.
	 */
	public int remove(String wordId) throws SQLException {
		String sql = "DELETE FROM WordBook WHERE \"wordId\"=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {wordId});	// JDBCUtil에 delete문과 매개 변수 설정

		try {				
			int result = jdbcUtil.executeUpdate();	// delete 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}


	public List<Word> findWordListInWordBook() throws SQLException {
		String sql = "SELECT wordId, wordsEng, wordsKor "
                + "FROM word, wordbook "
                + "WHERE word.wordid = wordbook.\"wordId\" "
                + "ORDER BY wordId";
	      jdbcUtil.setSqlAndParameters(sql, null);   // JDBCUtil에 query문과 매개 변수 설정
	      try {
	         ResultSet rs = jdbcUtil.executeQuery();      // query 실행
	         List<Word> wordList = new ArrayList<Word>();   // word들의 리스트 생성
	         while (rs.next()) {
	            Word word = new Word(         // Word 객체를 생성하여 현재 행의 정보를 저장
	                  rs.getInt("wordId"),
	                  rs.getString("wordsEng"),
	                  rs.getString("wordsKor"));               
	            wordList.add(word);            // List에 Word 객체 저장
	         }      
	         return wordList;               
	            
	      } catch (Exception ex) {
	         ex.printStackTrace();
	      } finally {
	         jdbcUtil.close();      // resource 반환
	      }
	      return null;
	   }

}

