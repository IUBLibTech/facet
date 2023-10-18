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


import javax.swing.JOptionPane;

/**
 * Helper method to open a web browser to the specified URL
 */
public class BrowserLauncher {

	public static void openURL(String url) {
		
		String osName = System.getProperty("os.name");
		try {
			/*
			java.net.URI test = new java.net.URI(url);
			java.awt.Desktop.getDesktop().browse(new java.net.URI(url));
			*/
			
			if (osName.startsWith("Windows")) {
				Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
			} 			
		}  catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error opening browser.");
		}
		
	}
}