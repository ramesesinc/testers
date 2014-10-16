/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testunit;

import com.rameses.common.AbstractAsyncHandler;
import com.rameses.common.AsyncHandler;
import com.rameses.service.ScriptServiceContext;
import java.util.HashMap;
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

        IService proxy = ctx.create("RPTReportRPAService", env, IService.class);
        System.out.println("result-> "+ proxy.generateReportOnRPA(params, new MyHandler()));
    }

    public interface IService {

        Object generateReportOnRPA(Object params, AsyncHandler handler);
    }
    
    private class MyHandler extends AbstractAsyncHandler {

        public void onError(Exception e) {
            System.out.println("onerror-> " + e);
        }

        public void onMessage(Object o) {
            System.out.println("onmessage-> " + o);
        }
        
        public void onTimeout() {
            System.out.println("onTimeout-> ");
        }

        public void onCancel() {
            System.out.println("onCancel-> ");
        }
    }
}
