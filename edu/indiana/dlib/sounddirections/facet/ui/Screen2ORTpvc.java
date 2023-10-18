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
import edu.indiana.dlib.sounddirections.facet.ui.dialogs.*;
import edu.indiana.dlib.sounddirections.facet.util.PageNav;
import edu.indiana.dlib.sounddirections.facet.*;

public class Screen2ORTpvc extends EditWindow{

	public JCheckBox offBrandBox, fungusBox, otherProblemsBox;
	public JRadioButton visibleMinor, visibleModerate, 
			visibleSevere, noVisible;
	public JCheckBox stickyRadio, lossRadio;
	public ButtonGroup bgroup;
	public JLabel minuteLabel, totalLabel, totalScoreLabel;
	public JTextField explanationText;
	public JButton explanationCheckButton;
	public JComboBox tapeThickness;
	
	public Screen2ORTpvc() {

		this.setTitle("Format Characteristics and Preservation Problems - FACET [" + Main.theData.collectionNumber + "]");
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
		
		JLabel characteristicsLabel = new JLabel("Format: Open Reel Tape-PVC");
		characteristicsLabel.setBounds(35,5,200,20);
		characteristicsLabel.setFont(Main.BIGFONT);
		mainJPanel.add(characteristicsLabel);
		
		JPanel characteristicsJPanel = new JPanel();
		characteristicsJPanel.setBounds(25,30,370,165);
		characteristicsJPanel.setBorder(new LineBorder(Color.BLACK));
		characteristicsJPanel.setLayout(null);
		characteristicsJPanel.setBackground(Main.BROWNCOLOR);
		mainJPanel.add(characteristicsJPanel);
		
		JLabel cha = new JLabel("Characteristics");
		cha.setBounds(55,5,200,20);
		cha.setFont(Main.BIGFONT);
		characteristicsJPanel.add(cha);
		
		JLabel thicknessLabel = new JLabel("Thickness:");
		thicknessLabel.setFont(font3);
		thicknessLabel.setBounds(5,35,130,15);
		characteristicsJPanel.add(thicknessLabel);
		
		tapeThickness = new JComboBox();
		tapeThickness.setFont(font3);
		tapeThickness.setBounds(74, 33, 290, 20);
		characteristicsJPanel.add(tapeThickness);
		tapeThickness.addItem("Standard Play (52 µm Total or 1.5 mil Base)");
		tapeThickness.addItem("Long Play (35 µm Total or 1.0 mil Base)");
		tapeThickness.addItem("Double Play (26 µm Total or 0.5 mil Base)");
		tapeThickness.addItem("Triple Play (18 µm Total or 0.5 mil or Thinner Base)");
		tapeThickness.addItem("Double/Triple Play Unknown");
		tapeThickness.addItem("Thickness Unknown");
		tapeThickness.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				updateTheData();
				updateTheUI();
			}
		});
		
		offBrandBox = new JCheckBox("   Off-brand");
		offBrandBox.setFont(font3);
		offBrandBox.setBounds(5,61,150,15);
		offBrandBox.setBackground(Main.BROWNCOLOR);
		characteristicsJPanel.add(offBrandBox);
		offBrandBox.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				updateTheData();
				updateTheUI();
			}
		});
		
		JButton tracksButton = new JButton("Tracks");
		tracksButton.setBounds(5,130,75,27);
		characteristicsJPanel.add(tracksButton);
		tracksButton.setFont(Main.REGFONT);
		tracksButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				openTracks();
			}
		});
		
		JButton noiseReductionButton = new JButton("Noise Reduction");
		noiseReductionButton.setBounds(80,130,150,27);
		noiseReductionButton.setFont(Main.REGFONT);
		characteristicsJPanel.add(noiseReductionButton);
		noiseReductionButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				openNoise();
			}
		});
		
		JPanel preservationsJPanel = new JPanel();
		preservationsJPanel.setBounds(25,225,350,200);
		preservationsJPanel.setBorder(new LineBorder(Color.BLACK));
		preservationsJPanel.setLayout(null);
		preservationsJPanel.setBackground(Main.BROWNCOLOR);
		mainJPanel.add(preservationsJPanel);
		
		JLabel preservationsLabel = new JLabel("Preservation Problems");
		preservationsLabel.setBounds(55,5,200,20);
		preservationsLabel.setFont(Main.BIGFONT);
		preservationsJPanel.add(preservationsLabel);
		
		JLabel tapeProblemLabel = new JLabel("Tape Pack Problems");
		tapeProblemLabel.setFont(font3);
		tapeProblemLabel.setBounds(5,30,130,15);
		preservationsJPanel.add(tapeProblemLabel);
		
		noVisible = new JRadioButton("None", true);
		noVisible.setFont(font3);
		noVisible.setBackground(Main.BROWNCOLOR);
		noVisible.setBounds(10,50,55,15);
		preservationsJPanel.add(noVisible);
		noVisible.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				updateTheData();
				updateTheUI();
			}
		});
		
		visibleMinor = new JRadioButton("Minor");
		visibleMinor.setFont(font3);
		visibleMinor.setBounds(70,50,60,15);
		visibleMinor.setBackground(Main.BROWNCOLOR);
		preservationsJPanel.add(visibleMinor);
		visibleMinor.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				updateTheData();
				updateTheUI();
			}
		});
		
		visibleModerate = new JRadioButton("Moderate");
		visibleModerate.setFont(font3);
		visibleModerate.setBounds(130,50,80,15);
		visibleModerate.setBackground(Main.BROWNCOLOR);
		preservationsJPanel.add(visibleModerate);
		visibleModerate.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				updateTheData();
				updateTheUI();
			}
		});

		visibleSevere = new JRadioButton("Severe");
		visibleSevere.setFont(font3);
		visibleSevere.setBounds(215,50,70,15);
		visibleSevere.setBackground(Main.BROWNCOLOR);
		preservationsJPanel.add(visibleSevere);
		visibleSevere.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				updateTheData();
				updateTheUI();
			}
		});
		
		ButtonGroup bgroupThree = new ButtonGroup();
		bgroupThree.add(noVisible);
		bgroupThree.add(visibleMinor);
		bgroupThree.add(visibleModerate);
		bgroupThree.add(visibleSevere);
		
		stickyRadio = new JCheckBox("   Soft Binder Syndrome-Sticky Shed Syndrome");
		stickyRadio.setFont(font3);
		stickyRadio.setBackground(Main.BROWNCOLOR);
		stickyRadio.setBounds(5,75,300,15);
		preservationsJPanel.add(stickyRadio);
		stickyRadio.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				if (stickyRadio.isSelected()) {
					lossRadio.setSelected(false);
				}
				updateTheData();
				updateTheUI();
			}
		});

		lossRadio = new JCheckBox("   Soft Binder Syndrome-Unidentified Problems");
		lossRadio.setFont(font3);
		lossRadio.setBackground(Main.BROWNCOLOR);
		lossRadio.setBounds(5,90,300,15);
		preservationsJPanel.add(lossRadio);
		lossRadio.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				if (lossRadio.isSelected()) {
					stickyRadio.setSelected(false);
				}
				updateTheData();
				updateTheUI();
			}
		});
		
		fungusBox = new JCheckBox("   Fungus");
		fungusBox.setFont(font3);
		fungusBox.setBackground(Main.BROWNCOLOR);
		fungusBox.setBounds(5,135,180,15);
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
		otherProblemsBox.setBackground(Main.BROWNCOLOR);
		otherProblemsBox.setBounds(5,150,210,15);
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
		explanationLabel.setBounds(5,175,75,15);
		preservationsJPanel.add(explanationLabel);
		
		explanationText = new JTextField();
		explanationText.setBounds(80,170,255,22);
		explanationText.setFont(Main.REGFONT);
		explanationText.setEnabled(false);
		explanationText.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Main.theData.isDirty = true;
			}
		});
		preservationsJPanel.add(explanationText);
		
		tapeThickness.setSelectedItem("Thickness Unknown");
		
		doComponentInitialization(this);
		
		this.updateTheUI();
	}
	
	public void setVisible(boolean value) {
		super.setVisible(value);
		updateTheUI();
	}
	
	private void openTracks() {
		new EditTracks(this);
	}
	private void openNoise(){
		new EditNoise(this);
	}
	
	public void updateTheData() {
		Main.theData.longPlayPVC = false;
		Main.theData.doublePlayPVC = false;
		Main.theData.triplePlayPVC = false;
		Main.theData.standardPlayPVC = false;
		Main.theData.unknownDoubleTriplePVC = false;
		
		if (tapeThickness.getSelectedIndex() == 0) {
			Main.theData.standardPlayPVC = true;
		}else if (tapeThickness.getSelectedIndex() == 1) {
			Main.theData.longPlayPVC = true;
		} else if (tapeThickness.getSelectedIndex() == 2) {
			Main.theData.doublePlayPVC = true;
		} else if (tapeThickness.getSelectedIndex() == 3) {
			Main.theData.triplePlayPVC = true;
		} else if (tapeThickness.getSelectedIndex() == 4) {
			Main.theData.unknownDoubleTriplePVC = true;
		}
		
		Main.theData.offBrand = offBrandBox.isSelected();
		Main.theData.lossPVC = lossRadio.isSelected();
		Main.theData.stickyPVC =stickyRadio.isSelected();
		Main.theData.fungus = fungusBox.isSelected();
		Main.theData.visibleMinorPVC = visibleMinor.isSelected();
		Main.theData.visibleModeratePVC = visibleModerate.isSelected();
		Main.theData.visibleSeverePVC = visibleSevere.isSelected();
		Main.theData.other = otherProblemsBox.isSelected();
		Main.theData.explanationString = explanationText.getText();
	}
	
	public void updateTheUI() {
		explanationText.setText(Main.theData.explanationString);
		summaryTextArea.setText("" + Main.theData.updateScoreBox());
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
