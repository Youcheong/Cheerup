package 알고리즘공부;
import java.util.*;

public class Cryptkicker {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		HashMap<Character, Character > map = new HashMap<Character,Character>();	//	암호문과 복호문의 글자를 저장할 해쉬맵

		String key = "the quick brown fox jumps over the lazy dog";		// 	a~z가 다들어가 있는 복호문
		String [] keyword = key.split(" ");

		char [] sentence = new char [8000];		// 최대 80문자 100줄

		int testcase = input.nextInt();	//	테스트케이스 개수	
		input.nextLine();	
		input.nextLine();	

		for(int t =0; t<testcase; t++) {
			int s =0;
			boolean print = false;
			while(input.hasNextLine()) {
				
				boolean put = true;
				String secret = input.nextLine();
				if(secret.equals("")) break;	//	공백시 탈출
				else if ( key.length() == secret.length()) {	//	암호문 확인하기
					secret = secret.trim();
					String [] vars = secret.split("\\s+");
					
					for(int j =0; j<vars.length; j++) {
						if(vars[j].length() != keyword[j].length()) {
							put = false;
						}
					}
					if(put) {
						map.clear();
						for(int i =0; i<key.length(); i++) {
							map.put(secret.charAt(i), key.charAt(i));	
						}
						print = true;
					}

				}

				for(int i = 0; i<secret.length(); i++) {	//	암호문 글자별로 배열에 추가하기
					sentence[s++] = secret.charAt(i);
				}
				sentence[s++] = '\\';	//	줄바꿈  표시
			}

			//	복호문 출력
			if(print) {
				for(int i =0; i<s; i++) {
					if(sentence[i] == '\\') {
						System.out.println();
					}
					else {
						if (map.containsKey(sentence[i])) {
							System.out.print(map.get(sentence[i]));
						} else {
							System.out.print(sentence[i]);
						}

					}
				}
			}
			else {
				System.out.println("No solution.");
			}

			System.out.println();	//	테스트케이스마다 빈줄출력
		}
	}
}
