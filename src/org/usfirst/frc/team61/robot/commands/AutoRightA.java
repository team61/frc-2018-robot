package org.usfirst.frc.team61.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRightA extends CommandGroup {

    public AutoRightA() {
    	addSequential(new DriveForDistance((110), .6));
    	addSequential(new DriveForDistance((17), .2));
    	addSequential(new TurnForDegrees(-90, .2));
    	addSequential(new DriveForDistance(28, .6));
    	addSequential(new lowerClaw());
    	addSequential(new openClaw());
    	addSequential(new liftClaw());
    	addSequential(new closeClaw());
    	System.out.println("DONE");
    }
}
