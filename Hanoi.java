package �˰������;
import java.util.*;

public class Hanoi {

	public static ArrayList <Integer> t1 = new ArrayList<Integer>();
	public static ArrayList <Integer> t2 = new ArrayList<Integer>();
	public static ArrayList <Integer> t3 = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();


		for(int i =num; i>0; i--) {	//	t1 ž�� ������ ������������ �ִ´�.
			t1.add(i);
		}
		//	�ʱ� Ÿ�� ���
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
	 * ��� Ÿ���� ����Ѵ�.
	 * @param t1	Ÿ��1
	 * @param t2	Ÿ��2
	 * @param t3	Ÿ��3
	 */
	public static void printAll (ArrayList<Integer> t1, ArrayList<Integer> t2, ArrayList<Integer> t3) {
		printt(t1);System.out.print(" ");
		printt(t2);System.out.print(" ");
		printt(t3);System.out.println();
	}
	/**
	 * Ÿ���� ���Ŀ� �°� ����Ѵ�.
	 * @param t ����� Ÿ��
	 */
	public static void printt ( ArrayList<Integer> t) {

		StringBuilder st = new StringBuilder();

		for(int i =t.size()-1; i>=0; i--) {	//	���������̹Ƿ� �ڿ��� ���� ���

			if(i == 0) {	//	������ ����
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
	 * from�� �����ִ� num���� ������ by�� ���� to�� �ű��.
	 * @param num	������ ����
	 * @param from	�Ű��� ������ �ִ� ž
	 * @param by	���İ� ž
	 * @param to	�Űܰ� ž
	 */
	public static void moveTo(int num, ArrayList<Integer> from, ArrayList<Integer> by, ArrayList<Integer> to) {


		if(num == 1) {	//	�̵��� ������ 1�� �� ��	(from���� to�� �ٷ� �ű��.)
			to.add(from.get(from.size()-1));
			from.remove(from.size()-1);
			printAll(t1, t2, t3);

		} else {
			// STEP 1 : num-1���� A���� B�� �̵�
			moveTo(num-1, from, to, by);	//��� ȣ��(from�� �ִ� ������ by�� �ű��.)
			to.add(from.get(from.size()-1));
			from.remove(from.size()-1);

			// STEP 2 : 1���� A���� C�� �̵�
			printAll(t1, t2, t3);

			// STEP 3 : num-1���� B���� C�� �̵�
			moveTo(num-1, by, from, to);	//	���ȣ��(by�� �ִ� ������ to�� �ű��.)
		}	
	}
}