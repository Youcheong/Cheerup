package 알고리즘공부;
import java.util.*;

public class Automatedjudge {
	public static void main(String[] args) {


		Scanner input = new Scanner(System.in);
		//Accepted, presentation error, wrong answer
		String [] answers = new String[100];
		String [] inputs = new String [100];
		int num = 1;
		while (input.hasNextLine()) {

			int n = input.nextInt();		// 정답
			if(n == 0) break;


			else {
				input.nextLine();
				for(int i =0; i<n; i++) {
					answers[i] = input.nextLine();
				}

				int m = input.nextInt();		//	제출된 결과
				input.nextLine();
				for(int i =0; i<m; i++) {
					inputs[i] = input.nextLine();
				}

				//확인
				if(Isanswer(answers, inputs, n)) {
					System.out.println("Run #" + num++ + ": Accepted");
				}
				else if(IspresentationErr(answers, inputs, n)) {
					System.out.println("Run #" + num++ + ": Presentation Error");
				}

				else System.out.println("Run #" + num++ + ": Wrong Answer");
			}


		}
		System.out.println();
	}
	/**
	 * 완전히 일치하는 정답인지 확인하는 메소드
	 * @param answers 정답지
	 * @param inputs 제출한 정답
	 * @param n 답안의 개수
	 * @return 정답이면 true , 오답이면 false
	 */
	public static boolean Isanswer(String [] answers , String [] inputs, int n) {
		boolean result = true;
		for(int i = 0; i<n; i++) {
			if(!answers[i].equals(inputs[i]))
				result = false;
		}
		return result;
	}
	/**
	 * 숫자가 없거나 숫자가 아닌 다른문자가 하나 이상 매치되지 않을 때
	 * @param answers 정답지
	 * @param inputs 제출한 정답
	 * @param n 답안의 개수
	 * @return 문장의 오류가 있으면 true, 없으면  false
	 */
	public static boolean IspresentationErr(String [] answers, String [] inputs, int n) {

		String ans = "";
		String in = "";
		for(int i = 0; i<n; i++) {
			for(int j =0; j<answers[i].length(); j++) {
				if(Character.isDigit((answers[i].charAt(j)))) {
					ans += answers[i].charAt(j);
				}
			}
			for(int j =0; j<inputs[i].length(); j++) {
				if(Character.isDigit((inputs[i].charAt(j)))) {
					in += inputs[i].charAt(j);
				}
			}
			ans = ans.trim();
			in = in.trim();

		}
		if(ans.equals(in)) {
			return true;
		}
		else	return false;
	}
}


