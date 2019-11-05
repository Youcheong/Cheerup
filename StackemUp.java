package 알고리즘공부;
import java.util.*;

public class StackemUp {
	/**
	 * 사용자로 부터 테스트케이스 갯수와 카드를 섞는 방식의 개수와 방식의 갯수만큼 섞는 방식을 직접 입력받는다.
	 * 방식의 개수만큼 섞는 방식을 입력받는다.
	 * 카드를 섞는 방식중 선택된 방식으로 카드를 섞은 후 출력한다. 
	 * @author 한유청
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	
		String [] card = new String [53];	//	새로운 카드덱
		int [] [] shuffle = new int [100] [53];	//	섞을 순서를 입력받을 배열
		String [] shfcard = new String [53];	//	섞여진 카드
		int n = 0;	// 섞는 방식의 수
		String c = "";	//	사용자가 선택한 섞는 방식
		
		int t = input.nextInt();	//테스트 케이스 갯수
		
		for(int i = 0; i<t; i++) {
			
			Deck(card);		//	새로운 덱 구성
			n = input.nextInt();	//	섞는 방식의 수 입력
			
			for(int k =1; k <=n; k++) {	// 섞는 방식 입력
				for(int j=1; j<53; j++) {
					shuffle[k][j] = input.nextInt();
				}
			}
		
		input.nextLine();	//	버퍼에 남은 개행문자를 없애기 위해 호출

		// 카드 섞기
			while(input.hasNextLine()) {
				
					c = input.nextLine();
					c = c.trim();
					
					if(c.equals("")) break;		//	공백을 만나면 탈출
					else 	card = Shuffle(card,shuffle,Integer.parseInt(c));	//	카드 섞기

			}

			shfcard = card;	//	섞인카드 옮기기
			
			// 출력
			for(int j =1; j<53; j++) {
				if(shfcard[j].length() == 2) {	//	숫자 10미만일 때
					if(shfcard[j].charAt(0) == 'C') {	//	무늬가 클로버일 때
						System.out.println(shfcard[j].charAt(1) + " of Clubs");
					}
					if(shfcard[j].charAt(0) == 'D') {	//	무늬가 다이아몬드 일 때
						System.out.println(shfcard[j].charAt(1) + " of Diamonds");
					}
					if(shfcard[j].charAt(0) == 'H') {	//	무늬가 하트일 때
						System.out.println(shfcard[j].charAt(1) + " of Hearts");
					}
					if(shfcard[j].charAt(0) == 'S') {	//	무늬가 스페이드일 때
						System.out.println(shfcard[j].charAt(1) + " of Spades");
					}
				}
				else {	//	숫자가 10이상일 때
					if(shfcard[j].charAt(0) == 'C') {	//	무늬가 클로버 일 때
						switch(shfcard[j].substring(1,3)) {
						case "11" :
							System.out.println("Jack of Clubs");
							break;
						case "12" :
							System.out.println("Queen of Clubs");
							break;
						case "13" :
							System.out.println("King of Clubs");
							break;
						case "14" :
							System.out.println("Ace of Clubs");
							break;
						default :
							System.out.println(shfcard[j].substring(1,3) + " of Clubs");
							break;
						}
					}
					if(shfcard[j].charAt(0) == 'D') {	//	무늬가 다이아몬드 일 때
						switch(shfcard[j].substring(1,3)) {
						case "11" :
							System.out.println("Jack of Diamonds");
							break;
						case "12" :
							System.out.println("Queen of Diamonds");
							break;
						case "13" :
							System.out.println("King of Diamonds");
							break;
						case "14" :
							System.out.println("Ace of Diamonds");
							break;
						default :
							System.out.println(shfcard[j].substring(1,3) + " of Diamonds");
							break;
						}
					}
					if(shfcard[j].charAt(0) == 'H') {	//	무늬가 하트일 때
						switch(shfcard[j].substring(1,3)) {
						case "11" :
							System.out.println("Jack of Hearts");
							break;
						case "12" :
							System.out.println("Queen of Hearts");
							break;
						case "13" :
							System.out.println("King of Hearts");
							break;
						case "14" :
							System.out.println("Ace of Hearts");
							break;
						default :
							System.out.println(shfcard[j].substring(1,3) + " of Hearts");
							break;
						}
					}
					if(shfcard[j].charAt(0) == 'S') {	//	무늬가 스페이드일 때
						switch(shfcard[j].substring(1,3)) {
						case "11" :
							System.out.println("Jack of Spades");
							break;
						case "12" :
							System.out.println("Queen of Spades");
							break;
						case "13" :
							System.out.println("King of Spades");
							break;
						case "14" :
							System.out.println("Ace of Spades");
							break;
						default :
							System.out.println(shfcard[j].substring(1,3) + " of Spades");
							break;

						}
					}
				}
			}
			System.out.println();	//	테스트케이스마다 빈줄 출력
		}
	}

	/**
	 * 정렬된 새로운 카드를 만드는 메소드
	 * @param card 정렬된 새로운 카드덱
	 */
	public static void Deck(String [] newcard) {
		int m =1;
		for(int j =2 ; j<15; j++) {
			newcard[m] = "C"+Integer.toString(j);
			m++;
		}
		for(int j =2 ; j<15; j++) {
			newcard[m] = "D"+Integer.toString(j);
			m++;
		}
		for(int j =2 ; j<15; j++) {
			newcard[m] = "H"+Integer.toString(j);
			m++;
		}
		for(int j =2 ; j<15; j++) {
			newcard[m] = "S"+Integer.toString(j);
			m++;
		}
	}
	/**
	 * 카드를 섞어주는 메소드
	 * @param card	섞을 카드가 담겨져 있는 배열
	 * @param shuffle	섞을 방식들이 담겨져 있는 배열
	 * @param c	사용자가 선택한 섞을 방식
	 * @return	섞인 카드
	 */
	public static String [] Shuffle(String [] card, int [][] shuffle, int c) {
		String [] shfcard = new String [53];


		for(int j = 1; j<53; j++) {
			shfcard[j] = card[shuffle[c][j]];	//	사용자가 선택한 섞기방법으로 섞기
		}
		return shfcard;
	}
}