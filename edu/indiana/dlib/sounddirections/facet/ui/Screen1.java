/*
The contents of this file are subject to the Indiana University Sound Directions License, Version 1.0 (the "License"); 
you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.dlib.indiana.edu/projects/sounddirections/license/

Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. 
See the License for the specific language governing rights and limitations under the License.

The Original Code is FACET (Field Audio Collection Evaluation Tool).

The Initial Developer of the Original Code is Indiana University Research and Technology Corporation. 
Portions created by Indiana University Research and Technology Corporation are Copyright 2005-2008 Indiana University Research and Technology Corporation. 
All Rights Reserved.

Contributor(s): ______________________________________.
*/

package edu.indiana.dlib.sounddirections.facet.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.text.*;
import java.util.*;
import edu.indiana.dlib.sounddirections.facet.*;
import edu.indiana.dlib.sounddirections.facet.util.*;

public class Screen1 extends EditWindow {
	
	public JComboBox formatBox, generationBox;
	public JTextField CollectionNumberText, CollectionPartOneText, CollectionPartTwoText, CollectionPartText,
		ShelfNumberText, DateText;
	public JComboBox WorkerText, ProjectTitleText, CollectionNameText;
	public JTextField yearField;
	SimpleDateFormat sdf, sdf1;
	Calendar cal;
	
