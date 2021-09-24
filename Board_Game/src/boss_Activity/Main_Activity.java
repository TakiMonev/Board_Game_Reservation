/*
 추가사항 : 방 추가 기능 삭제
 */

package boss_Activity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import rooms.Rooms;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main_Activity {
	private JFrame frame;
	
	Rooms num1, num2, num3, num4;
	String user = "";
	int start_time;
	int end_time;
	
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
	
	public Main_Activity() {
		initialize();
	}
	
	public void initialize() {
		num1 = new Rooms();										// num1 생성
		frame = new JFrame();
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
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 100, 784, 400);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		/* 아랫 부분 패널 */
		/* 이름 입력 */
		JPanel inputname = new JPanel();
		inputname.setBackground(new Color(51, 255, 255));
		inputname.setBounds(0, 0, 784, 10);
		inputname.add(new JLabel("이름 : "));
		inputname.add(new JTextField(15));
		
		/* 이름 입력 */
		JPanel phonenum = new JPanel();
		phonenum.setBackground(new Color(51, 255, 255));
		phonenum.setBounds(0, 0, 784, 10);
		phonenum.add(new JLabel("핸드폰 번호 : "));
		phonenum.add(new JTextField(15));
		
		/* 현재 시각 입력 */
		JPanel inputtime = new JPanel();
		inputtime.setBackground(new Color(51, 255, 255));
		inputtime.setBounds(0, 0, 784, 10);
		inputtime.add(new JLabel("시간 : "));
		SimpleDateFormat timeformat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm");
		Date time = new Date();
		String time1 = timeformat.format(time);
		inputtime.add(new JLabel(time1));
		
		/* 예약 / 시작 선택 */
		JPanel status = new JPanel();
		status.setBackground(new Color(51, 255, 255));
		status.setBounds(0, 0, 784, 10);
		status.setLayout(new FlowLayout()); 					// new 꼭 붙일 것!
		JButton resbtn = new JButton("예약");
		JButton startbtn = new JButton("시작");
		status.add(resbtn);
		status.add(startbtn);
		
		JPanel bottom_panel = new JPanel();
		bottom_panel.setBackground(new Color(51, 255, 255));
		bottom_panel.setBounds(0, 500, 784, 200);
		frame.getContentPane().add(bottom_panel);
		bottom_panel.setLayout(new BoxLayout(bottom_panel, BoxLayout.Y_AXIS));	// BoxLayout으로 설정
		bottom_panel.add(inputname);
		bottom_panel.add(phonenum);
		bottom_panel.add(inputtime);
		bottom_panel.add(status);
		bottom_panel.setVisible(false);							// 버튼 클릭 전까지 볼 수 없음
		
		JLabel intro = new JLabel("보드 게임 예약 현황");
		
		/* 방 1 버튼 클릭 시 */
		JButton room1 = new JButton("방 1");
		room1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bottom_panel.setVisible(true);
			}
		});
		
		/* 에약 버튼 클릭 시 */
		resbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		/* 시작 버튼 클릭 시 */
		startbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		intro.setFont(new Font("Dialog", Font.PLAIN, 20));
		intro.setBounds(300, 0, 200, 100);						// 인트로 바운드 설정
		room1.setBounds(100, 74, 200, 100);						// 버튼 바운드 설정
		top_panel.add(intro);
		panel.add(room1);										// room1 추가
		
	}
	
	
	
}

/* 더미 데이터 
void start(Rooms room)
	{
		JOptionPane Jstart=new JOptionPane();
		String username=Jstart.showInputDialog("이름을 입력하세요");
		room.setName(username);
		// System.out.println(room.getName());					// 확인용. "//" 없앨 시 콘솔에 이름 출력.
		
		

	}
*/
