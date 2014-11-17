
package test.tab;

import com.rameses.rcp.common.*;
import com.rameses.rcp.annotations.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*
        
class ItemController
{
    @Caller
    def caller; 
    
    def title;
    
    void init1() {
        title = 'Tab Item #1';
    }
    
    void init2() {
        title = 'Tab Item #2';
    }
    
    void init3() {
        title = 'Tab Item #3';
    }
    
    void openInNewTab() {
        def opener = Inv.lookupOpener( 'home:tab:open', [title: 'Dynamic Tab'] ); 
        caller.tabModel.show( opener ); 
    }
    
    void open() {
        
    }
}