package �˰������;
import java.util.*;

public class StackemUp {
	/**
	 * ����ڷ� ���� �׽�Ʈ���̽� ������ ī�带 ���� ����� ������ ����� ������ŭ ���� ����� ���� �Է¹޴´�.
	 * ����� ������ŭ ���� ����� �Է¹޴´�.
	 * ī�带 ���� ����� ���õ� ������� ī�带 ���� �� ����Ѵ�. 
	 * @author ����û
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	
		String [] card = new String [53];	//	���ο� ī�嵦
		int [] [] shuffle = new int [100] [53];	//	���� ������ �Է¹��� �迭
		String [] shfcard = new String [53];	//	������ ī��
		int n = 0;	// ���� ����� ��
		String c = "";	//	����ڰ� ������ ���� ���
		
		int t = input.nextInt();	//�׽�Ʈ ���̽� ����
		
		for(int i = 0; i<t; i++) {
			
			Deck(card);		//	���ο� �� ����
			n = input.nextInt();	//	���� ����� �� �Է�
			
			for(int k =1; k <=n; k++) {	// ���� ��� �Է�
				for(int j=1; j<53; j++) {
					shuffle[k][j] = input.nextInt();
				}
			}
		
		input.nextLine();	//	���ۿ� ���� ���๮�ڸ� ���ֱ� ���� ȣ��

		// ī�� ����
			while(input.hasNextLine()) {
				
					c = input.nextLine();
					c = c.trim();
					
					if(c.equals("")) break;		//	������ ������ Ż��
					else 	card = Shuffle(card,shuffle,Integer.parseInt(c));	//	ī�� ����

			}

			shfcard = card;	//	����ī�� �ű��
			
			// ���
			for(int j =1; j<53; j++) {
				if(shfcard[j].length() == 2) {	//	���� 10�̸��� ��
					if(shfcard[j].charAt(0) == 'C') {	//	���̰� Ŭ�ι��� ��
						System.out.println(shfcard[j].charAt(1) + " of Clubs");
					}
					if(shfcard[j].charAt(0) == 'D') {	//	���̰� ���̾Ƹ�� �� ��
						System.out.println(shfcard[j].charAt(1) + " of Diamonds");
					}
					if(shfcard[j].charAt(0) == 'H') {	//	���̰� ��Ʈ�� ��
						System.out.println(shfcard[j].charAt(1) + " of Hearts");
					}
					if(shfcard[j].charAt(0) == 'S') {	//	���̰� �����̵��� ��
						System.out.println(shfcard[j].charAt(1) + " of Spades");
					}
				}
				else {	//	���ڰ� 10�̻��� ��
					if(shfcard[j].charAt(0) == 'C') {	//	���̰� Ŭ�ι� �� ��
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
					if(shfcard[j].charAt(0) == 'D') {	//	���̰� ���̾Ƹ�� �� ��
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
					if(shfcard[j].charAt(0) == 'H') {	//	���̰� ��Ʈ�� ��
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
					if(shfcard[j].charAt(0) == 'S') {	//	���̰� �����̵��� ��
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
			System.out.println();	//	�׽�Ʈ���̽����� ���� ���
		}
	}

	/**
	 * ���ĵ� ���ο� ī�带 ����� �޼ҵ�
	 * @param card ���ĵ� ���ο� ī�嵦
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
	 * ī�带 �����ִ� �޼ҵ�
	 * @param card	���� ī�尡 ����� �ִ� �迭
	 * @param shuffle	���� ��ĵ��� ����� �ִ� �迭
	 * @param c	����ڰ� ������ ���� ���
	 * @return	���� ī��
	 */
	public static String [] Shuffle(String [] card, int [][] shuffle, int c) {
		String [] shfcard = new String [53];


		for(int j = 1; j<53; j++) {
			shfcard[j] = card[shuffle[c][j]];	//	����ڰ� ������ ���������� ����
		}
		return shfcard;
	}
}