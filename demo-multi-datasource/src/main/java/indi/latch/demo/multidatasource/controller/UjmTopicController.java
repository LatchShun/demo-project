package indi.latch.demo.multidatasource.controller;

import indi.latch.demo.multidatasource.repo.mysql.domain.UjmTopic;
import indi.latch.demo.multidatasource.service.UjmTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Title: UjmTopicController
 * Description:
 * Copyright: 数禾科技 Copyright(c) 2022/12/28
 * Encoding: UNIX UTF-8
 *
 * @author 徐林
 */
@RestController
@RequestMapping("/ujm/topic")
public class UjmTopicController {

    private final UjmTopicService ujmTopicService;

    @Autowired
    public UjmTopicController(UjmTopicService ujmTopicService) {
        this.ujmTopicService = ujmTopicService;
    }

    @GetMapping("/list")
    public List<UjmTopic> listTopic() {
        return ujmTopicService.listTopic();
    }
}
