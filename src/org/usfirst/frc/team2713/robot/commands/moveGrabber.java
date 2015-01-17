package org.usfirst.frc.team2713.robot.commands;

import org.usfirst.frc.team2713.robot.RobotMap;

public class moveGrabber extends commandBase{
	
	Boolean inOrOut;
	
	public moveGrabber(Boolean inOrOut1) {
		requires(commandBase.grab);
		inOrOut = inOrOut1;
	}
	
    protected void initialize() {
    	
    }

    protected void execute() {
    	if(inOrOut == true) {
    		grab.setLift(1);
    	} else {
    		grab.setLift(-1);    		
    	}
    }

    protected boolean isFinished() {
    	if(grab.getAmps() >= RobotMap.GRAB_VOLTAGE_LIMIT) {
    		return true;
    	}
        return false;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	
    }
	
}
