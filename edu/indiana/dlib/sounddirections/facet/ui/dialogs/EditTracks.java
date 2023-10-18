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
import javax.swing.*;
import edu.indiana.dlib.sounddirections.facet.*;
import edu.indiana.dlib.sounddirections.facet.ui.*;

public class EditTracks extends JDialog {
	
	JFrame theParent;
	JRadioButton fullTrackRadio, halfTrackRadio, quarterTrackRadio, unknownRadio, monoRadio, stereoRadio,
		unknownSoundRadio, speed1Radio, speed2Radio, speed3Radio, speed4Radio, speed5Radio,
		speed6Radio, speedUnknownRadio;
	ButtonGroup bgroup, bgroup1, bgroup2;
	JButton acceptButton;
	
	public EditTracks(JFrame parent) {
		theParent = parent;
		this.setModal(true);
		this.setTitle("Tracks");
		this.setResizable(false);
		this.setBounds(parent.getX() + 15, parent.getY() + 15, 300, 400);
		Container c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Main.BROWNCOLOR);
		Font font = Main.REGFONT;
		Font bigFont = Main.BIGFONT;
		JPanel mainJPanel = new JPanel();
		mainJPanel.setBounds(5,5,390,570);
		mainJPanel.setLayout(null);
		mainJPanel.setBackground(Main.BROWNCOLOR);
		c.add(mainJPanel);
		
		JLabel trackingLabel = new JLabel("Track Configuration");
		trackingLabel.setFont(bigFont);
		trackingLabel.setBounds(5,5,180,15);
		mainJPanel.add(trackingLabel);
		
		fullTrackRadio = new JRadioButton("   Full track");
		fullTrackRadio.setFont(font);
		fullTrackRadio.setBounds(10, 25, 200,15);
		fullTrackRadio.setBackground(Main.BROWNCOLOR);
		mainJPanel.add(fullTrackRadio);
		
		halfTrackRadio = new JRadioButton("   Half track");
		halfTrackRadio.setFont(font);
		halfTrackRadio.setBounds(10, 40, 200,15);
		halfTrackRadio.setBackground(Main.BROWNCOLOR);
		mainJPanel.add(halfTrackRadio);
		
		quarterTrackRadio = new JRadioButton("   Quarter track");
		quarterTrackRadio.setFont(font);
		quarterTrackRadio.setBounds(10, 55, 200,15);
		quarterTrackRadio.setBackground(Main.BROWNCOLOR);
		mainJPanel.add(quarterTrackRadio);
		
		unknownRadio = new JRadioButton("   Unknown");
		unknownRadio.setFont(font);
		unknownRadio.setBounds(10, 70, 200,15);
		unknownRadio.setBackground(Main.BROWNCOLOR);
		mainJPanel.add(unknownRadio);
		
		bgroup = new ButtonGroup();
		bgroup.add(fullTrackRadio);
		bgroup.add(halfTrackRadio);
		bgroup.add(quarterTrackRadio);
		bgroup.add(unknownRadio);
		
		JLabel soundLabel = new JLabel("Sound Field");
		soundLabel.setFont(bigFont);
		soundLabel.setBounds(5,105,180,15);
		mainJPanel.add(soundLabel);
		
		monoRadio = new JRadioButton("   Mono");  
		monoRadio.setFont(font);
		monoRadio.setBounds(10, 125, 200,15);
		monoRadio.setBackground(Main.BROWNCOLOR);
		mainJPanel.add(monoRadio);
		
		stereoRadio = new JRadioButton("   Stereo");
		stereoRadio.setFont(font);
		stereoRadio.setBounds(10, 140, 200,15);
		stereoRadio.setBackground(Main.BROWNCOLOR);
		mainJPanel.add(stereoRadio);
		
		unknownSoundRadio = new JRadioButton("   Unknown");
		unknownSoundRadio.setFont(font);
		unknownSoundRadio.setBounds(10, 155, 200,15);
		unknownSoundRadio.setBackground(Main.BROWNCOLOR);
		mainJPanel.add(unknownSoundRadio);
		
