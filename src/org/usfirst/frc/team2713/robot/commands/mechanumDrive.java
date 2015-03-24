package org.usfirst.frc.team2713.robot.commands;

import org.usfirst.frc.team2713.robot.OI;

import edu.wpi.first.wpilibj.DriverStation;
import org.usfirst.frc.team2713.robot.OI;

import edu.wpi.first.wpilibj.Preferences;

public class mechanumDrive extends commandBase {

	Preferences prefs;
	int driverStationNum;
	double SCALER;
	double DEADBAND;
	double POLARITY;
	double leftXSpeed;
	double leftYSpeed;
	double rightXSpeed;


	public mechanumDrive() {
		requires(drive);
		prefs = Preferences.getInstance();
	}

	protected void execute() {
		driverStationNum = prefs.getInt("DriverStationNumber", 2);
		SCALER = prefs.getDouble("SCALER", 0.6);
		DEADBAND = prefs.getDouble("DEADBAND", 0.05);
		POLARITY = -1;
		drive.roboDrive.setSafetyEnabled(false);
		leftXSpeed = -OI.xbox.getRightX();
		leftYSpeed = (OI.xbox.getLeftY() * SCALER);
		rightXSpeed = -OI.xbox.getLeftX();
		drive.CartesianDrive(leftXSpeed, leftYSpeed, rightXSpeed, DEADBAND);

	}
}
