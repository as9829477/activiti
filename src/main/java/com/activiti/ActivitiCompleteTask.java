package com.activiti;

import com.Utils.BeansUtil;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.TaskService;

/**
 * 实例任务的完成
 *    实例任务完成activiti使用了那些表
 *    1. act_hi_actinst
 *    2. act_hi_identitylink
 *    3. act_hi_taskinst
 *    4. act_ru_identitylink
 *    5. act_ru_task  //当前正在执行的任务信息，如果任务结束则不再添加信息
 */
public class ActivitiCompleteTask {

    public static void main(String[] args) {

        ProcessEngine processEngine = BeansUtil.getProcessEngin();

        TaskService taskService = processEngine.getTaskService();

        //任务的id
        taskService.complete("2505");
    }
}
