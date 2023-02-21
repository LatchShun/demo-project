package indi.latch.demo.multidatasource.controller;

import indi.latch.demo.multidatasource.pojo.req.UjmTopicTaskAddReq;
import indi.latch.demo.multidatasource.repo.mysql.domain.UjmTaskBasicInfo;
import indi.latch.demo.multidatasource.service.UjmTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title: UjmTaskController
 * Description:
 * Copyright: 数禾科技 Copyright(c) 2023/2/7
 * Encoding: UNIX UTF-8
 *
 * @author 徐林
 */
@RestController
@RequestMapping("/ujm/task")
public class UjmTaskController {

    private final UjmTaskService ujmTaskService;

    @Autowired
    public UjmTaskController(UjmTaskService ujmTaskService) {
        this.ujmTaskService = ujmTaskService;
    }

    @PostMapping("/sameTrans")
    public UjmTaskBasicInfo addTaskInSameTrans(@RequestBody UjmTopicTaskAddReq data) {
        return ujmTaskService.addTopicAndTaskInOneTransaction(data);
    }

    @PostMapping("/diffTrans")
    public UjmTaskBasicInfo addTaskInDiffTrans(@RequestBody UjmTopicTaskAddReq data) {
        return ujmTaskService.addTopicAndTaskInDiffTransaction(data);
    }
}
