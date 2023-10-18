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

package edu.indiana.dlib.sounddirections.facet.ui.dialogs;

import java.awt.*;
import javax.swing.*;

import edu.indiana.dlib.sounddirections.facet.*;
import edu.indiana.dlib.sounddirections.facet.ui.*;

public class EditNoise extends JDialog {
	
	JFrame theParent;
	JRadioButton dolbyA, dolbyB, dolbySR, dbx, none;
	JRadioButton dolbyC, dolbyS;
	ButtonGroup bgroup;
	JButton acceptButton;
	
	public EditNoise(JFrame parent) {
		theParent = parent;
		
		this.setModal(true);
		this.setTitle("Noise Reduction");
		this.setBounds(parent.getX() + 15, parent.getY() + 15, 200, 150);
		this.setResizable(false);
		
		Container c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Main.BROWNCOLOR);
		
		Font font3 = Main.REGFONT;
		
		JPanel mainJPanel = new JPanel();
		mainJPanel.setBounds(5,5,390,570);
		mainJPanel.setLayout(null);
		mainJPanel.setBackground(Main.BROWNCOLOR);
		c.add(mainJPanel);
		
		int reg = 5;
		
		if (!(theParent instanceof Screen2Cassette)) {
			dolbyA = new JRadioButton("   Dolby A");
			dolbyA.setFont(font3);
			dolbyA.setBounds(10, reg, 200,15);
			dolbyA.setBackground(Main.BROWNCOLOR);
			mainJPanel.add(dolbyA);
			reg = reg + 15;
		}
		
		dolbyB = new JRadioButton("   Dolby B");
		dolbyB.setFont(font3);
		dolbyB.setBounds(10, reg, 200,15);
		dolbyB.setBackground(Main.BROWNCOLOR);
		mainJPanel.add(dolbyB);
		reg = reg + 15;
		
		if (!(theParent instanceof Screen2Cassette)) {
			dolbySR = new JRadioButton("   Dolby SR");
			dolbySR.setFont(font3);
			dolbySR.setBounds(10, reg, 200,15);
			dolbySR.setBackground(Main.BROWNCOLOR);
			mainJPanel.add(dolbySR);
			reg = reg + 15;
		}
		
		if (theParent instanceof Screen2Cassette) {
			dolbyC = new JRadioButton("   Dolby C");
			dolbyC.setFont(font3);
			dolbyC.setBackground(Main.BROWNCOLOR);
			dolbyC.setBounds(10, reg, 200,15);
			mainJPanel.add(dolbyC);
			reg = reg + 15;
			
			dolbyS = new JRadioButton("   Dolby S");
			dolbyS.setFont(font3);
			dolbyS.setBounds(10, reg, 200,15);
			dolbyS.setBackground(Main.BROWNCOLOR);
			mainJPanel.add(dolbyS);
			reg = reg + 15;
		}
		
		dbx = new JRadioButton("   dbx");
		dbx.setFont(font3);
		dbx.setBounds(10, reg, 200,15);
		dbx.setBackground(Main.BROWNCOLOR);
		mainJPanel.add(dbx);
		reg = reg + 15;
		
		none = new JRadioButton("   None");
		none.setFont(font3);
		none.setBounds(10, reg, 200,15);
		none.setBackground(Main.BROWNCOLOR);
		mainJPanel.add(none);
		
		bgroup = new ButtonGroup();
		bgroup.add(dolbyA);
		bgroup.add(dolbyB);
		bgroup.add(dolbySR);
		bgroup.add(dbx);
		bgroup.add(none);
		bgroup.add(dolbyC);
		bgroup.add(dolbyS);
		
		acceptButton = new JButton("Accept");
		acceptButton.setBounds(5,85,80,27);
		mainJPanel.add(acceptButton);
		acceptButton.setFont(font3);
		acceptButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				updateTheUI();
				setVisible(false);
			}
		});
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBounds(90,85,80,27);
		cancelButton.setFont(font3);
		mainJPanel.add(cancelButton);
		cancelButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				setVisible(false);
			}
		});
		selectCorrectButton();
		this.setVisible(true);
	}
	
	private void selectCorrectButton() {
		none.setSelected(true);
		if (theParent instanceof Screen2ORTacetate) {
			if (Main.theData.dolbyAacetate) {
				dolbyA.setSelected(true);
			} else if (Main.theData.dolbyBacetate) {
				dolbyB.setSelected(true);
			} else if (Main.theData.dolbySRacetate) {
				dolbySR.setSelected(true);
			} else if (Main.theData.dbxAcetate) {
				dbx.setSelected(true);
			}
		} else if (theParent instanceof Screen2ORTpolyester) {
			if (Main.theData.dolbyApoly) {
				dolbyA.setSelected(true);
			} else if (Main.theData.dolbyBpoly) {
				dolbyB.setSelected(true);
			} else if (Main.theData.dolbySRpoly) {
				dolbySR.setSelected(true);
			} else if (Main.theData.dbxPoly) {
				dbx.setSelected(true);
			}
		} else if (theParent instanceof Screen2ORTpvc) {
			if (Main.theData.dolbyAPVC) {
				dolbyA.setSelected(true);
			} else if (Main.theData.dolbyBPVC) {
				dolbyB.setSelected(true);
			} else if (Main.theData.dolbySRPVC) {
				dolbySR.setSelected(true);
			} else if (Main.theData.dbxPVC) {
				dbx.setSelected(true);
			}
		} else if (theParent instanceof Screen2Cassette) {
			if (Main.theData.dolbyBcassette) {
				dolbyB.setSelected(true);
			} else if (Main.theData.dolbyCcassette) {
				dolbyC.setSelected(true);
			} else if (Main.theData.dolbyScassette) {
				dolbyS.setSelected(true);
			} else if (Main.theData.dbxcassette) {
				dbx.setSelected(true);
			}
		}
	}
	
	private void updateTheUI(){
		if (theParent instanceof Screen2ORTacetate) {
			Main.theData.dolbyAacetate = dolbyA.isSelected();
			Main.theData.dolbyBacetate = dolbyB.isSelected();
			Main.theData.dolbySRacetate = dolbySR.isSelected();
			Main.theData.dbxAcetate = dbx.isSelected();
			((Screen2ORTacetate)theParent).summaryTextArea.setText("" + Main.theData.updateScoreBox());
		} else if (theParent instanceof Screen2ORTpolyester) {
			Main.theData.dolbyApoly = dolbyA.isSelected();
			Main.theData.dolbyBpoly = dolbyB.isSelected();
			Main.theData.dolbySRpoly = dolbySR.isSelected();
			Main.theData.dbxPoly = dbx.isSelected();
			((Screen2ORTpolyester)theParent).summaryTextArea.setText("" + Main.theData.updateScoreBox());
		} else if (theParent instanceof Screen2ORTpvc) {
			Main.theData.dolbyAPVC = dolbyA.isSelected();
			Main.theData.dolbyBPVC = dolbyB.isSelected();
			Main.theData.dolbySRPVC = dolbySR.isSelected();
			Main.theData.dbxPVC = dbx.isSelected();
			((Screen2ORTpvc)theParent).summaryTextArea.setText("" + Main.theData.updateScoreBox());
		} else if (theParent instanceof Screen2Cassette) {
			Main.theData.dolbyBcassette = dolbyB.isSelected();
			Main.theData.dolbyCcassette = dolbyC.isSelected();
			Main.theData.dolbyScassette = dolbyS.isSelected();
			Main.theData.dbxcassette = dbx.isSelected();
			((Screen2Cassette)theParent).summaryTextArea.setText("" + Main.theData.updateScoreBox());
		}
	}
}
