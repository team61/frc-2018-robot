package org.usfirst.frc.team61.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class NormalLiftWithJoysticks extends GlobalCommand {

    public NormalLiftWithJoysticks() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	lift.moveLift(oi.getLiftSpeed());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	lift.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
