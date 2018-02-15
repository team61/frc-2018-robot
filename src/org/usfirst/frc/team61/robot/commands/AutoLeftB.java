package org.usfirst.frc.team61.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeftB extends CommandGroup {

    public AutoLeftB() {
    	addSequential(new DriveForDistance(290, .8));
    	addSequential(new DriveForDistance(10, .3));
    }
}
