package �˰������;
import java.util.*;
import java.math.*;

public class N_queen {
	static int count =0;	//	���� ����
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int [] arrays = new int [n+1];	//	�� ���� ���� ��ġ�� �� �迭
		backtrack(arrays,0,n);
		System.out.print("n=" + n + ", number_of_solutions="+count);

	}




	/**
	 * �迭 a�� k��°������ ���� ������ �Ǻ��ϰ�,
	 * ���̸� ����Ѵ�.
	 * �ذ� �ƴϸ� a�� k+1��°�� ��� �� �� �ִ� �ĺ� ���� �ְ� 
	 * �� �Լ��� �ٽ� ȣ���Ѵ�.(�ڱ�ȣ��, recursion)
	 * @param a ������ ���� ��ġ�� �� �迭
	 * @param k ���� ��ġ�� ã�� ���� ����
	 * @param n Ÿ���� ���� ����
	 */
	public static void backtrack(int [] a, int k ,int n) {

		int [] c = new int [n];	//	���� �� �� �ִ� ��ġ�ĺ�
		

		if(is_a_solution(k, n)) {	//	Ÿ���� �ض�� ����Ѵ�.
			process_solution(a, k);
			count++;
		}
		else {	//	Ÿ������ �ʴٸ�
			k = k+1;
			int ncandidates = construct_candidates(a,k,n,c);	//	���� �ٿ� ���� �� �� �ִ� �ĺ����� ���Ѵ�. (return �� �� �ִ� �ĺ� ��)
			for(int i =0; i<ncandidates; i++) {
				a[k] = c[i];
				backtrack(a,k,n);
			}
		}
		
	}
	/**
	 * ������ �ٱ��� ���� ��ġ�� ã�Ҵ��� Ȯ���Ѵ�.
	 * @param k ���� ��ġ�� ã�� ���� ����
	 * @param n Ÿ���� ���� ����
	 * @return ��� ã�Ҵٸ� true �ƴϸ� false
	 */
	public static boolean is_a_solution( int k, int n) {	// ������ �ٱ��� ��� ���� ��ġ�� ã���� ��
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
				if(Math.abs((k)-j) == Math.abs(i-a[j])) legal_move = false;	//	�밢�� �����̸� ��� �� �� ����. (�غ��� ���̰� ������ �밢�� �� �ִٰ� �� ���ִ�.)
				if(i == a[j])	legal_move = false;		//	���� ���̸� ��� �� �� ����
			}
			if(legal_move) {	//	���� �ִٸ� �ĺ��迭�� �߰��Ѵ�.
				c[ncandidates] = i;
				ncandidates++;
			}
		}
		return ncandidates;
	}
	/**
	 * ������ ���� ��ġ�� ����Ѵ�.
	 * @param a ������ ���� ��ġ�� ����� �ִ� �迭
	 * @param k ���� ����
	 */
	public static void process_solution(int [] a, int k) {	

		for(int i =1; i<=k; i++) {
			
			System.out.print(" "+a[i] );
		}
		System.out.println();
	}
}
