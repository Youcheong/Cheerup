package 알고리즘공부;
import java.util.*;


public class Fmt {
	public static void main(String[] args) {

		Scanner input = new Scanner (System.in);
		String line;	//	한줄

		while (input.hasNextLine()) {
			ArrayList<String> paragraph = new ArrayList<>(); 
			while (input.hasNextLine()) {	//	문단 입력받기
				line = input.nextLine();
				if (line.equals("") || line.matches("\\s+"))		// 빈줄과 공백만 있는 문자들을 만나면 탈출
					break;		
				paragraph.add(line);	
			}				
			
			for(int i =0; i<paragraph.size(); i++) {
				//	글자수가 0보다 크고 72보다 작을 때
				String print;
				if(paragraph.get(i).length() < 72 && i != paragraph.size()-1) {	
					paragraph = Cat(paragraph, i);
					print = paragraph.get(i);

					if(print.length() < 72 && i != paragraph.size()-1) {	//	다음 줄을 결합해도 72글자를 넘지 않을 때
						paragraph = Cat(paragraph, i);
						print = paragraph.get(i);
					}
					if((int)print.charAt(print.length()-1) == 32) {	//	문장 맨뒤에 공백이 있으면 지운다.
						print = print.substring(0,print.length()-1);
					}
					System.out.println(print);
				}
				//	글자수가 72보다 클 때
				else if (paragraph.get(i).length() > 72) {	
					if(!Isword(paragraph.get(i))) {	//	한 단어가 아닐 떼
						paragraph = Break(paragraph,i);
						System.out.println(paragraph.get(i));
					}
					else {	//	한 단어 일 때
						System.out.println(paragraph.get(i));
					}
				}
				//	글자수가 딱 72글자이거나 마지막 줄일 때
				else {	
					System.out.println(paragraph.get(i));
				}
			}
			System.out.println();	//	한 문단이 끝나면 빈줄 출력
		}
	}
	/**
	 * 72글자 미만의 문장을 다음줄에서 단어를 끌어 올려 출력한다.
	 * @param paragraph	문단
	 * @param index	글자를 더 출력할 수 있는 줄
	 * @return	변형된 문단
	 */
	public static ArrayList<String> Cat (ArrayList<String> paragraph, int index) {

		String cut = "";
		String curline = paragraph.get(index);	//	현재 줄
		String nextline = paragraph.get(index+1);	//	다음 줄
		int cnt = curline.length()+1;	//	띄어쓰기 1개 만큼 +1한 현재문장의 길이
		int possible = 72 - cnt;	//	더 출력 가능한 문자의 개수
		int i = 0;

		if((int)nextline.charAt(0) == 32) return paragraph;	//	다음줄의 첫번째 입력이 공백이라면 붙이는 것을 제외한다.

		if(possible < nextline.length()) {	//	다음줄의 길이가 출력 가능한 문자의 개수보다 많을 때
			while(cnt < 72) {	//	72글자가 될 때 까지 cut에 한글자씩 입력
				cut += nextline.charAt(i);
				i++;
				cnt++;
			}
		}
		else  {	//	출력 가능한 문자의 개수가 다음줄의 길이보다 클 때 다음줄 전체를 출력
			cut = nextline;
		}

		if(i>0) {	// 다음줄의 단어를 잘라서 전줄에 출력한 경우
			// 단어가 도중에 짤렸는지 확인

			int nextlinefirst = 0;	//	다음줄의 첫번째 단어의 길이
			for(int j =0; j<nextline.length(); j++) {
				if((int)nextline.charAt(j) == 32) break;
				nextlinefirst++;
			}

			if(Check(nextline,i)) {	//	단어가 짤렸다면
				if(cut.length() < nextlinefirst) cut = "";	// 붙일 문장이 다음줄의 첫 단어보다 작을 때, 붙일 문장 자체를 없앤다.

				else {
					for(int k =cut.length()-1; k>=0; k--) {
						if((int)cut.charAt(k) == 32) {	//	공백 전까지 지운다.
							cut = cut.substring(0,k);
							break;
						}	
					}
				}
			}
		}

		// paragraph 변경
		if(cut.length() != 0) {		//	추가로 붙일 문장이 있는 경우

			paragraph.remove(index);	//	기존의 문장을 삭제하고
			paragraph.add(index, curline + " " + cut );	//	변형된 문장을 추가
		}
		String newnextline = nextline.replaceFirst(cut, "");	//	윗줄에 추가된 단어들을 지운 문장
		paragraph.remove(index+1);	//	기존의 문장을 삭제하고
		
		if(newnextline.length()>0) {	//	문장앞 공백 없애기
			if((int)newnextline.charAt(0) == 32) {
				newnextline = newnextline.substring(1);
			}
		}

		if(newnextline.length() >0)		//	변형된 다음줄이 빈 문자열이 아니라면 변형된 문장을 추가 
			paragraph.add(index+1, newnextline);


		return paragraph;

	}
	/**
	 * 한 문장이 72글자를 초과하면 초과한 단어를 다음줄로 미뤄서 출력한다.
	 * @param paragraph	문단
	 * @param index	글자가 초과한 줄
	 * @return	변형된 문단
	 */
	public static ArrayList<String> Break (ArrayList<String> paragraph, int index) {

		String curline = paragraph.get(index);	//	현재 줄
		String newcurline = "";	//	변형된 현재 줄
		String cut = "";	//	현재줄에서 초과된 단어들
		int dif = curline.length() - 72;	//	72글자를 얼마나 초과하는지

		for(int i =curline.length()-1; i>0; i--, dif--) {	//	초과하는 만큼 단어를 자른다.
			if(dif <= 0 && (int)curline.charAt(i) == 32) {
				break;
			}
			newcurline = curline.substring(0,i);	//	초과한 만큼을 제외하고 새로운 문자열에 저장한다.
		}

		if((int)newcurline.charAt(newcurline.length()-1) == 32) {	//	문장 맨뒤에 공백이 있으면 지운다.
			newcurline = newcurline.substring(0,newcurline.length()-1);
		}

		// paragraph 변형
		cut = curline.replaceFirst(newcurline, "");	//	제외된 초과된 단어들
		cut = cut.trim();
		paragraph.remove(index);	//	기존 문장 제거
		paragraph.add(index,newcurline);	//	변경된 문장 추가

		if(index != paragraph.size()-1) {	// 초과한 줄이 마지막 줄이 아닐 때
			String nextline = paragraph.get(index+1);
			paragraph.remove(index+1);
			paragraph.add(index+1, cut+ " " + nextline);
		}
		else {	//	초과한 줄이 마지막 줄일 때 새로운 줄을 만든다.
			paragraph.add(cut);
		}
		return paragraph;
	}
	/**
	 * 마지막 문자가 단어가 잘린것인 지 아닌지 확인한다.
	 * @param nextline 다음줄
	 * @param i 붙여진 문장의 다음 인덱스
	 * @return 마지막 문자 다음 단어가 공백이거나 파일의 끝이라면 false, 문자라면 true(단어가 짤림)
	 */
	public static boolean Check (String nextline ,int i) {

		if(nextline.charAt(i) == 32 || i == nextline.length()-1) {	//	문장의 끝이거나  공백일 경우
			return false;
		}
		else {
			return true;
		}
	}
	/**
	 * 한단어로만 이루어져 있는지 확인한다.
	 * @param curline	현재 문장
	 * @return	단어로만 이루어져 있다면 true 아니면 false
	 */
	public static boolean Isword (String curline) {
		for(int i =0; i<curline.length(); i++) {
			if((int)curline.charAt(i) == 32) {	//	단어가 안닐 때
				return false;
			}
		}
		return true;
	}
}
