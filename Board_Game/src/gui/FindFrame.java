package gui;

import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import dao.MemberDao;

public class FindFrame extends JFrame{

	private JPanel contentPane;
	private JTextField name,phone;
	private JButton findId,findPw;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindFrame frame = new FindFrame(); 
								
				} catch (Exception e) {
					e.printStackTrace();						
				}
			}
		});

	}
	public FindFrame()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel findname=new JLabel("name");
		findname.setBounds(51, 52, 69, 35);
		contentPane.add(findname);
		
		JLabel findphone=new JLabel("phone");
		findphone.setBounds(51, 103, 69, 35);
		contentPane.add(findphone);
		
		name = new JTextField();
		name.setBounds(187, 52, 176, 35);
		contentPane.add(name);
		name.setColumns(10);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(187, 103, 176, 35);
		contentPane.add(phone);
		
		findId = new JButton("ID 찾기");
		findId.setBounds(100, 154, 100, 29);
		contentPane.add(findId);
		
		findPw=new JButton("PW 찾기");
		findPw.setBounds(240,154,100,29);
		contentPane.add(findPw);
		
		setVisible(true);
		
		//id 찾을때
		findId.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e)
			{
				String username=name.getText();
				String userphone=phone.getText();
				MemberDao dao=MemberDao.getInstance();
				String result=dao.findID(username, userphone);
				JOptionPane.showMessageDialog(null, result);
				dispose();
			}
				});
		
		//pw 찾을때
		findPw.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String username=name.getText();
				String userphone=phone.getText();
				MemberDao dao=MemberDao.getInstance();
				String result=dao.findPW(username, userphone);
				JOptionPane.showMessageDialog(null, result);
				dispose();
			}
				});
	}
	
	
}
