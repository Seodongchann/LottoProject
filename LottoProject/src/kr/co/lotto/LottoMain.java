package kr.co.lotto;

import java.awt.Frame;
import java.io.IOException;
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
		JFrame frame = new JFrame();
		LottoNum.s = new ArrayList<LottoStart>();
		while (true) {
			try {
				String s = JOptionPane.showInputDialog("몇장을 사시겠습니까?");
				if (!s.equals(null)) {
					int num = Integer.parseInt(s);
					LottoNum.count = num;
					for (int i = 0; i < num; i++) {
						LottoNum.s.add(new LottoStart(i));
						LottoNum.s.get(i).setVisible(true);
						LottoNum.listM.add(new HashMap<String, List<Integer>>());
						LottoNum.LIST2.add(new ArrayList<String>());
					}
				} else if (s.equals(null)) {
					System.exit(0);

				}
				당첨번호추첨메소드(r);
				break;

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(frame, "숫자를 입력해 주세요!!!", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
			} catch (Exception e) {
				break;
			}

		}
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
