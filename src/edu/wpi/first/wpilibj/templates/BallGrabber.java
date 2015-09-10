/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

/**
 *
 * @author localuser
 */
public class BallGrabber
{
    IRotator grabbers;
    IActuator positionSetter;
    
    public BallGrabber(IRotator grabbers, IActuator positionSetter)
    {
        this.grabbers = grabbers;
        this.positionSetter = positionSetter;
    }
    
    public void grab(double speed)
    {
        grabbers.rotate(speed);
    }
    public void setPosition(double position)
    {
        positionSetter.actuate(position);
    }
}
