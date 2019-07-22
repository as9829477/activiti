package com.activiti;

import com.Utils.BeansUtil;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;

/**
 * 删除流程定义
 *   注意事项：
 *      1.当我们正在执行的这一套流程没有完全审批结束的时候，此时如果要删除流程定义信息就会失败
 *      2.如果公司层面要强制删除，可以使用repositoryService.deleteDeployment("1",true);
 *          参数true代表级联删除，此时就会先删除没有完成的流程节点信息，最后可以删除流程定义信息。
 *          false代表不级联
 */
public class DeleteActivitiProcessDefinition {

    public static void main(String[] args) {
        ProcessEngine processEngine = BeansUtil.getProcessEngin();

        RepositoryService repositoryService = processEngine.getRepositoryService();

        //参数为部署的id
        repositoryService.deleteDeployment("1");
    }
}
