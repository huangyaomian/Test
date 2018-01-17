package com;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class P1 extends MonkeySql{
	public static String aString;
	
	MonkeySql monkey_data = new MonkeySql();
	public JPanel P1_Connect_the_device(){
		StringBuffer stringBuffer = new StringBuffer();
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		p1.setBorder(BorderFactory.createTitledBorder("连接设备"));
		p1.setBounds(15, 1, 750, 70);
		final JTextField jTextField = new JTextField(1);
		jTextField.setBounds(30, 25, 300, 30);
		JRadioButton Write = new JRadioButton("写入");
		Write.setBounds(350, 30, 70, 25);
		Write.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				aString = jTextField.getText();
				monkey_data.setDevice_ID("-s "+aString);
				monkey_data.setmonkey_array("-s "+aString, 1);
			}
		});
		JRadioButton Clear = new JRadioButton("清除");
		Clear.setBounds(420, 30, 70, 25);
		Clear.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jTextField.setText("");
				jTextField.requestFocus();
				monkey_data.setmonkey_array("", 1);
			}
		});
		Button Device_ID = new Button("Device_ID");
		final JTextArea jTextArea = new JTextArea();
		jTextArea.setLineWrap(true);
		Device_ID.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Process process=Runtime.getRuntime().exec("cmd /c adb devices");
					InputStream pInputStream =process.getInputStream();
					BufferedReader br = new BufferedReader(new InputStreamReader(pInputStream));
					StringBuffer sBuffer = new StringBuffer();
					String ID ="";
					while((ID = br.readLine()) != null ) {
						if (ID.endsWith("device")) {
							sBuffer.append(ID);
							int size=sBuffer.lastIndexOf("ice");
							sBuffer.insert(size+3, "\n");
							sBuffer.replace(size-3, size+3, "");
							jTextArea.setText(sBuffer.toString());
							
						}
						
					}
					process.waitFor();
					br.close();
					pInputStream.close();
					}catch(IOException e1) {
						e1.printStackTrace();
						
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		Device_ID.setBounds(480, 15, 70, 50);
		jTextArea.setBounds(560, 15, 180, 50);
		p1.add(jTextArea);
		p1.add(Device_ID);
		p1.add(Write);
		p1.add(Clear);
		p1.add(jTextField);
		ButtonGroup group = new ButtonGroup();	
		group.add(Write);
		group.add(Clear);
		return p1;
	}

}
