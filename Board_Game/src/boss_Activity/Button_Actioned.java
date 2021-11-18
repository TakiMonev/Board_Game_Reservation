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
	public void getFoodPanel(Main_Activity ma, Make_Room mr, int flag)
	{
		JButton btn1 = new JButton("음료수");
		JButton btn2 = new JButton("음식");
		
		btn1.setBounds(150, 60, 100, 50);
		btn2.setBounds(530, 60, 100, 50);
		ma.foodPanels[flag].add(btn1);
		ma.foodPanels[flag].add(btn2);
		ma.frame.add(ma.foodPanels[flag]);
	}

	
}
