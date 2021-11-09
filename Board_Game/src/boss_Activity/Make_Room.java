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
		/* 이름 저장공간 */
		JTextField name1 = new JTextField(15);
		
		/* 전화번호 저장공간 */
		JTextField phone1 = new JTextField(15);
		
		/* 아랫 부분 패널 */
		/* 이름 입력 */
		JPanel inputname = new JPanel();
		newRoom.setInputName(inputname);
		inputname.setBackground(new Color(51, 255, 255));
		inputname.setBounds(0, 0, 784, 10);
		inputname.add(new JLabel("이름 : "));
		inputname.add(name1);
		ma.num1.setInputName(inputname);
		//num1.setName(name1.toString());
		
		/* 핸드폰 번호 입력 */
		JPanel phonenum = new JPanel();
		newRoom.setPhoneNum(phonenum);
		phonenum.setBackground(new Color(51, 255, 255));
		phonenum.setBounds(0, 0, 784, 10);
		phonenum.add(new JLabel("핸드폰 번호 : "));
		phonenum.add(phone1);
		newRoom.setPhoneNum(phonenum);
		//num1.setPhone(phonenum.toString());
		
		/* 현재 시각 입력 */
		JPanel inputtime = new JPanel();
		newRoom.setInputTime(inputtime);
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
		ma.panels[flag].setBackground(new Color(51, 255, 255));
		ma.panels[flag].setBounds(0, 500, 784, 200);
		//contentPane.add(bottom_panel);
		ma.panels[flag].setLayout(new BoxLayout(ma.panels[flag], BoxLayout.Y_AXIS));	// BoxLayout으로 설정
		ma.panels[flag].add(newRoom.getInputName());
		ma.panels[flag].add(newRoom.getPhoneNum());
		ma.panels[flag].add(newRoom.getInputTime());
		ma.panels[flag].add(status);
		ma.panels[flag].setVisible(false);							// 버튼 클릭 전까지 볼 수 없음
		//bottom[flag].add(bottom_panel);
		
		//newRoom.setBottomPanel(bottom_panel); 					// bottom_panel 넣기 (나중에 삭제될 수도 있음)
		
		// 예약 관리 화면
		//JPanel manage_res = new JPanel();
		JButton res_cancel = new JButton("예약 취소");
		JButton res_to_start = new JButton("사용 시작");
		ma.res[flag].add(res_cancel);								// 예약 취소 버튼 추가
		ma.res[flag].add(res_to_start);							// 사용 시작 버튼 추가
		res_cancel.setBounds(50, 50, 784, 10);
		res_to_start.setBounds(50, 80, 784, 10);
		ma.res[flag].setBackground(new Color(51, 255, 255));
		ma.res[flag].setBounds(0, 500, 784, 200);
		ma.frame.getContentPane().add(ma.res[flag]);
		//res[flag].setLayout(new BoxLayout(res[flag], BoxLayout.Y_AXIS));	// BoxLayout으로 설정
		ma.res[flag].setVisible(false);							// 버튼 클릭 전까지 볼 수 없음
		//bottom[flag].add(manage_res);

	
		JButton room1 = new JButton("방 " + (flag + 1));
		JButton room1res = new JButton("");
		room1res.setVisible(false);
		
		// 버튼 바운드 설정 
		room1.setBounds(xpos, ypos, 200, 100);						
		room1res.setBounds(xpos, ypos, 200, 100);
		ma.panel.add(room1);											
		ma.panel.add(room1res);
		ma.frame.add(ma.panels[flag]);
		
		/* room1버튼 클릭 시 */
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
		
		/* room1res버튼 클릭 시 */
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
		
		/* 에약 버튼 클릭 시 */
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
				
				room1.setVisible(false);				// room1 투명화
				room1res.setVisible(true);				// room1res 가시화
				newRoom.setName(name1.getText());
				newRoom.setPhone(phone1.getText());
				Date timeupdate = new Date();
				SimpleDateFormat timeformat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm");
				String time1 = timeformat.format(timeupdate);
				JLabel temptime = new JLabel(time1);
				newRoom.getInputTime().removeAll();			// 시간 초기화
				JLabel timeInsert = new JLabel("시간 : ");
				newRoom.getInputTime().add(timeInsert);
				newRoom.getInputTime().add(temptime);		// 시간 업데이트 -> 문제점 : 계속 시간이 늘어남 -> 수정 완료
				newRoom.setTime(time1);
				
				/*줄바꿈을 이용하기 위해 HTML 사용*/
				room1res.setText(String.format("<HTML>예약 시간 : %s <br>이름 : %s<br>전화번호 : %s</HTML>",newRoom.getTime(), newRoom.getName(), newRoom.getPhone()));
				ma.panels[flag].setVisible(false);			// bottom_panel 투명화, 예약 관리 가시화(추가 예정)
				
			}
		});
		
		/* 예약 취소 버튼 클릭 시 */
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
		
		/* 시작 버튼 클릭 시 */
		startbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
}
