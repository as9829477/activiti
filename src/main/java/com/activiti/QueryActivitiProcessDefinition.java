package com.activiti;

import com.Utils.BeansUtil;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

import java.util.List;

/**
 *查询流程定义
 */
public class QueryActivitiProcessDefinition {

    public static void main(String[] args) {
        ProcessEngine processEngine = BeansUtil.getProcessEngin();

        RepositoryService repositoryService = processEngine.getRepositoryService();

        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();

        List<ProcessDefinition> list = processDefinitionQuery.processDefinitionKey("myProcess_1")
                .orderByProcessDefinitionVersion().desc()
                .list();

        System.out.println(list);
        for (ProcessDefinition processDefinition : list) {
            System.out.println("流程定义的Id===》"+processDefinition.getId());
            System.out.println("流程定义的名称===》"+processDefinition.getName());
            System.out.println("流程定义的key===》"+processDefinition.getKey());
            System.out.println("流程定义的版本号===》"+processDefinition.getVersion());

        }
    }
}
