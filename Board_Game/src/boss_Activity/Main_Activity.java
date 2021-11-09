/*
 VER1
 �߰����� : 
 �� �߰� ��� ����
 �� ��ư �߰�
 
 VER2
 �߰����� : 
 ����� ������ ��ư ��� �߰�
 */

package boss_Activity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.accessibility.AccessibleContext;
import rooms.Rooms;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main_Activity {
	public JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JPanel[] panels = new JPanel [4];
	JPanel[] res = new JPanel [4];
	
	//JPanel bottom = new JPanel();
	Container contentPane = frame.getContentPane();
	
	Rooms num1, num2, num3, num4;
	static Rooms[] nums = new Rooms[4];
	String user = "";
	
	/*���� �ҽ� ���� ���� (13 ~ 25)*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Activity window = new Main_Activity(); //
					window.frame.setVisible(true);				//	
				} catch (Exception e) {
					e.printStackTrace();						//
				}
			}
		});
	}
	
	public Main_Activity() {
		
		num1 = new Rooms();										// num1 ����
		num2 = new Rooms();
		//num3 = new Rooms();
		//num4 = new Rooms();
		
		nums[0] = num1;
		nums[1] = num2;
		
		for (int i = 0; i < 4; i++)
		{
			panels[i] = new JPanel();
			res[i] = new JPanel();
		}
		initialize(num1);
		initialize(num2);
		setButton(num1, panels, res, 100, 74, 0);
		setButton(num2, panels, res, 480, 74, 1);
		
		
	}
	
	public void initialize(Rooms num1) {
		
		//frame = new JFrame();
		frame.setBounds(100, 100, 800, 750); 					// ���� ��ġ, ���� ��ġ, ���� ����, ���� ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/* �� �κ� �г� */
		JPanel top_panel = new JPanel();
		top_panel.setBackground(new Color(3, 252, 148));		// �� ����
		top_panel.setBounds(0, 0, 784, 100);
		frame.getContentPane().add(top_panel);
		top_panel.setLayout(null);
		
		/* �߰� �κ� �г� */
		//JPanel panel = new JPanel();
		//num1.setPanel(panel);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 100, 784, 400);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		/* �Ʒ� �κ� �г� */
		
		JLabel intro = new JLabel("���� ���� ���� ��Ȳ");
		intro.setFont(new Font("Dialog", Font.PLAIN, 20));
		intro.setBounds(300, 0, 200, 100);						// ��Ʈ�� �ٿ�� ����
		
		top_panel.add(intro);
		/* room1 ~ 4, room1 ~ 4res �߰� (room2 ~ 4, room2 ~ 4res �߰� ����)	 */											
	}
	
	void setButton(Rooms newRoom, JPanel bottom[], JPanel res[], int xpos, int ypos, int flag)
	{			
		/* �̸� ������� */
		JTextField name1 = new JTextField(15);
		
		/* ��ȭ��ȣ ������� */
		JTextField phone1 = new JTextField(15);
		
		/* �Ʒ� �κ� �г� */
		/* �̸� �Է� */
		JPanel inputname = new JPanel();
		num1.setInputName(inputname);
		inputname.setBackground(new Color(51, 255, 255));
		inputname.setBounds(0, 0, 784, 10);
		inputname.add(new JLabel("�̸� : "));
		inputname.add(name1);
		newRoom.setInputName(inputname);
		//num1.setName(name1.toString());
		
		/* �ڵ��� ��ȣ �Է� */
		JPanel phonenum = new JPanel();
		num1.setPhoneNum(phonenum);
		phonenum.setBackground(new Color(51, 255, 255));
		phonenum.setBounds(0, 0, 784, 10);
		phonenum.add(new JLabel("�ڵ��� ��ȣ : "));
		phonenum.add(phone1);
		newRoom.setPhoneNum(phonenum);
		//num1.setPhone(phonenum.toString());
		
		/* ���� �ð� �Է� */
		JPanel inputtime = new JPanel();
		num1.setInputTime(inputtime);
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
		bottom[flag].setBackground(new Color(51, 255, 255));
		bottom[flag].setBounds(0, 500, 784, 200);
		//contentPane.add(bottom_panel);
		bottom[flag].setLayout(new BoxLayout(bottom[flag], BoxLayout.Y_AXIS));	// BoxLayout���� ����
		bottom[flag].add(newRoom.getInputName());
		bottom[flag].add(newRoom.getPhoneNum());
		bottom[flag].add(newRoom.getInputTime());
		bottom[flag].add(status);
		bottom[flag].setVisible(false);							// ��ư Ŭ�� ������ �� �� ����
		//bottom[flag].add(bottom_panel);
		
		//newRoom.setBottomPanel(bottom_panel); 					// bottom_panel �ֱ� (���߿� ������ ���� ����)
		
		// ���� ���� ȭ��
		//JPanel manage_res = new JPanel();
		JButton res_cancel = new JButton("���� ���");
		JButton res_to_start = new JButton("��� ����");
		res[flag].add(res_cancel);								// ���� ��� ��ư �߰�
		res[flag].add(res_to_start);							// ��� ���� ��ư �߰�
		res_cancel.setBounds(50, 50, 784, 10);
		res_to_start.setBounds(50, 80, 784, 10);
		res[flag].setBackground(new Color(51, 255, 255));
		res[flag].setBounds(0, 500, 784, 200);
		contentPane.add(res[flag]);
		//res[flag].setLayout(new BoxLayout(res[flag], BoxLayout.Y_AXIS));	// BoxLayout���� ����
		res[flag].setVisible(false);							// ��ư Ŭ�� ������ �� �� ����
		//bottom[flag].add(manage_res);

	
		JButton room1 = new JButton("�� 1");
		JButton room1res = new JButton("");
		room1res.setVisible(false);
		
		// ��ư �ٿ�� ���� 
		room1.setBounds(xpos, ypos, 200, 100);						
		room1res.setBounds(xpos, ypos, 200, 100);
		panel.add(room1);											
		panel.add(room1res);
		frame.add(bottom[flag]);
		
		/* room1��ư Ŭ�� �� */
		room1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for (int i = 0; i < 2; i++)
				{
					if (flag != i)
					{
						panels[i].setVisible(false);
						res[i].setVisible(false);
					}
				}
				
				bottom[flag].setVisible(true);
				res[flag].setVisible(false);
			}
		});
		
		/* room1res��ư Ŭ�� �� */
		room1res.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < 2; i++)
				{
					if (flag != i)
					{
						panels[i].setVisible(false);
						res[i].setVisible(false);
					}
				}
				
				bottom[flag].setVisible(false);
				res[flag].setVisible(true);
			}
		});
		
		/* ���� ��ư Ŭ�� �� */
		resbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for (int i = 0; i < 2; i++)
				{
					if (flag != i)
					{
						panels[i].setVisible(false);
						res[i].setVisible(false);
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
				//inputtime.removeAll();
				JLabel timeInsert = new JLabel("�ð� : ");
				newRoom.getInputTime().add(timeInsert);
				newRoom.getInputTime().add(temptime);		// �ð� ������Ʈ -> ������ : ��� �ð��� �þ -> ���� �Ϸ�
				num1.setTime(time1);
				
				/*�ٹٲ��� �̿��ϱ� ���� HTML ���*/
				room1res.setText(String.format("<HTML>���� �ð� : %s <br>�̸� : %s<br>��ȭ��ȣ : %s</HTML>",num1.getTime(), num1.getName(), num1.getPhone()));
				bottom[flag].setVisible(false);			// bottom_panel ����ȭ, ���� ���� ����ȭ(�߰� ����)
				
			}
		});
		
		/* ���� ��� ��ư Ŭ�� �� */
		res_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {
				
				for (int i = 0; i < 2; i++)
				{
					if (flag != i)
					{
						panels[i].setVisible(false);
						res[i].setVisible(false);
					}
				}
				
				bottom[flag].setVisible(true);
				res[flag].setVisible(false);
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

	private AccessibleContext getAccessibleContext() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

/*
 �ʿ� ����
 manage_res ȭ�� �� ����
 (���� �߰��� �� �ִ� ����� ����� �� ���) -> Layout ����
 ���� ������ ������Ʈ�� �Ǿ�� �ϴµ� ��ư ������Ʈ�� ���� ����.
 */


/* ���� ������ 

void start(Rooms room)
	{
		JOptionPane Jstart=new JOptionPane();
		String username=Jstart.showInputDialog("�̸��� �Է��ϼ���");
		room.setName(username);
		// System.out.println(room.getName());					// Ȯ�ο�. "//" ���� �� �ֿܼ� �̸� ���.
		
		

	}
*/
