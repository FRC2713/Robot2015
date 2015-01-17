package org.usfirst.frc.team2713.robot.commands;

import org.usfirst.frc.team2713.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team2713.robot.subsystems.LiftSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class commandBase extends Command{
	public static DriveSubsystem drive;
	public static LiftSubsystem lift = new LiftSubsystem();
	
	public void init() {
		lift = new LiftSubsystem();
		drive = new DriveSubsystem();
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
