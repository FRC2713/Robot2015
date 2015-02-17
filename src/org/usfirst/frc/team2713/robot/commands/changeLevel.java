package org.usfirst.frc.team2713.robot.commands;

public class changeLevel extends commandBase {

	Boolean upOrDown; // True is up, False is down
	double lastVoltage = 0;
	double endVoltage = 1;

	public changeLevel(Boolean upOrDown1) {
		upOrDown = upOrDown1;
	}

	protected void initialize() {

	}

	protected void execute() {
		lastVoltage = (lastVoltage + endVoltage)/2;
		if (upOrDown != null && (upOrDown || !upOrDown) && !lift.toBeReleased) {
			if (upOrDown == null) {
				lift.lift(0);
			} else if (upOrDown == true && !lift.atTop) {
				lift.atBottom = false;
				lift.lift(1);
			} else if (upOrDown == false && !lift.atBottom) {
				lift.atTop = false;
				lift.lift(-1);
			}
		}
		if(upOrDown == null) {
			lift.toBeReleased = false;
		}
		System.out.println(upOrDown);
	}

	protected boolean isFinished() { // Make it so you can go down if you don't touch the bottom level
		if (upOrDown == null) {
			lift.lift(0);
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
		if (upOrDown == true && !lift.limitSwitchTop.get()) {
			lift.atTop = true;
			lift.currentLevel = 6;
			lift.lift(0);
			lift.toBeReleased = true;
			return true;
		}
		if (upOrDown == true) {
			if (lift.lastPossition < 5) {
				if (lift.thisEncoder.getDistance() >= lift.totesLocation[lift.lastPossition + 1]) {
					System.out.println("Done Up");
					lift.lastPossition++;
					lift.lift(0);
					lift.toBeReleased = true;
					return true;
				}
			}
		}
		if (upOrDown == false && lift.lastPossition - 1 >= 0 && lift.thisEncoder.getDistance() <= lift.totesLocation[lift.lastPossition - 1]) {
			lift.lastPossition--;
			lift.lift(0);
			lift.toBeReleased = true;
			return true;
		}
		return false;
	}

	protected void end() {

	}

	protected void interrupted() {

	}

}
