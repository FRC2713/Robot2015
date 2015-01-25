package org.usfirst.frc.team2713.robot.commands;

import org.usfirst.frc.team2713.robot.OI;
import org.usfirst.frc.team2713.robot.RobotMap;

public class mechanumDrive extends commandBase{
	
	protected void execute() {
    	drive.roboDrive.mecanumDrive_Cartesian(Math.pow(OI.xbox.getX()*RobotMap.DRIVE_SCALER, RobotMap.DRIVE_DEADBAND), Math.pow(OI.xbox.getY()*RobotMap.DRIVE_SCALER, RobotMap.DRIVE_DEADBAND), Math.pow(OI.xbox.getRightX()*RobotMap.DRIVE_SCALER, RobotMap.DRIVE_DEADBAND), Math.pow(OI.xbox.getRightY()*RobotMap.DRIVE_SCALER, RobotMap.DRIVE_DEADBAND));
	}
	
}
