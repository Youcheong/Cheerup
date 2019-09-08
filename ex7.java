package �˰������;
import java.util.*;
/**
 * ����� ���ɻ縦 ���� ģ���� �ʴ��ϴ� ���α׷�
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
	 * �迭 ��� �޼ҵ�
	 * @param array	����� �迭
	 */
	public static void printarray(String[] array) {		

		for(int i =0; i<array.length; i++) {
			System.out.print(array[i] +" ");
		}
		System.out.println();
	}

	/**
	 * @param first ù ���� ���ɻ�
	 * @param second �� ��° ���ɻ�
	 * @return
	 */
	public static int bestInvitation(String[] first, String[] second) {
		HashMap<String, Integer> dic = new HashMap<String, Integer>();

		for(int i =0; i<first.length; i++) {		//���ɻ縦 key�� �ϰ� value�� 0���� �Է�
			dic.put(first[i], 0);
			dic.put(second[i],0);
		}

		for(int i =0; i<first.length; i++) {	// ���� key�� ������ ����� value���� +1
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
