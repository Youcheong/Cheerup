package �˰������;
import java.util.*;

public class CDVII {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);

		int testcase = input.nextInt();

		int [] hours = new int [24];	//	�ð��� ����� ���� �迭 (00:00~23:59)
		String [] word = {};	//	�����̽��� �������� ���ڿ��� ���� �ܾ���� �� �迭
		String [] time = {};	//	:�� �������� ��¥�� �ð��� ����

		for(int t =0; t<testcase; t++) {

			HashMap<String, ArrayList<Record> > records = new HashMap<String,ArrayList<Record>>();	//	 ������ ���ڵ�
			ArrayList<Record> rec = new ArrayList<Record>();	//	��ü������ ��� ���ڵ带 ���� �迭
			ArrayList<String> car = new ArrayList<String>();	//	���� ��ȣ���� ���� �迭

			for(int i =0; i<24; i++) {	//	�ð��� ��� �Է� (km/�� cent)
				hours[i] = input.nextInt();
			}
			input.nextLine();

			while(input.hasNextLine()) {

				String tmp = input.nextLine();	//	���ڵ� �Է�
				if (tmp.equals("")) break;	//	���ٽ� Ż��

				word = tmp.split("\\s+");		//	0:��ȣ�� 		1:��¥�� �ð� 	2:���Կ��� 		3:��ӵ��� ������ ������ �Ÿ�
				time = word[1].split(":");		//	0:�� 		1:��  	2:�ð� 	3:��
				Record r = new Record(word[0], word[2], time[0]+time[1]+time[2], time[2], word[3]);	//	���ڵ尴ü

				car.add(word[0]);	//	������ȣ���� �߰��Ѵ�.
				rec.add(r);			//	��ü ���ڵ���� �߰��Ѵ�.
			}

			HashSet <String> delete = new HashSet <String> (car);	//	������ȣ���� �ߺ� ����
			car = new ArrayList<String>(delete);

			for(int i =0; i <car.size(); i++) {
				ArrayList<Record> re = new ArrayList<Record>();		//	������ ���ڵ� ��ϵ��� ���� �迭
				for(int j =0; j<rec.size(); j++) {
					if(car.get(i).equals(rec.get(j).carnum)) {		//	������ȣ���� ���Ͽ� ��´�.
						re.add(rec.get(j));
					}
				}
				Collections.sort(re);	//	�ð������� ����
				records.put(car.get(i), re);		//	������ȣ���� key�� �Ͽ� �ؽ��ʿ� �ִ´�.
			}

			TreeMap<String,ArrayList<Record>> tm = new TreeMap<String,ArrayList<Record>>(records);		//	��ȣ���� ���ĺ� ������ �����ϱ� ���� treemap ���
			Iterator<String> iteratorKey = tm.keySet( ).iterator( );


			while(iteratorKey.hasNext()){
				String key = iteratorKey.next();
				
				int fee = 200  ;		//	�� �⺻��� 2�޷�
			
				if(records.get(key).size() %2 == 0) {	//	enter�� exit�� ¦�� �̷� ��
					for(int i =0; i<records.get(key).size()-1; i+=2) {
						fee += 100;	//	����� 1�޷��� �߰�
						Record start = (Record) records.get(key).get(i);	//	���� ���� �� ���ڵ�
						Record end = (Record) records.get(key).get(i+1);		//	���� ���� �� ���ڵ�
						int distance = Math.abs(end.km-start.km);		//	�̵��ѰŸ�
						int pay = hours[start.hh];		//	������  �ð����� ���
						fee += distance*pay;	//	�̵��� �Ÿ� * ������ �ð����� ���
				
					}
					System.out.printf(key +" $"+fee/100+"."+(fee%100)/10+fee%10);
					System.out.println();
				}
			}
			System.out.println();	//	�׽�Ʈ���̽����� ���� ��� 
		}
	}

	static class Record implements Comparable <Record> {

		String carnum;
		String enter_exit;
		int mmddhh;
		int hh;
		int km;

		public Record(String carnum , String enter_exit, String mmddhh, String hh, String km) {
			this.carnum = carnum;
			this.enter_exit = enter_exit;
			this.mmddhh = Integer.parseInt(mmddhh);
			this.km = Integer.parseInt(km);
			this.hh = Integer.parseInt(hh);
		}
		@Override
		public int compareTo(Record r) {

			return this.mmddhh - r.mmddhh;
		}
	}
}