package org.usfirst.frc.team2713.robot.commands;

public class changeLevel extends commandBase {

	Boolean upOrDown; // True is up, False is down

	public changeLevel(Boolean upOrDown1) {
		upOrDown = upOrDown1;
	}

	protected void initialize() {

	}

	protected void execute() {
		if (upOrDown == true) {
			lift.lift(1);
		} else {
			lift.lift(-1);
		}
	}

	protected boolean isFinished() {
		if(upOrDown == false && lift.currentLevel - 1 < 0) {
			return true;
		}
		if (upOrDown == true) {
			if (lift.limitSwitches[lift.currentLevel + 1].get() == true) {
				lift.currentLevel++;
				return true;
			}
		} else {
			if (lift.limitSwitches[lift.currentLevel - 1].get() == true) {
				lift.currentLevel--;
				return true;
			}
		}
		return false;
	}

	protected void end() {

	}

	protected void interrupted() {

	}

}
