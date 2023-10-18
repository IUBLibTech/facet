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

package edu.indiana.dlib.sounddirections.facet.data;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.*;
import java.io.*;
import java.math.BigDecimal;
import edu.indiana.dlib.sounddirections.facet.*;
import edu.indiana.dlib.sounddirections.facet.ui.*;
import edu.indiana.dlib.sounddirections.facet.util.*;

/**
 * The class that deals with actual connection to the database
 */
public class DB {
	
	private DB() {}
	
	public static String PrepareString(String str) {
		return str.replaceAll("'", "''");
	}
	
	public static void populateLists() throws Exception {
		Main.workers.clear();
		Main.projTitles.clear();
		Main.collectionNames.clear();
		
		//first workers
		Connection con = getConnection();
		Statement s = con.createStatement();
		String bigSQL = "SELECT worker FROM Collections";
		s.execute(bigSQL);
		ResultSet rs = s.getResultSet();
		if (rs != null) {
			while (rs.next()) {
				String workName = rs.getString(1);
				workName = workName.trim();
				if (!(workName.equals(""))) {
					if (!(Main.workers.contains(workName))) {
						Main.workers.add(workName);
					}
				}
		    }
		}
		java.util.Collections.sort(Main.workers);
		s.close();
		con.close();
		
		//now project titles
		con = getConnection();
		s = con.createStatement();
		bigSQL = "SELECT ProjectTitle FROM Collections";
		s.execute(bigSQL);
		rs = s.getResultSet();
		if (rs != null) {
			while (rs.next()) {
				String workName = rs.getString(1);
				workName = workName.trim();
				if (!(workName.equals(""))) {
					if (!(Main.projTitles.contains(workName))) {
						Main.projTitles.add(workName);
					}
				}
		    }
		}
		java.util.Collections.sort(Main.projTitles);
		s.close();
		con.close();
		
		//now name of collection
		con = getConnection();
		s = con.createStatement();
		bigSQL = "SELECT CollectionName FROM Collections";
		s.execute(bigSQL);
		rs = s.getResultSet();
		if (rs != null) {
			while (rs.next()) {
				String workName = rs.getString(1);
				workName = workName.trim();
				if (!(workName.equals(""))) {
					if (!(Main.collectionNames.contains(workName))) {
						Main.collectionNames.add(workName);
					}
				}
		    }
		}
		java.util.Collections.sort(Main.collectionNames);
		s.close();
		con.close();
	}
	
	static public boolean recordExists(CollectionData theData) throws Exception {
		Connection con = getConnection();
		Statement s = con.createStatement();
		s = con.createStatement();
		String bigSQL = "SELECT ID FROM Collections WHERE CollectionNumber='" + PrepareString(theData.collectionNumber) + 
				"' AND PartOne='" + PrepareString(theData.partOne) + "'";
		
		s.execute(bigSQL);
		ResultSet rs = s.getResultSet();
		if (rs == null) {
			s.close();
			con.close();
			return false;
		}
		if (rs.next()) {
			s.close();
			con.close();
			return true;
		} else {
			s.close();
			con.close();
			return false;
		}
	}
	
	static public int getIDFor(CollectionData theData) throws Exception {
		Connection con = getConnection();
		Statement s = con.createStatement();
		s = con.createStatement();
		String bigSQL = "SELECT ID FROM Collections WHERE CollectionNumber='" + PrepareString(theData.collectionNumber) + 
				"' AND PartOne='" + PrepareString(theData.partOne) + "'";
		
		s.execute(bigSQL);
		ResultSet rs = s.getResultSet();
		if (rs == null) {
			s.close();
			con.close();
			throw new Exception("Error getting ID from database");
		}
		int ID = -1;
		while (rs.next()) {
			ID = rs.getInt(1);
		}
		s.close();
		con.close();
		return ID;
	}
	
	static public boolean saveRecord(CollectionData theData) throws Exception {		
		if (theData.databaseID == -1) {
			//record was created using 'new' command, but might still exist
			if (recordExists(theData)) {
				//WARN user
				int response = JOptionPane.showConfirmDialog(null, "This object already exists in the database. Overwrite existing data?", "Overwrite data?", JOptionPane.YES_NO_OPTION);
				if (response == JOptionPane.YES_OPTION) {
					theData.databaseID = getIDFor(theData);
					saveExistingRecord(theData);
					return true;
				} else {
					return false;
				}
			} else {
				saveNewRecord(theData);	//this assigns a new database ID to this object
				return true;
			}			
		} else {
			//record is definitely already in database, and has an assigned ID
			//however, user might have changed ID and/or part number to a different, already existing one
			//so first, we need to check
			int newID = -1;
			try {
				newID = DB.getIDFor(theData);
			} catch (Exception err) {
				newID = -1;
			}
			if (newID != -1) {
				//ID exists; is it the same?
				if (newID != theData.databaseID) {
					//new ID exists; so this should overwrite rather than create new
					//WARN user
					int response = JOptionPane.showConfirmDialog(null, "This object already exists in the database. Overwrite existing data?", "Overwrite data?", JOptionPane.YES_NO_OPTION);
					if (response == JOptionPane.YES_OPTION) {
						//this will delete the old record (with the wrong ID)
						DB.deleteRecord(theData);
						theData.databaseID = getIDFor(theData);
						saveExistingRecord(theData);
						return true;
					} else {
						return false;
					}
				}
			}
			
			saveExistingRecord(theData);
			return true;
		}	
	}
	
	static public void deleteRecord(CollectionData theData) throws Exception {
		removeModPointsFor(theData.databaseID);
		Connection con = getConnection();
		Statement s = con.createStatement();
		String bigSQL = "DELETE FROM Collections WHERE ID=" + theData.databaseID;
		s.execute(bigSQL);
		s.close();
		con.close();
	}
	
