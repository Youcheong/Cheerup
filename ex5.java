//문자열 내림차순

import java.util.*;

class Solution {
  public String solution(String s) {
      
      String[] array = s.split("");
      Arrays.sort(array);
     Collections.reverse(Arrays.asList(array));
     return String.join("", array);

      
      }
}