package kr.co.lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;


public class LottoNum {
	List<String> list; // 자동 반자동 수동
	Map<String, List<Integer>> map; // KEY = A,B,C... List = 로또 번호

	static List<String> LIST = new ArrayList<>(); // 자동 반자동 수동
	static Map<String, List<Integer>> MAP = new HashMap<String, List<Integer>>(); // KEY = A,B,C... List = 로또 번호
	
	// 번호입력 메소드
	public void putNum(String a, List list) {
		MAP.put(a, list);
	}

	// 유저가 입력한 로또 번호 출력 메소드( String은 KEY , Int는 몇번째 자리)
	// KEY의 특정 자리 숫자 한자리 출력 메소드
	public Integer printNum(String a, int i) {
		return MAP.get(a).get(i);
	}

	// 자동 메소드
	public String choice(int b, List list) {
		if ("자동" == list.get(b)) {
			return "자　동";
		} else if ("반자동" == list.get(b)) {
			return "반자동";
		} else if ("수동" == list.get(b)) {
			return "수　동";
		}
		return "";
	}

}