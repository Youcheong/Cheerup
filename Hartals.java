package �˰������;
import java.util.*;

public class Hartals {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t,n,p,c;

		t = input.nextInt();	//	�׽�Ʈ ���̽� ����

		for(int i =0; i<t; i++) {
			c =0;
			n = input.nextInt();	// �ù����̼� ���� �Ⱓ
			p = input.nextInt();	//	������ ����
			int [] hartals = new int [p];	// ���纰 �޾� ����

			for(int j =0; j<p; j++) {	//�޾����� �Է¹ޱ�
				hartals[j] = input.nextInt();
			}

			Arrays.sort(hartals);
			
			for(int k=1; k<=n; k++) {
				if(k%7 ==6 || k%7 == 0) continue;
				else {
					for (int j =0; j<p; j++){
						if (k % hartals[j] == 0) {
							c++;
							break;		// �ϳ��� �����̶� �����̶�� �ٸ� ������ �Ű澲�� �ʴ´�.
						}
					}
				}
			}

			System.out.println(c);}
	}
}
