package 알고리즘공부;
import java.util.*;

public class Shoemaker {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);

		int testcase = input.nextInt();	//	테스트케이스 개수

		for(int t =0; t<testcase; t++) {

			int n = input.nextInt();	//	작업의 개수 1~1000
			int  days ;	//	작업이 걸리는 날수
			int  fine ;	//	벌금이 저장될 배열
			Process [] pro = new Process[n];	//	작업 객체들이 들어갈 배열

			for(int i =0; i<n; i++) {	//	작업의 걸리는 일수와 하루당 벌금 입력
				days = input.nextInt();
				fine = input.nextInt();
				Process p = new Process(i,days,fine);	//	작업 객체 생성
				pro[i] = p;
			}
			
			Arrays.sort(pro, new Comparator<Process>() {	//	val = 하루 당 벌금/ 작업이걸리는 일수
				public int compare(Process p1, Process p2) {
					double p1val = p1.val;
					double p2val = p2.val;
					if(p1val == p2val) {	//val이 같다면
						return p1.day-p2.day;	//	작업일수가 작은 순으로 정렬
					}
					return Double.compare(p2val, p1val);	//	val를 내림차순으로 정렬
				}
			});

			for(int i =0; i<n-1; i++) {		//출력
				System.out.print((pro[i].num+1) + " ");
			}
			System.out.println(pro[n-1].num+1);
	
			System.out.println();	//	테스트케이스마다 빈 줄 출력
		}
	}

	static class Process implements Comparable <Process> {

		int num;		//	작업의 번호
		int day;		//	작업의 걸리는 일수
		int fine;		//	하루당 벌금
		double val;		//	하루당 벌금/ 작업의 걸리는 일수

		public Process (int num , int day, int fine) {
			this.num = num;
			this.day = day;
			this.fine = fine;
			this.val = (double)fine/(double)day;
		}

		public int getnum() {	//	작업의 번호를 반환한다.
			return num;
		}

		@Override
		public int compareTo(Process p) {	//	걸리는 일수를 기준으로 오름차순으로 정렬한다.

			return  (this.day-p.day);
		}
	}
}
