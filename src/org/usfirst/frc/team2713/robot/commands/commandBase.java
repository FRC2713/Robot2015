package org.usfirst.frc.team2713.robot.commands;

import org.usfirst.frc.team2713.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team2713.robot.subsystems.LiftSubsystem;

public class commandBase {
	public static DriveSubsystem drive;
	public static LiftSubsystem lift = new LiftSubsystem();
	
	public void init() {
		lift = new LiftSubsystem();
		drive = new DriveSubsystem();
	}
}
