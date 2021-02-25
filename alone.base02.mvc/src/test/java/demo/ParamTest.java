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
public class ParamTest extends HttpTestBase {
    @Test
    public void test1() throws Exception {
        assert path("/param/post")
                .data("name","noear")
                .data("gender","1")
                .post()
                .equals("Hello noear");

        assert path("/param/post?name=noear&gender=1")
                .get()
                .equals("Hello noear");
    }

    @Test
    public void test2() throws Exception {

        assert path("/param/path/noear")
                .get()
                .equals("Hello noear");
    }

    @Test
    public void test3() throws Exception {

        assert path("/param/model")
                .data("name","noear")
                .data("level","1")
                .data("mail","noear@noear.org")
                .data("mobile","1xxxaaaabbbb")
                .post()
                .indexOf("noear") >= 0;
    }
}
