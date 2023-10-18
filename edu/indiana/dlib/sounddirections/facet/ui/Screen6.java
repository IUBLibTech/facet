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
import javax.swing.*;
import javax.swing.border.*;
import java.awt.print.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import edu.indiana.dlib.sounddirections.facet.*;
import edu.indiana.dlib.sounddirections.facet.util.*;

public class Screen6 extends EditWindow {

	JEditorPane summaryTextAreaLeft;
	JEditorPane summaryTextAreaRight;
	JScrollPane summaryScrollPaneLeft;
	JPanel summaryJPanelLeft;
	JButton printButton;
	boolean saved = false;

	public Screen6() {
		
		this.setTitle("Summary - FACET [" + Main.theData.collectionNumber + "]");
		summaryTextArea.setVisible(false);
		
		JLabel adminLabel = new JLabel("<html><body>Summary</body></html>");
		adminLabel.setBounds(15,45,450,20);
		adminLabel.setFont(Main.HEADERFONT);
		c.add(adminLabel);
		summaryLabel.setBounds(30,5,150,20);
		pageSummary.setForeground(Color.black);
		pageSummary.setText("Summary");
		final Screen6 t = this;
		pageOne.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent event) {
				if (event.getClickCount() == 1){
					PageNav.goToPage1(t);
				}
			}
		});
		pageTwo.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent event) {
				if (event.getClickCount() == 1){
					PageNav.goToPage2(t);
				}
			}
		});
		pageThree.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent event) {
				if (event.getClickCount() == 1){
					PageNav.goToPage3(t);
				}
			}
		});
		pageFive.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent event) {
				if (event.getClickCount() == 1){
					PageNav.goToPage5(t);
				}
			}
		});
		pageFour.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent event) {
				if (event.getClickCount() == 1){
					PageNav.goToPage4(t);
				}
			}
		});
		cancelButton.setVisible(false);
		nextButton.setVisible(false);
		backButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				PageNav.goToPage5(t);
			}
		});
		
		summaryJPanelLeft = new JPanel();
		summaryJPanelLeft.setBounds(5,30,350,420);
		summaryJPanelLeft.setBorder(new LineBorder(Color.BLACK));
		summaryJPanelLeft.setLayout(null);
		summaryJPanelLeft.setBackground(Main.BROWNCOLOR);
		mainJPanel.add(summaryJPanelLeft);
		
		summaryTextAreaLeft = new JEditorPane();
		summaryTextAreaLeft.setEditable(false);
		summaryTextAreaLeft.setMargin(new Insets(3, 3, 3, 3));
		summaryTextAreaLeft.setFont(Main.REGFONT);
		summaryTextAreaLeft.setContentType("text/html");
		
		summaryTextAreaRight = new JEditorPane();
		summaryTextAreaRight.setEditable(false);
		summaryTextAreaRight.setMargin(new Insets(3, 3, 3, 3));
		summaryTextAreaRight.setFont(Main.REGFONT);
		summaryTextAreaRight.setContentType("text/html");
		JScrollPane summaryScrollPanex = new JScrollPane(summaryTextAreaRight);
		summaryScrollPanex.setBackground(Main.BROWNCOLOR);
		summaryScrollPanex.setBounds(5,5,340,410);
		summaryScrollPane.setVisible(false);
		summaryJPanel.add(summaryScrollPanex);
		
		summaryScrollPaneLeft = new JScrollPane(summaryTextAreaLeft);
		summaryScrollPaneLeft.setBackground(Main.BROWNCOLOR);
		summaryScrollPaneLeft.setBounds(5,5,340,410);
		summaryJPanelLeft.add(summaryScrollPaneLeft);
		
		printButton = new JButton("Export/Print");
		printButton.setBounds(185,478,115,27);
		printButton.setFont(Main.REGFONT);
		mainJPanel.add(printButton);
		printButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				printIt();
			}
		});
		
		JButton homeButton = new JButton("Close");
		homeButton.setBounds(600,478,85,27);
		homeButton.setFont(Main.REGFONT);
		mainJPanel.add(homeButton);
		homeButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				goHome();
			}
		});
		
		JButton saveButton = new JButton("Save");
		saveButton.setBounds(300,478,85,27);
		saveButton.setFont(Main.REGFONT);
		mainJPanel.add(saveButton);
		saveButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				saveRecord();
			}
		});
		summaryLabel.setVisible(false);
		doComponentInitialization(this);
		
	}
	public void setVisible(boolean value) {
		super.setVisible(value);
		updateTheUI();
	}
	
	void printIt() {	
		String full = summaryTextAreaLeft.getText() + "<br><br>" + summaryTextAreaRight.getText();
		HTMLFilter HTMLfilt = new HTMLFilter();
        JFileChooser fc = new JFileChooser();
        fc.setAcceptAllFileFilterUsed(false);
        fc.addChoosableFileFilter(HTMLfilt);
        fc.setMultiSelectionEnabled(false);
        int returnVal = fc.showSaveDialog(this);
        fc.removeChoosableFileFilter(HTMLfilt);
        if (returnVal == JFileChooser.CANCEL_OPTION) {
            return;
        }
        String fileName = fc.getSelectedFile().getPath();
        if ((!(fileName.endsWith(".htm"))) && (!(fileName.endsWith(".html")))) {
        	fileName = fileName + ".html";
        }
		File file = new File(fileName);
		if (file.exists()) {
			int x = JOptionPane.showConfirmDialog(this, "File already exists. Overwrite?", "Overwrite?", JOptionPane.YES_NO_OPTION);
			if (x == JOptionPane.NO_OPTION) {
				return;
			}
			file.delete();
		}
		try {
			file.createNewFile();
			BufferedWriter output = new BufferedWriter(new FileWriter(file));
			output.write(full);
			output.flush();
			output.close();
		} catch (Exception err) {
			err.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error exporting results", "Error exporting results", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void updateTheUI() {
		summaryTextAreaRight.setText("" + Main.theData.updateLastScreenRight());
		summaryTextAreaRight.setCaretPosition(0);
		
		summaryTextAreaLeft.setText("" + Main.theData.updateLastScreenLeft());
		summaryTextAreaLeft.setCaretPosition(0);
	}
	
	private void saveRecord() {
		if (Main.theData.saveRecord()) {
			JOptionPane.showMessageDialog(null, "Your record was successfully saved!", "Saved", JOptionPane.INFORMATION_MESSAGE);
			saved = true;
			Main.theData.isDirty = false;
			if (Main.windowSearch != null) {
				if (Main.windowSearch.isVisible()) {
					Main.windowSearch.doSearch(true);
					this.toFront();
				}
			}
		}
	}
	
	private void goHome() {
		if (Main.theData.isDirty && (!saved)) {
			int response = JOptionPane.showConfirmDialog(null, "You have not yet saved this record. Save now?", "Save record?", JOptionPane.YES_NO_CANCEL_OPTION);
			if (response == JOptionPane.CANCEL_OPTION) {
				return;
			}
			if (response == JOptionPane.YES_OPTION) {
				Main.theData.saveRecord();
				if (Main.windowSearch != null) {
					if (Main.windowSearch.isVisible()) {
						Main.windowSearch.doSearch(true);
					}
				}
			}
		}
		this.setVisible(false);
	}
	
}
