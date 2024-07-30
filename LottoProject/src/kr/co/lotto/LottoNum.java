package kr.co.lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data // getter setter euqals 등등등
//@Builder
//@AllArgsConstructor // 생성자
//@NoArgsConstructor // 기본생성자
public class LottoNum {
	List<String> list; // 자동 반자동 수동
	Map<String, List<Integer>> map; // KEY = A,B,C... List = 로또 번호

	// 번호입력 메소드
	public void putNum(String a, List list) {
		map.put(a, list);
	}

	// 유저가 입력한 로또 번호 출력 메소드( String은 KEY , Int는 몇번째 자리)
	// KEY의 특정 자리 숫자 한자리 출력 메소드
	public Integer printNum(String a, int i) {
		return map.get(a).get(i);
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