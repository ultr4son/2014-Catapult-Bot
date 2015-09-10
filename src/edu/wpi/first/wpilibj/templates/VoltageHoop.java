/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Talon;

/**
 *
 * @author localuser
 */
public class VoltageHoop implements ILauncher
{
    Talon motor1;
    Talon motor2;
    Talon motor3;
    Talon motor4;
    public VoltageHoop(Talon motor1, Talon motor2, Talon motor3, Talon motor4)
    {
        this.motor1 = motor1;
        this.motor2 = motor2;                
        this.motor3 = motor3;
        this.motor4 = motor4;

        
    }
    public boolean launch(double magnitude)
    {
        motor1.set(magnitude);
        motor2.set(magnitude);
        
        motor3.set(-magnitude);
        motor4.set(-magnitude);
        return true;
    }

    public boolean returnLauncher(double magnitude)
    {
        //Launcher is returned manually
        return true;
    }

    public boolean done()
    {
        //Launcher is controlled manually
        return true;
    }
    
}
