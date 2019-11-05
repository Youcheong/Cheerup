package �˰������;
import java.io.*;
import java.util.*;

public class DecOct {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String num;

		while(input.hasNextLine()) {

			num = input.nextLine();
			if(num.equals("0")) {	// 0�� ��
				System.out.println("0x0");
			}
			else if(num.charAt(0) == '0' && num.charAt(1)== 'x') {		//16������ ��
				int dec =0;
				num = num.substring(2);	// 0x�� �����Ѵ�.
				for(int i =0, j = num.length()-1; i<num.length(); i++,j--) {
					if(num.charAt(i) >= 'A') {	// 16���� ���ĺ��� ��
						dec += (int)(num.charAt(i)-55)*(int)(Math.pow(16,j));
					}
					else {	// 16���� ������ ��
						dec += (int)(num.charAt(i)-48)*(int)(Math.pow(16,j));
					}
				}
				System.out.println(dec);



			}

			else {	// 10������ ��
				int dec = Integer.parseInt(num);
				System.out.printf("0x" +Integer.toHexString(dec).toUpperCase());
			}

		}
	}

}
