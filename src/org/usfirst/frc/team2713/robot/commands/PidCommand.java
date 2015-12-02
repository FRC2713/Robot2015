package org.usfirst.frc.team2713.robot.commands;

import org.usfirst.frc.team2713.robot.SubsystemStorage;

import edu.wpi.first.wpilibj.command.Command;

public class PidCommand extends Command {

	double startingPoint;
	double encoder;
	SubsystemStorage base;

	public PidCommand(double startingPoint, SubsystemStorage base) {
		this.base = base;
		this.base.lift.pidStarted = true;
		this.base.lift.stopPID = false;
		this.startingPoint = startingPoint;
	}

	protected void initialize(){	
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		encoder = base.lift.thisEncoder.getDistance();
		System.out.println(encoder);
			
		if (!base.lift.stopPID) {
			if (base.lift.thisEncoder.getDistance() < startingPoint) {
				base.lift.lift(.07);
			}
			if (base.lift.thisEncoder.getDistance() > startingPoint) {
				base.lift.lift(-.02);
			}
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (base.lift.stopPID) {
			base.lift.lift(0);
			base.lift.pidStarted = false;
			return true;
		}
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		base.lift.pidStarted = false;
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		base.lift.pidStarted = false;
	}
	

}
