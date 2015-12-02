package org.usfirst.frc.team2713.robot.commands;

import org.usfirst.frc.team2713.robot.OI;
import org.usfirst.frc.team2713.robot.SubsystemStorage;

import edu.wpi.first.wpilibj.command.Command;

public class MoveGrabber extends Command {

	Boolean inOrOut;
	double triggerPolarity = OI.xbox.getTriggerAxis();
	SubsystemStorage base;

	public MoveGrabber(SubsystemStorage base) {
		this.base = base;
		requires(this.base.grab);
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
			base.grab.setLift(.45);
		} else if (inOrOut != null && inOrOut == false) {
			base.grab.setLift(-.45);
		} else {
			base.grab.setLift(0);
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
