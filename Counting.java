package �˰������;
import java.util.*;
import java.math.*;

public class Counting {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		BigInteger [] counts = new BigInteger [1001];	//	���� �ε����� ���ڵ��� ����
		
		counts[1] = BigInteger.valueOf(2);	//	���� 1�� ���ڵ��� ����	1,4 (4 == 1�� ���)
		counts[2] = BigInteger.valueOf(5);	//	���� 2�� ���ڵ��� ����	11,41,14,44,2
		counts[3] = BigInteger.valueOf(13);	//	���� 3�� ���ڵ��� ����	111,411,141,441,21,114,414,144,444,24,12,42,3
		
		
		BigInteger tmp;
		for(int i =4; i<counts.length; i++) {	//	��Ģ�� �̿��Ͽ� ������ ������ ä���
			tmp = counts[i-1].multiply(BigInteger.valueOf(2));
			tmp = tmp.add(counts[i-2]);
			tmp = tmp.add(counts[i-3]);
			counts[i] = tmp;
		}
		
		while(input.hasNextInt()) {
			
			int sum = input.nextInt();		//	1�̻� 1000����
			System.out.println(counts[sum]);
			
		}		
	}
}