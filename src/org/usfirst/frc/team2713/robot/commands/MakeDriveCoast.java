package org.usfirst.frc.team2713.robot.commands;

import org.usfirst.frc.team2713.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class MakeDriveCoast extends Command {

	int timesRun = 0;

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		if (RobotMap.drive_Slow_Down == RobotMap.drive_Slow_Slow_Down) {
			RobotMap.drive_Slow_Down = RobotMap.drive_Normal_Slow_Down;
		} else {
			RobotMap.drive_Slow_Down = RobotMap.drive_Slow_Slow_Down;
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
