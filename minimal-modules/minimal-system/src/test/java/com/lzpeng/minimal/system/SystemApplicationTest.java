package com.lzpeng.minimal.system;

import com.lzpeng.minimal.common.core.domain.ProjectInfo;
import com.lzpeng.minimal.common.jpa.util.JpaIdUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author : Lzpeng
 */
@Slf4j
class SystemApplicationTest {

    @Test
    void getProjectInfo() {
        ProjectInfo projectInfo = ProjectInfo.get();
        log.info(projectInfo.getBaseModulePackage());
        String id = JpaIdUtil.decodeEntityId("aSleq_j0hl_1wdGEJ7HBwQ");
        log.info(id);
    }

}