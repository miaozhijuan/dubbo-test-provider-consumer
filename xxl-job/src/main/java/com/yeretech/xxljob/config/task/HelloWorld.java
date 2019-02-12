package com.yeretech.xxljob.config.task;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.stereotype.Component;

@Component
@JobHandler(value="helloWorld")
//@Comonent 把类交给spring容器管理，必须
//@JobHander 唯一标识一个任务。调度中心会查找这个唯一的名称来启动执行此类的execute方法。
public class HelloWorld extends IJobHandler {

    @Override
    public ReturnT<String> execute(String s) throws Exception {
        System.out.println("你好呀");
        return ReturnT.SUCCESS;
    }
}