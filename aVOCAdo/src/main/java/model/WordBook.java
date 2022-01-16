package model;

public class WordBook {

   private String userId;//단어장 주인 아이디
   private int wordId; //단어에서 단어장으로 넘어올때 단어 고유 id필요
   private int wordBookId; //단어장에서 단어 삭제할때
   
   public WordBook() { } //기본 생성자
   
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

