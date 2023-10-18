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

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;
import edu.indiana.dlib.sounddirections.facet.*;
import edu.indiana.dlib.sounddirections.facet.util.PageNav;

public class Screen2DAT extends EditWindow{
	
	public JCheckBox thinTapeBox, pre1993Box, longPlayBox, otherProblemsBox, recordedPortable,
		dataGradeTape, fungus;
	public JTextField explanationText;
	public JButton explanationCheckButton;
	
	public Screen2DAT() {
		this.setTitle("Characteristics and Preservation Problems - FACET [" + Main.theData.collectionNumber + "]");
		
		final JFrame t = this;
		pageTwo.setForeground(Color.black);
		pageTwo.setText("<html><body>2</body></html>");
		pageOne.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent event) {
				if (event.getClickCount() == 1){
					updateTheData();
					PageNav.goToPage1(t);
				}
			}
		});
		pageFive.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent event) {
				if (event.getClickCount() == 1){
					updateTheData();
					PageNav.goToPage5(t);
				}
			}
		});
		pageThree.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent event) {
				if (event.getClickCount() == 1){
					updateTheData();
					PageNav.goToPage3(t);
				}
			}
		});
		pageFour.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent event) {
				if (event.getClickCount() == 1){
					updateTheData();
					PageNav.goToPage4(t);
				}
			}
		});
		pageSummary.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent event) {
				if (event.getClickCount() == 1){
					updateTheData();
					PageNav.goToSummary(t);
				}
			}
		});
		cancelButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				setVisible(false);
			}
		});
		nextButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				updateTheData();
				PageNav.goToPage3(t);
			}});
		backButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				updateTheData();
				PageNav.goToPage1(t);
			}
		});
		
		JLabel adminLabel = new JLabel("Characteristics and Preservation Problems");
		adminLabel.setBounds(15,45,450,20);
		adminLabel.setFont(Main.HEADERFONT);
		c.add(adminLabel);
		Font font3 = new Font("Arial",Font.PLAIN,12);
		JLabel characteristicsLabel = new JLabel("Format: DAT");
		characteristicsLabel.setBounds(35,5,250,20);
		characteristicsLabel.setFont(Main.BIGFONT);
		mainJPanel.add(characteristicsLabel);
		
		JPanel characteristicsJPanel = new JPanel();
		characteristicsJPanel.setBounds(25,30,300,150);
		characteristicsJPanel.setBackground(Main.BROWNCOLOR);
		characteristicsJPanel.setBorder(new LineBorder(Color.BLACK));
		characteristicsJPanel.setLayout(null);
		mainJPanel.add(characteristicsJPanel);
		
		//ALL THESE IN characteristicsJPanel
		
		JLabel cha = new JLabel("Characteristics");
		cha.setBounds(55,5,200,20);
		cha.setFont(Main.BIGFONT);
		characteristicsJPanel.add(cha);
		
		thinTapeBox = new JCheckBox("   Thin Tape");
		thinTapeBox.setFont(font3);
		thinTapeBox.setBounds(5,35,210,15);
		thinTapeBox.setBackground(Main.BROWNCOLOR);
		characteristicsJPanel.add(thinTapeBox);
		thinTapeBox.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				updateTheData();
				updateTheUI();
			}
		});
		
		pre1993Box = new JCheckBox("   1993 or Earlier");
		pre1993Box.setFont(font3);
		pre1993Box.setBounds(5,50,150,15);
		pre1993Box.setBackground(Main.BROWNCOLOR);
		characteristicsJPanel.add(pre1993Box);
		pre1993Box.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				updateTheData();
				updateTheUI();
			}
		});
		
		recordedPortable = new JCheckBox("   Recorded on Portable");
		recordedPortable.setFont(font3);
		recordedPortable.setBounds(5,65,200,15);
		recordedPortable.setBackground(Main.BROWNCOLOR);
		characteristicsJPanel.add(recordedPortable);
		recordedPortable.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				updateTheData();
				updateTheUI();
			}
		});
		
		dataGradeTape = new JCheckBox("   Data Grade Tape");
		dataGradeTape.setFont(font3);
		dataGradeTape.setBackground(Main.BROWNCOLOR);
		dataGradeTape.setBounds(5,80,150,15);
		characteristicsJPanel.add(dataGradeTape);
		dataGradeTape.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				updateTheData();
				updateTheUI();
			}
		});
		
		longPlayBox = new JCheckBox("   Long-Play, 32k, or 96k");
		longPlayBox.setFont(font3);
		longPlayBox.setBackground(Main.BROWNCOLOR);
		longPlayBox.setBounds(5,95,250,15);
		characteristicsJPanel.add(longPlayBox);
		longPlayBox.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				updateTheData();
				updateTheUI();
			}
		});
		
		JPanel preservationsJPanel = new JPanel();
		preservationsJPanel.setBounds(25,225,350,150);
		preservationsJPanel.setBorder(new LineBorder(Color.BLACK));
		preservationsJPanel.setBackground(Main.BROWNCOLOR);
		preservationsJPanel.setLayout(null);
		mainJPanel.add(preservationsJPanel);
	
		
		JLabel preservationsLabel = new JLabel("Preservation Problems");
		preservationsLabel.setBounds(55,5,200,20);
		preservationsLabel.setFont(Main.BIGFONT);
		preservationsJPanel.add(preservationsLabel);
		
		fungus = new JCheckBox("   Fungus");
		fungus.setFont(font3);
		fungus.setBackground(Main.BROWNCOLOR);
		fungus.setBounds(5,35,210,15);
		preservationsJPanel.add(fungus);
		fungus.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				updateTheData();
				updateTheUI();
			}
		});
		
		otherProblemsBox = new JCheckBox("   Other Documented Problems");
		otherProblemsBox.setFont(font3);
		otherProblemsBox.setBackground(Main.BROWNCOLOR);
		otherProblemsBox.setBounds(5,50,210,15);
		preservationsJPanel.add(otherProblemsBox);
		otherProblemsBox.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				updateTheData();
				updateTheUI();
				enableExplanationText();
			}
		});
		
		JLabel explanationLabel = new JLabel("Explanation: ");
		explanationLabel.setFont(font3);
		explanationLabel.setBackground(Main.BROWNCOLOR);
		explanationLabel.setBounds(5,75,75,15);
		preservationsJPanel.add(explanationLabel);
		
		explanationText = new JTextField();
		explanationText.setBounds(80,70,255,22);
		explanationText.setEnabled(false);
		explanationText.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Main.theData.isDirty = true;
			}
		});
		preservationsJPanel.add(explanationText);
		
		//END of the preservationsJPanel
		
		doComponentInitialization(this);
		
	}
	
	public void setVisible(boolean value) {
		super.setVisible(value);
		updateTheUI();
	}
	
	public void updateTheData() {
		Main.theData.thinTape = thinTapeBox.isSelected();
		Main.theData.pre1993 = pre1993Box.isSelected();
		Main.theData.portableDAT = recordedPortable.isSelected();
		Main.theData.dataGradeDAT = dataGradeTape.isSelected();
		Main.theData.longPlayDAT = longPlayBox.isSelected();
		Main.theData.other = otherProblemsBox.isSelected();
		Main.theData.explanationString = explanationText.getText();
		Main.theData.fungus = fungus.isSelected();
	}
	
	public void updateTheUI() {
		summaryTextArea.setText("" + Main.theData.updateScoreBox());
		explanationText.setText(Main.theData.explanationString);
	}
	
	public void enableExplanationText(){
		if (otherProblemsBox.isSelected()) {
			explanationText.setEnabled(true);
		} else {
			explanationText.setEnabled(false);
			explanationText.setText("");
		}
	}
	
}
