package org.usfirst.frc.team61.robot.commands;

import org.usfirst.frc.team61.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TorqueLiftWithJoysticks extends GlobalCommand {

    public TorqueLiftWithJoysticks() {
        // Use requires() here to declare subsystem dependencies
        requires(drivetrain);
        requires(lift);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	System.out.println("Torque Mode Activated - You Will Not Be Able To Drive");
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
//    	drivetrain.swap(); //this will possible go in initialize
    	drivetrain.tankDrive(oi.getLiftSpeed(),oi.getLiftSpeed());
    	lift.moveLift(oi.getLiftSpeed());
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	//reverts  (hopefully...) everything back to normal driving position
//    	drivetrain.unswap();
    	drivetrain.stop();
    	lift.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	end();
    }
}


/*psuedocode:
 * move solonoids to torque position
 * use joystick y axis to move the lift up and down
 */
	