package org.usfirst.frc.team2713.robot.commands;

import org.usfirst.frc.team2713.robot.SubsystemStorage;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Turn extends Command {

	Timer time;
	double timeElapsed;
	private SubsystemStorage base;

	public Turn(boolean leftOrRight, SubsystemStorage base) {
		time = new Timer();
		time.reset();
		time.start();
		this.base = base;
	}

	protected void execute() {
		base.drive.rotate(.7);
	}
	
	protected void initialize() {
		time.reset();
		time.start();
	}

	protected boolean isFinished() {
		if(time.get() > .65) {
			base.drive.move(0);
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
