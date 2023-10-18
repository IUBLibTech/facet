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
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;
import edu.indiana.dlib.sounddirections.facet.*;
import edu.indiana.dlib.sounddirections.facet.util.PageNav;

public class Screen2Dlacquer extends EditWindow{

	public JCheckBox glassBox, plasticBox, delaminationBox;
	public JCheckBox plasticRadio, delaminationRadio;
	
	public Screen2Dlacquer() {
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
		JLabel characteristicsLabel = new JLabel("Format: Lacquer Disc");
		characteristicsLabel.setBounds(35,5,250,20);
		characteristicsLabel.setFont(Main.BIGFONT);
		mainJPanel.add(characteristicsLabel);
		JPanel characteristicsJPanel = new JPanel();
		characteristicsJPanel.setBounds(25,30,300,150);
		characteristicsJPanel.setBorder(new LineBorder(Color.BLACK));
		characteristicsJPanel.setLayout(null);
		characteristicsJPanel.setBackground(Main.BROWNCOLOR);
		mainJPanel.add(characteristicsJPanel);
		//ALL THESE IN characteristicsJPanel
		JLabel cha = new JLabel("Characteristics");
		cha.setBounds(55,5,200,20);
		cha.setFont(Main.BIGFONT);
		characteristicsJPanel.add(cha);
		glassBox = new JCheckBox("   Glass Base");
		glassBox.setFont(font3);
		glassBox.setBounds(5,35,130,15);
		glassBox.setBackground(Main.BROWNCOLOR);
		characteristicsJPanel.add(glassBox);
		glassBox.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				updateTheData();
				updateTheUI();
			}
		});
		//END of the characteristicsJPanel
		
		JPanel preservationsJPanel = new JPanel();
		preservationsJPanel.setBounds(25,225,300,150);
		preservationsJPanel.setBorder(new LineBorder(Color.BLACK));
		preservationsJPanel.setBackground(Main.BROWNCOLOR);
		preservationsJPanel.setLayout(null);
		mainJPanel.add(preservationsJPanel);
		JLabel preservationsLabel = new JLabel("Preservation Problems");
		preservationsLabel.setBounds(55,5,200,20);
		preservationsLabel.setFont(Main.BIGFONT);
		preservationsJPanel.add(preservationsLabel);
		//ALL THESE IN preservationsJPanel
		
		plasticRadio = new JCheckBox("   Plasticizer Exudation");
		plasticRadio.setFont(font3);
		plasticRadio.setBackground(Main.BROWNCOLOR);
		plasticRadio.setBounds(5,35,180,15);
		preservationsJPanel.add(plasticRadio);
		plasticRadio.addActionListener(new ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e){
				Main.theData.isDirty = true;
				if (plasticRadio.isSelected()) {
					delaminationRadio.setSelected(false);
				}
				updateTheData();
				updateTheUI();
			}
		});
		
		delaminationRadio = new JCheckBox("   Delamination");
		delaminationRadio.setFont(font3);
		delaminationRadio.setBackground(Main.BROWNCOLOR);
		delaminationRadio.setBounds(5,50,150,15);
		preservationsJPanel.add(delaminationRadio);
		delaminationRadio.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				if (delaminationRadio.isSelected()) {
					plasticRadio.setSelected(false);
				}
				updateTheData();
				updateTheUI();
			}
		});
		
		doComponentInitialization(this);
	}
	
	public void setVisible(boolean value) {
		super.setVisible(value);
		updateTheUI();
	}
	
	public void updateTheData() {
		Main.theData.glass = glassBox.isSelected();
		Main.theData.plastic = plasticRadio.isSelected();
		Main.theData.delamination = delaminationRadio.isSelected();
	}
	
	private void updateTheUI() {
		summaryTextArea.setText("" + Main.theData.updateScoreBox());
	}

}

