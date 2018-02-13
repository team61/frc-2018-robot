package org.usfirst.frc.team61.robot.subsystems;

import org.usfirst.frc.team61.robot.RobotMap;
import org.usfirst.frc.team61.robot.commands.DriveWithJoysticks;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The DriveTrain Subsystem
 */
public class DriveTrain extends Subsystem {
//	private Encoder leftEncoder = new Encoder(RobotMap.leftEncoderA, RobotMap.leftEncoderB);
//	private Encoder rightEncoder = new Encoder(RobotMap.rightEncoderA, RobotMap.rightEncoderB);
//
//	public Solenoid leftSwapSolenoid = new Solenoid(RobotMap.swapSolenoidModuleNumber, RobotMap.leftSwapSolenoidChannel); // this solenoid swaps the motor that is controlling the wheels to the motor that controls the lift
//	public Solenoid rightSwapSolenoid = new Solenoid(RobotMap.swapSolenoidModuleNumber, RobotMap.rightSwapSolenoidChannel);
	
    CANTalon firstLeftMotor = new CANTalon(RobotMap.mLeftA); 
    CANTalon secondLeftMotor = new CANTalon(RobotMap.mLeftB);
    CANTalon firstRightMotor = new CANTalon(RobotMap.mRightA);
    CANTalon secondRightMotor = new CANTalon(RobotMap.mRightB);
    
    // Initialize the subsystem
    public DriveTrain() {
    	super("DriveTrain");
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
     * Reset Right Encoder
     * Resets the right encoder counter to 0
     * @author Team 61 Programming
     */
//    public void resetRightEncoder()
//    {
//        rightEncoder.reset();
//    }
//    
    /**
     * Reset Left Encoder
     * Resets the left encoder counter to 0
     * @author Team 61 Programming
     */
//    public void resetLeftEncoder()
//    {
//        leftEncoder.reset();
//    }
//    
    /**
     * Get Right Encoder Distance
     * Returns scaled value of right encoder
     * @return distance since last reset of right encoder
     * @author Team 61 Programming
     */
//    public double getRightEncoder()
//    {
//        return rightEncoder.getDistance();
//    }
//    
    /**
     * Get Left Encoder Distance
     * Returns scaled value of left encoder
     * @return distance since last reset of left encoder
     * @author Team 61 Programming
     */
//    public double getLeftEncoder()
//    {
//        return -leftEncoder.getDistance();
//    }
}

