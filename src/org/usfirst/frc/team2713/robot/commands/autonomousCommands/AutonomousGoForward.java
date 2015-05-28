package org.usfirst.frc.team2713.robot.commands.autonomousCommands;

import edu.wpi.first.wpilibj.command.CommandGroup;


import org.usfirst.frc.team2713.robot.commands.GoForward;


public class AutonomousGoForward extends CommandGroup {
	
	public AutonomousGoForward(){
		addSequential(new GoForward(10.5));
	}
}