package org.usfirst.frc.team2713.robot.commands;

import edu.wpi.first.wpilibj.Timer;

public class goForward extends commandBase{
	
	double distance;
	Timer time;
	
	public goForward(double distance1) {
		time = new Timer();
		distance = distance1;
		//drive.thisEncoder.reset();
	}
	
    protected void initialize() {
        time.reset();
        time.start();
    }
	
	protected void execute() {
		drive.move(.7);
	}

	protected boolean isFinished() {
        if(drive.thisEncoder.getDistance() > distance*12) {
            drive.move(0);
            return true;
        }else {
            return false;
        }
    }
	
}
