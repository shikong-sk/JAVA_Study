/* 
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved. 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not 
 * use this file except in compliance with the License. You may obtain a copy 
 * of the License at 
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0 
 *   
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the 
 * License for the specific language governing permissions and limitations 
 * under the License.
 * 
 */
 
package cn.skcks.other.quartz;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.DateBuilder.evenSecondDateAfterNow;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/*
    Quartz
 */
public class TestQuartz {

  public void run() throws Exception {


    // 创建 SchedulerFactory 调度器工厂
    SchedulerFactory schedulerFactory = new StdSchedulerFactory();

    // 从工厂中获取调度器对象
    Scheduler scheduler = schedulerFactory.getScheduler();

    // 创建 JodDetail 任务
    JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1").build();

    // 任务开始时间
//    Date runTime = evenMinuteDate(new Date());  // 1分钟后
    Date runTime = evenSecondDateAfterNow();      // 1秒后

    // 触发器
//    Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();
    Trigger trigger = newTrigger().withSchedule(simpleSchedule().withIntervalInSeconds(5).withRepeatCount(3-1)).withIdentity("trigger1", "group1").startAt(runTime).build();

    // 注册任务 和 触发条件
    scheduler.scheduleJob(job, trigger);

    // 启动调度
    scheduler.start();

    try {
      // 20 秒后停止
      Thread.sleep(20L * 1000L);
    } catch (Exception e) {
      e.printStackTrace();
    }

    scheduler.shutdown(true);

  }

  public static void main(String[] args) throws Exception {

    TestQuartz example = new TestQuartz();
    example.run();

  }

}
