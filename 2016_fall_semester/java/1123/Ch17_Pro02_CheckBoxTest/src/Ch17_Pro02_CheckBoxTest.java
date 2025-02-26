import java.awt.event.*;

import javax.swing.*;

import java.awt.*;

class MyPanel extends JPanel {
	JCheckBox[] check = new JCheckBox[3];
	String[] names = {"dog", "cat", "bear"};
	JLabel[] label = new JLabel[3];
	ImageIcon[] icon = new ImageIcon[3];
	
	public MyPanel() {
		setLayout(new GridLayout(1, 4));
		for(int i = 0; i < 3; i++) {
			check[i] = new JCheckBox(names[i]);
			check[i].addItemListener(new MyItemListener());
			label[i] = new JLabel(names[i] + ".png");
			icon[i] = new ImageIcon(names[i] + ".png");
		}
		JPanel namePanel = new JPanel(new GridLayout(3, 1));
		for (int i = 0; i < 3; i++)
			namePanel.add(check[i]);
		add(namePanel);
		add(label[0]);
		add(label[1]);
		add(label[2]);
	}
	private class MyItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			for(int i = 0; i < check.length; i++) {
				if(e.getSource() == check[i]) {
					if(e.getStateChange() == ItemEvent.DESELECTED) {// ��������
						label[i].setIcon(null);
						label[i].setText(names[i] + ".png");
					}
					else {
						label[i].setIcon(icon[i]);
						label[i].setText(null);
					}
				}
			}
		}
	}
	
}

public class Ch17_Pro02_CheckBoxTest extends JFrame {
	public Ch17_Pro02_CheckBoxTest() {
	setTitle("Image Label");
	setSize(500, 350);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	add(new MyPanel());
	setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ch17_Pro02_CheckBoxTest();
	}
}
