package indi.latch.demo.multidatasource.service;

import indi.latch.demo.multidatasource.repo.clickhouse.domain.UidList;
import indi.latch.demo.multidatasource.repo.clickhouse.mapper.UidListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Title: UjmUidService
 * Description:
 * Copyright: 数禾科技 Copyright(c) 2023/2/7
 * Encoding: UNIX UTF-8
 *
 * @author 徐林
 */
@Service
public class UjmUidService {

    private final UidListMapper uidListMapper;

    @Autowired
    public UjmUidService(UidListMapper uidListMapper) {
        this.uidListMapper = uidListMapper;
    }

    public List<UidList> listUid() {
        return uidListMapper.listUid();
    }
}
