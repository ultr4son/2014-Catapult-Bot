/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot
{
    int REAR_RIGHT_CHANNEL = 1;
    int REAR_LEFT_CHANNEL = 2;
    int FRONT_RIGHT_CHANNEL = 3;
    int FRONT_LEFT_CHANNEL = 4;
    
    int NOODLE1_CHANNEL = 1;
    int NOODLE2_CHANNEL = 2;
    int GRABBERMOVER_CHANNEL = 7;
    
    int UPPERLIMIT_CHANNEL = 6;
    int LOWERLIMIT_CHANNEL = 7;
    
    int LEFT_YAXIS = 2;
    int RIGHT_YAXIS = 5;
    int ROTATION_AXIS = 1;
    int LEFT_TRIGGER = 3;
    int RIGHT_TRIGGER = 4;
    
    int BUTTON_UP = 1;
    int BUTTON_DOWN = 4;
    
    int CATAPULT1_CHANNEL = 1;
    int CATAPULT2_CHANNEL = 2;
    int CATAPULT3_CHANNEL = 3;
    int CATAPULT4_CHANNEL = 4;
    
    
    
    CANJaguar rearRight;
    CANJaguar rearLeft;
    CANJaguar frontRight;
    CANJaguar frontLeft;
    
    Talon catapult1;
    Talon catapult2;
    Talon catapult3;
    Talon catapult4;
    Catapult catapult;
    
    RobotDrive chassis;
    
    Talon noodle1;
    Talon noodle2;
    
    Talon grabberMover;
    
    DigitalInput upperLimit;
    DigitalInput lowerLimit;
    
    BallGrabber ballGrabber;
    
    Joystick xboxController;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initializion code.
     */
    
    public void robotInit()
    {
        try
        {
            rearRight = new CANJaguar(REAR_RIGHT_CHANNEL);
            rearLeft = new CANJaguar(REAR_LEFT_CHANNEL);
            frontRight = new CANJaguar(FRONT_LEFT_CHANNEL);
            frontLeft = new CANJaguar(FRONT_RIGHT_CHANNEL);
        }
        catch(CANTimeoutException ex)
        {
            System.err.println(ex.getMessage());
        }
        
        chassis = new RobotDrive(rearLeft, rearRight, frontLeft, frontRight);
        
        noodle1 = new Talon(1, NOODLE1_CHANNEL);
        noodle2 = new Talon(1, NOODLE2_CHANNEL);
        upperLimit = new DigitalInput(UPPERLIMIT_CHANNEL);
        lowerLimit = new DigitalInput(LOWERLIMIT_CHANNEL);
        grabberMover = new Talon(1, GRABBERMOVER_CHANNEL);
        
        ballGrabber = new BallGrabber(new TwoNoodleRotator(noodle1, noodle2), 
                new TwoLimitArm(grabberMover, upperLimit, lowerLimit));
        catapult1 = new Talon(CATAPULT1_CHANNEL);
        catapult2 = new Talon(CATAPULT2_CHANNEL);
        catapult3 = new Talon(CATAPULT3_CHANNEL);
        catapult4 = new Talon(CATAPULT4_CHANNEL);
        catapult = new Catapult(new VoltageHoop(catapult1, catapult2, catapult3, catapult4));
        
        
        xboxController = new Joystick(1);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic()
    {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic()
    {
        chassis.arcadeDrive(-xboxController.getRawAxis(LEFT_YAXIS), -xboxController.getRawAxis(ROTATION_AXIS));
        if(xboxController.getRawButton(BUTTON_UP))
        {
            ballGrabber.grab(1.0);
        }
        else if(xboxController.getRawButton(BUTTON_DOWN))
        {
            ballGrabber.grab(-1.0);
        }
        else
        {
            ballGrabber.grab(0);
        }
        ballGrabber.setPosition(xboxController.getRawAxis(RIGHT_YAXIS));
        //Right Trigger goes up, Left Trigger goes down
        catapult.launch(xboxController.getRawAxis(RIGHT_TRIGGER) + -xboxController.getRawAxis(LEFT_TRIGGER));
    }
    /**
     * This function is called periodically during test mode
     */
    /**
     * This function is called periodically during test mode
     */
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic()
    {

    }

}
