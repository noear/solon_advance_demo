package demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.solon.test.HttpTestBase;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import org.noear.solon.test.SolonTest;

/**
 * @author noear 2021/2/25 created
 */
@RunWith(SolonJUnit4ClassRunner.class)
@SolonTest(MvcApp.class)
public class ViewTest extends HttpTestBase {
    @Test
    public void test() throws Exception {
        assert path("/view").get().indexOf("world") >= 0;
    }
}
