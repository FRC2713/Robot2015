package org.usfirst.frc.team2713.robot.commands;

import edu.wpi.first.wpilibj.Timer;

public class Turn extends CommandBase {

	Timer time;
	double radials;
	double timeElapsed;
	double scaler;

	public Turn(double radians, boolean leftOrRight) {
		time = new Timer();
		time.reset();
		time.start();
		this.radials = radians;
		timeElapsed = radians / Math.PI/2 * .65;
		if(leftOrRight) {
			scaler = -1;
		} else {
			scaler = 1;
		}
	}

	protected void execute() {
		drive.rotate(.7 * scaler);
	}
	
	protected void initialize() {
		time.reset();
		time.start();
	}

	protected boolean isFinished() {
		if(time.get() > timeElapsed) {
			drive.move(0);
			return true;
		}
		return false;
	}

}
