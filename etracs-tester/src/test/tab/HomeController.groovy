
package test.tab;

import com.rameses.rcp.common.*;
import com.rameses.rcp.annotations.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*
        
class HomeController
{
    void init() {
        
    }
    
    def tabs = Inv.lookupOpeners('home:tab', [:]); 
    
    def tabModel = [ 
        getOpeners: {
            return tabs;
        }
    ] as TabbedPaneModel; 
    
    
}