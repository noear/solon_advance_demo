package demo;

import com.zaxxer.hikari.HikariDataSource;
import demo.controller.ApiCodes;
import demo.utils.CacheWrap;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.cache.CacheService;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Result;
import org.noear.solon.validation.ValidatorFailureHandler;
import org.noear.weed.cache.LocalCache;

import javax.sql.DataSource;
import java.lang.annotation.Annotation;

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

    /**
     * 配置验证注解的错误处理
     * */
    @Bean
    public ValidatorFailureHandler failureHandler(){
        return new ValidatorFailureHandler() {
            @Override
            public boolean onFailure(Context ctx, Annotation ano, Result result, String message) {
                throw ApiCodes.CODE_4002003;
            }
        };
    }
}
