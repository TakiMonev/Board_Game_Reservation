package boss_Activity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.accessibility.AccessibleContext;
import rooms.Rooms;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Make_Room {
	/*
	JButton roomGlobal = new JButton();
	JButton roomresGlobal = new JButton();
	JButton resbtnGlobal = new JButton();
	JButton startbtnGlobal = new JButton();
	JButton res_cancelGlobal = new JButton();
	JButton res_to_startGlobal = new JButton();
	*/
	
	void setButton(Main_Activity ma, Rooms newRoom, int xpos, int ypos, int flag)
	{	
		// 이름 저장공간
		JTextField name1 = new JTextField(15);
		
		// 전화번호 저장공간
		JTextField phone1 = new JTextField(15);

		// 아랫 부분 패널
		// 이름 입력
		JPanel inputname = new JPanel();
		newRoom.setInputName(inputname);
		inputname.setBackground(new Color(51, 255, 255));
		inputname.setBounds(0, 0, 784, 10);
		inputname.add(new JLabel("이름 : "));
		inputname.add(name1);
		ma.num1.setInputName(inputname);
		//num1.setName(name1.toString());
		
		// 핸드폰 번호 입력
		JPanel phonenum = new JPanel();
		newRoom.setPhoneNum(phonenum);
		phonenum.setBackground(new Color(51, 255, 255));
		phonenum.setBounds(0, 0, 784, 10);
		phonenum.add(new JLabel("핸드폰 번호 : "));
		phonenum.add(phone1);
		newRoom.setPhoneNum(phonenum);
		//num1.setPhone(phonenum.toString());
		
		// 현재 시각 입력
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
		//resbtnGlobal = resbtn;
		JButton startbtn = new JButton("시작");
		//startbtnGlobal = startbtn;
		status.add(resbtn);
		status.add(startbtn);
		
		//panels[flag] 정보 입력
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
		//res_cancelGlobal = res_cancel;
		JButton res_to_start = new JButton("사용 시작");
		//res_to_startGlobal = res_to_start;
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

		// 첨수꺼 메뉴 부분
		//masetBackground(new Color(51, 255, 255));
		//ma.foodPanels[flag].setBounds(0, 500, 784, 200);
		//ma.foodPanels[flag].setVisible(false);
		//ma.frame.getContentPane().add(ma.foodPanels[flag]);		// 첨수꺼 frame에 추가
		
		JButton room = new JButton("방 " + (flag + 1));
		//roomGlobal = room;
		JButton roomres = new JButton("");
		//roomresGlobal = roomres;
		roomres.setVisible(false);
		
		// 버튼 바운드 설정 
		room.setBounds(xpos, ypos, 200, 100);						
		roomres.setBounds(xpos, ypos, 200, 100);
		ma.panel.add(room);											
		ma.panel.add(roomres);
		ma.frame.add(ma.panels[flag]);
		
		
		//foodPanels
		Button_Actioned ba = new Button_Actioned();		// ba 선언
		ba.getFoodPanel(ma, this, flag);
		ma.frame.add(ma.foodPanels[flag]);
		
		// room버튼 클릭 시 
		room.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
				
				for (int i = 0; i < ma.panels.length; i++)
				{
					if (flag != i)
					{
						ma.panels[i].setVisible(false);
						ma.res[i].setVisible(false);
						ma.foodPanels[i].setVisible(false);		// foodPanels invisible
					}
				}
				
				ma.panels[flag].setVisible(true);
				ma.res[flag].setVisible(false);
				ma.foodPanels[flag].setVisible(false);		// foodPanels invisible
			}
		});
		
		// Roomers버튼 클릭 시
		roomres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < ma.panels.length; i++)
				{
					if (flag != i)
					{
						ma.panels[i].setVisible(false);
						ma.res[i].setVisible(false);
						ma.foodPanels[i].setVisible(false);		// foodPanels invisible
					}
				}
				
				ma.panels[flag].setVisible(false);
				ma.res[flag].setVisible(true);
				ma.foodPanels[flag].setVisible(false);		// foodPanels invisible
			}
		});
		
		// 에약 버튼 클릭 시 
		resbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for (int i = 0; i < ma.panels.length; i++)
				{
					if (flag != i)
					{
						ma.panels[i].setVisible(false);
						ma.res[i].setVisible(false);
						ma.foodPanels[i].setVisible(false);		// foodPanels invisible
					}
				}
				
				room.setVisible(false);				// room 투명화
				roomres.setVisible(true);				// roomres 가시화
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
				
				// 줄바꿈을 이용하기 위해 HTML 사용
				roomres.setText(String.format("<HTML>예약 시간 : %s <br>이름 : %s<br>전화번호 : %s</HTML>",newRoom.getTime(), newRoom.getName(), newRoom.getPhone()));
				ma.panels[flag].setVisible(false);			// bottom_panel 투명화, 예약 관리 가시화(추가 예정)
				ma.foodPanels[flag].setVisible(false);		// foodPanels invisible
				
			}
		});
		
		// 예약 취소 버튼 클릭 시
		res_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {
				
				for (int i = 0; i < ma.panels.length; i++)
				{
					if (flag != i)
					{
						ma.panels[i].setVisible(false);
						ma.res[i].setVisible(false);
						ma.foodPanels[i].setVisible(false);		// foodPanels invisible
					}
				}
				
				ma.panels[flag].setVisible(false);
				ma.res[flag].setVisible(false);
				room.setVisible(true);
				roomres.setVisible(false);
				ma.foodPanels[flag].setVisible(false);		// foodPanels invisible
			}
		});

		// 시작 버튼 클릭 시
		startbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < ma.foodPanels.length; i++)
				{
					if (flag != i)
					{
						ma.panels[i].setVisible(false);
						ma.res[i].setVisible(false);
						ma.foodPanels[i].setVisible(false);		// foodPanels invisible
					}
				}
				
				room.setVisible(false);				// room 투명화
				roomres.setVisible(true);			
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
				
				// 줄바꿈을 이용하기 위해 HTML 사용
				roomres.setText(String.format("<HTML>예약 시간 : %s <br>이름 : %s<br>전화번호 : %s</HTML>",newRoom.getTime(), newRoom.getName(), newRoom.getPhone()));
				
				ma.panels[flag].setVisible(false);
				ma.res[flag].setVisible(false);
				ma.foodPanels[flag].setVisible(true);
			}
		});
		
		res_to_start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < ma.foodPanels.length; i++)
				{
					if (flag != i)
					{
						ma.panels[i].setVisible(false);
						ma.res[i].setVisible(false);
						ma.foodPanels[i].setVisible(false);		// foodPanels invisible
					}
				}
				
				room.setVisible(false);				// room 투명화
				roomres.setVisible(true);			
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
				
				// 줄바꿈을 이용하기 위해 HTML 사용
				roomres.setText(String.format("<HTML>예약 시간 : %s <br>이름 : %s<br>전화번호 : %s</HTML>",newRoom.getTime(), newRoom.getName(), newRoom.getPhone()));
				
				ma.panels[flag].setVisible(false);
				ma.res[flag].setVisible(false);
				ma.foodPanels[flag].setVisible(true);
			}
		});
		
		// 확인 버튼 클릭 시
		ba.confirm.addActionListener(new ActionListener() {
			private JLabel JLabel;

			public void actionPerformed(ActionEvent e) {
				System.out.println(newRoom.getTime());
				Date timeupdate_end = new Date();
				SimpleDateFormat timeformat_end = new SimpleDateFormat ( "yyyy-MM-dd HH:mm");
				String time_end = timeformat_end.format(timeupdate_end);
				
				int starttime = ((newRoom.getTime().charAt(10) * 10) + newRoom.getTime().charAt(11)) * 60 
						+ newRoom.getTime().charAt(14) * 10 + newRoom.getTime().charAt(15);
				int endtime = ((time_end.charAt(10) * 10) + time_end.charAt(11)) * 60 
						+ time_end.charAt(14) * 10 + time_end.charAt(15);
				
				int finalPrice = (endtime - starttime) * 100;
			
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
				System.out.println(finalPrice);
			}
		});
		
	}

}
