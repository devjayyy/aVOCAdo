package model;

public class WordBook {

   private String userId;//�ܾ��� ���� ���̵�
   private int wordId; //�ܾ�� �ܾ������� �Ѿ�ö� �ܾ� ���� id�ʿ�
   private int wordBookId; //�ܾ��忡�� �ܾ� �����Ҷ�
   
   public WordBook() { } //�⺻ ������
   
   public WordBook(int wordId, int wordBookId, String userId) { 
      this.wordBookId = wordBookId;
      this.wordId = wordId;
      this.userId = userId;
   }

   public String getUserId() {
	      return userId;
   }
   public void setUserId(String userId) {
	      this.userId = userId;
  }
   
   public int getWordId() {
      return wordId;
   }
   public void setWordId(int wordId) {
      this.wordId = wordId;
   }

   public void setWordBookId(int wordBookId) {
      this.wordBookId = wordBookId;
   }
   public int getWordBookId() {
      return wordBookId;
   }

   
   @Override
   public String toString() {
      return "WordBook [wordId=" + wordId + ", wordBookId=" + wordBookId + "]";
   }

}

