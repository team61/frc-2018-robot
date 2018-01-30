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

	public static int leftStick = 0;
	public static int rightStick = 1;
	public static int elevStick = 2;
	public static int clawStick = 3;

	public static int leftMotorA = 1;
	public static int leftMotorB = 2;
	public static int rightMotorA = 3;
	public static int rightMotorB = 4;
	
	public static int liftMotorA = 5;
	public static int liftMotorB = 6;
	
	public static int leftEncoderA = 0;
	public static int leftEncoderB = 1;
	public static int rightEncoderA = 2;
	public static int rightEncoderB = 3;
	
	public static int liftEncoderA = 4;
	public static int liftEncoderB= 5;
	
	public static int encoderLiftMax = 100; // the maximum distance that we want the lift to go. this will need to be figured out.
	
	public static int swapSolenoidModuleNumber = 1;
	
	public static int leftSwapSolenoidChannel = 0;
	public static int rightSwapSolenoidChannel = 1;
	
	public static int pcmModule = 11;
	public static int sClawLifterChannelA = 0;
	public static int sClawLifterChannelB = 1;
	public static int sClawChannelA = 2;
	public static int sClawChannelB = 3;

	
	

}
