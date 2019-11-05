package 알고리즘공부;
import java.util.*;

public class Hartals {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t,n,p,c;

		t = input.nextInt();	//	테스트 케이스 갯수

		for(int i =0; i<t; i++) {
			c =0;
			n = input.nextInt();	// 시물레이션 돌린 기간
			p = input.nextInt();	//	정당의 개수
			int [] hartals = new int [p];	// 정당별 휴업 지수

			for(int j =0; j<p; j++) {	//휴업지수 입력받기
				hartals[j] = input.nextInt();
			}

			Arrays.sort(hartals);
			
			for(int k=1; k<=n; k++) {
				if(k%7 ==6 || k%7 == 0) continue;
				else {
					for (int j =0; j<p; j++){
						if (k % hartals[j] == 0) {
							c++;
							break;		// 하나의 정당이라도 휴일이라면 다른 정당은 신경쓰지 않는다.
						}
					}
				}
			}

			System.out.println(c);}
	}
}
