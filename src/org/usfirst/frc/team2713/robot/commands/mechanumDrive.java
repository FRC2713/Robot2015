package org.usfirst.frc.team2713.robot.commands;

import org.usfirst.frc.team2713.robot.*;
import org.usfirst.frc.team2713.robot.OI;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.DriverStation;
import org.usfirst.frc.team2713.robot.RobotMap;

public class mechanumDrive extends commandBase{
	
	Preferences prefs;
	double SCALER;
	double DEADBAND;
	double POLARITY;
	
	public mechanumDrive(){
	prefs = Preferences.getInstance();
	}
	
	protected void execute() {

		SCALER = prefs.getDouble("SCALER", 0.6);
		DEADBAND = prefs.getDouble("DEADBAND",0.1);
		POLARITY = -1;
		drive.roboDrive.setSafetyEnabled(false);
    	drive.CartesianDrive(OI.xbox.getX()*SCALER*POLARITY, OI.xbox.getY()*SCALER,OI.xbox.getRightX()*SCALER*POLARITY,DEADBAND);
	}
	
}
