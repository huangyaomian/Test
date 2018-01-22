package com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SetSeedValue {
	MonkeySql monkeySql = new MonkeySql();
	public JPanel getSeedValue() {
		JPanel SeedValue = new JPanel();
		SeedValue.setBorder(BorderFactory.createTitledBorder("Seed值"));
		SeedValue.setBounds(15, 366, 300, 70);
		SeedValue.setLayout(null);	
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
				monkeySql.setmonkey_array(" -s "+number, 9);
			}
		});
		Clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				monkeySql.setmonkey_array("", 9);
			}
		});
		SeedValue.add(jTextField);
		ButtonGroup group = new ButtonGroup();
		group.add(Write);
		group.add(Clear);
		SeedValue.add(Clear);
		SeedValue.add(Write);
		return SeedValue;
		
	}

}

