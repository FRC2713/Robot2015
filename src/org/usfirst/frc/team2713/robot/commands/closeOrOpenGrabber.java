package org.usfirst.frc.team2713.robot.commands;

import org.usfirst.frc.team2713.robot.RobotMap;

public class closeOrOpenGrabber extends commandBase{

	int direction;
	
	public closeOrOpenGrabber(int direction1) { //-1 is close, 1 is open
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
		return false;
	}
	
}
