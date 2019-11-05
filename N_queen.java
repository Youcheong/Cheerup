package 알고리즘공부;
import java.util.*;
import java.math.*;

public class N_queen {
	static int count =0;	//	해의 개수
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int [] arrays = new int [n+1];	//	각 줄의 퀸의 위치가 들어갈 배열
		backtrack(arrays,0,n);
		System.out.print("n=" + n + ", number_of_solutions="+count);

	}




	/**
	 * 배열 a의 k번째까지의 값이 해인지 판별하고,
	 * 해이면 출력한다.
	 * 해가 아니면 a의 k+1번째에 들어 갈 수 있는 후보 값을 넣고 
	 * 이 함수를 다시 호출한다.(자기호출, recursion)
	 * @param a 각줄의 퀸의 위치가 들어가 배열
	 * @param k 퀸의 위치를 찾은 줄의 길이
	 * @param n 타당한 줄의 길이
	 */
	public static void backtrack(int [] a, int k ,int n) {

		int [] c = new int [n];	//	퀸이 들어갈 수 있는 위치후보
		

		if(is_a_solution(k, n)) {	//	타당한 해라면 출력한다.
			process_solution(a, k);
			count++;
		}
		else {	//	타당하지 않다면
			k = k+1;
			int ncandidates = construct_candidates(a,k,n,c);	//	다음 줄에 퀸이 들어갈 수 있는 후보들을 구한다. (return 들어갈 수 있는 후보 수)
			for(int i =0; i<ncandidates; i++) {
				a[k] = c[i];
				backtrack(a,k,n);
			}
		}
		
	}
	/**
	 * 마지막 줄까지 퀸의 위치를 찾았는지 확인한다.
	 * @param k 퀸의 위치를 찾은 줄의 길이
	 * @param n 타당한 줄의 길이
	 * @return 모두 찾았다면 true 아니면 false
	 */
	public static boolean is_a_solution( int k, int n) {	// 마지막 줄까지 모두 퀸의 위치를 찾았을 때
		return (k == n);	
	}
	/**
	 * 
	 * @param a
	 * @param k
	 * @param n
	 * @param c
	 * @return
	 */
	public static int construct_candidates(int [] a,int k,int n, int [] c) {
		
		boolean legal_move;
		int ncandidates = 0;
		
		for(int i =1; i<=n; i++) {
			legal_move = true;
			for(int j =1; j<k; j++) {
				if(Math.abs((k)-j) == Math.abs(i-a[j])) legal_move = false;	//	대각선 방향이면 들어 갈 수 없다. (밑변과 높이가 같으면 대각선 상에 있다고 볼 수있다.)
				if(i == a[j])	legal_move = false;		//	같은 열이면 들어 갈 수 없다
			}
			if(legal_move) {	//	들어갈수 있다면 후보배열에 추가한다.
				c[ncandidates] = i;
				ncandidates++;
			}
		}
		return ncandidates;
	}
	/**
	 * 각줄의 퀸의 위치를 출력한다.
	 * @param a 각줄의 퀸의 위치가 담겨져 있는 배열
	 * @param k 줄의 길이
	 */
	public static void process_solution(int [] a, int k) {	

		for(int i =1; i<=k; i++) {
			
			System.out.print(" "+a[i] );
		}
		System.out.println();
	}
}
