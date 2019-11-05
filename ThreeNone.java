package 알고리즘공부;
import java.util.*;

public class ThreeNone {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n, count;
		
		
		while(input.hasNextInt()) {
			int max = 0;
			int start = input.nextInt();
			int end = input.nextInt();
			
			for(int i = start; i<=end; i++) {
				count = 1;
				n = i;
				while(n!=1) {	// n이 1이 될 때 까지
					if(n % 2 ==0) {	// 짝수 일 때
						n = n/2;
						count++;
					}
					else {	// 홀수 일 때
						n = n*3+1;
						count++;
					}
				}
				if(max < count) max = count;	// 최대 사이클 수 구하기
			}
			
			System.out.println(start + " " + end + " " + max);
		}
	}
}