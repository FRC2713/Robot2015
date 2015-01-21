package org.usfirst.frc.team2713.robot.commands;

import org.usfirst.frc.team2713.robot.inputs.XBoxController;
import org.usfirst.frc.team2713.robot.OI;
import org.usfirst.frc.team2713.robot.RobotMap;

public class moveGrabber extends commandBase{
	
	Boolean inOrOut;
	double triggerPolarity = OI.xbox.getX();
	
	public void getTiggerPolarity(){
		if(triggerPolarity <= -1){
			inOrOut = false;
		}
		else if(triggerPolarity >= 1){
			inOrOut = true;
		}
		else{
			inOrOut = null;
		}
	}
	
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
