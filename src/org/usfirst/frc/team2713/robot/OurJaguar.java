package org.usfirst.frc.team2713.robot;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Jaguar;

public class OurJaguar extends CANJaguar {

	public OurJaguar(int portNum) {
		super(portNum);
	}
	
	@Override
	public void set(double voltage) {
		super.set(voltage * 1.22);
	}
	
}