	static public void doYearlyUpdateDB() throws Exception {
		JOptionPane.showMessageDialog(null, "This database has not yet been accessed this year.\nThere will be a delay of up to several minutes\n while the records are being updated.", "Database out-of-date.", JOptionPane.WARNING_MESSAGE);
		Connection con = getConnection();
		Statement s = con.createStatement();
		String bigSQL = "SELECT * FROM Collections ";
		s.execute(bigSQL);
		ResultSet rs = s.getResultSet();
	    while (rs.next()) {
	    	CollectionData x = getCollectionDataFor(rs);
	    	//this will update the values to the correct totals based on the current year
			x.getRunningTotal();
	    	saveExistingRecord(x);
	    }
		s.close();
		con.close();
		DB.updateDBToCurrentYear();
	}
	
	static public boolean isOutOfDate() throws Exception {
		String sql = "SELECT LASTACCESSYEAR FROM ACCESSYEAR";
		Connection con = getConnection();
		Statement s = con.createStatement();
		s.execute(sql);
		ResultSet rs = s.getResultSet();
		rs.next();
		int year = rs.getInt(1);
		s.close();
		con.close();
		
		SimpleDateFormat sdf;
		sdf = new SimpleDateFormat("yyyy");
		Calendar cal;
		cal = Calendar.getInstance(TimeZone.getDefault());
		int currentYear = (new Integer(sdf.format(cal.getTime()))).intValue();
		if (currentYear > year) {
			return true;
		}
		return false;
	}
	
	static public void updateDBToCurrentYear() throws Exception {
		SimpleDateFormat sdf;
		sdf = new SimpleDateFormat("yyyy");
		Calendar cal;
		cal = Calendar.getInstance(TimeZone.getDefault());
		int currentYear = (new Integer(sdf.format(cal.getTime()))).intValue();
		String sql = "UPDATE ACCESSYEAR SET LASTACCESSYEAR = " + currentYear;
		Connection con = getConnection();
		Statement s = con.createStatement();
		s.execute(sql);
		s.close();
		con.close();
	}
	
	static public Vector doSearchFor(float pointFilter, String numberText, String partText, String nameText, String formatText, String titleText, String partNameText, boolean excludePreserved, int startDate, int endDate, boolean includeResearch) throws Exception {
		Connection con = getConnection();
		Statement s = con.createStatement();
		String bigSQL = "SELECT CollectionNumber, CollectionName, CollectionPart, PartOne, formatString, ProjectTitle, TotalPoints, researchValue, isPreserved, year, ID FROM Collections ";
		boolean doAnd = false;
		if (!numberText.equals("")) {
			bigSQL = bigSQL + "WHERE CollectionNumber LIKE '%" + PrepareString(numberText) + "%' ";
			doAnd = true;
		}
		if (!nameText.equals("")) {
			String bo = "WHERE ";
			if (doAnd) {
				bo = "AND ";
			} else {
				bo = "WHERE ";
				doAnd = true;
			}
			
			bigSQL = bigSQL + bo + "CollectionName LIKE '%" + PrepareString(nameText) + "%' ";
		}
		if (!partNameText.equals("")) {
			String bo = "WHERE ";
			if (doAnd) {
				bo = "AND ";
			} else {
				bo = "WHERE ";
				doAnd = true;
			}
			bigSQL = bigSQL + bo + "CollectionPart LIKE '%" + PrepareString(partNameText) + "%' ";
		}
		if (!partText.equals("")) {
			String bo = "WHERE ";
			if (doAnd) {
				bo = "AND ";
			} else {
				bo = "WHERE ";
				doAnd = true;
			}
			bigSQL = bigSQL + bo + "PartOne LIKE '%" + PrepareString(partText) + "%' ";
		}
		if (!formatText.equals("")) {
			String bo = "WHERE ";
			if (doAnd) {
				bo = "AND ";
			} else {
				bo = "WHERE ";
				doAnd = true;
			}
			bigSQL = bigSQL + bo + "formatString = '" + formatText + "' ";
		}
		if (!titleText.equals("")) {
			String bo = "WHERE ";
			if (doAnd) {
				bo = "AND ";
			} else {
				bo = "WHERE ";
				doAnd = true;
			}
			bigSQL = bigSQL + bo + "ProjectTitle LIKE '%" + PrepareString(titleText) + "%' ";
		}
		if (!(pointFilter == 0)) {
			String bo = "WHERE ";
			if (doAnd) {
				bo = "AND ";
			} else {
				bo = "WHERE ";
				doAnd = true;
			}
			String symbol = ">";
			if (pointFilter < 0) {
				symbol = "<";
				pointFilter = -pointFilter;
			}
			if (includeResearch) {
				bigSQL = bigSQL + bo + "(TotalPoints + researchValue) " + symbol + " " + pointFilter + " ";
			} else {
				bigSQL = bigSQL + bo + "TotalPoints " + symbol + " " + pointFilter + " ";
			}
			
		}
		if (excludePreserved) {
			String bo = "WHERE ";
			if (doAnd) {
				bo = "AND ";
			} else {
				bo = "WHERE ";
				doAnd = true;
			}
			bigSQL = bigSQL + bo + "isPreserved = false ";
		}
		if ((startDate > 0) && (endDate > 0)) {
			String bo = "WHERE ";
			if (doAnd) {
				bo = "AND ";
			} else {
				bo = "WHERE ";
				doAnd = true;
			}
			bigSQL = bigSQL + bo + "year >= " + startDate + " ";
			
			bo = "WHERE ";
			if (doAnd) {
				bo = "AND ";
			} else {
				bo = "WHERE ";
				doAnd = true;
			}
			bigSQL = bigSQL + bo + "year <= " + endDate + " ";
		} else if (startDate > 0) {
			String bo = "WHERE ";
			if (doAnd) {
				bo = "AND ";
			} else {
				bo = "WHERE ";
				doAnd = true;
			}
			bigSQL = bigSQL + bo + "year = " + startDate + " ";
		}
		
		s.execute(bigSQL);
		ResultSet rs = s.getResultSet();
		Vector vec = new Vector();
		if (rs == null) {
			return vec;
		}
	    while (rs.next()) {
	    	vec.add(getLimitedCollectionDataFor(rs));
	    }
		s.close();
		con.close();
		return vec;
	}
	
