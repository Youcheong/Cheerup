package 알고리즘공부;
import java.util.*;
import java.math.*;

public class HmF {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		ArrayList<BigInteger> fibonums = new ArrayList<BigInteger>();
		
		BigInteger max = new BigInteger("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
		BigInteger tmp =BigInteger.ZERO;

		// 10^100까지의 피보나치의 수들을 배열안에 담는다.
		int i = 1;
		while(tmp.compareTo(max) == -1) {

			if(fibonums.size() >3) {	//	시간절약을 위해서 f(n-1), f(n-2)가 배열안에 있다면 인덱스 값을 읽어와서 더한다.
				tmp = fibonums.get(fibonums.size()-1).add(fibonums.get(fibonums.size()-2));
				fibonums.add(tmp);
			}
			else {	//	피보나치 수를 구해서 배열에 넣는다.
				fibonums.add(Fibo(i));
			}
			i++;
		}
		
		while(true) {

			BigInteger a = new BigInteger(input.next());	//	정수 a
			BigInteger b = new BigInteger(input.next());	//	정수 b
			int count =0;	//	피보나치 수의 개수

			if(a.equals(BigInteger.ZERO)  && a.equals(b)) break;	//	둘다 0 이면 탈출

			for(int f=0; f<fibonums.size(); f++) {
				// 배열안에 있는 피보나치 수가 a보다 크고 b보다 작으면 count를 늘린다.
				if((fibonums.get(f).compareTo(a) == 1 ||fibonums.get(f).compareTo(a) == 0) && (fibonums.get(f).compareTo(b) == 0 ||fibonums.get(f).compareTo(b) ==-1)) {
					count++;
				}
			}

			System.out.println(count);
		}
	}
	/**
	 * 피보나치 수를 반환한다.
	 * @param n 피보나치수열 (fi)에서 i
	 * @return 피보나치 수
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