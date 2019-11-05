package 알고리즘공부;
import java.util.*;
import java.math.*;

public class Counting {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		BigInteger [] counts = new BigInteger [1001];	//	합이 인덱스인 숫자들의 개수
		
		counts[1] = BigInteger.valueOf(2);	//	합이 1인 숫자들의 개수	1,4 (4 == 1로 취급)
		counts[2] = BigInteger.valueOf(5);	//	합이 2인 숫자들의 개수	11,41,14,44,2
		counts[3] = BigInteger.valueOf(13);	//	합이 3인 숫자들의 개수	111,411,141,441,21,114,414,144,444,24,12,42,3
		
		
		BigInteger tmp;
		for(int i =4; i<counts.length; i++) {	//	규칙을 이용하여 나머지 개수들 채우기
			tmp = counts[i-1].multiply(BigInteger.valueOf(2));
			tmp = tmp.add(counts[i-2]);
			tmp = tmp.add(counts[i-3]);
			counts[i] = tmp;
		}
		
		while(input.hasNextInt()) {
			
			int sum = input.nextInt();		//	1이상 1000이하
			System.out.println(counts[sum]);
			
		}		
	}
}