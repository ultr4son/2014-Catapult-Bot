/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Talon;

/**
 *
 * @author localuser
 */
public class TwoNoodleRotator implements IRotator
{
    Talon noodle1;
    Talon noodle2;
    
    public TwoNoodleRotator(Talon noodle1, Talon noodle2)
    {
        this.noodle1 = noodle1;
        this.noodle2 = noodle2;
    }
    
    public boolean rotate(double speed)
    {
        noodle1.set(speed);
        noodle2.set(-speed);
        return true;
    }
    
}
