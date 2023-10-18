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

package edu.indiana.dlib.sounddirections.facet.util;

import java.math.BigDecimal;

import javax.swing.*;

import edu.indiana.dlib.sounddirections.facet.*;
import edu.indiana.dlib.sounddirections.facet.data.CollectionData;
import edu.indiana.dlib.sounddirections.facet.ui.*;

public class PageNav {
	private PageNav() {}
	
	public static void goToPage1(JFrame oldWindow) {
		goToPage1(oldWindow, true);
	}
	
	public static void goToPage2(JFrame oldWindow) {
		goToPage2(oldWindow, true);
	}
	
	public static void goToPage3(JFrame oldWindow) {
		goToPage3(oldWindow, true);
	}
	
	public static void goToPage4(JFrame oldWindow) {
		goToPage4(oldWindow, true);
	}
	
	public static void goToPage5(JFrame oldWindow) {
		goToPage5(oldWindow, true);
	}
	
	public static void goToSummary(JFrame oldWindow) {
		goToSummary(oldWindow, true);
	}
	
	public static void goToPage5(JFrame oldWindow, boolean showIt) {
		int x = 5;
		int y = 5;
		if (oldWindow != null) {
			x = oldWindow.getX();
			y = oldWindow.getY();
			
		}
		
		if (Main.window5 == null) {
			Main.window5 = new Screen5();
		}
		Main.window5.setBounds(x, y, Main.window5.getWidth(), Main.window5.getHeight());
		if (showIt) {
			Main.window5.setVisible(true);
		}
		if (oldWindow != null) {
			oldWindow.setVisible(false);
		}
		System.gc();
	}
	
	public static void goToPage4(JFrame oldWindow, boolean showIt) {
		int x = 5;
		int y = 5;
		if (oldWindow != null) {
			x = oldWindow.getX();
			y = oldWindow.getY();
		}
		
		if (Main.window4 == null) {
			Main.window4 = new Screen4();
		}
		Main.window4.setBounds(x, y, Main.window4.getWidth(), Main.window4.getHeight());
		if (showIt) {
			Main.window4.setVisible(true);
		}
		if (oldWindow != null) {
			oldWindow.setVisible(false);
		}
		System.gc();
	}
	
	public static void goToPage3(JFrame oldWindow, boolean showIt) {
		int x = 5;
		int y = 5;
		if (oldWindow != null) {
			x = oldWindow.getX();
			y = oldWindow.getY();
		}
		if (Main.window3 == null) {
			Main.window3 = new Screen3();
		}
		Main.window3.setBounds(x, y, Main.window3.getWidth(), Main.window3.getHeight());
		if (showIt) {
			Main.window3.setVisible(true);
		}
		if (oldWindow != null) {
			oldWindow.setVisible(false);
		}
		System.gc();
	}
	