	static CollectionData getLimitedCollectionDataFor(ResultSet set) throws Exception {
		CollectionData cd = new CollectionData();
		int x = 1;
		cd.collectionNumber = set.getString(x);
		x = x + 1;
		cd.collectionName = set.getString(x);
		x = x + 1;
		cd.collectionPart = set.getString(x);
		x = x + 1;
		cd.partOne = set.getString(x);
		x = x + 1;
		cd.formatString = set.getString(x);
		x = x + 1;
		cd.projectTitle = set.getString(x);
		x = x + 1;
		cd.runningTotal = set.getDouble(x);
		x = x + 1;
		cd.researchValue = set.getDouble(x);
		x = x + 1;
		cd.isPreserved = set.getBoolean(x);
		x = x + 1;
		cd.year = set.getInt(x);
		x = x + 1;
		cd.databaseID = set.getInt(x);
		x = x + 1;
		return cd;
	}
	
	/**
	 * This method takes a partially retrieved record (from the search window), and retrieves all the information associated with it.
	 */
	public static CollectionData getRealDataFor(CollectionData c) throws Exception {
		int x = getIDFor(c);
		if (c.databaseID == -1) {
			throw new Exception("File doesn't already exist.");	
		} else {
			Connection con = getConnection();
			Statement s = con.createStatement();
			String sql = "SELECT * FROM Collections WHERE ID=" + x;			
			s.execute(sql);
			ResultSet rs = s.getResultSet();
			Vector vec = new Vector();
			if (rs == null) {
				throw new Exception("File doesn't already exist.");	
			}
		    rs.next();
		    CollectionData xx = getCollectionDataFor(rs);
			s.close();
			con.close();
			return xx;		
		}	
	}
	
	static CollectionData getCollectionDataFor(ResultSet set) throws Exception {
		CollectionData cd = new CollectionData();
		int x = 1;
		cd.databaseID = set.getInt(x);
		x = x + 1;
		cd.runningTotal = set.getDouble(x);
		x = x + 1;
		cd.collectionNumber = set.getString(x);
		x = x + 1;
		cd.collectionPart = set.getString(x);
		x = x + 1;
		cd.collectionName = set.getString(x);
		x = x + 1;
		cd.shelfNumber = set.getString(x);
		x = x + 1;
		cd.worker = set.getString(x);
		x = x + 1;
		cd.date = set.getString(x);
		x = x + 1;
		cd.projectTitle = set.getString(x);
		x = x + 1;
		cd.partOne = set.getString(x);
		x = x + 1;
		cd.partTwo = set.getString(x);
		x = x + 1;
		cd.generation = set.getString(x);
		x = x + 1;
		cd.year = set.getInt(x);
		x = x + 1;
		cd.minute = set.getBoolean(x);
		x = x + 1;
		cd.offBrand = set.getBoolean(x);
		x = x + 1;
		cd.lubricant = set.getBoolean(x);
		x = x + 1;
		cd.fungus = set.getBoolean(x);
		x = x + 1;
		cd.other = set.getBoolean(x);
		x = x + 1;
		cd.typeIcassette = set.getBoolean(x);
		x = x + 1;
		cd.typeIIcassette = set.getBoolean(x);	
		x = x + 1;
		cd.typeIIIcassette = set.getBoolean(x);
		x = x + 1;
		cd.typeIVcassette = set.getBoolean(x);
		x = x + 1;
		cd.dolbyCcassette = set.getBoolean(x);	
		x = x + 1;
		cd.dolbyScassette = set.getBoolean(x);
		x = x + 1;
		cd.dolbyBcassette = set.getBoolean(x);
		x = x + 1;
		cd.dbxcassette = set.getBoolean(x);
		x = x + 1;
		cd.oxidation = set.getBoolean(x);
		x = x + 1;
		cd.thinTape = set.getBoolean(x);
		x = x + 1;
		cd.pre1993 = set.getBoolean(x);
		x = x + 1;
		cd.portableDAT = set.getBoolean(x);
		x = x + 1;
		cd.dataGradeDAT = set.getBoolean(x);
		x = x + 1;
		cd.longPlayDAT = set.getBoolean(x);
		x = x + 1;
		cd.glass = set.getBoolean(x);
		x = x + 1;
		cd.plastic = set.getBoolean(x);
		x = x + 1;
		cd.delamination = set.getBoolean(x);
		x = x + 1;
		cd.longPlayAcetate = set.getBoolean(x);
		x = x + 1;
		cd.doublePlayAcetate = set.getBoolean(x);
		x = x + 1;
		cd.triplePlayAcetate = set.getBoolean(x);
		x = x + 1;
		cd.standardAcetate = set.getBoolean(x);
		x = x + 1;
		cd.vinegar = set.getBoolean(x);
		x = x + 1;
		cd.visibleMinorAcetate = set.getBoolean(x);
		x = x + 1;
		cd.visibleModerateAcetate = set.getBoolean(x);
		x = x + 1;
		cd.visibleSevereAcetate = set.getBoolean(x);
		x = x + 1;
		cd.fullTrack = set.getBoolean(x);
		x = x + 1;
		cd.halfTrack = set.getBoolean(x);
		x = x + 1;
		cd.quarterTrack = set.getBoolean(x);
		x = x + 1;
		cd.unknownTrack = set.getBoolean(x);
		x = x + 1;
		cd.unknownSound = set.getBoolean(x);
		x = x + 1;
		cd.speed1 = set.getBoolean(x);
		x = x + 1;
		cd.speed2 = set.getBoolean(x);
		x = x + 1;
		cd.speed3 = set.getBoolean(x);
		x = x + 1;
		cd.speed4 = set.getBoolean(x);
		x = x + 1;
		cd.speed5 = set.getBoolean(x);
		x = x + 1;
		cd.speed6 = set.getBoolean(x);
		x = x + 1;
		cd.unknownSpeed = set.getBoolean(x);
		x = x + 1;
		cd.dolbyAacetate = set.getBoolean(x);
		x = x + 1;
		cd.dolbyBacetate = set.getBoolean(x);
		x = x + 1;
		cd.dolbySRacetate = set.getBoolean(x);
		x = x + 1;
		cd.dbxAcetate = set.getBoolean(x);
		x = x + 1;
		cd.longPlayPoly = set.getBoolean(x);
		x = x + 1;
		cd.doublePlayPoly = set.getBoolean(x);
		x = x + 1;
		cd.triplePlayPoly = set.getBoolean(x);
		x = x + 1;
		cd.standardPoly = set.getBoolean(x);
		x = x + 1;
		cd.thirtyPoly = set.getBoolean(x);
		x = x + 1;
		cd.stickyPoly = set.getBoolean(x);
		x = x + 1;
		cd.lossPoly = set.getBoolean(x);
		x = x + 1;
		cd.visibleMinorPoly = set.getBoolean(x);
		x = x + 1;
		cd.visibleModeratePoly = set.getBoolean(x);
		x = x + 1;
		cd.visibleSeverePoly = set.getBoolean(x);
		x = x + 1;
		cd.dolbyApoly = set.getBoolean(x);
		x = x + 1;
		cd.dolbyBpoly = set.getBoolean(x);
		x = x + 1;
		cd.dolbySRpoly = set.getBoolean(x);
		x = x + 1;
		cd.dbxPoly = set.getBoolean(x);
		x = x + 1;
		cd.longPlayPaper = set.getBoolean(x);
		x = x + 1;
		cd.doublePlayPaper = set.getBoolean(x);
		x = x + 1;
		cd.triplePlayPaper = set.getBoolean(x);
		x = x + 1;
		cd.standardPaper = set.getBoolean(x);
		x = x + 1;
		cd.visibleMinorPaper = set.getBoolean(x);
		x = x + 1;
		cd.visibleModeratePaper = set.getBoolean(x);
		x = x + 1;
		cd.visibleSeverePaper = set.getBoolean(x);
		x = x + 1;
		cd.longPlayPVC = set.getBoolean(x);
		x = x + 1;
		cd.doublePlayPVC = set.getBoolean(x);
		x = x + 1;
		cd.triplePlayPVC = set.getBoolean(x);
		x = x + 1;
		cd.standardPlayPVC = set.getBoolean(x);
		x = x + 1;
		cd.lubricantPVC = set.getBoolean(x);
		x = x + 1;
		cd.visibleMinorPVC = set.getBoolean(x);
		x = x + 1;
		cd.visibleModeratePVC = set.getBoolean(x);
		x = x + 1;
		cd.visibleSeverePVC = set.getBoolean(x);
		x = x + 1;
		cd.stickyPVC = set.getBoolean(x);
		x = x + 1;
		cd.lossPVC = set.getBoolean(x);
		x = x + 1;
		cd.dolbyAPVC = set.getBoolean(x);
		x = x + 1;
		cd.dolbyBPVC = set.getBoolean(x);
		x = x + 1;
		cd.dolbySRPVC = set.getBoolean(x);
		x = x + 1;
		cd.dbxPVC = set.getBoolean(x);
		x = x + 1;
		cd.preWWII = set.getBoolean(x);
		x = x + 1;
		cd.orpMastersBox = set.getBoolean(x);
		x = x + 1;
		cd.orpMastersStickyBox = set.getBoolean(x);
		x = x + 1;
		cd.orpNonMasterBox = set.getBoolean(x);
		x = x + 1;
		cd.oraBox = set.getBoolean(x);
		x = x + 1;
		cd.DACBox = set.getBoolean(x);
		x = x + 1;
		cd.cassetteBox = set.getBoolean(x);
		x = x + 1;
		cd.DATBox = set.getBoolean(x);
		x = x + 1;
		cd.cdDataBox = set.getBoolean(x);
		x = x + 1;
		cd.cdAudioBox = set.getBoolean(x);
		x = x + 1;
		cd.historyBox = set.getBoolean(x);
		x = x + 1;
		cd.researchValue = set.getDouble(x);
		x = x + 1;
		cd.notes4_5 = set.getString(x);
		x = x + 1;
		cd.rust = set.getBoolean(x);
		x = x + 1;
		cd.unknownDoubleTripleAcetate = set.getBoolean(x);
		x = x + 1;
		cd.unknownDoubleTriplePoly = set.getBoolean(x);
		x = x + 1;
		cd.unknownDoubleTriplePVC = set.getBoolean(x);
		x = x + 1;
		cd.formatString = set.getString(x);
		x = x + 1;
		cd.isPreserved = set.getBoolean(x);
		x = x + 1;
		cd.explanationString = set.getString(x);
		x = x + 1;
		cd.stereo = set.getBoolean(x);
		x = x + 1;
		cd.mono = set.getBoolean(x); 
		x = x + 1;
		
		cd.modPoints = getModPointsFor(cd.databaseID);		
		return cd;
	}
	
