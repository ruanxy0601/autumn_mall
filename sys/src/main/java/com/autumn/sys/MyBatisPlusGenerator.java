package com.autumn.sys;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.logging.log4j.util.PropertiesUtil;

import java.util.Collections;

/**
 * @author ruanxy
 * @date 2021-10-22
 */
public class MyBatisPlusGenerator {

//    private static final String JDBC_URL = PropertiesUtil.getProperties().getStringProperty("spring.datasource.url");
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/autumn_mall";
//    private static final String JDBC_USER_NAME = PropertiesUtil.getProperties().getStringProperty("spring.datasource.username");
    private static final String JDBC_USER_NAME = "root";
//    private static final String JDBC_PASSWORD = PropertiesUtil.getProperties().getStringProperty("spring.datasource.password");
    private static final String JDBC_PASSWORD = "123456";
    private static final String TABLE_NAME = "sys_role";


    public static void main(String[] args) {

        FastAutoGenerator.create(JDBC_URL, JDBC_USER_NAME, JDBC_PASSWORD)
                .globalConfig(builder -> {
                    builder.author("ruanxy") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("gen//"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.autumn") // 设置父包名
                            .moduleName("sys") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "gen\\com\\autumn\\sys\\mapper\\xml")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(TABLE_NAME); // 设置需要生成的表名
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }

}
