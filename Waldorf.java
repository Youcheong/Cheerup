package 알고리즘공부;
import java.util.*;

public class Waldorf {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int testcase = input.nextInt();	//	테스트케이스 갯수
		

		for(int t =0; t<testcase; t++) {
			int m = input.nextInt();	//	행
			int n = input.nextInt();	//	행에있는 글자의 개수 
			char [][] grid = new char [m][n];	//	글자들이 들어가 있는 그리드 

			//그리드 입력 받기
			for(int i =0; i<m; i++) {
				String letter = input.next();	//	그리드에 들어간 글자들 (한줄)
				letter = letter.toUpperCase();	//	모두 대문자로 변환
				for(int j =0; j<n; j++)  {
					grid[i][j] = letter.charAt(j);	//	한글자씩 배열에 넣는다.
				}
			}

			//찾을 단어 입력받기
			int w = input.nextInt(); 	// 단어의 개수
			boolean skip;	// 단어를 찾으면 그 다음줄에 출현하는 단어는 출력하지 않기 위한 조건
			for(int s =0; s<w; s++) {
				skip = true;	
				String word = input.next();
				word = word.toUpperCase();	//	단어 대문자로 변환
				for(int i=0; i<m; i++) {
					for(int j =0; j<n; j++) {
						if(word.charAt(0) == grid[i][j] && skip) {	//	단어의 첫글자를 찾았을 때
							if(find_match(grid, word, i, j)) {	//	단어를 찾았을 때
								System.out.println((i+1) + " " + (j+1));	
								skip = false;	//	다음줄에 같은 단어가 출현해도 출력하지 않는다.
							}
						}
					}
				}
			}
			System.out.println();	//	테스트케이스마다 빈줄 출력
		}
	}
	/**
	 * 위치(start_i, start_j)부터 시작하여 8방향으로 단어 word를 찾는다.
	 * @param grid	글자판.
	 * @param word	찾을 문자열.
	 * @param start_i	word를 찾기 시작한 위치 x 좌표.
	 * @param start_j	word를 찾기 시작한 위치 y 좌표.
	 * @return	word를 찾았으면 true, 그렇지 않으면 false.
	 */
	public static boolean find_match(char [][] grid,String word,int start_i,int start_j) {

		//	8가지 방향을 나타내기 위한 배열
		int [] plusi = {-1,-1,-1,0,0,1,1,1};
		int [] plusj = {-1,0,1,-1,1,-1,0,1};

		for(int p =0; p<8; p++) {
			int i = start_i;	// x좌표 시작위치
			int j = start_j;	//	y좌표 시작위치
			int t =1;	//	찾은 글자의 개수	
			for(int w =0; w<word.length(); w++) {
				if(t == word.length()) return true;	//	단어를 모두 찾았을 때,	true 리턴
				try {
					if(word.charAt(w) == grid[i][j]) {	//	단어 글자 비교
						i += plusi[p];
						j += plusj[p];
						t++;
					}
					else 	break;	
				}
				catch (ArrayIndexOutOfBoundsException e) {	//	첫번째 줄에서는 -1 할 때 인덱스 오류가 나므로 탈출한다.
					break;
				}
			}
		}
		return false;
	}
}



