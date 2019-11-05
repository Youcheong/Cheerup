package �˰������;
import java.util.*;

public class Pancakes {
	public static void main(String[] args) {

		Scanner input = new Scanner (System.in);

		while(input.hasNextLine()) {
			String [] tmp = {};	//	�Է¹��� �� ���� �ӽ÷� ������ �迭
			String s = input.nextLine();	//	�Է¹޴´�.
			System.out.println(s);
			tmp = s.split("\\s+");	//	�����̽��ٸ� �������� ������.

			int [] pancakes = new int [tmp.length];	//	������ũ�� �� �迭
			
			for(int i =0; i<pancakes.length; i++) {	//	�ӽ������� �迭�� ���������� ����ȯ�Ͽ� �迭�� �����Ѵ�.
				pancakes[i] = Integer.parseInt(tmp[i]); 
			}

			
			for (int i=pancakes.length-1;i>=0;i--) {	//	������ũ�� �� �Ʒ����� ���� �����Ѵ�.
				
				if (Highest(pancakes, i) != i) {	//	ū ������ũ �Ʒ��� ���� ��
					
					if (Highest(pancakes, i) != 0) {	//	������ ���������� ū ������ũ�� �� ���� ���� ��  
						int high = Highest(pancakes, i);	//	ū ������ũ�� ��ġ
						
						flip(pancakes,(pancakes.length-high));	//	ū ������ũ�� ������ �ö󰡵��� �����´�.
						System.out.print((pancakes.length-high)+" ");
					}

					flip(pancakes,(pancakes.length-i));		//	������ ū ������ũ�� ���� �� ����� �Ʒ��� ������ �Ѵ�.
					System.out.print((pancakes.length-i)+" ");
				}
			}
			System.out.println("0");
		}
	}
	/**
	 * ������ ������ ������ũ�� ���� ū ������ũ�� �ε����� ��ȯ�Ѵ�. 
	 * @param pancakes ������ũ���� ����ִ� �迭
	 * @return ���� ū ������ũ�� ����ִ� �迭�� �ε���
	 */
	public static int Highest(int [] pancakes,int index) {
		int max =0;
		int result = 0;
		for(int i = 0; i<= index; i++) {
			if(max <= pancakes[i]) {
				max = pancakes[i];
				result = i;
			}
		}
		return result;
	}
	/**
	 * 0�� �ε��� (����)���� ������ �ε��� ���� �����´�.
	 * @param pancakes	������ũ���� ����� �ִ� �迭
	 * @param index	������ �ε��� (pancakes.length - index)
	 */
	public static void flip (int [] pancakes, int index) {
		int [] tmp = new int [pancakes.length];
		
		for(int i =0; i<pancakes.length; i++) {	//	�ӽ� ����
			tmp[i] = pancakes[i];	
		}

		int endIndex=pancakes.length-index;	//	������ ��ġ
		
		for (int i=0;i<=endIndex;i++) {		//	�ε��� 0 (����)���� ������ �ε��� (������ ��ġ)���� �����´�.
			pancakes[i]=tmp[endIndex-i];
		}
	}
}