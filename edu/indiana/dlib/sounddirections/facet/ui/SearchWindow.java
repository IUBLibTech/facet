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
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.math.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import edu.indiana.dlib.sounddirections.facet.util.*;
import edu.indiana.dlib.sounddirections.facet.*;
import edu.indiana.dlib.sounddirections.facet.data.*;

public class SearchWindow extends ParentWindow {
	
	JButton searchButton, openButton, deleteButton, printButton;
	JTextField numberText, partText, partNumberText, nameText, titleText;
	JComboBox formatBox;
	JCheckBox exclude;
	JCheckBox showResearchVal;
	public JCheckBox exclude1;
	JPanel searchJPanel;
	JComboBox exc;
	JTextField ext;
	JTable searchResultsTable;
	DefaultTableModel tm;
	public JTextField recDateStart;
	JTextField recDateEnd;
	JLabel recCount;
	
	public boolean gettingTop10 = false;
	public static final String FORMAT_NONE = "Search by format...";
	private int selectRow = -1;
	Vector searchResults = new Vector();
	
	public SearchWindow(){
		this.setTitle("FACET - Search");
		this.setSize(800,740);
		this.setResizable(false);
		Main.centerWindow(this);
		
		Container c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Main.BROWNCOLOR);
		
		Font font2 = Main.HEADERFONT;
		Font font3 = Main.BIGFONT;
		
		JPanel extraPanel = new JPanel();
		extraPanel.setBounds(0,0,800,30);
		extraPanel.setBackground(Main.BLUECOLOR);
		extraPanel.setLayout(null);
		c.add(extraPanel);
		
		JLabel facetLabel = new JLabel("FACET");
		facetLabel.setBounds(15,5,450,20);
		facetLabel.setFont(Main.HEADERFONT);
		extraPanel.add(facetLabel);
		
		JPanel mainJPanel = new JPanel();
		mainJPanel.setBounds(5,35,790,720);
		mainJPanel.setBackground(Main.BROWNCOLOR);
		mainJPanel.setLayout(null);
		c.add(mainJPanel);
		
		JLabel trackingLabel = new JLabel("Search All Records");
		trackingLabel.setFont(font2);
		trackingLabel.setBounds(85,5,180,15);
		mainJPanel.add(trackingLabel);
		
		searchJPanel = new JPanel();
		searchJPanel.setBounds(60,30,680,300);
		searchJPanel.setBackground(Main.BROWNCOLOR);
		searchJPanel.setBorder(new LineBorder(Color.BLACK));
		searchJPanel.setLayout(null);
		mainJPanel.add(searchJPanel);
		
		JLabel searchByLabel = new JLabel("<html><b>Search by:</b></html>");
		searchByLabel.setFont(font3);
		searchByLabel.setBounds(120,7,100,15);
		searchJPanel.add(searchByLabel);
		
		JLabel numberLabel = new JLabel("Collection Primary Identifier: ");
		numberLabel.setFont(font3);
		numberLabel.setBounds(20,32,190,15);
		searchJPanel.add(numberLabel);
		
		numberText =  new JTextField();
		numberText.setEditable(true);
		numberText.setBounds(210,30,200,20);
		searchJPanel.add(numberText);
		
		JLabel partLabel = new JLabel("Part Name: ");
		partLabel.setFont(font3);
		partLabel.setBounds(125,58,210-125,15);
		searchJPanel.add(partLabel);
		
		partText =  new JTextField();
		partText.setEditable(true);
		partText.setBounds(210,55,80,20);
		searchJPanel.add(partText);
		
		JLabel partNumberLabel = new JLabel("Part Number: ");
		partNumberLabel.setFont(font3);
		partNumberLabel.setBounds(310,58,398-310,15);
		searchJPanel.add(partNumberLabel);
		
		partNumberText =  new JTextField();
		partNumberText.setEditable(true);
		partNumberText.setBounds(398,55,40,20);
		searchJPanel.add(partNumberText);
		
		JLabel nameLabel = new JLabel("Collection Name: ");
		nameLabel.setFont(font3);
		nameLabel.setBounds(92,83,210-92,15);
		searchJPanel.add(nameLabel);
		