		bgroup1 = new ButtonGroup();
		bgroup1.add(monoRadio);
		bgroup1.add(stereoRadio);
		bgroup1.add(unknownSoundRadio);
		
		JLabel speedLabel = new JLabel("Recording Speed");
		speedLabel.setFont(bigFont);
		speedLabel.setBounds(5,190,180,15);
		mainJPanel.add(speedLabel);
		
		speed1Radio = new JRadioButton("   15/16 or 0.9375 ips (2.38 cm/s)");
		speed1Radio.setFont(font);
		speed1Radio.setBounds(10, 210, 250,15);
		speed1Radio.setBackground(Main.BROWNCOLOR);
		mainJPanel.add(speed1Radio);
		
		speed2Radio = new JRadioButton("   1 7/8 or 1.875 ips (4.76 cm/s)");
		speed2Radio.setFont(font);
		speed2Radio.setBounds(10, 225, 250,15);
		speed2Radio.setBackground(Main.BROWNCOLOR);
		mainJPanel.add(speed2Radio);
		
		speed3Radio = new JRadioButton("   3 3/4 or 3.75 ips (9.525 cm/s)");
		speed3Radio.setFont(font);
		speed3Radio.setBounds(10, 240, 250,15);
		speed3Radio.setBackground(Main.BROWNCOLOR);
		mainJPanel.add(speed3Radio);
		
		speed4Radio = new JRadioButton("   7 1/2 or 7.5 ips (19.05 cm/s)");
		speed4Radio.setFont(font);
		speed4Radio.setBounds(10, 255, 250,15);
		speed4Radio.setBackground(Main.BROWNCOLOR);
		mainJPanel.add(speed4Radio);
		
		speed5Radio = new JRadioButton("   15 ips (38.1 cm/s)");
		speed5Radio.setFont(font);
		speed5Radio.setBounds(10, 270, 250,15);
		speed5Radio.setBackground(Main.BROWNCOLOR);
		mainJPanel.add(speed5Radio);
		
		speed6Radio = new JRadioButton("   30 ips (76.2 cm/s)");
		speed6Radio.setFont(font);
		speed6Radio.setBounds(10, 285, 250,15);
		speed6Radio.setBackground(Main.BROWNCOLOR);
		mainJPanel.add(speed6Radio);
		
		speedUnknownRadio = new JRadioButton("   Unknown");
		speedUnknownRadio.setFont(font);
		speedUnknownRadio.setBounds(10, 300, 200,15);
		speedUnknownRadio.setBackground(Main.BROWNCOLOR);
		speedUnknownRadio.setSelected(true);
		mainJPanel.add(speedUnknownRadio);
		
		bgroup2 = new ButtonGroup();
		bgroup2.add(speed1Radio);
		bgroup2.add(speed2Radio);
		bgroup2.add(speed3Radio);
		bgroup2.add(speed4Radio);
		bgroup2.add(speed5Radio);
		bgroup2.add(speed6Radio);
		bgroup2.add(speedUnknownRadio);
		
