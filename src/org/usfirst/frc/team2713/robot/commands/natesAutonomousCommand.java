package org.usfirst.frc.team2713.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2713.robot.commands.closeOrOpenGrabber;


public class natesAutonomousCommand extends CommandGroup {
	
	public natesAutonomousCommand(){
		addSequential(new closeOrOpenGrabber(1),4);	
		addSequential(new goForward(7.2));
		addSequential(new goForward(-1));
	}

}