		nameText =  new JTextField();
		nameText.setEditable(true);
		nameText.setBounds(210,80,100,20);
		searchJPanel.add(nameText);
		
		JLabel titleLabel = new JLabel("Project Title: ");
		titleLabel.setFont(font3);
		titleLabel.setBounds(118,108,210-118,15);
		searchJPanel.add(titleLabel);
		
		titleText =  new JTextField();
		titleText.setEditable(true);
		titleText.setBounds(210,105,100,20);
		searchJPanel.add(titleText);
		
		JLabel FormatLabel = new JLabel("Format: ");
		FormatLabel.setFont(font3);
		FormatLabel.setBounds(146,135,100,16);
		searchJPanel.add(FormatLabel);
		
		formatBox = new JComboBox(new Object[] {FORMAT_NONE, "Open reel tape-polyester", "Open reel tape-acetate",
				"Open reel tape-paper", "Open reel tape-pvc", "Cassette-analog, audio", 
				"DAT (digital audio tape)", "Disc-lacquer",	"Disc-aluminum", "Wire Recording"});
		formatBox.setEditable(false);
		formatBox.setFont(font3);
		formatBox.setBounds(210,133,220,23);
		searchJPanel.add(formatBox);
		
		JLabel dateLabel = new JLabel("Recording Date: ");
		dateLabel.setFont(font3);
		dateLabel.setBounds(92,163,120,16);
		searchJPanel.add(dateLabel);
		
		recDateStart = new JTextField();
		recDateStart.setBounds(210,163, 50, 20);
		searchJPanel.add(recDateStart);
		
		JLabel toLabel = new JLabel(" to ");
		toLabel.setFont(font3);
		toLabel.setBounds(270,163,30,16);
		searchJPanel.add(toLabel);
		
		recDateEnd = new JTextField();
		recDateEnd.setBounds(303, 163, 50, 20);
		searchJPanel.add(recDateEnd);
		
		exclude = new JCheckBox("Exclude Preserved Collections");
		exclude.setFont(font3);
		exclude.setBackground(Main.BROWNCOLOR);
		exclude.setBounds(25,192,300,16);
		searchJPanel.add(exclude);
		
		showResearchVal = new JCheckBox("Include Research Value in Point Totals");
		showResearchVal.setFont(font3);
		showResearchVal.setBackground(Main.BROWNCOLOR);
		showResearchVal.setBounds(25,214,500,16);
		searchJPanel.add(showResearchVal);
		
