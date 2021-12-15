package gui;

import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import boss_Activity.Main_Activity;

public class AfterLoginFrame extends JFrame{
	
	private JPanel contentPane;
	private JButton listBtn, reserveBtn; //회원정보 리스트 버튼, 예약버튼
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfterLoginFrame frame = new AfterLoginFrame(); 
								
				} catch (Exception e) {
					e.printStackTrace();						
				}
			}
		});
	}
	public AfterLoginFrame()
	{
		this(null);
	}
	
	public AfterLoginFrame(String username)
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		listBtn = new JButton("회원정보");  ///회원정보 버튼
		listBtn.setBounds(180, 154, 106, 29);
		contentPane.add(listBtn);
		
		
		reserveBtn = new JButton("예약하기"); //예약버튼
		reserveBtn.setBounds(180, 74, 106, 29);
		contentPane.add(reserveBtn);
		
		setVisible(true);
		
		reserveBtn.addActionListener(new ActionListener() { //예약하기 눌렀을때
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Main_Activity.main(null);
			}
		});
		
		listBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				MemberListFrame mlf= new MemberListFrame(username);
			}
				});
	}
}
