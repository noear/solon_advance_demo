package demo.utils;

import org.noear.solon.core.cache.CacheService;
import org.noear.weed.cache.ICacheServiceEx;

/**
 * @author noear 2021/2/25 created
 */
public class CacheWrap implements CacheService {
    ICacheServiceEx real;

    public CacheWrap(ICacheServiceEx real) {
        this.real = real;
    }

    @Override
    public void store(String key, Object obj, int seconds) {
        real.store(key, obj, seconds);
    }

    @Override
    public Object get(String key) {
        return real.get(key);
    }

    @Override
    public void remove(String key) {
        real.remove(key);
    }
}
