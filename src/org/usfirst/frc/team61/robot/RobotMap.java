package org.usfirst.frc.team61.robot;

import edu.wpi.first.wpilibj.DigitalSource;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;

	//Joystick Ports
	public static int leftStick = 0;
	public static int rightStick = 1;
	public static int elevStick = 2;
	public static int clawStick = 3;

	//Motor Ports
	public static int mLeftA = 1;
	public static int mLeftB = 2;
	public static int mRightA = 3;
	public static int mRightB = 4;
	public static int mLiftA = 5;
	public static int mLiftB = 6;
	
	//Encoder Ports
	public static int eLeftA = 0;
	public static int eLeftB = 1;
	public static int eRightA = 2;
	public static int eRightB = 3;
	public static int eLiftA = 4;
	public static int eLiftB= 5;
	
	//Solonoids 
	public static int pcmModule = 11;
	public static int sClawLifterChannelA = 0;
	public static int sClawLifterChannelB = 1;
	public static int sClawChannelA = 2;
	public static int sClawChannelB = 3;
	public static int sLiftSwapA = 4;
	public static int sLiftSwapB = 5;
	
	//Misc.
	public static int liftMaxHeight = 100; 
	// the maximum distance that we want the lift to 
	// go. this will need to be figured out.
	public static int limitSwitchA = 0;
	


	
	

}
