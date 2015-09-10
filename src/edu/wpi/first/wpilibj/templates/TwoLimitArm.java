/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;

/**
 *
 * @author localuser
 */
public class TwoLimitArm implements IActuator
{

    Talon arm;
    DigitalInput upperLimit;
    DigitalInput lowerLimit;
    public TwoLimitArm(Talon arm, DigitalInput upperLimit, DigitalInput lowerLimit)
    {
        this.arm = arm;
        this.upperLimit = upperLimit;
        this.lowerLimit = lowerLimit;
    }
    public boolean actuate(double magnitude)
    {
        if(upperLimit.get())
        {
            if(magnitude < 0)
            {
                arm.set(magnitude);
            }
        }
        else if(lowerLimit.get())
        {
            if(magnitude > 0)
            {
                arm.set(magnitude);
            }
        }
        else
        {
            arm.set(magnitude);
        }
        return true;
    }
    
}
