package kr.co.lotto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class LottoStart extends JFrame {
	private static final int Max = 6;
	private int count = 0;
	private int[] counts = { 0, 0, 0, 0, 0 };

	// btn = NEXT버튼
	// btn2 = 숫자 1~45번 버튼
	// btn3 = 각 패널에있는 초기화버튼
	// btn4 = 각 패널에 있는 자동 버튼
	// btn5 = 전체 자동 버튼
	// btn6 = 전체 초기화버튼
	public LottoStart(int num) {

		Color color1 = new Color(255, 153, 255);
		Color color2 = new Color(255, 102, 255);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.white);

		JPanel p = new JPanel();
		JLabel lbl = new JLabel();
		
		//전체자동버튼 설정값
		JButton btn5 = FullAuto(p);
		
		//초기화 버튼 설정값
		JButton btn6 = RestBtn(p);
		
		//Next버튼 설정
		JButton btn = NextBtn();
		ImageIcon icon = new ImageIcon(LottoStart.class.getResource("asdfg.png"));
		lbl.setIcon(icon);
		p.setLayout(null);
		p.setBounds(0, 0, 200, 520);
		lbl.setBounds(0, 0, 200, 530);
		p.add(btn);
		p.add(lbl);
		add(p);
		// 버튼 45개 생성
		int x = 200;
		int y = 0;
		int w = 300;
		int h = 500;
		int z = 0;
		int f = 50;
		// 페널 사이즈 조정
		int[] ss = new int[6];
		//패널 담는 리스트 
		List<JPanel> list = new ArrayList<JPanel>();
		//각 패널당 버튼의 개수 
		List<List<JButton>> list2 = new ArrayList<List<JButton>>();
		//초기화 버튼 
		List<JButton> listC = new ArrayList<JButton>();
		//자동 버튼
		List<JButton> listD = new ArrayList<JButton>();
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

			// 각 패널에 버튼 45개 생성
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

			// 체크박스 위치 초기설정값
			int boxX = 0;
			int boxW = 150;
			int boxH = 30;

			// 버튼으로 5개 만들기 
			JButton btn4 = AutoBtn(list, listC, j, boxW, boxH);
			
			// 각 패널에있는 자동버튼 출력기능
			btn4Listener(listC, btn4, list3, btn5, color1, color2);

			// 전체 자동 기능 구현
			FullAutomatic(color1, color2, btn5, list2, list3, btn4);
			// 초기화 버튼
			RestBtn(btn5, btn6, list2, listC, list3, btn4);
			// 초기화 버튼 세팅
			ResetBtnSetting(btn5, list, list2, listC, listD, j, btnpnl, list3, boxW, boxH, btn4);

		}

		// ABCDE / 가격표 만들기
		int lblX = 20;
		int lblW = 100;
		int lblH = 50;
		for (int i = 0; i < list.size(); i++) {
			char c = 'A';
			char c2 = (char) (c + i);
			String s = String.valueOf(c2);
			Tf(list, lblW, lblH, i, s);

			Tf2(list, lblW, lblH, i);
		}
		//NEXT버튼 출력메소드
		NextBtnPrint(num, color1, color2, btn, list2, listC);

		setSize(1800, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	private JButton NextBtn() {
		JButton btn = new JButton("N E X T");
		btn.setBackground(Color.pink);
		btn.setBounds(40, 0, 120, 50);
		btn.setFont(new Font(" ", Font.BOLD, 20));
		return btn;
	}

	private JButton FullAuto(JPanel p) {
		JButton btn5 = new JButton("자동");
		btn5.setBackground(Color.pink);
		btn5.setBounds(50, 55, 75, 30);
		btn5.setFont(new Font(" ", Font.BOLD, 12));
		p.add(btn5);
		return btn5;
	}

	private JButton RestBtn(JPanel p) {
		JButton btn6 = new JButton("초기화");
		btn6.setBackground(Color.pink);
		btn6.setBounds(50, 85, 75, 30);
		btn6.setFont(new Font(" ", Font.BOLD, 12));
		p.add(btn6);
		return btn6;
	}

	private JButton AutoBtn(List<JPanel> list, List<JButton> listC, int j, int boxW, int boxH) {
		JButton btn4 = new JButton("자동");
		btn4.setBounds(225, 400, boxW, boxH);
		btn4.setSize(75, 20);
		btn4.setBackground(Color.PINK);
		list.get(j).add(btn4);
		listC.add(btn4);
		return btn4;
	}

	private void FullAutomatic(Color color1, Color color2, JButton btn5, List<List<JButton>> list2, List<JButton> list3,
			JButton btn4) {
		btn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btn5.setEnabled(false);
				btn4.setEnabled(false);
				Random r = new Random();
				for (int i = 0; i < list3.size(); i++) {
					if (list3.get(i).getBackground().equals(Color.pink)) {
						count++;
					}
					list3.get(i).setEnabled(false);
				}
				if (count == 0) {
					btn4.setBackground(color2);
				}
				if (count > 0) {
					btn4.setBackground(color1);

				}

				for (int i = 0; i < 6 - count; i++) {
					int a = r.nextInt(45) + 1;
					for (int j = 0; j < list3.size(); j++) {
						if (list3.get(j).getText().equals(String.valueOf(a))
								&& list3.get(j).getBackground().equals(Color.pink)) {
							i--;
						}
						if (list3.get(j).getText().equals(String.valueOf(a))
								&& list3.get(j).getBackground().equals(Color.white)) {
							list3.get(j).setBackground(Color.pink);
						}
					}

				}
				count = 0;
				for (int i = 0; i < list2.size(); i++) {
				}
			}
		});
	}

	private void RestBtn(JButton btn5, JButton btn6, List<List<JButton>> list2, List<JButton> listC,
			List<JButton> list3, JButton btn4) {
		btn6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btn5.setEnabled(true);
				for (int i = 0; i < list2.size(); i++) {
					if (!btn4.getBackground().equals(Color.pink)) {
						btn4.setBackground(Color.pink);
					}
					listC.get(i).setEnabled(true);
				}
				for (int i = 0; i < list3.size(); i++) {
					list3.get(i).setBackground(Color.white);
					list3.get(i).setEnabled(true);
				}
			}
		});
	}

	private void ResetBtnSetting(JButton btn5, List<JPanel> list, List<List<JButton>> list2, List<JButton> listC,
			List<JButton> listD, int j, JPanel btnpnl, List<JButton> list3, int boxW, int boxH, JButton btn4) {
		JButton btn3 = new JButton("초기화");
		btn3.setBounds(150, 400, boxW, boxH);
		btn3.setSize(75, 20);
		btn3.setBackground(Color.pink);
		list.get(j).add(btn3);
		listD.add(btn3);

		btn3Listener(list2, list3, listC, btn3, btn4, btn5, listD);
		getContentPane().add(btnpnl);
	}

	private void Tf(List<JPanel> list, int lblW, int lblH, int i, String s) {
		JLabel tf = new JLabel();
		tf.setHorizontalAlignment(JLabel.CENTER);
		tf.setFont(new Font(" ", Font.BOLD, 20));
		tf.setText(s);
		tf.setBounds(0, 0, lblW, lblH);
		tf.setSize(65, 50);
		list.get(i).add(tf);
		tf.setBorder(new LineBorder(Color.gray));
	}

	private void Tf2(List<JPanel> list, int lblW, int lblH, int i) {
		JLabel tf2 = new JLabel();
		tf2.setText("1,000원");
		tf2.setFont(new Font(" ", Font.BOLD, 20));
		tf2.setBounds(65, 0, lblW, lblH);
		tf2.setSize(259, 50);
		tf2.setOpaque(true);
		tf2.setBackground(Color.pink);
		tf2.setHorizontalAlignment(JLabel.CENTER);
		list.get(i).add(tf2);
		tf2.setBorder(new LineBorder(Color.gray));
		list.get(i).setBorder(new LineBorder(Color.pink));
	}

	private void NextBtnPrint(int num, Color color1, Color color2, JButton btn, List<List<JButton>> list2,
			List<JButton> listC) {
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				char gs = 'A';
				Map<String, List<Integer>> map = new HashMap<>();
				List<List<Integer>> li = new ArrayList<List<Integer>>();
				for (int i = 0; i < list2.size(); i++) {
					List<Integer> s = new ArrayList<Integer>();
					for (int j = 0; j < list2.get(i).size(); j++) {
						if (list2.get(i).get(j).getBackground().equals(Color.pink)) {
							s.add(Integer.parseInt(list2.get(i).get(j).getText()));
						}
					}
					li.add(s);
					if (li.get(i).size() >= 6) {
						String ss = String.valueOf(gs++);
						map.put(ss, li.get(i));
						if (listC.get(i).getBackground().equals(Color.pink)) {
							LottoNum.LIST2.get(num).add("수동");
						} else if (listC.get(i).getBackground().equals(color2)) {
							LottoNum.LIST2.get(num).add("자동");
							count++;

						} else if (listC.get(i).getBackground().equals(color1)) {
							count++;
							LottoNum.LIST2.get(num).add("반자동");
						}
					}

				}
				LottoNum.listM.get(num).putAll(map);

				if (map.size() > 0) {
					dispose();
					LottoSecond ls = new LottoSecond(num);
					ls.setVisible(true);
					LottoNum.s2.add(ls);
					JOptionPane.showMessageDialog(null, "결과확인 : QR코드를 클릭하여 주세요", "필수체크 사항",
							JOptionPane.WARNING_MESSAGE);
					LottoNum.count2++;
				}

				if (map.size() == 0) {
					JOptionPane.showMessageDialog(null, "ERORR", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	// 수동 버튼 클릭 이벤트
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
					for (int i = 0; i < list2.size(); i++) {
						for (int j = 0; j < list2.get(i).size(); j++) {
							if (list2.get(i).get(j).equals(btn2)) {
								counts[i]--;
							}
						}
					}
				}
				for (int i = 0; i < counts.length; i++) {
					System.out.println(counts[i]);
				}
			}
		});
	}

	// 각 패널의 초기화 이벤트 메소드
	public void btn3Listener(List<List<JButton>> list2, List<JButton> list3, List<JButton> lll, JButton btn3,
			JButton btn4, JButton btn5, List<JButton> listD) {
		btn3.addActionListener(new ActionListener() {
			int ss = 0;

			@Override
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < list3.size(); i++) {
					list3.get(i).setBackground(Color.white);
					list3.get(i).setEnabled(true);
				}
				// btn4의 색상이 pink가 아니라면
				if (!btn4.getBackground().equals(Color.pink)) {
					btn4.setBackground(Color.pink);
				}
				btn4.setEnabled(true);
				// 각 패널의 자동버튼이 true면 전체 자동버튼 true로 변경
				for (int i = 0; i < lll.size(); i++) {
					if (lll.get(i).isEnabled() == false) {
						ss++;
					}
					if (listD.get(i).equals(btn3)) {
						counts[i] = 0;
					}
					System.out.println(counts[i]);
				}
				if (ss == 0) {
					btn5.setEnabled(true);
				}

			}
		});
	}

	// 각 패널에있는 자동버튼 출력기능 
	public void btn4Listener(List<JButton> listC, JButton btn4, List<JButton> list3, JButton btn5, Color color1,
			Color color2) {
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btn4.setEnabled(false);
				btn5.setEnabled(false);
				Random r = new Random();

				for (int i = 0; i < listC.size(); i++) {
					if (listC.get(i).equals(btn4)) {
						counts[i] = 6;
					}
					System.out.println(counts[i]);
				}

				for (int i = 0; i < list3.size(); i++) {
					if (list3.get(i).getBackground().equals(Color.pink)) {
						count++;
					}
					list3.get(i).setEnabled(false);
				}
				if (count == 0) {
					btn4.setBackground(color2);
				}
				if (count > 0) {
					btn4.setBackground(color1);

				}

				for (int i = 0; i < 6 - count; i++) {
					int a = r.nextInt(45) + 1;
					for (int j = 0; j < list3.size(); j++) {
						if (list3.get(j).getText().equals(String.valueOf(a))
								&& list3.get(j).getBackground().equals(Color.pink)) {
							i--;
						}
						if (list3.get(j).getText().equals(String.valueOf(a))
								&& list3.get(j).getBackground().equals(Color.white)) {
							list3.get(j).setBackground(Color.pink);
						}
					}

				}
				count = 0;

			}
		});
	}
}
