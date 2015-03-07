package org.usfirst.frc.team2713.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2713.robot.commands.closeOrOpenGrabber;


public class natesAutonomousCommand extends CommandGroup {
	
	public natesAutonomousCommand(){
		addSequential(new closeOrOpenGrabber(-1));
		addSequential(new turn90Right());
		//addSequential(new changeLevel(true));
		addSequential(new goForward(9.0));
		addSequential(new closeOrOpenGrabber(1));
		addSequential(new closeOrOpenGrabber(1));
		addSequential(new goForward(-5));
		//addSequential(new closeOrOpenGrabber(1));	
		//addSequential(new goForward(-1));
	}

}