	public static void goToPage2(JFrame oldWindow, boolean showIt) {
		int x = 5;
		int y = 5;
		if (oldWindow != null) {
			x = oldWindow.getX();
			y = oldWindow.getY();
		}
		if (Main.window1.formatBox.getSelectedIndex()==0) {
			if (Main.window2 instanceof Screen2ORTpolyester) {
				
			} else { 
				Main.window2 = new Screen2ORTpolyester();
			}
		} else if (Main.window1.formatBox.getSelectedIndex()==1) {
			if (Main.window2 instanceof Screen2ORTacetate) {
				
			} else { 
				Main.window2 = new Screen2ORTacetate();
			}
		} else if (Main.window1.formatBox.getSelectedIndex()==2) {
			if (Main.window2 instanceof Screen2ORTpaper) {
				
			} else { 
				Main.window2 = new Screen2ORTpaper();
			}
		} else if (Main.window1.formatBox.getSelectedIndex()==3) {
			if (Main.window2 instanceof Screen2ORTpvc) {
				
			} else { 
				Main.window2 = new Screen2ORTpvc();
			}
		} else if (Main.window1.formatBox.getSelectedIndex()==4) {
			if (Main.window2 instanceof Screen2Cassette) {
				
			} else { 
				Main.window2 = new Screen2Cassette();
			}
		} else if (Main.window1.formatBox.getSelectedIndex()==5) {
			if (Main.window2 instanceof Screen2DAT) {
				
			} else { 
				Main.window2 = new Screen2DAT();
			}
			if (Main.theData.year < 1994) {
				if (Main.theData.year != 0) {
					Main.theData.pre1993 = true;
					((Screen2DAT)Main.window2).pre1993Box.setSelected(Main.theData.pre1993);
				} else {
					Main.theData.pre1993 = false;
					((Screen2DAT)Main.window2).pre1993Box.setSelected(Main.theData.pre1993);
				}
			} else {
				Main.theData.pre1993 = false;
				((Screen2DAT)Main.window2).pre1993Box.setSelected(Main.theData.pre1993);
			}
		} else if (Main.window1.formatBox.getSelectedIndex()==6) {
			if (Main.window2 instanceof Screen2Dlacquer) {
				
			} else { 
				Main.window2 = new Screen2Dlacquer();
			}
		} else if (Main.window1.formatBox.getSelectedIndex()==7) {
			if (Main.window2 instanceof Screen2Daluminum) {
				
			} else { 
				Main.window2 = new Screen2Daluminum();
			}
		} else {
			if (Main.window2 instanceof Screen2wire) {
				
			} else { 
				Main.window2 = new Screen2wire();
			}
		}
		Main.window2.setBounds(x, y, Main.window2.getWidth(), Main.window2.getHeight());
		if (showIt) {
			Main.window2.setVisible(true);
		}
		if (oldWindow != null) {
			oldWindow.setVisible(false);
		}
		
		if (Main.window1.formatBox.getSelectedIndex()==0) {
			((Screen2ORTpolyester)Main.window2).explanationText.setCaretPosition(0);
		} else if (Main.window1.formatBox.getSelectedIndex()==1) {
			((Screen2ORTacetate)Main.window2).explanationText.setCaretPosition(0);
		} else if (Main.window1.formatBox.getSelectedIndex()==2) {
			((Screen2ORTpaper)Main.window2).explanationText.setCaretPosition(0);
		} else if (Main.window1.formatBox.getSelectedIndex()==3) {
			((Screen2ORTpvc)Main.window2).explanationText.setCaretPosition(0);
		} else if (Main.window1.formatBox.getSelectedIndex()==4) {
			((Screen2Cassette)Main.window2).explanationText.setCaretPosition(0);
		} else if (Main.window1.formatBox.getSelectedIndex()==5) {
			((Screen2DAT)Main.window2).explanationText.setCaretPosition(0);
		} 
		
		System.gc();
	}
	
	public static void goToPage1(JFrame oldWindow, boolean showIt){
		int x = 5;
		int y = 5;
		if (oldWindow != null) {
			x = oldWindow.getX();
			y = oldWindow.getY();
		}
		
		Main.window1.setBounds(x, y, Main.window1.getWidth(), Main.window1.getHeight());
		if (showIt) {
			Main.window1.setVisible(true);
		}
		if (oldWindow != null) {
			oldWindow.setVisible(false);
		}
		System.gc();
	}
	
	public static void goToSummary(JFrame oldWindow, boolean showIt) {
		int x = 5;
		int y = 5;
		if (oldWindow != null) {
			x = oldWindow.getX();
			y = oldWindow.getY();
		}
		if (Main.window6 != null) {
			
		} else {
			Main.window6 = new Screen6();
		}
		Main.window6.setBounds(x, y, Main.window6.getWidth(), Main.window6.getHeight());
		if (showIt) {
			Main.window6.setVisible(true);
		}
		if (oldWindow != null) {
			oldWindow.setVisible(false);
		}
		System.gc();
	}
	
