package org.usfirst.frc.team2713.robot.commands;

public class changeLevel extends commandBase {

	Boolean upOrDown; // True is up, False is down
	double lastVoltage = 0;
	double endVoltage = .25;

	public changeLevel(Boolean upOrDown1) {
		upOrDown = upOrDown1;
	}

	protected void initialize() {

	}

	protected void execute() {
		lastVoltage = (lastVoltage + endVoltage) / 2;
		if (upOrDown != null && (upOrDown || !upOrDown) && !lift.toBeReleased) {
			if (upOrDown == null) {

			} else if (upOrDown == true && !lift.atTop) {
				lift.stopPID = true;
				lift.atBottom = false;
				lift.lift(lastVoltage);
			} else if (upOrDown == false && !lift.atBottom) {
				lift.stopPID = true;
				lift.atTop = false;
				lift.lift(-lastVoltage);
			}
		}
		if (upOrDown == null) {
			lift.toBeReleased = false;
			lift.lift(0);
			if (!lift.pidStarted) {
				new pidCommand(lift.thisEncoder.getDistance()).start();
			}
		}
	}

	protected boolean isFinished() { // Make it so you can go down if you don't touch the bottom level
		if (upOrDown == null) {
			lift.lift(0);
			if (!lift.pidStarted) {
				new pidCommand(lift.thisEncoder.getDistance()).start();
			}
			return true; // Limit Switch to tell when you are at the bottom, and reset the counter
		}
		if (upOrDown == false && !lift.limitSwitchBottom.get()) {
			lift.lift(0);
			lift.atBottom = true;
			lift.currentLevel = 0;
			lift.thisEncoder.reset();
			lift.toBeReleased = true;
			return true;
		}
		if (lift.atBottom == true && upOrDown == false && lift.thisEncoder.getDistance() <= 0) {
			lift.lift(0);
			lift.atBottom = true;
			lift.currentLevel = 0;
			lift.thisEncoder.reset();
			lift.toBeReleased = true;
			return true;
		}
		if (upOrDown == true && lift.limitSwitchTop.get()) {
			lift.atTop = true;
			lift.currentLevel = 6;
			lift.lift(0);
			lift.toBeReleased = true;
			if (!lift.pidStarted) {
				new pidCommand(lift.thisEncoder.getDistance()).start();
			}
			return true;
		}
		if (upOrDown == true) {
			if (lift.lastPossition < 5) {
				if (lift.thisEncoder.getDistance() >= lift.totesLocation[lift.lastPossition + 1]) {
					lift.lastPossition++;
					lift.lift(0);
					lift.toBeReleased = true;
					if (!lift.pidStarted) {
						new pidCommand(lift.thisEncoder.getDistance()).start();
					}
					return true;
				}
			}
		}
		if (upOrDown == false && lift.lastPossition - 1 >= 0 && lift.thisEncoder.getDistance() <= lift.totesLocation[lift.lastPossition - 1]) {
			lift.lastPossition--;
			lift.lift(0);
			lift.toBeReleased = true;
			if (!lift.pidStarted) {
				new pidCommand(lift.thisEncoder.getDistance()).start();
			}
			return true;
		}
		return false;
	}

	protected void end() {

	}

	protected void interrupted() {

	}

}
