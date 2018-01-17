package com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class P3_delay {
	MonkeySql monkeySql = new MonkeySql();
	public JPanel P3_delay() {
		JPanel p3 = new JPanel();
		p3.setLayout(null);
		p3.setBorder(BorderFactory.createTitledBorder("执行间隔时间"));
		p3.setBounds(380, 72, 385, 70);
		final JTextField jTextField = new JTextField(1);
		jTextField.setBounds(10, 25, 150, 30);
		JRadioButton Write = new JRadioButton("写入");
		Write.setBounds(165, 15, 55, 50);
		JRadioButton Clear = new JRadioButton("清除");
		Clear.setBounds(216, 15, 55, 50);
		Write.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String Value = jTextField.getText();
				monkeySql.setmonkey_array(" --throttle "+Value, 6);
				
				
			}
		});
		Clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jTextField.setText("");
				monkeySql.setmonkey_array("", 6);
				
			}
		});
		
		ButtonGroup group = new ButtonGroup();
		group.add(Write);
		group.add(Clear);
		p3.add(Write);
		p3.add(Clear);
		p3.add(jTextField);
		return p3;
		
	}

}
