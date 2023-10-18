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

import java.text.*;
import java.util.*;
import edu.indiana.dlib.sounddirections.facet.*;

public class CollectionData {
	
	/********* POINT VALUE CONSTANTS *********/
	final static float fungusVal = 1.5f;
	final static float otherVal = 1.5f;
	final static float offBrandVal = 0.75f;
	/*cassette values*/
	final static float cassetteBASE = 2.75f;
	final static int typeIcassetteVal = 0;
	final static float typeIIcassetteVal = 0.5f;
	final static float typeIIIcassetteVal = 1.15f;
	final static float typeIVcassetteVal = 0.5f;
	final static float minuteVal = 0.75f;
	final static int lubricantVal = 2;
	final static float dolbyScassetteVal = 0.5f;
	final static float dolbyCcassetteVal = 0.5f;
	final static float dolbyBcassetteVal = 0.25f;
	final static float dbxCassetteVal = 0.5f;
	/*aluminum values*/
	final static int aluminumBASE = 3;
	final static int oxidationVal = 1;
	/*DAT values*/
	final static int datBASE = 4;
	final static float tapeVal = 0.75f;
	final static float preVal = 0.5f;
	final static float portableDATVal = 0.25f;
	final static float dataGradeDATVal = 0.5f;
	final static float longPlayDATVal = 0.5f;
	/*acetate values*/
	final static int acetateBASE = 3;
	final static float longPlayAcetateVal = 0.5f;
	final static int doublePlayAcetateVal = 1;
	final static float triplePlayAcetateVal = 1.2f;
	final static float unknownDoubleTripleAcetateVal = 1.1f;
	final static int standardAcetateVal = 0;
	final static float vinegarVal = 1.5f;
	final static float visibleMinorAcetateVal = 0.25f;
	final static float visibleModerateAcetateVal = 0.5f;
	final static float visibleSevereAcetateVal = 0.75f;
	final static float dolbyAacetateVal = 0.5f;
	final static float dolbyBacetateVal = 0.5f;
	final static float dolbySRacetateVal = 0.5f;
	final static float dbxAcetateVal = 0.5f;
	/*laquer disc values*/
	final static float lacBASE = 4.25f;
	final static float glassVal = 0.5f;
	final static float plasticVal = 1.5f;
	final static int delamVal = 2;
	/*polyester values*/
	final static float polyesterBASE = 2.5f;
	final static float longPlayPolyVal = 0.5f;
	final static int doublePlayPolyVal = 1;
	final static float triplePlayPolyVal = 1.2f;
	final static float unknownDoubleTriplePolyVal = 1.1f;
	final static int standardPolyVal = 0;
	final static float thirtyPolyVal = 0.5f;
	final static int stickyPolyVal = 2;
	final static int lossPolyVal = 2;
	final static float visibleMinorPolyVal = 0.25f;
	final static float visibleModeratePolyVal = 0.5f;
	final static float visibleSeverePolyVal = 0.75f;
	final static float dolbyApolyVal = 0.5f;
	final static float dolbyBpolyVal = 0.5f;
	final static float dolbySRpolyVal = 0.5f;
	final static float dbxPolyVal = 0.5f;
	/*paper values*/
	final static float paperBASE = 2.75f;
	final static float oneMilPaperVal = 0.5f;
	final static float longPlayPaperVal = 0.5f;
	final static int standardPaperVal = 0;
	final static float visibleMinorPaperVal = 0.25f;
	final static float visibleModeratePaperVal = 0.5f;
	final static float visibleSeverePaperVal = 0.75f;
	/*PVC values*/
	final static float ORTpvcBASE = 2.5f;
	final static float longPlayPVCval = 0.5f;
	final static int doublePlayPVCval = 1;
	final static float triplePlayPVCval = 1.2f;
	final static float unknownDoubleTriplePVCval = 1.1f;
	final static int standardPlayPVCval = 0;
	final static int stickyPVCval = 2;
	final static int lossPVCval = 2;
	final static float minorPVCval = 0.25f;
	final static float moderatePVCval = 0.5f;
	final static float severePVCval = 0.75f;
	final static float dolbyApvcVal = 0.5f;
	final static float dolbyBpvcVal = 0.5f;
	final static float dolbySRpvcVal = 0.5f;
	final static float dbxPVCVal = 0.5f;
	/*wire values*/
	final static float wireBASE = 2.75f;
	final static int preWWIIval = 1;
	final static int rustVal = 2;
	/*sound field values*/
	final static float stereoVal = 0.15f;
	final static int monoVal = 0;
	/*tracking values*/
	final static float fullTrackVal = 0.034f;
	final static float halfTrackVal = 0.099f;
	final static float quarterTrackVal = 0.188f;
	final static float fullTrackSpeed1Val = 0.179f;
	final static float fullTrackSpeed2Val = 0.090f;
	final static float fullTrackSpeed3Val = 0.045f;
	final static float fullTrackSpeed4Val = 0.022f;
	final static float fullTrackSpeed5Val = 0.011f;
	final static float fullTrackSpeed6Val = 0.006f;
	final static float halfTrackSpeed1Val = 0.524f;
	final static float halfTrackSpeed2Val = 0.262f;
	final static float halfTrackSpeed3Val = 0.131f;
	final static float halfTrackSpeed4Val = 0.066f;
	final static float halfTrackSpeed5Val = 0.033f;
	final static float halfTrackSpeed6Val = 0.016f;
	final static float quarterTrackSpeed1Val = 1.000f;
	final static float quarterTrackSpeed2Val = 0.500f;
	final static float quarterTrackSpeed3Val = 0.250f;
	final static float quarterTrackSpeed4Val = 0.125f;
	final static float quarterTrackSpeed5Val = 0.062f;
	final static float quarterTrackSpeed6Val = 0.031f;
	final static float noTrackSpeed1Val = 0.524f;
	final static float noTrackSpeed2Val = 0.262f;
	final static float noTrackSpeed3Val = 0.131f;
	final static float noTrackSpeed4Val = 0.066f;
	final static float noTrackSpeed5Val = 0.033f;
	final static float noTrackSpeed6Val = 0.016f;
	
	/*other values*/
	final static float perYear = 0.005f;
	/*preservation values*/
	final static float orpMastersBoxVal = -0.75f;
	final static float orpMastersStickyBoxVal = -0.25f;
	final static float orpNonMasterBoxVal = -0.5f;
	final static float oraBoxVal = -0.25f;
	final static float DACBoxVal = -0.65f;
	final static float cassetteBoxVal = -0.35f;
	final static float DATBoxVal = -0.15f;
	final static float cdDataBoxVal = -0.4f;
	final static float cdAudioBoxVal = -0.25f;
	
	/*********** COLLECTION DATA VARIABLES ****************/
	//used to tell if current record needs saving before closing (not saved to database)
	public boolean isDirty = true;
	//base score for this format (not saved to database)
	public double base;
	//database ID for this record; NOTE: value will be -1 if record is a new record until it is saved
	public int databaseID;
	//total facet points (not including research value)
	public double runningTotal;
	//screen 1 data
	public String collectionNumber, collectionPart, collectionName, shelfNumber,
		worker, date, projectTitle, partOne, partTwo, generation;
	public int year;
	double yearPoints = 0;
	int yearDifference;
	//Screen 3 data
	public boolean orpMastersBox, orpMastersStickyBox, orpNonMasterBox, oraBox, 
		DACBox, cassetteBox, DATBox, cdDataBox, cdAudioBox;
	public boolean isPreserved;
	//Screen 4 data
	public boolean historyBox;
	public Vector modPoints = new Vector();
	//Screen 5 data
	public double researchValue;
	public String notes4_5;
	public final float historyBoxVal = 1;
	//for all screen 2s
	public String formatString;
	//for more than one screen 2
	public String explanationString = "";
	public boolean fungus, other, stereo, mono, unknownSound;
	public boolean fullTrack, halfTrack, quarterTrack, unknownTrack, 
		speed1, speed2, speed3, speed4, speed5, speed6, unknownSpeed;
	public boolean offBrand;
	//Screen 2 data -- WIRE
	public boolean preWWII, rust;
	//Screen 2 data -- disc-Lacquer
	public boolean glass, plastic, delamination;
	//SCREEN 2 DATA -- disc-aluminum
	public boolean oxidation;
	//SCREEN 2 DATA -- cassette
	public boolean minute, lubricant, typeIcassette, typeIIcassette,
		typeIIIcassette, typeIVcassette;
	//NOISE cassette
	public boolean dolbyScassette, dolbyCcassette, dolbyBcassette, dbxcassette;
	//Screen 2 data -- DAT
	public boolean thinTape, pre1993, portableDAT, dataGradeDAT, longPlayDAT;
	//Screen 2 data -- ORT acetate
	public boolean longPlayAcetate, doublePlayAcetate, triplePlayAcetate, standardAcetate, 
		vinegar, visibleMinorAcetate, visibleModerateAcetate, visibleSevereAcetate, unknownDoubleTripleAcetate;
	//	NOISE acetate
	public boolean dolbyAacetate, dolbyBacetate, dolbySRacetate, dbxAcetate;
	//Screen 2 data -- ORT polyester
	public boolean longPlayPoly, doublePlayPoly, triplePlayPoly, standardPoly,
		thirtyPoly, stickyPoly, lossPoly, visibleMinorPoly, visibleModeratePoly, unknownDoubleTriplePoly,
		visibleSeverePoly;	
	//	NOISE polyester
	public boolean dolbyApoly, dolbyBpoly, dolbySRpoly, dbxPoly;
	//Screen 2 data -- ORT paper
	public boolean longPlayPaper, doublePlayPaper, triplePlayPaper, standardPaper, 
		visibleMinorPaper, visibleModeratePaper, visibleSeverePaper;
	//Scree 2 data - ORT pvc
	public boolean longPlayPVC, doublePlayPVC, triplePlayPVC, unknownDoubleTriplePVC, standardPlayPVC, 
		lubricantPVC, visibleMinorPVC, visibleModeratePVC, visibleSeverePVC, stickyPVC, lossPVC;
	//	NOISE pvc
	public boolean dolbyAPVC, dolbyBPVC, dolbySRPVC, dbxPVC;
	
