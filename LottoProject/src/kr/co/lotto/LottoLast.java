package kr.co.lotto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.MediaTracker;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class LottoLast extends JFrame {
//	LottoNum l = new LottoNum();
	Set<Integer> set = new TreeSet<Integer>();
	Random r = new Random();

	public LottoLast() {
		super("결과");
		// 당첨 번호 생성
		SetReset();
		JLabel pnl = new JLabel();
		ImageIcon icon = new ImageIcon(LottoLast.class.getResource("/kr/co/lotto/lotto.png"));
		ImageIcon icon2 = new ImageIcon(LottoLast.class.getResource("/kr/co/lotto/lottoLog.png"));
		ImageIcon icon3 = new ImageIcon(LottoLast.class.getResource("/kr/co/lotto/보너스.png"));
		ImageIcon icon4 = new ImageIcon(LottoLast.class.getResource("/kr/co/lotto/핑크원형.png"));
		ImageIcon icon5 = new ImageIcon(LottoLast.class.getResource("/kr/co/lotto/핑크원형10.png"));
		ImageIcon icon6 = new ImageIcon(LottoLast.class.getResource("/kr/co/lotto/핑크원형20.png"));
		ImageIcon icon7 = new ImageIcon(LottoLast.class.getResource("/kr/co/lotto/핑크원형30.png"));
		ImageIcon icon8 = new ImageIcon(LottoLast.class.getResource("/kr/co/lotto/핑크원형40.png"));
		ImageIcon icon9 = new ImageIcon(LottoLast.class.getResource("/kr/co/lotto/lotto축하.jpg"));
		ImageIcon icon10 = new ImageIcon(LottoLast.class.getResource("/kr/co/lotto/숫자같은거.png"));
		char c = 'A'; // 최초 번호 부여
		// 당첨번호 라벨
		JLabel lbLo = new JLabel("당첨번호");
		lbLo.setHorizontalTextPosition(JLabel.CENTER);
		lbLo.setBounds(200, 95, 200, 100);
		lbLo.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		pnl.add(lbLo);
		// 로또 로고
		JLabel lbLog = new JLabel();
		lbLog.setIcon(icon2);
		lbLog.setBounds(0, 0, 500, 130);
		pnl.add(lbLog);
		// 출력값 정렬
		List<Integer> listS = new ArrayList<Integer>();
		for (Integer i : set) {
			listS.add(i);
		}
		/////////////////////////////////////
		// 임의의 값 넣는 조건
//		List<Integer> list = new ArrayList<>(); 
//		for (int j = 1; j < 7; j++) {
//			list.add(j);
//		}
//		for (int i = 0; i < 5; i++) {
//			char c2 = (char) (c + i);
//			String s = String.valueOf(c2);
//			LottoNum.MAP.put(String.valueOf(c2), list);
//		}
		////////////////////////////////////////
// 당첨 번호 출력 + 보너스 번호 출력
		int x = 30;
		int y = 155;
		int count = 0;
		for (int i = 0; i < listS.size(); i++) {
			char c2 = (char) (c + i);
			String s = String.valueOf(c2);
			if (i == listS.size() - 1) {
				x += 10;
				JLabel lb2 = new JLabel();
				lb2.setText("보너스");
				lb2.setBounds(x, y, 60, 60);
				lb2.setHorizontalTextPosition(JLabel.CENTER);
				lb2.setForeground(Color.BLACK);
				lb2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
				pnl.add(lb2);
				x += 53;
			}

			JLabel lb2 = new JLabel();
			lb2.setText("" + listS.get(i));
			lb2.setHorizontalTextPosition(JLabel.CENTER);
			lb2.setFont(new Font("맑은 고딕", Font.BOLD, 17));
			lb2.setForeground(Color.WHITE);
			lb2.setBounds(x, y, 60, 60);
			pnl.add(lb2);
			// 숫자 크기별 이미 넣기
			int a = listS.get(i);
			숫자크기별이미지(a, icon4, icon5, icon6, icon7, icon8, lb2);
			x += 53;
		}

		// 유저정보 출력
		int x1 = 145;
		int y1 = 370;
		for (int i = 0; i < LottoNum.MAP.size(); i++) {
			char c2 = (char) (c + i);
			String s = String.valueOf(c2);
			JLabel lb1 = new JLabel();
			lb1.setText("" + s);
			lb1.setBounds(x1 - 110, y1 - 10, 60, 60);
			lb1.setFont(new Font(" ", Font.BOLD, 15));
			lb1.setHorizontalTextPosition(JLabel.RIGHT);
			lb1.setForeground(Color.BLACK);
			pnl.add(lb1);
			for (int j = 0; j < LottoNum.MAP.get(s).size(); j++) {
				JLabel lb = new JLabel();
				lb.setText("" + LottoNum.MAP.get(s).get(j));
				lb.setBounds(x1, y1, 40, 40);
				lb.setFont(new Font("맑은 고딕", Font.BOLD, 15));
				lb.setForeground(Color.WHITE);
				lb.setHorizontalTextPosition(JLabel.CENTER);
				int a = LottoNum.MAP.get(s).get(j);
				숫자크기별이미지(a, icon4, icon5, icon6, icon7, icon8, lb);
				for (int l = 0; l < listS.size(); l++) {
					if (l <= LottoNum.MAP.get(s).size() - 1) {
						if (LottoNum.MAP.get(s).get(j).equals(listS.get(l))) {
							lb.setIcon(icon10);
						}
					} else {
						if (LottoNum.MAP.get(s).get(j).equals(listS.get(l))) {
							lb.setIcon(icon3);
						}
					}
				}
				pnl.add(lb);
				x1 += 55;
			}
			x1 -= (55 * LottoNum.MAP.get(s).size());
			y1 += 51;
		}

		// 당첨에 따라 출력
		int first = 0;
		int second = 0;
		int third = 0;
		int four = 0;
		int five = 0;
		int mess = 0;
		// 당첨 여부 조회
		// 당첨 번호와 조회
		int clap = 0;
		// 보너스 번호 추가 조회
		int clap1 = 0;
		int x2 = 70;
		int y2 = 370;
		// 당첨번호 조회 메소드
		for (int i = 0; i < LottoNum.MAP.size(); i++) {
			char c2 = (char) (c + i);
			String s = String.valueOf(c2);
			for (int j = 0; j < LottoNum.MAP.get(s).size(); j++) {
				for (int j2 = 0; j2 < listS.size(); j2++) {
					// j2 가 LottoNum.MAP.get(s).size() - 1만큼 돈다
					if (j2 <= LottoNum.MAP.get(s).size() - 1) {
						if (LottoNum.MAP.get(s).get(j) == listS.get(j2)) {
							clap++;
						}
						// j2 가 LottoNum.MAP.get(s).size를 벗어나면 돈다
					} else {
						if (LottoNum.MAP.get(s).get(j) == listS.get(j2)) {
							clap1++;
						}
					}
				}
			}

			if (clap == 3) {
				// 5등
				당첨메소드(pnl, x2, y2, 5, i);
				five++;
			} else if (clap == 4) {
				// 4등
				당첨메소드(pnl, x2, y2, 4, i);
				four++;
			} else if (clap == 5) {
				// 3등
				당첨메소드(pnl, x2, y2, 3, i);
				third++;
			} else if (clap == 5 && clap1 == 1) {
				// 2등
				당첨메소드(pnl, x2, y2, 2, i);
				second++;
			} else if (clap == 6) {
				// 1등
				당첨메소드(pnl, x2, y2, 1, i);
				first++;
			} else {
				// 꽝...
				당첨메소드(pnl, x2, y2, 0, i);
				mess++;
			}
			y2 += 50;
			clap = 0;
			clap1 = 0;
		}

		if (first > 0) {
			당첨메시지출력(pnl, 1, icon9);
		} else if (second > 0 && first <= 0) {
			당첨메시지출력(pnl, 2, icon9);
		} else if (third > 0 && second <= 0 && first <= 0) {
			당첨메시지출력(pnl, 3, null);
		} else if (four > 0 && third <= 0 && second <= 0 && first <= 0) {
			당첨메시지출력(pnl, 4, null);
		} else if (five > 0 && four <= 0 && third <= 0 && second <= 0 && first <= 0) {
			당첨메시지출력(pnl, 5, null);
		} else if (mess > 0 && five <= 0 && four <= 0 && third <= 0 && second <= 0 && first <= 0) {
			당첨메시지출력(pnl, 0, null);
		}

		// 다시하기
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "다시 응모하시겠습니까?");
				System.out.println(result);
				if (result == JOptionPane.OK_OPTION) {
					dispose();
					new LottoStart().setVisible(true);
					LottoNum.LIST.clear();
					LottoNum.MAP.clear();
				} else if (result == 1) {
					setDefaultCloseOperation(EXIT_ON_CLOSE);
				} else {
					setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				}
			}
		});

		pnl.setBounds(0, 0, 500, 670);
		pnl.setLayout(null);
		setLayout(null);
		add(pnl);
		pnl.setIcon(icon);
		setBounds(0, 0, 500, 670);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}

