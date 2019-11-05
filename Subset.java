package �˰������;
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
	 * �迭 a�� k��°������ ���� ������ �Ǻ��ϰ�,
	 * ���̸� ����Ѵ�.
	 * �ذ� �ƴϸ� a�� k+1��°�� ��� �� �� �ִ� �ĺ� ���� �ְ� 
	 * �� �Լ��� �ٽ� ȣ���Ѵ�.(�ڱ�ȣ��, recursion)	 
	 * @param a ���� ���ҵ��� ���� �迭
	 * @param k ���� ���� �ε���
	 * @param n Ÿ���� ���� ũ��
	 */
	public static void backtrack(int [] a, int k ,int n) {
		{
			int [] c = new int [2];
			int ncandidates = 2;
			if(k == n) {	//	������ ������ Ÿ���� �ؿ� ���� ��
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
	 * ���� �ε����� �� �ĺ��� ���Ѵ�.
	 * @param a ���� ���ҵ��� �� �ִ� �迭
	 * @param k ���� ���� �ε���
	 * @param n Ÿ���� ���� ũ��
	 * @param c	���� ������ ��� ����
	 */
	public static void construct_candidates(int [] a, int k ,int n, int [] c) {
		c[0] = 1;	//	��� �� �� �ִ�.
		c[1] = 0;	//	��� �� �� ����.
	}
	/**
	 * Ÿ���� �ظ� ����Ѵ�.
	 * @param a ���� ���ҵ��� ����ִ� �迭 (�迭 ���Ұ� ������ �� �� �ִ�.)
	 * @param k Ÿ���� ���� ũ�� 
	 */
	public static void process_solution(int [] a, int k) {


		System.out.print("{");
		for(int i =1; i<=k; i++) {
			if (a[i] == 1) {	//	1�̸� �ε����� ���
				System.out.print(" "+i );
			}
		}
		System.out.println(" }");
	}
}



