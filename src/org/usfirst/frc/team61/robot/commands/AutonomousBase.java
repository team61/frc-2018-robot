package org.usfirst.frc.team61.robot.commands;

import org.usfirst.frc.team61.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This command is the first command that is run when the autonomous period starts. This is defined in Robot.java. Other
 * autonomous modes depending on the fms signal will stem from this defualt branch. The chooser will select other modes
 * than this one if our teammate allows us to benefit from a different autonomous. -Thomas
 */

/* Psuedocode:
* If start in left position and alliance color is to left:
* go forward 14 feet,
* turn 90 degrees right,
* drop block.
* If start in middle and alliance color is to left:
* go forward 5 feet,
* turn left 90 degrees,
* go forward 8 feet,
* turn right 90 degrees,
* go forward 8 feet,
* turn right 90 degrees,
* drop block.
* If start in right and alliance color is to left:
* go forward 5 feet,
* turn left 90 degrees,
* go forward 14 feet,
* turn right 90 degrees,
* go forward 8 feet,
* turn right 90 degrees,
* drop block.
* If start in right position and alliance color is to right:
* go forward 14 feet,
* turn 90 degrees left,
* drop block.
* If start in middle and alliance color is to right:
* go forward 5 feet,
* turn right 90 degrees,
* go forward 7 feet,
* turn left 90 degrees,
* go forward 8 feet,
* turn left 90 degrees,
* drop block.
* If start in left and alliance color is to right:
* go forward 5 feet,
* turn right 90 degrees,
* go forward 14 feet,
* turn left 90 degrees,
* go forward 8 feet,
* turn left 90 degrees,
* drop block.
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
    	System.out.println("Autonomous Executed!");
        drivetrain.tankDrive(.5, .5);
//    	String gameData = DriverStation.getInstance().getGameSpecificMessage();
//    	if(gameData.charAt(0) == 'L')
//    	{
//    		//Put left auto code here
//    	} else {
//    		//Put right auto code here
//    	}
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
