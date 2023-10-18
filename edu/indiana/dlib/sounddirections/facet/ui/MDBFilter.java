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

import java.io.File;
import javax.swing.filechooser.*;

/**
 * A file filter to display only MDB files.
 */
public class MDBFilter extends FileFilter {

    // Accept all directories and all MDB files.
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }
        String extension = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');
        if (i > 0 &&  i < s.length() - 1) {
            extension = s.substring(i+1).toLowerCase();
        }
        if (extension != null) {
            if (extension.equals("mdb")) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    // The description of this filter
    public String getDescription() {
        return "MDB Files";
    }
}