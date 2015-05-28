package org.usfirst.frc.team2713.robot.commands;

public class PidCommand extends CommandBase {

	double startingPoint;
	double encoder;

	public PidCommand(double startingPoint) {
		lift.pidStarted = true;
		lift.stopPID = false;
		this.startingPoint = startingPoint;
	}

	protected void initialize(){	
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		encoder = lift.thisEncoder.getDistance();
		System.out.println(encoder);
			
		if (!lift.stopPID) {
			if (lift.thisEncoder.getDistance() < startingPoint) {
				lift.lift(.07);
			}
			if (lift.thisEncoder.getDistance() > startingPoint) {
				lift.lift(-.02);
			}
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (lift.stopPID) {
			lift.lift(0);
			lift.pidStarted = false;
			return true;
		}
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		lift.pidStarted = false;
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		lift.pidStarted = false;
	}
	

}
