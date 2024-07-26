package kr.co.lotto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LottoNum {
	private int a;
	private int b;
	private int c;
	private int d;
	private int e;
	private int f;

}
