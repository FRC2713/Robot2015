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

	public mechanumDrive() {
		requires(drive);
		prefs = Preferences.getInstance();
	}

	protected void execute() {
		driverStationNum = prefs.getInt("DriverStationNumber", 2);
		SCALER = prefs.getDouble("SCALER", 0.6);
		DEADBAND = prefs.getDouble("DEADBAND", 0.1);
		POLARITY = -1;
		drive.roboDrive.setSafetyEnabled(false);
		switch (driverStationNum) {
		case 1:
			drive.CartesianDrive(OI.joystick.getX() * POLARITY * Math.abs(OI.joystick.getX() * POLARITY), -(OI.joystick.getY() * POLARITY * Math.abs(OI.joystick.getY() * POLARITY)),
					-(OI.joystick.getTwist() * POLARITY * Math.abs(OI.joystick.getTwist() * POLARITY)), DEADBAND);

			break; // Positive on both controllers
		case 2:
			drive.CartesianDrive(OI.xbox.getX() * SCALER * POLARITY * Math.abs(OI.xbox.getX() * SCALER * POLARITY), OI.xbox.getY() * SCALER * Math.abs(OI.xbox.getY() * SCALER), OI.xbox.getRightX()
					* SCALER * POLARITY * Math.abs(OI.xbox.getRightX() * SCALER * POLARITY), DEADBAND);

			break; // positive on both controllers

		}

	}
}
