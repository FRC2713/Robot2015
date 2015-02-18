package org.usfirst.frc.team2713.robot;

import org.usfirst.frc.team2713.robot.inputs.XBoxController;


import org.usfirst.frc.team2713.robot.commands.changeLevel;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// // CREATING BUTTONS
	// One type of button is a joystick button which is any button on a joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);
	
	public static Joystick joystick;
	public static XBoxController xbox;
	private JoystickButton liftUp;
	private JoystickButton liftDown;
	
	

	public OI() {
		joystick = new Joystick(RobotMap.JOYSTICK_PORT);
		xbox = new XBoxController(RobotMap.XBOX_PORT);
		joystick = new Joystick(RobotMap.JOYSTICK_PORT);
		if (RobotMap.INIT_LIFT) {
			
			liftUp = new JoystickButton(xbox, 4);
			liftUp.whileHeld(new changeLevel(true));
			liftUp.whenReleased(new changeLevel(null));
			liftDown = new JoystickButton(xbox, 1);
			liftDown.whileHeld(new changeLevel(false));
			liftDown.whenReleased(new changeLevel(null));
			
			//liftUp2 = new JoystickButton(joystick, 8);
			//liftUp2.whileHeld(new changeLevel(true));
			//liftUp2.whenReleased(new changeLevel(null));
			//liftDown2 = new JoystickButton(joystick, 7);
			//liftDown2.whileHeld(new changeLevel(false));
			//liftDown2.whenReleased(new changeLevel(null));
			
			//grabOpen = new JoystickButton(joystick,1);
			//grabOpen.whileHeld(new closeOrOpenGrabber(1));
			//grabOpen.whenReleased(new closeOrOpenGrabber(0));
			//grabClose = new JoystickButton(joystick,2);
			//grabClose.whileHeld(new closeOrOpenGrabber(-1));
			//grabClose.whenReleased(new closeOrOpenGrabber(0));
			
			
			
		}

	}

	public XBoxController getXbox() {
		// TODO Auto-generated method stub
		return xbox;
	}
	
	public Joystick joystick(){
		
		return joystick;
	}

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	// // TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
