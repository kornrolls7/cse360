package teamProject;

import java.awt.EventQueue;

import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.filechooser.FileSystemView;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.*;

public class gui1 {

	private JFrame frmGradebook;
	private String filePath = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
				
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					gui1 window = new gui1();
					//changeGradeRange window2 = new changeGradeRange();
					window.frmGradebook.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui1() {
		initialize();
	}
	

	
	ArrayList<String> gradeList = new ArrayList<String>();
	ArrayList<String> sortedGradeList = new ArrayList<String>();
	private JButton btnUploadGrades_1;
	private JButton btnPrintReport_1;
	private JButton btnChange_1;
	private JButton btnSaveGradesTo_1;
	private float gradeA = 90, gradeB = 80, gradeC = 70, gradeD = 60, gradeE = 0;
	private int distA = 0, distB = 0, distC = 0, distD = 0, distE = 0;
	int min = 0, max = 100;
	double high, low, avg, med;
	
	


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		frmGradebook = new JFrame();
		frmGradebook.getContentPane().setForeground(Color.WHITE);
		frmGradebook.setTitle("GRADEBOOK");
		frmGradebook.setBackground(new Color(0, 51, 102));
		frmGradebook.getContentPane().setBackground(new Color(30, 144, 255));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{1, 94, 19, 43, 153, 131, 35, 103, 0};
		gridBagLayout.rowHeights = new int[]{1, 23, 14, 14, 14, 14, 35, 23, 14, 14, 14, 14, 14, 35, 23, 14, 14, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmGradebook.getContentPane().setLayout(gridBagLayout);
				
				JLabel lblAverageDynamic = new JLabel("");
				lblAverageDynamic.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblAverageDynamic = new GridBagConstraints();
				gbc_lblAverageDynamic.insets = new Insets(0, 0, 5, 5);
				gbc_lblAverageDynamic.gridx = 0;
				gbc_lblAverageDynamic.gridy = 0;
				frmGradebook.getContentPane().add(lblAverageDynamic, gbc_lblAverageDynamic);
				
				JLabel lblLowDynamic = new JLabel("");
				lblLowDynamic.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblLowDynamic = new GridBagConstraints();
				gbc_lblLowDynamic.insets = new Insets(0, 0, 5, 5);
				gbc_lblLowDynamic.gridx = 0;
				gbc_lblLowDynamic.gridy = 0;
				frmGradebook.getContentPane().add(lblLowDynamic, gbc_lblLowDynamic);
				
				JLabel lblHighDynamic = new JLabel("");
				lblHighDynamic.setBackground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblHighDynamic = new GridBagConstraints();
				gbc_lblHighDynamic.insets = new Insets(0, 0, 5, 5);
				gbc_lblHighDynamic.gridx = 0;
				gbc_lblHighDynamic.gridy = 0;
				frmGradebook.getContentPane().add(lblHighDynamic, gbc_lblHighDynamic);
				
				JLabel lblMedianDynamic = new JLabel("");
				lblMedianDynamic.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblMedianDynamic = new GridBagConstraints();
				gbc_lblMedianDynamic.insets = new Insets(0, 0, 5, 5);
				gbc_lblMedianDynamic.gridx = 0;
				gbc_lblMedianDynamic.gridy = 0;
				frmGradebook.getContentPane().add(lblMedianDynamic, gbc_lblMedianDynamic);
				
				JButton btnUploadGrades_1 = new JButton("UPLOAD GRADES");
				GridBagConstraints gbc_btnUploadGrades_1 = new GridBagConstraints();
				gbc_btnUploadGrades_1.insets = new Insets(0, 0, 5, 5);
				gbc_btnUploadGrades_1.gridwidth = 2;
				gbc_btnUploadGrades_1.gridx = 0;
				gbc_btnUploadGrades_1.gridy = 1;
				frmGradebook.getContentPane().add(btnUploadGrades_1, gbc_btnUploadGrades_1);
				
				
				
				JButton btnChange_1 = new JButton("CHANGE GRADE RANGE");
				btnChange_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
				
						
				JButton btnPrintReport_1 = new JButton("PRINT REPORT");
				GridBagConstraints gbc_btnPrintReport_1 = new GridBagConstraints();
				gbc_btnPrintReport_1.insets = new Insets(0, 0, 5, 5);
				gbc_btnPrintReport_1.gridx = 4;
				gbc_btnPrintReport_1.gridy = 1;
				frmGradebook.getContentPane().add(btnPrintReport_1, gbc_btnPrintReport_1);
				
				
				JLabel lblLetterGrades = new JLabel("LETTER GRADES");
				lblLetterGrades.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblLetterGrades = new GridBagConstraints();
				gbc_lblLetterGrades.anchor = GridBagConstraints.SOUTH;
				gbc_lblLetterGrades.insets = new Insets(0, 0, 5, 5);
				gbc_lblLetterGrades.gridx = 5;
				gbc_lblLetterGrades.gridy = 1;
				frmGradebook.getContentPane().add(lblLetterGrades, gbc_lblLetterGrades);
				
				JLabel lblGrades = new JLabel("GRADES");
				lblGrades.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblGrades = new GridBagConstraints();
				gbc_lblGrades.anchor = GridBagConstraints.SOUTH;
				gbc_lblGrades.insets = new Insets(0, 0, 5, 5);
				gbc_lblGrades.gridx = 7;
				gbc_lblGrades.gridy = 1;
				frmGradebook.getContentPane().add(lblGrades, gbc_lblGrades);
				
				JLabel lblHigh = new JLabel("HIGH");
				lblHigh.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblHigh = new GridBagConstraints();
				gbc_lblHigh.insets = new Insets(0, 0, 5, 5);
				gbc_lblHigh.gridx = 1;
				gbc_lblHigh.gridy = 2;
				frmGradebook.getContentPane().add(lblHigh, gbc_lblHigh);
				
				JLabel lblHighDynamic_1 = new JLabel("0");
				lblHighDynamic_1.setForeground(Color.WHITE);
				GridBagConstraints gbc_lblHighDynamic_1 = new GridBagConstraints();
				gbc_lblHighDynamic_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblHighDynamic_1.gridx = 3;
				gbc_lblHighDynamic_1.gridy = 2;
				frmGradebook.getContentPane().add(lblHighDynamic_1, gbc_lblHighDynamic_1);
				
				JTextPane textPane = new JTextPane();
				JScrollPane textPaneT = new JScrollPane(textPane);
				//JScrollPane textPane = new JScrollPane(textPaneT);
				textPaneT.setBackground(new Color(30, 144, 255));
				textPane.setBackground(new Color(30, 144, 255));
				GridBagConstraints gbc_textPaneT = new GridBagConstraints();
				gbc_textPaneT.fill = GridBagConstraints.BOTH;
				gbc_textPaneT.insets = new Insets(0, 0, 5, 5);
				gbc_textPaneT.gridheight = 11;
				gbc_textPaneT.gridx = 5;
				gbc_textPaneT.gridy = 2;
				frmGradebook.getContentPane().add(textPaneT, gbc_textPaneT);
				
				
				
				JEditorPane editorPaneT = new JEditorPane();
				JScrollPane editorPane = new JScrollPane(editorPaneT);
				editorPane.setBackground(new Color(255, 255, 255));
				GridBagConstraints gbc_editorPane = new GridBagConstraints();
				gbc_editorPane.fill = GridBagConstraints.BOTH;
				gbc_editorPane.insets = new Insets(0, 0, 5, 5);
				gbc_editorPane.gridheight = 11;
				gbc_editorPane.gridx = 7;
				gbc_editorPane.gridy = 2;
				frmGradebook.getContentPane().add(editorPane, gbc_editorPane);
				
				
				JLabel lblLow = new JLabel("LOW");
				lblLow.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblLow = new GridBagConstraints();
				gbc_lblLow.anchor = GridBagConstraints.NORTH;
				gbc_lblLow.insets = new Insets(0, 0, 5, 5);
				gbc_lblLow.gridx = 1;
				gbc_lblLow.gridy = 3;
				frmGradebook.getContentPane().add(lblLow, gbc_lblLow);
				
				JLabel lblLowDynamic_1 = new JLabel("0");
				lblLowDynamic_1.setForeground(Color.WHITE);
				GridBagConstraints gbc_lblLowDynamic_1 = new GridBagConstraints();
				gbc_lblLowDynamic_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblLowDynamic_1.gridx = 3;
				gbc_lblLowDynamic_1.gridy = 3;
				frmGradebook.getContentPane().add(lblLowDynamic_1, gbc_lblLowDynamic_1);
				
				JLabel lblAverage = new JLabel("AVERAGE");
				lblAverage.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblAverage = new GridBagConstraints();
				gbc_lblAverage.insets = new Insets(0, 0, 5, 5);
				gbc_lblAverage.gridx = 1;
				gbc_lblAverage.gridy = 4;
				frmGradebook.getContentPane().add(lblAverage, gbc_lblAverage);
				
				JLabel lblAverageDynamic_1 = new JLabel("0");
				lblAverageDynamic_1.setForeground(Color.WHITE);
				GridBagConstraints gbc_lblAverageDynamic_1 = new GridBagConstraints();
				gbc_lblAverageDynamic_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblAverageDynamic_1.gridx = 3;
				gbc_lblAverageDynamic_1.gridy = 4;
				frmGradebook.getContentPane().add(lblAverageDynamic_1, gbc_lblAverageDynamic_1);
				
				JLabel lblMedian = new JLabel("MEDIAN");
				lblMedian.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblMedian = new GridBagConstraints();
				gbc_lblMedian.insets = new Insets(0, 0, 5, 5);
				gbc_lblMedian.gridx = 1;
				gbc_lblMedian.gridy = 5;
				frmGradebook.getContentPane().add(lblMedian, gbc_lblMedian);
				
				JLabel lblMedianDynamic_1 = new JLabel("0");
				lblMedianDynamic_1.setForeground(Color.WHITE);
				GridBagConstraints gbc_lblMedianDynamic_1 = new GridBagConstraints();
				gbc_lblMedianDynamic_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblMedianDynamic_1.gridx = 3;
				gbc_lblMedianDynamic_1.gridy = 5;
				frmGradebook.getContentPane().add(lblMedianDynamic_1, gbc_lblMedianDynamic_1);
				
				JLabel lblDistribution = new JLabel("DISTRIBUTION");
				lblDistribution.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblDistribution = new GridBagConstraints();
				gbc_lblDistribution.insets = new Insets(0, 0, 5, 5);
				gbc_lblDistribution.gridx = 1;
				gbc_lblDistribution.gridy = 7;
				frmGradebook.getContentPane().add(lblDistribution, gbc_lblDistribution);
				GridBagConstraints gbc_btnChange_1 = new GridBagConstraints();
				gbc_btnChange_1.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnChange_1.insets = new Insets(0, 0, 5, 5);
				gbc_btnChange_1.gridx = 4;
				gbc_btnChange_1.gridy = 7;
				frmGradebook.getContentPane().add(btnChange_1, gbc_btnChange_1);
				
				
						
				
				JLabel lblA = new JLabel("A");
				lblA.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblA = new GridBagConstraints();
				gbc_lblA.insets = new Insets(0, 0, 5, 5);
				gbc_lblA.gridx = 1;
				gbc_lblA.gridy = 8;
				frmGradebook.getContentPane().add(lblA, gbc_lblA);
				
				JLabel label = new JLabel("0");
				label.setForeground(Color.WHITE);
				GridBagConstraints gbc_lblTest = new GridBagConstraints();
				gbc_lblTest.insets = new Insets(0, 0, 5, 5);
				gbc_lblTest.gridx = 2;
				gbc_lblTest.gridy = 8;
				frmGradebook.getContentPane().add(label, gbc_lblTest);
				
				JLabel lblB = new JLabel("B");
				lblB.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblB = new GridBagConstraints();
				gbc_lblB.insets = new Insets(0, 0, 5, 5);
				gbc_lblB.gridx = 1;
				gbc_lblB.gridy = 9;
				frmGradebook.getContentPane().add(lblB, gbc_lblB);
				
				JLabel label_1 = new JLabel("0");
				label_1.setForeground(Color.WHITE);
				GridBagConstraints gbc_lblTest_1 = new GridBagConstraints();
				gbc_lblTest_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblTest_1.gridx = 2;
				gbc_lblTest_1.gridy = 9;
				frmGradebook.getContentPane().add(label_1, gbc_lblTest_1);
				
				JLabel lblC = new JLabel("C");
				lblC.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblC = new GridBagConstraints();
				gbc_lblC.insets = new Insets(0, 0, 5, 5);
				gbc_lblC.gridx = 1;
				gbc_lblC.gridy = 10;
				frmGradebook.getContentPane().add(lblC, gbc_lblC);
				
				JLabel label_2 = new JLabel("0");
				label_2.setForeground(Color.WHITE);
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = 2;
				gbc_label.gridy = 10;
				frmGradebook.getContentPane().add(label_2, gbc_label);
				
						JLabel lblD = new JLabel("D");
						lblD.setForeground(new Color(255, 255, 255));
						GridBagConstraints gbc_lblD = new GridBagConstraints();
						gbc_lblD.insets = new Insets(0, 0, 5, 5);
						gbc_lblD.gridx = 1;
						gbc_lblD.gridy = 11;
						frmGradebook.getContentPane().add(lblD, gbc_lblD);
				
				JLabel label_3 = new JLabel("0");
				label_3.setForeground(Color.WHITE);
				GridBagConstraints gbc_label_1 = new GridBagConstraints();
				gbc_label_1.insets = new Insets(0, 0, 5, 5);
				gbc_label_1.gridx = 2;
				gbc_label_1.gridy = 11;
				frmGradebook.getContentPane().add(label_3, gbc_label_1);
		
				JLabel lblE = new JLabel("E");
				lblE.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblE = new GridBagConstraints();
				gbc_lblE.insets = new Insets(0, 0, 5, 5);
				gbc_lblE.gridx = 1;
				gbc_lblE.gridy = 12;
				frmGradebook.getContentPane().add(lblE, gbc_lblE);
		
		JLabel label_4 = new JLabel("0");
		label_4.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 2;
		gbc_label_2.gridy = 12;
		frmGradebook.getContentPane().add(label_4, gbc_label_2);
		
		JLabel lblPercentile = new JLabel("PERCENTILE");
		lblPercentile.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblPercentile = new GridBagConstraints();
		gbc_lblPercentile.insets = new Insets(0, 0, 5, 5);
		gbc_lblPercentile.gridx = 1;
		gbc_lblPercentile.gridy = 14;
		frmGradebook.getContentPane().add(lblPercentile, gbc_lblPercentile);
		
		JButton btnSetMinmax = new JButton("SET MIN/MAX");
		btnSetMinmax.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		GridBagConstraints gbc_btnSetMinmax = new GridBagConstraints();
		gbc_btnSetMinmax.insets = new Insets(0, 0, 5, 5);
		gbc_btnSetMinmax.gridx = 5;
		gbc_btnSetMinmax.gridy = 14;
		frmGradebook.getContentPane().add(btnSetMinmax, gbc_btnSetMinmax);
		
		JButton btnSaveGradesTo_1 = new JButton("UPDATE GRADES");
		btnSaveGradesTo_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		GridBagConstraints gbc_btnSaveGradesTo_1 = new GridBagConstraints();
		gbc_btnSaveGradesTo_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnSaveGradesTo_1.gridx = 7;
		gbc_btnSaveGradesTo_1.gridy = 14;
		frmGradebook.getContentPane().add(btnSaveGradesTo_1, gbc_btnSaveGradesTo_1);
		
		
		JLabel lblBottom = new JLabel("20th Percentile");
		lblBottom.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblBottom = new GridBagConstraints();
		gbc_lblBottom.insets = new Insets(0, 0, 5, 5);
		gbc_lblBottom.gridx = 1;
		gbc_lblBottom.gridy = 15;
		frmGradebook.getContentPane().add(lblBottom, gbc_lblBottom);
		
		JLabel lblMiddle = new JLabel("70th Percentile");
		lblMiddle.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblMiddle = new GridBagConstraints();
		gbc_lblMiddle.insets = new Insets(0, 0, 5, 5);
		gbc_lblMiddle.gridx = 4;
		gbc_lblMiddle.gridy = 15;
		frmGradebook.getContentPane().add(lblMiddle, gbc_lblMiddle);
		
		JLabel lblTop = new JLabel("90th Percentile");
		lblTop.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblTop = new GridBagConstraints();
		gbc_lblTop.insets = new Insets(0, 0, 5, 5);
		gbc_lblTop.gridx = 5;
		gbc_lblTop.gridy = 15;
		frmGradebook.getContentPane().add(lblTop, gbc_lblTop);
		
		JLabel lblBottom20Dynamic = new JLabel(" ");
		lblBottom20Dynamic.setBackground(Color.WHITE);
		lblBottom20Dynamic.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblBottom20Dynamic = new GridBagConstraints();
		gbc_lblBottom20Dynamic.insets = new Insets(0, 0, 0, 5);
		gbc_lblBottom20Dynamic.gridx = 1;
		gbc_lblBottom20Dynamic.gridy = 16;
		frmGradebook.getContentPane().add(lblBottom20Dynamic, gbc_lblBottom20Dynamic);
		
		JLabel lblMiddle70Dynamic = new JLabel(" ");
		lblMiddle70Dynamic.setBackground(Color.WHITE);
		lblMiddle70Dynamic.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblMiddle70Dynamic = new GridBagConstraints();
		gbc_lblMiddle70Dynamic.insets = new Insets(0, 0, 0, 5);
		gbc_lblMiddle70Dynamic.gridx = 4;
		gbc_lblMiddle70Dynamic.gridy = 16;
		frmGradebook.getContentPane().add(lblMiddle70Dynamic, gbc_lblMiddle70Dynamic);
		
		JLabel lblTop10Dynamic = new JLabel(" ");
		lblTop10Dynamic.setBackground(Color.WHITE);
		lblTop10Dynamic.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblTop10Dynamic = new GridBagConstraints();
		gbc_lblTop10Dynamic.insets = new Insets(0, 0, 0, 5);
		gbc_lblTop10Dynamic.gridx = 5;
		gbc_lblTop10Dynamic.gridy = 16;
		frmGradebook.getContentPane().add(lblTop10Dynamic, gbc_lblTop10Dynamic);
		
		String temp = "";
		for (int i = 0; i < gradeList.size(); i++) {
			temp += gradeList.get(i) + "\n";
			
		}
		editorPaneT.setText(temp);
		
		btnUploadGrades_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				int returnValue = jfc.showOpenDialog(null);
				
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = jfc.getSelectedFile();
					filePath = selectedFile.getAbsolutePath();
					if(selectedFile.getName().toLowerCase().endsWith("txt")) {	
						try {
							gradeList.clear();
							FileReader fr = new FileReader(selectedFile);
							BufferedReader br = new BufferedReader(fr);
							String in;
							while ((in = br.readLine()) != null) {
								gradeList.add(in);
								sortedGradeList.add(in);
							}
							br.close();
							Collections.sort(sortedGradeList, Collections.reverseOrder());
							String temp = "";
							for (int i = 0; i < gradeList.size(); i++) {
								temp += gradeList.get(i) + "\n";
								
							}
							editorPaneT.setText(temp);
	
							lblHighDynamic_1.setText(sortedGradeList.get(0));
							lblLowDynamic_1.setText(sortedGradeList.get(sortedGradeList.size()-1));
							double avgTemp = 0;
							for(int i = 0; i < sortedGradeList.size(); i++) {
								avgTemp += Double.parseDouble(sortedGradeList.get(i));
							}
							avgTemp = avgTemp / sortedGradeList.size();
							DecimalFormat f = new DecimalFormat("##.00");
							lblAverageDynamic_1.setText(f.format(avgTemp));
							lblMedianDynamic_1.setText(sortedGradeList.get((int)Math.ceil(sortedGradeList.size()/2)-1));
							
							lblBottom20Dynamic.setText(sortedGradeList.get((int)Math.ceil(0.8 * sortedGradeList.size())-1));  //percentiles are reversed because of a reverse sort
							lblMiddle70Dynamic.setText(sortedGradeList.get((int)Math.ceil(0.3 * sortedGradeList.size())-1));
							lblTop10Dynamic.setText(sortedGradeList.get((int)Math.ceil(0.1 * sortedGradeList.size())-1));
							
							String temp1 = "";
							distA = 0;
							distB = 0;
							distC = 0;
							distD = 0;
							distE = 0;
							for (int i = 0; i < sortedGradeList.size(); i++) {
								float intVal = 100*(Float.parseFloat(sortedGradeList.get(i))+min)/max;	//grade-.5 to account for rounding
								if (intVal >= gradeA - .5) {
									temp1 += "A\n";
									distA++;
								}
								else if (intVal >= gradeB - .5) {
									temp1 += "B\n";
									distB++;
								}
								else if (intVal >= gradeC - .5) {
									temp1 += "C\n";
									distC++;
								}
								else if (intVal >= gradeD - .5) {
									temp1 += "D\n";
									distD++;
								}
								else {
									temp1 += "E\n";
									distE++;
								}
							}
							textPane.setText(temp1);
							label.setText("" + distA);
							label_1.setText("" + distB);
							label_2.setText("" + distC);
							label_3.setText("" + distD);
							label_4.setText("" + distE);
							
						}
						catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(frmGradebook, "Imported text document (" + selectedFile.getPath() + ") not formatted correctly.", "Error", JOptionPane.WARNING_MESSAGE);
						}
						
						catch (Exception eee) {
							eee.printStackTrace();
						}
					}
					else {
						JOptionPane.showMessageDialog(frmGradebook, "Incorrect file type.", "Error", JOptionPane.WARNING_MESSAGE);
					}
				}
				
			}
				
		});
	
		btnSaveGradesTo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (filePath == null) {
					JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
					int retrieval = jfc.showSaveDialog(null);
					if (retrieval == JFileChooser.APPROVE_OPTION) {
						filePath = jfc.getSelectedFile().getAbsolutePath();
					}
				}
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
					gradeList.clear();
					sortedGradeList.clear();
					String temp1 = "";
					temp1 = editorPaneT.getText();
					Scanner scan = new Scanner(temp1);
					while (scan.hasNext()) {
						gradeList.add(scan.next());
						sortedGradeList.add(scan.next());
					}
					scan.close();
					Collections.sort(sortedGradeList, Collections.reverseOrder());
					String temp = "";
					for (int i = 0; i < gradeList.size(); i++) {
						temp += gradeList.get(i) + "\n";
					}	
					editorPaneT.setText(temp);						
					
					
					lblHighDynamic_1.setText(sortedGradeList.get(0));
					lblLowDynamic_1.setText(sortedGradeList.get(sortedGradeList.size()-1));
					double avgTemp = 0;
					for(int i = 0; i < sortedGradeList.size(); i++) {
						avgTemp += Double.parseDouble(sortedGradeList.get(i));
					}
					avgTemp = avgTemp / sortedGradeList.size();
					DecimalFormat f = new DecimalFormat("##.00");
					lblAverageDynamic_1.setText(f.format(avgTemp));
					lblMedianDynamic_1.setText(sortedGradeList.get((int)Math.ceil(sortedGradeList.size()/2)-1));
					
					lblBottom20Dynamic.setText(sortedGradeList.get((int)Math.ceil(0.8 * sortedGradeList.size())-1));  //percentiles are reversed because of a reverse sort
					lblMiddle70Dynamic.setText(sortedGradeList.get((int)Math.ceil(0.3 * sortedGradeList.size())-1));
					lblTop10Dynamic.setText(sortedGradeList.get((int)Math.ceil(0.1 * sortedGradeList.size())-1));
					
					for (int i = 0; i < gradeList.size(); i++) {
						bw.write(gradeList.get(i));
						bw.newLine();
					}
					bw.close();
					temp1 = "";
					distA = 0;
					distB = 0;
					distC = 0;
					distD = 0;
					distE = 0;
					for (int i = 0; i < sortedGradeList.size(); i++) {
						float intVal = 100*(Float.parseFloat(sortedGradeList.get(i))+min)/max;	//grade-.5 to account for rounding
						if (intVal >= gradeA - .5) {
							temp1 += "A\n";
							distA++;
						}
						else if (intVal >= gradeB - .5) {
							temp1 += "B\n";
							distB++;
						}
						else if (intVal >= gradeC - .5) {
							temp1 += "C\n";
							distC++;
						}
						else if (intVal >= gradeD - .5) {
							temp1 += "D\n";
							distD++;
						}
						else {
							temp1 += "E\n";
							distE++;
						}
					}
					textPane.setText(temp1);
					label.setText("" + distA);
					label_1.setText("" + distB);
					label_2.setText("" + distC);
					label_3.setText("" + distD);
					label_4.setText("" + distE);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		btnChange_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					gradeA = Float.parseFloat(JOptionPane.showInputDialog("Enter minimum grade for A:"));
					gradeB = Float.parseFloat(JOptionPane.showInputDialog("Enter minimum grade for B:"));
					gradeC = Float.parseFloat(JOptionPane.showInputDialog("Enter minimum grade for C:"));
					gradeD = Float.parseFloat(JOptionPane.showInputDialog("Enter minimum grade for D:"));
					
					String temp1 = "";
					distA = 0;
					distB = 0;
					distC = 0;
					distD = 0;
					distE = 0;
					for (int i = 0; i < sortedGradeList.size(); i++) {
						float intVal = 100*(Float.parseFloat(sortedGradeList.get(i))+min)/max;	//grade-.5 to account for rounding
						if (intVal >= gradeA - .5) {
							temp1 += "A\n";
							distA++;
						}
						else if (intVal >= gradeB - .5) {
							temp1 += "B\n";
							distB++;
						}
						else if (intVal >= gradeC - .5) {
							temp1 += "C\n";
							distC++;
						}
						else if (intVal >= gradeD - .5) {
							temp1 += "D\n";
							distD++;
						}
						else {
							temp1 += "E\n";
							distE++;
						}
					}
					textPane.setText(temp1);
					label.setText("" + distA);
					label_1.setText("" + distB);
					label_2.setText("" + distC);
					label_3.setText("" + distD);
					label_4.setText("" + distE);
					
				} catch(Exception ee) {
					ee.printStackTrace();
				}
			}
				
		});
		
		btnSetMinmax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int tMin = Integer.parseInt(JOptionPane.showInputDialog("Enter minimum score:"));
					int tMax = Integer.parseInt(JOptionPane.showInputDialog("Enter maximum score:"));
					if (tMin < tMax && tMin >= 0) {
						min = tMin;
						max = tMax;
						gradeE = min;
					}
					else {
						JOptionPane.showMessageDialog(frmGradebook, "Incorrect Minimum / Maximum Scores.", "Error", JOptionPane.WARNING_MESSAGE);
					}
					
					
					String temp1 = "";
					distA = 0;
					distB = 0;
					distC = 0;
					distD = 0;
					distE = 0;
					for (int i = 0; i < sortedGradeList.size(); i++) {
						float intVal = 100*(Float.parseFloat(sortedGradeList.get(i))+min)/max;	//grade-.5 to account for rounding
						if (intVal >= gradeA - .5) {
							temp1 += "A\n";
							distA++;
						}
						else if (intVal >= gradeB - .5) {
							temp1 += "B\n";
							distB++;
						}
						else if (intVal >= gradeC - .5) {
							temp1 += "C\n";
							distC++;
						}
						else if (intVal >= gradeD - .5) {
							temp1 += "D\n";
							distD++;
						}
						else {
							temp1 += "E\n";
							distE++;
						}
					}
					textPane.setText(temp1);
					label.setText("" + distA);
					label_1.setText("" + distB);
					label_2.setText("" + distC);
					label_3.setText("" + distD);
					label_4.setText("" + distE);
					
				} catch (Exception exx) {
					exx.printStackTrace();
				}
			}
				
		});
		
		btnPrintReport_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				int retrieval = jfc.showSaveDialog(null);
				if (retrieval == JFileChooser.APPROVE_OPTION) {
					if (gradeList.size() != 0) {
						try {
							BufferedWriter bw = new BufferedWriter(new FileWriter(jfc.getSelectedFile() + ".txt"));
							
							String out = "";
							out = 
									"GRADES\n" +
									"----------------------\n";
							for (String s : gradeList) {
								out += s + "\n";
							}
							out += 
									"\nSTATISTICS\n" + 
									"----------------------\n" + 
									"HIGH = " + lblHighDynamic_1.getText() +
									"\nLOW = " + lblLowDynamic_1.getText() +
									"\nAVERAGE = " + lblAverageDynamic_1.getText() +
									"\nMEDIAN = " + lblMedianDynamic_1.getText() + 
									"\n\nDISTRIBUTION\n" + 
									"----------------------\n" +
									"A\t|\t" + distA + 
									"\nB\t|\t" + distB + 
									"\nC\t|\t" + distC + 
									"\nD\t|\t" + distD +
									"\nE\t|\t" + distE + 
									"\n\n20th Percentile: " + lblBottom20Dynamic.getText() +
									"\n70th Percentile: " + lblMiddle70Dynamic.getText() + 
									"\n90th Percentile: " + lblTop10Dynamic.getText();
							
							bw.write(out);
							bw.close();
							
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
					//changing to 'error' messsage
					else JOptionPane.showMessageDialog(frmGradebook, "No grades have been imported.", "Error", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		
		
		frmGradebook.setBounds(100, 100, 784, 464);
		frmGradebook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