		exclude1 = new JCheckBox("Retrieve Collections With Point Totals ");
		exclude1.setFont(font3);
		exclude1.setBackground(Main.BROWNCOLOR);
		exclude1.setBounds(25,235,270,16);
		exclude1.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				ext.setText("");
			}
		});
		searchJPanel.add(exclude1);
		
		exc = new JComboBox();
		exc.setBounds(295,233,110,20);
		exc.setFont(font3);
		exc.addItem("Less Than");
		exc.addItem("Greater Than");
		exc.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				exclude1.setSelected(true);
			}
		});
		searchJPanel.add(exc);
		
		ext = new JTextField();
		ext.setBounds(410, 233, 100, 20);
		ext.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				exclude1.setSelected(true);
			}
		});
		searchJPanel.add(ext);
		
		searchButton = new JButton("Search");
		searchButton.setBounds(570,260,80,27);
		searchButton.setFont(font3);
		searchJPanel.add(searchButton);
		searchButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				doSearch();
			}
		});
		
		JButton searchButton2 = new JButton("Get Top 10");
		searchButton2.setBounds(50,260,120,27);
		searchButton2.setFont(font3);
		searchButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				getTop10();
			}
		});
		searchJPanel.add(searchButton2);
		
		JButton clearButton = new JButton("Clear");
		clearButton.setBounds(480,260,80,27);
		clearButton.setFont(font3);
		searchJPanel.add(clearButton);
		clearButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				clearAll();
			}
		});

		////// END SEARCH PANEL //////////////////////////
		
		////// TABLE RESULTS PANEL //////////////////////////
		
		JPanel tableResultsPanel = new JPanel();
		tableResultsPanel.setBounds(5,365,780,260);
		tableResultsPanel.setBorder(new LineBorder(Color.BLACK));
		tableResultsPanel.setLayout(null);
		mainJPanel.add(tableResultsPanel);

		JLabel resultsLabel = new JLabel("Search Results");
		resultsLabel.setFont(font2);
		resultsLabel.setBounds(85,340,200,15);
		mainJPanel.add(resultsLabel);		
		tm = new DefaultTableModel();
		tm.setColumnCount(8);
		tm.setRowCount(35);
		TableSorter sorter = new TableSorter(tm);
		searchResultsTable = new JTable(sorter) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		searchResultsTable.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent event) {
				if (event.getClickCount() == 2) {
					openCurrentRecord();
				}
			}
		});
		ListSelectionModel rowSM = searchResultsTable.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) return;
                ListSelectionModel lsm = (ListSelectionModel)e.getSource();
                if (lsm.isSelectionEmpty()) {
                    //no rows selected
                	if (searchResults.size() == 0) {
            			recCount.setText("");
            		} else {
            			recCount.setText(searchResults.size() + " matching records found");
            		}
                	openButton.setEnabled(false);
                	deleteButton.setEnabled(false);
                	selectRow = -1;
                } else {
                	selectRow = lsm.getMinSelectionIndex();
		            //workaround for a swing bug?
		            if (selectRow > (searchResults.size() - 1)) {
		            	selectRow = selectRow - 1;
		            }
		    		recCount.setText("Record " + (selectRow+1) + " of " + searchResults.size() + " selected");
                    openButton.setEnabled(true);
                    deleteButton.setEnabled(true);
                }
            }
        });
		
		JScrollPane tableScrollPane = new JScrollPane(searchResultsTable);
		tableScrollPane.setBounds(5,5,770,250);
		tableResultsPanel.add(tableScrollPane);
		
		searchResultsTable.getColumnModel().getColumn(0).setHeaderValue("Primary ID");
		searchResultsTable.getColumnModel().getColumn(1).setHeaderValue("Part#");
		searchResultsTable.getColumnModel().getColumn(2).setHeaderValue("Part Name");
		searchResultsTable.getColumnModel().getColumn(3).setHeaderValue("Name");
		searchResultsTable.getColumnModel().getColumn(4).setHeaderValue("Title");
		searchResultsTable.getColumnModel().getColumn(5).setHeaderValue("Points");
		searchResultsTable.getColumnModel().getColumn(6).setHeaderValue("Format");
		searchResultsTable.getColumnModel().getColumn(7).setHeaderValue("Date");
		
		//////	 END TABLE RESULTS PANEL //////////////////////////
		
		recCount = new JLabel("");
		recCount.setBounds(20,635,240,27);
		mainJPanel.add(recCount);
		recCount.setFont(font3);
		
		openButton = new JButton("Open");
		openButton.setBounds(495,635,80,27);
		mainJPanel.add(openButton);
		openButton.setEnabled(false);
		openButton.setFont(font3);
		openButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				openCurrentRecord();
			}
		});
		
		deleteButton = new JButton("Delete");
		deleteButton.setBounds(265,635,80,27);
		deleteButton.setFont(font3);
		mainJPanel.add(deleteButton);
		deleteButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				deleteCurrentRecord();
			}
		});
		
		printButton = new JButton("Export/Print ");
		printButton.setBounds(360,635,120,27);
		printButton.setFont(font3);
		mainJPanel.add(printButton);
		printButton.setEnabled(false);
		printButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				printIt();
			}
		});
		
		JButton cancelButton = new JButton("Close");
		cancelButton.setBounds(690,635,80,27);
		cancelButton.setFont(font3);
		mainJPanel.add(cancelButton);
		cancelButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Main.windowSearch = null;
				setVisible(false);
			}
		});
		getRootPane().setDefaultButton(searchButton);
		doComponentInitialization(this);
		updateTable();
		this.setVisible(true);
	}
	
	private String getHTMLString() {
		String retString = "<b>Search Results:</b><br><br>";
		int counter = 0;
		while (counter < searchResultsTable.getRowCount()) {
			//(Primary ID, Part Number, Part Name, Collection Name, Project Title, Points, Format)
			retString = retString + "&nbsp;&nbsp;&nbsp;&nbsp;<b>" +  searchResultsTable.getValueAt(counter, 0);
			if (!((String)searchResultsTable.getValueAt(counter, 1)).trim().equals("")) {
				retString = retString + " Part " + searchResultsTable.getValueAt(counter, 1);
			}
			retString = retString + "</b>";
			retString = retString + " (" + searchResultsTable.getValueAt(counter, 6) + ") ";
			retString = retString + searchResultsTable.getValueAt(counter, 5) + " points";
			if (!((String)searchResultsTable.getValueAt(counter, 2)).trim().equals("")) {
				retString = retString + "<br>Part Name: " + searchResultsTable.getValueAt(counter, 2);
			}
			if (!((String)searchResultsTable.getValueAt(counter, 3)).trim().equals("")) {
				retString = retString + "<br>Collection: " + searchResultsTable.getValueAt(counter, 3);
			}
			if (!((String)searchResultsTable.getValueAt(counter, 4)).trim().equals("")) {
				retString = retString + "<br>Project Title: " + searchResultsTable.getValueAt(counter, 4);
			}
			if (!((String)searchResultsTable.getValueAt(counter, 7)).trim().equals("")) {
				retString = retString + "<br>Date: " + searchResultsTable.getValueAt(counter, 7);
			}
			retString = retString + "<br><br>";
			counter = counter + 1;
		}
		retString = "<html><head></head><body>" + retString + "</body></html>";
		return retString;
	}
	
	void printIt() {	
		String full = getHTMLString();
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
	
	protected void processWindowEvent(WindowEvent e){
		if (e.getID()==WindowEvent.WINDOW_CLOSING){
			Main.windowSearch = null;
		}
		super.processWindowEvent(e);
	}
	
	private void clearAll(){
		numberText.setText("");
		partText.setText("");
		partNumberText.setText("");
		nameText.setText("");
		titleText.setText("");
		formatBox.setSelectedItem(FORMAT_NONE);
		exclude.setSelected(false);
		exc.setSelectedIndex(0);
		ext.setText("");
		exclude1.setSelected(false);
		showResearchVal.setSelected(false);
		this.recDateEnd.setText("");
		this.recDateStart.setText("");
	}
	
	public String getFormatFor(CollectionData s) {
		return s.formatString;
	}
	
	private void updateTable() {
		String[][] thedata = new String[searchResults.size()][7];
		
		int counter = 0;
    	while (counter < searchResults.size()) {
    		CollectionData s = (CollectionData)searchResults.get(counter);
    		String format = getFormatFor(s);
    		BigDecimal d;
    		if (this.showResearchVal.isSelected()) {
    			d = new BigDecimal(s.runningTotal + s.researchValue).setScale(3, BigDecimal.ROUND_HALF_UP);
    		} else {
    			d = new BigDecimal(s.runningTotal).setScale(3, BigDecimal.ROUND_HALF_UP);
    		}
    		
    		String x = (new Integer(s.year)).toString();
    		if (x.equals("0")) {
    			x = "";
    		}
    		thedata[counter] = (new String[]{s.collectionNumber, s.partOne, s.collectionPart, s.collectionName, s.projectTitle, d.toString(), format, x});
    		counter = counter + 1;
    	}
    	EditValuesTableModel e = new EditValuesTableModel(thedata, new String[]{"Primary ID", "Part#", "Part Name", "Collection Name", "Project Title", "Points", "Format", "Date"});
    	TableSorter ts = new TableSorter(e);
    	ts.setTableHeader(searchResultsTable.getTableHeader());
    	ts.setSortingStatus(0, TableSorter.NOT_SORTED);		//otherwise sometimes double sorts
    	ts.setSortingStatus(0, TableSorter.ASCENDING);
    	searchResultsTable.setModel(ts);
    	searchResultsTable.getColumnModel().getColumn(1).setPreferredWidth(20);
		searchResultsTable.getColumnModel().getColumn(5).setPreferredWidth(20);
		searchResultsTable.getColumnModel().getColumn(6).setPreferredWidth(100);
		searchResultsTable.getColumnModel().getColumn(7).setPreferredWidth(20);
		if (searchResults.size() == 0) {
			recCount.setText("");
		} else {
			recCount.setText(searchResults.size() + " matching records found");
		}
	}
	
	private void getTop10() {
		boolean excludePreserved = false;
		if (exclude.isSelected()) {
			excludePreserved = true;
		}
		try {
			//get everything
			searchResults = DB.doSearchFor(0, "", "", "", "", "", "", excludePreserved, 0, 0, showResearchVal.isSelected());
			if (searchResults.size() == 0) {
				JOptionPane.showMessageDialog(this, "No items were found which match your search criteria", "No record found", JOptionPane.WARNING_MESSAGE);
				printButton.setEnabled(false);
			} else {
				printButton.setEnabled(true);
			}
			if (searchResults.size() < 11) {
				gettingTop10 = true;
				updateTable();
				gettingTop10 = false;
				return;
			}
			int counter = searchResults.size();
			Vector sortList = new Vector();
			while (counter > 0) {
				CollectionData s = (CollectionData)searchResults.get(counter-1);
				if (this.showResearchVal.isSelected()) {
					sortList.add(new Double(s.runningTotal + s.researchValue));
	    		} else {
	    			sortList.add(new Double(s.runningTotal));
	    		}
				
				
				counter = counter - 1;
			}
			Collections.sort(sortList);
			double cutoff = ((Double)sortList.get(sortList.size() - 10)).doubleValue();
			counter = searchResults.size();
			while (counter > 0) {
				CollectionData s = (CollectionData)searchResults.get(counter-1);
				if (this.showResearchVal.isSelected()) {
					if ((s.runningTotal + s.researchValue) < cutoff) {
						searchResults.remove(counter - 1);
					}
				} else {
					if (s.runningTotal < cutoff) {
						searchResults.remove(counter - 1);
					}
				}
				counter = counter - 1;
			}
			gettingTop10 = true;
			updateTable();
			gettingTop10 = false;
		} catch (Exception err) {
			gettingTop10 = true;
			err.printStackTrace();
			if (err.getMessage() != null) {
				javax.swing.JOptionPane.showMessageDialog(null, "Error connecting to database\n" + err.getMessage(), "Database error", javax.swing.JOptionPane.ERROR_MESSAGE);
			} else {
				javax.swing.JOptionPane.showMessageDialog(null, "Error connecting to database", "Database error", javax.swing.JOptionPane.ERROR_MESSAGE);
			}
		}	
	}
	
	public void doSearch() {
		doSearch(false);
	}
	
	public void doSearch(boolean hideDisplay) {
		try {
			String format = (String)formatBox.getSelectedItem();
			if (format.equals(FORMAT_NONE)) {
				format = "";
			}
			float pointFilter = 0;
			if (exclude1.isSelected()) {
				try { 
					pointFilter = Float.parseFloat(ext.getText()); 
				} catch (NumberFormatException e) { 
					pointFilter = 0; 
				}
				if (pointFilter < 0) {
					pointFilter = 0;
				}
				if (exc.getSelectedItem().equals("Less Than")) {
					pointFilter = 0 - pointFilter;
				}
			}
			boolean excludePreserved = false;
			if (exclude.isSelected()) {
				excludePreserved = true;
			}
			
			int startDate = 0;
			int endDate = 0;
			String sd = recDateStart.getText().trim();
			String ed = recDateEnd.getText().trim();
			if ((!sd.equals("")) && (!ed.equals(""))) {
				try {
					Integer sdI = new Integer(sd);
					Integer seI = new Integer(ed);
					if ((sdI.intValue() < 1) || (seI.intValue() < 1)) {
						throw new Exception();
					}
					startDate = sdI.intValue();
					endDate = seI.intValue();
				} catch (Exception err) {
					JOptionPane.showMessageDialog(this, "Invalid dates entered.\nDate field will be ignored.", "Invalid date", JOptionPane.ERROR_MESSAGE);
				}
			} else if (!sd.equals("")) {
				try {
					Integer sdI = new Integer(sd);
					if (sdI.intValue() < 1) {
						throw new Exception();
					}
					startDate = sdI.intValue();
				} catch (Exception err) {
					JOptionPane.showMessageDialog(this, "Invalid dates entered.\nDate field will be ignored.", "Invalid date", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			searchResults = DB.doSearchFor(pointFilter, numberText.getText().trim(), partNumberText.getText().trim(), nameText.getText().trim(), format, titleText.getText().trim(), partText.getText().trim(), excludePreserved, startDate, endDate, showResearchVal.isSelected());
			if (searchResults.size() == 0) {
				if (!hideDisplay) {
					JOptionPane.showMessageDialog(this, "No items were found which match your search criteria", "No record found", JOptionPane.WARNING_MESSAGE);
				}
				printButton.setEnabled(false);
			} else {
				printButton.setEnabled(true);
			}
			updateTable();
			
			System.gc();
		} catch (Exception err) {
			err.printStackTrace();
			if (!hideDisplay) {
				if (err.getMessage() != null) {
					javax.swing.JOptionPane.showMessageDialog(null, "Error connecting to database\n" + err.getMessage(), "Database error", javax.swing.JOptionPane.ERROR_MESSAGE);
				} else {
					javax.swing.JOptionPane.showMessageDialog(null, "Error connecting to database", "Database error", javax.swing.JOptionPane.ERROR_MESSAGE);
				}
			}
		}	
	}
	
	private void openCurrentRecord() {
		if ( ((Main.window1 != null) && (Main.window1.isVisible())) ||
				((Main.window2 != null) && (Main.window2.isVisible())) ||
				((Main.window3 != null) && (Main.window3.isVisible())) ||
				((Main.window4 != null) && (Main.window4.isVisible())) ||
				((Main.window5 != null) && (Main.window5.isVisible())) ||
				((Main.window6 != null) && (Main.window6.isVisible())) ) {
			JOptionPane.showMessageDialog(null, "Only one edit window may be opened;\n please close the open record before editing another one.", "Sorry", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		int realRow = ((TableSorter)this.searchResultsTable.getModel()).modelIndex(selectRow);
		
		CollectionData cd = (CollectionData)searchResults.get(realRow);
		try {
			showRecord(cd);
		} catch (Exception err) {
			err.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error connecting to database", "Error connecting to database", JOptionPane.ERROR_MESSAGE);
		}
		System.gc();
	}
	
	private void showRecord(CollectionData cd) throws Exception {
		CollectionData newCD = DB.getRealDataFor(cd);
		PageNav.showRecord(newCD);
	}
	
	private void deleteCurrentRecord() {
		int result = JOptionPane.showConfirmDialog(this, "Really delete this record from the database?", "Confirm record deletion", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.NO_OPTION) {
			return;
		}
		int realRow = ((TableSorter)this.searchResultsTable.getModel()).modelIndex(selectRow);
		
		CollectionData cd = (CollectionData)searchResults.get(realRow);
		try {
			DB.deleteRecord(cd);
		} catch (Exception err) {
			err.printStackTrace();
			if (err.getMessage() != null) {
				javax.swing.JOptionPane.showMessageDialog(null, "Error connecting to database\n" + err.getMessage(), "Database error", javax.swing.JOptionPane.ERROR_MESSAGE);
			} else {
				javax.swing.JOptionPane.showMessageDialog(null, "Error connecting to database", "Database error", javax.swing.JOptionPane.ERROR_MESSAGE);
			}
		}
		doSearch(true);
	}
	
	class EditValuesTableModel extends AbstractTableModel {
	    private String[] columnNames = {};
	    String[][] data = {};
	    
	    public EditValuesTableModel(String[][] newdata, String[] newcolumns) {
	    	columnNames = newcolumns;
	    	if (newdata == null) {
	    		data = new String[0][0];
	    	} else {
	    		data = newdata;
	    	}
	    }	    
	    public int getColumnCount() {
	        return columnNames.length;
	    }
	    public int getRowCount() {
	        return data.length;
	    }
	    public String getColumnName(int col) {
	        return columnNames[col];
	    }
	    public Object getValueAt(int row, int col) {
	        return data[row][col];
	    }
	    public Class getColumnClass(int c) {
	        return getValueAt(0, c).getClass();
	    }
	    public boolean isCellEditable(int row, int col) {
	        return false;
	    }
	}
}