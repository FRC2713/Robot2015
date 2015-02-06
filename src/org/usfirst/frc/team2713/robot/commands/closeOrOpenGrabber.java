package org.usfirst.frc.team2713.robot.commands;

import org.usfirst.frc.team2713.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;

public class closeOrOpenGrabber extends commandBase{

	int direction;
	Timer time;
	
	public closeOrOpenGrabber(int direction1) { //-1 is close, 1 is open
		time = new Timer();
		time.reset();
		time.start();
		direction = direction1;
	}
	
	protected void execute() {
		grab.setLift(direction);
	}
	
	protected boolean isFinished() {
		if(grab.grab.CANOrTalon) {
			if(grab.getAmps() > RobotMap.GRAB_VOLTAGE_LIMIT) {
				return true;
			}
		} else {
			if(grab.getRaw() > RobotMap.GRAB_RAW_LIMIT) {
				return true;
			}
		}
		if(time.get() > RobotMap.TIME_TO_CLOSE_OR_OPEN) {
			return true;
		}
		return false;
	}
	
}
