package org.usfirst.frc.team2713.robot.commands;

import org.usfirst.frc.team2713.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ChangeDriveSpeed extends Command {

	int timesRun = 0;

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		if (RobotMap.drive_Scaler == RobotMap.drive_Slow_Scaler) {
			RobotMap.drive_Scaler = RobotMap.drive_Normal_Scaler;
		} else {
			RobotMap.drive_Scaler = RobotMap.drive_Slow_Scaler;
		}
		timesRun++;
	}

	@Override
	protected boolean isFinished() {
		if (timesRun > 0) {
			return true;
		}
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
