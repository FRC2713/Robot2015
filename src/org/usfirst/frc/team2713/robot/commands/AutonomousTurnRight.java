package org.usfirst.frc.team2713.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2713.robot.commands.CloseOrOpenGrabber;


public class AutonomousTurnRight extends CommandGroup {
	
	public AutonomousTurnRight(){
		addSequential(new CloseOrOpenGrabber(-1));
		addSequential(new CloseOrOpenGrabber(-1));
		addSequential(new Turn(Math.PI/3, false));
		//addSequential(new changeLevel(true));
		addSequential(new GoForward(10.5));
		//addSequential(new goForward(8.5));
		addSequential(new CloseOrOpenGrabber(1));	
		addSequential(new CloseOrOpenGrabber(1));	
		//addSequential(new goForward(-3));
	}
}