// 숫자 크기별 이미지 넣기
	private void 숫자크기별이미지(int a, ImageIcon icon4, ImageIcon icon5, ImageIcon icon6, ImageIcon icon7, ImageIcon icon8,
			JLabel lb) {
		if (a > 0 && a < 11) {
			lb.setIcon(icon4);
		} else if (a >= 11 && a < 21) {
			lb.setIcon(icon5);
		} else if (a >= 21 && a < 31) {
			lb.setIcon(icon6);
		} else if (a >= 31 && a < 41) {
			lb.setIcon(icon7);
		} else {
			lb.setIcon(icon8);
		}
		char c = 'A';
		lb.setHorizontalTextPosition(JLabel.CENTER);
	}

// 당첨 여부에 따라 메시지 출력
	private void 당첨메시지출력(JLabel pnl, int d, Icon icon) {
		JLabel lp = new JLabel();
		if (d == 0) {
			lp.setText("안타깝게 되었습니다..");
		} else if (d <= 5 && d >= 3) {
			lp.setText("축하드립니다 " + d + "등 당첨이 되셨습니다.");
		} else if (d < 3) {
			lp.setText("축하드립니다 " + d + "등 당첨이 되셨습니다!");
			JLabel pink = new JLabel();
			pink.setIcon(icon);
			pink.setBounds(20, 250, 60, 60);
			pnl.add(pink);
		}
		lp.setBounds(0, 230, 500, 100);
		lp.setHorizontalAlignment(SwingConstants.CENTER);
		lp.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		pnl.add(lp);
	}

