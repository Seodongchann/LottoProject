package kr.co.lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class LottoNum {
	// 당첨번호 결과 값 담을 set
	static Set<Integer> SET = new TreeSet<Integer>();
	// 자동 반자동 수동을 담을 수 있는 list
	static List<List<String>> LIST2= new ArrayList<List<String>>(); 
	// 로또 번호를 담는 리스트
	static List<Map<String, List<Integer>>> listM = new ArrayList<Map<String,List<Integer>>>();
	// Second 종이 개수 count
	static int count;
	// Second 종이 개수 count랑 비교 할 count2 같아야 QR코드 활성화
	static int count2;
	//각 클래스를 담는 리스트
	static List<LottoStart> s; 
	static List<LottoSecond> s2 = new ArrayList<LottoSecond>(); 
	static List<LottoLast> s3 = new ArrayList<LottoLast>(); 
	
	
}