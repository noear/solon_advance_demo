package demo;

import org.noear.solon.Solon;
import org.noear.solon.annotation.Configuration;
import org.noear.water.WW;
import org.noear.water.WaterClient;
import org.noear.water.model.ConfigM;
import org.noear.wood.DbContext;

/**
 * @author noear 2021/2/11 created
 */
@Configuration
public class Config {
    public static final DbContext water = cfg(WW.water).getDb(true);


    public static ConfigM cfg(String key) {
        if (key.indexOf("/") < 0) {
            return WaterClient.Config.get(WW.water, key);
        } else {
            return WaterClient.Config.getByTagKey(key);
        }
    }

    public static void tryInit() {
        WaterClient.Config.getProperties("water_bcf").forEach((k, v) -> {
            if (Solon.cfg().isDebugMode()) {
                String key = k.toString();
                if (key.indexOf(".session.") < 0) {
                    Solon.cfg().put(k, v);
                }
            } else {
                Solon.cfg().put(k, v);
            }
        });
    }


}
