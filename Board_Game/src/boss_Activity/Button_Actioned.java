package boss_Activity;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import rooms.Rooms;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Button_Actioned {
	
	JButton btn1 = new JButton("음료수");
	JButton btn2 = new JButton("음식");
	JButton confirm = new JButton("확인");
	JButton cancel = new JButton("취소");
	
	public void getFoodPanel(Main_Activity ma, Make_Room mr, int flag)
	{	
		btn1.setBounds(150, 60, 100, 50);
		btn2.setBounds(530, 60, 100, 50);
		confirm.setBounds(300, 150, 80, 40);
		cancel.setBounds(400, 150, 80, 40);
		ma.foodPanels[flag].add(btn1);
		ma.foodPanels[flag].add(btn2);
		ma.foodPanels[flag].add(confirm);
		ma.foodPanels[flag].add(cancel);
		ma.frame.add(ma.foodPanels[flag]);
	}

	
}
