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
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.ImageIcon;
import edu.indiana.dlib.sounddirections.facet.util.*;
import edu.indiana.dlib.sounddirections.facet.*;
import java.io.*;
import java.nio.channels.*;
import edu.indiana.dlib.sounddirections.facet.data.*;

/**
 * The FACET welcome screen
 */
public class Welcome extends JFrame {
	
	final static public ImageIcon icoWelcome = new ImageIcon("images/green_gray_welcome.jpg");
	final static public ImageIcon icoWelcomeAlt = new ImageIcon("images/blue_beige_welcome.jpg");

	JLabel mdbLabel;
	Font regFont = Main.REGFONT;
	Font bigButtonFont = Main.BIGBUTTONFONT;
	JPanel mainJPanel;
	
	public Welcome() {
		new Welcome(false);
	}
	
	public Welcome(boolean disableError) {	
		this.setIconImage(Main.icoFacet.getImage());
		this.setSize(800,600);
		this.setResizable(false);
		Main.centerWindow(this);
		Container c = this.getContentPane();
		c.setLayout(null);
		
		mainJPanel = new JPanel();
		mainJPanel.setBounds(15,15,765,540);
		mainJPanel.setBorder(new LineBorder(Color.BLACK));
		mainJPanel.setLayout(null);
		c.add(mainJPanel);
		this.setTitle("Welcome - FACET Version " + Main.VERSION);
		
		//this sets the background image
		if (Main.BROWNCOLOR == Main.GRAY1) {
			this.setContentPane(BackGroundImage.wrapInBackgroundImage(mainJPanel, icoWelcome));
		} else {
			this.setContentPane(BackGroundImage.wrapInBackgroundImage(mainJPanel, icoWelcomeAlt));
		}
	
		JPanel logoPanel2 = new JPanel();
		logoPanel2.setBounds(85,300,640,170);
		logoPanel2.setLayout(null);
		logoPanel2.setBackground(Color.WHITE);
		mainJPanel.add(logoPanel2);
		
		JLabel logo2Label = new JLabel("Field Audio Collection Evaluation Tool");
		logo2Label.setFont(regFont);
		logo2Label.setBounds(5,5,330,15);
		logoPanel2.add(logo2Label);
		
		JLabel logoLabel2 = new JLabel("Indiana University");
		logoLabel2.setFont(regFont);
		logoLabel2.setBounds(5,25,330,15);
		logoPanel2.add(logoLabel2);
		
		JLabel logoLabel3 = new JLabel("Version " + Main.VERSION);
		logoLabel3.setFont(regFont);
		logoLabel3.setBounds(5,45,330,15);
		logoPanel2.add(logoLabel3);
		
		mdbLabel = new JLabel("Current location of database file: " + Main.getDatabaseLocation());
		mdbLabel.setFont(regFont);
		mdbLabel.setBounds(5,85,630,15);
		logoPanel2.add(mdbLabel);
		
		JButton changeButton = new JButton("Choose database");
		changeButton.setBounds(5,105,180,25);
		changeButton.setFont(regFont);
		logoPanel2.add(changeButton);
		changeButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				promptForNewDatabase();
			}
		});
		
		JButton changeColorButton = new JButton("Change color scheme");
		changeColorButton.setBounds(5,135,180,25);
		changeColorButton.setFont(regFont);
		logoPanel2.add(changeColorButton);
		changeColorButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				changeColorScheme();
			}
		});
		
		JButton newButton = new JButton();
		newButton.setText("CREATE NEW RECORD");
		newButton.setFont(bigButtonFont);
		newButton.setBackground(Main.SPLASHBUTTONCOLOR);
		newButton.setBounds(500,513,285,33);
		mainJPanel.add(newButton);
		newButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				//don't allow if an edit window is currently open
				if ( ((Main.window1 != null) && (Main.window1.isVisible())) ||
						((Main.window2 != null) && (Main.window2.isVisible())) ||
						((Main.window3 != null) && (Main.window3.isVisible())) ||
						((Main.window4 != null) && (Main.window4.isVisible())) ||
						((Main.window5 != null) && (Main.window5.isVisible())) ||
						((Main.window6 != null) && (Main.window6.isVisible())) ) {
					JOptionPane.showMessageDialog(null, "Only one edit window may be opened;\n please close the open record before editing another one.", "Sorry", JOptionPane.ERROR_MESSAGE);
					return;
				}
				//used to keep wrong text from showing up on first summary screen
				Main.window2 = null;
				int x = getX();
				int y = getY();
				try {
					Main.updateLists();
				} catch (Exception err) {
					JOptionPane.showMessageDialog(null, "Unable to connect to database", "Database error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				Main.createNewCollectionData();
				Main.window1 = new Screen1();
				Main.window2 = null;
				Main.window3 = null;
				Main.window4 = null;
				Main.window5 = null;
				Main.window6 = null;
				Main.window1.setBounds(x, y, Main.window1.getWidth(), Main.window1.getHeight());
				Main.centerWindow(Main.window1);
				Main.window1.setVisible(true);
			}
		});
		
		JButton searchButton = new JButton();
		searchButton.setText("SEARCH CURRENT RECORDS");
		searchButton.setFont(bigButtonFont);
		searchButton.setBackground(Main.SPLASHBUTTONCOLOR);
		searchButton.setBounds(500,480,285,31);
		mainJPanel.add(searchButton);
		searchButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				if (Main.windowSearch instanceof SearchWindow) {
					JOptionPane.showMessageDialog(null, "Only one search window may be opened.", "Sorry", JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						Main.updateLists();
					} catch (Exception err) {
						JOptionPane.showMessageDialog(null, "Unable to connect to database", "Database error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					Main.windowSearch = new SearchWindow();
				}
			}});
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				this_windowClosing(e);
			}
	    });
		if ( (Main.getDatabaseLocation() == null) || (Main.getDatabaseLocation().trim().equals("")) ) {
			promptForNewDatabase();
		} else {
			try {
	        	if (DB.isOutOfDate()) {
	    			DB.doYearlyUpdateDB();
	    		}
			} catch (Exception err) {
				err.printStackTrace();
				if (!disableError) {
					JOptionPane.showMessageDialog(this, "Error accessing database file.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}    
		}
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
	}
	
	void promptForNewDatabase() {
		JOptionPane pane = new JOptionPane("Please choose whether to create a new \ndatabase or open an existing one.");
		Object[] options = new String[] { "Create New", "Open Existing" };
		pane.setOptions(options);
		
		Object obj = null;
		JDialog dialog = pane.createDialog(new JFrame(), "Create or open database");
		dialog.setVisible(true);
		obj = pane.getValue();
		if (obj == null) {
			return;
		}
		
		int result = -1;
		for (int k = 0; k < options.length; k++) {
			if (options[k].equals(obj)) {
				result = k;
			}
		}
		if (result == 1) {
			changeDatabaseLoc();
		} else {
			createNewDatabase();
		}
	}
	
	void this_windowClosing(WindowEvent e) {
		//don't allow if an edit window is currently open
		if ( ((Main.window1 != null) && (Main.window1.isVisible())) ||
				((Main.window2 != null) && (Main.window2.isVisible())) ||
				((Main.window3 != null) && (Main.window3.isVisible())) ||
				((Main.window4 != null) && (Main.window4.isVisible())) ||
				((Main.window5 != null) && (Main.window5.isVisible())) ||
				((Main.window6 != null) && (Main.window6.isVisible())) ) {
			JOptionPane.showMessageDialog(null, "Please close all other open windows first.", "Close all open windows", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (Main.windowSearch instanceof SearchWindow) {
			JOptionPane.showMessageDialog(null, "Please close all other open windows first.", "Sorry", JOptionPane.ERROR_MESSAGE);
			return;
		}
		System.exit(0);
    }
	
	void changeColorScheme() {
		String response = (String)JOptionPane.showInputDialog(this, "Choose a color scheme", "Choose a color scheme",
				JOptionPane.INFORMATION_MESSAGE, null, new String[] {"Blue/Beige scheme", "Green/gray scheme"}, "Blue/Beige scheme");
		if (response.equals("Blue/Beige scheme")) {
			Main.BROWNCOLOR = Main.BEIGE1;
			Main.BLUECOLOR = Main.BLUE1;
			Main.window0 = new Welcome(true);
			this.setVisible(false);
		} else {
			Main.BROWNCOLOR = Main.GRAY1;
			Main.BLUECOLOR = Main.GREEN1;
			Main.window0 = new Welcome(true);
			this.setVisible(false);
		}
	}
	
	void changeDatabaseLoc() {
		//change the current database location
		MDBFilter MDBfilt = new MDBFilter();
        JFileChooser fc = new JFileChooser();
        fc.setAcceptAllFileFilterUsed(false);
        fc.addChoosableFileFilter(MDBfilt);
        fc.setMultiSelectionEnabled(false);
        int returnVal = fc.showOpenDialog(this);
        fc.removeChoosableFileFilter(MDBfilt);
        if (returnVal == JFileChooser.CANCEL_OPTION) {
            return;
        }
        String fileName = fc.getSelectedFile().getPath();
        Main.setDatabaseLocation(fileName);
        try {
        	if (DB.isOutOfDate()) {
    			DB.doYearlyUpdateDB();
    		}
		} catch (Exception err) {
			err.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error creating database file.", "Error", JOptionPane.ERROR_MESSAGE);
        	return;
		}        
        updateUI();
	}
	
	void createNewDatabase() {
		MDBFilter MDBfilt = new MDBFilter();
        JFileChooser fc = new JFileChooser();
        fc.setAcceptAllFileFilterUsed(false);
        fc.addChoosableFileFilter(MDBfilt);
        fc.setMultiSelectionEnabled(false);
        int returnVal = fc.showSaveDialog(this);
        fc.removeChoosableFileFilter(MDBfilt);
        if (returnVal == JFileChooser.CANCEL_OPTION) {
            return;
        }
        String thing = fc.getSelectedFile().getPath();
        if (!(thing.toLowerCase().endsWith(".mdb"))) {
        	thing = thing + ".mdb";
        }
        File fil = new File(thing);
        if (fil.isDirectory()) {
        	JOptionPane.showMessageDialog(this, "The selected item is a folder, and cannot be used.", "Folder selected", JOptionPane.ERROR_MESSAGE);
        	return;
        }
        if (fil.exists()) {
        	int opt = JOptionPane.showConfirmDialog(this, "The selected file already exists. \nIf you continue, all existing data will be erased.\n Continue?", "Overwrite file?", JOptionPane.YES_NO_OPTION);
        	if (opt == JOptionPane.NO_OPTION) {
        		return;
        	}
        }
        
		try {
			if (fil.exists()) {
				fil.delete();
			}
	        fil.createNewFile();
			FileChannel srcChannel = new FileInputStream(new File("data.dat")).getChannel();
		    FileChannel dstChannel = new FileOutputStream(fil).getChannel();
		    dstChannel.transferFrom(srcChannel, 0, srcChannel.size());
		    srcChannel.close();
		    dstChannel.close();
		    String fileName = fil.getPath();
	        Main.setDatabaseLocation(fileName);
	        DB.updateDBToCurrentYear();
		} catch (Exception err) {
			JOptionPane.showMessageDialog(this, "Error creating database file.", "Error", JOptionPane.ERROR_MESSAGE);
        	return;
		}
        
        updateUI();
	}
	
	void updateUI() {
		mdbLabel.setText("Current location of database file: " + Main.getDatabaseLocation());
	}
}