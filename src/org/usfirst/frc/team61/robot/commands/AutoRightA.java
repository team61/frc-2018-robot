package org.usfirst.frc.team61.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRightA extends CommandGroup {

    public AutoRightA() {
    	addSequential(new DriveForDistance((110), .6));
    	addSequential(new DriveForDistance((17), .2));
    	addSequential(new TurnForDegrees(-84, .25));
    	addSequential(new DriveForDistance(28, .6));
    	addSequential(new lowerClaw());
    	addSequential(new openClaw()); // this automatically closes the claw for some reason
    	addParallel(new liftClaw());
    	System.out.println("DONE");
    }
}
