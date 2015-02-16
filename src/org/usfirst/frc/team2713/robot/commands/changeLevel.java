package org.usfirst.frc.team2713.robot.commands;

public class changeLevel extends commandBase {

	Boolean upOrDown; // True is up, False is down

	public changeLevel(Boolean upOrDown1) {
		upOrDown = upOrDown1;
	}

	protected void initialize() {

	}

	protected void execute() {
		System.out.println("Change Level Running ");
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
			return true;
		}
		if (lift.atBottom == true && upOrDown == false && lift.thisEncoder.getDistance() <= 0) {
			lift.lift(0);
			lift.atBottom = true;
			lift.currentLevel = 0;
			lift.thisEncoder.reset();
		}
		if (upOrDown == true && !lift.limitSwitchTop.get()) {
			lift.atTop = true;
			lift.currentLevel = 6;
			lift.lift(0);
			return true;
		}
		if (upOrDown == true) {
			if (lift.lastPossition < 5) {
				if (lift.thisEncoder.getDistance() >= lift.totesLocation[lift.lastPossition + 1]) {
					lift.lastPossition++;
					System.out.println(lift.lastPossition);
					lift.lift(0);
					return true;
				}
			}
		}
		if (upOrDown == false && lift.lastPossition - 1 >= 0 && lift.thisEncoder.getDistance() <= lift.totesLocation[lift.lastPossition - 1]) {
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
