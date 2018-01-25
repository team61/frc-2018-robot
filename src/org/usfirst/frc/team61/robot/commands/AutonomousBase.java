package org.usfirst.frc.team61.robot.commands;

import org.usfirst.frc.team61.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command is the first command that is run when the autonomous period starts. This is defined in Robot.java. Other
 * autonomous modes depending on the fms signal will stem from this defualt branch. The chooser will select other modes
 * than this one if our teammate allows us to benefit from a different autonomous. -Thomas
 */
public class AutonomousBase extends GlobalCommand {

    public AutonomousBase() {
        // Use requires() here to declare subsystem dependencies
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
