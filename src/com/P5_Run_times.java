package com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class P5_Run_times {
	MonkeySql monkeySql = new MonkeySql();
	public JPanel P5_Run_times() {
		JPanel p5 = new JPanel();
		p5.setBorder(BorderFactory.createTitledBorder("运行次数"));
		p5.setBounds(465, 146, 300, 70);
		p5.setLayout(null);	
		final JTextField jTextField = new JTextField(1);
		jTextField.setBounds(10, 25, 150, 35);
		JRadioButton Write = new JRadioButton("写入");
		JRadioButton Clear = new JRadioButton("清除");
		Write.setBounds(160, 25, 55, 35);
		Clear.setBounds(210, 25, 55, 35);
		Write.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String number = jTextField.getText();
				monkeySql.setmonkey_array(" "+number, 8);
			}
		});
		Clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				monkeySql.setmonkey_array("", 8);
				
			}
		});
		p5.add(jTextField);
		ButtonGroup group = new ButtonGroup();
		group.add(Write);
		group.add(Clear);
		p5.add(Clear);
		p5.add(Write);
		return p5;
		
	}

}
