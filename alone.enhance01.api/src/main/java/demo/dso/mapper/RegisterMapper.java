package demo.dso.mapper;

import java.math.*;
import java.sql.SQLException;
import java.time.*;
import java.util.*;

import org.noear.wood.BaseMapper;
import org.noear.wood.DataItem;
import org.noear.wood.DataList;
import org.noear.wood.annotation.Db;
import org.noear.wood.xml.Namespace;
import demo.model.db.*;

@Db("db1")
@Namespace("demo.dso.mapper.RegisterMapper")
public interface RegisterMapper{
    //添加服务
    long addService(WaterRegServiceDo model) throws SQLException;

    //更新服务
    long udpService(WaterRegServiceDo model) throws SQLException;

    //删除服务
    long delService(String key) throws SQLException;

    //查找服务
    List<WaterRegServiceDo> getServiceList(String name) throws SQLException;
}
