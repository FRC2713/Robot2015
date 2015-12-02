package org.usfirst.frc.team2713.robot.commands.autonomousCommands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team2713.robot.SubsystemStorage;
import org.usfirst.frc.team2713.robot.commands.GoForward;


public class AutonomousGoForward extends CommandGroup {
	
	public AutonomousGoForward(SubsystemStorage base){
		addSequential(new GoForward(10.5, base));
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
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