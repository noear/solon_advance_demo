package demo;

import com.zaxxer.hikari.HikariDataSource;
import demo.utils.CacheWrap;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.cache.CacheService;
import org.noear.weed.cache.LocalCache;

import javax.sql.DataSource;

/**
 * @author noear 2021/2/11 created
 */
@Configuration
public class Config {

    /**
     * 配置数据源
     * */
    @Bean("db1")
    public DataSource db1(@Inject("${test.db1}") HikariDataSource ds) {
        return ds;
    }

    @Bean
    public CacheService cache(){
        return new CacheWrap(new LocalCache());
    }
}
