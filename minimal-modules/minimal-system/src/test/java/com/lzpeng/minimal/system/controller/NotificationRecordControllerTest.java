package com.lzpeng.minimal.system.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lzpeng.minimal.system.domain.entity.NotificationRecord;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.Generated;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
* 通知记录 控制层单元测试com.lzpeng.minimal.common.jpa.controller
* @author: Lzpeng
*/
@Slf4j
@EnableWebMvc
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SuppressWarnings("deprecation")
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-25 2:02:06", comments = "通知记录 控制层单元测试")
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
public class NotificationRecordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
    * json 工具类
    */
    private ObjectMapper objectMapper;

    /**
    * 测试用户
    */
    private static final String TEST_USER = "test-user";
    /**
    * 模块名称
    */
    private static final String MODULE_NAME = "system";
    /**
    * 类名称
    */
    private static final String CLASS_NAME = "notificationRecord";
    /**
    * 通知记录列表权限
    */
    private static final String LIST_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":list";
    /**
    * 通知记录查询权限
    */
    private static final String QUERY_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":query";
    /**
    * 通知记录新增权限
    */
    private static final String ADD_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":add";
    /**
    * 通知记录删除权限
    */
    private static final String DELETE_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":delete";
    /**
    * 通知记录修改权限
    */
    private static final String EDIT_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":edit";
    /**
    * 通知记录导出权限
    */
    private static final String EXPORT_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":export";
    /**
    * 通知记录导入权限
    */
    private static final String IMPORT_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":import";

    /**
    * 测试前初始化JSON工具
    */
    @BeforeEach
    public void beforeEach(){
        this.objectMapper = new ObjectMapper();
        this.objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        this.objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
    }


    /**
    * 保存通知记录测试
    */
    @Test
    @WithMockUser(username = TEST_USER, authorities = ADD_PERM)
    public void testSave() throws Exception {
        NotificationRecord notificationRecord = new NotificationRecord();
        String content = objectMapper.writeValueAsString(notificationRecord);
        String result = mockMvc.perform(post("/system/notificationRecord")
                .content(content) // @RequestBody 解析
                .contentType(MediaType.APPLICATION_JSON_UTF8) // @RequestBody 解
//                .param("xxx", "xxx")// @RequestParam 解析
//                .contentType(MediaType.APPLICATION_FORM_URLENCODED) // @RequestParam 解析
                .accept(MediaType.APPLICATION_JSON_UTF8)) // 响应类型
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").isNotEmpty())
                .andReturn().getResponse().getContentAsString();
        log.info("{}",result);
    }

    /**
    * 删除通知记录测试
    */
    @Test
    @WithMockUser(username = TEST_USER, authorities = DELETE_PERM)
    public void testDelete() throws Exception {
        String id = "{}";
        mockMvc.perform(delete("/system/notificationRecord/" + id)
                .contentType(MediaType.APPLICATION_JSON_UTF8) // 请求类型
                .accept(MediaType.APPLICATION_JSON_UTF8)) // 响应类型
                .andExpect(status().isOk());
    }

    /**
    * 更新通知记录测试
    */
    @Test
    @WithMockUser(username = TEST_USER, authorities = EDIT_PERM)
    public void testUpdate() throws Exception {
        String id = "{}";
        NotificationRecord notificationRecord = new NotificationRecord();
        String content = objectMapper.writeValueAsString(notificationRecord);
        String result = mockMvc.perform(put("/system/notificationRecord/" + id)
                .content(content) // @RequestBody 解析
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)) // 响应类型
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").isNotEmpty())
                .andReturn().getResponse().getContentAsString();
        log.info("{}",result);
    }

    /**
    * 分页查询通知记录测试
    */
    @Test
    @WithMockUser(username = TEST_USER, authorities = QUERY_PERM)
    public void testQuery() throws Exception {
        int page = 1;
        int size = 10;
        NotificationRecord notificationRecord = new NotificationRecord();
        String content = objectMapper.writeValueAsString(notificationRecord);
        String result = mockMvc.perform(get("/system/notificationRecord/"+ page + "/" + size)
                .content(content)
                .contentType(MediaType.APPLICATION_JSON_UTF8) // 请求类型
                .accept(MediaType.APPLICATION_JSON_UTF8)) // 响应类型
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.total").isNumber())
                .andReturn().getResponse().getContentAsString();
        log.info(result);
    }

    /**
    * 根据id查询通知记录测试
    */
    @Test
    @WithMockUser(username = TEST_USER, authorities = QUERY_PERM)
    public void testFindById() throws Exception {
        String id = "{}";
        String result = mockMvc.perform(get("/system/notificationRecord/"+ id)
                .contentType(MediaType.APPLICATION_JSON_UTF8) // 请求类型
                .accept(MediaType.APPLICATION_JSON_UTF8)) // 响应类型
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(id))
                .andReturn().getResponse().getContentAsString();
        log.info(result);
    }
}