package �˰������;
import java.util.*;


public class Fmt {
	public static void main(String[] args) {

		Scanner input = new Scanner (System.in);
		String line;	//	����

		while (input.hasNextLine()) {
			ArrayList<String> paragraph = new ArrayList<>(); 
			while (input.hasNextLine()) {	//	���� �Է¹ޱ�
				line = input.nextLine();
				if (line.equals("") || line.matches("\\s+"))		// ���ٰ� ���鸸 �ִ� ���ڵ��� ������ Ż��
					break;		
				paragraph.add(line);	
			}				
			
			for(int i =0; i<paragraph.size(); i++) {
				//	���ڼ��� 0���� ũ�� 72���� ���� ��
				String print;
				if(paragraph.get(i).length() < 72 && i != paragraph.size()-1) {	
					paragraph = Cat(paragraph, i);
					print = paragraph.get(i);

					if(print.length() < 72 && i != paragraph.size()-1) {	//	���� ���� �����ص� 72���ڸ� ���� ���� ��
						paragraph = Cat(paragraph, i);
						print = paragraph.get(i);
					}
					if((int)print.charAt(print.length()-1) == 32) {	//	���� �ǵڿ� ������ ������ �����.
						print = print.substring(0,print.length()-1);
					}
					System.out.println(print);
				}
				//	���ڼ��� 72���� Ŭ ��
				else if (paragraph.get(i).length() > 72) {	
					if(!Isword(paragraph.get(i))) {	//	�� �ܾ �ƴ� ��
						paragraph = Break(paragraph,i);
						System.out.println(paragraph.get(i));
					}
					else {	//	�� �ܾ� �� ��
						System.out.println(paragraph.get(i));
					}
				}
				//	���ڼ��� �� 72�����̰ų� ������ ���� ��
				else {	
					System.out.println(paragraph.get(i));
				}
			}
			System.out.println();	//	�� ������ ������ ���� ���
		}
	}
	/**
	 * 72���� �̸��� ������ �����ٿ��� �ܾ ���� �÷� ����Ѵ�.
	 * @param paragraph	����
	 * @param index	���ڸ� �� ����� �� �ִ� ��
	 * @return	������ ����
	 */
	public static ArrayList<String> Cat (ArrayList<String> paragraph, int index) {

		String cut = "";
		String curline = paragraph.get(index);	//	���� ��
		String nextline = paragraph.get(index+1);	//	���� ��
		int cnt = curline.length()+1;	//	���� 1�� ��ŭ +1�� ���繮���� ����
		int possible = 72 - cnt;	//	�� ��� ������ ������ ����
		int i = 0;

		if((int)nextline.charAt(0) == 32) return paragraph;	//	�������� ù��° �Է��� �����̶�� ���̴� ���� �����Ѵ�.

		if(possible < nextline.length()) {	//	�������� ���̰� ��� ������ ������ �������� ���� ��
			while(cnt < 72) {	//	72���ڰ� �� �� ���� cut�� �ѱ��ھ� �Է�
				cut += nextline.charAt(i);
				i++;
				cnt++;
			}
		}
		else  {	//	��� ������ ������ ������ �������� ���̺��� Ŭ �� ������ ��ü�� ���
			cut = nextline;
		}

		if(i>0) {	// �������� �ܾ �߶� ���ٿ� ����� ���
			// �ܾ ���߿� ©�ȴ��� Ȯ��

			int nextlinefirst = 0;	//	�������� ù��° �ܾ��� ����
			for(int j =0; j<nextline.length(); j++) {
				if((int)nextline.charAt(j) == 32) break;
				nextlinefirst++;
			}

			if(Check(nextline,i)) {	//	�ܾ ©�ȴٸ�
				if(cut.length() < nextlinefirst) cut = "";	// ���� ������ �������� ù �ܾ�� ���� ��, ���� ���� ��ü�� ���ش�.

				else {
					for(int k =cut.length()-1; k>=0; k--) {
						if((int)cut.charAt(k) == 32) {	//	���� ������ �����.
							cut = cut.substring(0,k);
							break;
						}	
					}
				}
			}
		}

		// paragraph ����
		if(cut.length() != 0) {		//	�߰��� ���� ������ �ִ� ���

			paragraph.remove(index);	//	������ ������ �����ϰ�
			paragraph.add(index, curline + " " + cut );	//	������ ������ �߰�
		}
		String newnextline = nextline.replaceFirst(cut, "");	//	���ٿ� �߰��� �ܾ���� ���� ����
		paragraph.remove(index+1);	//	������ ������ �����ϰ�
		
		if(newnextline.length()>0) {	//	����� ���� ���ֱ�
			if((int)newnextline.charAt(0) == 32) {
				newnextline = newnextline.substring(1);
			}
		}

		if(newnextline.length() >0)		//	������ �������� �� ���ڿ��� �ƴ϶�� ������ ������ �߰� 
			paragraph.add(index+1, newnextline);


		return paragraph;

	}
	/**
	 * �� ������ 72���ڸ� �ʰ��ϸ� �ʰ��� �ܾ �����ٷ� �̷Ｍ ����Ѵ�.
	 * @param paragraph	����
	 * @param index	���ڰ� �ʰ��� ��
	 * @return	������ ����
	 */
	public static ArrayList<String> Break (ArrayList<String> paragraph, int index) {

		String curline = paragraph.get(index);	//	���� ��
		String newcurline = "";	//	������ ���� ��
		String cut = "";	//	�����ٿ��� �ʰ��� �ܾ��
		int dif = curline.length() - 72;	//	72���ڸ� �󸶳� �ʰ��ϴ���

		for(int i =curline.length()-1; i>0; i--, dif--) {	//	�ʰ��ϴ� ��ŭ �ܾ �ڸ���.
			if(dif <= 0 && (int)curline.charAt(i) == 32) {
				break;
			}
			newcurline = curline.substring(0,i);	//	�ʰ��� ��ŭ�� �����ϰ� ���ο� ���ڿ��� �����Ѵ�.
		}

		if((int)newcurline.charAt(newcurline.length()-1) == 32) {	//	���� �ǵڿ� ������ ������ �����.
			newcurline = newcurline.substring(0,newcurline.length()-1);
		}

		// paragraph ����
		cut = curline.replaceFirst(newcurline, "");	//	���ܵ� �ʰ��� �ܾ��
		cut = cut.trim();
		paragraph.remove(index);	//	���� ���� ����
		paragraph.add(index,newcurline);	//	����� ���� �߰�

		if(index != paragraph.size()-1) {	// �ʰ��� ���� ������ ���� �ƴ� ��
			String nextline = paragraph.get(index+1);
			paragraph.remove(index+1);
			paragraph.add(index+1, cut+ " " + nextline);
		}
		else {	//	�ʰ��� ���� ������ ���� �� ���ο� ���� �����.
			paragraph.add(cut);
		}
		return paragraph;
	}
	/**
	 * ������ ���ڰ� �ܾ �߸����� �� �ƴ��� Ȯ���Ѵ�.
	 * @param nextline ������
	 * @param i �ٿ��� ������ ���� �ε���
	 * @return ������ ���� ���� �ܾ �����̰ų� ������ ���̶�� false, ���ڶ�� true(�ܾ ©��)
	 */
	public static boolean Check (String nextline ,int i) {

		if(nextline.charAt(i) == 32 || i == nextline.length()-1) {	//	������ ���̰ų�  ������ ���
			return false;
		}
		else {
			return true;
		}
	}
	/**
	 * �Ѵܾ�θ� �̷���� �ִ��� Ȯ���Ѵ�.
	 * @param curline	���� ����
	 * @return	�ܾ�θ� �̷���� �ִٸ� true �ƴϸ� false
	 */
	public static boolean Isword (String curline) {
		for(int i =0; i<curline.length(); i++) {
			if((int)curline.charAt(i) == 32) {	//	�ܾ �ȴ� ��
				return false;
			}
		}
		return true;
	}
}
