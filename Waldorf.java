package �˰������;
import java.util.*;

public class Waldorf {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int testcase = input.nextInt();	//	�׽�Ʈ���̽� ����
		

		for(int t =0; t<testcase; t++) {
			int m = input.nextInt();	//	��
			int n = input.nextInt();	//	�࿡�ִ� ������ ���� 
			char [][] grid = new char [m][n];	//	���ڵ��� �� �ִ� �׸��� 

			//�׸��� �Է� �ޱ�
			for(int i =0; i<m; i++) {
				String letter = input.next();	//	�׸��忡 �� ���ڵ� (����)
				letter = letter.toUpperCase();	//	��� �빮�ڷ� ��ȯ
				for(int j =0; j<n; j++)  {
					grid[i][j] = letter.charAt(j);	//	�ѱ��ھ� �迭�� �ִ´�.
				}
			}

			//ã�� �ܾ� �Է¹ޱ�
			int w = input.nextInt(); 	// �ܾ��� ����
			boolean skip;	// �ܾ ã���� �� �����ٿ� �����ϴ� �ܾ�� ������� �ʱ� ���� ����
			for(int s =0; s<w; s++) {
				skip = true;	
				String word = input.next();
				word = word.toUpperCase();	//	�ܾ� �빮�ڷ� ��ȯ
				for(int i=0; i<m; i++) {
					for(int j =0; j<n; j++) {
						if(word.charAt(0) == grid[i][j] && skip) {	//	�ܾ��� ù���ڸ� ã���� ��
							if(find_match(grid, word, i, j)) {	//	�ܾ ã���� ��
								System.out.println((i+1) + " " + (j+1));	
								skip = false;	//	�����ٿ� ���� �ܾ �����ص� ������� �ʴ´�.
							}
						}
					}
				}
			}
			System.out.println();	//	�׽�Ʈ���̽����� ���� ���
		}
	}
	/**
	 * ��ġ(start_i, start_j)���� �����Ͽ� 8�������� �ܾ� word�� ã�´�.
	 * @param grid	������.
	 * @param word	ã�� ���ڿ�.
	 * @param start_i	word�� ã�� ������ ��ġ x ��ǥ.
	 * @param start_j	word�� ã�� ������ ��ġ y ��ǥ.
	 * @return	word�� ã������ true, �׷��� ������ false.
	 */
	public static boolean find_match(char [][] grid,String word,int start_i,int start_j) {

		//	8���� ������ ��Ÿ���� ���� �迭
		int [] plusi = {-1,-1,-1,0,0,1,1,1};
		int [] plusj = {-1,0,1,-1,1,-1,0,1};

		for(int p =0; p<8; p++) {
			int i = start_i;	// x��ǥ ������ġ
			int j = start_j;	//	y��ǥ ������ġ
			int t =1;	//	ã�� ������ ����	
			for(int w =0; w<word.length(); w++) {
				if(t == word.length()) return true;	//	�ܾ ��� ã���� ��,	true ����
				try {
					if(word.charAt(w) == grid[i][j]) {	//	�ܾ� ���� ��
						i += plusi[p];
						j += plusj[p];
						t++;
					}
					else 	break;	
				}
				catch (ArrayIndexOutOfBoundsException e) {	//	ù��° �ٿ����� -1 �� �� �ε��� ������ ���Ƿ� Ż���Ѵ�.
					break;
				}
			}
		}
		return false;
	}
}



