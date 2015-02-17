package org.usfirst.frc.team2713.robot.commands;

import edu.wpi.first.wpilibj.Timer;

public class goForward extends commandBase{
	
	double distance;
	double speed;
	Timer time;
	
	public goForward(double speed1) {
		time = new Timer();
		speed = speed1;
		//drive.thisEncoder.reset();
	}
	
    protected void initialize() {
        time.reset();
        time.start();
    }
	
	protected void execute() {
		System.out.println("Go Forward Running ");
		drive.move(speed);
	}

	protected boolean isFinished() {
//        if(drive.thisEncoder.getDistance() > distance*12) {
//            drive.move(0);
//            return true;
//        }else {
//            return false;
//        }
    	  return false;
    }
	
}
