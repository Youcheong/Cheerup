package 알고리즘공부;
import java.util.*;

public class Filefrag {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);


		int testcase = input.nextInt();	//	테스트케이스의 개수
		input.nextLine();
		input.nextLine();

		for(int i = 0; i<testcase; i++) {
			int num =0;	//	조각의 개수
			String [] pieces = new String [144];	//	조각이 담겨져 있는 배열

			HashMap  <String,Integer> file = new HashMap<String,Integer>();		//	조각들을 합쳐서 파일로 가능한 것들을 저장

			while(input.hasNextLine()) {

				String piece = input.nextLine();	//	조각들 입력

				if(piece.equals("")) break;	//	공백문자면 탈출
				else {
					piece = piece.trim();
					pieces[num++] = piece;
				}
			}

			int filelength = Filelength(pieces, num);	//	파일의 길이

			for(int j =0; j<num; j++) {
				String possible = "";	//	파일이 될 수있는 후보
				for(int k =0; k<num; k++) {
					if(filelength - pieces[j].length() == pieces[k].length() && j != k) {	//	파일의 길이에 맞는 짝을 찾았을 때
						possible = pieces[j] + pieces[k];

						if(!file.containsKey(possible)) {	//	파일의 후보가 HashMap에 없을 때 추가
							file.put(possible,1);
						}
						else {	//	파일의 후보가 HashMap에 있다면 value값 +1
							file.put(possible, file.get(possible)+1);
						}
					}
				}
			}
			//	출력
			int max =0;
			for (String key : file.keySet()) {
				  if(file.get(key) > max) max = file.get(key);
				}
			
			for (String key : file.keySet()) {
				if(file.get(key) == max) {	//	가장 빈도수가 많았던 파일을 출력
					System.out.println(key);
					break;

				}
			}

			System.out.println();}	
	}
	/**
	 * 파일조각 중 가장 짧은 길이의 조각과 가장 긴 조각의 길이를 더해서 파일의 길이를 구한다.
	 * @param pieces	조각들이 들어있는 배열
	 * @param num	조각들의 개수
	 * @return	파일의 길이 (조각의 가장 짧은 길이 + 조각의 가장 긴 길이)
	 */
	public static int Filelength(String [] pieces, int num) {
		int max =0;
		int min = pieces[0].length();

		for(int i =0; i<num; i++ ) {
			if(max < pieces[i].length()) {	//	가장 긴 조각
				max = pieces[i].length();
			}

			if (min > pieces[i].length()) {	//	가장 짧은 조각
				min = pieces[i].length();
			}

		}
		return max + min;	//	파일의 길이
	}
}