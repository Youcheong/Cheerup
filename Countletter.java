package 알고리즘공부;
import java.io.*;
import java.util.*;

public class Countletter {
	public static void main(String [] args) {
		String word ;
		String [] strings = {};
		Scanner input = new Scanner (System.in);
		


		while(input.hasNextLine()) {
			
			
			int count = 0;
			
			word = input.nextLine();
			word = word.trim();
			strings = word.split("\\s+");

			for(int i = 0; i<strings.length; i++) {
				count += strings[i].length();
			}
			
			System.out.println(count + " " + strings.length);


		}
	}
}


