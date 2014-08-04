/*
 * ServerConfig.java
 *
 * Created on May 14, 2014, 9:52 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package main;

/**
 *
 * @author wflores
 */
class Conf 
{
    public static void load() {
        String basedir = "C:/RAMESES/testers/etracsorg-tester";
        System.getProperties().put("osiris.base.dir", basedir);
        System.getProperties().put("osiris.run.dir",  basedir+"/bin");         
    } 
    
    
    private Conf() {
    }
        
}
