package com.activiti;

import com.Utils.BeansUtil;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * 需求：
 *   1. 从activiti的act_ge_bytearray表中读取两个资源文件
 *   2. 将两个资源文件保存路径F:\工作空间\activiti\src\main\resources\bpmn1
 *
 * 技术方案
 *    1.第一种方式使用activiti的api来实现
 *    2.第二种方式：其实就是原理层面，可以使用jdbc的对blob/clob类型数据的读取，并保存IO流转换
 *      最好commeons-io.jar包可以轻松解决IO操作
 *
 * 真实应用场景：用户想查看这个请假流程有哪些步骤要走
 */
public class QueryBpmnFile {

    public static void main(String[] args) throws IOException {

        ProcessEngine processEngine = BeansUtil.getProcessEngin();

        RepositoryService repositoryService = processEngine.getRepositoryService();

        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();

        //设置查询条件
        ProcessDefinitionQuery definitionQuery = processDefinitionQuery.processDefinitionKey("");
        //执行查询操作，查询出想要的流程定义
        ProcessDefinition processDefinition = definitionQuery.singleResult();
        //通过流程定义信息得到部署id
        String deploymentId = processDefinition.getDeploymentId();
        //获取png文件的名字
        String pngDiagram = processDefinition.getDiagramResourceName();
        //获得bpmn文件的名字
        String bpmnResourceName = processDefinition.getResourceName();
        //通过repositoryService的方法实现读取图片信息及bpmn文件信息（输入流）
        //构建出OutputStream流
        //输入流+输出流的转换
        //关闭流
        try(
                InputStream pngIn=repositoryService.getResourceAsStream(deploymentId,pngDiagram);
                InputStream bpmnIn=repositoryService.getResourceAsStream(deploymentId,bpmnResourceName);
                OutputStream pngOut=new FileOutputStream(new File("F:\\工作空间\\activiti\\src\\main\\resources\\bpmn1\\"+pngDiagram));
                OutputStream bpmnOut=new FileOutputStream(new File("F:\\工作空间\\activiti\\src\\main\\resources\\bpmn1\\"+bpmnResourceName));
                ) {
            IOUtils.copy(pngIn,pngOut);
            IOUtils.copy(bpmnIn,bpmnOut);
        }
    }
}
