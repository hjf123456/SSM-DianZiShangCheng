package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class Main {

	//代码生成器
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AutoGenerator autoGenerator=new AutoGenerator();
		
		DataSourceConfig dataSourceConfig=new DataSourceConfig();
		dataSourceConfig.setDbType(DbType.MYSQL);
		dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
		dataSourceConfig.setUsername("root");
		dataSourceConfig.setPassword("123456");
		dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/mmall?useUnicode=true&characterEncoding=utf-8");
		autoGenerator.setDataSource(dataSourceConfig);
		
		GlobalConfig globalConfig=new GlobalConfig();
		globalConfig.setOpen(true);
		globalConfig.setOutputDir(System.getProperty("user.dir")+"/src/main/java");
		globalConfig.setAuthor("houjianfeng");
		globalConfig.setServiceImplName("%sService");
		autoGenerator.setGlobalConfig(globalConfig);
		
		PackageConfig packageConfig=new PackageConfig();
		packageConfig.setParent("com.example.demo");
		packageConfig.setEntity("entity");
		packageConfig.setMapper("mapper");
		packageConfig.setController("Controller");
		packageConfig.setService("service");
		packageConfig.setServiceImpl("service.impl");
		autoGenerator.setPackageInfo(packageConfig);
		
		StrategyConfig strategyConfig=new StrategyConfig();
		strategyConfig.setEntityLombokModel(true);
		strategyConfig.setNaming(NamingStrategy.underline_to_camel);
		strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
		
		List<TableFill> list=new ArrayList<>();
		TableFill tableFill1=new TableFill("create_time", FieldFill.INSERT);
		TableFill tableFill2=new TableFill("update_time", FieldFill.INSERT_UPDATE);
		list.add(tableFill1);
		list.add(tableFill2);		
		strategyConfig.setTableFillList(list);
		autoGenerator.setStrategy(strategyConfig);
		
		autoGenerator.execute();
		
	}

}
