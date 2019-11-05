package �˰������;
import java.util.*;
import java.math.*;

public class HmF {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		ArrayList<BigInteger> fibonums = new ArrayList<BigInteger>();
		
		BigInteger max = new BigInteger("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
		BigInteger tmp =BigInteger.ZERO;

		// 10^100������ �Ǻ���ġ�� ������ �迭�ȿ� ��´�.
		int i = 1;
		while(tmp.compareTo(max) == -1) {

			if(fibonums.size() >3) {	//	�ð������� ���ؼ� f(n-1), f(n-2)�� �迭�ȿ� �ִٸ� �ε��� ���� �о�ͼ� ���Ѵ�.
				tmp = fibonums.get(fibonums.size()-1).add(fibonums.get(fibonums.size()-2));
				fibonums.add(tmp);
			}
			else {	//	�Ǻ���ġ ���� ���ؼ� �迭�� �ִ´�.
				fibonums.add(Fibo(i));
			}
			i++;
		}
		
		while(true) {

			BigInteger a = new BigInteger(input.next());	//	���� a
			BigInteger b = new BigInteger(input.next());	//	���� b
			int count =0;	//	�Ǻ���ġ ���� ����

			if(a.equals(BigInteger.ZERO)  && a.equals(b)) break;	//	�Ѵ� 0 �̸� Ż��

			for(int f=0; f<fibonums.size(); f++) {
				// �迭�ȿ� �ִ� �Ǻ���ġ ���� a���� ũ�� b���� ������ count�� �ø���.
				if((fibonums.get(f).compareTo(a) == 1 ||fibonums.get(f).compareTo(a) == 0) && (fibonums.get(f).compareTo(b) == 0 ||fibonums.get(f).compareTo(b) ==-1)) {
					count++;
				}
			}

			System.out.println(count);
		}
	}
	/**
	 * �Ǻ���ġ ���� ��ȯ�Ѵ�.
	 * @param n �Ǻ���ġ���� (fi)���� i
	 * @return �Ǻ���ġ ��
	 */
	public static BigInteger Fibo(int n) {
		BigInteger two = new BigInteger("2");
		if(n <= 2) {
			return BigInteger.ONE;
		}

		else {
			return Fibo(n-1).add(Fibo(n-2));
		}

	}
}