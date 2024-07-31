package kr.co.lotto;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

public class LottoStart extends JFrame {
	private static final int Max = 6;
	private int count = 0;
	private int[] counts = { 0, 0, 0, 0, 0 };

	public LottoStart() {

//		JButton[] btn = new JButton[45];
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.white);

		JPanel p = new JPanel();
		JLabel lbl = new JLabel();
		JButton btn = new JButton("다　　　음");
		btn.setBackground(Color.pink);
		btn.setBounds(30, 0, 150, 50);
		ImageIcon icon = new ImageIcon(LottoStart.class.getResource("sss.png"));
		lbl.setIcon(icon);
		p.setLayout(null);
		p.setBounds(0, 0, 200, 520);
		lbl.setBounds(0, 0, 200, 520);
		p.add(btn);
		p.add(lbl);
		add(p);
		// 버튼 45개 생성
		int x = 200;
		int y = 0;
		int w = 300;
		int h = 600;
		int z = 0;
		int f = 50;
		// 페널 사이즈 조정
		int[] ss = new int[6];
		List<JPanel> list = new ArrayList<JPanel>();
		List<List<JButton>> list2 = new ArrayList<List<JButton>>();
		for (int j = 0; j < 5; j++) {
			JPanel btnpnl = new JPanel();
			btnpnl.setLayout(null);
			btnpnl.setBounds(x, y, w, h);
			list.add(btnpnl);
			list.get(j).setBackground(Color.white);
			x += 320;
			// 버튼 45개 생성
			List<JButton> list3 = new ArrayList<JButton>();
			list2.add(list3);
			for (int i = 1; i < 46; i++) {
				JButton btn2 = new JButton(String.valueOf(i));
				list3.add(btn2);
				btn2.setBounds(z, f, 50, 20);
				z += 50;
				btn2.setBackground(Color.white);
				if (z >= 300) {
					z = 0;
					f += 40;
				}
				list.get(j).add(btn2);
				btn2Listener(list2, btn2);

			}

			z = 0;
			f = 50;

			getContentPane().add(btnpnl);

		}

		// 체크박스 위치 초기설정값
		int boxX = 0;
		int boxW = 150;
		int boxH = 30;

		// 자동 체크박스 5개 만들기
		for (int i = 0; i < list.size(); i++) {
//			JCheckBox box = new JCheckBox("자동");
//			box.setBounds(boxX, 500, boxW, boxH);
//			list.get(i).add(box);

			// 이건 버튼으로 5개 만들기 verison
			JButton btn4 = new JButton("자동");
			btn4.setBounds(240, 400, boxW, boxH);
			btn4.setSize(60, 20);
			btn4.setBackground(Color.PINK);
			list.get(i).add(btn4);

		}
		// ABCDE 가격표 만들기
		int lblX = 20;
		int lblW = 100;
		int lblH = 50;
		for (int i = 0; i < list.size(); i++) {
			char c = 'A';
			char c2 = (char) (c + i);
			String s = String.valueOf(c2);
//			JLabel lbl = new JLabel(s);
//			lbl.setBounds(25,35,lblW,lblH);
//			list.get(i).add(lbl);

			JTextPane tp = new JTextPane();
			tp.setText(s);
			tp.setBounds(0, 0, lblW, lblH);
			tp.setSize(65, 50);
//			tp.setBackground(Color.);
			list.get(i).add(tp);
			tp.setBorder(new LineBorder(Color.gray));

			JTextPane tp2 = new JTextPane();
			tp2.setText("1,000원");
			tp2.setBounds(65, 0, lblW, lblH);
			tp2.setSize(259, 50);
			tp2.setBackground(Color.pink);
			list.get(i).add(tp2);
			tp2.setBorder(new LineBorder(Color.gray));
			list.get(i).setBorder(new LineBorder(Color.pink));
		}

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				char gs = 'A';
				List<List<Integer>> li = new ArrayList<List<Integer>>();
				for (int i = 0; i < list2.size(); i++) {
					List<Integer> s = new ArrayList<Integer>();
					for (int j = 0; j < list2.get(i).size(); j++) {
						if (list2.get(i).get(j).getBackground().equals(Color.pink)) {
							s.add(Integer.parseInt(list2.get(i).get(j).getText()));
						}
					}
					li.add(s);
					System.out.println(li.get(i));
					if (li.get(i).size() >= 6) {
						String ss = String.valueOf(gs++);
						LottoNum.MAP.put(ss, li.get(i));
					}

				}

				new LottoSecond().setVisible(true);
			}
		});

		setSize(2000, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void btn2Listener(List<List<JButton>> list2, JButton btn2) {
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (btn2.getBackground().equals(Color.white)) {
					btn2.setBackground(Color.pink);
					for (int i = 0; i < list2.size(); i++) {
						counts[i] = 0;
						for (int j = 0; j < list2.get(i).size(); j++) {
							if (list2.get(i).get(j).getBackground().equals(Color.pink)) {
								counts[i]++;
							}
						}
					}
					for (int i = 0; i < counts.length; i++) {
						if (counts[i] > 6) {
							btn2.setBackground(Color.white);
						}
					}
				} else {
					btn2.setBackground(Color.white);
				}
			}
		});
	}

	public static void main(String[] args) {
		new LottoStart().setVisible(true);
	}
}
