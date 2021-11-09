package boss_Activity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.accessibility.AccessibleContext;
import rooms.Rooms;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Make_Room {
	
	void setButton(Main_Activity ma, Rooms newRoom, int xpos, int ypos, int flag)
	{			
		/* �̸� ������� */
		JTextField name1 = new JTextField(15);
		
		/* ��ȭ��ȣ ������� */
		JTextField phone1 = new JTextField(15);
		
		/* �Ʒ� �κ� �г� */
		/* �̸� �Է� */
		JPanel inputname = new JPanel();
		newRoom.setInputName(inputname);
		inputname.setBackground(new Color(51, 255, 255));
		inputname.setBounds(0, 0, 784, 10);
		inputname.add(new JLabel("�̸� : "));
		inputname.add(name1);
		ma.num1.setInputName(inputname);
		//num1.setName(name1.toString());
		
		/* �ڵ��� ��ȣ �Է� */
		JPanel phonenum = new JPanel();
		newRoom.setPhoneNum(phonenum);
		phonenum.setBackground(new Color(51, 255, 255));
		phonenum.setBounds(0, 0, 784, 10);
		phonenum.add(new JLabel("�ڵ��� ��ȣ : "));
		phonenum.add(phone1);
		newRoom.setPhoneNum(phonenum);
		//num1.setPhone(phonenum.toString());
		
		/* ���� �ð� �Է� */
		JPanel inputtime = new JPanel();
		newRoom.setInputTime(inputtime);
		inputtime.setBackground(new Color(51, 255, 255));
		inputtime.setBounds(0, 0, 784, 10);
		JLabel timeInsert = new JLabel("�ð� : ");
		inputtime.add(timeInsert);
		SimpleDateFormat timeformat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm");
		Date time = new Date();
		String time1 = timeformat.format(time);
		JLabel temptime = new JLabel(time1);		// �ӽ� �ð�
		inputtime.add(temptime);
		newRoom.setInputTime(inputtime);
		
		// ���� / ���� ����
		JPanel status = new JPanel();
		status.setBackground(new Color(51, 255, 255));
		status.setBounds(0, 0, 784, 10);
		status.setLayout(new FlowLayout()); 					// new �� ���� ��!
		JButton resbtn = new JButton("����");
		JButton startbtn = new JButton("����");
		status.add(resbtn);
		status.add(startbtn);
		
		//JPanel bottom_panel = new JPanel();
		ma.panels[flag].setBackground(new Color(51, 255, 255));
		ma.panels[flag].setBounds(0, 500, 784, 200);
		//contentPane.add(bottom_panel);
		ma.panels[flag].setLayout(new BoxLayout(ma.panels[flag], BoxLayout.Y_AXIS));	// BoxLayout���� ����
		ma.panels[flag].add(newRoom.getInputName());
		ma.panels[flag].add(newRoom.getPhoneNum());
		ma.panels[flag].add(newRoom.getInputTime());
		ma.panels[flag].add(status);
		ma.panels[flag].setVisible(false);							// ��ư Ŭ�� ������ �� �� ����
		//bottom[flag].add(bottom_panel);
		
		//newRoom.setBottomPanel(bottom_panel); 					// bottom_panel �ֱ� (���߿� ������ ���� ����)
		
		// ���� ���� ȭ��
		//JPanel manage_res = new JPanel();
		JButton res_cancel = new JButton("���� ���");
		JButton res_to_start = new JButton("��� ����");
		ma.res[flag].add(res_cancel);								// ���� ��� ��ư �߰�
		ma.res[flag].add(res_to_start);							// ��� ���� ��ư �߰�
		res_cancel.setBounds(50, 50, 784, 10);
		res_to_start.setBounds(50, 80, 784, 10);
		ma.res[flag].setBackground(new Color(51, 255, 255));
		ma.res[flag].setBounds(0, 500, 784, 200);
		ma.frame.getContentPane().add(ma.res[flag]);
		//res[flag].setLayout(new BoxLayout(res[flag], BoxLayout.Y_AXIS));	// BoxLayout���� ����
		ma.res[flag].setVisible(false);							// ��ư Ŭ�� ������ �� �� ����
		//bottom[flag].add(manage_res);

	
		JButton room1 = new JButton("�� " + (flag + 1));
		JButton room1res = new JButton("");
		room1res.setVisible(false);
		
		// ��ư �ٿ�� ���� 
		room1.setBounds(xpos, ypos, 200, 100);						
		room1res.setBounds(xpos, ypos, 200, 100);
		ma.panel.add(room1);											
		ma.panel.add(room1res);
		ma.frame.add(ma.panels[flag]);
		
		/* room1��ư Ŭ�� �� */
		room1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for (int i = 0; i < ma.panels.length; i++)
				{
					if (flag != i)
					{
						ma.panels[i].setVisible(false);
						ma.res[i].setVisible(false);
					}
				}
				
				ma.panels[flag].setVisible(true);
				ma.res[flag].setVisible(false);
			}
		});
		
		/* room1res��ư Ŭ�� �� */
		room1res.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < ma.panels.length; i++)
				{
					if (flag != i)
					{
						ma.panels[i].setVisible(false);
						ma.res[i].setVisible(false);
					}
				}
				
				ma.panels[flag].setVisible(false);
				ma.res[flag].setVisible(true);
			}
		});
		
		/* ���� ��ư Ŭ�� �� */
		resbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for (int i = 0; i < ma.panels.length; i++)
				{
					if (flag != i)
					{
						ma.panels[i].setVisible(false);
						ma.res[i].setVisible(false);
					}
				}
				
				room1.setVisible(false);				// room1 ����ȭ
				room1res.setVisible(true);				// room1res ����ȭ
				newRoom.setName(name1.getText());
				newRoom.setPhone(phone1.getText());
				Date timeupdate = new Date();
				SimpleDateFormat timeformat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm");
				String time1 = timeformat.format(timeupdate);
				JLabel temptime = new JLabel(time1);
				newRoom.getInputTime().removeAll();			// �ð� �ʱ�ȭ
				JLabel timeInsert = new JLabel("�ð� : ");
				newRoom.getInputTime().add(timeInsert);
				newRoom.getInputTime().add(temptime);		// �ð� ������Ʈ -> ������ : ��� �ð��� �þ -> ���� �Ϸ�
				newRoom.setTime(time1);
				
				/*�ٹٲ��� �̿��ϱ� ���� HTML ���*/
				room1res.setText(String.format("<HTML>���� �ð� : %s <br>�̸� : %s<br>��ȭ��ȣ : %s</HTML>",newRoom.getTime(), newRoom.getName(), newRoom.getPhone()));
				ma.panels[flag].setVisible(false);			// bottom_panel ����ȭ, ���� ���� ����ȭ(�߰� ����)
				
			}
		});
		
		/* ���� ��� ��ư Ŭ�� �� */
		res_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {
				
				for (int i = 0; i < ma.panels.length; i++)
				{
					if (flag != i)
					{
						ma.panels[i].setVisible(false);
						ma.res[i].setVisible(false);
					}
				}
				
				ma.panels[flag].setVisible(false);
				ma.res[flag].setVisible(false);
				room1.setVisible(true);
				room1res.setVisible(false);
			}
		});
		
		/* ���� ��ư Ŭ�� �� */
		startbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
}