	/* Set the base format point total, based on the given format string. */
	private void setBaseAmount() {
		if (formatString.equals("Open reel tape-polyester")) {
			base = 2.5;
		}
		if (formatString.equals("Open reel tape-acetate")) {
			base = 3;
		}
		if (formatString.equals("Open reel tape-paper")) {
			base = 2.75;
		}
		if (formatString.equals("Open reel tape-pvc")) {
			base = 2.5;
		}
		if (formatString.equals("Cassette-analog, audio")) {
			base = 2.75;
		}
		if (formatString.equals("DAT (digital audio tape)")) {
			base = 4;
		}
		if (formatString.equals("Disc-lacquer")) {
			base = 4.25;
		}
		if (formatString.equals("Disc-aluminum")) {
			base = 3;
		}
		if (formatString.equals("Wire Recording")) {
			base = 2.75;
		}
	}
	
	public void clearFormatValues() {
		explanationString = "";
		portableDAT = false;
		dataGradeDAT = false;
		stereo = false;
		mono = false;
		unknownSound = false;
		speed1 = false;
		speed2 = false;
		speed3 = false;
		speed4 = false;
		speed5 = false;
		speed6 = false;
		unknownSpeed = false;			
		dolbyBacetate = false;
		dolbyAacetate = false;
		dolbySRacetate = false;
		dbxAcetate = false;
		fullTrack = false;
		halfTrack = false;
		quarterTrack = false;
		unknownTrack = false;
		dolbyApoly = false;
		dolbyBpoly = false;
		dolbySRpoly = false;
		dbxPoly = false;
		dolbyAPVC = false;
		dolbyBPVC = false;
		dolbySRPVC = false;
		dbxPVC = false;		
		stickyPVC = false;
		lossPVC = false;
		longPlayPVC = false;
		doublePlayPVC = false;
		triplePlayPVC = false;
		unknownDoubleTriplePVC = false;
		standardPlayPVC = false;
		lubricantPVC = false;
		visibleMinorPVC = false;
		visibleModeratePVC = false;
		visibleSeverePVC = false;
		oxidation = false;
		thinTape = false;
		pre1993 = false;
		longPlayDAT = false;
		glass = false;
		plastic = false;
		delamination = false;
		longPlayAcetate = false;
		doublePlayAcetate = false;
		triplePlayAcetate = false;
		unknownDoubleTripleAcetate = false;
		standardAcetate = false;
		vinegar = false;
		visibleMinorAcetate = false;
		visibleModerateAcetate = false;
		visibleSevereAcetate = false;
		longPlayPaper = false;
		doublePlayPaper = false;
		triplePlayPaper = false;
		standardPaper = false;
		visibleMinorPaper = false;
		visibleModeratePaper = false;
		visibleSeverePaper = false;
		longPlayPoly = false;
		doublePlayPoly = false;
		triplePlayPoly = false;
		unknownDoubleTriplePoly = false;
		standardPoly = false;
		thirtyPoly = false;
		stickyPoly = false;
		lossPoly = false;
		visibleMinorPoly = false;
		visibleModeratePoly = false;
		visibleSeverePoly = false;
		preWWII = false;
		rust = false;
		typeIcassette = false;
		typeIIcassette = false;
		typeIIIcassette = false;
		typeIVcassette = false;
		dolbyBcassette = false;
		dolbyCcassette = false;
		dolbyScassette = false;
		dbxcassette = false;
		minute = false;
		offBrand = false;
		lubricant = false;
		fungus = false;
		other = false;
	}
	
