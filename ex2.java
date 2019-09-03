//s의 가운데 글자 추출하기

class Solution {
  public String solution(String s) {
      String answer = "";
      
      if(s.length() % 2== 0) {
            answer = ""+s.charAt(s.length()/2-1) + s.charAt(s.length()/2);
      }
      else {
          answer = ""+ s.charAt(s.length()/2);
      }
      return answer;
  }
}