package 알고리즘공부;
import java.io.*;
import java.util.*;

public class JollyJumper {
	public static void main(String [] args) {

		Scanner input = new Scanner (System.in);

		int num ;
		int [] numbers = {};
		int [] jump = {};
		boolean isjolly = true;


		while(input.hasNextInt()) {

			num = input.nextInt();

			if(num <= 1 ) {
				num = input.nextInt();
			}
			else {
				numbers = new int [num];
				jump = new int [num-1];

				for(int i = 0; i<numbers.length; i++) {
					numbers[i] = input.nextInt();
				}

				for(int i =0; i<numbers.length-1; i++) {
					jump[i] = Math.abs((numbers[i] - numbers[i+1]));
				}

				Arrays.sort(jump);

				if(jump[jump.length-1]> numbers.length) {
					isjolly = false;
				}

				for(int i=0; i<jump.length; i++) {
					if(jump[i] != i+1) {
						isjolly = false;
						break;
					}
				}
			}

			if(isjolly) {
				System.out.println("Jolly");
			}
			else {
				System.out.println("Not Jolly");
			}
			isjolly = true;
		}
	}

}
