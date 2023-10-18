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
import javax.swing.text.JTextComponent;
import edu.indiana.dlib.sounddirections.facet.*;
import edu.indiana.dlib.sounddirections.facet.util.*;

public class ParentWindow extends JFrame {
    //	the popup menu stuff
	JPopupMenu mnuShowHelp = new JPopupMenu();
	JMenuItem menuiWhatIsThis = new JMenuItem("What is this?");
    JPopupMenu mnuCutCopyPaste = new JPopupMenu();
    JMenuItem menuiCut = new JMenuItem("Cut");
    JMenuItem menuiCopy = new JMenuItem("Copy");
    JMenuItem menuiPaste = new JMenuItem("Paste");
    JTextComponent theTextComponent = null;
    
    String parentText = "";
    final String procedureLink = "http://www.dlib.indiana.edu/projects/sounddirections/facet/facet_procedures.pdf#";
    
    public ParentWindow() {
    	//window icon
    	this.setIconImage(Main.icoFacet.getImage());
        //		popup menu init stuff
		mnuCutCopyPaste.add(menuiCut);
        mnuCutCopyPaste.add(menuiCopy);
        mnuCutCopyPaste.add(menuiPaste);
        this.menuiCut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (theTextComponent != null) {
                    theTextComponent.cut();
                }
            }
        });
        this.menuiCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (theTextComponent != null) {
                    theTextComponent.copy();
                }
            }
        });
        this.menuiPaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (theTextComponent != null) {
                     theTextComponent.paste();
                }
            }
        });
        mnuShowHelp.add(menuiWhatIsThis);
        this.menuiWhatIsThis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//screen 1
        		if (parentText.equals("Collection Primary Identifier")) {
        			BrowserLauncher.openURL(procedureLink + "5.3collectionprimary");
        		} else if (parentText.equals("Part Name: ")) {
        			BrowserLauncher.openURL(procedureLink + "5.3partname");
        		} else if (parentText.equals("Part ")) {
        			BrowserLauncher.openURL(procedureLink + "5.3partnumber");
        		} else if (parentText.equals("Collection Name: ")) {
        			BrowserLauncher.openURL(procedureLink + "5.3collectionname");
        		} else if (parentText.equals("Shelf Number(s): ")) {
        			BrowserLauncher.openURL(procedureLink + "5.3shelf");
        		} else if (parentText.equals("Worker: ")) {
        			BrowserLauncher.openURL(procedureLink + "5.3worker");
        		} else if (parentText.equals("Date: ")) {
        			BrowserLauncher.openURL(procedureLink + "5.3date");
        		} else if (parentText.equals("Project Title: ")) {
        			BrowserLauncher.openURL(procedureLink + "5.3project");
        		} else if (parentText.equals("Format: ")) {
        			BrowserLauncher.openURL(procedureLink + "5.3format");
        		} else if (parentText.equals("Generation: ")) {
        			BrowserLauncher.openURL(procedureLink + "5.3generation");
        		} else if (parentText.equals("Year Recorded: ")) {
        			BrowserLauncher.openURL(procedureLink + "5.3year");
        		//search screen
        		} else if (parentText.equals("Export/Print ")) {
        			BrowserLauncher.openURL(procedureLink + "5.9print");
        		} else if (parentText.equals("Exclude Preserved Collections")) {
        			BrowserLauncher.openURL(procedureLink + "5.9exclude");
        		} else if (parentText.equals("Include Research Value in Point Totals")) {
        			BrowserLauncher.openURL(procedureLink + "5.9include");
        		} else if (parentText.equals("Retrieve Collections With Point Totals ")) {
        			BrowserLauncher.openURL(procedureLink + "5.9retrieve");
        		} else if (parentText.equals("Get Top 10")) {
        			BrowserLauncher.openURL(procedureLink + "5.9search");
        		} else if (parentText.equals("Collection Primary Identifier: ")) {
        			BrowserLauncher.openURL(procedureLink + "5.3collectionprimary");
        		} else if (parentText.equals("Part Number: ")) {
        			BrowserLauncher.openURL(procedureLink + "5.3partnumber");
        		} else if (parentText.equals("Recording Date: ")) {
        			BrowserLauncher.openURL(procedureLink + "5.3year");
        		} else if (parentText.equals("Clear")) {
        			BrowserLauncher.openURL(procedureLink + "5.9search");
        		} else if (parentText.equals("Delete")) {
        			BrowserLauncher.openURL(procedureLink + "5.9search");
        		} else if (parentText.equals("Open")) {
        			BrowserLauncher.openURL(procedureLink + "5.9search");
        		//summary screen
        		} else if (parentText.equals("Export/Print")) {
        			BrowserLauncher.openURL(procedureLink + "5.8print");
        		//screen 5
        		} else if (parentText.equals("Research Value Score (If Applicable)")) {
        			BrowserLauncher.openURL(procedureLink + "5.7research");
        		} else if (parentText.equals("Notes")) {
        			BrowserLauncher.openURL(procedureLink + "5.7notes");
        		//screen 4
        		} else if (parentText.equals("   Storage History Problems")) {
        			BrowserLauncher.openURL(procedureLink + "5.6storage");
        		} else if (parentText.equals("Other Factors")) {
        			BrowserLauncher.openURL(procedureLink + "5.6other");
        		//screen 3
        		} else if (parentText.equals("Only two selections may be made on this page.")) {
        			BrowserLauncher.openURL(procedureLink + "5.5");
        		} else if (parentText.equals("   Open Reel Preservation Masters (Non Sticky Shed)")) {
        			BrowserLauncher.openURL(procedureLink + "5.5ORnonSS");
        		} else if (parentText.equals("   Open Reel Preservation Masters (Sticky Shed)")) {
        			BrowserLauncher.openURL(procedureLink + "5.5ORSS");
        		} else if (parentText.equals("   Open Reel, Polyester, Non-Preservation Masters")) {
        			BrowserLauncher.openURL(procedureLink + "5.5ORpoly");
        		} else if (parentText.equals("   Open Reel, Acetate")) {
        			BrowserLauncher.openURL(procedureLink + "5.5ORacetate");
        		} else if (parentText.equals("   Cassette-Analog, Audio")) {
        			BrowserLauncher.openURL(procedureLink + "5.5CASS");
        		} else if (parentText.equals("   DAT (Digital Audio Tape)")) {
        			BrowserLauncher.openURL(procedureLink + "5.5DAT");
        		} else if (parentText.equals("   CDs-Data Files")) {
        			BrowserLauncher.openURL(procedureLink + "5.5CDdata");
        		} else if (parentText.equals("   CDs-Audio")) {
        			BrowserLauncher.openURL(procedureLink + "5.5CDaudio");
        		} else if (parentText.equals("   Digital File (Non-Preservation Masters)")) {
        			BrowserLauncher.openURL(procedureLink + "5.5digital");
        		} else if (parentText.equals("   Preservation (Archival) Master Files")) {
        			BrowserLauncher.openURL(procedureLink + "5.5preservation");
        		//screen 2
        		} else if (parentText.equals("   Pre-WWII and/or Armour Brand")) {
        			BrowserLauncher.openURL(procedureLink + "5.4WIREpre");
        		} else if (parentText.equals("   Rust, Oxidation or Corrosion")) {
        			BrowserLauncher.openURL(procedureLink + "5.4WIRErust");
        		} else if (parentText.equals("   Oxidation")) {
        			BrowserLauncher.openURL(procedureLink + "5.4ALUMoxidation");
        		} else if (parentText.equals("   Glass Base")) {
        			BrowserLauncher.openURL(procedureLink + "5.4LACQglass");
        		} else if (parentText.equals("   Plasticizer Exudation")) {
        			BrowserLauncher.openURL(procedureLink + "5.4LACQplasticizer");
        		} else if (parentText.equals("   Delamination")) {
        			BrowserLauncher.openURL(procedureLink + "5.4LACQdelamination");
        			
        			
        		} else if (parentText.equals("   Thin Tape")) {
        			BrowserLauncher.openURL(procedureLink + "5.4DATthin");
        		} else if (parentText.equals("   1993 or Earlier")) {
        			BrowserLauncher.openURL(procedureLink + "5.4DAT1993");
        		} else if (parentText.equals("   Recorded on Portable")) {
        			BrowserLauncher.openURL(procedureLink + "5.4DATrecorded");
        		} else if (parentText.equals("   Data Grade Tape")) {
        			BrowserLauncher.openURL(procedureLink + "5.4DATdata");
        		} else if (parentText.equals("   Long-Play, 32k, or 96k")) {
        			BrowserLauncher.openURL(procedureLink + "5.4DATlong");
        		} else if (parentText.equals("   Fungus")) {
        			BrowserLauncher.openURL(procedureLink + "5.4ORfungus");
        		} else if (parentText.equals("   Other Documented Problems")) {
        			BrowserLauncher.openURL(procedureLink + "5.4ORother");
        		
        		
        		} else if (parentText.equals("Tape Type:")) {
        			BrowserLauncher.openURL(procedureLink + "5.4CASStape");
        		} else if (parentText.equals("Sound Field: ")) {
        			BrowserLauncher.openURL(procedureLink + "5.4CASSsound");
        		} else if (parentText.equals("   120 or 180 Minute")) {
        			BrowserLauncher.openURL(procedureLink + "5.4CASS120");
        		} else if (parentText.equals("   Off-Brand")) {
        			BrowserLauncher.openURL(procedureLink + "5.4CASSoffbrand");
        		} else if (parentText.equals("Noise Reduction ")) {
        			BrowserLauncher.openURL(procedureLink + "5.4CASSnoise");
        		} else if (parentText.equals("   Soft Binder Syndrome-Unidentified Problems")) {
        			BrowserLauncher.openURL(procedureLink + "5.4ORsoft");
        			
        		} else if (parentText.equals("Thickness:")) {
        			BrowserLauncher.openURL(procedureLink + "5.4ORthickness");
        		} else if (parentText.equals("   Off-brand")) {
        			BrowserLauncher.openURL(procedureLink + "5.4ORoffbrand");
        		} else if (parentText.equals("Tracks")) {
        			BrowserLauncher.openURL(procedureLink + "5.4ORtracks");
        		} else if (parentText.equals("Tape Pack Problems")) {
        			BrowserLauncher.openURL(procedureLink + "5.4ORtape");
        		} else if (parentText.equals("Noise Reduction")) {
        			BrowserLauncher.openURL(procedureLink + "5.4ORnoise");
        			
        		} else if (parentText.equals("   Soft Binder Syndrome-Sticky Shed Syndrome")) {
        			BrowserLauncher.openURL(procedureLink + "5.4ORsoft");
        			
        		} else if (parentText.equals("   Vinegar Syndrome")) {
        			BrowserLauncher.openURL(procedureLink + "5.4ORvinegar");
        			
        		}
        		
        		
            }
        });
    }
    
    /**
     * Mouse pressed in a JTextComponent on this window. Used to figure out where to display pop-up menu and whether to show it or not.
     */
    void textComponent_mousePressed(MouseEvent e) {
        boolean doPopUp = false;
        if (System.getProperty("os.name").startsWith("Mac OS")) {
            if (e.isControlDown()) {
                doPopUp = true;
            }
        }
        if ((e.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK) {
            doPopUp = true;
        }
        if (!doPopUp) {
            return;
        }
        this.theTextComponent = (JTextComponent)e.getComponent();
        theTextComponent.requestFocusInWindow();
        int theInt = theTextComponent.viewToModel(new Point(e.getX(), e.getY()));
        this.menuiCopy.setEnabled(false);
        this.menuiCut.setEnabled(false);
        this.menuiPaste.setEnabled(false);
        if (theTextComponent.isEditable()) {
            this.menuiCut.setEnabled(true);
            this.menuiPaste.setEnabled(true);
        }
        if (!(theTextComponent.getSelectedText() == null)) {
            if ((theInt <= theTextComponent.getSelectionEnd()) && (theInt >= theTextComponent.getSelectionStart())) {
                //click was on selected portion of text
                this.menuiCopy.setEnabled(true);
            } else {
                //click wasn't on selected portion of text
                this.menuiCut.setEnabled(false);
                theTextComponent.setSelectionStart(theInt);
                theTextComponent.setSelectionEnd(theInt);
            }
        } else {
            this.menuiCut.setEnabled(false);
            theTextComponent.setSelectionStart(theInt);
            theTextComponent.setSelectionEnd(theInt);
        }
        if ((!this.menuiCopy.isEnabled()) && (!this.menuiCut.isEnabled()) && (!this.menuiPaste.isEnabled())) {
            return;       //nothing would be enabled; don't show
        }
        mnuCutCopyPaste.show(e.getComponent(), e.getX(), e.getY());
    }
    
    void jLabel_mousePressed(MouseEvent e) {
        boolean doPopUp = false;
        if (System.getProperty("os.name").startsWith("Mac OS")) {
            if (e.isControlDown()) {
                doPopUp = true;
            }
        }
        if ((e.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK) {
            doPopUp = true;
        }
        if (!doPopUp) {
            return;
        }
        if (e.getComponent() instanceof JLabel) {
        	parentText = ((JLabel)e.getComponent()).getText();
        } else if (e.getComponent() instanceof JCheckBox) {
        	parentText = ((JCheckBox)e.getComponent()).getText();
        } else if (e.getComponent() instanceof JButton) {
        	parentText = ((JButton)e.getComponent()).getText();
        }
        mnuShowHelp.show(e.getComponent(), e.getX(), e.getY());
    }
    
    public void doComponentInitialization(Container component) {
		Component[] components = component.getComponents();
        int counter = 0;
        while (counter < components.length) {
            if (components[counter] instanceof JTextComponent) {
                components[counter].addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        textComponent_mousePressed(e);
                }});
            }
            if  (components[counter] instanceof JLabel) {
            	final JLabel comp = (JLabel)(components[counter]);
                boolean show = false;
            	if (comp.getText().equals("Collection Primary Identifier")) {
            		show = true;
                } else if (comp.getText().equals("Part Name: ")) {
            		show = true;
                
                } else if (comp.getText().equals("Part ")) {
            		show = true;
                } else if (comp.getText().equals("Collection Name: ")) {
            		show = true;
                } else if (comp.getText().equals("Shelf Number(s): ")) {
            		show = true;
                } else if (comp.getText().equals("Worker: ")) {
            		show = true;
                } else if (comp.getText().equals("Date: ")) {
            		show = true;
                } else if (comp.getText().equals("Project Title: ")) {
            		show = true;
                } else if (comp.getText().equals("Format: ")) {
            		show = true;
                } else if (comp.getText().equals("Generation: ")) {
            		show = true;
                } else if (comp.getText().equals("Year Recorded: ")) {
            		show = true;
                } else if (comp.getText().equals("Notes")) {
            		show = true;
                } else if (comp.getText().equals("Research Value Score (If Applicable)")) {
            		show = true;
                } else if (comp.getText().equals("Other Factors")) {
            		show = true;
                } else if (comp.getText().equals("Only two selections may be made on this page.")) {
            		show = true;
                } else if (comp.getText().equals("Tape Type:")) {
            		show = true;
                } else if (comp.getText().equals("Sound Field: ")) {
            		show = true;
                } else if (comp.getText().equals("Thickness:")) {
            		show = true;
                } else if (comp.getText().equals("Tape Pack Problems")) {
            		show = true;
                } else if (comp.getText().equals("Collection Primary Identifier: ")) {
            		show = true;
                } else if (comp.getText().equals("Part Number: ")) {
            		show = true;
                } else if (comp.getText().equals("Recording Date: ")) {
            		show = true;
                } 
            	if (show) {
            		comp.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mousePressed(MouseEvent e) {
                            jLabel_mousePressed(e);
                    }});
            	}
            	
            }
            if (components[counter] instanceof JCheckBox) {
            	final JCheckBox comp = (JCheckBox)(components[counter]);
            	boolean show = false;
            	if (comp.getText().equals("Exclude Preserved Collections")) {
            		show = true;
            	} else if (comp.getText().equals("Include Research Value in Point Totals")) {
            		show = true;
            	} else if (comp.getText().equals("Retrieve Collections With Point Totals ")) {
            		show = true;
            	} else if (comp.getText().equals("   Storage History Problems")) {
            		show = true;
            	} else if (comp.getText().equals("   Open Reel Preservation Masters (Non Sticky Shed)")) {
            		show = true;
            	} else if (comp.getText().equals("   Open Reel Preservation Masters (Sticky Shed)")) {
            		show = true;
            	} else if (comp.getText().equals("   Open Reel, Polyester, Non-Preservation Masters")) {
            		show = true;
            	} else if (comp.getText().equals("   Open Reel, Acetate")) {
            		show = true;
            	} else if (comp.getText().equals("   Cassette-Analog, Audio")) {
            		show = true;
            	} else if (comp.getText().equals("   DAT (Digital Audio Tape)")) {
            		show = true;
            	} else if (comp.getText().equals("   CDs-Data Files")) {
            		show = true;
            	} else if (comp.getText().equals("   CDs-Audio")) {
            		show = true;
            	} else if (comp.getText().equals("   Digital File (Non-Preservation Masters)")) {
            		show = true;
            	} else if (comp.getText().equals("   Preservation (Archival) Master Files")) {
            		show = true;
            	
            	} else if (comp.getText().equals("   Delamination")) {
            		show = true;
            	} else if (comp.getText().equals("   Plasticizer Exudation")) {
            		show = true;
            	} else if (comp.getText().equals("   Glass Base")) {
            		show = true;
            	} else if (comp.getText().equals("   Oxidation")) {
            		show = true;
            	} else if (comp.getText().equals("   Rust, Oxidation or Corrosion")) {
            		show = true;
            	} else if (comp.getText().equals("   Pre-WWII and/or Armour Brand")) {
            		show = true;
            		
            		
            	} else if (comp.getText().equals("   Thin Tape")) {
            		show = true;
            	} else if (comp.getText().equals("   1993 or Earlier")) {
            		show = true;
            	} else if (comp.getText().equals("   Recorded on Portable")) {
            		show = true;
            	} else if (comp.getText().equals("   Data Grade Tape")) {
            		show = true;
            	} else if (comp.getText().equals("   Long-Play, 32k, or 96k")) {
            		show = true;
            	} else if (comp.getText().equals("   Fungus")) {
            		show = true;
            	} else if (comp.getText().equals("   Other Documented Problems")) {
            		show = true;
            		
            	} else if (comp.getText().equals("   120 or 180 Minute")) {
            		show = true;
            	} else if (comp.getText().equals("   Off-Brand")) {
            		show = true;
            	} else if (comp.getText().equals("   Soft Binder Syndrome-Unidentified Problems")) {
            		show = true;
            	} else if (comp.getText().equals("   Off-brand")) {
            		show = true;
            	} else if (comp.getText().equals("   Soft Binder Syndrome-Sticky Shed Syndrome")) {
            		show = true;
            	} else if (comp.getText().equals("   Vinegar Syndrome")) {
            		show = true;
            	}
            	
            	
            	   
            	
            	if (show) {
            		comp.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mousePressed(MouseEvent e) {
                            jLabel_mousePressed(e);
                    }});
            	}
            }
            if (components[counter] instanceof JButton) {
            	final JButton comp = (JButton)(components[counter]);
            	boolean show = false;
            	if (comp.getText().equals("Get Top 10")) {
            		show = true;
            	} else if (comp.getText().equals("Export/Print ")) {
            		show = true;
                } else if (comp.getText().equals("Export/Print")) {
            		show = true;
            	} else if (comp.getText().equals("Delete")) {
            		show = true;
            	} else if (comp.getText().equals("Open")) {
            		show = true;
            	} else if (comp.getText().equals("Clear")) {
            		show = true;
            	} else if (comp.getText().equals("Noise Reduction")) {
            		show = true;
            	} else if (comp.getText().equals("Noise Reduction ")) {
            		show = true;
            	} else if (comp.getText().equals("Tracks")) {
            		show = true;
            	}

            	
        		if (show) {
            		comp.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mousePressed(MouseEvent e) {
                            jLabel_mousePressed(e);
                    }});
            	}
            }
            
            if (components[counter] instanceof Container) {
                //recurse
                doComponentInitialization((Container)components[counter]);
            }
            counter = counter + 1;
        }
	}
    
}