	static private void saveNewRecord(CollectionData theData) throws Exception {
		Connection con = getConnection();
		Statement s = con.createStatement();
		String bigSQL = "INSERT INTO Collections (";
		bigSQL = bigSQL + "TotalPoints, CollectionNumber, CollectionPart, CollectionName, " +
				"ShelfNumber, Worker, DateField, ProjectTitle, PartOne, PartTwo, Generation, " +
				"Year, Minute, OffBrand, Lubricant, " +
				"Fungus, Other, TypeICassette, TypeIICassette, TypeIIICassette, TypeIVCassette, " +
				"DolbyCassette, DolbySCassette, DolbyBCassette, " + 
				"DbxCassette, Oxidation, ThinTape, Pre1993, PortableDAT, DataGradeDAT, LongPlayDAT, " +  
				"Glass, Plastic, Delamination, LongPlayAcetate, DoublePlayAcetate, TriplePlayAcetate, " + 
				"StandardAcetate, Vinegar, VisibleMinorAcetate, VisibleModerateAcetate, " +
				"VisibleSevereAcetate, " +  
				"FullTrack, HalfTrack, QuarterTrack, UnknownTrack, " +
				"UnknownSound, Speed1, Speed2, Speed3, Speed4, Speed5, Speed6, " +
				"UnknownSpeed, DolbyAacetate, DolbyBacetate, DolbySRacetate, DbxAcetate, LongPlayPoly, DoublePlayPoly, TriplePlayPoly, " +
				"StandardPoly, ThirtyPoly, StickyPoly, LossPoly, VisibleMinorPoly, VisibleModeratePoly, " +
				"VisibleSeverePoly, " +  
				"DolbyApoly, " +
				"DolbyBpoly, DolbySRpoly, DbxPoly, longPlayPaper, doublePlayPaper, triplePlayPaper, standardPaper, " +
				"visibleMinorPaper, visibleModeratePaper, visibleSeverePaper, " +  
				"longPlayPVC, doublePlayPVC, triplePlayPVC, standardPlayPVC, " +
				"lubricantPVC, visibleMinorPVC, visibleModeratePVC, visibleSeverePVC, " +
				"stickyPVC, lossPVC, " +  
				"dolbyAPVC, dolbyBPVC, dolbySRPVC, dbxPVC, preWWII, " +
				"orpMastersBox, orpMastersStickyBox, orpNonMastersBox, oraBox, DACBox, cassetteBox, " +  
				"DATBox, cdDataBox, cdAudioBox, historyBox, researchValue, notes4_5, rust, unknownDoubleTripleAcetate, " +
				"unknownDoubleTriplePoly, unknownDoubleTriplePVC, formatString, isPreserved, explanationString, stereo, mono";	
		
		bigSQL = bigSQL + ") VALUES (";
		bigSQL = bigSQL + theData.runningTotal + ", "; 
		bigSQL = bigSQL + "'" + PrepareString(theData.collectionNumber) + "', "; 
		bigSQL = bigSQL + "'" + PrepareString(theData.collectionPart) + "', "; 
		bigSQL = bigSQL + "'" + PrepareString(theData.collectionName) + "', "; 
		bigSQL = bigSQL + "'" + PrepareString(theData.shelfNumber) + "', "; 
		bigSQL = bigSQL + "'" + PrepareString(theData.worker) + "', "; 
		bigSQL = bigSQL + "'" + PrepareString(theData.date) + "', "; 
		bigSQL = bigSQL + "'" + PrepareString(theData.projectTitle) + "', "; 
		bigSQL = bigSQL + "'" + PrepareString(theData.partOne) + "', "; 
		bigSQL = bigSQL + "'" + PrepareString(theData.partTwo) + "', "; 
		bigSQL = bigSQL + "'" + PrepareString(theData.generation) + "', "; 
		bigSQL = bigSQL + theData.year + ", "; 
		bigSQL = bigSQL + theData.minute + ", "; 
		bigSQL = bigSQL + theData.offBrand + ", "; 
		bigSQL = bigSQL + theData.lubricant + ", "; 
		bigSQL = bigSQL + theData.fungus + ", "; 
		bigSQL = bigSQL + theData.other + ", "; 
		bigSQL = bigSQL + theData.typeIcassette + ", "; 
		bigSQL = bigSQL + theData.typeIIcassette + ", "; 
		bigSQL = bigSQL + theData.typeIIIcassette + ", "; 
		bigSQL = bigSQL + theData.typeIVcassette + ", "; 
		bigSQL = bigSQL + theData.dolbyCcassette + ", "; 
		bigSQL = bigSQL + theData.dolbyScassette + ", "; 
		bigSQL = bigSQL + theData.dolbyBcassette + ", "; 
		bigSQL = bigSQL + theData.dbxcassette + ", "; 
		bigSQL = bigSQL + theData.oxidation + ", "; 
		bigSQL = bigSQL + theData.thinTape + ", "; 
		bigSQL = bigSQL + theData.pre1993 + ", "; 
		bigSQL = bigSQL + theData.portableDAT + ", "; 
		bigSQL = bigSQL + theData.dataGradeDAT + ", "; 
		bigSQL = bigSQL + theData.longPlayDAT + ", "; 
		bigSQL = bigSQL + theData.glass + ", "; 
		bigSQL = bigSQL + theData.plastic + ", "; 
		bigSQL = bigSQL + theData.delamination + ", "; 
		bigSQL = bigSQL + theData.longPlayAcetate + ", "; 
		bigSQL = bigSQL + theData.doublePlayAcetate + ", "; 
		bigSQL = bigSQL + theData.triplePlayAcetate + ", "; 
		bigSQL = bigSQL + theData.standardAcetate + ", "; 
		bigSQL = bigSQL + theData.vinegar + ", "; 
		bigSQL = bigSQL + theData.visibleMinorAcetate + ", "; 
		bigSQL = bigSQL + theData.visibleModerateAcetate + ", "; 
		bigSQL = bigSQL + theData.visibleSevereAcetate + ", "; 
		bigSQL = bigSQL + theData.fullTrack + ", "; 
		bigSQL = bigSQL + theData.halfTrack + ", "; 
		bigSQL = bigSQL + theData.quarterTrack + ", "; 
		bigSQL = bigSQL + theData.unknownTrack + ", "; 
		bigSQL = bigSQL + theData.unknownSound + ", "; 
		bigSQL = bigSQL + theData.speed1 + ", "; 
		bigSQL = bigSQL + theData.speed2 + ", "; 
		bigSQL = bigSQL + theData.speed3 + ", "; 
		bigSQL = bigSQL + theData.speed4 + ", "; 
		bigSQL = bigSQL + theData.speed5 + ", "; 
		bigSQL = bigSQL + theData.speed6 + ", "; 
		bigSQL = bigSQL + theData.unknownSpeed + ", "; 
		bigSQL = bigSQL + theData.dolbyAacetate + ", "; 
		bigSQL = bigSQL + theData.dolbyBacetate + ", "; 
		bigSQL = bigSQL + theData.dolbySRacetate + ", "; 
		bigSQL = bigSQL + theData.dbxAcetate + ", "; 
		bigSQL = bigSQL + theData.longPlayPoly + ", "; 
		bigSQL = bigSQL + theData.doublePlayPoly + ", "; 
		bigSQL = bigSQL + theData.triplePlayPoly + ", "; 
		bigSQL = bigSQL + theData.standardPoly + ", "; 
		bigSQL = bigSQL + theData.thirtyPoly + ", "; 
		bigSQL = bigSQL + theData.stickyPoly + ", "; 
		bigSQL = bigSQL + theData.lossPoly + ", "; 
		bigSQL = bigSQL + theData.visibleMinorPoly + ", "; 
		bigSQL = bigSQL + theData.visibleModeratePoly + ", "; 
		bigSQL = bigSQL + theData.visibleSeverePoly + ", "; 
		bigSQL = bigSQL + theData.dolbyApoly + ", ";
		bigSQL = bigSQL + theData.dolbyBpoly + ", ";
		bigSQL = bigSQL + theData.dolbySRpoly + ", ";
		bigSQL = bigSQL + theData.dbxPoly + ", ";
		bigSQL = bigSQL + theData.longPlayPaper + ", ";
		bigSQL = bigSQL + theData.doublePlayPaper + ", ";
		bigSQL = bigSQL + theData.triplePlayPaper + ", ";
		bigSQL = bigSQL + theData.standardPaper + ", ";
		bigSQL = bigSQL + theData.visibleMinorPaper + ", ";
		bigSQL = bigSQL + theData.visibleModeratePaper + ", ";
		bigSQL = bigSQL + theData.visibleSeverePaper + ", ";
		bigSQL = bigSQL + theData.longPlayPVC + ", ";
		bigSQL = bigSQL + theData.doublePlayPVC + ", ";
		bigSQL = bigSQL + theData.triplePlayPVC + ", ";
		bigSQL = bigSQL + theData.standardPlayPVC + ", ";
		bigSQL = bigSQL + theData.lubricantPVC + ", ";
		bigSQL = bigSQL + theData.visibleMinorPVC + ", ";
		bigSQL = bigSQL + theData.visibleModeratePVC + ", ";
		bigSQL = bigSQL + theData.visibleSeverePVC + ", ";
		bigSQL = bigSQL + theData.stickyPVC + ", ";
		bigSQL = bigSQL + theData.lossPVC + ", ";
		bigSQL = bigSQL + theData.dolbyAPVC + ", ";
		bigSQL = bigSQL + theData.dolbyBPVC + ", ";
		bigSQL = bigSQL + theData.dolbySRPVC + ", ";
		bigSQL = bigSQL + theData.dbxPVC + ", ";
		bigSQL = bigSQL + theData.preWWII + ", ";
		bigSQL = bigSQL + theData.orpMastersBox + ", ";
		bigSQL = bigSQL + theData.orpMastersStickyBox + ", ";
		bigSQL = bigSQL + theData.orpNonMasterBox + ", ";
		bigSQL = bigSQL + theData.oraBox + ", ";
		bigSQL = bigSQL + theData.DACBox + ", ";
		bigSQL = bigSQL + theData.cassetteBox + ", ";
		bigSQL = bigSQL + theData.DATBox + ", ";
		bigSQL = bigSQL + theData.cdDataBox + ", ";
		bigSQL = bigSQL + theData.cdAudioBox + ", ";
		bigSQL = bigSQL + theData.historyBox + ", ";
		bigSQL = bigSQL + theData.researchValue + ", ";
		bigSQL = bigSQL + "'" + PrepareString(theData.notes4_5) + "', ";
		bigSQL = bigSQL + theData.rust + ", ";
		bigSQL = bigSQL + theData.unknownDoubleTripleAcetate + ", ";
		bigSQL = bigSQL + theData.unknownDoubleTriplePoly + ", ";
		bigSQL = bigSQL + theData.unknownDoubleTriplePVC + ", ";
		bigSQL = bigSQL + "'" + PrepareString(theData.formatString) + "', ";  //newly added
		bigSQL = bigSQL + theData.isPreserved + ", ";
		bigSQL = bigSQL + "'" + PrepareString(theData.explanationString) + "', "; 
		bigSQL = bigSQL + theData.stereo + ", "; 
		bigSQL = bigSQL + theData.mono; 
		
		bigSQL = bigSQL + ");";		
		s.execute(bigSQL);
		s.close();
		con.close();
		//we now need to update the CollectionData object to tell it the ID that got assigned to this record		
	    theData.databaseID = getIDFor(theData);
		addModPointsFor(theData);
	}
	
