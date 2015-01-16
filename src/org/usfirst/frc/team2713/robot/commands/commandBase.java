package org.usfirst.frc.team2713.robot.commands;

import org.usfirst.frc.team2713.robot.subsystems.DriveSubsystem;

public class commandBase {
	public DriveSubsystem drive;
	
	public void init() {
		drive = new DriveSubsystem();
	}
}
