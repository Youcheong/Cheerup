package �˰������;
import java.util.*;

public class Permutations {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);

		int num = input.nextInt();
		
		int[] arrays = new int [num+1];		// ������ ���迭 (��)
		backtrack(arrays, 0, num);
		
		int count = 1;	
		for(int i =num; i>0; i--) {		//	num! ���ϱ�
			count *= i;
		}
		System.out.println("Counts: " + count);

	}
	/**
	 * �迭 a�� k��°������ ���� ������ �Ǻ��ϰ�,
	 * ���̸� ����Ѵ�.
	 * �ذ� �ƴϸ� a�� k+1��°�� ��� �� �� �ִ� �ĺ� ���� �ְ� 
	 * �� �Լ��� �ٽ� ȣ���Ѵ�.(�ڱ�ȣ��, recursion)
	 * @param a ���� ���Ұ� �� �迭
	 * @param k ���� ���� �ε���
	 * @param n Ÿ���� ���� ũ��
	 */
	public static void backtrack(int [] a, int k ,int n) {
		{
			int [] c = new int [n];	//	�� �� �ִ� �ĺ�

			if(is_a_solution(k, n)) {	//	Ÿ���� �ض�� ����Ѵ�.
				process_solution(a, k);
			}
			else {	//	Ÿ������ �ʴٸ�
				k = k+1;
				int ncandidates = construct_candidates(a,k,n,c);	//	���� ���ҿ� �� �ĺ����� ���Ѵ�. (return �� �� �ִ� �ĺ� ��)
				for(int i =0; i<ncandidates; i++) {
					a[k] = c[i];
					backtrack(a,k,n);
				}
			}
		}

	}
	/**
	 * Ÿ���� ������ Ȯ���Ѵ�.
	 * @param k ���� ���� �ε���
	 * @param n Ÿ���� ���� ũ��
	 * @return Ÿ���� ���� ũ��� ���� ���� �ε����� ���ٸ� true �ٸ��ٸ� fasle
	 */
	public static boolean is_a_solution( int k, int n) {
		return (k == n);	//	���� �ε����� Ÿ���� ���� ũ��� ���ٸ� true
	}
	/**
	 * ���� �ε����� �� �ĺ��� �ִ´�.
	 * @param a ���� ���Ұ� ���� �迭
	 * @param k �迭�� �ε���
	 * @param n Ÿ���� ���� ����
	 * @param c ���� �������Ұ� �� �ĺ��� �� �迭
	 * @return ncandidates �ĺ��� ��
	 */
	public static int construct_candidates(int [] a,int k,int n, int [] c) {
		boolean [] in_perm = new boolean [a.length];	//	���ڸ� ����߾����� ���θ� Ȯ���ϴ� �迭

		for(int i =0; i<a.length; i++)	in_perm[i] = false;	//	��� false�� �ʱ�ȭ
		for(int i =0; i<k; i++) in_perm[a[i]] = true;	//	�ߺ��� ���ֱ� ���ؼ� �ؿ� �ִ� ���ڸ� true��

		int ncandidates = 0;
		
		for(int i =0; i <=n; i++) {
			if(in_perm[i] == false) {	//	�������ҷ� �� �� �ִ� �����
				c[ncandidates] = i;
				ncandidates++;
			}
		}
		return ncandidates;
	}

	/**
	 * Ÿ���� �ظ� ����Ѵ�.
	 * @param a ���Ұ� ����� �ִ� �迭
	 * @param k ������ ���� (Ÿ���� ��)
	 */
	public static void process_solution(int [] a, int k) {

		for(int i =1; i<=k; i++) {
			System.out.print(" "+a[i] );
		}
		System.out.println();
	}
}
