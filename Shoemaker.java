package �˰������;
import java.util.*;

public class Shoemaker {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);

		int testcase = input.nextInt();	//	�׽�Ʈ���̽� ����

		for(int t =0; t<testcase; t++) {

			int n = input.nextInt();	//	�۾��� ���� 1~1000
			int  days ;	//	�۾��� �ɸ��� ����
			int  fine ;	//	������ ����� �迭
			Process [] pro = new Process[n];	//	�۾� ��ü���� �� �迭

			for(int i =0; i<n; i++) {	//	�۾��� �ɸ��� �ϼ��� �Ϸ�� ���� �Է�
				days = input.nextInt();
				fine = input.nextInt();
				Process p = new Process(i,days,fine);	//	�۾� ��ü ����
				pro[i] = p;
			}
			
			Arrays.sort(pro, new Comparator<Process>() {	//	val = �Ϸ� �� ����/ �۾��̰ɸ��� �ϼ�
				public int compare(Process p1, Process p2) {
					double p1val = p1.val;
					double p2val = p2.val;
					if(p1val == p2val) {	//val�� ���ٸ�
						return p1.day-p2.day;	//	�۾��ϼ��� ���� ������ ����
					}
					return Double.compare(p2val, p1val);	//	val�� ������������ ����
				}
			});

			for(int i =0; i<n-1; i++) {		//���
				System.out.print((pro[i].num+1) + " ");
			}
			System.out.println(pro[n-1].num+1);
	
			System.out.println();	//	�׽�Ʈ���̽����� �� �� ���
		}
	}

	static class Process implements Comparable <Process> {

		int num;		//	�۾��� ��ȣ
		int day;		//	�۾��� �ɸ��� �ϼ�
		int fine;		//	�Ϸ�� ����
		double val;		//	�Ϸ�� ����/ �۾��� �ɸ��� �ϼ�

		public Process (int num , int day, int fine) {
			this.num = num;
			this.day = day;
			this.fine = fine;
			this.val = (double)fine/(double)day;
		}

		public int getnum() {	//	�۾��� ��ȣ�� ��ȯ�Ѵ�.
			return num;
		}

		@Override
		public int compareTo(Process p) {	//	�ɸ��� �ϼ��� �������� ������������ �����Ѵ�.

			return  (this.day-p.day);
		}
	}
}
