package �˰������;
import java.util.*;

public class ThreeNone {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n, count;
		
		
		while(input.hasNextInt()) {
			int max = 0;
			int start = input.nextInt();
			int end = input.nextInt();
			
			for(int i = start; i<=end; i++) {
				count = 1;
				n = i;
				while(n!=1) {	// n�� 1�� �� �� ����
					if(n % 2 ==0) {	// ¦�� �� ��
						n = n/2;
						count++;
					}
					else {	// Ȧ�� �� ��
						n = n*3+1;
						count++;
					}
				}
				if(max < count) max = count;	// �ִ� ����Ŭ �� ���ϱ�
			}
			
			System.out.println(start + " " + end + " " + max);
		}
	}
}