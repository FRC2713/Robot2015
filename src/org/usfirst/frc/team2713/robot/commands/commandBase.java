package org.usfirst.frc.team2713.robot.commands;

import org.usfirst.frc.team2713.robot.subsystems.DriveSubsystem;

import org.usfirst.frc.team2713.robot.subsystems.GrabberSubsystem;
import org.usfirst.frc.team2713.robot.subsystems.LiftSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class commandBase extends Command {
	public static DriveSubsystem drive = new DriveSubsystem();
	public static LiftSubsystem lift = new LiftSubsystem();
	public static GrabberSubsystem grab = new GrabberSubsystem();
	public boolean isCreated;

	public commandBase() {
		
	}
	
	public void initLift() {
		if (lift == null) {
			//lift = new LiftSubsystem();
		}
	}

	public void initDrive() {
		if (drive == null) {
			//drive = new DriveSubsystem();
		}
	}

	public void initGrab() {
		if (grab == null) {
			//grab = new GrabberSubsystem();
		}
	}

	protected void initialize() {

	}

	protected void execute() {

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
