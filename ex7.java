package 알고리즘공부;
import java.util.*;
/**
 * 공통된 관심사를 갖은 친구들 초대하는 프로그램
 * @author Han
 *
 */
public class EX2 {
	public static void main(String [] args) {

		String [] first = {"snakes","programming","cobra", "monty"};
		String [] second = {"python","python", "anaconda", "python"};


		System.out.print("first: "); printarray(first);
		System.out.print("second: "); printarray(second);
		System.out.print("Returns: " + bestInvitation(first, second)); 


	}
	/**
	 * 배열 출력 메소드
	 * @param array	출력한 배열
	 */
	public static void printarray(String[] array) {		

		for(int i =0; i<array.length; i++) {
			System.out.print(array[i] +" ");
		}
		System.out.println();
	}

	/**
	 * @param first 첫 번쨰 관심사
	 * @param second 두 번째 관심사
	 * @return
	 */
	public static int bestInvitation(String[] first, String[] second) {
		HashMap<String, Integer> dic = new HashMap<String, Integer>();

		for(int i =0; i<first.length; i++) {		//관심사를 key로 하고 value는 0으로 입력
			dic.put(first[i], 0);
			dic.put(second[i],0);
		}

		for(int i =0; i<first.length; i++) {	// 같은 key가 나오면 저장된 value값에 +1
			dic.put( first[i], dic.get(first[i])+1);
			dic.put( second[i], dic.get(second[i])+1);
		}
		
		int ans =0;
		for( String key : dic.keySet() ) {
			ans = Math.max(ans,dic.get(key));
			System.out.println(key + " "+ dic.get(key));
		}
		return ans;
	}
}
