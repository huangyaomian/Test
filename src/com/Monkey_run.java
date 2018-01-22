package com;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/*
 * 连接设备的JPanel类	
 */
public class Monkey_run {
	MonkeySql monkeySql = new MonkeySql();
	public Monkey_run() {		
		JFrame jFrame= new JFrame("monkey可视化操作工具");
		Container container = jFrame.getContentPane();
		container.setLayout(null);
		try {
		container.add(new P1().P1_Connect_the_device());
		container.add(new P2_log_Detail_level().P2_log_Detail_level());
		container.add(new P3_delay().P3_delay());
		container.add(new P4_Constraint_package().P4_Constraint_package());
		container.add(new P5_Run_times().P5_Run_times());
		container.add(new P6_log_save().P6_log_save());
		container.add(new P7_Start_and_finish().P7_Start_and_finish());
		container.add(P9_Chart_switch());
		container.add(new P10_getPackage().P10_getPackage());
		jFrame.setVisible(true);
		jFrame.setSize(800, 800);
		jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	
	public JPanel P9_Chart_switch() throws InterruptedException {
		JPanel p9 = new JPanel();
		p9.setBorder(BorderFactory.createTitledBorder("图表开关"));
		p9.setBounds(15, 700, 200, 50);
		JButton jButton = new JButton("log");
		jButton.setBounds(15, 30, 50, 50);
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (MonkeySql.getmonkey_array_Specify_the_value(7).isEmpty()) {
						JOptionPane.showMessageDialog(null, "约束包不能为空！！！", "【出错啦】", JOptionPane.ERROR_MESSAGE);
						return;
					}
					new P8("CPU使用情况图示").setVisible(true);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		p9.add(jButton);
		return p9;
	}
	
	
	public static void main(String [] agrs) {
		new Monkey_run();
		}
	
}	
