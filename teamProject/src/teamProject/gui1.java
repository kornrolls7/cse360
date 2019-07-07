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
		//initialize global variables
		List<Double> grades = new ArrayList<>(); 
		String gradesString = "";
		int minGrade = 0, maxGrade = 100;
		double high = 0, low = 0, average = 0, median = 0;
		double minA = 90, minB = 80, minC = 70, minD = 60;
		
		//initialize global text editor window
		JEditorPane editorPaneT = new JEditorPane();
		JScrollPane editorPane = new JScrollPane(editorPaneT);
		
		//initialize 'letter grades' display text window
		JTextPane textPane = new JTextPane(); 
		JScrollPane textPaneT = new JScrollPane(textPane);
		
		//initialize global labels
		JLabel lblHighResult = new JLabel("0");
		JLabel lblLowResult = new JLabel("0");
		JLabel lblAverageResult = new JLabel("0");
		JLabel lblMedianResult = new JLabel("0");
		JLabel lblAResult = new JLabel("0");
		JLabel lblBResult = new JLabel("0");
		JLabel lblCResult = new JLabel("0");
		JLabel lblDResult = new JLabel("0");
		JLabel lblEResult = new JLabel("0");
		JLabel lbl20thResult = new JLabel(" ");
		JLabel lbl70thResult = new JLabel(" ");
		JLabel lbl90thResult = new JLabel(" ");
		//initialize private variables
		private JFrame frmGradebook; //initialize grading application 
		private String filePath = null; 
		
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
					
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						gui1 window = new gui1();
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
			//initialize gui contents
			initialize();
		}
			
		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			initializeFrame();
			initializeLabels();
			initializeButtons();
			initializePanes();
		}//initialize() method	

		private void initializeFrame() {
			//initialize 'grading application' window
			frmGradebook = new JFrame();
			frmGradebook.getContentPane().setForeground(Color.WHITE);
			frmGradebook.setBounds(100, 100, 784, 464);
			frmGradebook.setTitle("GRADEBOOK"); //title of application
			frmGradebook.setBackground(new Color(0, 51, 102));
			frmGradebook.getContentPane().setBackground(new Color(30, 144, 255));
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[]{1, 94, 19, 43, 153, 131, 35, 103, 0};
			gridBagLayout.rowHeights = new int[]{1, 23, 14, 14, 14, 14, 35, 23, 14, 14, 14, 14, 14, 35, 23, 14, 14, 0};
			gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
			gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			frmGradebook.getContentPane().setLayout(gridBagLayout);
		}

		private void initializeLabels() {
			//'high' label
				JLabel lblHigh = new JLabel("HIGH");
				lblHigh.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblHigh = new GridBagConstraints();
				gbc_lblHigh.insets = new Insets(0, 0, 5, 5);
				gbc_lblHigh.gridx = 1;
				gbc_lblHigh.gridy = 2;
				frmGradebook.getContentPane().add(lblHigh, gbc_lblHigh);

			//'high' result label to 0 
				lblHighResult.setForeground(Color.WHITE);
				GridBagConstraints gbcHighResult = new GridBagConstraints();
				gbcHighResult.insets = new Insets(0, 0, 5, 5);
				gbcHighResult.gridx = 3;
				gbcHighResult.gridy = 2;
				frmGradebook.getContentPane().add(lblHighResult, gbcHighResult);
			
			//'low' label
				JLabel lblLow = new JLabel("LOW");
				lblLow.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblLow = new GridBagConstraints();
				gbc_lblLow.anchor = GridBagConstraints.NORTH;
				gbc_lblLow.insets = new Insets(0, 0, 5, 5);
				gbc_lblLow.gridx = 1;
				gbc_lblLow.gridy = 3;
				frmGradebook.getContentPane().add(lblLow, gbc_lblLow);
	
			//'low' result label to 0
				lblLowResult.setForeground(Color.WHITE);
				GridBagConstraints gbcLowResult = new GridBagConstraints();
				gbcLowResult.insets = new Insets(0, 0, 5, 5);
				gbcLowResult.gridx = 3;
				gbcLowResult.gridy = 3;
				frmGradebook.getContentPane().add(lblLowResult, gbcLowResult);
			
			//'average' label
				JLabel lblAverage = new JLabel("AVERAGE");
				lblAverage.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblAverage = new GridBagConstraints();
				gbc_lblAverage.insets = new Insets(0, 0, 5, 5);
				gbc_lblAverage.gridx = 1;
				gbc_lblAverage.gridy = 4;
				frmGradebook.getContentPane().add(lblAverage, gbc_lblAverage);
				
			//'average' result label to 0
				lblAverageResult.setForeground(Color.WHITE);
				GridBagConstraints gbcAverageResult = new GridBagConstraints();
				gbcAverageResult.insets = new Insets(0, 0, 5, 5);
				gbcAverageResult.gridx = 3;
				gbcAverageResult.gridy = 4;
				frmGradebook.getContentPane().add(lblAverageResult, gbcAverageResult);
			
			//'median' label
				JLabel lblMedian = new JLabel("MEDIAN");
				lblMedian.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblMedian = new GridBagConstraints();
				gbc_lblMedian.insets = new Insets(0, 0, 5, 5);
				gbc_lblMedian.gridx = 1;
				gbc_lblMedian.gridy = 5;
				frmGradebook.getContentPane().add(lblMedian, gbc_lblMedian);
	
			//'median' result label
				lblMedianResult.setForeground(Color.WHITE);
				GridBagConstraints gbc_lblMedianDynamic_1 = new GridBagConstraints();
				gbc_lblMedianDynamic_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblMedianDynamic_1.gridx = 3;
				gbc_lblMedianDynamic_1.gridy = 5;
				frmGradebook.getContentPane().add(lblMedianResult, gbc_lblMedianDynamic_1);
				
			//'letter grades' label
				JLabel lblLetterGrades = new JLabel("LETTER GRADES");
				lblLetterGrades.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblLetterGrades = new GridBagConstraints();
				gbc_lblLetterGrades.anchor = GridBagConstraints.SOUTH;
				gbc_lblLetterGrades.insets = new Insets(0, 0, 5, 5);
				gbc_lblLetterGrades.gridx = 5;
				gbc_lblLetterGrades.gridy = 1;
				frmGradebook.getContentPane().add(lblLetterGrades, gbc_lblLetterGrades);
	
			//'grades' label
				JLabel lblGrades = new JLabel("GRADES");
				lblGrades.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblGrades = new GridBagConstraints();
				gbc_lblGrades.anchor = GridBagConstraints.SOUTH;
				gbc_lblGrades.insets = new Insets(0, 0, 5, 5);
				gbc_lblGrades.gridx = 7;
				gbc_lblGrades.gridy = 1;
				frmGradebook.getContentPane().add(lblGrades, gbc_lblGrades);
			
			//grade distribution label
				JLabel lblDistribution = new JLabel("DISTRIBUTION");
				lblDistribution.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblDistribution = new GridBagConstraints();
				gbc_lblDistribution.insets = new Insets(0, 0, 5, 5);
				gbc_lblDistribution.gridx = 1;
				gbc_lblDistribution.gridy = 7;
				frmGradebook.getContentPane().add(lblDistribution, gbc_lblDistribution);
				
			//'A' grade label
				JLabel lblA = new JLabel("A");
				lblA.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblA = new GridBagConstraints();
				gbc_lblA.insets = new Insets(0, 0, 5, 5);
				gbc_lblA.gridx = 1;
				gbc_lblA.gridy = 8;
				frmGradebook.getContentPane().add(lblA, gbc_lblA);
	
			//'number of A's' result display label
				lblAResult.setForeground(Color.WHITE);
				GridBagConstraints gbc_lblTest = new GridBagConstraints();
				gbc_lblTest.insets = new Insets(0, 0, 5, 5);
				gbc_lblTest.gridx = 2;
				gbc_lblTest.gridy = 8;
				frmGradebook.getContentPane().add(lblAResult, gbc_lblTest);
				
			//'B' grade label
				JLabel lblB = new JLabel("B");
				lblB.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblB = new GridBagConstraints();
				gbc_lblB.insets = new Insets(0, 0, 5, 5);
				gbc_lblB.gridx = 1;
				gbc_lblB.gridy = 9;
				frmGradebook.getContentPane().add(lblB, gbc_lblB);
	
			//'number of B's' result display label
				lblBResult.setForeground(Color.WHITE);
				GridBagConstraints gbc_lblTest_1 = new GridBagConstraints();
				gbc_lblTest_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblTest_1.gridx = 2;
				gbc_lblTest_1.gridy = 9;
				frmGradebook.getContentPane().add(lblBResult, gbc_lblTest_1);
	
			//'C' grade label
				JLabel lblC = new JLabel("C");
				lblC.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblC = new GridBagConstraints();
				gbc_lblC.insets = new Insets(0, 0, 5, 5);
				gbc_lblC.gridx = 1;
				gbc_lblC.gridy = 10;
				frmGradebook.getContentPane().add(lblC, gbc_lblC);
	
			//'number of C's' result display label 
				lblCResult.setForeground(Color.WHITE);
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = 2;
				gbc_label.gridy = 10;
				frmGradebook.getContentPane().add(lblCResult, gbc_label);
	
			// 'D' grade label
				JLabel lblD = new JLabel("D");
				lblD.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblD = new GridBagConstraints();
				gbc_lblD.insets = new Insets(0, 0, 5, 5);
				gbc_lblD.gridx = 1;
				gbc_lblD.gridy = 11;
				frmGradebook.getContentPane().add(lblD, gbc_lblD);
	
			//'number of D's' result display label
				lblDResult.setForeground(Color.WHITE);
				GridBagConstraints gbc_label_1 = new GridBagConstraints();
				gbc_label_1.insets = new Insets(0, 0, 5, 5);
				gbc_label_1.gridx = 2;
				gbc_label_1.gridy = 11;
				frmGradebook.getContentPane().add(lblDResult, gbc_label_1);
	
			//'E' grade label
				JLabel lblE = new JLabel("E");
				lblE.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblE = new GridBagConstraints();
				gbc_lblE.insets = new Insets(0, 0, 5, 5);
				gbc_lblE.gridx = 1;
				gbc_lblE.gridy = 12;
				frmGradebook.getContentPane().add(lblE, gbc_lblE);

			//'number of E's' result display label
				lblEResult.setForeground(Color.WHITE);
				GridBagConstraints gbc_label_2 = new GridBagConstraints();
				gbc_label_2.insets = new Insets(0, 0, 5, 5);
				gbc_label_2.gridx = 2;
				gbc_label_2.gridy = 12;
				frmGradebook.getContentPane().add(lblEResult, gbc_label_2);
	
			//'percentile' label
				JLabel lblPercentile = new JLabel("PERCENTILE");
				lblPercentile.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblPercentile = new GridBagConstraints();
				gbc_lblPercentile.insets = new Insets(0, 0, 5, 5);
				gbc_lblPercentile.gridx = 1;
				gbc_lblPercentile.gridy = 14;
				frmGradebook.getContentPane().add(lblPercentile, gbc_lblPercentile);
	
			//'20th percentile' label
				JLabel lbl20th = new JLabel("20th Percentile");
				lbl20th.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblBottom = new GridBagConstraints();
				gbc_lblBottom.insets = new Insets(0, 0, 5, 5);
				gbc_lblBottom.gridx = 1;
				gbc_lblBottom.gridy = 15;
				frmGradebook.getContentPane().add(lbl20th, gbc_lblBottom);
	
			//'70th percentile' label
				JLabel lbl70th = new JLabel("70th Percentile");
				lbl70th.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblMiddle = new GridBagConstraints();
				gbc_lblMiddle.insets = new Insets(0, 0, 5, 5);
				gbc_lblMiddle.gridx = 4;
				gbc_lblMiddle.gridy = 15;
				frmGradebook.getContentPane().add(lbl70th, gbc_lblMiddle);

			//'90th percentile' label
				JLabel lbl90th = new JLabel("90th Percentile");
				lbl90th.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblTop = new GridBagConstraints();
				gbc_lblTop.insets = new Insets(0, 0, 5, 5);
				gbc_lblTop.gridx = 5;
				gbc_lblTop.gridy = 15;
				frmGradebook.getContentPane().add(lbl90th, gbc_lblTop);

			//20th percentile result display label
				lbl20thResult.setBackground(Color.WHITE);
				lbl20thResult.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblBottom20Dynamic = new GridBagConstraints();
				gbc_lblBottom20Dynamic.insets = new Insets(0, 0, 0, 5);
				gbc_lblBottom20Dynamic.gridx = 1;
				gbc_lblBottom20Dynamic.gridy = 16;
				frmGradebook.getContentPane().add(lbl20thResult, gbc_lblBottom20Dynamic);

			//70th percentile result display label
				lbl70thResult.setBackground(Color.WHITE);
				lbl70thResult.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblMiddle70Dynamic = new GridBagConstraints();
				gbc_lblMiddle70Dynamic.insets = new Insets(0, 0, 0, 5);
				gbc_lblMiddle70Dynamic.gridx = 4;
				gbc_lblMiddle70Dynamic.gridy = 16;
				frmGradebook.getContentPane().add(lbl70thResult, gbc_lblMiddle70Dynamic);
	
			//90th percentile result display label
				lbl90thResult.setBackground(Color.WHITE);
				lbl90thResult.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblTop10Dynamic = new GridBagConstraints();
				gbc_lblTop10Dynamic.insets = new Insets(0, 0, 0, 5);
				gbc_lblTop10Dynamic.gridx = 5;
				gbc_lblTop10Dynamic.gridy = 16;
				frmGradebook.getContentPane().add(lbl90thResult, gbc_lblTop10Dynamic);
		}//initialize labels method

		private void initializeButtons() {
			
			//upload grades button
			btnUploadGrades();
			//change grade range button
			btnChangeGradeRange();
			
			//initialize print report button
			JButton btnPrintReport_1 = new JButton("PRINT REPORT");
			GridBagConstraints gbc_btnPrintReport_1 = new GridBagConstraints();
			gbc_btnPrintReport_1.insets = new Insets(0, 0, 5, 5);
			gbc_btnPrintReport_1.gridx = 4;
			gbc_btnPrintReport_1.gridy = 1;
			frmGradebook.getContentPane().add(btnPrintReport_1, gbc_btnPrintReport_1);
			
			//initialize 'set minimum and maximum' button
			btnSetMinMax();
			//initialize 'update grades' button
			btnUpdateGrades();
		
		}//initialize buttons method

			

			private void btnUploadGrades() {
			//upload grades button 
			JButton btnUploadGrades = new JButton("Upload Grades");
			GridBagConstraints gbcUploadGrades = new GridBagConstraints();
			gbcUploadGrades.insets = new Insets(0, 0, 5, 5);
			gbcUploadGrades.gridwidth = 2;
			gbcUploadGrades.gridx = 0;
			gbcUploadGrades.gridy = 1;
			frmGradebook.getContentPane().add(btnUploadGrades, gbcUploadGrades);
			
			//upload grades action listener
		    btnUploadGrades.addActionListener(new ActionListener(){  
		        public void actionPerformed(ActionEvent e){  
		        	//initialize local variables
		        	double newGrade = 0;
		        	//initialize file chooser
		        	JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
					int returnValue = jfc.showOpenDialog(null);
					
					if (returnValue == JFileChooser.APPROVE_OPTION) {
						File selectedFile = jfc.getSelectedFile();
						filePath = selectedFile.getAbsolutePath();
						if(selectedFile.getName().toLowerCase().endsWith("txt")){
							try {
								Scanner scan = new Scanner(selectedFile);

						        while(scan.hasNextDouble())
						        {
						        	newGrade = scan.nextDouble();
						        	if(newGrade > maxGrade || newGrade < minGrade) { //grade is out of range
						        		JOptionPane.showMessageDialog(frmGradebook, "Imported text document " + selectedFile.getPath() + " contains grade(s) which are\nout of range. Those grades have not been added. Use 'Set Min/Max Grade' button to change grade range.");
						        	}
						        	else {
						        		grades.add(newGrade); //add each grade to the ArrayList grades
						        	}
						        }
						        
						        gradesString = gradesToString(grades); //set grades string
						        editorPaneT.setText(gradesString);
						        analyzeGrades();
							}
							catch (NumberFormatException e1) {
								JOptionPane.showMessageDialog(frmGradebook, "Imported text document (" + selectedFile.getPath() + ") not formatted correctly.");
							}
							catch (Exception eee) {
								eee.printStackTrace();
							}
						}
						else{
							JOptionPane.showMessageDialog(frmGradebook, "Incorrect file type.", "Error", JOptionPane.WARNING_MESSAGE);
						}
					}//if file approved
				}//action performed	
		    });//add upload grades action listener
		}//upload grades button actions

				protected String gradesToString(List<Double> grades) {
			String temp = "";
			for (int i = 0; i < grades.size(); i++) {
				temp += grades.get(i) + "\n";
			}	
			return temp;	
			}

			private void btnUpdateGrades() {
				//initialize updateGrades button
				JButton btnUpdateGrades = new JButton("Update Grades");
				btnUpdateGrades.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
				GridBagConstraints gbcUpdateGrades= new GridBagConstraints();
				gbcUpdateGrades.insets = new Insets(0, 0, 5, 5);
				gbcUpdateGrades.gridx = 7;
				gbcUpdateGrades.gridy = 14;
				frmGradebook.getContentPane().add(btnUpdateGrades, gbcUpdateGrades);
				
				//updateGrades action listener
				btnUpdateGrades.addActionListener(new ActionListener(){  
					
				        public void actionPerformed(ActionEvent e){  
				        	if (filePath == null) { //no grades have been uploaded yet
								JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
								int retrieval = jfc.showSaveDialog(null);
								if (retrieval == JFileChooser.APPROVE_OPTION) {
									filePath = jfc.getSelectedFile().getAbsolutePath();
								}
							}
				        	gradesString = editorPaneT.getText(); //update grades string
				        	grades.clear();
				        	gradesToDouble(gradesString); //update grade array list
				        	saveGrades();
				        	analyzeGrades();
						}//action performed
				    });//add upload grades action listener
			}//btnUpdateGrades method

				protected void gradesToDouble(String gradesString) {
				String temp;
				double grade;
				Scanner scan = new Scanner(gradesString);
				while (scan.hasNext()) {
					temp = scan.next();
					grade = Double.parseDouble(temp);
					grades.add(grade);
				}
			}
				
				protected void saveGrades() {
					String temp = "";
					File saveFile = new File(filePath);
					try {
						//clear the file first
						FileWriter clrFileWriter = new FileWriter(filePath, false); 
						PrintWriter clrPrintWriter = new PrintWriter(clrFileWriter, false);
						clrPrintWriter.flush();
						clrPrintWriter.close();
						clrFileWriter.close();
						
						//save new grades to file
						FileWriter fileWriter = new FileWriter(saveFile);
						for(int index = 0; index < grades.size(); index++) {
							temp = grades.get(index).toString() + "\n";
							fileWriter.write(temp);
							fileWriter.write("\n");
						}
						fileWriter.flush();
						fileWriter.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
			private void btnSetMinMax() {
				//initialize btnSetMinMax
				JButton btnSetMinMax = new JButton("Set Min/Max Grade");
				btnSetMinMax.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
				GridBagConstraints gbc_btnSetMinmax = new GridBagConstraints();
				gbc_btnSetMinmax.insets = new Insets(0, 0, 5, 5);
				gbc_btnSetMinmax.gridx = 5;
				gbc_btnSetMinmax.gridy = 14;
				frmGradebook.getContentPane().add(btnSetMinMax, gbc_btnSetMinmax);
				
				//btnSetMinMax action listener
				btnSetMinMax.addActionListener(new ActionListener(){  
					
			        public void actionPerformed(ActionEvent e){  
			        	try {
							int newMin = Integer.parseInt(JOptionPane.showInputDialog("Enter minimum score:"));
							int newMax = Integer.parseInt(JOptionPane.showInputDialog("Enter maximum score:"));
							if (newMin < newMax && newMin >= 0) {
								minGrade = newMin;
								maxGrade = newMax;
							}
							else {
								JOptionPane.showMessageDialog(frmGradebook, "Minimum grade must be positive and Maximum grade must be larger than Minimum grade.", "Error", JOptionPane.WARNING_MESSAGE);
							}
							
						} catch (Exception exx) {
							exx.printStackTrace();
						}
					}//action performed
			    });//add upload grades action listener			
			}//betSetMinMax() method
		
			private void btnChangeGradeRange() {
				//initialize change grade range button
				JButton btnChangeGrade = new JButton("Change Letter Grade Ranges");
				btnChangeGrade.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
				GridBagConstraints gbc_btnChange_1 = new GridBagConstraints();
				gbc_btnChange_1.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnChange_1.insets = new Insets(0, 0, 5, 5);
				gbc_btnChange_1.gridx = 4;
				gbc_btnChange_1.gridy = 7;
				frmGradebook.getContentPane().add(btnChangeGrade, gbc_btnChange_1);
				
				//btnChangeGradeRange action listener
				btnChangeGrade.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						double newA, newB, newC, newD;
						try {
							newA = Double.parseDouble(JOptionPane.showInputDialog("Enter minimum grade for A:"));
							newB = Double.parseDouble(JOptionPane.showInputDialog("Enter minimum grade for B:"));
							newC = Double.parseDouble(JOptionPane.showInputDialog("Enter minimum grade for C:"));
							newD = Double.parseDouble(JOptionPane.showInputDialog("Enter minimum grade for D:"));
							
							if(newA > newB && newB > newC && newC > newD) {
								minA = newA;
								minB = newB;
								minC = newC;
								minD = newD;
								analyzeGrades();
							}
							else {
								JOptionPane.showMessageDialog(frmGradebook, "Grade ranges must follow the following format: A > B > C > D > E. Please try again.", "Error", JOptionPane.WARNING_MESSAGE);
							}
						} catch(Exception ee) {
							ee.printStackTrace();
						}
					}
					});
			}//btnChangeGradeRange() method
			
		private void initializePanes() {
			textPaneT.setBackground(new Color(30, 144, 255));
			textPane.setBackground(new Color(30, 144, 255));
			GridBagConstraints gbc_textPaneT = new GridBagConstraints();
			gbc_textPaneT.fill = GridBagConstraints.BOTH;
			gbc_textPaneT.insets = new Insets(0, 0, 5, 5);
			gbc_textPaneT.gridheight = 11;
			gbc_textPaneT.gridx = 5;
			gbc_textPaneT.gridy = 2;
			frmGradebook.getContentPane().add(textPaneT, gbc_textPaneT);
			
			editorPane.setBackground(new Color(255, 255, 255));
			GridBagConstraints gbc_editorPane = new GridBagConstraints();
			gbc_editorPane.fill = GridBagConstraints.BOTH;
			gbc_editorPane.insets = new Insets(0, 0, 5, 5);
			gbc_editorPane.gridheight = 11;
			gbc_editorPane.gridx = 7;
			gbc_editorPane.gridy = 2;
			frmGradebook.getContentPane().add(editorPane, gbc_editorPane);
		}
		
		private void analyzeGrades() {
			//initialize local variables
			int numA = 0, numB = 0, numC = 0, numD = 0, numE = 0;
			String gradesRecieved = "";
			//calculate sum of grades
			double sum = 0;
				for (int index = 0; index < grades.size(); index++) {
					sum += grades.get(index);
				}
			
			DecimalFormat decimal = new DecimalFormat("#.##");
			
			//create new list and sort in increasing order
			List<Double> sortedGrades = new ArrayList<>();
			sortedGrades.addAll(grades);
			Collections.sort(sortedGrades);
			
			//calculate and display high result
			high = sortedGrades.get(sortedGrades.size() - 1);
			lblHighResult.setText(decimal.format(high)); 
			//calculate and display low result
			low = sortedGrades.get(0);
			lblLowResult.setText(decimal.format(low)); 
			//calculate and display average result
			average = sum / grades.size();
			lblAverageResult.setText(decimal.format(average));
			//calculate and display median result
			if(sortedGrades.size() % 2 == 0) { //even number of grades
				median = (double)(sortedGrades.get(((grades.size()/2) - 1)) + sortedGrades.get((grades.size() / 2))) / 2.0;
			}
			else {
				median = (double)sortedGrades.get((grades.size() / 2));
			}
			lblMedianResult.setText(decimal.format(median)); 
			
			//calculate grade distributions
			for (int index = 0; index < grades.size(); index++) {
				double currentGrade = grades.get(index); 
				if (currentGrade >= minA - .5) {
					gradesRecieved += "A\n";
					numA++;
				}
				else if (currentGrade >= minB - .5) {
					gradesRecieved += "B\n";
					numB++;
				}
				else if (currentGrade >= minC - .5) {
					gradesRecieved += "C\n";
					numC++;
				}
				else if (currentGrade >= minD - .5) {
					gradesRecieved += "D\n";
					numD++;
				}
				else {
					gradesRecieved += "E\n";
					numE++;
				}
			}
			//display grades recieved
			textPane.setText(gradesRecieved);
			//display number of each grade
			lblAResult.setText(Integer.toString(numA));
			lblBResult.setText(Integer.toString(numB));
			lblCResult.setText(Integer.toString(numC));
			lblDResult.setText(Integer.toString(numD));
			lblEResult.setText(Integer.toString(numE));
			
			//calculate and display percentiles
			lbl20thResult.setText(decimal.format(sortedGrades.get((int)Math.ceil(0.2 * sortedGrades.size())-1))); //20th percentile
			lbl70thResult.setText(decimal.format(sortedGrades.get((int)Math.ceil(0.7 * sortedGrades.size())-1))); //70th percentile
			lbl90thResult.setText(decimal.format(sortedGrades.get((int)Math.ceil(0.9 * sortedGrades.size())-1))); //90th percentile
		}
}//gui class 	
	
	
