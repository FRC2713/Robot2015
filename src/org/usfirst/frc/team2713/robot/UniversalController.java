package org.usfirst.frc.team2713.robot;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.can.CANMessageNotFoundException;
import edu.wpi.first.wpilibj.util.AllocationException;

public class UniversalController {
	CANJaguar thisJaguar;
	CANTalon thisTalon;
	public Boolean CANOrTalon; // True is a CAN, False is a Talon
	public Boolean normalOrSpedUp; // True is normal, false is a sped up controller

	public UniversalController(int portNum, boolean normalOrSpedUp) {
		this.normalOrSpedUp = normalOrSpedUp;
		try {
			if (normalOrSpedUp) {
				thisJaguar = new CANJaguar(portNum);
			} else {
				thisJaguar = new OurJaguar(portNum);
			}
			System.out.println(portNum);
			CANOrTalon = true;
		} catch (AllocationException ex) {
			thisTalon = new CANTalon(portNum);
			CANOrTalon = false;
		} catch(CANMessageNotFoundException ex) {
			thisTalon = new CANTalon(portNum);
			CANOrTalon = false;
		}
	}

	public SpeedController getProperController() {
		if (CANOrTalon == true) {
			return thisJaguar;
		} else {
			return thisTalon;
		}
	}
}
