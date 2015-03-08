package org.usfirst.frc.team2713.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2713.robot.commands.closeOrOpenGrabber;


public class theAutonomousCommand extends CommandGroup {
	
	public theAutonomousCommand(){
		addSequential(new closeOrOpenGrabber(-1));
		addSequential(new turn90Right());
		//addSequential(new changeLevel(true));
		addSequential(new goForward(10.0));
		addSequential(new closeOrOpenGrabber(1));	
		addSequential(new closeOrOpenGrabber(1));	
		//addSequential(new goForward(-3));
	}

}