package org.usfirst.frc.team2713.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team2713.robot.RobotMap;
import org.usfirst.frc.team2713.robot.commands.goForward;
import org.usfirst.frc.team2713.robot.commands.turn90Right;

public class ryansAutonomousCommand extends CommandGroup {
	public ryansAutonomousCommand() {
		addSequential(new closeOrOpenGrabber(-1));	
		addSequential(new changeLevel(true));
		addSequential(new goForward(2));
		addSequential(new closeOrOpenGrabber(1));
		addSequential(new changeLevel(false));
		addSequential(new closeOrOpenGrabber(-1));	
		addSequential(new turn90Right());
		addSequential(new goForward(7.2));

		
	}
}