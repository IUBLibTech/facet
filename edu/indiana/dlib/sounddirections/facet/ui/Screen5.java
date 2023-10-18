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
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import edu.indiana.dlib.sounddirections.facet.util.*;
import edu.indiana.dlib.sounddirections.facet.*;

public class Screen5 extends EditWindow {
	
	public JTextArea notesText;
	public JComboBox researchValueSpinner;
	public JButton acceptTextButton, clearTextButton;
	
	public Screen5() {
		this.setTitle("Notes and Research Value - FACET [" + Main.theData.collectionNumber + "]");
		
		pageFive.setForeground(Color.black);
		pageFive.setText("<html><body>5</body></html>");
		final Screen5 t = this;
		pageOne.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent event) {
				if (event.getClickCount() == 1){
					if (updateTheData()) {
						PageNav.goToPage1(t);
					}
				}
			}
		});
		pageTwo.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent event) {
				if (event.getClickCount() == 1){
					if (updateTheData()) {
						PageNav.goToPage2(t);
					}
				}
			}
		});
		pageThree.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent event) {
				if (event.getClickCount() == 1){
					if (updateTheData()) {
						PageNav.goToPage3(t);
					}
				}
			}
		});
		pageFour.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent event) {
				if (event.getClickCount() == 1){
					if (updateTheData()) {
						PageNav.goToPage4(t);
					}
				}
			}
		});
		pageSummary.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent event) {
				if (event.getClickCount() == 1){
					if (updateTheData()) {
						PageNav.goToSummary(t);
					}
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
				if (updateTheData()) {
					PageNav.goToSummary(t);
				}
			}});
		backButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				if (updateTheData()) {
					PageNav.goToPage4(t);
				}
			}
		});
		
		
		JLabel adminLabel = new JLabel("Notes and Research Value");
		adminLabel.setBounds(15,45,450,20);
		adminLabel.setFont(Main.HEADERFONT);
		c.add(adminLabel);

		JLabel researchValueLabel = new JLabel("Research Value Score (If Applicable)");
		researchValueLabel.setFont(Main.BIGFONT);
		researchValueLabel.setBounds(10,15,250,15);
		mainJPanel.add(researchValueLabel);
		
		JLabel ifApplicableLabel = new JLabel(" ");
		ifApplicableLabel.setFont(Main.REGFONT);
		ifApplicableLabel.setBounds(165,15,90,15);
		mainJPanel.add(ifApplicableLabel);
		
		researchValueSpinner = new JComboBox();
		researchValueSpinner.setEditable(true);
		researchValueSpinner.addItem("5.00");
		researchValueSpinner.addItem("4.75");
		researchValueSpinner.addItem("4.50");
		researchValueSpinner.addItem("4.25");
		researchValueSpinner.addItem("4.00");
		researchValueSpinner.addItem("3.75");
		researchValueSpinner.addItem("3.50");
		researchValueSpinner.addItem("3.25");
		researchValueSpinner.addItem("3.00");
		researchValueSpinner.addItem("2.75");
		researchValueSpinner.addItem("2.50");
		researchValueSpinner.addItem("2.25");
		researchValueSpinner.addItem("2.00");
		researchValueSpinner.addItem("1.75");
		researchValueSpinner.addItem("1.50");
		researchValueSpinner.addItem("1.25");
		researchValueSpinner.addItem("1.00");
		researchValueSpinner.addItem("0.75");
		researchValueSpinner.addItem("0.50");
		researchValueSpinner.addItem("0.25");
		researchValueSpinner.addItem("0.00");
		researchValueSpinner.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
			}
		});
		
		researchValueSpinner.setSelectedItem("0.00");
		researchValueSpinner.setBounds(250,10,60,27);
		researchValueSpinner.setFont(Main.REGFONT);
		mainJPanel.add(researchValueSpinner);

		JLabel notesLabel = new JLabel("Notes");
		notesLabel.setFont(Main.BIGFONT);
		notesLabel.setBounds(15,100,50,15);
		mainJPanel.add(notesLabel);
		
		notesText = new JTextArea();
		notesText.setEditable(true);
		notesText.setFont(Main.REGFONT);
		notesText.setWrapStyleWord(true);
		notesText.setLineWrap(true);
		notesText.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Main.theData.isDirty = true;
			}
		});
		
		JScrollPane notesTextPane = new JScrollPane(notesText);
		notesTextPane.setBounds(10,125,350,200);
		mainJPanel.add(notesTextPane);

		clearTextButton = new JButton("Clear");
		clearTextButton.setFont(Main.REGFONT);
		clearTextButton.setBounds(10,335,75,27);
		mainJPanel.add(clearTextButton);
		clearTextButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				clearText();
			}
		});

		doComponentInitialization(this);
		
	}
	
	public void setVisible(boolean value) {
		super.setVisible(value);
		updateTheUI();
	}
	
	public boolean updateTheData(){
		String amt = (String)researchValueSpinner.getSelectedItem();
		Double amtD = null;
		if (amt.trim().equals("")) {
			amtD = Double.valueOf(0.00d);
		} else {
			try {
				amtD = Double.valueOf(amt);
			} catch (Exception err) {
				JOptionPane.showMessageDialog(this, "Incorrect point value", "Incorrect point value", JOptionPane.ERROR_MESSAGE);
				amtD = new Double(0.00d);
				researchValueSpinner.requestFocus();
				((JTextField)researchValueSpinner.getEditor().getEditorComponent()).selectAll();
				return false;
			}
		}
		if (amtD.doubleValue() < 0) {
			JOptionPane.showMessageDialog(this, "Incorrect point value", "Incorrect point value", JOptionPane.ERROR_MESSAGE);
			amtD = new Double(0.00d);
			return false;
		}
		
		double pointsAdded = amtD.doubleValue();
		Main.theData.researchValue = pointsAdded;
		Main.theData.notes4_5 = notesText.getText();
		updateTheUI();
		return true;
	}
	
	private void clearText(){
		notesText.setText("");
		Main.theData.notes4_5 = notesText.getText();
		updateTheUI();
	}

	private void updateTheUI() {		
		summaryTextArea.setText("" + Main.theData.updateScoreBox());
	}
	
}