	/* This method re-generates the running total, and updates the text that appears in the right-hand side of each window except the last one. */
	public String updateScoreBox() {
		if (Main.window2 == null) {
			//user just started; nothing to show yet
			return "";
		}
		getRunningTotal();
		SimpleDateFormat sdf;
		sdf = new SimpleDateFormat("yyyy");
		Calendar cal;
		cal = Calendar.getInstance(TimeZone.getDefault());
		int currentYear = (new Integer(sdf.format(cal.getTime()))).intValue();
		
		setBaseAmount();
		
		if ((formatString.equals("Disc-lacquer")) || (formatString.equals("Disc-aluminum")) || (formatString.equals("Wire Recording"))) {
			yearPoints = 0;
		} else {
			if (year > 0) {
				yearDifference = currentYear - year;
				yearPoints = yearDifference * perYear;
			} else {
				yearPoints = 0;
			}
		}
		//running total with the respective base score
		DecimalFormat twoDigits = new DecimalFormat("0.000");
		String returnString = generation + "\n\nFormat base score: " + twoDigits.format(base) + "\n";
		if (year >0)
			returnString = returnString + "Year: " + year + "\n\n";
		else
			returnString = returnString + "\n";
		if (yearPoints > 0)
			returnString = returnString +  "(+ " + twoDigits.format(yearPoints) + ") " + yearDifference +  " years of life\n";
		else
			returnString = returnString + "\n";
		if (typeIcassette == true) {
			returnString = returnString + "(+ " + twoDigits.format(typeIcassetteVal) + ") Type I (Normal)\n";
		}
		if (typeIIcassette == true) {
			returnString = returnString + "(+ " + twoDigits.format(typeIIcassetteVal) + ") Type II (high bias: CrO2 and cobalt-doped)\n";
		}
		if (typeIIIcassette == true) {
			returnString = returnString + "(+ " + twoDigits.format(typeIIIcassetteVal) + ") Type III (ferric chrome)\n";
		}
		if (typeIVcassette == true) {
			returnString = returnString + "(+ " + twoDigits.format(typeIVcassetteVal) + ") Type IV (metal)\n";
		}
		if (stereo == true) {
			returnString = returnString + "(+ " + twoDigits.format(stereoVal) + ") Stereo\n";
		}
		if (mono == true) {
			returnString = returnString + "(+ " + twoDigits.format(monoVal) + ") Mono\n";
		}
		if (minute == true) {
			returnString = returnString + "(+ " + twoDigits.format(minuteVal) + ") 120 or 180 minute\n";
		}
		if (offBrand == true) {
			returnString = returnString + "(+ " + twoDigits.format(offBrandVal) + ") Off brand\n";
		}
		if (lubricant == true) {
			returnString = returnString + "(+ " + twoDigits.format(lubricantVal) + ") Soft binder syndrome-unidentified problems\n";
		}
		if (fungus == true) {
			returnString = returnString + "(+ " + twoDigits.format(fungusVal) + ") Fungus\n";
		}
		if (other == true) {
			returnString = returnString + "(+ " + twoDigits.format(otherVal) + ") Other\nExplanation: " + explanationString + "\n";
		}
		if (oxidation == true) {
			returnString = returnString + "(+ " + twoDigits.format(oxidationVal) + ") Oxidation\n";
		}
		if (thinTape == true) {
			returnString = returnString + "(+ " + twoDigits.format(tapeVal) + ") Thin tape\n";
		}
		if (pre1993 == true) {
			returnString = returnString + "(+ " + twoDigits.format(preVal) + ") 1993 or earlier\n";
		}
		if (portableDAT == true) {
			returnString = returnString + "(+ " + twoDigits.format(portableDATVal) + ") Recorded on portable\n";
		}
		if (dataGradeDAT == true) {
			returnString = returnString + "(+ " + twoDigits.format(dataGradeDATVal) + ") Data grade tape\n";
		}
		if (longPlayDAT == true) {
			returnString = returnString + "(+ " + twoDigits.format(longPlayDATVal) + ") Long-play, 32k, or 96k\n";
		}
		if (glass == true) {
			returnString = returnString + "(+ " + twoDigits.format(glassVal) + ") Glass base\n";
		}
		if (plastic == true) {
			returnString = returnString + "(+ " + twoDigits.format(plasticVal) + ") Plasticizer exudation\n";
		}
		if (delamination == true) {
			returnString = returnString + "(+ " + twoDigits.format(delamVal) + ") Delamination\n";
		}
		if (longPlayAcetate == true) {
			returnString = returnString + "(+ " + twoDigits.format(longPlayAcetateVal) + ") Long play (35 µm total or 1.0 mil base)\n";
		}
		if (doublePlayAcetate == true) {
			returnString = returnString + "(+ " + twoDigits.format(doublePlayAcetateVal) + ") Double play (26 µm total or 0.5 mil base)\n";
		}
		if (triplePlayAcetate == true) {
			returnString = returnString + "(+ " + twoDigits.format(triplePlayAcetateVal) + ") Triple play (18 µm total or 0.5 mil or thinner base)\n";
		}
		if (unknownDoubleTripleAcetate == true) {
			returnString = returnString + "(+ " + twoDigits.format(unknownDoubleTripleAcetateVal) + ") Unknown double/triple play\n";
		}
		if (standardAcetate == true) {
			returnString = returnString + "(+ " + twoDigits.format(standardAcetateVal) + ") Standard play (52 µm total or 1.5 mil base)\n";
		}
		if (vinegar == true) {
			returnString = returnString + "(+ " + twoDigits.format(vinegarVal) + ") Vinegar syndrome\n";
		}
		if (visibleMinorAcetate == true) {
			returnString = returnString + "(+ " + twoDigits.format(visibleMinorAcetateVal) + ")Tape pack problems-minor\n";
		}
		if (visibleModerateAcetate == true) {
			returnString = returnString + "(+ " + twoDigits.format(visibleModerateAcetateVal) + ")Tape pack problems-moderate\n";
		}
		if (visibleSevereAcetate == true) {
			returnString = returnString + "(+ " + twoDigits.format(visibleSevereAcetateVal) + ")Tape pack problems-severe\n";
		}
		if (standardPaper == true) {
			returnString = returnString + "(+ " + twoDigits.format(standardPaperVal) + ") Standard play (52 µm total or 1.5 mil base)\n";
		}
		if (longPlayPaper == true) {
			returnString = returnString + "(+ " + twoDigits.format(longPlayPaperVal) + ") Long play (35 µm total or 1.0 mil base)\n";
		}
		if (visibleMinorPaper == true) {
			returnString = returnString + "(+ " + twoDigits.format(visibleMinorPaperVal) + ")Tape pack problems-minor\n";
		}
		if (visibleModeratePaper == true) {
			returnString = returnString + "(+ " + twoDigits.format(visibleModeratePaperVal) + ")Tape pack problems-moderate\n";
		}
		if (visibleSeverePaper == true) {
			returnString = returnString + "(+ " + twoDigits.format(visibleSeverePaperVal) + ")Tape pack problems-severe\n";
		}
		if (longPlayPoly == true) {
			returnString = returnString + "(+ " + twoDigits.format(longPlayPolyVal) + ") Long play (35 µm total or 1.0 mil base)\n";
		}
		if (doublePlayPoly == true) {
			returnString = returnString + "(+ " + twoDigits.format(doublePlayPolyVal) + ") Double play (26 µm total or 0.5 mil base)\n";
		}
		if (triplePlayPoly == true) {
			returnString = returnString + "(+ " + twoDigits.format(triplePlayPolyVal) + ") Triple play (18 µm total or 0.5 mil or thinner base)\n";
		}
		if (unknownDoubleTriplePoly == true) {
			returnString = returnString + "(+ " + twoDigits.format(unknownDoubleTriplePolyVal) + ") Unknown double/triple play\n";
		}
		if (standardPoly == true) {
			returnString = returnString + "(+ " + twoDigits.format(standardPolyVal) + ") Standard play (52 µm total or 1.5 mil base)\n";
		}
		if (thirtyPoly == true) {
			returnString = returnString + "(+ " + twoDigits.format(thirtyPolyVal) + ") 30+ years old\n";
		}
		if (stickyPoly == true) {
			returnString = returnString + "(+ " + twoDigits.format(stickyPolyVal) + ") Soft binder syndrome-sticky shed syndrome\n";
		}
		if (lossPoly == true) {
			returnString = returnString + "(+ " + twoDigits.format(lossPolyVal) + ") Soft binder syndrome-unidentified problems\n";
		}
		if (visibleMinorPoly == true) {
			returnString = returnString + "(+ " + twoDigits.format(visibleMinorPolyVal) + ") Tape pack problems-minor\n";
		}
		if (visibleModeratePoly == true) {
			returnString = returnString + "(+ " + twoDigits.format(visibleModeratePolyVal) + ") Tape pack problems-moderate\n";
		}
		if (visibleSeverePoly == true) {
			returnString = returnString + "(+ " + twoDigits.format(visibleSeverePolyVal) + ") Tape Pack Problems-severe\n";
		}
		if (longPlayPVC == true) {
			returnString = returnString + "(+ " + twoDigits.format(longPlayPVCval) + ") Long play (35 µm total or 1.0 mil base)\n";
		}
		if (doublePlayPVC == true) {
			returnString = returnString + "(+ " + twoDigits.format(doublePlayPVCval) + ") Double play (26 µm total or 0.5 mil base)\n";
		}
		if (triplePlayPVC == true) {
			returnString = returnString + "(+ " + twoDigits.format(triplePlayPVCval) + ") Triple play (18 µm total or 0.5 mil or thinner base)\n";
		}
		if (unknownDoubleTriplePVC == true) {
			returnString = returnString + "(+ " + twoDigits.format(unknownDoubleTriplePVCval) + ") Unknown double/triple play\n";
		}
		if (standardPlayPVC == true) {
			returnString = returnString + "(+ " + twoDigits.format(standardPlayPVCval) + ") Standard play (52 µm total or 1.5 mil base)\n";
		}
		if (lossPVC == true) {
			returnString = returnString + "(+ " + twoDigits.format(lossPVCval) + ") Soft binder syndrome-unidentified problems\n";
		}
		if (stickyPVC == true) {
			returnString = returnString + "(+ " + twoDigits.format(stickyPVCval) + ") Soft binder syndrome-sticky shed syndrome\n";
		}
		if (visibleMinorPVC == true) {
			returnString = returnString + "(+ " + twoDigits.format(minorPVCval) + ") Visible tape pack problems-minor\n";
		}
		if (visibleModeratePVC == true) {
			returnString = returnString + "(+ " + twoDigits.format(moderatePVCval) + ") Visible tape pack problems-moderate\n";
		}
		if (visibleSeverePVC == true) {
			returnString = returnString + "(+ " + twoDigits.format(severePVCval) + ") Visible tape pack problems-severe\n";
		}
		if (preWWII == true) {
			returnString = returnString + "(+ " + twoDigits.format(preWWIIval) + ") Pre-WWII and/or armour brand\n";
		}
		if (rust == true) {
			returnString = returnString + "(+ " + twoDigits.format(rustVal) + ") Rust, oxidation or corrosion\n";
		}
		if(fullTrack == true && unknownSpeed == true){
			returnString = returnString + "(+ " + twoDigits.format(fullTrackVal) + ") Full track\n";
		}
		if(halfTrack == true && unknownSpeed == true){
			returnString = returnString + "(+ " + twoDigits.format(halfTrackVal) + ") Half track\n";
		}
		if(quarterTrack == true && unknownSpeed == true){
			returnString = returnString + "(+ " + twoDigits.format(quarterTrackVal) + ") Quarter track\n";
		}
		if(fullTrack == true && speed1 == true){
			returnString = returnString + "(+ " + twoDigits.format(fullTrackSpeed1Val) + ") Full track & 15/16 or 0.9375 ips (2.38 cm/s)\n";
		}
		if(fullTrack == true && speed2 == true){
			returnString = returnString + "(+ " + twoDigits.format(fullTrackSpeed2Val) + ") Full track & 1 7/8 or 1.875 ips (4.76 cm/s)\n";
		}
		if(fullTrack == true && speed3 == true){
			returnString = returnString + "(+ " + twoDigits.format(fullTrackSpeed3Val) + ") Full track & 3 3/4 or 3.75 ips (9.525 cm/s)\n";
		}
		if(fullTrack == true && speed4 == true){
			returnString = returnString + "(+ " + twoDigits.format(fullTrackSpeed4Val) + ") Full track & 7 1/2 or 7.5 ips (19.05 cm/s)\n";
		}
		if(fullTrack == true && speed5 == true){
			returnString = returnString + "(+ " + twoDigits.format(fullTrackSpeed5Val) + ") Full track & 15 ips (38.1 cm/s)\n";
		}
		if(fullTrack == true && speed6 == true){
			returnString = returnString + "(+ " + twoDigits.format(fullTrackSpeed6Val) + ") Full track & 30 ips (76.2 cm/s)\n";
		}
		if(halfTrack == true && speed1 == true){
			returnString = returnString + "(+ " + twoDigits.format(halfTrackSpeed1Val) + ") Half track & 15/16 or 0.9375 ips (2.38 cm/s)\n";
		}
		if(halfTrack == true && speed2 == true){
			returnString = returnString + "(+ " + twoDigits.format(halfTrackSpeed2Val) + ") Half track & 1 7/8 or 1.875 ips (4.76 cm/s)\n";
		}
		if(halfTrack == true && speed3 == true){
			returnString = returnString + "(+ " + twoDigits.format(halfTrackSpeed3Val) + ") Half track & 3 3/4 or 3.75 ips (9.525 cm/s)\n";
		}
		if(halfTrack == true && speed4 == true){
			returnString = returnString + "(+ " + twoDigits.format(halfTrackSpeed4Val) + ") Half track & 7 1/2 or 7.5 ips (19.05 cm/s)\n";
		}
		if(halfTrack == true && speed5 == true){
			returnString = returnString + "(+ " + twoDigits.format(halfTrackSpeed5Val) + ") Half track & 15 ips (38.1 cm/s)\n";
		}
		if(halfTrack == true && speed6 == true){
			returnString = returnString + "(+ " + twoDigits.format(halfTrackSpeed6Val) + ") Half track & 30 ips (76.2 cm/s)\n";
		}
		if(quarterTrack == true && speed1 == true){
			returnString = returnString + "(+ " + twoDigits.format(quarterTrackSpeed1Val) + ") Quarter track & 15/16 or 0.9375 ips (2.38 cm/s)\n";
		}
		if(quarterTrack == true && speed2 == true){
			returnString = returnString + "(+ " + twoDigits.format(quarterTrackSpeed2Val) + ") Quarter track & 1 7/8 or 1.875 ips (4.76 cm/s)\n";
		}
		if(quarterTrack == true && speed3 == true){
			returnString = returnString + "(+ " + twoDigits.format(quarterTrackSpeed3Val) + ") Quarter track & 3 3/4 or 3.75 ips (9.525 cm/s)\n";
		}
		if(quarterTrack == true && speed4 == true){
			returnString = returnString + "(+ " + twoDigits.format(quarterTrackSpeed4Val) + ") Quarter track & 7 1/2 or 7.5 ips (19.05 cm/s)\n";
		}
		if(quarterTrack == true && speed5 == true){
			returnString = returnString + "(+ " + twoDigits.format(quarterTrackSpeed5Val) + ") Quarter track & 15 ips (38.1 cm/s)\n";
		}
		if(quarterTrack == true && speed6 == true){
			returnString = returnString + "(+ " + twoDigits.format(quarterTrackSpeed6Val) + ") Quarter track & 30 ips (76.2 cm/s)\n";
		}
		if ((fullTrack == false) && (halfTrack == false) && (quarterTrack == false)) {
			if (speed1 == true) {
				returnString = returnString + "(+ " + twoDigits.format(noTrackSpeed1Val) + ") 15/16 or 0.9375 ips (2.38 cm/s)\n";
			}
			if (speed2 == true) {
				returnString = returnString + "(+ " + twoDigits.format(noTrackSpeed2Val) + ") 1 7/8 or 1.875 ips (4.76 cm/s)\n";
			}
			if (speed3 == true) {
				returnString = returnString + "(+ " + twoDigits.format(noTrackSpeed3Val) + ") 3 3/4 or 3.75 ips (9.525 cm/s)\n";
			}
			if (speed4 == true) {
				returnString = returnString + "(+ " + twoDigits.format(noTrackSpeed4Val) + ") 7 1/2 or 7.5 ips (19.05 cm/s)\n";
			}
			if (speed5 == true) {
				returnString = returnString + "(+ " + twoDigits.format(noTrackSpeed5Val) + ") 15 ips (38.1 cm/s)\n";
			}
			if (speed6 == true) {
				returnString = returnString + "(+ " + twoDigits.format(noTrackSpeed6Val) + ") 30 ips (76.2 cm/s)\n";
			}
		}
		
		///noise reduction
		if(dolbyApoly == true){
			returnString = returnString + "(+ " + twoDigits.format(dolbyApolyVal) + ") Dolby A noise reduction\n";
		}
		if(dolbyBpoly == true){
			returnString = returnString + "(+ " + twoDigits.format(dolbyBpolyVal) + ") Dolby B noise reduction\n";
		}
		if(dolbySRpoly == true){
			returnString = returnString + "(+ " + twoDigits.format(dolbySRpolyVal) + ") Dolby SR noise reduction\n";
		}
		if(dbxPoly == true){
			returnString = returnString + "(+ " + twoDigits.format(dbxPolyVal) + ") dbx noise reduction\n";
		}
		if(dolbyAacetate == true){
			returnString = returnString + "(+ " + twoDigits.format(dolbyAacetateVal) + ") Dolby A noise reduction\n";
		}
		if(dolbyBacetate == true){
			returnString = returnString + "(+ " + twoDigits.format(dolbyBacetateVal) + ") Dolby B noise reduction\n";
		}
		if(dolbySRacetate == true){
			returnString = returnString + "(+ " + twoDigits.format(dolbySRacetateVal) + ") Dolby SR noise reduction\n";
		}
		if(dbxAcetate == true){
			returnString = returnString + "(+ " + twoDigits.format(dbxAcetateVal) + ") dbx roise reduction\n";
		}
		if(dolbyAPVC == true){
			returnString = returnString + "(+ " + twoDigits.format(dolbyBpvcVal) + ") Dolby A noise reduction\n";
		}
		if(dolbyBPVC == true){
			returnString = returnString + "(+ " + twoDigits.format(dolbyBpvcVal) + ") Dolby B noise reduction\n";
		}
		if(dolbySRPVC == true){
			returnString = returnString + "(+ " + twoDigits.format(dolbySRpvcVal) + ") Dolby SR noise reduction\n";
		}
		if(dbxPVC == true){
			returnString = returnString + "(+ " + twoDigits.format(dbxPVCVal) + ") dbx noise reduction\n";
		}
		if(dolbyBcassette == true){
			returnString = returnString + "(+ " + twoDigits.format(dolbyBcassetteVal) + ") Dolby B noise reduction\n";
		}
		if(dolbyCcassette == true){
			returnString = returnString + "(+ " + twoDigits.format(dolbyCcassetteVal) + ") Dolby C noise reduction\n";
		}
		if(dolbyScassette == true){
			returnString = returnString + "(+ " + twoDigits.format(dolbyScassetteVal) + ") Dolby S noise reduction\n";
		}
		if(dbxcassette == true){
			returnString = returnString + "(+ " + twoDigits.format(dbxCassetteVal) + ") dbx noise reduction\n";
		}
		//////////////////// end noise
		if (orpMastersBox == true) {
			returnString = returnString + "( " + twoDigits.format(orpMastersBoxVal) + ") Open reel preservation " +
					"masters (non sticky shed)\n";
		}
		if (orpMastersStickyBox == true){
			returnString = returnString + "( " + twoDigits.format(orpMastersStickyBoxVal) + ") Open reel preservation " +
					"masters (sticky shed)\n";
		}
		if (orpNonMasterBox == true){
			returnString = returnString + "( " + twoDigits.format(orpNonMasterBoxVal) + ") Open reel, polyester, " +
					"non-preservation masters\n";
		}
		if (oraBox == true){
			returnString = returnString + "( " + twoDigits.format(oraBoxVal) + ") Open reel, acetate\n";
		}
		if (cassetteBox == true){
			returnString = returnString + "( " + twoDigits.format(cassetteBoxVal) + ") Cassette-analog, audio\n";
		}
		if (DATBox == true){
			returnString = returnString + "( " + twoDigits.format(DATBoxVal) + ") DAT (digital audio tape)\n";
		}
		if (cdDataBox == true){
			returnString = returnString + "( " + twoDigits.format(cdDataBoxVal) + ") CDs-data files\n";
		}
		if (cdAudioBox == true){
			returnString = returnString + "( " + twoDigits.format(cdAudioBoxVal) + ") CDs-audio\n";
		}
		if (DACBox == true){
			returnString = returnString + "( " + twoDigits.format(DACBoxVal) + ") Digital file (16/44.1)\n";
		}
		if(historyBox == true){
			returnString = returnString + "(+ " + twoDigits.format(historyBoxVal) + ") Storage history problems\n";
		}
		int counter = 0;
		while (counter < modPoints.size()) {
			ModData md = (ModData)modPoints.get(counter);
			double pointsAdded = md.pointsAdded;
			if(pointsAdded > 0){
				returnString = returnString + "(+ " + twoDigits.format(pointsAdded) + ") Points added\n" + 
				"Explanation: " + md.explanationText + "\n\n";
			}
			if(pointsAdded < 0){
				returnString = returnString + "( " + twoDigits.format(pointsAdded) + ") Points deducted\n" + 
				"Explanation: " + md.explanationText + "\n\n";
			}
			counter = counter + 1;
		}
		
		if(researchValue > 0){
			returnString = returnString + "\nResearch value score: " + twoDigits.format(researchValue) +
					"\nFACET & Research value combined: " + twoDigits.format(researchValue + runningTotal) + "\n";
		}
		
		if (isPreserved == true) {
			returnString = returnString + "\nPreservation work complete\n\n";
		}
		
		returnString = returnString + "FACET TOTAL: " + twoDigits.format(runningTotal) + "\n\n" +
				"Notes: \n" + notes4_5;
		return returnString;
	}
	
