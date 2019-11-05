package �˰������;
import java.util.*;

public class LogestNap {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int day = 1;	//	��¥

		while(input.hasNextLine()) {
			ArrayList<Appointment> appointment = new ArrayList<Appointment>();	//	�����ٵ��� ��� Arraylist
			String [] schedules = {};	//	�����ٵ��� ����� �迭
			String [] starttimes = {};	//	���۽ð��� ���� �迭
			String [] endtimes = {};	//	����ð��� ���� �迭

			int i = input.nextInt();	//	�������� ����
			input.nextLine();

			for(int s =0; s <i; s++) {
				String tmp = input.nextLine();	//	�������� �Է¹޴´�.
				schedules = tmp.split("\\s");	//	�����̽��� �������� ���۽ð��� ����ð��� ������.
				starttimes = schedules[0].split(":");	//	:�� �������� �ð��� ���� ������.
				endtimes = schedules[1].split(":");		//	:�� �������� �ð��� ���� ������.

				Appointment app = new Appointment();	//	��Ӱ�ü ����
				app.startString = schedules[0];	//	��Ӱ�ü�� ���۽ð�
				app.endString =	schedules[1];	//	��Ӱ�ü�� ������ �ð�
				app.startmin = Integer.parseInt(starttimes[0])*60 + Integer.parseInt(starttimes[1]);	//	���۽ð��� ������ ȯ���Ѵ�.
				app.endmin = Integer.parseInt(endtimes[0])*60 + Integer.parseInt(endtimes[1]);		//	������ �ð��� ������ ȯ���Ѵ�.
				appointment.add(app);	//	ArrayList�� �߰�
			}
			Collections.sort(appointment);	//	�����ٺ��� �����ϴ� �ð��� �������� ����

			int max = appointment.get(0).start()-10*60;	//	10:00 ���� ù ������ ������ 
			Appointment app = appointment.get(0);		//	 ù ������
			boolean first = true;	//	10:00 ���� ù ������ ���� �ڴ� ������ ���� ���� �ƴ���
			
			for(int a =0; a<appointment.size()-1;	a++) {	//	������ ���̸��� �߼��ִ� ���� �ð��߿� ���� �� ���� �ð��븦 ���Ѵ�.
				int naptime = appointment.get(a+1).start()-appointment.get(a).end();
				if(max < naptime) {
					first = false;
					max = naptime;
					app = appointment.get(a);
				}
			}
			//	��� �������� �����ð����� 18:00 ���� �� ���ִ� ���� �ð��� ���ؼ� �����ٵ� ������ �ִ� ���� �ð��� ���Ѵ�.
			if(max < 18*60 - appointment.get(appointment.size()-1).end()) {
				max = 18*60 - appointment.get(appointment.size()-1).end();
				app = appointment.get(appointment.size()-1);
				first = false;
			}
			
			
			if(max >= 60)	{	//	�ִ�� �߼��ִ� ����ð��� 1�ð� �̻��� ��
				int hour = max/60;
				int min = max%60;
				if(first) 		System.out.printf("Day #%d: the longest nap starts at 10:00 and will last for %d hours and %d minutes.\n",day++,hour,min);
				else 	System.out.printf("Day #%d: the longest nap starts at %s and will last for %d hours and %d minutes.\n",day++,app.endString,hour,min);
			}
			else {	//	1�ð� �̸��� ��
				if(first)		System.out.printf("Day #%d: the longest nap starts at 10:00 and will last for %d minutes.\n",day++,max);
				else 	System.out.printf("Day #%d: the longest nap starts at %s and will last for %d minutes.\n",day++,app.endString,max);
			}
		}

	}
	/**
	 * �������� �����ϴ� Ŭ����
	 * �������� ���� �ð��� ������ �ð�
	 * @author Han
	 *
	 */
	static class Appointment implements Comparable <Appointment> {

		String startString;	//	���� �ú� ���ڿ�		
		String endString;	//	�� �ú� ���ڿ�
		int startmin;	//	00:00���� �����ϴ� �ð����� �ɸ��� ��
		int endmin;		//	00:00���� ������ �ð����� �ɸ��� ��

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