	static private void saveExistingRecord(CollectionData theData) throws Exception {
		Connection con = getConnection();
		
		Statement s = con.createStatement();
		String bigSQL = "UPDATE Collections SET ";
		bigSQL = bigSQL + "TotalPoints = " + theData.runningTotal + ",";
		bigSQL = bigSQL + "CollectionNumber = '" + PrepareString(theData.collectionNumber) + "',";
		bigSQL = bigSQL + "CollectionPart = '" + PrepareString(theData.collectionPart) + "',";
		bigSQL = bigSQL + "CollectionName = '" + PrepareString(theData.collectionName) + "',";
		bigSQL = bigSQL + "ShelfNumber = '" + PrepareString(theData.shelfNumber) + "',";
		bigSQL = bigSQL + "Worker = '" + PrepareString(theData.worker) + "',";
		bigSQL = bigSQL + "DateField = '" + PrepareString(theData.date) + "',";
		bigSQL = bigSQL + "ProjectTitle = '" + PrepareString(theData.projectTitle) + "',";
		bigSQL = bigSQL + "PartOne = '" + PrepareString(theData.partOne) + "',";
		bigSQL = bigSQL + "PartTwo = '" + PrepareString(theData.partTwo) + "',";
		bigSQL = bigSQL + "Generation = '" + PrepareString(theData.generation) + "',";
		bigSQL = bigSQL + "Year = " + theData.year + ",";
		bigSQL = bigSQL + "Minute = " + theData.minute + ",";
		bigSQL = bigSQL + "OffBrand = " + theData.offBrand + ", ";
		bigSQL = bigSQL + "Lubricant = " + theData.lubricant + ", ";
		bigSQL = bigSQL + "Fungus = " + theData.fungus + ", ";
		bigSQL = bigSQL + "Other = " + theData.other + ", ";
		bigSQL = bigSQL + "TypeICassette = " + theData.typeIcassette + ", ";
		bigSQL = bigSQL + "TypeIICassette = " + theData.typeIIcassette + ", ";
		bigSQL = bigSQL + "TypeIIICassette = " + theData.typeIIIcassette + ", ";
		bigSQL = bigSQL + "TypeIVCassette = " + theData.typeIVcassette + ", ";
		bigSQL = bigSQL + "DolbyCassette = " + theData.dolbyCcassette + ", ";
		bigSQL = bigSQL + "DolbySCassette = " + theData.dolbyScassette + ", ";
		bigSQL = bigSQL + "DolbyBCassette = " + theData.dolbyBcassette + ", ";
		bigSQL = bigSQL + "DbxCassette = " + theData.dbxcassette + ", ";
		bigSQL = bigSQL + "Oxidation = " + theData.oxidation + ", ";
		bigSQL = bigSQL + "ThinTape = " + theData.thinTape + ", ";
		bigSQL = bigSQL + "Pre1993 = " + theData.pre1993 + ", ";
		bigSQL = bigSQL + "PortableDAT = " + theData.portableDAT + ", ";
		bigSQL = bigSQL + "DataGradeDAT = " + theData.dataGradeDAT + ", ";
		bigSQL = bigSQL + "LongPlayDAT = " + theData.longPlayDAT + ", ";
		bigSQL = bigSQL + "Glass = " + theData.glass + ", ";
		bigSQL = bigSQL + "Plastic = " + theData.plastic + ", ";
		bigSQL = bigSQL + "Delamination = " + theData.delamination + ", ";
		bigSQL = bigSQL + "LongPlayAcetate = " + theData.longPlayAcetate + ", ";
		bigSQL = bigSQL + "DoublePlayAcetate = " + theData.doublePlayAcetate + ", ";
		bigSQL = bigSQL + "TriplePlayAcetate = " + theData.triplePlayAcetate + ", ";
		bigSQL = bigSQL + "StandardAcetate = " + theData.standardAcetate + ", ";
		bigSQL = bigSQL + "Vinegar = " + theData.vinegar + ", ";
		bigSQL = bigSQL + "VisibleMinorAcetate = " + theData.visibleMinorAcetate + ", ";
		bigSQL = bigSQL + "VisibleModerateAcetate = " + theData.visibleModerateAcetate + ", ";
		bigSQL = bigSQL + "VisibleSevereAcetate = " + theData.visibleSevereAcetate + ", ";
		bigSQL = bigSQL + "FullTrack = " + theData.fullTrack + ", ";
		bigSQL = bigSQL + "HalfTrack = " + theData.halfTrack + ", ";
		bigSQL = bigSQL + "QuarterTrack = " + theData.quarterTrack + ", ";
		bigSQL = bigSQL + "UnknownTrack = " + theData.unknownTrack + ", ";
		bigSQL = bigSQL + "UnknownSound = " + theData.unknownSound + ", ";
		bigSQL = bigSQL + "Speed1 = " + theData.speed1 + ", ";
		bigSQL = bigSQL + "Speed2 = " + theData.speed2 + ", ";
		bigSQL = bigSQL + "Speed3 = " + theData.speed3 + ", ";
		bigSQL = bigSQL + "Speed4 = " + theData.speed4 + ", ";
		bigSQL = bigSQL + "Speed5 = " + theData.speed5 + ", ";
		bigSQL = bigSQL + "Speed6 = " + theData.speed6 + ", ";
		bigSQL = bigSQL + "UnknownSpeed = " + theData.unknownSpeed + ", ";
		bigSQL = bigSQL + "DolbyAacetate = " + theData.dolbyAacetate + ", ";
		bigSQL = bigSQL + "DolbyBacetate = " + theData.dolbyBacetate + ", ";
		bigSQL = bigSQL + "DolbySRacetate = " + theData.dolbySRacetate + ", ";
		bigSQL = bigSQL + "DbxAcetate = " + theData.dbxAcetate + ", ";
		bigSQL = bigSQL + "LongPlayPoly = " + theData.longPlayPoly + ", ";
		bigSQL = bigSQL + "DoublePlayPoly = " + theData.doublePlayPoly + ", ";
		bigSQL = bigSQL + "TriplePlayPoly = " + theData.triplePlayPoly + ", ";
		bigSQL = bigSQL + "StandardPoly = " + theData.standardPoly + ", ";
		bigSQL = bigSQL + "ThirtyPoly = " + theData.thirtyPoly + ", ";
		bigSQL = bigSQL + "StickyPoly = " + theData.stickyPoly + ", ";
		bigSQL = bigSQL + "LossPoly = " + theData.lossPoly + ", ";
		bigSQL = bigSQL + "VisibleMinorPoly = " + theData.visibleMinorPoly + ", ";
		bigSQL = bigSQL + "VisibleModeratePoly = " + theData.visibleModeratePoly + ", ";
		bigSQL = bigSQL + "VisibleSeverePoly = " + theData.visibleSeverePoly + " ";
		
		bigSQL = bigSQL + "WHERE ID=" + theData.databaseID;
		s.execute(bigSQL);
		s.close();
		
		//have to split the update transaction into 2 since there are too many fields for the Jet engine
		//to deal with in 1 transaction
		s = con.createStatement();
		bigSQL = "UPDATE Collections SET ";
		
		bigSQL = bigSQL + "DolbyApoly = " + theData.dolbyApoly + ", ";
		bigSQL = bigSQL + "DolbyBpoly = " + theData.dolbyBpoly + ", ";
		bigSQL = bigSQL + "DolbySRpoly = " + theData.dolbySRpoly + ", ";
		bigSQL = bigSQL + "DbxPoly = " + theData.dbxPoly + ", ";
		bigSQL = bigSQL + "longPlayPaper = " + theData.longPlayPaper + ", ";
		bigSQL = bigSQL + "doublePlayPaper = " + theData.doublePlayPaper + ", ";
		bigSQL = bigSQL + "triplePlayPaper = " + theData.triplePlayPaper + ", ";
		bigSQL = bigSQL + "standardPaper = " + theData.standardPaper + ", ";
		bigSQL = bigSQL + "visibleMinorPaper = " + theData.visibleMinorPaper + ", ";
		bigSQL = bigSQL + "visibleModeratePaper = " + theData.visibleModeratePaper + ", ";
		bigSQL = bigSQL + "visibleSeverePaper = " + theData.visibleSeverePaper + ", ";
		bigSQL = bigSQL + "longPlayPVC = " + theData.longPlayPVC + ", ";
		bigSQL = bigSQL + "doublePlayPVC = " + theData.doublePlayPVC + ", ";
		bigSQL = bigSQL + "triplePlayPVC = " + theData.triplePlayPVC + ", ";
		bigSQL = bigSQL + "standardPlayPVC = " + theData.standardPlayPVC + ", ";
		bigSQL = bigSQL + "lubricantPVC = " + theData.lubricantPVC + ", ";
		bigSQL = bigSQL + "visibleMinorPVC = " + theData.visibleMinorPVC + ", ";
		bigSQL = bigSQL + "visibleModeratePVC = " + theData.visibleModeratePVC + ", ";
		bigSQL = bigSQL + "visibleSeverePVC = " + theData.visibleSeverePVC + ", ";
		bigSQL = bigSQL + "stickyPVC = " + theData.stickyPVC + ", ";
		bigSQL = bigSQL + "lossPVC = " + theData.lossPVC + ", ";
		bigSQL = bigSQL + "dolbyAPVC = " + theData.dolbyAPVC + ", ";
		bigSQL = bigSQL + "dolbyBPVC = " + theData.dolbyBPVC + ", ";
		bigSQL = bigSQL + "dolbySRPVC = " + theData.dolbySRPVC + ", ";
		bigSQL = bigSQL + "dbxPVC = " + theData.dbxPVC + ", ";
		bigSQL = bigSQL + "preWWII = " + theData.preWWII + ", ";
		bigSQL = bigSQL + "orpMastersBox = " + theData.orpMastersBox + ", ";
		bigSQL = bigSQL + "orpMastersStickyBox = " + theData.orpMastersStickyBox + ", ";
		bigSQL = bigSQL + "orpNonMastersBox = " + theData.orpNonMasterBox + ", ";
		bigSQL = bigSQL + "oraBox = " + theData.oraBox + ", ";
		bigSQL = bigSQL + "DACBox = " + theData.DACBox + ", ";
		bigSQL = bigSQL + "cassetteBox = " + theData.cassetteBox + ", ";
		bigSQL = bigSQL + "DATBox = " + theData.DATBox + ", ";
		bigSQL = bigSQL + "cdDataBox = " + theData.cdDataBox + ", ";
		bigSQL = bigSQL + "cdAudioBox = " + theData.cdAudioBox + ", ";
		bigSQL = bigSQL + "historyBox = " + theData.historyBox + ", ";
		bigSQL = bigSQL + "researchValue = " + theData.researchValue + ", ";
		bigSQL = bigSQL + "notes4_5 = '" + PrepareString(theData.notes4_5) + "', ";
		bigSQL = bigSQL + "rust = " + theData.rust + ", ";
		bigSQL = bigSQL + "unknownDoubleTripleAcetate = " + theData.unknownDoubleTripleAcetate + ", ";
		bigSQL = bigSQL + "unknownDoubleTriplePoly = " + theData.unknownDoubleTriplePoly + ", ";
		bigSQL = bigSQL + "unknownDoubleTriplePVC = " + theData.unknownDoubleTriplePVC + ", ";
		bigSQL = bigSQL + "formatString = '" + PrepareString(theData.formatString) + "', "; //newly added
		bigSQL = bigSQL + "isPreserved = " + theData.isPreserved + ", ";
		if (theData.explanationString == null) {
			theData.explanationString = "";
		}
		bigSQL = bigSQL + "explanationString = '" + PrepareString(theData.explanationString) + "', ";
		bigSQL = bigSQL + "stereo = " + theData.stereo + ", ";
		bigSQL = bigSQL + "mono = " + theData.mono + " ";
		bigSQL = bigSQL + "WHERE ID=" + theData.databaseID;
		s.execute(bigSQL);
		s.close();
		
		con.close();
		
		//mod points stuff
		removeModPointsFor(theData.databaseID);
		addModPointsFor(theData);
		
		//System.out.println(bigSQL);
	}
	
