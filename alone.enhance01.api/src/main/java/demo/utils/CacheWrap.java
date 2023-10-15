package demo.utils;

import org.noear.solon.data.cache.CacheService;
import org.noear.wood.cache.ICacheServiceEx;

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
    public void remove(String key) {
        real.remove(key);
    }

    @Override
    public <T> T get(String key, Class<T> clz) {
        return null;
    }
}
