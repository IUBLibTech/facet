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
import edu.indiana.dlib.sounddirections.facet.*;

/**
 * Parent to all main record edit windows
 */
public class EditWindow extends ParentWindow {
	
	protected Container c;
	JPanel summaryJPanel;
	public JTextArea summaryTextArea;
	JPanel mainJPanel;
	JLabel summaryLabel;
	JScrollPane summaryScrollPane;
	JPanel navigationPanel;
	JLabel pageLabel;
	JLabel pageOne;
	JLabel pageTwo;
	JLabel pageThree;
	JLabel pageFour;
	JLabel pageFive;
	JLabel pageSummary;
	JButton backButton;
	JButton nextButton;
	JButton cancelButton;
	
	public EditWindow() {
		super();
		this.setSize(800,630);
		this.setResizable(false);
		
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Main.BROWNCOLOR);
		
		mainJPanel = new JPanel();
		mainJPanel.setBounds(15,75,765,510);
		mainJPanel.setBorder(null);
		mainJPanel.setBackground(Main.BROWNCOLOR);
		mainJPanel.setLayout(null);
		c.add(mainJPanel);
		
		JPanel extraPanel = new JPanel();
		extraPanel.setBounds(0,0,800,30);
		extraPanel.setBackground(Main.BLUECOLOR);
		extraPanel.setLayout(null);
		c.add(extraPanel);
		
		JLabel facetLabel = new JLabel("FACET");
		facetLabel.setBounds(15,5,450,20);
		facetLabel.setFont(Main.HEADERFONT);
		extraPanel.add(facetLabel);
		
		summaryLabel = new JLabel("Summary:");
		summaryLabel.setFont(Main.BIGFONT);
		summaryLabel.setBounds(410,5,150,20);
		mainJPanel.add(summaryLabel);
		
		summaryJPanel = new JPanel();
		summaryJPanel.setBounds(400,30,350,420);
		summaryJPanel.setBorder(new LineBorder(Color.BLACK));
		summaryJPanel.setLayout(null);
		summaryJPanel.setBackground(Main.BROWNCOLOR);
		mainJPanel.add(summaryJPanel);
		
		summaryTextArea = new JTextArea();
		summaryTextArea.setEditable(false);
		summaryTextArea.setMargin(new Insets(3, 3, 3, 3));
		summaryTextArea.setFont(Main.REGFONT);
		summaryTextArea.setWrapStyleWord(true);
		summaryTextArea.setLineWrap(true);
		
		summaryScrollPane = new JScrollPane(summaryTextArea);
		summaryScrollPane.setBackground(Main.BLUECOLOR);
		summaryScrollPane.setBounds(5,5,340,410);
		summaryJPanel.add(summaryScrollPane);
		
		navigationPanel = new JPanel();
		navigationPanel.setBounds(615,40,170,27);
		navigationPanel.setLayout(null);
		navigationPanel.setBackground(Main.BROWNCOLOR);
		c.add(navigationPanel);
		
		pageLabel = new JLabel("Page: ");
		pageLabel.setBounds(1,1,42,18);
		pageLabel.setFont(Main.BIGFONT);
		navigationPanel.add(pageLabel);
		
		pageOne = new JLabel("<html><body><u>1</u></body></html>");
		pageOne.setBounds(42,1,10,18);
		pageOne.setFont(Main.BIGFONT);
		pageOne.setForeground(Color.BLUE);
		pageOne.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseEntered(java.awt.event.MouseEvent event) {
				Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(handCursor);
			}
			public void mouseExited(java.awt.event.MouseEvent event) {
				Cursor handCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(handCursor);
			}
		});
		navigationPanel.add(pageOne);

		pageTwo = new JLabel("<html><body><u>2</u></body></html>");
		pageTwo.setBounds(54,1,10,18);
		pageTwo.setFont(Main.BIGFONT);
		pageTwo.setForeground(Color.BLUE);
		pageTwo.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseEntered(java.awt.event.MouseEvent event) {
				Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(handCursor);
			}
			public void mouseExited(java.awt.event.MouseEvent event) {
				Cursor handCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(handCursor);
			}
		});
		navigationPanel.add(pageTwo);
		
		pageThree = new JLabel("<html><body><u>3</u></body></html>");
		pageThree.setBounds(66,1,10,18);
		pageThree.setFont(Main.BIGFONT);
		pageThree.setForeground(Color.BLUE);
		pageThree.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseEntered(java.awt.event.MouseEvent event) {
				Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(handCursor);
			}
			public void mouseExited(java.awt.event.MouseEvent event) {
				Cursor handCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(handCursor);
			}
		});
		navigationPanel.add(pageThree);
		
		pageFour = new JLabel("<html><body><u>4</u></body></html>");
		pageFour.setBounds(78,1,10,18);
		pageFour.setFont(Main.BIGFONT);
		pageFour.setForeground(Color.BLUE);
		pageFour.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseEntered(java.awt.event.MouseEvent event) {
				Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(handCursor);
			}
			public void mouseExited(java.awt.event.MouseEvent event) {
				Cursor handCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(handCursor);
			}
		});
		navigationPanel.add(pageFour);
		
		pageFive = new JLabel("<html><body><u>5</u></body></html>");
		pageFive.setBounds(90,1,10,18);
		pageFive.setFont(Main.BIGFONT);
		pageFive.setForeground(Color.BLUE);
		pageFive.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseEntered(java.awt.event.MouseEvent event) {
				Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(handCursor);
			}
			public void mouseExited(java.awt.event.MouseEvent event) {
				Cursor handCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(handCursor);
			}
		});
		navigationPanel.add(pageFive);
		
		pageSummary = new JLabel("<html><body><u>Summary</u></body></html>");
		pageSummary.setBounds(102,1,60,18);
		pageSummary.setFont(Main.BIGFONT);
		pageSummary.setForeground(Color.BLUE);
		pageSummary.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseEntered(java.awt.event.MouseEvent event) {
				Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
				setCursor(handCursor);
			}
			public void mouseExited(java.awt.event.MouseEvent event) {
				Cursor handCursor = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(handCursor);
			}
		});
		navigationPanel.add(pageSummary);
		
		backButton = new JButton("Back");
		backButton.setBounds(25,478,85,27);
		backButton.setFont(Main.REGFONT);
		backButton.setIcon(Main.icoPrev);
		mainJPanel.add(backButton);
				
		nextButton = new JButton("Next");
		nextButton.setBounds(115,478,85,27);
		nextButton.setIcon(Main.icoNext);
		nextButton.setFont(Main.REGFONT);
		nextButton.setHorizontalTextPosition(SwingConstants.LEFT);
		mainJPanel.add(nextButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(650,478,85,27);
		cancelButton.setFont(Main.REGFONT);
		mainJPanel.add(cancelButton);
	}
}