	static private void removeModPointsFor(int databaseID) throws Exception {
		Connection con = getConnection();
		Statement s = con.createStatement();
		String bigSQL = "DELETE FROM ModData WHERE CollectionID = " + databaseID;
		s.execute(bigSQL);
		s.close();
		con.close();
	}
	
	static private void addModPointsFor(CollectionData theData) throws Exception {
		Connection con = getConnection();
		int counter = 0;
		while (counter < theData.modPoints.size()) {
			ModData modd = (ModData)theData.modPoints.get(counter);
			Statement s = con.createStatement();
			String bigSQL = "INSERT INTO ModData (pointsAdded, explanationText, CollectionID) VALUES (" +
					modd.pointsAdded + ", '" + PrepareString(modd.explanationText) + "', "+ theData.databaseID + ")";
			s.execute(bigSQL);
			s.close();
			counter = counter + 1;
		}
		con.close();
	}
	
	static private Vector getModPointsFor(int databaseID) throws Exception {
		Connection con = getConnection();
		Statement s = con.createStatement();
		String bigSQL = "SELECT pointsAdded, explanationText FROM ModData WHERE CollectionID = " + databaseID;
		s.execute(bigSQL);
		ResultSet rs = s.getResultSet();
		Vector vec = new Vector();
		if (rs == null) {
			return vec;
		}
	    while (rs.next()) {
	    	vec.add(getModDataFor(rs));
	    }
		s.close();
		con.close();
		return vec;	
	}
	
	static ModData getModDataFor(ResultSet set) throws Exception {
		ModData md = new ModData();
		md.pointsAdded = set.getDouble(1);
		md.explanationText = set.getString(2);
		return md;
	}
	
	static private Connection getConnection() throws Exception {
		File f = new File(Main.getDatabaseLocation());
		if (!f.exists()) {
			throw new Exception("The database file can not be found.\nEdit the database location from the welcome screen.");
		}
		if (!f.canWrite()) {
			throw new Exception("The database file is read-only and cannot be accessed.");
		}
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=";
		database += Main.getDatabaseLocation() + ";DriverID=22;READONLY=false}";
		Connection con = DriverManager.getConnection(database, "", "");
		return con;
	}
}

