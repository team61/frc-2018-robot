package org.usfirst.frc.team61.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForDistance extends GlobalCommand {

    private static final double FUDGE_FACTOR = .94;
	private double target = 1;
    private double speed = .5;
    private double threshold = .25;
    public double travelled = 0;
    

	public DriveForDistance(double target, double speed) {
    	requires(drivetrain);
    	this.target = target;
    	this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drivetrain.resetLeftEncoder();
    	drivetrain.resetRightEncoder();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	travelled = (drivetrain.getLeftEncoder() + drivetrain.getRightEncoder())/2;
    	drivetrain.tankDrive(speed, speed*FUDGE_FACTOR);
    	System.out.println("Left: " + drivetrain.getLeftEncoder());
    	System.out.println("Right: " + drivetrain.getRightEncoder());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (target - travelled) < threshold;
    }

    // Called once after isFinished returns true
    protected void end() {
    	drivetrain.tankDrive(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
