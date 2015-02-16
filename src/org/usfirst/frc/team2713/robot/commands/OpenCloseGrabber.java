package org.usfirst.frc.team2713.robot.commands;

public class OpenCloseGrabber extends commandBase {

	public double polarity;

	public OpenCloseGrabber(double polarity1) {
		polarity1 = polarity;
	}

	protected void initialize() {

	}

	protected void execute() {
		grab.setLift(polarity);
		System.out.println("Running");
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		grab.setLift(0);
	}

	protected void interrupted() {
		grab.setLift(0);
	}

}
