package org.usfirst.frc.team2713.robot.commands;

import org.usfirst.frc.team2713.robot.OI;

public class MoveGrabber extends CommandBase {

	Boolean inOrOut;
	double triggerPolarity = OI.xbox.getTriggerAxis();

	public MoveGrabber() {
		requires(grab);
	}
	
	public void getTiggerPolarity() {
		if (OI.xbox.getTriggerAxis() != 0 && OI.xbox.getZ() != 0) {
			inOrOut = null;
			triggerPolarity = 0;
		} else if (OI.xbox.getZ() != 0) { //Left
			inOrOut = true;
			triggerPolarity = OI.xbox.getTriggerAxis();
		} else if (OI.xbox.getTriggerAxis() != 0) { //Right
			inOrOut = false;
			triggerPolarity = OI.xbox.getZ();
		} else if (OI.xbox.getTriggerAxis() == 0 && OI.xbox.getZ() == 0) {
			triggerPolarity = 0;
			inOrOut = null;
		}
	}
	
	protected void initialize() {

	}

	protected void execute() {
		getTiggerPolarity();
		//System.out.println(!grab.armClosed.get() + " Limit");
		//System.out.println(inOrOut + " In or Out");
		if (inOrOut != null && inOrOut == true) {
			grab.setLift(.45);
		} else if (inOrOut != null && inOrOut == false) {
			grab.setLift(-.45);
		} else {
			grab.setLift(0);
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
