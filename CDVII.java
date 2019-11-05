package 알고리즘공부;
import java.util.*;

public class CDVII {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);

		int testcase = input.nextInt();

		int [] hours = new int [24];	//	시간별 요금이 들어가는 배열 (00:00~23:59)
		String [] word = {};	//	스페이스를 기준으로 문자열을 나눈 단어들이 들어갈 배열
		String [] time = {};	//	:를 기준으로 날짜와 시간을 구분

		for(int t =0; t<testcase; t++) {

			HashMap<String, ArrayList<Record> > records = new HashMap<String,ArrayList<Record>>();	//	 차량별 레코드
			ArrayList<Record> rec = new ArrayList<Record>();	//	전체차량의 통과 레코드를 담을 배열
			ArrayList<String> car = new ArrayList<String>();	//	차량 번호판을 담을 배열

			for(int i =0; i<24; i++) {	//	시간별 요금 입력 (km/당 cent)
				hours[i] = input.nextInt();
			}
			input.nextLine();

			while(input.hasNextLine()) {

				String tmp = input.nextLine();	//	레코드 입력
				if (tmp.equals("")) break;	//	빈줄시 탈출

				word = tmp.split("\\s+");		//	0:번호판 		1:날짜와 시간 	2:출입여부 		3:고속도로 끝으로 부터의 거리
				time = word[1].split(":");		//	0:달 		1:일  	2:시간 	3:분
				Record r = new Record(word[0], word[2], time[0]+time[1]+time[2], time[2], word[3]);	//	레코드객체

				car.add(word[0]);	//	차량번호들을 추가한다.
				rec.add(r);			//	전체 레코드들을 추가한다.
			}

			HashSet <String> delete = new HashSet <String> (car);	//	차량번호판의 중복 제거
			car = new ArrayList<String>(delete);

			for(int i =0; i <car.size(); i++) {
				ArrayList<Record> re = new ArrayList<Record>();		//	차량별 레코드 기록들을 담을 배열
				for(int j =0; j<rec.size(); j++) {
					if(car.get(i).equals(rec.get(j).carnum)) {		//	차량번호판을 비교하여 담는다.
						re.add(rec.get(j));
					}
				}
				Collections.sort(re);	//	시간순으로 정렬
				records.put(car.get(i), re);		//	차량번호판을 key로 하여 해쉬맵에 넣는다.
			}

			TreeMap<String,ArrayList<Record>> tm = new TreeMap<String,ArrayList<Record>>(records);		//	번호판을 알파벳 순으로 정렬하기 위해 treemap 사용
			Iterator<String> iteratorKey = tm.keySet( ).iterator( );


			while(iteratorKey.hasNext()){
				String key = iteratorKey.next();
				
				int fee = 200  ;		//	달 기본요금 2달러
			
				if(records.get(key).size() %2 == 0) {	//	enter와 exit가 짝을 이룰 때
					for(int i =0; i<records.get(key).size()-1; i+=2) {
						fee += 100;	//	주행시 1달러씩 추가
						Record start = (Record) records.get(key).get(i);	//	차가 들어올 때 레코드
						Record end = (Record) records.get(key).get(i+1);		//	차가 나갈 때 레코드
						int distance = Math.abs(end.km-start.km);		//	이동한거리
						int pay = hours[start.hh];		//	입장한  시간대의 요금
						fee += distance*pay;	//	이동한 거리 * 입장한 시간대의 요금
				
					}
					System.out.printf(key +" $"+fee/100+"."+(fee%100)/10+fee%10);
					System.out.println();
				}
			}
			System.out.println();	//	테스트케이스마다 빈줄 출력 
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