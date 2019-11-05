package �˰������;
import java.util.*;

public class Cryptkicker {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		HashMap<Character, Character > map = new HashMap<Character,Character>();	//	��ȣ���� ��ȣ���� ���ڸ� ������ �ؽ���

		String key = "the quick brown fox jumps over the lazy dog";		// 	a~z�� �ٵ� �ִ� ��ȣ��
		String [] keyword = key.split(" ");

		char [] sentence = new char [8000];		// �ִ� 80���� 100��

		int testcase = input.nextInt();	//	�׽�Ʈ���̽� ����	
		input.nextLine();	
		input.nextLine();	

		for(int t =0; t<testcase; t++) {
			int s =0;
			boolean print = false;
			while(input.hasNextLine()) {
				
				boolean put = true;
				String secret = input.nextLine();
				if(secret.equals("")) break;	//	����� Ż��
				else if ( key.length() == secret.length()) {	//	��ȣ�� Ȯ���ϱ�
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

				for(int i = 0; i<secret.length(); i++) {	//	��ȣ�� ���ں��� �迭�� �߰��ϱ�
					sentence[s++] = secret.charAt(i);
				}
				sentence[s++] = '\\';	//	�ٹٲ�  ǥ��
			}

			//	��ȣ�� ���
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

			System.out.println();	//	�׽�Ʈ���̽����� �������
		}
	}
}
