// �迭�ȿ� �ߺ��Ǵ� ���� �ߺ� ���ֱ�

import java.util.*;

public class Solution {
	public int[] solution(int []arr) {
        
        
        int c =0;
        for(int i =0; i<arr.length-1; i++) {
          if(arr[i] != arr[i+1]) {
             c++;
          }
        }
        c++;
        
        int[] answer = new int [c];
        
        int o =0;
        
           for(int i =0; i<arr.length-1; i++) {
          if(arr[i] != arr[i+1]) {
             answer[o] = arr[i];
              o++;
          }
        }
        answer[o] = arr[arr.length-1];
      

        return answer;
	}
}