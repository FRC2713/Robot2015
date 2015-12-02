package org.usfirst.frc.team2713.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class PauseCommand extends Command {

	double time;
	Timer timer;
	
	public PauseCommand(double Time){
		timer = new Timer();
		time = Time;
		timer.reset();
		timer.start();
	}
	
	protected void initialize() {
		timer.reset();
		timer.start();
	}
	
	protected void execute() {

	}
	
	protected boolean isFinished() {
		if (timer.get() > time) {
			return true;
		}
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
