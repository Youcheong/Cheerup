package �˰������;
import java.util.*;

public class Inout {
	public static void main(String[] args)  {

		Scanner input = new Scanner(System.in);		


		String j, k;

		String [] numbers = {};

		while(input.hasNextLine()) {
			boolean check = true;
			String count = input.nextLine();	// �������� ����

			j = input.nextLine();	// ������ �Է�
			j = j.trim();

			if(j.equals(""))	check = false;	// ù �����͸� ������ �Է��Ѵٸ� �ٽ� ó������ ���ư� ������ ������ �Է� �޴´�.
			else  	numbers = j.split("\\s+");

			if(check) {	//	������ �ƴ� ��
				
				while(input.hasNextLine()) {	
				
					k = input.nextLine();
					k = k.trim();

					if(k.equals("")) break;
					else  	System.out.println(numbers[Integer.parseInt(k)-1]);
					
					

				}
			}
		}
	}
}


