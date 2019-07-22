package com.activiti;

import com.Utils.BeansUtil;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

import java.io.InputStream;
import java.util.zip.ZipInputStream;

/**
 * 压缩格式为zip   QueryActivitiProcessDefinition
 */
public class ActivitiZipDeployment {

    public static void main(String[] args) {
        ProcessEngine processEngin = BeansUtil.getProcessEngin();

        InputStream resourceAsStream = ActivitiZipDeployment.class.getClassLoader()
                .getResourceAsStream("bpmn/qingjia.zip");

        ZipInputStream zipInputStream = new ZipInputStream(resourceAsStream);

        RepositoryService repositoryService = processEngin.getRepositoryService();

        Deployment deployment = repositoryService.createDeployment()
                .addZipInputStream(zipInputStream)
                .name("请假流程")
                .deploy();

        System.out.println(deployment);

    }
}
