package com.activiti.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.junit.jupiter.api.Test;

public class TestActiviti {

    @Test
    public void test() {
        ProcessEngineConfiguration configuration =ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        ProcessEngine processEngine= configuration.buildProcessEngine();
        System.out.println(processEngine);
    }

    @Test
    public  void test1(){
        /**
         * 使用processEngine创建25张表需要满足两个条件
         *   （1）activiti的配置文件名必须是activiti.cfg.xml
         *   （2）activiti.cfg.xml配置文件中的org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration这个类的bean
         *       id必须是ProcessEngineConfiguration
         */
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        System.out.println(processEngine);
    }
}
