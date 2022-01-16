package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Word;

/**
 * �ܾ� ������ ���� �����ͺ��̽� �۾��� �����ϴ� DAO Ŭ����
 * Word ���̺��� �ܾ� ������ �˻� ���� 
 */
public class WordDAO {
	private JDBCUtil jdbcUtil = null;
	
	public WordDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil ��ü ����
	}
	
	/**
	 * �־��� �ܾ� ID�� �ش��ϴ� �ܾ� ������ �����ͺ��̽����� ã�� Word ������ Ŭ������ 
	 * �����Ͽ� ��ȯ.
	 */
	public Word findWord(String wordsEng) throws SQLException {
        String sql = "SELECT wordId, wordsKor "
     		   		+ "FROM WORD "
        			+ "WHERE wordsEng=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {wordsEng});	// JDBCUtil�� query���� �Ű� ���� ����

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query ����
			if (rs.next()) {						// �ܾ� ���� �߰�
				Word word = new Word(			// Word ��ü�� �����Ͽ� ���� ���� ������ ����
						rs.getInt("wordId"),
						wordsEng,
						rs.getString("wordsKor"));
				return word;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}
		return null;
	}
	
	/**
	 * ��ü �ܾ� ������ �˻��Ͽ� List�� ���� �� ��ȯ
	 */
	public List<Word> findWordList() throws SQLException {
        String sql = "SELECT wordId, wordsEng, wordsKor "
        		   + "FROM WORD "
        		   + "ORDER BY wordId";        
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil�� query�� ����
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query ����			
			List<Word> wordList = new ArrayList<Word>();	// Word���� ����Ʈ ����
			while (rs.next()) {
				Word word = new Word(			// Word ��ü�� �����Ͽ� ���� ���� ������ ����
						rs.getInt("wordId"),
						rs.getString("wordsEng"),
						rs.getString("wordsKor"));					
				wordList.add(word);				// List�� Word ��ü ����
			}		
			return wordList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}
		return null;
	}
	
	
}