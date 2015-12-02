package org.usfirst.frc.team2713.robot.commands;

import org.usfirst.frc.team2713.robot.OI;
import org.usfirst.frc.team2713.robot.RobotMap;
import org.usfirst.frc.team2713.robot.SubsystemStorage;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;

public class MechanumDrive extends Command {

	Preferences prefs;
	int driverStationNum;
	double SCALER;
	double DEADBAND;
	double POLARITY;
	double leftXSpeed;
	double leftYSpeed;
	double rightXSpeed;
	double suggestedLeftXSpeed;
	double suggestedLeftYSpeed;
	double suggestedRightXSpeed;
	private SubsystemStorage base;

	public MechanumDrive(SubsystemStorage base) {
		this.base = base;
		requires(this.base.drive);
		prefs = Preferences.getInstance();
	}

	protected void execute() {
		driverStationNum = prefs.getInt("DriverStationNumber", 2);
		SCALER = prefs.getDouble("SCALER", 0.6);
		DEADBAND = prefs.getDouble("DEADBAND", 0.10);
		POLARITY = -1;
		base.drive.roboDrive.setSafetyEnabled(false);
		suggestedLeftXSpeed = OI.xbox.getRightX()  * RobotMap.drive_Scaler;
		suggestedLeftYSpeed = -(OI.xbox.getLeftY()) * RobotMap.drive_Scaler;
		suggestedRightXSpeed = OI.xbox.getLeftX() * RobotMap.drive_Scaler;
		leftXSpeed = leftXSpeed * (1 - RobotMap.drive_Slow_Down) + suggestedLeftXSpeed * RobotMap.drive_Slow_Down;
		leftYSpeed = leftYSpeed * (1 - RobotMap.drive_Slow_Down) + suggestedLeftYSpeed * RobotMap.drive_Slow_Down;
		//leftXSpeed = approachSpeed(leftXSpeed, suggestedLeftXSpeed);
		//leftYSpeed = approachSpeed(leftYSpeed, suggestedLeftYSpeed);
		rightXSpeed = rightXSpeed * (1 - .5) + suggestedRightXSpeed * .5;
		base.drive.CartesianDrive(leftXSpeed, leftYSpeed, rightXSpeed, DEADBAND);
	}
	
	public static double approachSpeed(double current, double suggested) {
		if(current + .01 > suggested) {
			 return current;
		} else {
			return current = current + .01;
		}
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
}
