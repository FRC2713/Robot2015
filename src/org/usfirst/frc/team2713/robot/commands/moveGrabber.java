package org.usfirst.frc.team2713.robot.commands;

import org.usfirst.frc.team2713.robot.OI;
import org.usfirst.frc.team2713.robot.RobotMap;

public class moveGrabber extends commandBase {

	Boolean inOrOut;
	double triggerPolarity = OI.xbox.getTriggerAxis();

	public void getTiggerPolarity() {
		if (OI.xbox.getTriggerAxis() != 0 && OI.xbox.getZ() != 0) {
			inOrOut = null;
			triggerPolarity = 0;
		} else if (OI.xbox.getTriggerAxis() != 0) {
			inOrOut = true;
			triggerPolarity = OI.xbox.getTriggerAxis();
		} else if (OI.xbox.getZ() != 0) {
			inOrOut = false;
			triggerPolarity = OI.xbox.getZ();
		} else if(OI.xbox.getTriggerAxis() == 0 && OI.xbox.getZ() == 0) {
			triggerPolarity = 0;
			inOrOut = null;
		}
	}

	public moveGrabber() {
	}

	protected void initialize() {

	}

	protected void execute() {
		triggerPolarity = OI.xbox.getTriggerAxis();
		getTiggerPolarity();
		if (grab.grab.CANOrTalon) {
			// if (grab.getAmps() <= RobotMap.GRAB_VOLTAGE_LIMIT) {
			if (inOrOut != null && inOrOut == true) {
				grab.setLift(1);
			} else if (inOrOut != null && inOrOut == false) {
				grab.setLift(-1);
			} else {
				grab.setLift(0);
			}
			// }
		} else {
			if (grab.getRaw() <= RobotMap.GRAB_RAW_LIMIT) {
				if (inOrOut != null && inOrOut == true) {
					grab.setLift(1);
				} else if (inOrOut != null && inOrOut == false) {
					grab.setLift(-1);
				} else {
					grab.setLift(0);
				}
			}
		}
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {

	}

	protected void interrupted() {

	}

}
