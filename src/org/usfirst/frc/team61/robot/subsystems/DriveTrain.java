package org.usfirst.frc.team61.robot.subsystems;

import org.usfirst.frc.team61.robot.RobotMap;
import org.usfirst.frc.team61.robot.commands.DriveWithJoysticks;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;


/**
 * The DriveTrain Subsystem
 */
public class DriveTrain extends Subsystem {
	private Encoder leftEncoder = new Encoder(RobotMap.eLeftA, RobotMap.eLeftB, false, EncodingType.k4X);
	private Encoder rightEncoder = new Encoder(RobotMap.eRightA, RobotMap.eRightB, false, EncodingType.k4X);

	private AnalogGyro mainGyro = new AnalogGyro(RobotMap.mainGyro);
	
    CANTalon firstLeftMotor = new CANTalon(RobotMap.mLeftA); 
    CANTalon secondLeftMotor = new CANTalon(RobotMap.mLeftB);
    CANTalon firstRightMotor = new CANTalon(RobotMap.mRightA);
    CANTalon secondRightMotor = new CANTalon(RobotMap.mRightB);
    
	public static final double WHEEL_DIAMETER = 8;
	public static final double PULSE_PER_REVOLUTION = 1440;
	public static final double ENCODER_GEAR_RATIO = 1;
	public static final double GEAR_RATIO = 5 / 3;
	public static final double FUDGE_FACTOR = 2.73; // this is changed to accurately get a measure from our encoder
	//.84
	
    // Initialize the subsystem
    public DriveTrain() {
    	super("DriveTrain");
        final double distancePerPulse = Math.PI * WHEEL_DIAMETER / PULSE_PER_REVOLUTION / ENCODER_GEAR_RATIO / GEAR_RATIO * FUDGE_FACTOR;
    	leftEncoder.setDistancePerPulse(distancePerPulse);
    	rightEncoder.setDistancePerPulse(distancePerPulse);
        System.out.println("DriveTrain Initiated");
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new DriveWithJoysticks());
    }
    
    /**
     * Tank-drive controls.
     * @author Team 61 Programming
     * @param left Left motor value or motor stack value
     * @param right Right motor value or motor stack value
     */
    public void tankDrive(double left, double right) {
        moveLeftMotorStack(left);
        moveRightMotorStack(right);
    }
    
    /**
     * Reversed tank-drive controls.
     * @author Team 61 Programming
     * @param left Left motor value or motor stack value
     * @param right Right motor value or motor stack value
     */
    public void reverseTankDrive(double right, double left) {
        moveRightMotorStack(right);
        moveLeftMotorStack(left);
    }
    
    /**
     * Moves the multiple motors on the left side.
     * @author Team 61 Programming
     * @param speed 
     */
    private void moveLeftMotorStack(double speed)
    {
//      speed = speed*-1.0;
        firstLeftMotor.set(speed);
        secondLeftMotor.set(speed);
    }
    
    /**
     * Moves the multiple motors on the right side.
     * @author Team 61 Programming
     * @param speed 
     */
    private void moveRightMotorStack(double speed)
    {
    // negative to go in forward direction
        firstRightMotor.set(-speed);
        secondRightMotor.set(-speed);
    }
    
    /**
     * Stops the left and right motor stacks.
     * @author Team 61 Programming
     * @param speed 
     */
    public void stop() {
    	moveLeftMotorStack(0.0);
    	moveRightMotorStack(0.0);
    }
    
    /**
     * Resets Gyro to 0
     */
    public void resetGyro(){
        mainGyro.reset();
    }
    
    /**
     * Get Gyro Angle
     * Positive is clockwise
     * @return scaled angle in degrees
     */
    public double getGyroAngle(){
        return mainGyro.getAngle();
    }
    
    public double getGyroRate(){
        return mainGyro.getRate();
    }
   
    public double getLeftEncoder() {
    	return leftEncoder.getDistance();
    }
    
    public void resetLeftEncoder() {
    	leftEncoder.reset();
    }
    
    public double getRightEncoder() {
    	return rightEncoder.getDistance();
    }
    
    public void resetRightEncoder() {
    	rightEncoder.reset();
    }
}

