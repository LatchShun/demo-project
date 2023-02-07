package indi.latch.demo.multidatasource.service;

import indi.latch.demo.multidatasource.repo.mysql.domain.UjmTopic;
import indi.latch.demo.multidatasource.repo.mysql.domain.UjmTopicExample;
import indi.latch.demo.multidatasource.repo.mysql.mapper.UjmTopicMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Title: UjmTopicService
 * Description:
 * Copyright: 数禾科技 Copyright(c) 2022/12/28
 * Encoding: UNIX UTF-8
 *
 * @author 徐林
 */
@Slf4j
@Service
public class UjmTopicService {

    private final UjmTopicMapper ujmTopicMapper;

    @Autowired
    public UjmTopicService(UjmTopicMapper ujmTopicMapper) {
        this.ujmTopicMapper = ujmTopicMapper;
    }

    public List<UjmTopic> listTopic() {
        UjmTopicExample ujmTopicExample = new UjmTopicExample();
        return ujmTopicMapper.selectByExample(ujmTopicExample);
    }
}
