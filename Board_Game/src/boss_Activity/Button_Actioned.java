package boss_Activity;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import rooms.Rooms;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
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

	public void finalFrame(int finalPrice) 
	{
		JFrame confirmfrm = new JFrame();
		confirmfrm.setSize(400,300);
		confirmfrm.setBackground(Color.white);
		
		JPanel confirmPanel = new JPanel();
		confirmPanel.setSize(400, 300);
		confirmPanel.setBackground(Color.white);
		//confirmPanel.setLayout(null);
		confirmPanel.setLayout(new BoxLayout(confirmPanel, BoxLayout.Y_AXIS));
		
		JPanel announce = new JPanel();
		//announce.setLayout(null);
		announce.setSize(400, 200);
		JLabel finalPriceOutput = new JLabel("계산할 비용 : " + finalPrice);
		finalPriceOutput.setBackground(Color.white);
		finalPriceOutput.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		announce.add(finalPriceOutput);
		
		JPanel bottomAnnounce = new JPanel();
		bottomAnnounce.setSize(400, 100);
		
		// calFinish 버튼
		JButton calFinish = new JButton();
		calFinish.setBounds(300, 300, 200, 100);
		calFinish.add(new JLabel("확인"));
		bottomAnnounce.add(calFinish);
		
		confirmPanel.add(announce);
		confirmPanel.add(bottomAnnounce);
		//confirmPanel.add(calFinish);
		
		confirmfrm.add(confirmPanel);
		confirmfrm.setVisible(true);
		//System.out.println(finalPrice);
		
		calFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmfrm.setVisible(false);
				System.out.println("Calculation Completed!!");
			}
		});
	}
}
