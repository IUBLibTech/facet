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

package edu.indiana.dlib.sounddirections.facet.ui.dialogs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;

/**
 * A regular dialog with built in cut/copy/paste functionality added. Any dialog that needs that 
 * functionality should have this dialog as a parent
 */
public class ParentDialog extends JDialog {
    //	the popup menu stuff
    JPopupMenu mnuCutCopyPaste = new JPopupMenu();
    JMenuItem menuiCut = new JMenuItem("Cut");
    JMenuItem menuiCopy = new JMenuItem("Copy");
    JMenuItem menuiPaste = new JMenuItem("Paste");
    JTextComponent theTextComponent = null;
    
    public ParentDialog() {
        //popup menu init stuff
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
            if (components[counter] instanceof Container) {
                //recurse
                doComponentInitialization((Container)components[counter]);
            }
            counter = counter + 1;
        }
	}
}
