package com.Utils;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;

public class BeansUtil {

    public static ProcessEngine getProcessEngin(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        return  processEngine;
    }
}
