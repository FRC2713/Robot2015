package org.usfirst.frc.team2713.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2713.robot.commands.autonomousCommands.AutonomousGoForward;
import org.usfirst.frc.team2713.robot.commands.autonomousCommands.AutonomousTurnRight;
import org.usfirst.frc.team2713.robot.commands.autonomousCommands.ExampleCommand;
import org.usfirst.frc.team2713.robot.subsystems.ExampleSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to each mode, as described in the IterativeRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the manifest file in the resource directory.
 */
public class Robot extends IterativeRobot {

	public SubsystemStorage base;
	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static DigitalInput[] autonomousSwitches;
	public static boolean ignoreReleased = false;
	public static OI oi;
	
	Preferences prefs;
	CameraServer server;
	int session;

	Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be used for any initialization code.
	 */
	public void robotInit() {
		// instantiate the command used for the autonomous period
		System.out.println("--------------------2713-----------------------");
		System.out.println("*Awsome-sauce code produced by RyNaJaSa  inc.      *");
		System.out.println("*WARNING: might not possibly work             *");
		System.out.println("-----------------TEST-ROBOT--------------------");
		base = new SubsystemStorage();
		autonomousSwitches = new DigitalInput[RobotMap.DIPSWITCHCOUNT];
		for(int i = 0; i < RobotMap.DIPSWITCHCOUNT; i++) {
			autonomousSwitches[i] = new DigitalInput(i + RobotMap.DIPSWITCHSTARTPORT);
		}
		if(autonomousSwitches[0].get() == true) {
			autonomousCommand = new ExampleCommand();
		} else if(autonomousSwitches[1].get() == true) {
			autonomousCommand = new AutonomousTurnRight(base);			
		} else if(autonomousSwitches[2].get() == true) {
			autonomousCommand = new AutonomousGoForward(base);			
		} else {
			autonomousCommand = new ExampleCommand();
		}
		oi = new OI(base);
		
		prefs = Preferences.getInstance();
		prefs.putInt("DriverStationNumber", RobotMap.XBOX_OR_JOYSTICK);
		prefs.putDouble("SCALER", 0.75); 
		prefs.putDouble("DEADBAND", 0.05);
        server = CameraServer.getInstance();
        server.setQuality(50);
        server.startAutomaticCapture("cam0");
		SmartDashboard.putData(Scheduler.getInstance());
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		if (autonomousCommand != null) {
			autonomousCommand.start();
			ignoreReleased = true;
		}
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
			ignoreReleased = true;
		}
		base.drive.startCommand();
		base.grab.startCommand();
	}

	/**
	 * This function is called when the disabled button is hit. You can use it to reset subsystems before shutting down.
	 */
	public void disabledInit() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		//NIVision.IMAQdxStartAcquisition(session);
		//NIVision.IMAQdxGrab(session, frame, 1);
		//CameraServer.getInstance().setImage(frame);
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}

}