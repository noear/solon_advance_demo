package demo;

import org.noear.solon.Solon;

/**
 * @author noear 2021/2/25 created
 */
public class App {
    public static void main(String[] args) {
        Solon.start(App.class, args ,app->{
            Config.tryInit();
        });
    }
}
