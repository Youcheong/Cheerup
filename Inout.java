package 알고리즘공부;
import java.util.*;

public class Inout {
	public static void main(String[] args)  {

		Scanner input = new Scanner(System.in);		


		String j, k;

		String [] numbers = {};

		while(input.hasNextLine()) {
			boolean check = true;
			String count = input.nextLine();	// 데이터의 개수

			j = input.nextLine();	// 데이터 입력
			j = j.trim();

			if(j.equals(""))	check = false;	// 첫 데이터를 공백을 입력한다면 다시 처음으로 돌아가 정수의 개수를 입력 받는다.
			else  	numbers = j.split("\\s+");

			if(check) {	//	공백이 아닐 시
				
				while(input.hasNextLine()) {	
				
					k = input.nextLine();
					k = k.trim();

					if(k.equals("")) break;
					else  	System.out.println(numbers[Integer.parseInt(k)-1]);
					
					

				}
			}
		}
	}
}