	public Screen1() {
		super();
        this.setTitle("Administrative Data - FACET");	
				
        summaryTextArea.setFocusable(false);
		pageOne.setForeground(Color.black);
		pageOne.setText("<html><body>1</body></html>");
		pageTwo.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent event) {
				if (event.getClickCount() == 1){
					goToPage2();
				}
			}
		});
		pageThree.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent event) {
				if (event.getClickCount() == 1){
					goToPage3();
				}
			}
		});
		pageFour.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent event) {
				if (event.getClickCount() == 1){
					goToPage4();
				}
			}
		});
		pageFive.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent event) {
				if (event.getClickCount() == 1){
					goToPage5();
				}
			}
		});
		pageSummary.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent event) {
				if (event.getClickCount() == 1){
					goToSummary();
				}
			}
		});
		backButton.setVisible(false);
		cancelButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				setVisible(false);
			}
		});
		nextButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				goToPage2();
			}});
		
		/***********************************************/
		
		String DATE_FORMAT = "yyyy";
		String DATE_FORMAT_ONE = "MM-dd-yyyy";
		
		sdf = new SimpleDateFormat(DATE_FORMAT);
		sdf1 = new SimpleDateFormat(DATE_FORMAT_ONE);
		
		cal = Calendar.getInstance(TimeZone.getDefault());
		
		JLabel adminLabel = new JLabel("Administrative Data");
		adminLabel.setBounds(15,45,450,20);
		adminLabel.setFont(Main.HEADERFONT);
		c.add(adminLabel);
		
		JLabel CollectionNumberLabel = new JLabel("Collection Primary Identifier");		
		
		CollectionNumberLabel.setFont(Main.BIGFONT);
		CollectionNumberLabel.setBounds(10,12,190,16);
		mainJPanel.add(CollectionNumberLabel);
		
		CollectionNumberText = new JTextField();
		CollectionNumberText.setEditable(true);
		CollectionNumberText.setBounds(200,10,150,22);
		CollectionNumberText.setFont(Main.REGFONT);
		CollectionNumberText.setHorizontalAlignment(JTextField.LEFT);
		CollectionNumberText.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Main.theData.isDirty = true;
			}
		});
		mainJPanel.add(CollectionNumberText);
		
		JLabel CollectionPartLabel = new JLabel("Part Name: ");
		CollectionPartLabel.setFont(Main.BIGFONT);
		CollectionPartLabel.setBounds(45,72,80,16);
		mainJPanel.add(CollectionPartLabel);
		
		CollectionPartText = new JTextField();
		CollectionPartText.setEditable(true);
		CollectionPartText.setBounds(130,70,190,22);
		CollectionPartText.setFont(Main.REGFONT);
		CollectionPartText.setHorizontalAlignment(JTextField.LEFT);
		CollectionPartText.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Main.theData.isDirty = true;
			}
		});
		mainJPanel.add(CollectionPartText);
		
		JLabel CollectionPartNumberOneLabel = new JLabel("Part ");
		CollectionPartNumberOneLabel.setFont(Main.BIGFONT);
		CollectionPartNumberOneLabel.setBounds(90,102,40,16);
		mainJPanel.add(CollectionPartNumberOneLabel);
		
		CollectionPartOneText = new JTextField();
		CollectionPartOneText.setEditable(true);
		CollectionPartOneText.setBounds(130,100,30,22);
		CollectionPartOneText.setFont(Main.REGFONT);
		CollectionPartOneText.setHorizontalAlignment(JTextField.LEFT);
		CollectionPartOneText.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Main.theData.isDirty = true;
			}
		});
		mainJPanel.add(CollectionPartOneText);
		
		JLabel CollectionPartNumberTwoLabel = new JLabel("of ");
		CollectionPartNumberTwoLabel.setFont(Main.BIGFONT);
		CollectionPartNumberTwoLabel.setBounds(170,102,20,16);
		mainJPanel.add(CollectionPartNumberTwoLabel);
		
		CollectionPartTwoText = new JTextField();
		CollectionPartTwoText.setEditable(true);
		CollectionPartTwoText.setBounds(190,100,30,22);
		CollectionPartTwoText.setFont(Main.REGFONT);
		CollectionPartTwoText.setHorizontalAlignment(JTextField.LEFT);
		CollectionPartTwoText.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Main.theData.isDirty = true;
			}
		});
		mainJPanel.add(CollectionPartTwoText);
		
		JLabel CollectionNameLabel = new JLabel("Collection Name: ");
		CollectionNameLabel.setFont(Main.BIGFONT);
		CollectionNameLabel.setBounds(10,132,115,16);
		mainJPanel.add(CollectionNameLabel);
		
		CollectionNameText = new JComboBox();
		CollectionNameText.setEditable(true);
		CollectionNameText.setBounds(130,130,190,22);
		CollectionNameText.setFont(Main.REGFONT);
		updateCNText();
		CollectionNameText.setSelectedItem("");
		CollectionNameText.setSelectedItem("");
		//this seemingly needless bit of code is necessary to prevent a swing bug that doesn't grab the latest text typed in a combo box
		//when navigating directly away from the window without pressing a button (such as navigating via the top links)
		((JTextField)CollectionNameText.getEditor().getEditorComponent()).addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent e) {
				javax.swing.SwingUtilities.invokeLater( new Runnable() {
	                public void run() {
	                	JTextField j = ((JTextField)CollectionNameText.getEditor().getEditorComponent());
	                	int x = j.getSelectionStart();
	                	int y = j.getSelectionEnd();
	                	String currVal = j.getText();
	                	CollectionNameText.setSelectedItem(currVal);
	                	j.setSelectionStart(x);
	                	j.setSelectionEnd(y);
	                }
				});
				
			}
		});
		mainJPanel.add(CollectionNameText);
		
		
		JLabel ShelfNumberLabel = new JLabel("Shelf Number(s): ");
		ShelfNumberLabel.setFont(Main.BIGFONT);
		ShelfNumberLabel.setBounds(10,162,115,16);
		mainJPanel.add(ShelfNumberLabel);
		
		ShelfNumberText = new JTextField();
		ShelfNumberText.setEditable(true);
		ShelfNumberText.setBounds(130,160,190,22);
		ShelfNumberText.setFont(Main.REGFONT);
		ShelfNumberText.setHorizontalAlignment(JTextField.LEFT);
		ShelfNumberText.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Main.theData.isDirty = true;
			}
		});
		mainJPanel.add(ShelfNumberText);
		
		JLabel WorkerLabel = new JLabel("Worker: ");
		WorkerLabel.setFont(Main.BIGFONT);
		WorkerLabel.setBounds(70,217,60,16);
		mainJPanel.add(WorkerLabel);
		
		WorkerText = new JComboBox();
		WorkerText.setEditable(true);
		WorkerText.setBounds(130,215,190,22);
		WorkerText.setFont(Main.REGFONT);
		updateWorkerText();
		WorkerText.setSelectedItem("");
		//this seemingly needless bit of code is necessary to prevent a swing bug that doesn't grab the latest text typed in a combo box
		//when navigating directly away from the window without pressing a button (such as navigating via the top links)
		((JTextField)WorkerText.getEditor().getEditorComponent()).addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent e) {
				javax.swing.SwingUtilities.invokeLater( new Runnable() {
	                public void run() {
	                	JTextField j = ((JTextField)WorkerText.getEditor().getEditorComponent());
	                	int x = j.getSelectionStart();
	                	int y = j.getSelectionEnd();
	                	String currVal = j.getText();
	                	WorkerText.setSelectedItem(currVal);
	                	j.setSelectionStart(x);
	                	j.setSelectionEnd(y);
	                }
				});
				
			}
		});
		mainJPanel.add(WorkerText);
		
		
		JLabel DateLabel = new JLabel("Date: ");
		DateLabel.setFont(Main.BIGFONT);
		DateLabel.setBounds(82,247,60,16);
		mainJPanel.add(DateLabel);
		
		DateText = new JTextField();
		DateText.setText("" + sdf1.format(cal.getTime()));
		DateText.setFont(Main.REGFONT);
		DateText.setBounds(130,245,90,22);
		DateText.setHorizontalAlignment(JTextField.LEFT);
		DateText.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Main.theData.isDirty = true;
			}
		});
		mainJPanel.add(DateText);
		
		JLabel ProjectTitleLabel = new JLabel("Project Title: ");
		ProjectTitleLabel.setFont(Main.BIGFONT);
		ProjectTitleLabel.setBounds(40,277,90,16);
		mainJPanel.add(ProjectTitleLabel);
		
		ProjectTitleText = new JComboBox();
		ProjectTitleText.setEditable(true);
		ProjectTitleText.setFont(Main.REGFONT);
		ProjectTitleText.setBounds(130,275,190,22);
		updatePTText();
		ProjectTitleText.setSelectedItem("");
		ProjectTitleText.setSelectedItem("");
		//this seemingly needless bit of code is necessary to prevent a swing bug that doesn't grab the latest text typed in a combo box
		//when navigating directly away from the window without pressing a button (such as navigating via the top links)
		((JTextField)ProjectTitleText.getEditor().getEditorComponent()).addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent e) {
				javax.swing.SwingUtilities.invokeLater( new Runnable() {
	                public void run() {
	                	JTextField j = ((JTextField)ProjectTitleText.getEditor().getEditorComponent());
	                	int x = j.getSelectionStart();
	                	int y = j.getSelectionEnd();
	                	String currVal = j.getText();
	                	ProjectTitleText.setSelectedItem(currVal);
	                	j.setSelectionStart(x);
	                	j.setSelectionEnd(y);
	                }
				});
				
			}
		});
		mainJPanel.add(ProjectTitleText);
		
		JLabel FormatLabel = new JLabel("Format: ");
		FormatLabel.setFont(Main.BIGFONT);
		FormatLabel.setBounds(65,333,70,16);
		mainJPanel.add(FormatLabel);
		
		formatBox = new JComboBox(new Object[] {"Open reel tape-polyester", "Open reel tape-acetate",
				"Open reel tape-paper", "Open reel tape-pvc", "Cassette-analog, audio", 
				"DAT (digital audio tape)", "Disc-lacquer",	"Disc-aluminum", "Wire Recording"});
		formatBox.setEditable(false);
		formatBox.setBounds(130,330,220,23);
		formatBox.setFont(Main.REGFONT);
		mainJPanel.add(formatBox);
		
		JLabel GenerationLabel = new JLabel("Generation: ");
		GenerationLabel.setFont(Main.BIGFONT);
		GenerationLabel.setBounds(40,363,90,16);
		mainJPanel.add(GenerationLabel);
		
		generationBox = new JComboBox(new Object[] {"Original (1st generation)",
				"Copy (generation unknown)", "Unknown", "First Copy (2nd generation)" ,
				"Second Copy (3rd generation)", "Third Copy (4th generation)", 
				"Fourth Copy (5th generation)" , "Fifth Copy (6th generation)"});
		generationBox.setEditable(false);
		generationBox.setFont(Main.REGFONT);
		generationBox.setBounds(130,360,220,23);
		generationBox.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
			}
		});
		
		mainJPanel.add(generationBox);
		
		JLabel yearLabel = new JLabel("Year Recorded: ");
		yearLabel.setFont(Main.BIGFONT);
		yearLabel.setBounds(10,392,105,16);
		mainJPanel.add(yearLabel);
		
		yearField = new JTextField();
		yearField.setBounds(130,390,70,22);
		yearField.setEnabled(true);
		yearField.setFont(Main.REGFONT);
		yearField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Main.theData.isDirty = true;
			}
		});
		mainJPanel.add(yearField);
		
		summaryTextArea.setText("" + Main.theData.updateScoreBox());
        doComponentInitialization(this);
	}
	
	private void updateWorkerText() {    	
		int counter = 0;
		while (counter < Main.workers.size()) {
			String theCandidate = Main.workers.get(counter);
			WorkerText.addItem(theCandidate);   					
			counter = counter + 1;
		}
    }
	
	private void updateCNText() {    	
    	int counter = 0;
		while (counter < Main.collectionNames.size()) {
			String theCandidate = Main.collectionNames.get(counter);
			CollectionNameText.addItem(theCandidate);   					
			counter = counter + 1;
		}
    }
	
	private void updatePTText() {    	
		int counter = 0;
		while (counter < Main.projTitles.size()) {
			String theCandidate = Main.projTitles.get(counter);
			ProjectTitleText.addItem(theCandidate);   					
			counter = counter + 1;
		}
    }
	
	public void setVisible(boolean val) {
		summaryTextArea.setText("" + Main.theData.updateScoreBox());
		super.setVisible(val);
	}
	
	public boolean saveData(){
		if (CollectionNumberText.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "You must specify a primary identifier", "No primary identifier specified", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		Integer intObject1 = null;
		int years = 0;
		try {
			intObject1 = new Integer(yearField.getText());
			years = intObject1.intValue();
			
		} catch (Exception err) {
			if (yearField.getText().equals("")) {
				years = 0;
			} else {
				JOptionPane.showMessageDialog(null, "Please enter a numeric value " +
						"for the Year field, or leave blank.", "Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}		
		int currentYear = (new Integer(sdf.format(cal.getTime()))).intValue();
		if (yearField.getText().equals("")) {
			years = 0;
		} else if (years < 1885 || years > currentYear) {
			JOptionPane.showMessageDialog(null, "Please enter a valid year number " +
					"in the year field, or leave blank.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if (formatBox.getSelectedIndex()==5) {
			if ((years < 1987) && (years != 0)) {
				JOptionPane.showMessageDialog(null, "Please enter a valid year number " +
						"in the year field, or leave blank.", "Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
 		}
		
		setFormat();
		Object generationObject = generationBox.getSelectedItem();
		String generation = generationObject + "";
		
    	Main.theData.collectionNumber = CollectionNumberText.getText();
		Main.theData.partOne = CollectionPartOneText.getText();
		Main.theData.partTwo = CollectionPartTwoText.getText();
		Main.theData.collectionPart = CollectionPartText.getText();
		Main.theData.collectionName = (String)CollectionNameText.getSelectedItem();
		Main.theData.shelfNumber = ShelfNumberText.getText();
		Main.theData.worker = (String)WorkerText.getSelectedItem();
		Main.theData.date = DateText.getText();
		Main.theData.projectTitle = (String)ProjectTitleText.getSelectedItem();
		Main.theData.year = years;
		Main.theData.generation = generation;				
            
		return true;
	}
	
	public void initVars(){
		boolean isNew = false;
		if (formatBox.getSelectedIndex()==0) {
			if (!(Main.window2 instanceof Screen2ORTpolyester)) {
				isNew = true;
			}
		} else if (formatBox.getSelectedIndex()==1) {
			if (!(Main.window2 instanceof Screen2ORTacetate)) {
				isNew = true;
			}
		} else if (formatBox.getSelectedIndex()==2) {
			if (!(Main.window2 instanceof Screen2ORTpaper)) {
				isNew = true;
			}
		} else if (formatBox.getSelectedIndex()==3) {
			if (!(Main.window2 instanceof Screen2ORTpvc)) {
				isNew = true;
			}
		} else if (formatBox.getSelectedIndex()==4) {
			if (!(Main.window2 instanceof Screen2Cassette)) {
				isNew = true;
			}
		} else if (formatBox.getSelectedIndex()==5) {
			if (!(Main.window2 instanceof Screen2DAT)) {
				isNew = true;
			}
			if (Main.theData.year < 1994) {
				if (Main.theData.year != 0) {
					Main.theData.pre1993 = true;
				} else {
					Main.theData.pre1993 = false;
				}
			} else {
				Main.theData.pre1993 = false;
			}
		} else if (formatBox.getSelectedIndex()==6) {
			if (!(Main.window2 instanceof Screen2Dlacquer)) {
				isNew = true;
			}
		} else if (formatBox.getSelectedIndex()==7) {
			if (!(Main.window2 instanceof Screen2Daluminum)) {
				isNew = true;
			}
		} else {
			if (!(Main.window2 instanceof Screen2wire)) {
				isNew = true;
			}
		}
		if (isNew) {
			Main.theData.orpMastersBox = false;
			Main.theData.orpMastersStickyBox = false;
			Main.theData.orpNonMasterBox = false;
			Main.theData.cdAudioBox = false;
			Main.theData.cdDataBox = false;
			Main.theData.isPreserved = false;
			Main.theData.oraBox = false;
			Main.theData.DACBox = false;
			Main.theData.cassetteBox = false;
			Main.theData.historyBox = false;
			Main.theData.DATBox = false;
			Main.theData.modPoints.clear();
			Main.theData.researchValue = 0;
			Main.theData.notes4_5 = "";
			Main.theData.clearFormatValues();
			Main.window3 = null;
			Main.window4 = null;
			Main.window5 = null;
			Main.window6 = null;
		}
	}
	
	private void setFormat(){
		if (formatBox.getSelectedIndex()==0) {
			Main.theData.formatString = "Open reel tape-polyester";
		}
		if (formatBox.getSelectedIndex()==1) {
			Main.theData.formatString = "Open reel tape-acetate";
		}
		if (formatBox.getSelectedIndex()==2) {
			Main.theData.formatString = "Open reel tape-paper";
		}
		if (formatBox.getSelectedIndex()==3) {
			Main.theData.formatString = "Open reel tape-pvc";
		}
		if (formatBox.getSelectedIndex()==4) {
			Main.theData.formatString = "Cassette-analog, audio";
		}
		if (formatBox.getSelectedIndex()==5) {
			Main.theData.formatString = "DAT (digital audio tape)";
		}
		if (formatBox.getSelectedIndex()==6) {
			Main.theData.formatString = "Disc-lacquer";
		}
		if (formatBox.getSelectedIndex()==7) {
			Main.theData.formatString = "Disc-aluminum";
		}
		if (formatBox.getSelectedIndex()==8) {
			Main.theData.formatString = "Wire Recording";
		}
	}
	
	private void goToPage2(){
		if (!saveData()) {
			return;
		}
		initVars();
		PageNav.goToPage2(this);
	}
	
	private void goToPage3(){
		if (!saveData()) {
			return;
		}
		initVars();
		PageNav.goToPage3(this);
	}
	
	private void goToPage4(){
		if (!saveData()) {
			return;
		}
		initVars();
		PageNav.goToPage4(this);
	}
	
	private void goToPage5(){
		if (!saveData()) {
			return;
		}
		initVars();
		PageNav.goToPage5(this);
	}
	
	private void goToSummary(){
		if (!saveData()) {
			return;
		}
		initVars();
		PageNav.goToSummary(this);
	}
	
	
}