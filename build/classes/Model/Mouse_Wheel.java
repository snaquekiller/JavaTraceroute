/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import org.graphstream.ui.swingViewer.View;

/**
 *
 * @author Hassane
 */
public class Mouse_Wheel implements MouseWheelListener {
    View view;
   
    public Mouse_Wheel(View view)
    {
    this.view=view;
    
    }
    @Override
    
    public void mouseWheelMoved(MouseWheelEvent e) {
        double zoom=view.getCamera().getViewPercent();
        if(e.getUnitsToScroll()==-1)
        {
        
        if(zoom!=0)
        {
        view.getCamera().setViewPercent(zoom-0.1);
        
        }
        }
        if(e.getUnitsToScroll()==1)
        {
         if(zoom!=1.5)
        {
        view.getCamera().setViewPercent(zoom+0.1);
        
        }
        
        }
    }
    
}
