package org.usfirst.frc.team2713.robot;

import org.usfirst.frc.team2713.robot.subsystems.DriveSubsystem;

import org.usfirst.frc.team2713.robot.subsystems.GrabberSubsystem;
import org.usfirst.frc.team2713.robot.subsystems.LiftSubsystem;

public class SubsystemStorage {
	
	public DriveSubsystem drive;
	public LiftSubsystem lift;
	public GrabberSubsystem grab;
	public boolean isCreated;

	public SubsystemStorage() {
		drive = new DriveSubsystem(this);
		lift = new LiftSubsystem(this);
		grab = new GrabberSubsystem(this);
	}
}
