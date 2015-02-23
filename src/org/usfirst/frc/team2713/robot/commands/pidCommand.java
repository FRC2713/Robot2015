package org.usfirst.frc.team2713.robot.commands;

public class pidCommand extends commandBase {

	double startingPoint;

	public pidCommand(double startingPoint) {
		lift.pidStarted = true;
		lift.stopPID = false;
		this.startingPoint = startingPoint;
	}

	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (!lift.stopPID) {
			if (lift.thisEncoder.getDistance() < startingPoint) {
				if(lift.thisEncoder.getDistance() - startingPoint > -.7) {
					lift.lift(.07);
				} else {
					lift.lift(lift.thisEncoder.getDistance() - startingPoint * -.1);
				}
			}
			if (lift.thisEncoder.getDistance() > startingPoint) {
				if(lift.thisEncoder.getDistance() - startingPoint < .7) {
					lift.lift(-.02);
				} else {
					lift.lift(lift.thisEncoder.getDistance() - startingPoint * -.02857);
				}
				System.out.println("Adjusting Down");
			}
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (lift.stopPID) {
			lift.lift(0);
			lift.pidStarted = false;
			return true;
		}
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		lift.pidStarted = false;
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		lift.pidStarted = false;
	}

}
