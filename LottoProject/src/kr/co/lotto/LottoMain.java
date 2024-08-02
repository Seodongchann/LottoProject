package kr.co.lotto;

import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LottoMain extends JPanel {
	Random r = new Random();

	public LottoMain() {
	
		LottoNum.s = new ArrayList<LottoStart>();
		String s = JOptionPane.showInputDialog("");
		int num = Integer.parseInt(s);
		LottoNum.count = num;
		for (int i = 0; i < num; i++) {
			LottoNum.s.add(new LottoStart(i));

		}
		for (int i = 0; i < num; i++) {
			LottoNum.s.get(i).setVisible(true);
		}
		for (int i = 0; i <= num; i++) {
			LottoNum.listM.add(new HashMap<String, List<Integer>>());
			LottoNum.LIST2.add(new ArrayList<String>());
		}
		당첨번호추첨메소드(r);

	}

	public static void main(String[] args) {
		new LottoMain().setVisible(true);
	}

	public void 당첨번호추첨메소드(Random r) {
		while (true) {
			for (int i = 0; i < 7; i++) {
				int a = r.nextInt(45) + 1;
				LottoNum.SET.add(a);
			}
			if (LottoNum.SET.size() > 6) {
				break;
			} else {
				LottoNum.SET.clear();
			}
		}
	}
}
