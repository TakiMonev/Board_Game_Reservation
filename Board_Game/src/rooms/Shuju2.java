package rooms;

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
import boss_Activity.Button_Actioned;
import boss_Activity.Main_Activity;
import boss_Activity.Make_Room;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Shuju2 {

	private int totalPrice = 0;
	public int amount2 = 0;
	
	public void setTotalPrice(int amount2)
	{
		totalPrice = amount2;
	}
	
	public int getTotalPrice()
	{
		return totalPrice;
	}
	
}