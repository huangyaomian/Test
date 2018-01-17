package com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class P4_Constraint_package {
	MonkeySql monkeySql = new MonkeySql();
	public JPanel P4_Constraint_package() {
		JPanel p4 = new JPanel();
		p4.setLayout(null);
		final JTextField jTextField = new JTextField(1);
		JRadioButton Write = new JRadioButton("写入");
		JRadioButton Clear = new JRadioButton("清除");
		ButtonGroup group = new ButtonGroup();
		Write.setBounds(330, 25, 55, 35);
		Clear.setBounds(385, 25, 55, 35);
		jTextField.setBounds(15, 25, 300, 35);
		Write.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String Value =jTextField.getText();
				monkeySql.setmonkey_array(" -p "+Value, 7);
				
			}
		});
		Clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jTextField.setText("");
				monkeySql.setmonkey_array("", 7);
				
			}
		});
		group.add(Write);
		group.add(Clear);
		p4.add(Write);
		p4.add(Clear);
		p4.add(jTextField);
		p4.setBorder(BorderFactory.createTitledBorder("约束包"));
		p4.setBounds(15, 146, 450, 70);
		return p4;
		
	}

}
