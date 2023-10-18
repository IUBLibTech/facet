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

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A utility class to wrap in a background image with a swing component; used in the welcome screen
 */
public class BackGroundImage {    
    
    private static final GridBagConstraints gbc;
    static {
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHWEST;
    }
    
    public static JPanel wrapInBackgroundImage(JComponent component,
            Icon backgroundIcon) {
        return wrapInBackgroundImage(
                component,
                backgroundIcon,
                JLabel.TOP,
                JLabel.LEADING);
    }
    
    public static JPanel wrapInBackgroundImage(JComponent component,
            Icon backgroundIcon,
            int verticalAlignment,
            int horizontalAlignment) {
        
        component.setOpaque(false);
        JPanel backgroundPanel = new JPanel(new GridBagLayout());
        backgroundPanel.add(component, gbc);
        JLabel backgroundImage = new JLabel(backgroundIcon);
        backgroundImage.setPreferredSize(new Dimension(1,1));
        backgroundImage.setMinimumSize(new Dimension(1,1));
        backgroundImage.setVerticalAlignment(verticalAlignment);
        backgroundImage.setHorizontalAlignment(horizontalAlignment);
        backgroundPanel.add(backgroundImage, gbc);
        return backgroundPanel;
    }
}