		acceptButton = new JButton("Accept");
		acceptButton.setBounds(5,330,80,27);
		mainJPanel.add(acceptButton);
		acceptButton.setFont(font);
		acceptButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				updateTheUI();
				setVisible(false);
			}
		});

		JButton clearButton = new JButton("Clear");
		clearButton.setBounds(100,330,80,27);
		mainJPanel.add(clearButton);
		clearButton.setFont(font);
		clearButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				clearSelections();
			}
		});
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBounds(195,330,80,27);
		cancelButton.setFont(font);
		mainJPanel.add(cancelButton);
		cancelButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				setVisible(false);
			}
		});
		unknownRadio.setSelected(true);
		unknownSoundRadio.setSelected(true);
		selectCorrectButtons();
		this.setVisible(true);
	}
	
	private void clearSelections(){
		fullTrackRadio.setSelected(false);
		halfTrackRadio.setSelected(false);
		quarterTrackRadio.setSelected(false);
		unknownRadio.setSelected(true);
		monoRadio.setSelected(false);
		stereoRadio.setSelected(false);
		unknownSoundRadio.setSelected(true);
		speed1Radio.setSelected(false);
		speed2Radio.setSelected(false);
		speed3Radio.setSelected(false);
		speed4Radio.setSelected(false);
		speed5Radio.setSelected(false);
		speed6Radio.setSelected(false);
		speedUnknownRadio.setSelected(true);		
		//selectCorrectButtons();
	}
	
	private void selectCorrectButtons() {
		unknownSoundRadio.setSelected(true);
		unknownRadio.setSelected(true);
		if (Main.theData.mono) {
			monoRadio.setSelected(true);
		}
		if (Main.theData.stereo) {
			stereoRadio.setSelected(true);
		}
		if (Main.theData.fullTrack) {
			fullTrackRadio.setSelected(true);
		}
		if (Main.theData.halfTrack) {
			halfTrackRadio.setSelected(true);
		}
		if (Main.theData.quarterTrack) {
			quarterTrackRadio.setSelected(true);
		}
		if (Main.theData.unknownTrack) {
			unknownRadio.setSelected(true);
		}
		if (Main.theData.unknownSound) {
			unknownSoundRadio.setSelected(true);
		}
		if (Main.theData.speed1) {
			speed1Radio.setSelected(true);
		}
		if (Main.theData.speed2) {
			speed2Radio.setSelected(true);
		}
		if (Main.theData.speed3) {
			speed3Radio.setSelected(true);
		}
		if (Main.theData.speed4) {
			speed4Radio.setSelected(true);
		}
		if (Main.theData.speed5) {
			speed5Radio.setSelected(true);
		}
		if (Main.theData.speed6) {
			speed6Radio.setSelected(true);
		}
		if (Main.theData.unknownSpeed) {
			speedUnknownRadio.setSelected(true);
		}
	}
	
	private void updateTheUI() {
		Main.theData.mono = monoRadio.isSelected();
		Main.theData.stereo = stereoRadio.isSelected();
		Main.theData.fullTrack = fullTrackRadio.isSelected();
		Main.theData.halfTrack = halfTrackRadio.isSelected();
		Main.theData.quarterTrack = quarterTrackRadio.isSelected();
		Main.theData.unknownTrack = unknownRadio.isSelected();
		Main.theData.unknownSound = unknownSoundRadio.isSelected();
		Main.theData.speed1 = speed1Radio.isSelected();
		Main.theData.speed2 = speed2Radio.isSelected();
		Main.theData.speed3 = speed3Radio.isSelected();
		Main.theData.speed4 = speed4Radio.isSelected();
		Main.theData.speed5 = speed5Radio.isSelected();
		Main.theData.speed6 = speed6Radio.isSelected();
		Main.theData.unknownSpeed = speedUnknownRadio.isSelected();
		if (theParent instanceof Screen2ORTacetate) {
			Screen2ORTacetate ort = (Screen2ORTacetate)theParent;
			ort.summaryTextArea.setText("" + Main.theData.updateScoreBox());
		}
		if (theParent instanceof Screen2ORTpaper) {
			Screen2ORTpaper ort = (Screen2ORTpaper)theParent;
			ort.summaryTextArea.setText("" + Main.theData.updateScoreBox());
		}
		
		if (theParent instanceof Screen2ORTpolyester) {
			Screen2ORTpolyester ort = (Screen2ORTpolyester)theParent;
			ort.summaryTextArea.setText("" + Main.theData.updateScoreBox());
		}
		
		if (theParent instanceof Screen2ORTpvc) {
			Screen2ORTpvc ort = (Screen2ORTpvc)theParent;
			ort.summaryTextArea.setText("" + Main.theData.updateScoreBox());
		}
		
	}

}