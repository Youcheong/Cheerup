package 알고리즘공부;
import java.util.*;
import java.math.*;

public class Subset {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);

		int num = input.nextInt();
		int[] arrays = new int [num+1];
		backtrack(arrays, 0, num);
		System.out.println("N: " + num);
		System.out.println("Number of subsets: " + (int)Math.pow(2,num));

	}
	/**
	 * 배열 a의 k번째까지의 값이 해인지 판별하고,
	 * 해이면 출력한다.
	 * 해가 아니면 a의 k+1번째에 들어 갈 수 있는 후보 값을 넣고 
	 * 이 함수를 다시 호출한다.(자기호출, recursion)	 
	 * @param a 해의 원소들이 들어가는 배열
	 * @param k 해의 원소 인덱스
	 * @param n 타당한 해의 크기
	 */
	public static void backtrack(int [] a, int k ,int n) {
		{
			int [] c = new int [2];
			int ncandidates = 2;
			if(k == n) {	//	원소의 개수가 타당한 해와 같을 때
				process_solution(a, k);
			}
			else {
				k = k+1;	
				construct_candidates(a,k,n,c);
				for(int i =0; i<ncandidates; i++) {
					a[k] = c[i];
					backtrack(a,k,n);
				}
			}
		}

	}

	/**
	 * 다음 인덱스에 들어갈 후보를 구한다.
	 * @param a 해의 원소들이 들어가 있는 배열
	 * @param k 해의 원소 인덱스
	 * @param n 타당한 해의 크기
	 * @param c	다음 원소의 출력 여부
	 */
	public static void construct_candidates(int [] a, int k ,int n, int [] c) {
		c[0] = 1;	//	출력 할 수 있다.
		c[1] = 0;	//	출력 할 수 없다.
	}
	/**
	 * 타당한 해를 출력한다.
	 * @param a 해의 원소들이 들어있는 배열 (배열 원소가 공집합 일 수 있다.)
	 * @param k 타당한 해의 크기 
	 */
	public static void process_solution(int [] a, int k) {


		System.out.print("{");
		for(int i =1; i<=k; i++) {
			if (a[i] == 1) {	//	1이면 인덱스를 출력
				System.out.print(" "+i );
			}
		}
		System.out.println(" }");
	}
}



