package 알고리즘공부;
import java.util.*;

public class Bridge {
	public static void main(String[] args) {

		Scanner input = new Scanner (System.in);

		int testcase = input.nextInt();	//	테스트 케이스 개수
		int result = 0;
		for(int t =0; t<testcase; t++) {
			result = 0;

			int num = input.nextInt();	//	사람들 명수
			int [] speed = new int [num];

			for(int n = 0; n<num; n++) {	//	사람별로 다리를 건너는 속도를 입력 받는다.
				speed[n] = input.nextInt();
			}
			
			Arrays.sort(speed);	//	정렬

			if(speed.length == 2) {	//	2명일 때 둘이 건너간다.
				result += speed[1]; 
			}
			else if(speed.length == 3) {	//	3명일 때
				result += speed[2] + speed[0] + speed[1];	//	가장 빠른 사람이 가장 느린사람을  데려다 주고, 가장 빠른 사람이 후래시를 가지고 돌아와서 나머지 한명을 데리고 간다. 
			}
			//	4명 이상일 때
			//	1)가장 빠른 사람이 느린사람 부터 왔다갔다 왕복하면서 데려다 준다.  
			//	2)가장 빠른사람하고 두번째 빠른사람이 가고 느린사람들을 먼저 보내고 마지막에 두번째 사람이 후래시를 들고 다시 와서 1번을 데리고 간다.
			else if (speed.length >= 4) {	

				if(m1(speed) > m2(speed)) result = m2(speed);	//	첫번 째 방법이 더 적게 걸릴 때
				else result = m1(speed);	//	똑같거나 두번째 방법이 더 적게 걸릴 때
			}
			
			System.out.println(result);
			System.out.println();
		}
	}

	/**
	 * 제일 빠른 사람이 느린사람부터 한명씩 옮기는 방법
	 * @param speed 다리를 건너는 속도가 들어있는 배열
	 * @return	모두가 이동하는데 걸린 시간
	 */
	public static int m1 (int [] speed) {
		int result = 0;	//	총 걸린 시간
		for(int i=speed.length-1; i>0; i--) {	//	가장 빠른 사람이 느린사람부터 한명씩 이동시키고 후래시를 다시 가지고 돌아온다.
			result += (speed[i] + speed[0]);
		}
		
		return result-speed[0];	//	반복문에서 마지막에 가장 빠른사람이 한번 더 돌아오는걸로 돼있으므로 한번 더 뺀다.

	}
	/**
	 * 먼저 가장 빠른 2명이 이동하고 가장 빠른 사람이 혼자 후래시를 들고 돌아오고 
	 * 남은 사람중에 제일 느린 2명이 이동하고 건너가 있던 두번째 빠른 사람이 후래시를 다시 가지고 돌아온다.
	 * 이를 반복하여 남은사람들이 3명이하로 남을 때까지 느린사람들 부터 이동시킨다.
	 * @param speed	다리를 건너는 속도가 들어있는 배열
	 * @return	모두 이동하는데 걸린 시간
	 */
	public static int m2 (int [] speed) {
		int result =0;	//	총 걸린 시간
		int remain = speed.length;	//	남아있는 사람들
		
		while(remain > 3) {	//	3명이하로 남을 때 까지
			
			result += (speed[1]);	//	처음에 가장 빠른 두명만 이동한다.
			result += speed[0];		//	가장 빠른 사람이 후래시를 가지고 돌아온다.
			result += (speed[remain-1]);	//	가장 느린 두명이 이동한다.
			result += speed[1];		//	두 번째 빠른 사람이 후래시를 가지고 돌아온다.
			
			remain -= 2;
			
		}
		
		if(remain == 2) {	//	남은사람들이 2명일 때
			result += speed[1]; 
		}
		else if(remain == 3) {	//	남은 사람들이 3명일 때
			result += speed[2] + speed[0] + speed[1];	//	제일 빠른 사람이 제일느린사람을  데려다 주고 후래시를 가지고 돌아와서 나머지 한명을 데리고 간다. 
		}
		return result;
	}
}
