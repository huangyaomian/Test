package com;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
public class P8 extends JPanel{
	private static Thread thread;
	public P8(String AA) throws InterruptedException {
		JFrame jFrame = new JFrame(AA);
		Container container = jFrame.getContentPane();
		container.add(p8_log());
		jFrame.setVisible(true);
		jFrame.setSize(1000, 600);
		jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
	}
	public ChartPanel p8_log() throws InterruptedException {
		ChartPanel framel;	
		JFreeChart jfreechart = ChartFactory.createLineChart("ID", "Type", "Value", createDataset(), PlotOrientation.VERTICAL, true, true, false);
		framel= new ChartPanel(jfreechart,true);
		framel.setBounds(15, 15, 750, 300);;
		jfreechart.setBackgroundPaint(Color.white);
		CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
		categoryplot.setBackgroundPaint(Color.lightGray);
		categoryplot.setRangeGridlinePaint(Color.white);
		NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
		numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		numberaxis.setAutoRangeIncludesZero(true);
		//获得renderer 注意这里是下嗍造型到lineandshaperenderer！！
		LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer)categoryplot.getRenderer();
		lineandshaperenderer.setSeriesStroke(1, new BasicStroke(2.0F, 1, 1, 1.0F, new float[] {6F, 6F}, 0.0F)); //定义series为”Second”的（即series2）点之间的连线
		lineandshaperenderer.setSeriesStroke(2, new BasicStroke(2.0F, 1, 1, 1.0F, new float[] {2.0F, 6F}, 0.0F)); //定义series为”Third”的（即series3）点之间的连线
		return framel;

	}
	public static CategoryDataset createDataset() throws InterruptedException {
		final DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset(); //这个地方添加了final
		thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					try {
						Process process;
						if (MonkeySql.Device_ID == "") {
							process=Runtime.getRuntime().exec("cmd /c adb shell dumpsys cpuinfo");
						}else {
							process=Runtime.getRuntime().exec("cmd /c adb "+ MonkeySql.Device_ID +" shell dumpsys cpuinfo");
						}
						InputStream pInputStream =process.getInputStream();
						BufferedReader br = new BufferedReader(new InputStreamReader(pInputStream));
						StringBuffer sBuffer = new StringBuffer();
						String ID ="";
						while((ID = br.readLine()) != null ) {
							if (ID.endsWith("TOTAL")) {
								sBuffer.append(ID);
								int size=sBuffer.lastIndexOf("ice");
								sBuffer.insert(size+3, "\n");
								sBuffer.replace(size-3, size+3, "");
							}
						}
						}catch(IOException e1) {
							e1.printStackTrace();
						}
					Date date = new Date();
					System.out.println(date.toString());
					String hour =String.format("%tH", date);
					String minute =String.format("%tM", date);
					String second =String.format("%tS", date);
					String time1 = hour+minute+second;
					sleep(2000);
				Random random = new Random();
				int randNum = random.nextInt(10);
				defaultCategoryDataset.addValue(randNum, "A",time1);
				sleep(1000);
				int randNum2 = random.nextInt(10);
				defaultCategoryDataset.addValue(randNum2, "B",time1);
				sleep(1000);
				int randNum3 = random.nextInt(10);
				defaultCategoryDataset.addValue(randNum3, "C",time1);
				}
			}
		});
		thread.start();
		return defaultCategoryDataset;
	}
	public static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
