package org.usfirst.frc.team2713.robot.commands;

import org.usfirst.frc.team2713.robot.OI;
import org.usfirst.frc.team2713.robot.RobotMap;

public class moveGrabber extends commandBase{
	
	Boolean inOrOut;
	double triggerPolarity = OI.xbox.getTriggerAxis();
	
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
	
	public moveGrabber() {
		requires(commandBase.grab);
	}
	
    protected void initialize() {
    	
    }

    protected void execute() {
    	triggerPolarity = OI.xbox.getTriggerAxis();
    	if(inOrOut == true) {
    		grab.setLift(1);
    	} else if(inOrOut == false) {
    		grab.setLift(-1);    		
    	} else {
    		grab.setLift(0);    			
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
