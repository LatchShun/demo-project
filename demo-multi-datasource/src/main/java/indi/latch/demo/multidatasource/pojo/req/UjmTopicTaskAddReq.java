package indi.latch.demo.multidatasource.pojo.req;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Title: UjmTopicTaskAddReq
 * Description:
 * Copyright: 数禾科技 Copyright(c) 2023/2/7
 * Encoding: UNIX UTF-8
 *
 * @author 徐林
 */
@Getter
@Setter
@ToString
public class UjmTopicTaskAddReq {

    private String topicName;

    private String topicInfo;

    private String taskName;
}
