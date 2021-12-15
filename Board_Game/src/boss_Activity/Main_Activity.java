/*
 VER1
 추가사항 : 
 방 추가 기능 삭제
 방 버튼 추가
 
 VER2
 추가사항 : 
 예약시 나오는 버튼 기능 추가
 */

package boss_Activity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.accessibility.AccessibleContext;
import rooms.Rooms;
import java.text.SimpleDateFormat;
import java.util.Date;
//import caidan.yaotianshui;

public class Main_Activity extends JFrame {
	public JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JPanel[] panels = new JPanel [4];
	JPanel[] res = new JPanel [4];
	JPanel[] foodPanels = new JPanel [4];

	//JPanel bottom = new JPanel();
	//Container contentPane = frame.getContentPane();
	
	//static Main_Activity window = new Main_Activity();
	Rooms num1 = new Rooms();
	Rooms num2 = new Rooms();
	Rooms num3 = new Rooms();
	Rooms num4 = new Rooms();
	
	static Rooms[] nums = new Rooms[4];
	String user = "";
	
	/*오픈 소스 참조 내용 (13 ~ 25)*/
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
	
	Main_Activity() {
		
		Make_Room mr = new Make_Room();
		
		nums[0] = num1;
		nums[1] = num2;
		nums[2] = num3;
		nums[3] = num4;
		
		for (int i = 0; i < 4; i++)
		{
			panels[i] = new JPanel();
			res[i] = new JPanel();
		}
		
		for (int i = 0; i < 4; i++)
		{
			foodPanels[i] = new JPanel();
			foodPanels[i].setBounds(0, 500, 784, 200);
			foodPanels[i].setBackground(new Color(255, 255, 0));
			foodPanels[i].setLayout(null);
			frame.add(foodPanels[i]); 				// foodPanels
			foodPanels[i].setVisible(false);
		}
		
		initialize(num1);
		initialize(num2);
			
		// 방 이미지 생성
		ImageIcon icon1 = new ImageIcon("src/images/rooms/room1.jpg");
		Image img1 = icon1.getImage();
		Image changeImg1 = img1.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
		ImageIcon changeIcon1 = new ImageIcon(changeImg1);
		
		ImageIcon icon2 = new ImageIcon("src/images/rooms/room2.jpg");
		Image img2 = icon2.getImage();
		Image changeImg2 = img2.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
		ImageIcon changeIcon2 = new ImageIcon(changeImg2);
		
		ImageIcon icon3 = new ImageIcon("src/images/rooms/room3.jpg");
		Image img3 = icon3.getImage();
		Image changeImg3 = img3.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
		ImageIcon changeIcon3 = new ImageIcon(changeImg3);
		
		ImageIcon icon4 = new ImageIcon("src/images/rooms/room4.jpg");
		Image img4 = icon4.getImage();
		Image changeImg4 = img4.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
		ImageIcon changeIcon4 = new ImageIcon(changeImg4);
		
		mr.setButton(changeIcon1, this, num1, 100, 74, 0);
		mr.setButton(changeIcon2, this, num2, 480, 74, 1);
		mr.setButton(changeIcon3, this, num3, 100, 255, 2);
		mr.setButton(changeIcon4, this, num4, 480, 255, 3);
	}

	public void initialize(Rooms num1) {
		
		//frame = new JFrame();
		frame.setBounds(100, 100, 800, 750); 					// 가로 위치, 세로 위치, 가로 길이, 세로 길이
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/* 윗 부분 패널 */
		JPanel top_panel = new JPanel();
		top_panel.setBackground(new Color(3, 252, 148));		// 색 구분
		top_panel.setBounds(0, 0, 784, 100);
		frame.getContentPane().add(top_panel);
		top_panel.setLayout(null);
		
		/* 중간 부분 패널 */
		// 가운데 초기 패널
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 100, 784, 400);
		// panel의 레이아웃 설정 안함
		panel.setLayout(null);
		frame.getContentPane().add(panel);		
		
		JLabel intro = new JLabel("보드 게임 예약 현황");
		intro.setFont(new Font("Dialog", Font.PLAIN, 20));
		intro.setBounds(300, 0, 200, 100);						// 인트로 바운드 설정
		
		top_panel.add(intro);
		/* room1 ~ 4, room1 ~ 4res 추가 (room2 ~ 4, room2 ~ 4res 추가 예정)	 */											
	}
	
}

/*
 필요 사항
 manage_res 화면 상세 설정
 (방을 추가할 수 있는 기능을 만들게 될 경우) -> Layout 변경
 누를 때마다 업데이트가 되어야 하는데 버튼 업데이트가 되지 않음.
 */


/* 더미 데이터 

*/
