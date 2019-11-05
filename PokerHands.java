package 알고리즘공부;
import java.io.*;
import java.util.*;

public class PokerHands {
	public static void main (String[] args) {
		
		Scanner input = new Scanner(System.in);
		String card = " ";
		String [] [] black = {};		//2345678TJAKA  CDHS
		String [] [] white = {};
		
		//one-pair	두 장의 같은 값
		//two-pair	두 쌍의 같은 값 (2.2)
		//three-card 3장의 같은 값
		//straight 다섯 장의 카드가 연속적인 값
		//flush  다섯 장의 카드의 무늬가 모두 같은경우
		//full-house 세장의 카드가 같은 값을 가지고 나머지 두장의 카드가 같은 값을 가지는 경우
		//four-card 4장의 카드가 같은 값을 가지는 경우
		//straight-flush 다섯장의 카드가 무늬가 같으면서 모두 연속적일 때
		

		while(input.hasNextLine()) {

			card = input.nextLine();
			
		}

	}
}