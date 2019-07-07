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
	
		
		//initialize global text editor window
		JEditorPane editorPaneT = new JEditorPane();
		JScrollPane editorPane = new JScrollPane(editorPaneT);
		
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
			//average grade result label
				JLabel lblAverageDynamic = new JLabel("");
				lblAverageDynamic.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblAverageDynamic = new GridBagConstraints();
				gbc_lblAverageDynamic.insets = new Insets(0, 0, 5, 5);
				gbc_lblAverageDynamic.gridx = 0;
				gbc_lblAverageDynamic.gridy = 0;
				frmGradebook.getContentPane().add(lblAverageDynamic, gbc_lblAverageDynamic);
	
			//low score result label 
				JLabel lblLowDynamic = new JLabel("");
				lblLowDynamic.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblLowDynamic = new GridBagConstraints();
				gbc_lblLowDynamic.insets = new Insets(0, 0, 5, 5);
				gbc_lblLowDynamic.gridx = 0;
				gbc_lblLowDynamic.gridy = 0;
				frmGradebook.getContentPane().add(lblLowDynamic, gbc_lblLowDynamic);
				
			//high score result label 
				JLabel lblHighDynamic = new JLabel("");
				lblHighDynamic.setBackground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblHighDynamic = new GridBagConstraints();
				gbc_lblHighDynamic.insets = new Insets(0, 0, 5, 5);
				gbc_lblHighDynamic.gridx = 0;
				gbc_lblHighDynamic.gridy = 0;
				frmGradebook.getContentPane().add(lblHighDynamic, gbc_lblHighDynamic);
			
			//median grade result label
				JLabel lblMedianDynamic = new JLabel("");
				lblMedianDynamic.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblMedianDynamic = new GridBagConstraints();
				gbc_lblMedianDynamic.insets = new Insets(0, 0, 5, 5);
				gbc_lblMedianDynamic.gridx = 0;
				gbc_lblMedianDynamic.gridy = 0;
				frmGradebook.getContentPane().add(lblMedianDynamic, gbc_lblMedianDynamic);
			
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
	
			//'high' label
				JLabel lblHigh = new JLabel("HIGH");
				lblHigh.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblHigh = new GridBagConstraints();
				gbc_lblHigh.insets = new Insets(0, 0, 5, 5);
				gbc_lblHigh.gridx = 1;
				gbc_lblHigh.gridy = 2;
				frmGradebook.getContentPane().add(lblHigh, gbc_lblHigh);
	
			//'high' result label to 0 
				JLabel lblHighDynamic_1 = new JLabel("0");
				lblHighDynamic_1.setForeground(Color.WHITE);
				GridBagConstraints gbc_lblHighDynamic_1 = new GridBagConstraints();
				gbc_lblHighDynamic_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblHighDynamic_1.gridx = 3;
				gbc_lblHighDynamic_1.gridy = 2;
				frmGradebook.getContentPane().add(lblHighDynamic_1, gbc_lblHighDynamic_1);
	
			//initialize 'low' label
				JLabel lblLow = new JLabel("LOW");
				lblLow.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblLow = new GridBagConstraints();
				gbc_lblLow.anchor = GridBagConstraints.NORTH;
				gbc_lblLow.insets = new Insets(0, 0, 5, 5);
				gbc_lblLow.gridx = 1;
				gbc_lblLow.gridy = 3;
				frmGradebook.getContentPane().add(lblLow, gbc_lblLow);
	
			//initialize 'low' display result to 0
				JLabel lblLowDynamic_1 = new JLabel("0");
				lblLowDynamic_1.setForeground(Color.WHITE);
				GridBagConstraints gbc_lblLowDynamic_1 = new GridBagConstraints();
				gbc_lblLowDynamic_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblLowDynamic_1.gridx = 3;
				gbc_lblLowDynamic_1.gridy = 3;
				frmGradebook.getContentPane().add(lblLowDynamic_1, gbc_lblLowDynamic_1);
	
			//initialize average label
				JLabel lblAverage = new JLabel("AVERAGE");
				lblAverage.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblAverage = new GridBagConstraints();
				gbc_lblAverage.insets = new Insets(0, 0, 5, 5);
				gbc_lblAverage.gridx = 1;
				gbc_lblAverage.gridy = 4;
				frmGradebook.getContentPane().add(lblAverage, gbc_lblAverage);
	
			//initialize 'average' display result to 0
				JLabel lblAverageDynamic_1 = new JLabel("0");
				lblAverageDynamic_1.setForeground(Color.WHITE);
				GridBagConstraints gbc_lblAverageDynamic_1 = new GridBagConstraints();
				gbc_lblAverageDynamic_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblAverageDynamic_1.gridx = 3;
				gbc_lblAverageDynamic_1.gridy = 4;
				frmGradebook.getContentPane().add(lblAverageDynamic_1, gbc_lblAverageDynamic_1);
	
			//initialize median label
				JLabel lblMedian = new JLabel("MEDIAN");
				lblMedian.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblMedian = new GridBagConstraints();
				gbc_lblMedian.insets = new Insets(0, 0, 5, 5);
				gbc_lblMedian.gridx = 1;
				gbc_lblMedian.gridy = 5;
				frmGradebook.getContentPane().add(lblMedian, gbc_lblMedian);
	
			//initialize 'median' display result to 0
				JLabel lblMedianDynamic_1 = new JLabel("0");
				lblMedianDynamic_1.setForeground(Color.WHITE);
				GridBagConstraints gbc_lblMedianDynamic_1 = new GridBagConstraints();
				gbc_lblMedianDynamic_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblMedianDynamic_1.gridx = 3;
				gbc_lblMedianDynamic_1.gridy = 5;
				frmGradebook.getContentPane().add(lblMedianDynamic_1, gbc_lblMedianDynamic_1);
	
			//initialize grade distribution label
				JLabel lblDistribution = new JLabel("DISTRIBUTION");
				lblDistribution.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblDistribution = new GridBagConstraints();
				gbc_lblDistribution.insets = new Insets(0, 0, 5, 5);
				gbc_lblDistribution.gridx = 1;
				gbc_lblDistribution.gridy = 7;
				frmGradebook.getContentPane().add(lblDistribution, gbc_lblDistribution);
				
			//initialize 'A' grade label
				JLabel lblA = new JLabel("A");
				lblA.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblA = new GridBagConstraints();
				gbc_lblA.insets = new Insets(0, 0, 5, 5);
				gbc_lblA.gridx = 1;
				gbc_lblA.gridy = 8;
				frmGradebook.getContentPane().add(lblA, gbc_lblA);
	
			//initialize 'number of A's' result display label to 0
				JLabel label = new JLabel("0");
				label.setForeground(Color.WHITE);
				GridBagConstraints gbc_lblTest = new GridBagConstraints();
				gbc_lblTest.insets = new Insets(0, 0, 5, 5);
				gbc_lblTest.gridx = 2;
				gbc_lblTest.gridy = 8;
				frmGradebook.getContentPane().add(label, gbc_lblTest);
	
			//initialize 'B' grade label
				JLabel lblB = new JLabel("B");
				lblB.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblB = new GridBagConstraints();
				gbc_lblB.insets = new Insets(0, 0, 5, 5);
				gbc_lblB.gridx = 1;
				gbc_lblB.gridy = 9;
				frmGradebook.getContentPane().add(lblB, gbc_lblB);
	
			//initialize 'number of B's' result display label to 0
				JLabel label_1 = new JLabel("0");
				label_1.setForeground(Color.WHITE);
				GridBagConstraints gbc_lblTest_1 = new GridBagConstraints();
				gbc_lblTest_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblTest_1.gridx = 2;
				gbc_lblTest_1.gridy = 9;
				frmGradebook.getContentPane().add(label_1, gbc_lblTest_1);
	
			//initialize 'C' grade label
				JLabel lblC = new JLabel("C");
				lblC.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblC = new GridBagConstraints();
				gbc_lblC.insets = new Insets(0, 0, 5, 5);
				gbc_lblC.gridx = 1;
				gbc_lblC.gridy = 10;
				frmGradebook.getContentPane().add(lblC, gbc_lblC);
	
			//initialize 'number of C's' result display label to 0
				JLabel label_2 = new JLabel("0");
				label_2.setForeground(Color.WHITE);
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = 2;
				gbc_label.gridy = 10;
				frmGradebook.getContentPane().add(label_2, gbc_label);
	
			//initialize 'D' grade label
				JLabel lblD = new JLabel("D");
				lblD.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblD = new GridBagConstraints();
				gbc_lblD.insets = new Insets(0, 0, 5, 5);
				gbc_lblD.gridx = 1;
				gbc_lblD.gridy = 11;
				frmGradebook.getContentPane().add(lblD, gbc_lblD);
	
			//initialize 'number of D's' result display label to 0
				JLabel label_3 = new JLabel("0");
				label_3.setForeground(Color.WHITE);
				GridBagConstraints gbc_label_1 = new GridBagConstraints();
				gbc_label_1.insets = new Insets(0, 0, 5, 5);
				gbc_label_1.gridx = 2;
				gbc_label_1.gridy = 11;
				frmGradebook.getContentPane().add(label_3, gbc_label_1);
	
			//initialize 'E' grade label
				JLabel lblE = new JLabel("E");
				lblE.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblE = new GridBagConstraints();
				gbc_lblE.insets = new Insets(0, 0, 5, 5);
				gbc_lblE.gridx = 1;
				gbc_lblE.gridy = 12;
				frmGradebook.getContentPane().add(lblE, gbc_lblE);

			//initialize 'number of E's' result display label
				JLabel label_4 = new JLabel("0");
				label_4.setForeground(Color.WHITE);
				GridBagConstraints gbc_label_2 = new GridBagConstraints();
				gbc_label_2.insets = new Insets(0, 0, 5, 5);
				gbc_label_2.gridx = 2;
				gbc_label_2.gridy = 12;
				frmGradebook.getContentPane().add(label_4, gbc_label_2);
	
			//initialize 'percentile' label
				JLabel lblPercentile = new JLabel("PERCENTILE");
				lblPercentile.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblPercentile = new GridBagConstraints();
				gbc_lblPercentile.insets = new Insets(0, 0, 5, 5);
				gbc_lblPercentile.gridx = 1;
				gbc_lblPercentile.gridy = 14;
				frmGradebook.getContentPane().add(lblPercentile, gbc_lblPercentile);
	
			//initialize '20th percentile' label
				JLabel lblBottom = new JLabel("20th Percentile");
				lblBottom.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblBottom = new GridBagConstraints();
				gbc_lblBottom.insets = new Insets(0, 0, 5, 5);
				gbc_lblBottom.gridx = 1;
				gbc_lblBottom.gridy = 15;
				frmGradebook.getContentPane().add(lblBottom, gbc_lblBottom);
	
			//initialize '70th percentile' label
				JLabel lblMiddle = new JLabel("70th Percentile");
				lblMiddle.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblMiddle = new GridBagConstraints();
				gbc_lblMiddle.insets = new Insets(0, 0, 5, 5);
				gbc_lblMiddle.gridx = 4;
				gbc_lblMiddle.gridy = 15;
				frmGradebook.getContentPane().add(lblMiddle, gbc_lblMiddle);

			//initialize '90th percentile' label
				JLabel lblTop = new JLabel("90th Percentile");
				lblTop.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblTop = new GridBagConstraints();
				gbc_lblTop.insets = new Insets(0, 0, 5, 5);
				gbc_lblTop.gridx = 5;
				gbc_lblTop.gridy = 15;
				frmGradebook.getContentPane().add(lblTop, gbc_lblTop);

			//initialize 20th percentile result display label
				JLabel lblBottom20Dynamic = new JLabel(" ");
				lblBottom20Dynamic.setBackground(Color.WHITE);
				lblBottom20Dynamic.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblBottom20Dynamic = new GridBagConstraints();
				gbc_lblBottom20Dynamic.insets = new Insets(0, 0, 0, 5);
				gbc_lblBottom20Dynamic.gridx = 1;
				gbc_lblBottom20Dynamic.gridy = 16;
				frmGradebook.getContentPane().add(lblBottom20Dynamic, gbc_lblBottom20Dynamic);

			//initialize 70th percentile result display label
				JLabel lblMiddle70Dynamic = new JLabel(" ");
				lblMiddle70Dynamic.setBackground(Color.WHITE);
				lblMiddle70Dynamic.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblMiddle70Dynamic = new GridBagConstraints();
				gbc_lblMiddle70Dynamic.insets = new Insets(0, 0, 0, 5);
				gbc_lblMiddle70Dynamic.gridx = 4;
				gbc_lblMiddle70Dynamic.gridy = 16;
				frmGradebook.getContentPane().add(lblMiddle70Dynamic, gbc_lblMiddle70Dynamic);
	
			//initialize 90th percentile result display label
				JLabel lblTop10Dynamic = new JLabel(" ");
				lblTop10Dynamic.setBackground(Color.WHITE);
				lblTop10Dynamic.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblTop10Dynamic = new GridBagConstraints();
				gbc_lblTop10Dynamic.insets = new Insets(0, 0, 0, 5);
				gbc_lblTop10Dynamic.gridx = 5;
				gbc_lblTop10Dynamic.gridy = 16;
				frmGradebook.getContentPane().add(lblTop10Dynamic, gbc_lblTop10Dynamic);
		}//initialize labels method

		private void initializeButtons() {
			
			//upload grades button
			btnUploadGrades();
			
			//change grade range button
			JButton btnChange_1 = new JButton("CHANGE GRADE RANGE");
			btnChange_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			GridBagConstraints gbc_btnChange_1 = new GridBagConstraints();
			gbc_btnChange_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnChange_1.insets = new Insets(0, 0, 5, 5);
			gbc_btnChange_1.gridx = 4;
			gbc_btnChange_1.gridy = 7;
			frmGradebook.getContentPane().add(btnChange_1, gbc_btnChange_1);
			
			//initialize print report button
			JButton btnPrintReport_1 = new JButton("PRINT REPORT");
			GridBagConstraints gbc_btnPrintReport_1 = new GridBagConstraints();
			gbc_btnPrintReport_1.insets = new Insets(0, 0, 5, 5);
			gbc_btnPrintReport_1.gridx = 4;
			gbc_btnPrintReport_1.gridy = 1;
			frmGradebook.getContentPane().add(btnPrintReport_1, gbc_btnPrintReport_1);
			
			//initialize 'set minimum and maximum' button
			JButton btnSetMinmax = new JButton("SET MIN/MAX");
			btnSetMinmax.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			GridBagConstraints gbc_btnSetMinmax = new GridBagConstraints();
			gbc_btnSetMinmax.insets = new Insets(0, 0, 5, 5);
			gbc_btnSetMinmax.gridx = 5;
			gbc_btnSetMinmax.gridy = 14;
			frmGradebook.getContentPane().add(btnSetMinmax, gbc_btnSetMinmax);

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
						            grades.add(scan.nextDouble()); //add each grade to the ArrayList grades
						        }
						        
						        gradesString = gradesToString(grades); //set grades string
						        editorPaneT.setText(gradesString);
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

		public void initializePanes() {
			//initialize 'letter grades' display text window
			JTextPane textPane = new JTextPane(); 
			JScrollPane textPaneT = new JScrollPane(textPane);
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
}//gui class 	
	
	
