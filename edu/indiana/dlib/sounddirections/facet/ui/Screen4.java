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
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;
import edu.indiana.dlib.sounddirections.facet.data.*;
import edu.indiana.dlib.sounddirections.facet.ui.dialogs.*;
import edu.indiana.dlib.sounddirections.facet.*;
import edu.indiana.dlib.sounddirections.facet.util.*;

public class Screen4 extends EditWindow {
	
	public JCheckBox historyBox;
	public JButton deleteButton, editButton;
	public JTable dataTable;
	DefaultTableModel tm = new DefaultTableModel();
	
	public Screen4() {
		this.setTitle("Storage History and Other Factors - FACET [" + Main.theData.collectionNumber + "]");
		
		JLabel adminLabel = new JLabel("Storage History and Other Factors");
		adminLabel.setBounds(15,45,450,20);
		adminLabel.setFont(Main.HEADERFONT);
		c.add(adminLabel);
		
		pageFour.setForeground(Color.black);
		pageFour.setText("<html><body>4</body></html>");
		final Screen4 t = this;
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
		pageThree.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent event) {
				if (event.getClickCount() == 1){
					updateTheData();
					PageNav.goToPage3(t);
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
				PageNav.goToPage5(t);
			}});
		backButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				updateTheData();
				PageNav.goToPage3(t);
			}
		});
		
		JLabel historyLabel = new JLabel("History");
		historyLabel.setBounds(15,5,100,20);
		historyLabel.setFont(Main.BIGFONT);
		mainJPanel.add(historyLabel);
		
		JPanel historyJPanel = new JPanel();
		historyJPanel.setBounds(25,30,300,50);
		historyJPanel.setBackground(Main.BROWNCOLOR);
		historyJPanel.setLayout(null);
		mainJPanel.add(historyJPanel);
		
		historyBox = new JCheckBox("   Storage History Problems");
		historyBox.setFont(Main.BIGFONT);
		historyBox.setBackground(Main.BROWNCOLOR);
		historyBox.setBounds(5,5,200,15);
		historyJPanel.add(historyBox);
		historyBox.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				Main.theData.historyBox = historyBox.isSelected();
				updateTheUI();
			}
		});
		
		JLabel otherFactorsLabel = new JLabel("Other Factors");
		otherFactorsLabel.setBounds(15,90,150,20);
		otherFactorsLabel.setFont(Main.BIGFONT);
		mainJPanel.add(otherFactorsLabel);
		
		JPanel tableJpanel = new JPanel();
		tableJpanel.setBounds(25,115,370,200);
		tableJpanel.setBorder(new LineBorder(Color.BLACK));
		tableJpanel.setLayout(null);
		tableJpanel.setBackground(Main.BROWNCOLOR);
		mainJPanel.add(tableJpanel);
		
		dataTable = new JTable(tm) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		dataTable.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent event) {
				if (event.getClickCount() == 2) {
					Main.theData.isDirty = true;
					openEditTableEDIT();
					updateTable();
				}
			}
		});
		dataTable.setFont(Main.REGFONT);
		ListSelectionModel rowSM = dataTable.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) return;
                ListSelectionModel lsm = (ListSelectionModel)e.getSource();
                if (lsm.isSelectionEmpty()) {
                    //no rows selected
                	deleteButton.setEnabled(false);
                } else {
                    deleteButton.setEnabled(true);
                }
            }
        });
		
		JScrollPane tableScrollPane = new JScrollPane(dataTable);
		tableScrollPane.setBounds(5,5,360,160);
		tableScrollPane.setBackground(Main.BROWNCOLOR);
		tableJpanel.add(tableScrollPane);
		
		JButton newButton = new JButton("New");
		newButton.setBounds(5,168,65,27);
		newButton.setFont(Main.REGFONT);
		tableJpanel.add(newButton);
		newButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				openEditTable();
				updateTable();
			}
		});
		
		ListSelectionModel newRowSM = dataTable.getSelectionModel();
		newRowSM.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) return;
                ListSelectionModel lsm = (ListSelectionModel)e.getSource();
                if (lsm.isSelectionEmpty()) {
                    //no rows selected
                	editButton.setEnabled(false);
                } else {
                    editButton.setEnabled(true);
                }
            }
        });
		
		editButton = new JButton("Edit");
		editButton.setBounds(75,168,65,27);
		editButton.setEnabled(false);
		editButton.setFont(Main.REGFONT);
		tableJpanel.add(editButton);
		editButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				openEditTableEDIT();
				updateTable();
			}
		});
		
		deleteButton = new JButton("Delete");
		deleteButton.setBounds(145,168,75,27);
		deleteButton.setFont(Main.REGFONT);
		tableJpanel.add(deleteButton);
		deleteButton.setEnabled(false);
		deleteButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.theData.isDirty = true;
				deleteRecord();
				
			}
		});
		
		updateTable();
		doComponentInitialization(this);
		
	}
	
	public void setVisible(boolean value) {
		super.setVisible(value);
		updateTheUI();
	}
	public void updateTheData(){
		Main.theData.historyBox = historyBox.isSelected();
	}
	
	public void updateTable() {
		DecimalFormat threeDigits = new DecimalFormat("0.000");
		
		tm.setColumnCount(2);
		tm.setRowCount(Main.theData.modPoints.size());
		
		dataTable.getColumnModel().getColumn(0).setHeaderValue("Add/Deduct");
		dataTable.getColumnModel().getColumn(1).setHeaderValue("Explanation");
		
		dataTable.setAutoscrolls(true);
		dataTable.getColumnModel().getColumn(0).setPreferredWidth(10);
		
		int counter = 0;
		while (counter < Main.theData.modPoints.size()) {
			ModData md = (ModData)Main.theData.modPoints.get(counter);

			tm.setValueAt(String.valueOf(threeDigits.format(md.pointsAdded)), counter, 0);
			tm.setValueAt(md.explanationText, counter, 1);
			counter = counter + 1;
		}
		dataTable.setModel(tm);
		dataTable.getColumnModel().getColumn(0).setPreferredWidth(100);
		dataTable.getColumnModel().getColumn(1).setPreferredWidth(500);
	}
	
	private void openEditTable() {
		new EditOtherFactors(this);
	}
	
	private void openEditTableEDIT(){
		int row = dataTable.getSelectedRow();
		double value = Double.valueOf((String)dataTable.getValueAt(dataTable.getSelectedRow(),0)).doubleValue();
		
		String one = "" + dataTable.getValueAt(row, 1);
		new EditOtherFactors(this, value, one);
	}
	
	private void deleteRecord() { 
		Main.theData.modPoints.remove(dataTable.getSelectedRow());
		updateTable();
		updateTheUI();
	}
	
	private void updateTheUI() {
		summaryTextArea.setText("" + Main.theData.updateScoreBox());
	}
	
}