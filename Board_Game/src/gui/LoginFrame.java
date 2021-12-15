package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;

import dao.MemberDao;
import boss_Activity.Main_Activity;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsername; //, tfPassword; //아이디, 비밀번호 입력칸
	private JPasswordField tfPassword;
	private JButton loginBtn, joinBtn, findBtn; //로그인, 회원가입 버튼

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
						LoginFrame frame = new LoginFrame();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("username");
		lblLogin.setBounds(51, 52, 69, 35);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(51, 103, 69, 35);
		contentPane.add(lblPassword);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(187, 52, 176, 35);
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);
		
		joinBtn = new JButton("회원가입");
		joinBtn.setBounds(340, 154, 100, 29);
		contentPane.add(joinBtn);
		
		loginBtn = new JButton("로그인");
		loginBtn.setBounds(200, 154, 100, 29);
		contentPane.add(loginBtn);
		
		findBtn = new JButton("ID/PW 찾기");
		findBtn.setBounds(60, 154, 100, 29);
		contentPane.add(findBtn);
		
		tfPassword = new JPasswordField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(187, 103, 176, 35);
		contentPane.add(tfPassword);
		
		setVisible(true);
		
		//id pw 찾기 눌렀을때
		findBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e)
			{
				FindFrame frame=new FindFrame();
			}
		});
		//회원가입 눌렀을때
		joinBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JoinFrame frame = new JoinFrame();
			}
		});
		
		//로그인 눌렀을때
		loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = tfUsername.getText();
				String password = tfPassword.getText();
				MemberDao dao = MemberDao.getInstance();
				int result = dao.findByUsernameAndPassword(username, password);
				if(result == 1) 
				{
					//로그인 성공 메시지
					JOptionPane.showMessageDialog(null, "로그인 성공");
					//Main_Activity.main(null); //방 선택 화면으로 넘어감
					//회원 정보 리스트 화면 이동과 동시에 username 세션값으로 넘김.
					//MemberListFrame mlf = new MemberListFrame(username);
					AfterLoginFrame alf=new AfterLoginFrame(username);
					dispose(); //현재 화면 종료
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "로그인 실패");
				}
				
			}
		});
	}
}


