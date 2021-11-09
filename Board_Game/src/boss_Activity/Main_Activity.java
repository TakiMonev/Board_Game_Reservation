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
		
		num1 = new Rooms();										// num1 생성
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
		//JPanel panel = new JPanel();
		//num1.setPanel(panel);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 100, 784, 400);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		/* 아랫 부분 패널 */
		
		JLabel intro = new JLabel("보드 게임 예약 현황");
		intro.setFont(new Font("Dialog", Font.PLAIN, 20));
		intro.setBounds(300, 0, 200, 100);						// 인트로 바운드 설정
		
		top_panel.add(intro);
		/* room1 ~ 4, room1 ~ 4res 추가 (room2 ~ 4, room2 ~ 4res 추가 예정)	 */											
	}
	
	void setButton(Rooms newRoom, JPanel bottom[], JPanel res[], int xpos, int ypos, int flag)
	{			
		/* 이름 저장공간 */
		JTextField name1 = new JTextField(15);
		
		/* 전화번호 저장공간 */
		JTextField phone1 = new JTextField(15);
		
		/* 아랫 부분 패널 */
		/* 이름 입력 */
		JPanel inputname = new JPanel();
		num1.setInputName(inputname);
		inputname.setBackground(new Color(51, 255, 255));
		inputname.setBounds(0, 0, 784, 10);
		inputname.add(new JLabel("이름 : "));
		inputname.add(name1);
		newRoom.setInputName(inputname);
		//num1.setName(name1.toString());
		
		/* 핸드폰 번호 입력 */
		JPanel phonenum = new JPanel();
		num1.setPhoneNum(phonenum);
		phonenum.setBackground(new Color(51, 255, 255));
		phonenum.setBounds(0, 0, 784, 10);
		phonenum.add(new JLabel("핸드폰 번호 : "));
		phonenum.add(phone1);
		newRoom.setPhoneNum(phonenum);
		//num1.setPhone(phonenum.toString());
		
		/* 현재 시각 입력 */
		JPanel inputtime = new JPanel();
		num1.setInputTime(inputtime);
		inputtime.setBackground(new Color(51, 255, 255));
		inputtime.setBounds(0, 0, 784, 10);
		JLabel timeInsert = new JLabel("시간 : ");
		inputtime.add(timeInsert);
		SimpleDateFormat timeformat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm");
		Date time = new Date();
		String time1 = timeformat.format(time);
		JLabel temptime = new JLabel(time1);		// 임시 시간
		inputtime.add(temptime);
		newRoom.setInputTime(inputtime);
		
		// 예약 / 시작 선택
		JPanel status = new JPanel();
		status.setBackground(new Color(51, 255, 255));
		status.setBounds(0, 0, 784, 10);
		status.setLayout(new FlowLayout()); 					// new 꼭 붙일 것!
		JButton resbtn = new JButton("예약");
		JButton startbtn = new JButton("시작");
		status.add(resbtn);
		status.add(startbtn);
		
		//JPanel bottom_panel = new JPanel();
		bottom[flag].setBackground(new Color(51, 255, 255));
		bottom[flag].setBounds(0, 500, 784, 200);
		//contentPane.add(bottom_panel);
		bottom[flag].setLayout(new BoxLayout(bottom[flag], BoxLayout.Y_AXIS));	// BoxLayout으로 설정
		bottom[flag].add(newRoom.getInputName());
		bottom[flag].add(newRoom.getPhoneNum());
		bottom[flag].add(newRoom.getInputTime());
		bottom[flag].add(status);
		bottom[flag].setVisible(false);							// 버튼 클릭 전까지 볼 수 없음
		//bottom[flag].add(bottom_panel);
		
		//newRoom.setBottomPanel(bottom_panel); 					// bottom_panel 넣기 (나중에 삭제될 수도 있음)
		
		// 예약 관리 화면
		//JPanel manage_res = new JPanel();
		JButton res_cancel = new JButton("예약 취소");
		JButton res_to_start = new JButton("사용 시작");
		res[flag].add(res_cancel);								// 예약 취소 버튼 추가
		res[flag].add(res_to_start);							// 사용 시작 버튼 추가
		res_cancel.setBounds(50, 50, 784, 10);
		res_to_start.setBounds(50, 80, 784, 10);
		res[flag].setBackground(new Color(51, 255, 255));
		res[flag].setBounds(0, 500, 784, 200);
		contentPane.add(res[flag]);
		//res[flag].setLayout(new BoxLayout(res[flag], BoxLayout.Y_AXIS));	// BoxLayout으로 설정
		res[flag].setVisible(false);							// 버튼 클릭 전까지 볼 수 없음
		//bottom[flag].add(manage_res);

	
		JButton room1 = new JButton("방 1");
		JButton room1res = new JButton("");
		room1res.setVisible(false);
		
		// 버튼 바운드 설정 
		room1.setBounds(xpos, ypos, 200, 100);						
		room1res.setBounds(xpos, ypos, 200, 100);
		panel.add(room1);											
		panel.add(room1res);
		frame.add(bottom[flag]);
		
		/* room1버튼 클릭 시 */
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
		
		/* room1res버튼 클릭 시 */
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
		
		/* 에약 버튼 클릭 시 */
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
				
				room1.setVisible(false);				// room1 투명화
				room1res.setVisible(true);				// room1res 가시화
				newRoom.setName(name1.getText());
				newRoom.setPhone(phone1.getText());
				Date timeupdate = new Date();
				SimpleDateFormat timeformat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm");
				String time1 = timeformat.format(timeupdate);
				JLabel temptime = new JLabel(time1);
				//inputtime.removeAll();
				JLabel timeInsert = new JLabel("시간 : ");
				newRoom.getInputTime().add(timeInsert);
				newRoom.getInputTime().add(temptime);		// 시간 업데이트 -> 문제점 : 계속 시간이 늘어남 -> 수정 완료
				num1.setTime(time1);
				
				/*줄바꿈을 이용하기 위해 HTML 사용*/
				room1res.setText(String.format("<HTML>예약 시간 : %s <br>이름 : %s<br>전화번호 : %s</HTML>",num1.getTime(), num1.getName(), num1.getPhone()));
				bottom[flag].setVisible(false);			// bottom_panel 투명화, 예약 관리 가시화(추가 예정)
				
			}
		});
		
		/* 예약 취소 버튼 클릭 시 */
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
		
		/* 시작 버튼 클릭 시 */
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
 필요 사항
 manage_res 화면 상세 설정
 (방을 추가할 수 있는 기능을 만들게 될 경우) -> Layout 변경
 누를 때마다 업데이트가 되어야 하는데 버튼 업데이트가 되지 않음.
 */


/* 더미 데이터 

void start(Rooms room)
	{
		JOptionPane Jstart=new JOptionPane();
		String username=Jstart.showInputDialog("이름을 입력하세요");
		room.setName(username);
		// System.out.println(room.getName());					// 확인용. "//" 없앨 시 콘솔에 이름 출력.
		
		

	}
*/
