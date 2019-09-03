import java.util.;

  병의 음료를 이동하는 작업을 한다.
  병의 용량과 병 안에 음료의 양은 배열로 선언한다. (직접 지정)
  @author Han
 
 
public class ex1 {
	public static void main(String [] args) {

		int [] capacities = {30,20,10};	 병의 최대용량
		int [] bottles = {10,5,5};		 병안에 들어있는 음료의 양
		int [] fromId = {0,1,2} ;		 옮겨질 음료의 병
		int [] toId = {1,2,0} ;		 옮겨갈 음료의 병 

		System.out.print(capacities ); printarray(capacities);
		System.out.print(bottles ); printarray(bottles);
		System.out.print(from ); printarray(fromId);
		System.out.print(to ); printarray(toId);
		System.out.print(return );
		printarray(thePuring(capacities,bottles,fromId,toId));
	}
	
	  배열 출력 메소드
	  @param array	출력한 배열
	 
	public static void printarray(int[] array) {		

		for(int i =0; iarray.length; i++) {
			System.out.print(array[i] + );
		}
		System.out.println();
	}
	
	  
	  @param capacities 병의 용량
	  @param bottles	병안에 들어있는 음료의 양
	  @param fromId	옮겨질 음료의 병
	  @param toId		옮겨갈 음료의 병
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
