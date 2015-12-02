package org.usfirst.frc.team2713.robot.commands;

import org.usfirst.frc.team2713.robot.Robot;
import org.usfirst.frc.team2713.robot.SubsystemStorage;

import edu.wpi.first.wpilibj.command.Command;

public class ChangeLevel extends Command {

	Boolean upOrDown; // True is up, False is down
	double lastVoltage = 0;
	double endVoltage = .3;
	SubsystemStorage base;

	public ChangeLevel(Boolean upOrDown1, SubsystemStorage base) {
		upOrDown = upOrDown1;
		this.base = base;
	}

	protected void initialize() {

	}

	protected void execute() {
		lastVoltage = (lastVoltage + endVoltage) / 2;
		base.grab.grab.getProperController().get();
		if (upOrDown != null && (upOrDown || !upOrDown) && ((!base.lift.toBeReleased) || Robot.ignoreReleased)) {
			if (upOrDown == null) {

			} else if (upOrDown == true && !base.lift.atTop) {
				base.lift.stopPID = true;
				base.lift.atBottom = false;
				base.lift.lift(lastVoltage * 2);
			} else if (upOrDown == false && !base.lift.atBottom) {
				base.lift.stopPID = true;
				base.lift.atTop = false;
				base.lift.lift(-lastVoltage);
			}
		}
		if (upOrDown == null) {
			base.lift.toBeReleased = false;
			base.lift.lift(0);
			if (!base.lift.pidStarted) {
				new PidCommand(base.lift.thisEncoder.getDistance(), base).start();
			}
		}
	}

	protected boolean isFinished() { // Make it so you can go down if you don't touch the bottom level
		if (upOrDown == null) {
			base.lift.lift(0);
			if (!base.lift.pidStarted) {
				new PidCommand(base.lift.thisEncoder.getDistance(), base).start();
			}
			return true; // Limit Switch to tell when you are at the bottom, and reset the counter
		}
		if (upOrDown == false && !base.lift.limitSwitchBottom.get()) {
			base.lift.lift(0);
			base.lift.atBottom = true;
			base.lift.currentLevel = 0;
			base.lift.thisEncoder.reset();
			base.lift.toBeReleased = true;
			return true;
		}
		if (base.lift.atBottom == true && upOrDown == false && base.lift.thisEncoder.getDistance() <= 0) {
			base.lift.lift(0);
			base.lift.atBottom = true;
			base.lift.currentLevel = 0;
			base.lift.thisEncoder.reset();
			base.lift.toBeReleased = true;
			return true;
		}
		if (upOrDown == true && base.lift.limitSwitchTop.get()) {
			base.lift.atTop = true;
			base.lift.currentLevel = 6;
			base.lift.lift(0);
			base.lift.toBeReleased = true;
			if (!base.lift.pidStarted) {
				new PidCommand(base.lift.thisEncoder.getDistance(), base).start();
			}
			return true;
		}
		if (upOrDown == true) {
			if (base.lift.lastPossition < 5) {
				if (base.lift.thisEncoder.getDistance() >= base.lift.totesLocation[base.lift.lastPossition + 1]) {
					base.lift.lastPossition++;
					base.lift.lift(0);
					base.lift.toBeReleased = true;
					if (!base.lift.pidStarted) {
						new PidCommand(base.lift.thisEncoder.getDistance(), base).start();
					}
					return true;
				}
			}
		}
		if (upOrDown == false && base.lift.lastPossition - 1 >= 0 && base.lift.thisEncoder.getDistance() <= base.lift.totesLocation[base.lift.lastPossition - 1]) {
			base.lift.lastPossition--;
			base.lift.lift(0);
			base.lift.toBeReleased = true;
			if (!base.lift.pidStarted) {
				new PidCommand(base.lift.thisEncoder.getDistance(), base).start();
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
