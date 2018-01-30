package org.usfirst.frc.team61.robot.commands;

import org.usfirst.frc.team61.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftBase extends GlobalCommand {
	
	Command normalLift;
	Command torqueLift;
	
    public LiftBase() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	normalLift = new NormalLiftWithJoysticks();
    	torqueLift = new TorqueLiftWithJoysticks();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	oi.updateToggle();
    	
        if(oi.toggleOn){
        	// Do something when toggled on
        	if (normalLift != null) normalLift.cancel();
            if (torqueLift != null) torqueLift.start();
        } else {
        	// Do something when toggled off
        	if (torqueLift != null) torqueLift.cancel();
        	if (normalLift != null) normalLift.start();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
