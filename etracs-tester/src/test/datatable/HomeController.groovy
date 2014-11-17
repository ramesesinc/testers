
package test.datatable;

import com.rameses.rcp.common.*;
import com.rameses.rcp.annotations.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*
        
class HomeController
{
    void init() {
        
    }
    
    def items = [
        [name: 'product 1'],
        [name: 'product 2'],
        [name: 'product 3']
    ]; 

    def listhandler = [
        fetchList: {
            return items; 
        },
        onRemoveItem: {
            items.remove(it); 
            return true; 
        }
    ] as EditorListModel;
    
    
}