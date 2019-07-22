package com.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

/**
 * 流程定义的部署
 *   部署activiti使用了那些表
 *      1. act_re_deployment //部署的信息
 *      2. act_re_procdef    //流程定义的一些信息
 *      3. act_ge_bytearray  //流程定义的bpmn文件及png文件
 */
public class ActivitiDeployment {
    public static void main(String[] args) {

        // 1.创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.得到RepositoryService实例对象
        RepositoryService repositoryService = processEngine.getRepositoryService();

        Deployment deployment = repositoryService.createDeployment()//得到Deployment实例对象
                .addClasspathResource("bpmn/qingjia.bpmn")  //添加bpmn为后缀的文件
                .addClasspathResource("bpmn/qingjia.png")   //添加png为后缀的文件
                .name("请假流程单")  //给这个流程图起名
                .deploy();    //加载
        System.out.println("添加的id"+deployment.getId()); //得到添加流程的id
        System.out.println("添加的name"+deployment.getName());  //得到添加流程的名字
    }
}
