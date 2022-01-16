package model.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Word;
import model.WordBook;
import model.service.ExistingUserException;

/**
 * �ܾ��� ������ ���� �����ͺ��̽� �۾��� �����ϴ� DAO Ŭ����
 * WORDBOOK ���̺� �ܾ� ������  ����, �˻� ���� 
 */
public class WordBookDAO {
	private JDBCUtil jdbcUtil = null;
	
	public WordBookDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil ��ü ����
	}

	/**
	 * �ܾ��� ���̺� ���ο� �� ���� (PK ���� Sequence�� �̿��Ͽ� �ڵ� ����)
	 */
	public WordBook add(Word word, WordBook wordBook) throws SQLException {
		String sql = "INSERT INTO WORDBOOK VALUES (?, ?)";		
		Object[] param = new Object[] {word.getWordId(), word.getWordId()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil �� insert���� �Ű� ���� ����
		try {				
			jdbcUtil.executeUpdate();	// insert �� ����
			return wordBook;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ��ȯ
		}		
		return null;		
//		String key[] = {"wordBookId"};	// PK �÷��� �̸�     
//		try {    
//			jdbcUtil.executeUpdate(key);  // insert �� ����
//		   	ResultSet rs = jdbcUtil.getGeneratedKeys();
//		   	if(rs.next()) {
//		   		int generatedKey = rs.getInt(1);   // ������ PK ��
//		   		wordBook.setWordBookId(generatedKey); 	// id�ʵ忡 ����  
//		   	}
//		   	return wordBook;
//		} catch (Exception ex) {
//			jdbcUtil.rollback();
//			ex.printStackTrace();
//		} finally {		
//			jdbcUtil.commit();
//			jdbcUtil.close();	// resource ��ȯ
//		}		
//		return null;			
	}
						
	/**
	 * �ܾ��� �������� �ܾ��� id�� �� �ش��ϴ� �ܾ ����.
	 */
	public int remove(String wordId) throws SQLException {
		String sql = "DELETE FROM WordBook WHERE \"wordId\"=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {wordId});	// JDBCUtil�� delete���� �Ű� ���� ����

		try {				
			int result = jdbcUtil.executeUpdate();	// delete �� ����
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ��ȯ
		}		
		return 0;
	}


	public List<Word> findWordListInWordBook() throws SQLException {
		String sql = "SELECT wordId, wordsEng, wordsKor "
                + "FROM word, wordbook "
                + "WHERE word.wordid = wordbook.\"wordId\" "
                + "ORDER BY wordId";
	      jdbcUtil.setSqlAndParameters(sql, null);   // JDBCUtil�� query���� �Ű� ���� ����
	      try {
	         ResultSet rs = jdbcUtil.executeQuery();      // query ����
	         List<Word> wordList = new ArrayList<Word>();   // word���� ����Ʈ ����
	         while (rs.next()) {
	            Word word = new Word(         // Word ��ü�� �����Ͽ� ���� ���� ������ ����
	                  rs.getInt("wordId"),
	                  rs.getString("wordsEng"),
	                  rs.getString("wordsKor"));               
	            wordList.add(word);            // List�� Word ��ü ����
	         }      
	         return wordList;               
	            
	      } catch (Exception ex) {
	         ex.printStackTrace();
	      } finally {
	         jdbcUtil.close();      // resource ��ȯ
	      }
	      return null;
	   }

}

