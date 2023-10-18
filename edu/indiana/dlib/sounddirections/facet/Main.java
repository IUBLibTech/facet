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

package edu.indiana.dlib.sounddirections.facet;

import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import edu.indiana.dlib.sounddirections.facet.ui.*;
import edu.indiana.dlib.sounddirections.facet.data.*;

public class Main {
	
	public static Welcome window0;
	public static Screen1 window1;
	public static JFrame window2;
	public static Screen3 window3;
	public static Screen4 window4;
	public static Screen5 window5;
	public static Screen6 window6;
	public static SearchWindow windowSearch;
	public static CollectionData theData;
	
	public static final String VERSION = "1.00";
	
	final static public ImageIcon icoPrev = new ImageIcon("images/prev.GIF");
	final static public ImageIcon icoNext = new ImageIcon("images/next.GIF");
	final static public ImageIcon icoFacet = new ImageIcon("images/facet_window_icon.gif");
	
	final static public Color BLUE1 = new Color(159, 203, 236);
	final static public Color BEIGE1 = new Color(231, 232, 218);
	final static public Color GREEN1 = new Color(188, 214, 205);
	final static public Color GRAY1 = new Color(227, 232, 227);
	
	static public Color BROWNCOLOR = BEIGE1;
	static public Color BLUECOLOR = BLUE1;
	
	final static public Color SPLASHBUTTONCOLOR = new Color(206, 216, 215);
	final static public Font REGFONT = new Font("Arial",Font.PLAIN,12);
	final static public Font BIGFONT = new Font("Arial",Font.PLAIN,14);
	final static public Font BIGBUTTONFONT = new Font("Arial",Font.BOLD,16);
	final static public Font BOLDFONT = new Font("Arial", Font.BOLD,12);
	final static public Font HEADERFONT = new Font("Arial",Font.PLAIN,18);
	
	//file location for properties file
	final static private String FACET_PROPERTIES_FILE = System.getProperty("user.home") + "/facet/FACET.properties";
	final static private String FACET_PROPERTIES_FOLDER = System.getProperty("user.home") + "/facet";
	
	//database lists for previously used combo boxes
	static public Vector<String> workers = new Vector<String>();
	static public Vector<String> projTitles = new Vector<String>();
	static public Vector<String> collectionNames = new Vector<String>();
	
	public static void main(String[] args) {
		new Main();
	}
	
	private Main() {
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
          }
		catch(Exception e) {}
		window0 = new Welcome();
	}
	
	public static void updateLists() throws Exception {
		DB.populateLists();
	}
	
	/**
     * Center the specified window on the screen
     */
    public static void centerWindow(JFrame window) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = window.getSize();
        if (frameSize.height > screenSize.height) {
          frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
          frameSize.width = screenSize.width;
        }
        window.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    }

    /**
     * Center the specified window on the screen
     */
    public static void centerWindow(JDialog window) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = window.getSize();
        if (frameSize.height > screenSize.height) {
          frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
          frameSize.width = screenSize.width;
        }
        window.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    }
	
	public static void createNewCollectionData() {
		theData = new CollectionData();
		theData.isDirty = true;
		theData.databaseID = -1;	//new one - not in database yet
	}
	
	public static String getDatabaseLocation() {
		String loc = "";
		try {
			File x = new File(FACET_PROPERTIES_FILE);
			if (!(x.exists())) {
				//have to create properties file and folder
				File fold = new File(FACET_PROPERTIES_FOLDER);
				if (!(fold.exists())) {
					fold.mkdir();
				}
				x.createNewFile();
				BufferedWriter output = new BufferedWriter(new FileWriter(FACET_PROPERTIES_FILE));
				output.write("#Database location; can be a relative path or full path\n" + "databaseloc=");
				output.flush();
				output.close();	
			}
			BufferedReader input = new BufferedReader(new FileReader(FACET_PROPERTIES_FILE));
		    String line = null;
		    while ((line = input.readLine()) != null){
		    	line = line.trim();
		    	if (line.startsWith("databaseloc=")) {
		    		loc = line.substring(12);
		    		break;
		    	}
		    }			
		} catch (Exception err) {
			err.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error accessing properties file.", "Error accessing properties file", JOptionPane.ERROR_MESSAGE);
			return "";
		}
		return loc;
	}
	
	public static void setDatabaseLocation(String loc) {
		try {
			File x = new File(FACET_PROPERTIES_FILE);
			if (x.exists()) {
				//NOTE: Currently erases entire file! Assumes only one property
				x.delete();
			}
			File fold = new File(FACET_PROPERTIES_FOLDER);
			if (!(fold.exists())) {
				fold.mkdir();
			}
			x.createNewFile();
			BufferedWriter output = new BufferedWriter(new FileWriter(FACET_PROPERTIES_FILE));
			output.write("#Database location; can be a relative path or full path\n" + "databaseloc=" + loc);
			output.flush();
			output.close();	
		} catch (Exception err) {
			err.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error accessing properties file.", "Error accessing properties file", JOptionPane.ERROR_MESSAGE);
		}
	}
}
