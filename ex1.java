import java.util.;

  ���� ���Ḧ �̵��ϴ� �۾��� �Ѵ�.
  ���� �뷮�� �� �ȿ� ������ ���� �迭�� �����Ѵ�. (���� ����)
  @author Han
 
 
public class ex1 {
	public static void main(String [] args) {

		int [] capacities = {30,20,10};	 ���� �ִ�뷮
		int [] bottles = {10,5,5};		 ���ȿ� ����ִ� ������ ��
		int [] fromId = {0,1,2} ;		 �Ű��� ������ ��
		int [] toId = {1,2,0} ;		 �Űܰ� ������ �� 

		System.out.print(capacities ); printarray(capacities);
		System.out.print(bottles ); printarray(bottles);
		System.out.print(from ); printarray(fromId);
		System.out.print(to ); printarray(toId);
		System.out.print(return );
		printarray(thePuring(capacities,bottles,fromId,toId));
	}
	
	  �迭 ��� �޼ҵ�
	  @param array	����� �迭
	 
	public static void printarray(int[] array) {		

		for(int i =0; iarray.length; i++) {
			System.out.print(array[i] + );
		}
		System.out.println();
	}
	
	  
	  @param capacities ���� �뷮
	  @param bottles	���ȿ� ����ִ� ������ ��
	  @param fromId	�Ű��� ������ ��
	  @param toId		�Űܰ� ������ ��
	  @return
	 
	public static int [] thePuring(int[] capacities, int [] bottles, int [] fromId, int[] toId) {

		int [] returns = bottles;
		for(int i =0; ifromId.length; i++) {
			int f = fromId[i];
			int t = toId[i];
			int space = capacities[t] - bottles[t];

			if(space = bottles[f]) {
				bottles[t] = bottles[t] + bottles[f];
				bottles[f] = 0;
			}
			else {
				bottles[t] = capacities[t];
				bottles[f] = bottles[f] - space; 

			}

		}

		return returns;
	}
}
