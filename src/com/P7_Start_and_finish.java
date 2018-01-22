package com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class P7_Start_and_finish {
	MonkeySql monkeySql = new MonkeySql();
	public JPanel P7_Start_and_finish() {
		JPanel p7 = new JPanel();
		final ButtonGroup group = new ButtonGroup();
		JRadioButton Start = new JRadioButton("启动");
		JRadioButton finish = new JRadioButton("停止");
		Start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (monkeySql.getmonkey_array_Specify_the_value(7).isEmpty()) {
					JOptionPane.showMessageDialog(null, "约束包不能为空！！！", "【出错啦】", JOptionPane.ERROR_MESSAGE);
					group.clearSelection();
					return;
				}else if (monkeySql.getmonkey_array_Specify_the_value(8).isEmpty()) {
					JOptionPane.showMessageDialog(null, "运行次数不能为空！！！", "【出错啦】", JOptionPane.ERROR_MESSAGE);
					group.clearSelection();
					return;
				}else if (monkeySql.getmonkey_array_Specify_the_value(6).isEmpty()) {
					JOptionPane.showMessageDialog(null, "时间间隔不能为空！！！", "【出错啦】", JOptionPane.ERROR_MESSAGE);
					group.clearSelection();
					return;
				}
				monkeySql.setmonkey_array("adb ", 0);
				monkeySql.setmonkey_array(" shell ", 2);
				monkeySql.setmonkey_array(" monkey ", 4);
				String runCode = "";
				for(int i = 0; i<monkeySql.getmonkey_array().length;i++) {
					runCode = runCode + monkeySql.getmonkey_array_Specify_the_value(i);
				}
				System.out.println(runCode);
				try {
					Process process = Runtime.getRuntime().exec("cmd /c " + runCode);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		p7.setBorder(BorderFactory.createTitledBorder("启动/关闭monkey"));
		p7.setBounds(580, 700, 200, 50);
		group.add(Start);
		group.add(finish);
		p7.add(Start);
		p7.add(finish);
		return p7;
		
	}

}
