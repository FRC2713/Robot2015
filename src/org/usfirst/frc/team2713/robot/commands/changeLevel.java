package org.usfirst.frc.team2713.robot.commands;

import org.usfirst.frc.team2713.robot.RobotMap;

public class changeLevel extends commandBase {

	Boolean upOrDown; // True is up, False is down

	public changeLevel(Boolean upOrDown1) {
		upOrDown = upOrDown1;
	}

	protected void initialize() {

	}

	protected void execute() {
		if (upOrDown == null) {
			lift.lift(0);
		} else if (upOrDown == true) {
			lift.lift(1);
		} else if (upOrDown == false) {
			lift.lift(-1);
		}
	}

	protected boolean isFinished() { //Make it so you can go down if you don't touch the bottom level
		if (upOrDown == null) {
			return true;
		}
		if (upOrDown == true && lift.currentLevel + 1 >= RobotMap.NUMBER_OF_LIMIT_SWITCHES) {
			lift.lift(0);
			return true;
		}
		if (upOrDown == false && lift.currentLevel - 1 < 0) {
			lift.lift(0);
			return true;
		}
		if (upOrDown == true) {
			if (lift.limitSwitches[lift.currentLevel + 1].get() == false) {
				lift.currentLevel++;
				lift.lift(0);
				return true;
			}
		} else {
			if (lift.limitSwitches[lift.currentLevel - 1].get() == false) {
				lift.currentLevel--;
				lift.lift(0);
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
