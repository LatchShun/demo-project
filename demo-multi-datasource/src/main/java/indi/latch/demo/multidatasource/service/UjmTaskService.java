package indi.latch.demo.multidatasource.service;

import indi.latch.demo.multidatasource.pojo.req.UjmTopicTaskAddReq;
import indi.latch.demo.multidatasource.repo.mysql.domain.UjmTaskBasicInfo;
import indi.latch.demo.multidatasource.repo.mysql.domain.UjmTopic;
import indi.latch.demo.multidatasource.repo.mysql.domain.UjmTopicExample;
import indi.latch.demo.multidatasource.repo.mysql.mapper.UjmTaskBasicInfoMapper;
import indi.latch.demo.multidatasource.repo.mysql.mapper.UjmTopicMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Title: UjmTaskService
 * Description:
 * Copyright: 数禾科技 Copyright(c) 2023/2/7
 * Encoding: UNIX UTF-8
 *
 * @author 徐林
 */
@Slf4j
@Service
public class UjmTaskService {

    private static final String UID = "8c7a36db-fa3a-48ca-a030-6b6b82fe7c35";
    private static final String USER_NAME = "徐林";

    private static final String TASK_CATEGORY = "TEST_DEMO";

    private static final String TASK_STATE = "STATE_APPROVED";

    private final UjmTopicMapper ujmTopicMapper;

    private final UjmTaskBasicInfoMapper ujmTaskBasicInfoMapper;

    @Autowired
    public UjmTaskService(UjmTopicMapper ujmTopicMapper, UjmTaskBasicInfoMapper ujmTaskBasicInfoMapper) {
        this.ujmTopicMapper = ujmTopicMapper;
        this.ujmTaskBasicInfoMapper = ujmTaskBasicInfoMapper;
    }

    @Transactional(transactionManager = "mysqlTransactionManager", rollbackFor = RuntimeException.class)
    public UjmTaskBasicInfo addTopicAndTaskInOneTransaction(UjmTopicTaskAddReq data) {
        String topicCode = UUID.randomUUID().toString();
        UjmTopic ujmTopic = new UjmTopic();
        ujmTopic.setName(data.getTopicName());
        ujmTopic.setInfo(data.getTopicInfo());
        ujmTopic.setCode(topicCode);
        ujmTopic.setState(TASK_STATE);
        ujmTopic.setCreatedByUid(UID);
        ujmTopic.setUpdatedByUid(UID);
        ujmTopic.setCreatedBy(USER_NAME);
        ujmTopic.setUpdatedBy(USER_NAME);
        ujmTopicMapper.insertSelective(ujmTopic);

        return addTaskBasicInfo(data.getTopicName(), data.getTaskName());
    }

    @Transactional(transactionManager = "mysqlTransactionManager", rollbackFor = RuntimeException.class,
            propagation = Propagation.REQUIRES_NEW)
    public UjmTaskBasicInfo addTopicAndTaskInDiffTransaction(UjmTopicTaskAddReq data) {
        String topicCode = UUID.randomUUID().toString();
        UjmTopic ujmTopic = new UjmTopic();
        ujmTopic.setName(data.getTopicName());
        ujmTopic.setInfo(data.getTopicInfo());
        ujmTopic.setCode(topicCode);
        ujmTopic.setState(TASK_STATE);
        ujmTopic.setCreatedByUid(UID);
        ujmTopic.setUpdatedByUid(UID);
        ujmTopic.setCreatedBy(USER_NAME);
        ujmTopic.setUpdatedBy(USER_NAME);
        ujmTopicMapper.insertSelective(ujmTopic);

        return addTaskBasicInfoInTrans(data.getTopicName(), data.getTaskName());
    }

    public UjmTaskBasicInfo addTaskBasicInfo(String topicName, String taskName) {
        UjmTopicExample ujmTopicExample = new UjmTopicExample();
        ujmTopicExample.createCriteria().andNameEqualTo(topicName);
        List<UjmTopic> ujmTopics = ujmTopicMapper.selectByExample(ujmTopicExample);
        UjmTopic ujmTopic = ujmTopics.get(0);

        UjmTaskBasicInfo ujmTaskBasicInfo = new UjmTaskBasicInfo();
        ujmTaskBasicInfo.setName(taskName);
        ujmTaskBasicInfo.setTopicCode(ujmTopic.getCode());
        ujmTaskBasicInfo.setCategory(TASK_CATEGORY);
        ujmTaskBasicInfo.setCode(UUID.randomUUID().toString());
        ujmTaskBasicInfo.setState(TASK_STATE);
        ujmTaskBasicInfo.setCreatedBy(USER_NAME);
        ujmTaskBasicInfo.setUpdatedBy(USER_NAME);
        ujmTaskBasicInfo.setCreatedByUid(UID);
        ujmTaskBasicInfo.setUpdatedByUid(UID);
        ujmTaskBasicInfoMapper.insertSelective(ujmTaskBasicInfo);
        return ujmTaskBasicInfo;
    }

    @Transactional(transactionManager = "mysqlTransactionManager", rollbackFor = RuntimeException.class,
            propagation = Propagation.REQUIRES_NEW)
    public UjmTaskBasicInfo addTaskBasicInfoInTrans(String topicName, String taskName) {
        UjmTopicExample ujmTopicExample = new UjmTopicExample();
        ujmTopicExample.createCriteria().andNameEqualTo(topicName);
        List<UjmTopic> ujmTopics = ujmTopicMapper.selectByExample(ujmTopicExample);
        UjmTopic ujmTopic = ujmTopics.get(0);

        UjmTaskBasicInfo ujmTaskBasicInfo = new UjmTaskBasicInfo();
        ujmTaskBasicInfo.setName(taskName);
        ujmTaskBasicInfo.setTopicCode(ujmTopic.getCode());
        ujmTaskBasicInfo.setCategory(TASK_CATEGORY);
        ujmTaskBasicInfo.setCode(UUID.randomUUID().toString());
        ujmTaskBasicInfo.setState(TASK_STATE);
        ujmTaskBasicInfo.setCreatedBy(USER_NAME);
        ujmTaskBasicInfo.setUpdatedBy(USER_NAME);
        ujmTaskBasicInfo.setCreatedByUid(UID);
        ujmTaskBasicInfo.setUpdatedByUid(UID);

        throw new RuntimeException();
        //ujmTaskBasicInfoMapper.insertSelective(ujmTaskBasicInfo);
        //return ujmTaskBasicInfo;
    }
}