	/* This method re-generates the running total, and updates the text that appears on the left-hand side of the final window. */
	public String updateLastScreenLeft() {
		getRunningTotal();
		DecimalFormat twoDigits = new DecimalFormat("0.000");
		String returnString =  "<br><br>    <b>FACET POINTS:</b><br>Format base score: " + twoDigits.format(base) + "<br>";
		if (year > 0)
			returnString = returnString + "Year: " + year + "<br>";
		
		if (yearPoints > 0)
			returnString = returnString +  "(+ " + twoDigits.format(yearPoints) + ") " + yearDifference +  " years of life<br>";
		
		if (typeIcassette == true) {
			returnString = returnString + "(+ " + twoDigits.format(typeIcassetteVal) + ") Type I (normal)<br>";
		}
		if (typeIIcassette == true) {
			returnString = returnString + "(+ " + twoDigits.format(typeIIcassetteVal) + ") Type II (high bias: CrO2 and cobalt-doped)<br>";
		}
		if (typeIIIcassette == true) {
			returnString = returnString + "(+ " + twoDigits.format(typeIIIcassetteVal) + ") Type III (ferric chrome)<br>";
		}
		if (typeIVcassette == true) {
			returnString = returnString + "(+ " + twoDigits.format(typeIVcassetteVal) + ") Type IV (metal)<br>";
		}
		if (stereo == true) {
			returnString = returnString + "(+ " + twoDigits.format(stereoVal) + ") Stereo<br>";
		}
		if (mono == true) {
			returnString = returnString + "(+ " + twoDigits.format(monoVal) + ") Mono<br>";
		}
		if (minute == true) {
			returnString = returnString + "(+ " + twoDigits.format(minuteVal) + ") 120 or 180 minute<br>";
		}
		if (offBrand == true) {
			returnString = returnString + "(+ " + twoDigits.format(offBrandVal) + ") Off brand<br>";
		}
		if (lubricant == true) {
			returnString = returnString + "(+ " + twoDigits.format(lubricantVal) + ") Soft binder syndrome-unidentified problems<br>";
		}
		if (fungus == true) {
			returnString = returnString + "(+ " + twoDigits.format(fungusVal) + ") Fungus<br>";
		}
		if (other == true) {
			returnString = returnString + "(+ " + twoDigits.format(otherVal) + ") Other<br>Explanation: " + explanationString + "<br>";
		}
		if (oxidation == true) {
			returnString = returnString + "(+ " + twoDigits.format(oxidationVal) + ") Oxidation<br>";
		}
		if (thinTape == true) {
			returnString = returnString + "(+ " + twoDigits.format(tapeVal) + ") Thin tape<br>";
		}
		if (pre1993 == true) {
			returnString = returnString + "(+ " + twoDigits.format(preVal) + ") 1993 or earlier<br>";
		}
		if (portableDAT == true) {
			returnString = returnString + "(+ " + twoDigits.format(portableDATVal) + ") Recorded on portable<br>";
		}
		if (dataGradeDAT == true) {
			returnString = returnString + "(+ " + twoDigits.format(dataGradeDATVal) + ") Data grade tape<br>";
		}
		if (longPlayDAT == true) {
			returnString = returnString + "(+ " + twoDigits.format(longPlayDATVal) + ") Long-play, 32k, or 96k<br>";
		}
		if (glass == true) {
			returnString = returnString + "(+ " + twoDigits.format(glassVal) + ") Glass base<br>";
		}
		if (plastic == true) {
			returnString = returnString + "(+ " + twoDigits.format(plasticVal) + ") Plasticizer exudation<br>";
		}
		if (delamination == true) {
			returnString = returnString + "(+ " + twoDigits.format(delamVal) + ") Delamination<br>";
		}
		if (longPlayAcetate == true) {
			returnString = returnString + "(+ " + twoDigits.format(longPlayAcetateVal) + ") Long play (35 µm total or 1.0 mil base)<br>";
		}
		if (doublePlayAcetate == true) {
			returnString = returnString + "(+ " + twoDigits.format(doublePlayAcetateVal) + ") Double play (26 µm total or 0.5 mil base)<br>";
		}
		if (triplePlayAcetate == true) {
			returnString = returnString + "(+ " + twoDigits.format(triplePlayAcetateVal) + ") Triple play (18 µm total or 0.5 mil or thinner base)<br>";
		}
		if (unknownDoubleTripleAcetate == true) {
			returnString = returnString + "(+ " + twoDigits.format(unknownDoubleTripleAcetateVal) + ") Unknown double/triple play<br>";
		}
		if (standardAcetate == true) {
			returnString = returnString + "(+ " + twoDigits.format(standardAcetateVal) + ") Standard play (52 µm total or 1.5 mil base)<br>";
		}
		if (vinegar) {
			returnString = returnString + "(+ " + twoDigits.format(vinegarVal) + ") Vinegar syndrome<br>";
		}
		if (visibleMinorAcetate == true) {
			returnString = returnString + "(+ " + twoDigits.format(visibleMinorAcetateVal) + ")Tape pack problems-minor<br>";
		}
		if (visibleModerateAcetate == true) {
			returnString = returnString + "(+ " + twoDigits.format(visibleModerateAcetateVal) + ")Tape pack problems-moderate<br>";
		}
		if (visibleSevereAcetate == true) {
			returnString = returnString + "(+ " + twoDigits.format(visibleSevereAcetateVal) + ")Tape pack problems-severe<br>";
		}
		if (standardPaper == true) {
			returnString = returnString + "(+ " + twoDigits.format(standardPaperVal) + ") Standard play (52 µm total or 1.5 mil base)<br>";
		}
		if (longPlayPaper == true) {
			returnString = returnString + "(+ " + twoDigits.format(longPlayPaperVal) + ") Long play (35 µm total or 1.0 mil base)<br>";
		}
		if (visibleMinorPaper == true) {
			returnString = returnString + "(+ " + twoDigits.format(visibleMinorPaperVal) + ")Tape pack problems-minor<br>";
		}
		if (visibleModeratePaper == true) {
			returnString = returnString + "(+ " + twoDigits.format(visibleModeratePaperVal) + ")Tape pack problems-moderate<br>";
		}
		if (visibleSeverePaper == true) {
			returnString = returnString + "(+ " + twoDigits.format(visibleSeverePaperVal) + ")Tape pack problems-severe<br>";
		}
		if (longPlayPoly == true) {
			returnString = returnString + "(+ " + twoDigits.format(longPlayPolyVal) + ") Long play (35 µm total or 1.0 mil base)<br>";
		}
		if (doublePlayPoly == true) {
			returnString = returnString + "(+ " + twoDigits.format(doublePlayPolyVal) + ") Double play (26 µm total or 0.5 mil base)<br>";
		}
		if (triplePlayPoly == true) {
			returnString = returnString + "(+ " + twoDigits.format(triplePlayPolyVal) + ") Triple play (18 µm total or 0.5 mil or thinner base)<br>";
		}
		if (unknownDoubleTriplePoly == true) {
			returnString = returnString + "(+ " + twoDigits.format(unknownDoubleTriplePolyVal) + ") Unknown double/triple play<br>";
		}
		if (standardPoly == true) {
			returnString = returnString + "(+ " + twoDigits.format(standardPolyVal) + ") Standard play (52 µm total or 1.5 mil base)<br>";
		}
		if (thirtyPoly == true) {
			returnString = returnString + "(+ " + twoDigits.format(thirtyPolyVal) + ") 30+ years old<br>";
		}
		if (stickyPoly == true) {
			returnString = returnString + "(+ " + twoDigits.format(stickyPolyVal) + ") Soft binder syndrome-sticky shed syndrome<br>";
		}
		if (lossPoly == true) {
			returnString = returnString + "(+ " + twoDigits.format(lossPolyVal) + ") Soft binder syndrome-unidentified problems<br>";
		}
		if (visibleMinorPoly == true) {
			returnString = returnString + "(+ " + twoDigits.format(visibleMinorPolyVal) + ") Tape pack problems-minor<br>";
		}
		if (visibleModeratePoly == true) {
			returnString = returnString + "(+ " + twoDigits.format(visibleModeratePolyVal) + ") Tape pack problems-moderate<br>";
		}
		if (visibleSeverePoly == true) {
			returnString = returnString + "(+ " + twoDigits.format(visibleSeverePolyVal) + ") Tape pack problems-severe<br>";
		}
		if (longPlayPVC == true) {
			returnString = returnString + "(+ " + twoDigits.format(longPlayPVCval) + ") Long play (35 µm total or 1.0 mil base)<br>";
		}
		if (doublePlayPVC == true) {
			returnString = returnString + "(+ " + twoDigits.format(doublePlayPVCval) + ") Double play (26 µm total or 0.5 mil base)<br>";
		}
		if (triplePlayPVC == true) {
			returnString = returnString + "(+ " + twoDigits.format(triplePlayPVCval) + ") Triple play (18 µm total or 0.5 mil or thinner base)<br>";
		}
		if (standardPlayPVC == true) {
			returnString = returnString + "(+ " + twoDigits.format(standardPlayPVCval) + ") Standard play (52 µm total or 1.5 mil base)<br>";
		}
		if (lossPVC == true) {
			returnString = returnString + "(+ " + twoDigits.format(lossPVCval) + ") Soft binder syndrome-unidentified problems<br>";
		}
		if (stickyPVC == true) {
			returnString = returnString + "(+ " + twoDigits.format(stickyPVCval) + ") Soft binder syndrome-sticky shed syndrome<br>";
		}
		if (visibleMinorPVC == true) {
			returnString = returnString + "(+ " + twoDigits.format(minorPVCval) + ") Visible tape pack problems-minor<br>";
		}
		if (visibleModeratePVC == true) {
			returnString = returnString + "(+ " + twoDigits.format(moderatePVCval) + ") Visible tape pack problems-moderate<br>";
		}
		if (visibleSeverePVC == true) {
			returnString = returnString + "(+ " + twoDigits.format(severePVCval) + ") Visible tape pack problems-severe<br>";
		}		
		if (preWWII == true) {
			returnString = returnString + "(+ " + twoDigits.format(preWWIIval) + ") Pre-WWII and/or armour brand<br>";
		}
		if (rust == true) {
			returnString = returnString + "(+ " + twoDigits.format(rustVal) + ") Rust, oxidation or corrosion<br>";
		}
		////////////////////////////////////////tracks
		if(fullTrack == true && unknownSpeed == true){
			returnString = returnString + "(+ " + twoDigits.format(fullTrackVal) + ") Full track<br>";
		}
		if(halfTrack == true && unknownSpeed == true){
			returnString = returnString + "(+ " + twoDigits.format(halfTrackVal) + ") Half track<br>";
		}
		if(quarterTrack == true && unknownSpeed == true){
			returnString = returnString + "(+ " + twoDigits.format(quarterTrackVal) + ") Quarter track<br>";
		}
		if(fullTrack == true && speed1 == true){
			returnString = returnString + "(+ " + twoDigits.format(fullTrackSpeed1Val) + ") Full track & 15/16 or 0.9375 ips (2.38 cm/s)<br>";
		}
		if(fullTrack == true && speed2 == true){
			returnString = returnString + "(+ " + twoDigits.format(fullTrackSpeed2Val) + ") Full track & 1 7/8 or 1.875 ips (4.76 cm/s)<br>";
		}
		if(fullTrack == true && speed3 == true){
			returnString = returnString + "(+ " + twoDigits.format(fullTrackSpeed3Val) + ") Full track & 3 3/4 or 3.75 ips (9.525 cm/s)<br>";
		}
		if(fullTrack == true && speed4 == true){
			returnString = returnString + "(+ " + twoDigits.format(fullTrackSpeed4Val) + ") Full track & 7 1/2 or 7.5 ips (19.05 cm/s)<br>";
		}
		if(fullTrack == true && speed5 == true){
			returnString = returnString + "(+ " + twoDigits.format(fullTrackSpeed5Val) + ") Full track & 15 ips (38.1 cm/s)<br>";
		}
		if(fullTrack == true && speed6 == true){
			returnString = returnString + "(+ " + twoDigits.format(fullTrackSpeed6Val) + ") Full track & 30 ips (76.2 cm/s)<br>";
		}
		if(halfTrack == true && speed1 == true){
			returnString = returnString + "(+ " + twoDigits.format(halfTrackSpeed1Val) + ") Half track & 15/16 or 0.9375 ips (2.38 cm/s)<br>";
		}
		if(halfTrack == true && speed2 == true){
			returnString = returnString + "(+ " + twoDigits.format(halfTrackSpeed2Val) + ") Half track & 1 7/8 or 1.875 ips (4.76 cm/s)<br>";
		}
		if(halfTrack == true && speed3 == true){
			returnString = returnString + "(+ " + twoDigits.format(halfTrackSpeed3Val) + ") Half track & 3 3/4 or 3.75 ips (9.525 cm/s)<br>";
		}
		if(halfTrack == true && speed4 == true){
			returnString = returnString + "(+ " + twoDigits.format(halfTrackSpeed4Val) + ") Half track & 7 1/2 or 7.5 ips (19.05 cm/s)<br>";
		}
		if(halfTrack == true && speed5 == true){
			returnString = returnString + "(+ " + twoDigits.format(halfTrackSpeed5Val) + ") Half track & 15 ips (38.1 cm/s)<br>";
		}
		if(halfTrack == true && speed6 == true){
			returnString = returnString + "(+ " + twoDigits.format(halfTrackSpeed6Val) + ") Half track & 30 ips (76.2 cm/s)<br>";
		}
		if(quarterTrack == true && speed1 == true){
			returnString = returnString + "(+ " + twoDigits.format(quarterTrackSpeed1Val) + ") Quarter track & 15/16 or 0.9375 ips (2.38 cm/s)<br>";
		}
		if(quarterTrack == true && speed2 == true){
			returnString = returnString + "(+ " + twoDigits.format(quarterTrackSpeed2Val) + ") Quarter track & 1 7/8 or 1.875 ips (4.76 cm/s)<br>";
		}
		if(quarterTrack == true && speed3 == true){
			returnString = returnString + "(+ " + twoDigits.format(quarterTrackSpeed3Val) + ") Quarter track & 3 3/4 or 3.75 ips (9.525 cm/s)<br>";
		}
		if(quarterTrack == true && speed4 == true){
			returnString = returnString + "(+ " + twoDigits.format(quarterTrackSpeed4Val) + ") Quarter track & 7 1/2 or 7.5 ips (19.05 cm/s)<br>";
		}
		if(quarterTrack == true && speed5 == true){
			returnString = returnString + "(+ " + twoDigits.format(quarterTrackSpeed5Val) + ") Quarter track & 15 ips (38.1 cm/s)<br>";
		}
		if(quarterTrack == true && speed6 == true){
			returnString = returnString + "(+ " + twoDigits.format(quarterTrackSpeed6Val) + ") Quarter track & 30 ips (76.2 cm/s)<br>";
		}
		
		if ((fullTrack == false) && (halfTrack == false) && (quarterTrack == false)) {
			if (speed1 == true) {
				returnString = returnString + "(+ " + twoDigits.format(noTrackSpeed1Val) + ") 15/16 or 0.9375 ips (2.38 cm/s)<br>";
			}
			if (speed2 == true) {
				returnString = returnString + "(+ " + twoDigits.format(noTrackSpeed2Val) + ") 1 7/8 or 1.875 ips (4.76 cm/s)<br>";
			}
			if (speed3 == true) {
				returnString = returnString + "(+ " + twoDigits.format(noTrackSpeed3Val) + ") 3 3/4 or 3.75 ips (9.525 cm/s)<br>";
			}
			if (speed4 == true) {
				returnString = returnString + "(+ " + twoDigits.format(noTrackSpeed4Val) + ") 7 1/2 or 7.5 ips (19.05 cm/s)<br>";
			}
			if (speed5 == true) {
				returnString = returnString + "(+ " + twoDigits.format(noTrackSpeed5Val) + ") 15 ips (38.1 cm/s)<br>";
			}
			if (speed6 == true) {
				returnString = returnString + "(+ " + twoDigits.format(noTrackSpeed6Val) + ") 30 ips (76.2 cm/s)<br>";
			}
		}
		///noise reduction
		if(dolbyApoly == true){
			returnString = returnString + "(+ " + twoDigits.format(dolbyApolyVal) + ") Dolby A noise reduction<br>";
		}
		if(dolbyBpoly == true){
			returnString = returnString + "(+ " + twoDigits.format(dolbyBpolyVal) + ") Dolby B noise reduction<br>";
		}
		if(dolbySRpoly == true){
			returnString = returnString + "(+ " + twoDigits.format(dolbySRpolyVal) + ") Dolby SR noise reduction<br>";
		}
		if(dbxPoly == true){
			returnString = returnString + "(+ " + twoDigits.format(dbxPolyVal) + ") dbx noise reduction<br>";
		}
		if(dolbyAacetate == true){
			returnString = returnString + "(+ " + twoDigits.format(dolbyAacetateVal) + ") Dolby A noise reduction<br>";
		}
		if(dolbyBacetate == true){
			returnString = returnString + "(+ " + twoDigits.format(dolbyBacetateVal) + ") Dolby B noise reduction<br>";
		}
		if(dolbySRacetate == true){
			returnString = returnString + "(+ " + twoDigits.format(dolbySRacetateVal) + ") Dolby SR noise reduction<br>";
		}
		if(dbxAcetate == true){
			returnString = returnString + "(+ " + twoDigits.format(dbxAcetateVal) + ") dbx noise reduction<br>";
		}
		if(dolbyAPVC == true){
			returnString = returnString + "(+ " + twoDigits.format(dolbyBpvcVal) + ") Dolby A noise reduction<br>";
		}
		if(dolbyBPVC == true){
			returnString = returnString + "(+ " + twoDigits.format(dolbyBpvcVal) + ") Dolby B noise reduction<br>";
		}
		if(dolbySRPVC == true){
			returnString = returnString + "(+ " + twoDigits.format(dolbySRpvcVal) + ") Dolby SR noise reduction<br>";
		}
		if(dbxPVC == true){
			returnString = returnString + "(+ " + twoDigits.format(dbxPVCVal) + ") dbx noise reduction<br>";
		}
		if(dolbyBcassette == true){
			returnString = returnString + "(+ " + twoDigits.format(dolbyBcassetteVal) + ") Dolby B noise reduction<br>";
		}
		if(dolbyCcassette == true){
			returnString = returnString + "(+ " + twoDigits.format(dolbyCcassetteVal) + ") Dolby C noise reduction<br>";
		}
		if(dolbyScassette == true){
			returnString = returnString + "(+ " + twoDigits.format(dolbyScassetteVal) + ") Dolby S noise reduction<br>";
		}
		if(dbxcassette == true){
			returnString = returnString + "(+ " + twoDigits.format(dbxCassetteVal) + ") dbx noise reduction<br>";
		}
		///////////////// end noise
		if (orpMastersBox == true) {
			returnString = returnString + "( " + twoDigits.format(orpMastersBoxVal) + ") Open reel preservation " +
					"Masters (non Sticky Shed)<br>";
		}
		if (orpMastersStickyBox == true){
			returnString = returnString + "( " + twoDigits.format(orpMastersStickyBoxVal) + ") Open reel preservation " +
					"Masters (Sticky Shed)<br>";
		}
		if (orpNonMasterBox == true){
			returnString = returnString + "( " + twoDigits.format(orpNonMasterBoxVal) + ") Open reel, polyester, " +
					"Non-Preservation Masters<br>";
		}
		if (oraBox == true){
			returnString = returnString + "( " + twoDigits.format(oraBoxVal) + ") Open reel, acetate<br>";
		}
		if (cassetteBox == true){
			returnString = returnString + "( " + twoDigits.format(cassetteBoxVal) + ") Cassette-analog, audio<br>";
		}
		if (DATBox == true){
			returnString = returnString + "( " + twoDigits.format(DATBoxVal) + ") DAT (digital audio tape)<br>";
		}
		if (cdDataBox == true){
			returnString = returnString + "( " + twoDigits.format(cdDataBoxVal) + ") CDs-data files<br>";
		}
		if (cdAudioBox == true){
			returnString = returnString + "( " + twoDigits.format(cdAudioBoxVal) + ") CDs-audio<br>";
		}
		if (DACBox == true){
			returnString = returnString + "( " + twoDigits.format(DACBoxVal) + ") Digital file (16/44.1)<br>";
		}
		if(historyBox == true){
			returnString = returnString + "(+ " + twoDigits.format(historyBoxVal) + ") Storage history problems<br>";
		}
		
		
		int counter = 0;
		while (counter < modPoints.size()) {
			ModData md = (ModData)modPoints.get(counter);
			double pointsAdded = md.pointsAdded;
			if(pointsAdded > 0){
				returnString = returnString + "(+ " + twoDigits.format(pointsAdded) + ") Points added<br>" + 
				"Explanation: " + md.explanationText + "<br><br>";;
			}
			if(pointsAdded < 0){
				returnString = returnString + "( " + twoDigits.format(pointsAdded) + ") Points deducted<br>" + 
				"Explanation: " + md.explanationText + "<br><br>";;
			}
			counter = counter + 1;
		}
		
		if (!notes4_5.equals("")) {
			returnString = returnString + "<br>    <b>NOTES:</b> <br>" + notes4_5 + "</font></html>";
		}
		
		String firstPart = "<html><font face=\"Arial\" size=\"3\">    <b>ADMINISTRATIVE DATA:</b>";
		if (!(collectionNumber.equals(""))) {
			firstPart = firstPart + "<br>Collection primary identifier:  " + collectionNumber;
		}
		if (!(collectionPart.equals(""))) {
			firstPart = firstPart + "<br>Part name:  " + collectionPart;
		}
		if (!(partOne.equals(""))) {
			firstPart = firstPart + "<br>Part " + partOne + "  of " + partTwo;
		}
		if (!(collectionName.equals(""))) {
			firstPart = firstPart + "<br>Collection name:  " + collectionName;
		}
		if (!(shelfNumber.equals(""))) {
			firstPart = firstPart + "<br>Shelf number(s):  " + shelfNumber;
		}
		if (!(formatString.equals(""))) {
			firstPart = firstPart + "<br>Format:  " + formatString;
		}
		if (!(generation.equals(""))) {
			firstPart = firstPart + "<br>Generation:  " + generation;
		}
		if (!(worker.equals(""))) {
			firstPart = firstPart + "<br>Worker:  " + worker;
		}
		if (!(date.equals(""))) {
			firstPart = firstPart + "<br>Date:  " + date;
		}
		if (!(projectTitle.equals(""))) {
			firstPart = firstPart + "<br>Project title:  " + projectTitle;
		}
		
		
		
		return firstPart + returnString;
	}

