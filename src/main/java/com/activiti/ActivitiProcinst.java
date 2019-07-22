package com.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * 启动流程实例：
 *   前提是先已经完成流程定义的部署工作
 *     启动流程实例activiti使用了那些表
 *       1. act_hi_actinst 已完成的活动信息
 *       2. act_hi_identitylink  参与者信息
 *       3. act_hi_procinst  流程实例
 *       4. act_hi_taskinst  任务实例
 *       5. act_ru_execution 执行表
 *       6. act_ru_identitylink 参与者信息
 *       7. act_ru_task  任务
 */
public class ActivitiProcinst {

    public static void main(String[] args) {

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        RuntimeService runtimeService = processEngine.getRuntimeService();

        //key查询bpmn为后缀的文件点击空白处，左侧显示的id值即为key,或查看表act_re_procdef中显示的key
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess_1");

        System.out.println("流程部署的Id"+processInstance.getDeploymentId());
        System.out.println("流程实例的Id"+processInstance.getId());
        System.out.println("活动Id"+processInstance.getActivityId());
    }
}
