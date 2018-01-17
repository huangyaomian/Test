package com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class P7_Start_and_finish {
	MonkeySql monkeySql = new MonkeySql();
	public JPanel P7_Start_and_finish() {
		JPanel p7 = new JPanel();
		JRadioButton Start = new JRadioButton("启动");
		JRadioButton finish = new JRadioButton("停止");
		Start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				monkeySql.setmonkey_array("adb ", 0);
				monkeySql.setmonkey_array(" shell ", 2);
				monkeySql.setmonkey_array(" monkey ", 4);
				System.out.println(monkeySql.getmonkey_array());
				for(int i = 0; i<monkeySql.getmonkey_array().length;i++) {
					System.out.print(monkeySql.getmonkey_array_Specify_the_value(i));
				}
			}
		});
		p7.setBorder(BorderFactory.createTitledBorder("启动/关闭monkey"));
		p7.setBounds(580, 700, 200, 50);
		ButtonGroup group = new ButtonGroup();
		group.add(Start);
		group.add(finish);
		p7.add(Start);
		p7.add(finish);
		return p7;
		
	}

}
