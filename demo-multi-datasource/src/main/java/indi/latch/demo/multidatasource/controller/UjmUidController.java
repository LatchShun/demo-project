package indi.latch.demo.multidatasource.controller;

import indi.latch.demo.multidatasource.repo.clickhouse.domain.UidList;
import indi.latch.demo.multidatasource.service.UjmUidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Title: UjmUidController
 * Description:
 * Copyright: 数禾科技 Copyright(c) 2023/2/7
 * Encoding: UNIX UTF-8
 *
 * @author 徐林
 */
@RestController
@RequestMapping("/ujm/uid")
public class UjmUidController {

    private final UjmUidService ujmUidService;

    @Autowired
    public UjmUidController(UjmUidService ujmUidService) {
        this.ujmUidService = ujmUidService;
    }

    @GetMapping("/list")
    public List<UidList> listUid() {
        return ujmUidService.listUid();
    }
}
