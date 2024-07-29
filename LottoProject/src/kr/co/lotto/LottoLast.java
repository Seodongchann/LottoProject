package kr.co.lotto;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.sun.org.apache.bcel.internal.generic.NEW;

import javafx.scene.layout.BackgroundImage;

public class LottoLast extends JFrame {
	LottoNum l = new LottoNum();
	Set<Integer> set = new TreeSet<Integer>();
	Random r = new Random();

	public LottoLast() {
		super("결과");
		// 1등 번호 생성
		SetReset();
		l.list = new ArrayList<String>();
		l.map = new HashMap<String, List<Integer>>();
		List<String> listA = l.list;
		Map<String, List<Integer>> map = l.map;
		JLabel pnl = new JLabel();
		List<Integer> list = new ArrayList<Integer>();
		ImageIcon icon = new ImageIcon(LottoLast.class.getResource("/kr/co/lotto/로또1.png"));
		ImageIcon icon2 = new ImageIcon(LottoLast.class.getResource("/kr/co/lotto/lotto.png"));
		char c = 'A'; // 최초 번호 부여

		List<Integer> listS = new ArrayList<Integer>();
		for (Integer i : set) {
			listS.add(i);
		}
	// 임의의 값 넣는 조건
		for (int j = 1; j < 7; j++) {
			list.add(j);
		}
		for (int i = 0; i < 5; i++) {
			char c2 = (char) (c + i);
			String s = String.valueOf(c2);
			map.put(String.valueOf(c2), list);
		}
// 당첨 번호 출력 + 보너스 번호 출력
		int x = 40;
		int y = 180;
		int count = 0;
		for (int i = 0; i < listS.size(); i++) {
			char c2 = (char) (c + i);
			String s = String.valueOf(c2);
			if (i == listS.size() - 1) {
				x += 30;
				JLabel lb2 = new JLabel();
				lb2.setText("보너스");
				lb2.setBounds(x, y, 50, 50);
				pnl.add(lb2);
			}
			x += 50;
			JLabel lb2 = new JLabel();
			lb2.setText("" + listS.get(i));
			lb2.setBounds(x, y, 50, 50);
			pnl.add(lb2);
		}
		// 당첨 여부 조회
		// 당첨 번호와 조회
		int clap = 0;
		// 보너스 번호 추가 조회
		int clap1 = 0;
		int x2 = 70;
		int y2 = 380;

		for (int i = 0; i < map.size(); i++) {
			char c2 = (char) (c + i);
			String s = String.valueOf(c2);
			for (int j = 0; j < map.get(s).size(); j++) {
				for (int j2 = 0; j2 < listS.size(); j2++) {
					if (map.get(s).size() <= listS.size()) {
						if (map.get(s).get(j) == listS.get(j2)) {
							clap++;
						}
					} else {
						if (map.get(s).get(j) == listS.get(j2)) {
							clap1++;
						}
					}
				}
				
			}
			if (clap == 3) {
				JLabel lbD = new JLabel();
				lbD.setText("5등당첨");
				lbD.setBounds(x2, y2, 50, 50);
				pnl.add(lbD);
			} else if (clap == 4) {
				JLabel lbD = new JLabel();
				lbD.setText("4등당첨");
				lbD.setBounds(x2, y2, 50, 50);
				pnl.add(lbD);
			} else if (clap == 5) {
				JLabel lbD = new JLabel();
				lbD.setText("3등당첨");
				lbD.setBounds(x2, y2, 50, 50);
				pnl.add(lbD);
			} else if (clap == 5 && clap1 == 1) {
				JLabel lbD = new JLabel();
				lbD.setText("2등당첨");
				lbD.setBounds(x2, y2, 50, 50);
				pnl.add(lbD);
			} else if (clap == 6) {
				JLabel lbD = new JLabel();
				lbD.setText("1등당첨");
				lbD.setBounds(x2, y2, 50, 50);
				pnl.add(lbD);
			} else {
				JLabel lbD = new JLabel();
				lbD.setText("미당첨");
				lbD.setBounds(x2, y2, 50, 50);
				pnl.add(lbD);
			}
			y2 += 51;
			clap = 0;
			clap1 = 0;
		}

// 유저정보 출력
		int x1 = 150;
		int y1 = 380;
		for (int i = 0; i < map.size(); i++) {
			char c2 = (char) (c + i);
			String s = String.valueOf(c2);
			JLabel lb1 = new JLabel();
			lb1.setText("" + s);
			lb1.setBounds(x1-115, y1, 50, 50);
			pnl.add(lb1);
			for (int j = 0; j < map.get(s).size(); j++) {
				JLabel lb = new JLabel();
				lb.setText("" + map.get(s).get(j));
				// 이미지 위에 글자 출력
				lb.setBounds(x1, y1, 40, 40);
				pnl.add(lb);
				x1 += 60;
			}
			x1 -= (60 * map.get(s).size());
			y1 += 52;
		}
		pnl.setBounds(0, 0, 500, 700);
		pnl.setLayout(null);
		setLayout(null);
		add(pnl);
		pnl.setIcon(icon2);
		setBounds(0, 0, 500, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

// 1등 추첨번호 출력
	private void SetReset() {
		while (true) {
			for (int i = 0; i < 7; i++) {
				int a = r.nextInt(8)+1;
				set.add(a);
			}
			if (set.size() > 6) {
				break;
			} else {
				set.clear();
			}
		}
	}

	public static void main(String[] args) {
		new LottoLast().setVisible(true);
	}
}