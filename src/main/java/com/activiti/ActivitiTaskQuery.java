package com.activiti;

import com.Utils.BeansUtil;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * 实例任务的查询
 */
public class ActivitiTaskQuery {


    public static void main(String[] args) {

        ProcessEngine processEngine = BeansUtil.getProcessEngin();

        TaskService taskService = processEngine.getTaskService();

        List<Task> list = taskService.createTaskQuery()
                .processDefinitionKey("myProcess_1") //部署的key键
                //.taskAssignee("zhangsan")  //申请人的名字
                .list();

        for (Task task : list) {
            System.out.println(("任务的实例id:" + task.getProcessInstanceId()));
            System.out.println("任务的id:"+task.getId());
            System.out.println("任务的名字："+task.getName());
        }
    }
}
