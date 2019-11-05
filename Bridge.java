package �˰������;
import java.util.*;

public class Bridge {
	public static void main(String[] args) {

		Scanner input = new Scanner (System.in);

		int testcase = input.nextInt();	//	�׽�Ʈ ���̽� ����
		int result = 0;
		for(int t =0; t<testcase; t++) {
			result = 0;

			int num = input.nextInt();	//	����� ���
			int [] speed = new int [num];

			for(int n = 0; n<num; n++) {	//	������� �ٸ��� �ǳʴ� �ӵ��� �Է� �޴´�.
				speed[n] = input.nextInt();
			}
			
			Arrays.sort(speed);	//	����

			if(speed.length == 2) {	//	2���� �� ���� �ǳʰ���.
				result += speed[1]; 
			}
			else if(speed.length == 3) {	//	3���� ��
				result += speed[2] + speed[0] + speed[1];	//	���� ���� ����� ���� ���������  ������ �ְ�, ���� ���� ����� �ķ��ø� ������ ���ƿͼ� ������ �Ѹ��� ������ ����. 
			}
			//	4�� �̻��� ��
			//	1)���� ���� ����� ������� ���� �Դٰ��� �պ��ϸ鼭 ������ �ش�.  
			//	2)���� ��������ϰ� �ι�° ��������� ���� ����������� ���� ������ �������� �ι�° ����� �ķ��ø� ��� �ٽ� �ͼ� 1���� ������ ����.
			else if (speed.length >= 4) {	

				if(m1(speed) > m2(speed)) result = m2(speed);	//	ù�� ° ����� �� ���� �ɸ� ��
				else result = m1(speed);	//	�Ȱ��ų� �ι�° ����� �� ���� �ɸ� ��
			}
			
			System.out.println(result);
			System.out.println();
		}
	}

	/**
	 * ���� ���� ����� ����������� �Ѹ� �ű�� ���
	 * @param speed �ٸ��� �ǳʴ� �ӵ��� ����ִ� �迭
	 * @return	��ΰ� �̵��ϴµ� �ɸ� �ð�
	 */
	public static int m1 (int [] speed) {
		int result = 0;	//	�� �ɸ� �ð�
		for(int i=speed.length-1; i>0; i--) {	//	���� ���� ����� ����������� �Ѹ� �̵���Ű�� �ķ��ø� �ٽ� ������ ���ƿ´�.
			result += (speed[i] + speed[0]);
		}
		
		return result-speed[0];	//	�ݺ������� �������� ���� ��������� �ѹ� �� ���ƿ��°ɷ� �������Ƿ� �ѹ� �� ����.

	}
	/**
	 * ���� ���� ���� 2���� �̵��ϰ� ���� ���� ����� ȥ�� �ķ��ø� ��� ���ƿ��� 
	 * ���� ����߿� ���� ���� 2���� �̵��ϰ� �ǳʰ� �ִ� �ι�° ���� ����� �ķ��ø� �ٽ� ������ ���ƿ´�.
	 * �̸� �ݺ��Ͽ� ����������� 3�����Ϸ� ���� ������ ��������� ���� �̵���Ų��.
	 * @param speed	�ٸ��� �ǳʴ� �ӵ��� ����ִ� �迭
	 * @return	��� �̵��ϴµ� �ɸ� �ð�
	 */
	public static int m2 (int [] speed) {
		int result =0;	//	�� �ɸ� �ð�
		int remain = speed.length;	//	�����ִ� �����
		
		while(remain > 3) {	//	3�����Ϸ� ���� �� ����
			
			result += (speed[1]);	//	ó���� ���� ���� �θ� �̵��Ѵ�.
			result += speed[0];		//	���� ���� ����� �ķ��ø� ������ ���ƿ´�.
			result += (speed[remain-1]);	//	���� ���� �θ��� �̵��Ѵ�.
			result += speed[1];		//	�� ��° ���� ����� �ķ��ø� ������ ���ƿ´�.
			
			remain -= 2;
			
		}
		
		if(remain == 2) {	//	����������� 2���� ��
			result += speed[1]; 
		}
		else if(remain == 3) {	//	���� ������� 3���� ��
			result += speed[2] + speed[0] + speed[1];	//	���� ���� ����� ���ϴ��������  ������ �ְ� �ķ��ø� ������ ���ƿͼ� ������ �Ѹ��� ������ ����. 
		}
		return result;
	}
}
