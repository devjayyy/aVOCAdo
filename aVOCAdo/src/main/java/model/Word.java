package model;

/**
 * 단어 관리를 위해 필요한 도메인 클래스. Word 테이블과 대응됨
 */
public class Word {
   private int wordId;
   private String wordsEng;
   private String wordsKor;
   
   public Word() { } //기본 생성자
   
   public Word(int wordId, String wordsEng, String wordsKor) { 
      this.wordId = wordId;
      this.wordsEng = wordsEng;
      this.wordsKor = wordsKor;
   }

   public Word(String wordsEng, String wordKor) {
	   this.wordsEng = wordsEng;
	   this.wordsKor = wordKor;
}

   public int getWordId() {
      return wordId;
   }

   public void setWordId(int wordId) {
      this.wordId = wordId;
   }
   public String getWordsEng() {
      return wordsEng;
   }

   public void setWordsEng(String wordEng) {
      this.wordsEng = wordEng;
   }

   public String getWordsKor() {
      return wordsKor;
   }

   public void setWordsKor(String wordKor) {
      this.wordsKor = wordKor;
   }
   
   @Override
   public String toString() {
      return "Word [wordId=" + wordId + ", wordsEng=" + wordsEng + ", wordsKor=" + wordsKor + "]";
   }

}
