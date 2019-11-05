package 알고리즘공부;
import java.util.*;

public class Pancakes {
	public static void main(String[] args) {

		Scanner input = new Scanner (System.in);

		while(input.hasNextLine()) {
			String [] tmp = {};	//	입력받은 한 줄을 임시로 저장한 배열
			String s = input.nextLine();	//	입력받는다.
			System.out.println(s);
			tmp = s.split("\\s+");	//	스페이스바를 기준으로 나눈다.

			int [] pancakes = new int [tmp.length];	//	팬케이크가 들어갈 배열
			
			for(int i =0; i<pancakes.length; i++) {	//	임시저장한 배열을 정수형으로 형변환하여 배열에 저장한다.
				pancakes[i] = Integer.parseInt(tmp[i]); 
			}

			
			for (int i=pancakes.length-1;i>=0;i--) {	//	팬케이크를 맨 아래에서 부터 정렬한다.
				
				if (Highest(pancakes, i) != i) {	//	큰 팬케이크 아래에 없을 때
					
					if (Highest(pancakes, i) != 0) {	//	지정된 범위에서의 큰 팬케이크가 맨 위에 없을 때  
						int high = Highest(pancakes, i);	//	큰 팬케이크의 위치
						
						flip(pancakes,(pancakes.length-high));	//	큰 팬케이크가 맨위로 올라가도록 뒤집는다.
						System.out.print((pancakes.length-high)+" ");
					}

					flip(pancakes,(pancakes.length-i));		//	맨위에 큰 팬케이크가 있을 때 뒤집어서 아래로 가도록 한다.
					System.out.print((pancakes.length-i)+" ");
				}
			}
			System.out.println("0");
		}
	}
	/**
	 * 지정된 범위의 팬케이크중 가장 큰 팬케이크의 인덱스를 반환한다. 
	 * @param pancakes 팬케이크들이 들어있는 배열
	 * @return 가장 큰 팬케이크가 들어있는 배열의 인덱스
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
	 * 0번 인덱스 (맨위)부터 지정된 인덱스 까지 뒤집는다.
	 * @param pancakes	팬케이크들이 담겨져 있는 배열
	 * @param index	지정된 인덱스 (pancakes.length - index)
	 */
	public static void flip (int [] pancakes, int index) {
		int [] tmp = new int [pancakes.length];
		
		for(int i =0; i<pancakes.length; i++) {	//	임시 저장
			tmp[i] = pancakes[i];	
		}

		int endIndex=pancakes.length-index;	//	뒤집을 위치
		
		for (int i=0;i<=endIndex;i++) {		//	인덱스 0 (맨위)부터 지정된 인덱스 (뒤집을 위치)까지 뒤집는다.
			pancakes[i]=tmp[endIndex-i];
		}
	}
}