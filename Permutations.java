package 알고리즘공부;
import java.util.*;

public class Permutations {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);

		int num = input.nextInt();
		
		int[] arrays = new int [num+1];		// 순열이 들어갈배열 (해)
		backtrack(arrays, 0, num);
		
		int count = 1;	
		for(int i =num; i>0; i--) {		//	num! 구하기
			count *= i;
		}
		System.out.println("Counts: " + count);

	}
	/**
	 * 배열 a의 k번째까지의 값이 해인지 판별하고,
	 * 해이면 출력한다.
	 * 해가 아니면 a의 k+1번째에 들어 갈 수 있는 후보 값을 넣고 
	 * 이 함수를 다시 호출한다.(자기호출, recursion)
	 * @param a 해의 원소가 들어가 배열
	 * @param k 해의 원소 인덱스
	 * @param n 타당한 해의 크기
	 */
	public static void backtrack(int [] a, int k ,int n) {
		{
			int [] c = new int [n];	//	들어갈 수 있는 후보

			if(is_a_solution(k, n)) {	//	타당한 해라면 출력한다.
				process_solution(a, k);
			}
			else {	//	타당하지 않다면
				k = k+1;
				int ncandidates = construct_candidates(a,k,n,c);	//	다음 원소에 들어갈 후보들을 구한다. (return 들어갈 수 있는 후보 수)
				for(int i =0; i<ncandidates; i++) {
					a[k] = c[i];
					backtrack(a,k,n);
				}
			}
		}

	}
	/**
	 * 타당한 해인지 확인한다.
	 * @param k 해의 원소 인덱스
	 * @param n 타당한 해의 크기
	 * @return 타당한 해의 크기와 해의 원소 인덱스가 같다면 true 다르다면 fasle
	 */
	public static boolean is_a_solution( int k, int n) {
		return (k == n);	//	원소 인덱스가 타당한 해의 크기와 같다면 true
	}
	/**
	 * 다음 인덱스에 들어갈 후보를 넣는다.
	 * @param a 해의 원소가 들어가는 배열
	 * @param k 배열의 인덱스
	 * @param n 타당한 해의 길이
	 * @param c 해의 다음원소가 될 후보가 들어갈 배열
	 * @return ncandidates 후보의 수
	 */
	public static int construct_candidates(int [] a,int k,int n, int [] c) {
		boolean [] in_perm = new boolean [a.length];	//	숫자를 사용했었는지 여부를 확인하는 배열

		for(int i =0; i<a.length; i++)	in_perm[i] = false;	//	모두 false로 초기화
		for(int i =0; i<k; i++) in_perm[a[i]] = true;	//	중복을 없애기 위해서 해에 있는 숫자를 true로

		int ncandidates = 0;
		
		for(int i =0; i <=n; i++) {
			if(in_perm[i] == false) {	//	다음원소로 올 수 있는 수라면
				c[ncandidates] = i;
				ncandidates++;
			}
		}
		return ncandidates;
	}

	/**
	 * 타당한 해를 출력한다.
	 * @param a 원소가 담겨져 있는 배열
	 * @param k 순열의 길이 (타당한 해)
	 */
	public static void process_solution(int [] a, int k) {

		for(int i =1; i<=k; i++) {
			System.out.print(" "+a[i] );
		}
		System.out.println();
	}
}
