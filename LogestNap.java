package 알고리즘공부;
import java.util.*;

public class LogestNap {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int day = 1;	//	날짜

		while(input.hasNextLine()) {
			ArrayList<Appointment> appointment = new ArrayList<Appointment>();	//	스케줄들이 담길 Arraylist
			String [] schedules = {};	//	스케줄들이 담겨질 배열
			String [] starttimes = {};	//	시작시간을 담을 배열
			String [] endtimes = {};	//	종료시간을 담을 배열

			int i = input.nextInt();	//	스케줄의 개수
			input.nextLine();

			for(int s =0; s <i; s++) {
				String tmp = input.nextLine();	//	스케줄을 입력받는다.
				schedules = tmp.split("\\s");	//	스페이스를 기준으로 시작시간과 종료시간을 나눈다.
				starttimes = schedules[0].split(":");	//	:을 기준으로 시간과 분을 나눈다.
				endtimes = schedules[1].split(":");		//	:을 기준으로 시간과 분을 나눈다.

				Appointment app = new Appointment();	//	약속객체 생성
				app.startString = schedules[0];	//	약속객체의 시작시간
				app.endString =	schedules[1];	//	약속객체의 끝나는 시간
				app.startmin = Integer.parseInt(starttimes[0])*60 + Integer.parseInt(starttimes[1]);	//	시작시간을 분으로 환산한다.
				app.endmin = Integer.parseInt(endtimes[0])*60 + Integer.parseInt(endtimes[1]);		//	끝나는 시간을 분으로 환산한다.
				appointment.add(app);	//	ArrayList에 추가
			}
			Collections.sort(appointment);	//	스케줄별로 시작하는 시간을 기준으로 정렬

			int max = appointment.get(0).start()-10*60;	//	10:00 부터 첫 스케줄 전까지 
			Appointment app = appointment.get(0);		//	 첫 스케줄
			boolean first = true;	//	10:00 부터 첫 스케줄 까지 자는 낮잠이 가장 긴지 아닌지
			
			for(int a =0; a<appointment.size()-1;	a++) {	//	스케줄 사이마다 잘수있는 낮잠 시간중에 가장 긴 낮잠 시간대를 구한다.
				int naptime = appointment.get(a+1).start()-appointment.get(a).end();
				if(max < naptime) {
					first = false;
					max = naptime;
					app = appointment.get(a);
				}
			}
			//	모든 스케줄이 끝난시간부터 18:00 까지 잘 수있는 낮잠 시간을 구해서 스케줄들 사이의 최대 낮잠 시간과 비교한다.
			if(max < 18*60 - appointment.get(appointment.size()-1).end()) {
				max = 18*60 - appointment.get(appointment.size()-1).end();
				app = appointment.get(appointment.size()-1);
				first = false;
			}
			
			
			if(max >= 60)	{	//	최대로 잘수있는 낮잠시간이 1시간 이상일 때
				int hour = max/60;
				int min = max%60;
				if(first) 		System.out.printf("Day #%d: the longest nap starts at 10:00 and will last for %d hours and %d minutes.\n",day++,hour,min);
				else 	System.out.printf("Day #%d: the longest nap starts at %s and will last for %d hours and %d minutes.\n",day++,app.endString,hour,min);
			}
			else {	//	1시간 미만일 때
				if(first)		System.out.printf("Day #%d: the longest nap starts at 10:00 and will last for %d minutes.\n",day++,max);
				else 	System.out.printf("Day #%d: the longest nap starts at %s and will last for %d minutes.\n",day++,app.endString,max);
			}
		}

	}
	/**
	 * 스케줄을 구성하는 클래스
	 * 스케줄의 시작 시간과 끝나는 시간
	 * @author Han
	 *
	 */
	static class Appointment implements Comparable <Appointment> {

		String startString;	//	시작 시분 문자열		
		String endString;	//	끝 시분 문자열
		int startmin;	//	00:00부터 시작하는 시간까지 걸리는 분
		int endmin;		//	00:00부터 끝나는 시간까지 걸리는 분

		public int start() {
			return startmin;
		}
		public int end () {
			return endmin;
		}
		@Override
		public int compareTo(Appointment t) {
			return this.startmin-t.startmin;
		}
	}
}