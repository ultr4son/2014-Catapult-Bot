/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;


/***
 *
 * Interface for components whose purpose is rotation
 * 
 * @author localuser
 */
public interface IRotator
{
    /***
     * 
     * @param speed
     * @return true if successful, false if not
     */
    public boolean rotate(double speed);
}
