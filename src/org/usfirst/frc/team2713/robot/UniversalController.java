package org.usfirst.frc.team2713.robot;

import edu.wpi.first.wpilibj.CANJaguar;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.util.AllocationException;

public class UniversalController {
	CANJaguar thisJaguar;
	Talon thisTalon;
	public Boolean CANOrTalon; //True is a CAN, False is a Talon
	public UniversalController(int portNum) {
		try {
			thisJaguar = new CANJaguar(portNum);
			CANOrTalon = true;
		} catch(AllocationException ex) {
			//thisTalon = new Talon(portNum);
			CANOrTalon = false;
		}
	}
	
	public SpeedController getProperController() {
		if(CANOrTalon == true) {
			return thisJaguar;
		} else {
			return thisTalon;
		}
	}
}
