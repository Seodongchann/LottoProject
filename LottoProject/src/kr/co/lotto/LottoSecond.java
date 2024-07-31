package kr.co.lotto;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public final class LottoSecond extends JFrame {

	public LottoSecond() {
		

		int x = 0;
		int y = 0;
		int w = 459;
		int h = 200;
		setLayout(null);
		List<JPanel> pnls = new ArrayList<JPanel>();
		for (int i = 0; i < 3; i++) {
			pnls.add(new JPanel());
			pnls.get(i).setBounds(x, y, w, h);
			y += 200;
			pnls.get(i).setLayout(null);
			pnls.get(i).setBackground(Color.white);
			add(pnls.get(i));
		}

		ImageIcon icon = new ImageIcon(LottoSecond.class.getResource("캡쳐4.png"));
		ImageIcon icon2 = new ImageIcon(LottoSecond.class.getResource("캡쳐2.png"));
		ImageIcon icon3 = new ImageIcon(LottoSecond.class.getResource("캡쳐1.png"));
		ImageIcon icon4 = new ImageIcon(LottoSecond.class.getResource("사이드2.png"));

		JLabel lb = new JLabel();
		lb.setIcon(icon);
		lb.setBounds(0, 0, 320, 200);
		JButton lb2 = new JButton();
		lb2.setIcon(icon2);
		lb2.setBounds(350, 50, 85, 85);
		lb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 new LottoLast().setVisible(true);
			}
		});

		pnls.get(0).add(lb);
		pnls.get(0).add(lb2);

		x = 50;
		y = 0;
		for (int i = 0; i < LottoNum.MAP.size(); i++) {
			char c = 'A';
			char s = (char) (c + i);
			JLabel lbl = new JLabel(String.valueOf(s));
			JLabel lbl2 = new JLabel("자  동");

			lbl.setBounds(x, y, 40, 40);
			lbl2.setBounds(x += 50, y, 40, 40);
			for (int j = 0; j < LottoNum.MAP.get(String.valueOf(s)).size(); j++) {
				String s2 = String.valueOf(LottoNum.MAP.get(String.valueOf(s)).get(j));
				System.out.println(s2);
				JLabel lbls = new JLabel(s2);
				lbls.setFont(new Font("", Font.BOLD, 15));
				x += 50;
				lbls.setBounds(x, y, 40, 40);
				pnls.get(1).add(lbls);
			}
			x = 50;
			y += 40;
			pnls.get(1).add(lbl);
			pnls.get(1).add(lbl2);
		}
		pnls.get(1).setBackground(Color.white);

		JLabel lb3 = new JLabel();
		JLabel lb4 = new JLabel("$  " + (LottoNum.MAP.size() * 1000));
		lb4.setFont(new Font("", Font.BOLD, 25));

		lb3.setBounds(0, 0, 500, 200);
		lb3.setIcon(icon3);
		lb4.setBounds(333, 20, 150, 50);

		pnls.get(2).add(lb4);
		pnls.get(2).add(lb3);
		
		
		JPanel pn = new JPanel();
		JLabel ilbl = new JLabel();
		pn.setLayout(null);
		pn.setBounds(459, 0, 41, 600);
		ilbl.setBounds(0, 0, 41, 600);
		ilbl.setIcon(icon4);
		pn.add(ilbl);
		
		add(pn);
		setSize(500, 630);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new LottoSecond().setVisible(true);
	}
}
