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
public class Catapult
{
    ILauncher hoop;
    public Catapult(ILauncher hoopController)
    {
        hoop = hoopController;
    }
    public void launch(double speed)
    {
        hoop.launch(speed);
        
        hoop.returnLauncher(speed);
    }
    
}
