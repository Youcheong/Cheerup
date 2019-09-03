// 배열안에 숫자를 주어진 숫자로 나누었을 때 나누어 지는 숫자 추출

import java.util.*;

class Solution {
  public int[] solution(int[] arr, int divisor) {
      
      int c =0;
      for(int i =0; i< arr.length; i++) {
          if(arr[i] % divisor == 0) {
              c++;
          }
      }
      int[] answer = new int [c];
        c =0;
      
       for(int i =0; i< arr.length; i++) {
          if(arr[i] % divisor == 0) {
              answer[c] = arr[i];
              c++;
          }
      }
      
        Arrays.sort(answer);
      
      if(answer.length == 0) {
          answer = new int [1];
          answer[0] = -1;
       
      }
      return answer;
  }
}