package �˰������;
import java.util.*;

public class Filefrag {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);


		int testcase = input.nextInt();	//	�׽�Ʈ���̽��� ����
		input.nextLine();
		input.nextLine();

		for(int i = 0; i<testcase; i++) {
			int num =0;	//	������ ����
			String [] pieces = new String [144];	//	������ ����� �ִ� �迭

			HashMap  <String,Integer> file = new HashMap<String,Integer>();		//	�������� ���ļ� ���Ϸ� ������ �͵��� ����

			while(input.hasNextLine()) {

				String piece = input.nextLine();	//	������ �Է�

				if(piece.equals("")) break;	//	���鹮�ڸ� Ż��
				else {
					piece = piece.trim();
					pieces[num++] = piece;
				}
			}

			int filelength = Filelength(pieces, num);	//	������ ����

			for(int j =0; j<num; j++) {
				String possible = "";	//	������ �� ���ִ� �ĺ�
				for(int k =0; k<num; k++) {
					if(filelength - pieces[j].length() == pieces[k].length() && j != k) {	//	������ ���̿� �´� ¦�� ã���� ��
						possible = pieces[j] + pieces[k];

						if(!file.containsKey(possible)) {	//	������ �ĺ��� HashMap�� ���� �� �߰�
							file.put(possible,1);
						}
						else {	//	������ �ĺ��� HashMap�� �ִٸ� value�� +1
							file.put(possible, file.get(possible)+1);
						}
					}
				}
			}
			//	���
			int max =0;
			for (String key : file.keySet()) {
				  if(file.get(key) > max) max = file.get(key);
				}
			
			for (String key : file.keySet()) {
				if(file.get(key) == max) {	//	���� �󵵼��� ���Ҵ� ������ ���
					System.out.println(key);
					break;

				}
			}

			System.out.println();}	
	}
	/**
	 * �������� �� ���� ª�� ������ ������ ���� �� ������ ���̸� ���ؼ� ������ ���̸� ���Ѵ�.
	 * @param pieces	�������� ����ִ� �迭
	 * @param num	�������� ����
	 * @return	������ ���� (������ ���� ª�� ���� + ������ ���� �� ����)
	 */
	public static int Filelength(String [] pieces, int num) {
		int max =0;
		int min = pieces[0].length();

		for(int i =0; i<num; i++ ) {
			if(max < pieces[i].length()) {	//	���� �� ����
				max = pieces[i].length();
			}

			if (min > pieces[i].length()) {	//	���� ª�� ����
				min = pieces[i].length();
			}

		}
		return max + min;	//	������ ����
	}
}