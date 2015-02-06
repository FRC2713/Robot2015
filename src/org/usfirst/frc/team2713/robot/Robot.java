package org.usfirst.frc.team2713.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PrintCommand;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import org.usfirst.frc.team2713.robot.commands.ExampleCommand;
import org.usfirst.frc.team2713.robot.commands.commandBase;
import org.usfirst.frc.team2713.robot.subsystems.ExampleSubsystem;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to each mode, as described in the IterativeRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the manifest file in the resource directory.
 */
public class Robot extends IterativeRobot {

	public static commandBase base = new commandBase();
	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	Preferences prefs;
	CameraServer server;
	int session;
    Image frame;
	

	Command autonomousCommand;
	Command natesPerfectAutonomous;

	/**
	 * This function is run when the robot is first started up and should be used for any initialization code.
	 */
	public void robotInit() {
		oi = new OI();
		// instantiate the command used for the autonomous period
        System.out.println("--------------------2713-----------------------");
        System.out.println("*Awsome-sauce code produced by RyNaJaSa  inc.      *");
        System.out.println("*WARNING: might not possibly work             *");
        System.out.println("-----------------TEST-ROBOT--------------------");
        autonomousCommand = new ExampleCommand();
        
        frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
        session = NIVision.IMAQdxOpenCamera("cam0",
                NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        NIVision.IMAQdxConfigureGrab(session);

        prefs = Preferences.getInstance();
        prefs.putDouble("SCALER",0.6);
        prefs.putDouble("DEADBAND",0.1);
        SmartDashboard.putData(Scheduler.getInstance());
        
       
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		if (natesPerfectAutonomous != null)
			natesPerfectAutonomous.start();
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
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		if (RobotMap.INIT_DRIVE) {
			base.initDrive();
		}

		if (RobotMap.INIT_GRAB) {
			base.initGrab();
		}

		if (RobotMap.INIT_LIFT) {
			base.initLift();
		}
					
		
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
		NIVision.IMAQdxStartAcquisition(session);
		 NIVision.IMAQdxGrab(session, frame, 1);
		NIVision.Rect rect = new NIVision.Rect(10, 10, 100, 100);
		CameraServer.getInstance().setImage(frame);
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}

}
