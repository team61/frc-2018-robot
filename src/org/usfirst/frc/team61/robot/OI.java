package org.usfirst.frc.team61.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	// variables used for various toggle buttons
	// these are required for the toggle to remain
	// on when a switch is pressed and turn off
	// when switched again
	
    public boolean toggleOnOpenClaw = false;
    boolean togglePressedOpenClaw = false;
    public boolean toggleOnBar = false;
    boolean togglePressedBar = false;
    public boolean toggleOnLiftClaw = false;
    boolean togglePressedLiftClaw = false;
    public boolean toggleOnLift = false;
    boolean togglePressedLift = false;
    
	Joystick jLeft = new Joystick(RobotMap.leftStick);    
	Joystick jRight = new Joystick(RobotMap.rightStick); 
	Joystick jLift = new Joystick(RobotMap.elevStick);
	Joystick jClaw = new Joystick(RobotMap.clawStick);
	
	Button torqueButton = new JoystickButton(jLeft,1);
	
	public OI() {
		
	}
	
    public void updateToggleOpenClaw()
    {
        if(jClaw.getTrigger()){
            if(!togglePressedOpenClaw){
                toggleOnOpenClaw = !toggleOnOpenClaw;
                togglePressedOpenClaw = true;
            }
        } else {
            togglePressedOpenClaw = false;
        }
    }
    
    public void updateToggleLiftClaw()
    {
        if(jLift.getTrigger()){
            if(!togglePressedLiftClaw){
                toggleOnLiftClaw = !toggleOnLiftClaw;
                togglePressedLiftClaw = true;
            }
        } else {
            togglePressedLiftClaw = false;
        }
    }
	
    public void updateToggleBar()
    {
        if(jClaw.getRawButton(10)){
            if(!togglePressedBar){
                toggleOnBar = !toggleOnBar;
                togglePressedBar = true;
            }
        } else {
            togglePressedBar = false;
        }
    }
	
    
    public void updateToggleLift()
    {
        if(jRight.getTrigger()){
            if(!togglePressedLift){
                toggleOnLift = !toggleOnLift;
                togglePressedLift = true;
            }
        } else {
            togglePressedLift = false;
        }
    }
    /** 
     * Gets the position of the jElev Y Axis
     * @return joystick value scaled -1 to 1
     */
	public double getLiftSpeed() {
        return (jLift.getY()); 
	}
	
	public double getLiftYSpeed() {
		if (getLiftSpeed() < 0) {
			return (jLift.getY());
		} else {
			return 0;		
		}
	}
    /** 
     * Gets the position of the jLeft Y Axis
     * @return joystick value scaled -1 to 1
     */
	public double getLeftSpeed() {
        return (jLeft.getY()); 
	}
	
    /** 
     * Gets the position of the jLeft Y Axis
     * @return joystick value scaled -1 to 1
     */
	public double getRightSpeed() {
        return (jRight.getY()); 
	}
	
    /** 
     * Gets the position of the jClaw Y Axis
     * @return joystick value scaled -1 to 1
     */
	public double getClawSpeed() {
        return (jClaw.getY()); 
	}
}
