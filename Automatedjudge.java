package �˰������;
import java.util.*;

public class Automatedjudge {
	public static void main(String[] args) {


		Scanner input = new Scanner(System.in);
		//Accepted, presentation error, wrong answer
		String [] answers = new String[100];
		String [] inputs = new String [100];
		int num = 1;
		while (input.hasNextLine()) {

			int n = input.nextInt();		// ����
			if(n == 0) break;


			else {
				input.nextLine();
				for(int i =0; i<n; i++) {
					answers[i] = input.nextLine();
				}

				int m = input.nextInt();		//	����� ���
				input.nextLine();
				for(int i =0; i<m; i++) {
					inputs[i] = input.nextLine();
				}

				//Ȯ��
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
	 * ������ ��ġ�ϴ� �������� Ȯ���ϴ� �޼ҵ�
	 * @param answers ������
	 * @param inputs ������ ����
	 * @param n ����� ����
	 * @return �����̸� true , �����̸� false
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
	 * ���ڰ� ���ų� ���ڰ� �ƴ� �ٸ����ڰ� �ϳ� �̻� ��ġ���� ���� ��
	 * @param answers ������
	 * @param inputs ������ ����
	 * @param n ����� ����
	 * @return ������ ������ ������ true, ������  false
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


