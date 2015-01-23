package org.usfirst.frc.team2713.robot.commands;

import org.usfirst.frc.team2713.robot.OI;

public class mechanumDrive extends commandBase{
	
	protected void execute() {
    	drive.roboDrive.mecanumDrive_Cartesian(OI.xbox.getX(), OI.xbox.getY(), OI.xbox.getZ(), 0);
	}
	
}
