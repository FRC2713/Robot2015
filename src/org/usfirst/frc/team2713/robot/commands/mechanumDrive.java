package org.usfirst.frc.team2713.robot.commands;


import org.usfirst.frc.team2713.robot.OI;

import edu.wpi.first.wpilibj.DriverStation;
import org.usfirst.frc.team2713.robot.OI;
import org.usfirst.frc.team2713.robot.subsystems.Passer;

import edu.wpi.first.wpilibj.Preferences;

public class mechanumDrive extends commandBase{
	
	Preferences prefs;
	int driverStationNum = 1;
	double SCALER;
	double DEADBAND;
	double POLARITY;
	
	public mechanumDrive() {
		requires(drive);
		prefs = Preferences.getInstance();
	}
	
	protected void execute() {
		driverStationNum = Passer.getNum();
		SCALER = prefs.getDouble("SCALER", 0.6);
		DEADBAND = prefs.getDouble("DEADBAND",0.1);
		POLARITY = -1;
		drive.roboDrive.setSafetyEnabled(false);
		
		switch (driverStationNum) {
		case 1:
           drive.CartesianDrive(OI.joystick.getX()*POLARITY,OI.joystick.getY()*POLARITY, OI.joystick.getTwist()*POLARITY, DEADBAND);
            
            break; //Positive on both controllers
        case 2:
        	drive.CartesianDrive(OI.xbox.getX()*SCALER*POLARITY, OI.xbox.getY()*SCALER,OI.xbox.getRightX()*SCALER*POLARITY,DEADBAND);
            
            break; //positive on both controllers
 
	}
	
}
}
