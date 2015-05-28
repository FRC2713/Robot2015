package org.usfirst.frc.team2713.robot.commands;

import edu.wpi.first.wpilibj.Timer;

public class Turn extends CommandBase {

	Timer time;
	double timeElapsed;

	public Turn(boolean leftOrRight) {
		time = new Timer();
		time.reset();
		time.start();
	}

	protected void execute() {
		drive.rotate(.7);
	}
	
	protected void initialize() {
		time.reset();
		time.start();
	}

	protected boolean isFinished() {
		if(time.get() > .65) {
			drive.move(0);
			return true;
		}
		return false;
	}

}