	static public void showRecord(CollectionData theData) {
		Main.theData = new CollectionData();
		Main.theData.databaseID = theData.databaseID;
		Main.window2 = null;
		//window 1
		Main.window1 = new Screen1();
		Main.window1.CollectionNumberText.setText(theData.collectionNumber);
		Main.window1.CollectionNumberText.setCaretPosition(0);
		Main.window1.CollectionPartText.setText(theData.collectionPart);
		Main.window1.CollectionPartText.setCaretPosition(0);
		Main.window1.CollectionNameText.setSelectedItem(theData.collectionName);
		Main.window1.ShelfNumberText.setText(theData.shelfNumber);
		Main.window1.ShelfNumberText.setCaretPosition(0);
		Main.window1.WorkerText.setSelectedItem(theData.worker);
		Main.window1.CollectionPartOneText.setText(theData.partOne);
		Main.window1.CollectionPartOneText.setCaretPosition(0);
		Main.window1.CollectionPartTwoText.setText(theData.partTwo);
		Main.window1.CollectionPartTwoText.setCaretPosition(0);
		Main.window1.ProjectTitleText.setSelectedItem(theData.projectTitle);
		Main.window1.DateText.setText(theData.date);
		Main.window1.generationBox.setSelectedItem(theData.generation);
		String forma = theData.formatString;
		Main.window1.formatBox.setSelectedItem(forma);
		if (!(theData.year == 0)) {
			Main.window1.yearField.setText("" + theData.year);
		}
		Main.window1.saveData();
		Main.window1.initVars();
		Main.theData.stereo = theData.stereo;
		Main.theData.mono = theData.mono;
		Main.theData.unknownSound = theData.unknownSound;
		Main.theData.fullTrack = theData.fullTrack;
		Main.theData.halfTrack = theData.halfTrack;
		Main.theData.quarterTrack = theData.quarterTrack;
		Main.theData.unknownTrack = theData.unknownTrack;
		Main.theData.speed1 = theData.speed1;
		Main.theData.speed2 = theData.speed2;
		Main.theData.speed3 = theData.speed3;
		Main.theData.speed4 = theData.speed4;
		Main.theData.speed5 = theData.speed5;
		Main.theData.speed6 = theData.speed6;
		Main.theData.unknownSpeed = theData.unknownSpeed;
		
		PageNav.goToPage2(null, false);
		//window 2
		if (theData.formatString.equals("Disc-aluminum")){ 
			Main.window2 = new Screen2Daluminum();
			((Screen2Daluminum)Main.window2).oxidationBox.setSelected(theData.oxidation);
			((Screen2Daluminum)Main.window2).updateTheData();
			PageNav.goToPage3(null, false);
		} else if (theData.formatString.equals("Cassette-analog, audio")){ 
			Main.window2 = new Screen2Cassette();
			((Screen2Cassette)Main.window2).minuteBox.setSelected(theData.minute);
			((Screen2Cassette)Main.window2).offBrandBox.setSelected(theData.offBrand);
			((Screen2Cassette)Main.window2).lossBox.setSelected(theData.lubricant);
			((Screen2Cassette)Main.window2).fungusBox.setSelected(theData.fungus);
			((Screen2Cassette)Main.window2).otherProblemsBox.setSelected(theData.other);
			JComboBox b = ((Screen2Cassette)Main.window2).tapeType;
			if (theData.typeIcassette) {
				b.setSelectedIndex(0);
			} else if (theData.typeIIcassette) {
				b.setSelectedIndex(1);
			} else if (theData.typeIIIcassette) {
				b.setSelectedIndex(2);
			} else if (theData.typeIVcassette) {
				b.setSelectedIndex(3);
			} else {
				b.setSelectedIndex(4);
			}
			JComboBox c = ((Screen2Cassette)Main.window2).soundfieldType;
			if (theData.stereo) {
				c.setSelectedIndex(0);
			} else if (theData.mono) {
				c.setSelectedIndex(1);
			} else {
				c.setSelectedIndex(2);
			}
			((Screen2Cassette)Main.window2).explanationText.setText(theData.explanationString);
			((Screen2Cassette)Main.window2).enableExplanationText();
			((Screen2Cassette)Main.window2).updateTheData();
			PageNav.goToPage3(null, false);
		} else if (theData.formatString.equals("DAT (digital audio tape)")){ 
			Main.window2 = new Screen2DAT();
			((Screen2DAT)Main.window2).thinTapeBox.setSelected(theData.thinTape);
			((Screen2DAT)Main.window2).pre1993Box.setSelected(theData.pre1993);
			((Screen2DAT)Main.window2).recordedPortable.setSelected(theData.portableDAT);
			((Screen2DAT)Main.window2).dataGradeTape.setSelected(theData.dataGradeDAT);
			((Screen2DAT)Main.window2).longPlayBox.setSelected(theData.longPlayDAT);
			((Screen2DAT)Main.window2).otherProblemsBox.setSelected(theData.other);
			((Screen2DAT)Main.window2).fungus.setSelected(theData.fungus);
			((Screen2DAT)Main.window2).explanationText.setText(theData.explanationString);
			((Screen2DAT)Main.window2).enableExplanationText();
			((Screen2DAT)Main.window2).updateTheData();
			PageNav.goToPage3(null, false);
		} else if (theData.formatString.equals("Disc-lacquer")){
			Main.window2 = new Screen2Dlacquer();
			((Screen2Dlacquer)Main.window2).glassBox.setSelected(theData.glass);
			((Screen2Dlacquer)Main.window2).plasticRadio.setSelected(theData.plastic);
			((Screen2Dlacquer)Main.window2).delaminationRadio.setSelected(theData.delamination);
			((Screen2Dlacquer)Main.window2).updateTheData();
			PageNav.goToPage3(null, false);
		} else if (theData.formatString.equals("Open reel tape-acetate")){
			Main.window2 = new Screen2ORTacetate();
			JComboBox b = ((Screen2ORTacetate)Main.window2).tapeThickness;
			if (theData.longPlayAcetate) {
				b.setSelectedIndex(1);
			} else if (theData.doublePlayAcetate) {
				b.setSelectedIndex(2);
			} else if (theData.triplePlayAcetate) {
				b.setSelectedIndex(3);
			} else if (theData.standardAcetate) {
				b.setSelectedIndex(0);
			} else if (theData.unknownDoubleTripleAcetate) {
				b.setSelectedIndex(4);
			} else {
				b.setSelectedIndex(5);
			}
			((Screen2ORTacetate)Main.window2).offBrandBox.setSelected(theData.offBrand);
			((Screen2ORTacetate)Main.window2).vinegarSyndromeBox.setSelected(theData.vinegar);
			((Screen2ORTacetate)Main.window2).fungusBox.setSelected(theData.fungus);
			((Screen2ORTacetate)Main.window2).visibleMinor.setSelected(theData.visibleMinorAcetate);
			((Screen2ORTacetate)Main.window2).visibleModerate.setSelected(theData.visibleModerateAcetate);
			((Screen2ORTacetate)Main.window2).visibleSevere.setSelected(theData.visibleSevereAcetate);
			((Screen2ORTacetate)Main.window2).otherProblemsBox.setSelected(theData.other);
			((Screen2ORTacetate)Main.window2).explanationText.setText(theData.explanationString);
			((Screen2ORTacetate)Main.window2).enableExplanationText();
			((Screen2ORTacetate)Main.window2).updateTheData();
			PageNav.goToPage3(null, false);
		} else if (theData.formatString.equals("Open reel tape-paper")){
			Main.window2 = new Screen2ORTpaper();
			JComboBox b = ((Screen2ORTpaper)Main.window2).tapeThickness;
			if (theData.longPlayPaper) {
				b.setSelectedIndex(1);
			} else if (theData.standardPaper) {
				b.setSelectedIndex(0);
			} else {
				b.setSelectedIndex(2);
			}
			((Screen2ORTpaper)Main.window2).fungusBox.setSelected(theData.fungus);
			((Screen2ORTpaper)Main.window2).offBrandBox.setSelected(theData.offBrand);
			((Screen2ORTpaper)Main.window2).otherProblemsBox.setSelected(theData.other);
			((Screen2ORTpaper)Main.window2).visibleMinor.setSelected(theData.visibleMinorPaper);
			((Screen2ORTpaper)Main.window2).visibleModerate.setSelected(theData.visibleModeratePaper);
			((Screen2ORTpaper)Main.window2).visibleSevere.setSelected(theData.visibleSeverePaper);
			((Screen2ORTpaper)Main.window2).explanationText.setText(theData.explanationString);
			((Screen2ORTpaper)Main.window2).enableExplanationText();
			((Screen2ORTpaper)Main.window2).updateTheData();
			PageNav.goToPage3(null, false);
		} else if (theData.formatString.equals("Open reel tape-polyester")){
			Main.window2 = new Screen2ORTpolyester();
			JComboBox b = ((Screen2ORTpolyester)Main.window2).tapeThickness;
			if (theData.longPlayPoly) {
				b.setSelectedIndex(1);
			} else if (theData.doublePlayPoly) {
				b.setSelectedIndex(2);
			} else if (theData.triplePlayPoly) {
				b.setSelectedIndex(3);
			} else if (theData.standardPoly) {
				b.setSelectedIndex(0);
			} else if (theData.unknownDoubleTriplePoly) {
				b.setSelectedIndex(4);
			} else {
				b.setSelectedIndex(5);
			}
			((Screen2ORTpolyester)Main.window2).offBrandBox.setSelected(theData.offBrand);
			((Screen2ORTpolyester)Main.window2).stickyRadio.setSelected(theData.stickyPoly);
			((Screen2ORTpolyester)Main.window2).lossRadio.setSelected(theData.lossPoly);
			((Screen2ORTpolyester)Main.window2).fungusBox.setSelected(theData.fungus);
			((Screen2ORTpolyester)Main.window2).visibleMinor.setSelected(theData.visibleMinorPoly);
			((Screen2ORTpolyester)Main.window2).visibleModerate.setSelected(theData.visibleModeratePoly);
			((Screen2ORTpolyester)Main.window2).visibleSevere.setSelected(theData.visibleSeverePoly);
			((Screen2ORTpolyester)Main.window2).otherProblemsBox.setSelected(theData.other);
			((Screen2ORTpolyester)Main.window2).explanationText.setText(theData.explanationString);
			((Screen2ORTpolyester)Main.window2).enableExplanationText();
			((Screen2ORTpolyester)Main.window2).updateTheData();
			PageNav.goToPage3(null, false);
		} else if (theData.formatString.equals("Open reel tape-pvc")){
			Main.window2 = new Screen2ORTpvc();
			JComboBox b = ((Screen2ORTpvc)Main.window2).tapeThickness;
			if (theData.longPlayPVC) {
				b.setSelectedIndex(1);
			} else if (theData.doublePlayPVC) {
				b.setSelectedIndex(2);
			} else if (theData.triplePlayPVC) {
				b.setSelectedIndex(3);
			} else if (theData.standardPlayPVC) {
				b.setSelectedIndex(0);
			} else if (theData.unknownDoubleTriplePVC) {
				b.setSelectedIndex(4);
			} else {
				b.setSelectedIndex(5);
			}
			((Screen2ORTpvc)Main.window2).offBrandBox.setSelected(theData.offBrand);
			((Screen2ORTpvc)Main.window2).fungusBox.setSelected(theData.fungus);
			((Screen2ORTpvc)Main.window2).visibleMinor.setSelected(theData.visibleMinorPVC);
			((Screen2ORTpvc)Main.window2).visibleModerate.setSelected(theData.visibleModeratePVC);
			((Screen2ORTpvc)Main.window2).visibleSevere.setSelected(theData.visibleSeverePVC);
			((Screen2ORTpvc)Main.window2).otherProblemsBox.setSelected(theData.other);
			((Screen2ORTpvc)Main.window2).stickyRadio.setSelected(theData.stickyPVC);
			((Screen2ORTpvc)Main.window2).lossRadio.setSelected(theData.lossPVC);
			((Screen2ORTpvc)Main.window2).explanationText.setText(theData.explanationString);
			((Screen2ORTpvc)Main.window2).enableExplanationText();
			((Screen2ORTpvc)Main.window2).updateTheData();
			PageNav.goToPage3(null, false);
		} else {
			Main.window2 = new Screen2wire();
			((Screen2wire)Main.window2).preWWII.setSelected(theData.preWWII);
			((Screen2wire)Main.window2).rust.setSelected(theData.rust);
			((Screen2wire)Main.window2).updateTheData();
			PageNav.goToPage3(null, false);
		}
		//window 3
		Main.window3.orpMastersBox.setSelected(theData.orpMastersBox);
		Main.window3.orpMastersStickyBox.setSelected(theData.orpMastersStickyBox);
		Main.window3.orpNonMasterBox.setSelected(theData.orpNonMasterBox);
		Main.window3.oraBox.setSelected(theData.oraBox);
		Main.window3.DACBox.setSelected(theData.DACBox);
		Main.window3.cassetteBox.setSelected(theData.cassetteBox);
		Main.window3.DATBox.setSelected(theData.DATBox);
		Main.window3.cdDataBox.setSelected(theData.cdDataBox);
		Main.window3.newone.setSelected(theData.isPreserved);
		Main.window3.cdAudioBox.setSelected(theData.cdAudioBox);
		Main.window3.updateTheData();
		PageNav.goToPage4(null, false);
		//window 4
		Main.window4.historyBox.setSelected(theData.historyBox);
		//mod points
		Main.theData.modPoints = theData.modPoints;
		Main.window4.updateTable();
		Main.window4.updateTheData();
		PageNav.goToPage5(null, false);
		//window 5
		BigDecimal d = new BigDecimal(theData.researchValue).setScale(2, BigDecimal.ROUND_HALF_UP);
		Main.window5.researchValueSpinner.setSelectedItem(d.toString());
		Main.window5.notesText.setText(theData.notes4_5);
		Main.window5.updateTheData();
		PageNav.goToSummary(null);
		Main.theData.isDirty = false;
	}
}
