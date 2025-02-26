import java.awt.event.*;

import javax.swing.*;

import java.awt.*;

class MyPanel extends JPanel {
	private JTextField field;
	private JTextArea area;
	
	public MyPanel() {
		field = new JTextField(20);
		field.addActionListener(new MyListener());
		area = new JTextArea(10, 20);	// 행, 열
		
		JScrollPane pane = new JScrollPane(area,	// 수평, 수직 스크롤바
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(field);
		add(pane);	// area가 포함된 JScrollPane 객체를 add
	}
	private class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String str = field.getText();
			area.append(str + "\n");
			field.selectAll();
		}
	}
}

class MyFrame extends JFrame {
	public MyFrame() {
		setTitle("Text Test");
		setSize(300, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 창에 스크롤
		JScrollPane pane = new JScrollPane(new MyPanel(),	// 수평, 수직 스크롤바
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(pane);
		
	//	add(new MyPanel());
		setVisible(true);
	}
}
public class Ch17_Pro03_TextTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame();
	}
}
