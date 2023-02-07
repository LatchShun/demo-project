package indi.latch.demo.multidatasource.repo.clickhouse.mapper;

import indi.latch.demo.multidatasource.repo.clickhouse.domain.UidList;

import java.util.List;

/**
 * Title: UidListMapper
 * Description:
 * Copyright: 数禾科技 Copyright(c) 2023/2/7
 * Encoding: UNIX UTF-8
 *
 * @author 徐林
 */
public interface UidListMapper {

    List<UidList> listUid();
}
