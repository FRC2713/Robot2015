package org.usfirst.frc.team2713.robot.commands;

import org.usfirst.frc.team2713.robot.RobotMap;
import org.usfirst.frc.team2713.robot.SubsystemStorage;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class CloseOrOpenGrabber extends Command {

	double direction;
	Timer time;
	SubsystemStorage base;
	
	public CloseOrOpenGrabber(double direction1, SubsystemStorage base) { //-1 is close, 1 is open
		this.base = base;
		time = new Timer();
		time.reset();
		time.start();
		direction = direction1;
	}
	
	protected void initialize() {
		time.reset();
		time.start();
	}
	
	protected void execute() {
		base.grab.setLift(direction * .33);
	}
	
	protected boolean isFinished() {
		if ((!base.grab.armClosed.get()) && !base.grab.armClosed2.get() && direction < 0) {
			return true;
		}
		if(time.get() > RobotMap.TIME_TO_CLOSE_OR_OPEN) {
			base.grab.setLift(0);
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