	/* This method re-generates the running total. */
	public void getRunningTotal() {
		setBaseAmount();
		SimpleDateFormat sdf;
		sdf = new SimpleDateFormat("yyyy");
		Calendar cal;
		cal = Calendar.getInstance(TimeZone.getDefault());
		int currentYear = (new Integer(sdf.format(cal.getTime()))).intValue();
		
		if ((formatString.equals("Disc-lacquer")) || (formatString.equals("Disc-aluminum")) || (formatString.equals("Wire Recording"))) {
			yearPoints = 0;
		} else {
			if (year > 0) {
				yearDifference = currentYear - year;
				yearPoints = yearDifference * perYear;
			} else {
				yearPoints = 0;
			}
		}
	
		runningTotal = base + yearPoints;
		if (typeIcassette == true) {
			runningTotal = runningTotal + typeIcassetteVal;
		}
		if (typeIIcassette == true) {
			runningTotal = runningTotal + typeIIcassetteVal;
		}
		if (typeIIIcassette == true) {
			runningTotal = runningTotal + typeIIIcassetteVal;
		}
		if (typeIVcassette == true) {
			runningTotal = runningTotal + typeIVcassetteVal;
		}
		if (stereo == true) {
			runningTotal = runningTotal + stereoVal;
		}
		if (mono == true) {
			runningTotal = runningTotal + monoVal;
		}
		if (minute == true) {
			runningTotal = runningTotal + minuteVal;
		}
		if (offBrand == true) {
			runningTotal = runningTotal + offBrandVal;
		}
		if (lubricant == true) {
			runningTotal = runningTotal + lubricantVal;
		}
		if (fungus == true) {
			runningTotal = runningTotal + fungusVal;
		}
		if (other == true) {
			runningTotal = runningTotal + otherVal;
		}
		if (oxidation == true) {
			runningTotal = runningTotal + oxidationVal;
		}
		if (thinTape == true) {
			runningTotal = runningTotal + tapeVal;
		}
		if (pre1993 == true) {
			runningTotal = runningTotal + preVal;
		}
		if (portableDAT == true) {
			runningTotal = runningTotal + portableDATVal;
		}
		if (dataGradeDAT == true) {
			runningTotal = runningTotal + dataGradeDATVal;
		}
		if (longPlayDAT == true) {
			runningTotal = runningTotal + longPlayDATVal;
		}
		if (glass == true) {
			runningTotal = runningTotal + glassVal;
		}
		if (plastic == true) {
			runningTotal = runningTotal + plasticVal;
		}
		if (delamination == true) {
			runningTotal = runningTotal + delamVal;
		}
		if (longPlayAcetate == true) {
			runningTotal = runningTotal + longPlayAcetateVal;
		}
		if (doublePlayAcetate == true) {
			runningTotal = runningTotal + doublePlayAcetateVal;
		}
		if (triplePlayAcetate == true) {
			runningTotal = runningTotal + triplePlayAcetateVal;
		}
		if (unknownDoubleTripleAcetate == true) {
			runningTotal = runningTotal + unknownDoubleTripleAcetateVal;
		}
		if (standardAcetate == true) {
			runningTotal = runningTotal + standardAcetateVal;
		}
		if (vinegar) {
			runningTotal = runningTotal + vinegarVal;
		}
		if (visibleMinorAcetate == true) {
			runningTotal = runningTotal + visibleMinorAcetateVal;
		}
		if (visibleModerateAcetate == true) {
			runningTotal = runningTotal + visibleModerateAcetateVal;
		}
		if (visibleSevereAcetate == true) {
			runningTotal = runningTotal + visibleSevereAcetateVal;
		}
		if (standardPaper == true) {
			runningTotal = runningTotal + standardPaperVal;
		}
		if (longPlayPaper == true) {
			runningTotal = runningTotal + longPlayPaperVal;
		}
		if (visibleMinorPaper == true) {
			runningTotal = runningTotal + visibleMinorPaperVal;
		}
		if (visibleModeratePaper == true) {
			runningTotal = runningTotal + visibleModeratePaperVal;
		}
		if (visibleSeverePaper == true) {
			runningTotal = runningTotal + visibleSeverePaperVal;
		}
		if (longPlayPoly == true) {
			runningTotal = runningTotal + longPlayPolyVal;
		}
		if (doublePlayPoly == true) {
			runningTotal = runningTotal + doublePlayPolyVal;
		}
		if (triplePlayPoly == true) {
			runningTotal = runningTotal + triplePlayPolyVal;
		}
		if (unknownDoubleTriplePoly == true) {
			runningTotal = runningTotal + unknownDoubleTriplePolyVal;
		}
		if (standardPoly == true) {
			runningTotal = runningTotal + standardPolyVal;
		}
		if (thirtyPoly == true) {
			runningTotal = runningTotal + thirtyPolyVal;
		}
		if (stickyPoly == true) {
			runningTotal = runningTotal + stickyPolyVal;
		}
		if (lossPoly == true) {
			runningTotal = runningTotal + lossPolyVal;
		}
		if (visibleMinorPoly == true) {
			runningTotal = runningTotal + visibleMinorPolyVal;
		}
		if (visibleModeratePoly == true) {
			runningTotal = runningTotal + visibleModeratePolyVal;
		}
		if (visibleSeverePoly == true) {
			runningTotal = runningTotal + visibleSeverePolyVal;
		}
		if (longPlayPVC == true) {
			runningTotal = runningTotal + longPlayPVCval;
		}
		if (doublePlayPVC == true) {
			runningTotal = runningTotal + doublePlayPVCval;
		}
		if (triplePlayPVC == true) {
			runningTotal = runningTotal + triplePlayPVCval;
		}
		if (standardPlayPVC == true) {
			runningTotal = runningTotal + standardPlayPVCval;
		}
		if (lossPVC == true) {
			runningTotal = runningTotal + lossPVCval;
		}
		if (stickyPVC == true) {
			runningTotal = runningTotal + stickyPVCval;
		}
		if (visibleMinorPVC == true) {
			runningTotal = runningTotal + minorPVCval;
		}
		if (visibleModeratePVC == true) {
			runningTotal = runningTotal + moderatePVCval;
		}
		if (visibleSeverePVC == true) {
			runningTotal = runningTotal + severePVCval;
		}		
		if (preWWII == true) {
			runningTotal = runningTotal + preWWIIval;
		}
		if (rust == true) {
			runningTotal = runningTotal + rustVal;
		}
		if(fullTrack == true && unknownSpeed == true){
			runningTotal = runningTotal + fullTrackVal;
		}
		if(halfTrack == true && unknownSpeed == true){
			runningTotal = runningTotal + halfTrackVal;
		}
		if(quarterTrack == true && unknownSpeed == true){
			runningTotal = runningTotal + quarterTrackVal;
		}
		if(fullTrack == true && speed1 == true){
			runningTotal = runningTotal + fullTrackSpeed1Val;
		}
		if(fullTrack == true && speed2 == true){
			runningTotal = runningTotal + fullTrackSpeed2Val;
		}
		if(fullTrack == true && speed3 == true){
			runningTotal = runningTotal + fullTrackSpeed3Val;
		}
		if(fullTrack == true && speed4 == true){
			runningTotal = runningTotal + fullTrackSpeed4Val;
		}
		if(fullTrack == true && speed5 == true){
			runningTotal = runningTotal + fullTrackSpeed5Val;
		}
		if(fullTrack == true && speed6 == true){
			runningTotal = runningTotal + fullTrackSpeed6Val;
		}
		if(halfTrack == true && speed1 == true){
			runningTotal = runningTotal + halfTrackSpeed1Val;
		}
		if(halfTrack == true && speed2 == true){
			runningTotal = runningTotal + halfTrackSpeed2Val;
		}
		if(halfTrack == true && speed3 == true){
			runningTotal = runningTotal + halfTrackSpeed3Val;
		}
		if(halfTrack == true && speed4 == true){
			runningTotal = runningTotal + halfTrackSpeed4Val;
		}
		if(halfTrack == true && speed5 == true){
			runningTotal = runningTotal + halfTrackSpeed5Val;
		}
		if(halfTrack == true && speed6 == true){
			runningTotal = runningTotal + halfTrackSpeed6Val;
		}
		if(quarterTrack== true && speed1 == true){
			runningTotal = runningTotal + quarterTrackSpeed1Val;
		}
		if(quarterTrack == true && speed2 == true){
			runningTotal = runningTotal + quarterTrackSpeed2Val;
		}
		if(quarterTrack == true && speed3 == true){
			runningTotal = runningTotal + quarterTrackSpeed3Val;
		}
		if(quarterTrack == true && speed4 == true){
			runningTotal = runningTotal + quarterTrackSpeed4Val;
		}
		if(quarterTrack == true && speed5 == true){
			runningTotal = runningTotal + quarterTrackSpeed5Val;
		}
		if(quarterTrack == true && speed6 == true){
			runningTotal = runningTotal + quarterTrackSpeed6Val;
		}
		if ((fullTrack == false) && (halfTrack == false) && (quarterTrack == false)) {
			if (speed1 == true) {
				runningTotal = runningTotal + noTrackSpeed1Val;
			}
			if (speed2 == true) {
				runningTotal = runningTotal + noTrackSpeed2Val;
			}
			if (speed3 == true) {
				runningTotal = runningTotal + noTrackSpeed3Val;
			}
			if (speed4 == true) {
				runningTotal = runningTotal + noTrackSpeed4Val;
			}
			if (speed5 == true) {
				runningTotal = runningTotal + noTrackSpeed5Val;
			}
			if (speed6 == true) {
				runningTotal = runningTotal + noTrackSpeed6Val;
			}
		}
		///noise reduction
		if(dolbyApoly == true){
			runningTotal = runningTotal + dolbyApolyVal;
		}
		if(dolbyBpoly == true){
			runningTotal = runningTotal + dolbyBpolyVal;
		}
		if(dolbySRpoly == true){
			runningTotal = runningTotal + dolbySRpolyVal;
		}
		if(dbxPoly == true){
			runningTotal = runningTotal + dbxPolyVal;
		}
		if(dolbyAacetate == true){
			runningTotal = runningTotal + dolbyAacetateVal;
		}
		if(dolbyBacetate == true){
			runningTotal = runningTotal + dolbyBacetateVal;
		}
		if(dolbySRacetate == true){
			runningTotal = runningTotal + dolbySRacetateVal;
		}
		if(dbxAcetate == true){
			runningTotal = runningTotal + dbxAcetateVal;
		}
		if(dolbyAPVC == true){
			runningTotal = runningTotal + dolbyApvcVal;
		}
		if(dolbyBPVC == true){
			runningTotal = runningTotal + dolbyBpvcVal;
		}
		if(dolbySRPVC == true){
			runningTotal = runningTotal + dolbySRpvcVal;
		}
		if(dbxPVC == true){
			runningTotal = runningTotal + dbxPVCVal;
		}
		if(dolbyBcassette == true){
			runningTotal = runningTotal + dolbyBcassetteVal;
		}
		if(dolbyCcassette == true){
			runningTotal = runningTotal + dolbyCcassetteVal;
		}
		if(dolbyScassette == true){
			runningTotal = runningTotal + dolbyScassetteVal;
		}
		if(dbxcassette == true){
			runningTotal = runningTotal + dbxCassetteVal;
		}
		///////////////// end noise
		if (orpMastersBox == true) {
			runningTotal = runningTotal + orpMastersBoxVal;
		}
		if (orpMastersStickyBox == true){
			runningTotal = runningTotal + orpMastersStickyBoxVal;
		}
		if (orpNonMasterBox == true){
			runningTotal = runningTotal + orpNonMasterBoxVal;
		}
		if (oraBox == true){
			runningTotal = runningTotal + oraBoxVal;
		}
		if (cassetteBox == true){
			runningTotal = runningTotal + cassetteBoxVal;
		}
		if (DATBox == true){
			runningTotal = runningTotal + DATBoxVal;
		}
		if (cdDataBox == true){
			runningTotal = runningTotal + cdDataBoxVal;
		}
		if (cdAudioBox == true){
			runningTotal = runningTotal + cdAudioBoxVal;
		}
		if (DACBox == true){
			runningTotal = runningTotal + DACBoxVal;
		}
		if(historyBox == true){
			runningTotal = runningTotal + historyBoxVal;
		}
		int counter = 0;
		while (counter < modPoints.size()) {
			ModData md = (ModData)modPoints.get(counter);
			double pointsAdded = md.pointsAdded;
			if(pointsAdded > 0){
				runningTotal = runningTotal + pointsAdded;
			}
			if(pointsAdded < 0){
				runningTotal = runningTotal + pointsAdded;
			}
			counter = counter + 1;
		}		
	}
	
