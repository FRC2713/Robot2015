package org.usfirst.frc.team2713.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


import org.usfirst.frc.team2713.robot.RobotMap;
import org.usfirst.frc.team2713.robot.commands.goForward;
import org.usfirst.frc.team2713.robot.commands.turn90Right;

public class ryansAutonomousCommand extends CommandGroup {
	public ryansAutonomousCommand() {
		int cratesGrabbed = 0;
		for (int i = 0; i < RobotMap.AMMOUNT_OF_CRATES_TO_GET_IN_AUTONOMOUS; i++) {
			//addSequential(new closeOrOpenGrabber(-.25));
			cratesGrabbed++;
			if (cratesGrabbed < RobotMap.AMMOUNT_OF_CRATES_TO_GET_IN_AUTONOMOUS) {
				//addSequential(new changeLevel(true));
				addSequential(new goForward(5.9));
				//addSequential(new closeOrOpenGrabber(.25));
				//addSequential(new changeLevel(false));	
			} else {
				break;
			}
		}
		addSequential(new turn90Right());
		addSequential(new goForward(7.2));
		//addSequential(new closeOrOpenGrabber(.25));
	}
}