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

import java.math.*;

import edu.indiana.dlib.sounddirections.facet.*;
import edu.indiana.dlib.sounddirections.facet.data.*;
import edu.indiana.dlib.sounddirections.facet.ui.*;

public class EditOtherFactors extends ParentDialog {
	
	JComboBox pointsAddedSpinner;
	JTextArea explanationText;
	Font font = Main.REGFONT;
	Screen4 theParent;
	double points = 0;
	String explanation = "";
	String notes = "";
	JButton acceptButton;
	boolean isNew = false;
	
	public EditOtherFactors(Screen4 parent, double pointsAdded, String explanation) {
		theParent = parent;
		points = pointsAdded;
		this.explanation = explanation;
		isNew = false;
		this.setBounds(parent.getX() + 35, parent.getY() + 35, 400, 360);
		init();
	}
	
	public EditOtherFactors(Screen4 parent) {
		theParent = parent;
		isNew = true;
		this.setBounds(parent.getX() + 35, parent.getY() + 45, 400, 360);
		init();
	}
	
	private void init() {
		this.setModal(true);
		this.setTitle("Point Modification - FACET");
		this.setResizable(false);
		
		Container c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Main.BROWNCOLOR);
		
		JPanel otherFactorsJPanel = new JPanel();
		otherFactorsJPanel.setBounds(5,5,390,325);
		otherFactorsJPanel.setLayout(null);
		c.add(otherFactorsJPanel);
		otherFactorsJPanel.setBackground(Main.BROWNCOLOR);
		
		JLabel pointsAddedLabel = new JLabel("Points added/deducted: ");
		pointsAddedLabel.setFont(font);
		pointsAddedLabel.setBounds(10,10,150,15);
		otherFactorsJPanel.add(pointsAddedLabel);
		
		pointsAddedSpinner = new JComboBox();
		pointsAddedSpinner.setBounds(155,7,60,24);
		pointsAddedSpinner.setFont(font);
		otherFactorsJPanel.add(pointsAddedSpinner);
		
		pointsAddedSpinner.setEditable(true);
		pointsAddedSpinner.addItem("5.00");
		pointsAddedSpinner.addItem("4.75");
		pointsAddedSpinner.addItem("4.50");
		pointsAddedSpinner.addItem("4.25");
		pointsAddedSpinner.addItem("4.00");
		pointsAddedSpinner.addItem("3.75");
		pointsAddedSpinner.addItem("3.50");
		pointsAddedSpinner.addItem("3.25");
		pointsAddedSpinner.addItem("3.00");
		pointsAddedSpinner.addItem("2.75");
		pointsAddedSpinner.addItem("2.50");
		pointsAddedSpinner.addItem("2.25");
		pointsAddedSpinner.addItem("2.00");
		pointsAddedSpinner.addItem("1.75");
		pointsAddedSpinner.addItem("1.50");
		pointsAddedSpinner.addItem("1.25");
		pointsAddedSpinner.addItem("1.00");
		pointsAddedSpinner.addItem("0.75");
		pointsAddedSpinner.addItem("0.50");
		pointsAddedSpinner.addItem("0.25");
		pointsAddedSpinner.addItem("0.00");
		pointsAddedSpinner.addItem("-0.25");
		pointsAddedSpinner.addItem("-0.50");
		pointsAddedSpinner.addItem("-0.75");
		pointsAddedSpinner.addItem("-1.00");
		pointsAddedSpinner.addItem("-1.25");
		pointsAddedSpinner.addItem("-1.50");
		pointsAddedSpinner.addItem("-1.75");
		pointsAddedSpinner.addItem("-2.00");
		pointsAddedSpinner.addItem("-2.25");
		pointsAddedSpinner.addItem("-2.50");
		pointsAddedSpinner.addItem("-2.75");
		pointsAddedSpinner.addItem("-3.00");
		pointsAddedSpinner.addItem("-3.25");
		pointsAddedSpinner.addItem("-3.50");
		pointsAddedSpinner.addItem("-3.75");
		pointsAddedSpinner.addItem("-4.00");
		pointsAddedSpinner.addItem("-4.25");
		pointsAddedSpinner.addItem("-4.50");
		pointsAddedSpinner.addItem("-4.75");
		pointsAddedSpinner.addItem("-5.00");
		
		pointsAddedSpinner.setSelectedItem("0.00");

		JLabel explanationLabel = new JLabel("Explanation: ");
		explanationLabel.setFont(font);
		explanationLabel.setBounds(10,40,180,20);
		otherFactorsJPanel.add(explanationLabel);
		
		explanationText = new JTextArea();
		explanationText.setText(explanation);
		explanationText.setEditable(true);
		explanationText.setFont(font);
		explanationText.setWrapStyleWord(true);
		explanationText.setLineWrap(true);
		
		JScrollPane explanationScrollPane = new JScrollPane (explanationText);
		explanationScrollPane.setBounds(105,40,275,240);
		otherFactorsJPanel.add(explanationScrollPane);
		
		acceptButton = new JButton("Accept");
		acceptButton.setBounds(5,290,80,27);
		otherFactorsJPanel.add(acceptButton);
		acceptButton.setFont(font);
		acceptButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				if (updateTheUI()) {
					setVisible(false);
				}
			}
		});
		
		JButton clearButton = new JButton("Clear");
		clearButton.setBounds(100,290,80,27);
		otherFactorsJPanel.add(clearButton);
		clearButton.setFont(font);
		clearButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				explanationText.setText("");
				pointsAddedSpinner.setSelectedItem("0.00");
			}
		});
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBounds(195,290,80,27);
		cancelButton.setFont(font);
		otherFactorsJPanel.add(cancelButton);
		cancelButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				setVisible(false);
			}
		});
		
		if (!(explanation.equals(""))) {
			explanationText.setText(explanation);
		}
		if (!(points==0)) {
			BigDecimal d = new BigDecimal(points).setScale(2, BigDecimal.ROUND_HALF_UP);
			BigDecimal d3 = new BigDecimal(points).setScale(3, BigDecimal.ROUND_HALF_UP);
			String x = d.toString() + "0";
			if (x.equals(d3.toString())) {
				pointsAddedSpinner.setSelectedItem(d.toString());
			} else {
				pointsAddedSpinner.setSelectedItem(d3.toString());
			}
			
		}
		doComponentInitialization(this);
		((JTextField)pointsAddedSpinner.getEditor().getEditorComponent()).selectAll();
		this.setVisible(true);
	}
	
	private boolean updateTheUI() {
		String amt = (String)pointsAddedSpinner.getSelectedItem();
		Double amtD = null;
		try {
			amtD = Double.valueOf(amt);
		} catch (Exception err) {
			JOptionPane.showMessageDialog(this, "Incorrect point value", "Incorrect point value", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		double pointsAdded = amtD.doubleValue();
		ModData md = new ModData();
		md.explanationText = explanationText.getText();
		md.pointsAdded = pointsAdded;
		if (isNew) {
			if (pointsAdded != 0) {
				Main.theData.modPoints.add(md);
			}
		} else {
			if (pointsAdded != 0) {
				Main.theData.modPoints.set(theParent.dataTable.getSelectedRow(), md);
			} else {
				Main.theData.modPoints.remove(theParent.dataTable.getSelectedRow());
			}
		}
		theParent.summaryTextArea.setText("" + Main.theData.updateScoreBox());
		return true;
	}
}
