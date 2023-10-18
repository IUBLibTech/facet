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
import java.text.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import edu.indiana.dlib.sounddirections.facet.*;
import edu.indiana.dlib.sounddirections.facet.util.*;

public class Screen3 extends EditWindow {

	public JCheckBox orpMastersBox, orpMastersStickyBox, orpNonMasterBox, oraBox,
		DACBox, cassetteBox, DATBox, cdDataBox, cdAudioBox, newone;
	
	public Screen3() {
		super();

		this.setTitle("Copies - FACET [" + Main.theData.collectionNumber + "]");
		final Screen3 t = this;
		pageThree.setForeground(Color.black);
		pageThree.setText("<html><body>3</body></html>");
		pageOne.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent event) {
				if (event.getClickCount() == 1){
					updateTheData();
					PageNav.goToPage1(t);
				}
			}
		});
		pageTwo.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent event) {
				if (event.getClickCount() == 1){
					updateTheData();
					PageNav.goToPage2(t);
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
		pageFive.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent event) {
				if (event.getClickCount() == 1){
					updateTheData();
					PageNav.goToPage5(t);
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
				PageNav.goToPage4(t);
			}});
		backButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				updateTheData();
				PageNav.goToPage2(t);
			}
		});
		
		/******************************************/
		
		JLabel adminLabel = new JLabel("Copies");
		adminLabel.setBounds(15,45,100,20);
		adminLabel.setFont(Main.HEADERFONT);
		c.add(adminLabel);
		
		JLabel noteLabel = new JLabel("Only two selections may be made on this page.");
		noteLabel.setBounds(10,10,400,15);
		noteLabel.setFont(Main.REGFONT);
		mainJPanel.add(noteLabel);
		
		orpMastersBox = new JCheckBox("   Open Reel Preservation Masters (Non Sticky Shed)");
		orpMastersBox.setFont(Main.BIGFONT);
		orpMastersBox.setBackground(Main.BROWNCOLOR);
		orpMastersBox.setBounds(5,50,360,15);
		mainJPanel.add(orpMastersBox);
		orpMastersBox.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				String orpMaster = "orpMaster";
				onlyTwoChecked(orpMaster);
				updateTheData();
				updateTheUI();
			}
		});
		
		orpMastersStickyBox = new JCheckBox("   Open Reel Preservation Masters (Sticky Shed)");
		orpMastersStickyBox.setFont(Main.BIGFONT);
		orpMastersStickyBox.setBackground(Main.BROWNCOLOR);
		orpMastersStickyBox.setBounds(5,70,360,15);
		mainJPanel.add(orpMastersStickyBox);
		orpMastersStickyBox.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				String orpMasterSticky = "orpMasterSticky";
				onlyTwoChecked(orpMasterSticky);
				updateTheData();
				updateTheUI();
			}
		});
		
		orpNonMasterBox = new JCheckBox("   Open Reel, Polyester, Non-Preservation Masters");
		orpNonMasterBox.setFont(Main.BIGFONT);
		orpNonMasterBox.setBackground(Main.BROWNCOLOR);
		orpNonMasterBox.setBounds(5,90,360,15);
		mainJPanel.add(orpNonMasterBox);
		orpNonMasterBox.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				String orpNonMaster = "orpNonMaster";
				onlyTwoChecked(orpNonMaster);
				updateTheData();
				updateTheUI();
			}
		});
		
		oraBox = new JCheckBox("   Open Reel, Acetate");
		oraBox.setFont(Main.BIGFONT);
		oraBox.setBackground(Main.BROWNCOLOR);
		oraBox.setBounds(5,110,360,15);
		mainJPanel.add(oraBox);
		oraBox.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				String ora = "ora";
				onlyTwoChecked(ora);
				updateTheData();
				updateTheUI();
			}
		});
		
		cassetteBox = new JCheckBox("   Cassette-Analog, Audio");
		cassetteBox.setFont(Main.BIGFONT);
		cassetteBox.setBackground(Main.BROWNCOLOR);
		cassetteBox.setBounds(5,150,360,15);
		mainJPanel.add(cassetteBox);
		cassetteBox.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				String cassette = "cassette";
				onlyTwoChecked(cassette);
				updateTheData();
				updateTheUI();
			}
		});
		
		DATBox = new JCheckBox("   DAT (Digital Audio Tape)");
		DATBox.setFont(Main.BIGFONT);
		DATBox.setBackground(Main.BROWNCOLOR);
		DATBox.setBounds(5,170,360,15);
		mainJPanel.add(DATBox);
		DATBox.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				String DAT = "DAT";
				onlyTwoChecked(DAT);
				updateTheData();
				updateTheUI();
			}
		});
		
		cdDataBox = new JCheckBox("   CDs-Data Files");
		cdDataBox.setFont(Main.BIGFONT);
		cdDataBox.setBackground(Main.BROWNCOLOR);
		cdDataBox.setBounds(5,190,360,15);
		mainJPanel.add(cdDataBox);
		cdDataBox.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				String cdData = "cdData";
				onlyTwoChecked(cdData);
				updateTheData();
				updateTheUI();
			}
		});
		
		cdAudioBox = new JCheckBox("   CDs-Audio");
		cdAudioBox.setFont(Main.BIGFONT);
		cdAudioBox.setBackground(Main.BROWNCOLOR);
		cdAudioBox.setBounds(5,210,360,15);
		mainJPanel.add(cdAudioBox);
		cdAudioBox.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				String cdAudio = "cdAudio";
				onlyTwoChecked(cdAudio);
				updateTheData();
				updateTheUI();
			}
		});

		DACBox = new JCheckBox("   Digital File (Non-Preservation Masters)");
		DACBox.setFont(Main.BIGFONT);
		DACBox.setBackground(Main.BROWNCOLOR);
		DACBox.setBounds(5,250,360,15);
		mainJPanel.add(DACBox);
		DACBox.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				String DAC = "DAC";
				onlyTwoChecked(DAC);
				updateTheData();
				updateTheUI();
			}
		});
		
		newone = new JCheckBox("   Preservation (Archival) Master Files");
		newone.setFont(Main.BIGFONT);
		newone.setBackground(Main.BROWNCOLOR);
		newone.setBounds(5,290,360,15);
		mainJPanel.add(newone);
		newone.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				updateTheData();
				updateTheUI();
			}
		});
		
		JLabel newone1 = new JLabel("(Preservation Work Completed)");
		newone1.setFont(Main.BIGFONT);
		newone1.setBounds(35,310,360,15);
		mainJPanel.add(newone1);
		doComponentInitialization(this);
	}
	
	public void setVisible(boolean value) {
		super.setVisible(value);
		updateTheUI();
	}
	
	public void updateTheData() {
		Main.theData.orpMastersBox = orpMastersBox.isSelected();
		Main.theData.orpMastersStickyBox = orpMastersStickyBox.isSelected();
		Main.theData.orpNonMasterBox = orpNonMasterBox.isSelected();
		Main.theData.oraBox = oraBox.isSelected();
		Main.theData.DACBox = DACBox.isSelected();
		Main.theData.cassetteBox = cassetteBox.isSelected();
		Main.theData.DATBox = DATBox.isSelected();
		Main.theData.cdAudioBox = cdAudioBox.isSelected();
		Main.theData.cdDataBox = cdDataBox.isSelected();
		Main.theData.isPreserved = newone.isSelected();
	}
	
	private void updateTheUI() {
		summaryTextArea.setText("" + Main.theData.updateScoreBox());
	}
	
	private void onlyTwoChecked(String a){
		int count = 0;
		if (orpMastersBox.isSelected())
			count++;
		if(orpMastersStickyBox.isSelected())
			count++;
		if(orpNonMasterBox.isSelected())
			count++;
		if(oraBox.isSelected())
			count++;
		if(DACBox.isSelected())
			count++;
		if(cassetteBox.isSelected())
			count++;
		if(DATBox.isSelected())
			count++;
		if(cdAudioBox.isSelected())
			count++;
		if(cdDataBox.isSelected())
			count++;
		if(count > 2) {
			JOptionPane.showMessageDialog(null, "Please select no more than two" +
					" selections on this page.", "Error", JOptionPane.ERROR_MESSAGE);
			if (a.equals("orpMaster"))
				orpMastersBox.setSelected(false);
			if (a.equals("orpMasterSticky"))
				orpMastersStickyBox.setSelected(false);
			if(a.equals("orpNonMaster"))
				orpNonMasterBox.setSelected(false);
			if(a.equals("ora"))
				oraBox.setSelected(false);
			if(a.equals("DAC"))
				DACBox.setSelected(false);
			if(a.equals("DAT"))
				DATBox.setSelected(false);
			if(a.equals("cdData"))
				cdDataBox.setSelected(false);
			if(a.equals("cdAudio"))
				cdAudioBox.setSelected(false);
			if(a.equals("cassette"))
				cassetteBox.setSelected(false);
		}
		else
			nextButton.setEnabled(true);
	}
}

