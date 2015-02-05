package org.usfirst.frc.team2713.robot.commands;

import org.usfirst.frc.team2713.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team2713.robot.subsystems.GrabberSubsystem;
import org.usfirst.frc.team2713.robot.subsystems.LiftSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class commandBase extends Command{
	public static DriveSubsystem drive;
	public static LiftSubsystem lift;
	public static GrabberSubsystem grab;	
	public boolean isCreated;
	
	public void initLift() {
		lift = new LiftSubsystem();
	}
	
	public void initDrive() {
		if(drive == null){
			drive = new DriveSubsystem();
		}
		drive.initMechanumDrive();
		
	}
	
	public void initGrab() {
		grab = new GrabberSubsystem();
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