	/* This method re-generates the running total, and updates the text that appears on the right-hand side of the final window. */
	public String updateLastScreenRight() {
		getRunningTotal();
		DecimalFormat twoDigits = new DecimalFormat("0.000");
		String returnString = "<html><font face=\"Arial\" size=\"3\">    <b>COLLECTION SCORES:</b><br>";
		
		returnString = returnString + "FACET Score: " + twoDigits.format(runningTotal);
		
		if(researchValue > 0){
			returnString = returnString + "<br>Research Value Score: " + twoDigits.format(researchValue) + 
					"<br>Combined Score: " + twoDigits.format(researchValue + runningTotal);
		}
		
		returnString = returnString + "<br><br>    <b>RISK ASSESSMENT:</b><br>";
		
		if (isPreserved == true) {
			returnString = returnString + "Preservation work has been completed for this collection.<br><br>";
		}
		
		if (runningTotal < 1.99) 
		{
			returnString = returnString + "This collection is in very good shape and there is little or no risk to its content at the present time.<br><br>" +
					"There are no compelling reasons relating to preservation condition to take preservation action with this collection.";
		}
		if (runningTotal >= 2 && runningTotal < 2.99) //OK
		{
			returnString = returnString + "This collection is in good shape but there is a small risk to its content at the present time.<br><br>" +
					"There are few compelling reasons to take preservation action with this collection. The collection must have multiple important" +
					" outside factors present (such as potential or actual use or very high research value) to justify preservation action.";
		}
		if (runningTotal >= 3 && runningTotal < 3.99) //OK
		{
			returnString = returnString + "This collection is in decent shape but its content is at some risk.<br><br>" +
					"This collection is at some risk and could be a candidate for preservation action depending on " +
					"other priorities as well as outside factors such as potential use or research value.";
		}
		if (runningTotal >= 4 && runningTotal < 4.99) //OK
		{
			returnString = returnString + "This collection is in deteriorating or poor shape and/or is carried on a format that is nearly " +
					"or completely obsolete. Its content is at moderate to severe risk.<br><br>" +
					"This collection is at moderate to severe risk and is a solid candidate for preservation action.";
		}
		if (runningTotal >= 5)
		{
			returnString = returnString + "This collection is in very poor shape or is rapidly deteriorating, has extensive damage " +
					"and/or significant deteriorative forces at work. Its content is at serious risk and requires " +
					"attention soon.<br><br>" +
					"This collection is in serious trouble and is a prime candidate for preservation action. If the " +
					"content of the collection is to survive with the highest quality possible, preservation action must " +
					"be taken soon.";
		}
		returnString = returnString + "</font></html>";
		
		return returnString;
	}
	
	public boolean saveRecord() {
		try {
			boolean test = DB.saveRecord(this);
			return test;
		} catch (Exception err) {
			err.printStackTrace();
			if (err.getMessage() != null) {
				javax.swing.JOptionPane.showMessageDialog(null, "Error connecting to database\n" + err.getMessage(), "Database error", javax.swing.JOptionPane.ERROR_MESSAGE);
			} else {
				javax.swing.JOptionPane.showMessageDialog(null, "Error connecting to database", "Database error", javax.swing.JOptionPane.ERROR_MESSAGE);
			}
			return false;
		}
	}
}
