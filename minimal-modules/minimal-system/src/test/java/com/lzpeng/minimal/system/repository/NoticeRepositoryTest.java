package com.lzpeng.minimal.system.repository;

import com.lzpeng.minimal.system.domain.entity.Notice;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Generated;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
* 通知 数据层单元测试
* @author: Lzpeng
*/
@Slf4j
@ExtendWith(SpringExtension.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-25 2:02:06", comments = "通知 数据层单元测试")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class NoticeRepositoryTest {

    /**
    * 通知Repository
    */
    @Autowired
    private NoticeRepository noticeRepository;

    /**
    * 保存通知测试
    */
    @Test
    public void testSave(){
        Notice notice = new Notice();
        notice = noticeRepository.save(notice);
        assertNotNull(notice.getId());
    }

    /**
    * 删除通知测试
    */
    @Test
    public void testDelete(){
        String id = "{}";
        noticeRepository.deleteById(id);
    }

    /**
    * 更新通知测试
    */
    @Test
    public void testUpdate(){
        String id = "{}";
        Optional<Notice> optional = noticeRepository.findById(id);
        optional.ifPresent(notice -> {
            notice = noticeRepository.save(notice);
            assertEquals(notice.getId(), id);
        });
    }

    /**
    * 查询所有通知测试
    */
    @Test
    public void testFindAll(){
        Page<Notice> noticePage = noticeRepository.findAll(PageRequest.of(0, 10));
        assertNotNull(noticePage.getContent());
    }

    /**
    * 根据id查询通知测试
    */
    @Test
    public void testFindById(){
        String id = "{}";
        Optional<Notice> optional = noticeRepository.findById(id);
        Notice notice = optional.orElse(null);
        assertNotNull(notice);
    }
}