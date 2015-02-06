package org.usfirst.frc.team2713.robot.commands;


import org.usfirst.frc.team2713.robot.*;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team2713.robot.RobotMap;

public class Autonomous extends commandBase{
	/*
	 * @Author JaydenF
	 */
	Preferences prefs;
	double mag = 0.2;
	double dir = 0.0;
	double rot = 0.2;
	public int crateNum;
	public RobotDrive roboDrive;
	public commandBase CommandBase;
	
	public Autonomous(commandBase commandBase, int CrateNum){
		CommandBase = commandBase;
		crateNum = CrateNum;
		prefs = Preferences.getInstance();
	}
	
	protected void execute() {
		for(int i = crateNum; i == 0; i--){
		goForward(0.1);
		grab(1,6.0);
		grab(0,6.0);
		goForward(0.8);
		grab(1,6.0);
		grab(-1,6.0);
		}
		
	}
	
	protected void initialize() {
		
	}
	
	public void goForward(double seconds){
		Timer timr = new Timer();
		timr.start();
		while(timr.get() < seconds){
			roboDrive.mecanumDrive_Polar(mag, dir, rot);
		}
	}
	
	public void grab(int polarity, double seconds){
		Timer timr = new Timer();
		timr.start();
		while(timr.get() < seconds){
			grab.setLift(polarity);
		}
	}
	
	//@Override
	//protected boolean isFinished() {
		
	//	return false;
	//}
}
