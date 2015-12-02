package org.usfirst.frc.team2713.robot.commands;

import org.usfirst.frc.team2713.robot.SubsystemStorage;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class GoForward extends Command {

	double distance; // 8' at 70%
	double time;
	Timer timer;
	double polarity = 0.7;
	SubsystemStorage base;

	public GoForward(double distance1, SubsystemStorage base) {
		this.base = base;
		timer = new Timer();
		distance = distance1;
		time = distance / 8;
		if (distance < 0) {
			polarity = -.7;
			time = time * -1;
		}
		timer.reset();
		timer.start();
		// drive.thisEncoder.reset();
	}

	protected void initialize() {
		timer.reset();
		timer.start();
	}

	protected void execute() {
		System.out.println("Go Forward");
		if ((timer.get() < time)) {
			base.drive.move(-polarity);
		} else {
			base.drive.move(0);
		}
	}

	protected boolean isFinished() {

		// if (drive.thisEncoder.getDistance() > distance * 12) {
		// drive.move(0);
		// return true;
		// } else {
		// return false;
		// }
		if (timer.get() > time) {
			base.drive.move(0);
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
