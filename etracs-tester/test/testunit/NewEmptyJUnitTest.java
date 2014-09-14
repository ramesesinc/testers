/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testunit;

import com.rameses.service.ScriptServiceContext;
import groovy.util.AntBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.TestCase;

/**
 *
 * @author compaq
 */
public class NewEmptyJUnitTest extends TestCase {

    private ScriptServiceContext ctx;
    private Map env = new HashMap();

    public NewEmptyJUnitTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
        Map appenv = new HashMap();
        appenv.put("app.host", "localhost:8070");
        appenv.put("app.cluster", "osiris3");
        appenv.put("app.context", "etracs25");
        appenv.put("readTimeout", "5000");
        appenv.put("connectTimeout", "5000");
        ctx = new ScriptServiceContext(appenv);
        env.put("USER", "sa");
        env.put("USERID", "sa");
    }

    protected void tearDown() throws Exception {
    }

    public void testMain() throws Exception {

        Map params = new HashMap();
        params.put("searchtext", "%");

        IService proxy = ctx.create("UserService", env, IService.class);
        for (int i=0; i<50; i++) {
            try {
                List list = proxy.getList(params);
                System.out.println("list-size: " + list.size());
            } catch(Throwable t) {
                System.out.println("ERROR: " + t.getClass().getName() + ": " + t.getMessage()); 
            }
            
            Thread.sleep(500);
        }
    }

    public interface IService {

        List getList(Object params);
    }
}
