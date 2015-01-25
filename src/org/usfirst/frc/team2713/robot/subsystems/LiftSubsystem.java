package org.usfirst.frc.team2713.robot.subsystems;

import org.usfirst.frc.team2713.robot.RobotMap;
import org.usfirst.frc.team2713.robot.UniversalController;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LiftSubsystem  extends Subsystem{
	
	public DigitalInput[] limitSwitches;
	public int currentLevel = 0;
	UniversalController arm;
	
	public LiftSubsystem() {
		arm = new UniversalController(RobotMap.ARM_MOTOR);
		limitSwitches = new DigitalInput[RobotMap.AMMOUNT_OF_LIMIT_SWITCHES];
		for(int i = 0; i < limitSwitches.length; i++) {
			limitSwitches[i] = new DigitalInput(i);
		}
	}
	
	public void lift(int polarity) {
		arm.getProperController().set(polarity);
	}

	public void initDefaultCommand() {
		
	}

}
