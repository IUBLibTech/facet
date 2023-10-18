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
import edu.indiana.dlib.sounddirections.facet.ui.dialogs.*;
import edu.indiana.dlib.sounddirections.facet.util.PageNav;

public class Screen2Cassette extends EditWindow {

	public JButton explanationCheckButton;
	public JCheckBox minuteBox, offBrandBox, lossBox, fungusBox, otherProblemsBox;
	public JLabel minuteLabel, totalLabel, totalScoreLabel;
	public JTextField explanationText;
	public JComboBox tapeType, soundfieldType;
	
	public Screen2Cassette() {
		
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
		
		JLabel characteristicsLabel = new JLabel("Format: Cassette");
		characteristicsLabel.setBounds(35,5,250,20);
		characteristicsLabel.setFont(Main.BIGFONT);
		mainJPanel.add(characteristicsLabel);
		
		JPanel characteristicsJPanel = new JPanel();
		characteristicsJPanel.setBounds(25,30,370,200);
		characteristicsJPanel.setBackground(Main.BROWNCOLOR);
		characteristicsJPanel.setBorder(new LineBorder(Color.BLACK));
		characteristicsJPanel.setLayout(null);
		mainJPanel.add(characteristicsJPanel);
		
		//ALL THESE IN characteristicsJPanel
		
		JLabel cha = new JLabel("Characteristics");
		cha.setBounds(55,5,200,20);
		cha.setFont(Main.BIGFONT);
		characteristicsJPanel.add(cha);

		JLabel thicknessLabel = new JLabel("Tape Type:");
		thicknessLabel.setFont(font3);
		thicknessLabel.setBounds(5,35,75,15);
		characteristicsJPanel.add(thicknessLabel);
		
		tapeType = new JComboBox();
		tapeType.setFont(font3);
		tapeType.setBounds(76, 34, 270, 20);
		characteristicsJPanel.add(tapeType);
		tapeType.addItem("Type I (Normal)");
		tapeType.addItem("Type II (High Bias: CrO2 and Cobalt-Doped)");
		tapeType.addItem("Type III (Ferric Chrome)");
		tapeType.addItem("Type IV (Metal)");
		tapeType.addItem("Unknown");
		tapeType.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				updateTheData();
				updateTheUI();
			}
		});
		
		JLabel soundFieldLabel = new JLabel("Sound Field: ");
		soundFieldLabel.setBounds(5,65,85,15);
		soundFieldLabel.setFont(font3);
		characteristicsJPanel.add(soundFieldLabel);
		
		soundfieldType = new JComboBox();
		soundfieldType.setFont(font3);
		soundfieldType.setBounds(76, 63, 130, 20);
		characteristicsJPanel.add(soundfieldType);
		soundfieldType.addItem("Stereo");
		soundfieldType.addItem("Mono");
		soundfieldType.addItem("Unknown");
		soundfieldType.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				updateTheData();
				updateTheUI();
			}
		});

		minuteBox = new JCheckBox("   120 or 180 Minute");
		minuteBox.setFont(font3);
		minuteBox.setBackground(Main.BROWNCOLOR);
		minuteBox.setBounds(5,90,150,15);
		characteristicsJPanel.add(minuteBox);
		minuteBox.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				updateTheData();
				updateTheUI();
			}
		});
		
		offBrandBox = new JCheckBox("   Off-Brand");
		offBrandBox.setFont(font3);
		offBrandBox.setBounds(5,105,150,15);
		offBrandBox.setBackground(Main.BROWNCOLOR);
		characteristicsJPanel.add(offBrandBox);
		offBrandBox.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				updateTheData();
				updateTheUI();
			}
		});
		
		JButton noiseReductionButton = new JButton("Noise Reduction ");
		noiseReductionButton.setFont(Main.REGFONT);
		noiseReductionButton.setBounds(10,165,150,27);
		characteristicsJPanel.add(noiseReductionButton);
		noiseReductionButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				openNoise();
			}
		});
		
		//END of the characteristicsJPanel
		
		JPanel preservationsJPanel = new JPanel();
		preservationsJPanel.setBounds(25,275,350,165);
		preservationsJPanel.setBorder(new LineBorder(Color.BLACK));
		preservationsJPanel.setLayout(null);
		preservationsJPanel.setBackground(Main.BROWNCOLOR);
		mainJPanel.add(preservationsJPanel);
		
		JLabel preservationsLabel = new JLabel("Preservation Problems");
		preservationsLabel.setBounds(55,5,200,20);
		preservationsLabel.setFont(Main.BIGFONT);
		preservationsJPanel.add(preservationsLabel);
		
		//ALL THESE IN preservationsJPanel
		
		lossBox = new JCheckBox("   Soft Binder Syndrome-Unidentified Problems");
		lossBox.setFont(font3);
		lossBox.setBounds(5,35,300,15);
		preservationsJPanel.add(lossBox);
		lossBox.setBackground(Main.BROWNCOLOR);
		lossBox.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				updateTheData();
				updateTheUI();
			}
		});
		
		fungusBox = new JCheckBox("   Fungus");
		fungusBox.setFont(font3);
		fungusBox.setBounds(5,50,180,15);
		fungusBox.setBackground(Main.BROWNCOLOR);
		preservationsJPanel.add(fungusBox);
		fungusBox.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				updateTheData();
				updateTheUI();
			}
		});
		
		otherProblemsBox = new JCheckBox("   Other Documented Problems");
		otherProblemsBox.setFont(font3);
		otherProblemsBox.setBounds(5,65,210,15);
		otherProblemsBox.setBackground(Main.BROWNCOLOR);
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
		explanationLabel.setBounds(5,90,75,15);
		preservationsJPanel.add(explanationLabel);
		
		explanationText = new JTextField();
		explanationText.setBounds(80,85,255,22);
		explanationText.setFont(font3);
		explanationText.setEnabled(false);
		explanationText.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Main.theData.isDirty = true;
			}
		});
		preservationsJPanel.add(explanationText);
		
		tapeType.setSelectedItem("Unknown");
		soundfieldType.setSelectedItem("Unknown");
		//END of the preservationsJPanel
		
		doComponentInitialization(this);
		this.updateTheUI();
	}
	
	public void setVisible(boolean value) {
		super.setVisible(value);
		updateTheUI();
	}
	
	private void openNoise(){
		new EditNoise(this);
	}
	
	public void updateTheData() {	
		Main.theData.typeIcassette = false;
		Main.theData.typeIIcassette = false;
		Main.theData.typeIIIcassette = false;
		Main.theData.typeIVcassette = false;
		
		if (tapeType.getSelectedIndex() == 0) {
			Main.theData.typeIcassette = true;
		} else if (tapeType.getSelectedIndex() == 1) {
			Main.theData.typeIIcassette = true;
		} else if (tapeType.getSelectedIndex() == 2) {
			Main.theData.typeIIIcassette = true;
		} else if (tapeType.getSelectedIndex() == 3) {
			Main.theData.typeIVcassette = true;
		}
		
		Main.theData.stereo = false;
		Main.theData.mono = false;
		if (soundfieldType.getSelectedIndex() == 0) {
			Main.theData.stereo = true;
		} else if (soundfieldType.getSelectedIndex() == 1) {
			Main.theData.mono = true;
		} 
	
		Main.theData.minute = minuteBox.isSelected();
		Main.theData.offBrand = offBrandBox.isSelected();
		Main.theData.lubricant = lossBox.isSelected();
		Main.theData.fungus = fungusBox.isSelected();
		Main.theData.other = otherProblemsBox.isSelected();
		Main.theData.explanationString = explanationText.getText();
	}
	
	private void updateTheUI() {
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
