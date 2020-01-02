package com.cj.jtsys.sys.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
@Setter
@Getter//getter,setter方法
@Configuration//是个存储配置信息 的配置对象，由spring进行管理
@ConfigurationProperties(prefix = "db.page")//从application.yml找到前缀为db.page的属性
public class PageProperties {
    private int pageSize;//属性名字要和application.yml里面的命名一致，这样会自动赋值过来
}
