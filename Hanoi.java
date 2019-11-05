package 알고리즘공부;
import java.util.*;

public class Hanoi {

	public static ArrayList <Integer> t1 = new ArrayList<Integer>();
	public static ArrayList <Integer> t2 = new ArrayList<Integer>();
	public static ArrayList <Integer> t3 = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();


		for(int i =num; i>0; i--) {	//	t1 탑에 원반을 내림차순으로 넣는다.
			t1.add(i);
		}
		//	초기 타워 출력
		System.out.print("Enter number of discs: "  ); 
		printt(t1); 	System.out.print(" ");
		printt(t2);		System.out.print(" ");
		printt(t3);
		System.out.println();

		if(num != 0) {
			moveTo(num, t1, t2, t3);		
		}
	}
	/**
	 * 모든 타워를 출력한다.
	 * @param t1	타워1
	 * @param t2	타워2
	 * @param t3	타워3
	 */
	public static void printAll (ArrayList<Integer> t1, ArrayList<Integer> t2, ArrayList<Integer> t3) {
		printt(t1);System.out.print(" ");
		printt(t2);System.out.print(" ");
		printt(t3);System.out.println();
	}
	/**
	 * 타워를 형식에 맞게 출력한다.
	 * @param t 출력할 타워
	 */
	public static void printt ( ArrayList<Integer> t) {

		StringBuilder st = new StringBuilder();

		for(int i =t.size()-1; i>=0; i--) {	//	내림차순이므로 뒤에서 부터 출력

			if(i == 0) {	//	마지막 원소
				st.append(t.get(i));
			}
			else {
				st.append(t.get(i)+ ", ");
			}
		}
		if(t.size() != 0)  	System.out.print("["+st+"]");
		else System.out.print("[]");
	}

	/**
	 * from에 꽂혀있는 num개의 원반을 by를 거쳐 to로 옮긴다.
	 * @param num	원반의 개수
	 * @param from	옮겨질 원반이 있는 탑
	 * @param by	거쳐갈 탑
	 * @param to	옮겨갈 탑
	 */
	public static void moveTo(int num, ArrayList<Integer> from, ArrayList<Integer> by, ArrayList<Integer> to) {


		if(num == 1) {	//	이동할 원반이 1개 일 때	(from에서 to로 바로 옮긴다.)
			to.add(from.get(from.size()-1));
			from.remove(from.size()-1);
			printAll(t1, t2, t3);

		} else {
			// STEP 1 : num-1개를 A에서 B로 이동
			moveTo(num-1, from, to, by);	//재귀 호출(from에 있는 원반을 by로 옮긴다.)
			to.add(from.get(from.size()-1));
			from.remove(from.size()-1);

			// STEP 2 : 1개를 A에서 C로 이동
			printAll(t1, t2, t3);

			// STEP 3 : num-1개를 B에서 C로 이동
			moveTo(num-1, by, from, to);	//	재귀호출(by에 있는 원반을 to로 옮긴다.)
		}	
	}
}