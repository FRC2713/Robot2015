package org.usfirst.frc.team2713.robot.commands;

public class changeLevel extends commandBase {

	Boolean upOrDown; // True is up, False is down

	public changeLevel(Boolean upOrDown1) {
		upOrDown = upOrDown1;
	}

	protected void initialize() {

	}

	protected void execute() {
		lift.thisEncoder.reset();
		if (upOrDown == null) {
			lift.lift(0);
		} else if (upOrDown == true) {
			lift.lift(1);
		} else if (upOrDown == false) {
			lift.lift(-1);
		}
		lift.distanceTraveled += lift.thisEncoder.getDistance();
	}

	protected boolean isFinished() { // Make it so you can go down if you don't touch the bottom level
		if (upOrDown == null) {
			lift.lift(0);
			return true; // Limit Switch to tell when you are at the bottom, and reset the counter
		}
		if (upOrDown == false && lift.distanceTraveled <= 0) {
			lift.lift(0);
			return true;
		}
		if (upOrDown == true && lift.heightOfArm >= lift.distanceTraveled) {
			lift.lift(0);
			return true;
		}
		if (upOrDown == true && lift.distanceTraveled >= lift.totesLocation[lift.lastPossition + 1]) {
			lift.lastPossition++;
			lift.lift(0);
			return true;
		}
		if (upOrDown == false && lift.distanceTraveled <= lift.totesLocation[lift.lastPossition - 1]) {
			lift.lastPossition--;
			lift.lift(0);
			return true;
		}
		return false;
	}

	protected void end() {

	}

	protected void interrupted() {

	}

}
