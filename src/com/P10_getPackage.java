package com;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.channels.SelectableChannel;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class P10_getPackage {
	MonkeySql monkeySql = new MonkeySql();
	public JPanel P10_getPackage() {
		JPanel p10 = new JPanel();
		p10.setLayout(null);
		p10.setBounds(10, 215, 340, 150);
		p10.setBorder(BorderFactory.createTitledBorder("获得当前应用包名"));
		Button jButton = new Button("Get_Package");
		jButton.setBounds(10, 20, 320, 35);
		final JTextArea jTextArea = new JTextArea();
		jTextArea.setBounds(10, 60, 320, 40);
		jTextArea.setLineWrap(true);
		JLabel jLabel = new JLabel("先在设备上进入一个要测试的应用，在点击获取包名");
		jLabel.setBounds(10, 90, 330, 40);
		jButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Process process;
					if (MonkeySql.Device_ID == "") {
						process = Runtime.getRuntime().exec("cmd /c adb shell \"dumpsys activity | grep  Focuse\"");
					}else {
						process = Runtime.getRuntime().exec("cmd /c adb "+ MonkeySql.Device_ID +" shell \"dumpsys activity | grep  Focuse\"");
					}
					BufferedReader rf = new BufferedReader(new InputStreamReader(process.getInputStream()));
					StringBuffer sBuffer = new StringBuffer();
					String value = "";
					while((value = rf.readLine())!= null) {
						if (value.startsWith("  mFocusedActivity")) {
							sBuffer.append(value);
							int start = sBuffer.lastIndexOf("u0 com.");
							int end = sBuffer.lastIndexOf("/.");
							String string =sBuffer.substring(start+2, end);
							jTextArea.setText(string.toString());
						}
					}
					process.waitFor();
					rf.close();
//					inputStream.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		p10.add(jLabel);
		p10.add(jTextArea);
		p10.add(jButton);
		return p10;
	}

}
