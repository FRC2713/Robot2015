package org.usfirst.frc.team2713.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class natesAutonomousCommand extends CommandGroup {
	
	public natesAutonomousCommand() {

	}
	
	public void runThis() {
		addSequential(new OpenCloseGrabber(-1),4);
		addSequential(new goForward(5), 1);
		addSequential(new OpenCloseGrabber(1), 4);
		addSequential(new goForward(5),3.5);
		addSequential(new OpenCloseGrabber(-1),4);
		addSequential(new goForward(-5), 2.5);
	}



}