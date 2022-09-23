package demo.dso.service;

import java.sql.SQLException;
import java.util.*;

import org.noear.solon.annotation.Inject;
import org.noear.solon.aspect.annotation.Service;
import org.noear.solon.data.annotation.Cache;
import org.noear.solon.data.annotation.CachePut;
import demo.model.db.*;

@Service
public class RegisterService {
    @Inject
    demo.dso.mapper.RegisterMapper mapper;

    //注册服务（cache:注册服务后，直接更新缓存）
    @CachePut(tags = "services:${name}")
    public List<WaterRegServiceDo> regService(String name, WaterRegServiceDo model) throws SQLException {
        if (mapper.udpService(model) < 1) {
            mapper.addService(model);
        }

        return mapper.getServiceList(name);
    }


    //删除服务（cache:删除服务后，直接更新缓存）
    @CachePut(tags = "services:${name}")
    public List<WaterRegServiceDo> delService(String name, String key) throws SQLException {
        mapper.delService(key);
        return mapper.getServiceList(name);
    }

    //查找服务
    @Cache(tags = "services:${name}")
    public List<WaterRegServiceDo> getServiceList(String name) throws SQLException {
        return mapper.getServiceList(name);
    }
}
