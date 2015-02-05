package org.usfirst.frc.team2713.robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team2713.robot.commands.changeLevel;
import org.usfirst.frc.team2713.robot.commands.closeOrOpenGrabber;
import org.usfirst.frc.team2713.robot.commands.goForward;
import org.usfirst.frc.team2713.robot.commands.turn90Right;

public class autonomousCommand extends CommandGroup {
	public autonomousCommand() {
		int cratesGrabbed = 0;
		for (int i = 0; i < RobotMap.AMMOUNT_OF_CRATES_TO_GET_IN_AUTONOMOUS; i++) {
			addSequential(new closeOrOpenGrabber(-1));
			cratesGrabbed++;
			if (cratesGrabbed < RobotMap.AMMOUNT_OF_CRATES_TO_GET_IN_AUTONOMOUS) {
				for (int x = 0; x < cratesGrabbed; x++) {
					addSequential(new changeLevel(true));
				}
				addSequential(new goForward(4.8333));
				addSequential(new closeOrOpenGrabber(1));
				for(int x = 0; x < cratesGrabbed; x++) {
					addSequential(new changeLevel(false));	
				}
				addSequential(new closeOrOpenGrabber(-1));
			} else {
				break;
			}
		}
		addSequential(new turn90Right());
		addSequential(new goForward(8.91666));
		addSequential(new closeOrOpenGrabber(1));
		
	}
}
