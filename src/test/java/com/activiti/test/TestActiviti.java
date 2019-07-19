package com.activiti.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.jupiter.api.Test;

public class TestActiviti {

    @Test
    public void test() {
        ProcessEngineConfiguration configuration =ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("activit.cfg.xml");
        ProcessEngine processEngine= configuration.buildProcessEngine();
        System.out.println(processEngine);
    }
}
