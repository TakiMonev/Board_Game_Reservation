package boss_Activity;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import rooms.Rooms;
import rooms.Shuju;
import rooms.Shuju2;
import javax.swing.ImageIcon;
import java.awt.Image;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Button_Actioned {

	Shuju[] shu = new Shuju [4];
	Shuju2[] shu2 = new Shuju2 [4];
	
	JButton btn1 = new JButton("음료수");
	JButton btn2 = new JButton("음식");
	JButton confirm = new JButton("확인");
	JButton cancel = new JButton("취소");
	
	public void getFoodPanel(Main_Activity ma, Make_Room mr, int flag )
	{	
		for (int i = 0; i < 4; i++)
		{
			shu[i] = new Shuju();
		}
		for (int j = 0; j < 4; j++)
		{
			shu2[j] = new Shuju2();
		}
		
		Button btn1 = new Button("음료수");
		Button btn2 = new Button("음식");
		JDialog dialog = new JDialog(ma,"My dialog");
		 Label lab1 = new Label("선택하세요");
		 JCheckBox jcb1 = new JCheckBox();
		 jcb1.add(new JLabel("     에스프레소1500"));
		 JCheckBox jcb2 = new JCheckBox();
		 jcb2.add(new JLabel("     아메리카노2000"));
		  JCheckBox cb3 = new JCheckBox();
		  cb3.add(new JLabel("     더치1500"));
		  JCheckBox cb4 = new JCheckBox("카페라떼2500");
		
		  Button btn3 = new Button("확인");
		  Container ct2 = ma.getContentPane();
		  Button btn19= new Button("계산");
		  Label lab13=new Label("총 가격:");
		  
		  
		 
		  JDialog dialog2 = new JDialog(ma,"My dialog2");
		  Label lab2 = new Label("선택하세요");
		  JCheckBox cb12 = new JCheckBox("애플타르트1500");
		  JCheckBox cb22 = new JCheckBox("쿠키슈2000");
		  JCheckBox cb32 = new JCheckBox("스틱케익1500");
		  JCheckBox cb42 = new JCheckBox("치즈타르트2500");

		  Button btn4 = new Button("확인");
		  
		  Container ct = ma.getContentPane();
		  Button btn9= new Button("계산");
		  Label lab3=new Label("총 가격:");
		  
		
		  ImageIcon source_esspresso = new ImageIcon("src/images/esspresso.jpg"); 
		  Image ess = source_esspresso.getImage(); //imageicon을 image로 변환
		  Image change_ess=ess.getScaledInstance(100,100,Image.SCALE_SMOOTH);  ////에스프레소
		  ImageIcon change_esspresso=new ImageIcon(change_ess);
		  JLabel lbl_ess=new JLabel();
			 
		  ImageIcon source_americano = new ImageIcon("src/images/americano.jpg"); 
		  Image ame = source_americano.getImage(); //imageicon을 image로 변환
		  Image change_ame=ame.getScaledInstance(100,100,Image.SCALE_SMOOTH);
		  ImageIcon change_americano=new ImageIcon(change_ame);
		  JLabel lbl_ame=new JLabel();
		  
		  ImageIcon source_dutch = new ImageIcon("src/images/dutch.jpg"); 
		  Image dutch = source_dutch.getImage(); //imageicon을 image로 변환
		  Image change_dut=dutch.getScaledInstance(100,100,Image.SCALE_SMOOTH);
		  ImageIcon change_dutch=new ImageIcon(change_dut);
		  JLabel lbl_dutch=new JLabel();
		  
		  ImageIcon source_cafelatte = new ImageIcon("src/images/cafelatte.jpg"); 
		  Image cafe = source_cafelatte.getImage(); //imageicon을 image로 변환
		  Image change_cafe=cafe.getScaledInstance(100,100,Image.SCALE_SMOOTH);
		  ImageIcon change_cafelatte=new ImageIcon(change_cafe);
		  JLabel lbl_cafelatte=new JLabel();
		  
		  ImageIcon source_apple = new ImageIcon("src/images/appletarrt.jpg"); 
		  Image apple = source_apple.getImage(); //imageicon을 image로 변환
		  Image change_apple=apple.getScaledInstance(100,100,Image.SCALE_SMOOTH);
		  ImageIcon change_appletarrt=new ImageIcon(change_apple);
		  JLabel lbl_appletarrt=new JLabel();
		  
		  ImageIcon source_cookie = new ImageIcon("src/images/cookiesu.png"); 
		  Image cookie = source_cookie.getImage(); //imageicon을 image로 변환
		  Image change_cookie=cookie.getScaledInstance(100,100,Image.SCALE_SMOOTH);
		  ImageIcon change_cookiesu=new ImageIcon(change_cookie);
		  JLabel lbl_cookiesu=new JLabel();
		  
		  ImageIcon source_stick = new ImageIcon("src/images/stickcake.jpg"); 
		  Image stick = source_stick.getImage(); //imageicon을 image로 변환
		  Image change_stick=stick.getScaledInstance(100,100,Image.SCALE_SMOOTH);
		  ImageIcon change_stickcake=new ImageIcon(change_stick);
		  JLabel lbl_stickcake=new JLabel();
		  
		  ImageIcon source_cheese = new ImageIcon("src/images/cheesetarrt.jpg"); 
		  Image cheese = source_cheese.getImage(); //imageicon을 image로 변환
		  Image change_cheese=cheese.getScaledInstance(100,100,Image.SCALE_SMOOTH);
		  ImageIcon change_cheesetarrt=new ImageIcon(change_cheese);
		  JLabel lbl_cheesetarrt=new JLabel();
		  
		class MyListener implements ActionListener{
	       	  public void actionPerformed(ActionEvent e) {
	       		  Button btn = (Button) e.getSource();
	       		 
	       		  if(btn==btn2)
	      			{
	      			  dialog2.setLayout(null);
	      			  dialog2.setSize(700,600);
	      			  lab1.setBounds(300,50,150,20);
	      			  dialog2.add(lab1);
	      			
	      			  btn4.setBounds(550,500,70,30);
	      			  dialog2.add(btn4);
	      			 
	      			  cb12.setBounds(200,100,150,50);
	      			  dialog2.add(cb12);
	        		  cb22.setBounds(380,100,150,50);
	        		  dialog2.add(cb22);
	        		  cb32.setBounds(200,200,150,50);
	      			  dialog2.add(cb32);
	      			  cb42.setBounds(380,200,150,50);
	     			  dialog2.add(cb42);
	     			
	     			 // dialog2.setDefaultCloseOperation(ma.EXIT_ON_CLOSE);
	        		 
	        		  
	        		//fff  
		     			 lab13.setBounds(300,450,150,20);
		      			  dialog2.add(lab13);
	        		  
	        		  btn19.setBounds(500,450,100,20);
	      			  dialog2.add(btn19);
	      			  //dialog.setDefaultCloseOperation(ma.EXIT_ON_CLOSE);
	      	 		  dialog2.setVisible(true);
	      			  //kkkk  
	      	 		  
	      	 		  lbl_appletarrt.setIcon(change_appletarrt);
	    			  lbl_appletarrt.setBounds(70,80,100,100);
	    			  lbl_appletarrt.setHorizontalAlignment(JLabel.CENTER);
	    			  dialog2.getContentPane().add(lbl_appletarrt);
	    			 
	    			  lbl_cookiesu.setIcon(change_cookiesu);
	    			  lbl_cookiesu.setBounds(530,80,100,100);
	    			  lbl_cookiesu.setHorizontalAlignment(JLabel.CENTER);
	    			  dialog2.getContentPane().add(lbl_cookiesu);
		    			  
	    			  lbl_stickcake.setIcon(change_stickcake);
	    			  lbl_stickcake.setBounds(70,200,100,100);
	    			  lbl_stickcake.setHorizontalAlignment(JLabel.CENTER);
	    			  dialog2.getContentPane().add(lbl_stickcake);
	    			  
	    			  lbl_cheesetarrt.setIcon(change_cheesetarrt);
	    			  lbl_cheesetarrt.setBounds(530,200,100,100);
	    			  lbl_cheesetarrt.setHorizontalAlignment(JLabel.CENTER);
	    			  dialog2.getContentPane().add(lbl_cheesetarrt);
	        		  
	      			}
	      			else if(btn==btn4)
	      			{
	      				dialog2.setVisible(false);
	      			}
	        
	      			else if(btn==btn1)
	     			{
	     			  dialog.setLayout(null);
	     			  
	     			    
	     			
	     			  dialog.setSize(700,600);
	     			  lab2.setBounds(300,50,150,20);
	     			  dialog.add(lab2);
	     			  
	     			  btn3.setBounds(550,500,70,30);
	     			  dialog.add(btn3);
	     			//fff  
	     			 lab3.setBounds(300,450,150,20);
	      			  dialog.add(lab3);
		      	
	     			  jcb1.setBounds(200,100,130,50);
	     			  dialog.add(jcb1);
	     			  jcb2.setBounds(380,100,130,50);
	     			  dialog.add(jcb2);
	     			  cb3.setBounds(200,200,150,50);
	     			  dialog.add(cb3);
	     			  cb4.setBounds(380,200,150,50);
	    			  dialog.add(cb4);
	    			 
	    			  
	    			  btn9.setBounds(500,450,100,20);
	    			  dialog.add(btn9);
		      			  //dialog.setDefaultCloseOperation(ma.EXIT_ON_CLOSE);
	    			  dialog.setVisible(true);
		      			  //kkkk  
		      	 		  
	    			  lbl_ess.setIcon(change_esspresso);
	    			  lbl_ess.setBounds(70,80,100,100);
	    			  lbl_ess.setHorizontalAlignment(JLabel.CENTER);
	    			  dialog.getContentPane().add(lbl_ess);
	    			 
	    			  lbl_ame.setIcon(change_americano);
	    			  lbl_ame.setBounds(530,80,100,100);
	    			  lbl_ame.setHorizontalAlignment(JLabel.CENTER);
	    			  dialog.getContentPane().add(lbl_ame);
		    			  
	    			  lbl_dutch.setIcon(change_dutch);
	    			  lbl_dutch.setBounds(70,200,100,100);
	    			  lbl_dutch.setHorizontalAlignment(JLabel.CENTER);
	    			  dialog.getContentPane().add(lbl_dutch);
	    			  
	    			  lbl_cafelatte.setIcon(change_cafelatte);
	    			  lbl_cafelatte.setBounds(530,200,100,100);
	    			  lbl_cafelatte.setHorizontalAlignment(JLabel.CENTER);
	    			  dialog.getContentPane().add(lbl_cafelatte);
	     			}
	      			
	       		
	     			else if(btn==btn3)
	     			{
	     				dialog.setVisible(false);
	     			}
	       		  
	     			
	       		 
	     			else if(btn==btn9)
	     			{
	     				 dialog.setLayout(null);
	     				 
	     				 
		      			  
	     				 int amount=0;
	     				 
	   	       		 if( jcb1.isSelected())
	   	       			  shu[flag].amount += 1500;
	   	       		 if( jcb2.isSelected())
	   	       			  shu[flag].amount += 2000;
	   	       	    if( cb3.isSelected())
  	       			      shu[flag].amount += 1500;
	   	            if( cb4.isSelected())
	       			      shu[flag].amount += 2500;
	   	           
	   	       		 lab3.setText("총 가격:" +Integer.toString(shu[flag].amount));
	   	       		 shu[flag].setTotalPrice(shu[flag].getTotalPrice() +shu[flag]. amount);
	   	       		 // 디버그. 확인용...
	   	       		 System.out.println(shu[flag].getTotalPrice());
	   	       	     dialog.setVisible(true);
	   	       		 
	     			}
  			  
   	 		

	     			else if(btn==btn19)
	     			{
	     				 dialog2.setLayout(null);
	     				 
	     				 
		      			  
	     				 int amount2=0;
	     				 
	   	       		 if( cb12.isSelected())
	   	       			  shu2[flag].amount2 += 1500;
	   	       		 if( cb22.isSelected())
	   	       			  shu2[flag].amount2 += 2000;
	   	       	    if( cb32.isSelected())
  	       			      shu2[flag].amount2 += 1500;
	   	            if( cb42.isSelected())
	       			      shu2[flag].amount2 += 2500;
	   	           
	   	       		 lab13.setText("총 가격:" +Integer.toString(shu2[flag].amount2));
	   	       		 shu2[flag].setTotalPrice(shu2[flag].getTotalPrice() +shu2[flag]. amount2);
	   	       		 // 디버그. 확인용...
	   	       		 System.out.println(shu2[flag].getTotalPrice());
	   	       	     dialog2.setVisible(true);
	   	       		 
	     			}
	       		  
	       		  
	       		  
	       		  
	       		  
	       		  
	       		  
	       		  
	       		  
	       		  
	       		  
	       		  
	       		  
	       		  
	       		  
	       	  }
				 
			 }

	
			
			 ma.setBackground(Color.yellow);
			 btn1.addActionListener(new MyListener());
			 btn9.addActionListener(new MyListener());
			 btn19.addActionListener(new MyListener());
			
			 btn3.addActionListener(new MyListener());
			 btn4.addActionListener(new MyListener());
			 btn2.addActionListener(new MyListener());
				ma.foodPanels[flag].add(btn1);
				ma.foodPanels[flag].add(btn2);
				ma.frame.add(ma.foodPanels[flag]);
				
		    
		
		btn1.setBounds(150, 60, 100, 50);
		btn2.setBounds(530, 60, 100, 50);
		confirm.setBounds(300, 150, 80, 40);
		cancel.setBounds(400, 150, 80, 40);
		ma.foodPanels[flag].add(btn1);
		ma.foodPanels[flag].add(btn2);
		ma.foodPanels[flag].add(confirm);
		ma.foodPanels[flag].add(cancel);
		ma.frame.add(ma.foodPanels[flag]);
	}

	public void finalFrame(int finalPrice, int flag) 
	{
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
		finalPrice = finalPrice + shu[flag].getTotalPrice() + shu2[flag].getTotalPrice();
		JLabel finalPriceOutput = new JLabel("계산할 비용 : " + finalPrice);
		finalPriceOutput.setBackground(Color.white);
		finalPriceOutput.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		announce.add(finalPriceOutput);
		
		JPanel bottomAnnounce = new JPanel();
		bottomAnnounce.setSize(400, 100);
		
		// calFinish 버튼
		JButton calFinish = new JButton();
		calFinish.setBounds(300, 300, 200, 100);
		calFinish.add(new JLabel("확인(꼭 눌러주세요!)"));
		bottomAnnounce.add(calFinish);
		
		confirmPanel.add(announce);
		confirmPanel.add(bottomAnnounce);
		//confirmPanel.add(calFinish);
		
		confirmfrm.add(confirmPanel);
		confirmfrm.setVisible(true);
		//System.out.println(finalPrice);
		
		calFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shu[flag].setTotalPrice(0);
				shu[flag].amount = 0;
				shu2[flag].setTotalPrice(0);
				shu2[flag].amount2 = 0;
				confirmfrm.setVisible(false);
				//System.out.println("Calculation Completed!!");
			}
		});
	}

}