// 당첨 중복 메소드
	private void 당첨메소드(JLabel pnl, int x2, int y2, int dl, int aA) {
		JLabel lbD = new JLabel();
		JLabel lbA = new JLabel();
		if (dl == 0) {
			lbD.setText("미당첨");
		} else {
			lbD.setText(dl + "등당첨");
		}
		if (aA == 0) {
			lbA.setText("(" + LottoNum.LIST.get(aA) + ")");
		} else if (aA == 1) {
			lbA.setText("(" + LottoNum.LIST.get(aA) + ")");
		} else if (aA == 2) {
			lbA.setText("(" + LottoNum.LIST.get(aA) + ")");
		} else if (aA == 3) {
			lbA.setText("(" + LottoNum.LIST.get(aA) + ")");
		} else if (aA == 4) {
			lbA.setText("(" + LottoNum.LIST.get(aA) + ")");
		}
		lbA.setBounds(x2, y2 + 15, 50, 30); // 자동 반자동 수동
		lbD.setBounds(x2, y2, 50, 30); // 당첨 확인
		lbD.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lbA.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		pnl.add(lbD);
		pnl.add(lbA);
	}

// 1등 추첨번호 출력
	private void SetReset() {
		while (true) {
			for (int i = 0; i < 7; i++) {
				int a = r.nextInt(45) + 1;
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