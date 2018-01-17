package com;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class P6_log_save {
	MonkeySql monkeySql = new MonkeySql();
	public JPanel P6_log_save() {
		JPanel p6 = new JPanel();
		p6.setLayout(null);
		JRadioButton phone = new JRadioButton("手机");
		JRadioButton PC = new JRadioButton("电脑");
		final JRadioButton Write = new JRadioButton("写入");
		final JRadioButton Clear = new JRadioButton("清除");
		final JTextField jTextField = new JTextField(2);
		JLabel jLabel = new JLabel("PS:请输入路径加文件名称和文件后缀名。"
				+ "\n例如：/mnt/sdcard/log1.txt");
		
		phone.setBounds(15, 15, 100, 25);
		PC.setBounds(120, 15, 100, 25);
		jLabel.setBounds(15, 25, 390, 60);
		jTextField.setBounds(15, 80, 390, 35);
		Write.setBounds(15, 110, 100, 35);
		Clear.setBounds(120, 110, 100, 35);
		Write.setEnabled(false);
		Clear.setEnabled(false);
		jTextField.setEnabled(false);
		phone.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Write.setEnabled(true);
				Clear.setEnabled(true);
				jTextField.setEnabled(true);
				monkeySql.setmonkey_array("#", 3);
			}
		});
		PC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Write.setEnabled(true);
				Clear.setEnabled(true);
				jTextField.setEnabled(true);
				monkeySql.setmonkey_array("", 3);
				
			}
		});
		Write.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String content = ">"+jTextField.getText();
				monkeySql.setmonkey_array(content, 9);
			}
		});
		Clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jTextField.setText("");
				monkeySql.setmonkey_array("", 9);
				
			}
		});
		p6.setBorder(BorderFactory.createTitledBorder("log文档保存位置"));
		p6.setBounds(350, 215, 415, 150);
		ButtonGroup group1 = new ButtonGroup();
		ButtonGroup group2 = new ButtonGroup();
		group1.add(phone);
		group1.add(PC);
		group2.add(Write);
		group2.add(Clear);
		p6.add(phone);
		p6.add(PC);
		p6.add(Write);
		p6.add(Clear);
		p6.add(jLabel);
		p6.add(jTextField);
		return p6;
	}

}
