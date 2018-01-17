package com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class P2_log_Detail_level {
	MonkeySql monkeySql = new MonkeySql();
	public JPanel P2_log_Detail_level() {
		JPanel p2 = new JPanel();
		p2.setBorder(BorderFactory.createTitledBorder("log详细级别"));
		p2.setBounds(15, 72, 350, 70);
		p2.setLayout(null);
		String value [] = {"空","一级","二级","三级"};
		final JComboBox<String> group = new JComboBox<>(value);
		group.setBounds(50, 25, 200, 35);
		group.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(group.getSelectedItem().equals("空")) {
					monkeySql.setmonkey_array("", 5);
					
				}else if(group.getSelectedItem().equals("一级")){
					System.out.println("一级");
					monkeySql.setmonkey_array("-v", 5);
					
				}else if (group.getSelectedItem().equals("二级")) {
					System.out.println("二级");
					monkeySql.setmonkey_array("-v -v", 5);
					
				}else if(group.getSelectedItem().equals("三级")) {
					System.out.println("三级");
					monkeySql.setmonkey_array("-v -v -v", 5);
				}
			}
		});
		
		
		/*JRadioButton v1 = new JRadioButton("1级");
		JRadioButton v2 = new JRadioButton("2级");
		JRadioButton v3 = new JRadioButton("3级");
		JRadioButton cancel = new JRadioButton("取消");
		v1.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				monkeySql.setmonkey_array("-v", 5);
			}
		});
		v2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				monkeySql.setmonkey_array("-v -v", 5);
				
			}
		});
		v3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				monkeySql.setmonkey_array("-v -v -v", 5);
				
			}
		});
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				monkeySql.setmonkey_array("", 3);
				
			}
		});
		ButtonGroup group = new ButtonGroup();
		group.add(v1);
		group.add(v2);
		group.add(v3);
		group.add(cancel);
		*/
		//p2.add(v1);
		//p2.add(v2);
		//p2.add(v3);
		//p2.add(cancel);
		p2.add(group);
		return p2;	
	}

}
