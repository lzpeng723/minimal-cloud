package ${baseModulePackage}.service;

import cn.hutool.core.io.FileUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import ${baseProjectPackage}.common.core.response.QueryResult;
import ${fullClassName};
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Generated;

import java.nio.charset.Charset;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

/**
* ${chineseClassName} 业务层单元测试
* @author: ${author!'JpaCodeGenerator'}
*/
@Slf4j
@ExtendWith(SpringExtension.class)
@Generated(value = "${generateClassName}", date = "${.now?date} ${.now?time}", comments = "${chineseClassName} 业务层单元测试")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ${simpleClassName}ServiceTest {

    /**
    * ${chineseClassName}Service
    */
    @Autowired
    private ${simpleClassName}Service ${simpleClassName?uncap_first}Service;

    /**
    * 保存${chineseClassName}测试
    */
    @Test
    public void testSave() {
        ${simpleClassName} ${simpleClassName?uncap_first} = new ${simpleClassName}();
        ${simpleClassName?uncap_first} = ${simpleClassName?uncap_first}Service.save(${simpleClassName?uncap_first});
        assertNotNull(${simpleClassName?uncap_first}.getId());
    }

    /**
    * 删除${chineseClassName}测试
    */
    @Test
    public void testDelete() {
        String id = "{}";
        ${simpleClassName?uncap_first}Service.delete(id);
    }

    /**
    * 更新${chineseClassName}测试
    */
    @Test
    public void testUpdate() {
        String id = "{}";
        ${simpleClassName} ${simpleClassName?uncap_first} = new ${simpleClassName}();
        ${simpleClassName?uncap_first} = ${simpleClassName?uncap_first}Service.update(id, ${simpleClassName?uncap_first});
        assertEquals(${simpleClassName?uncap_first}.getId(), id);
    }

    /**
    * 根据id查询${chineseClassName}测试
    */
    @Test
    public void testFindById() {
        String id = "{}";
        ${simpleClassName} ${simpleClassName?uncap_first} = ${simpleClassName?uncap_first}Service.findById(id);
        assertEquals(${simpleClassName?uncap_first}.getId(), id);
    }

    /**
    * 分页查询${chineseClassName}测试
    */
    @Test
    public void testQuery() {
        ${simpleClassName} ${simpleClassName?uncap_first} = new ${simpleClassName}();
        QueryResult<${simpleClassName}> result = ${simpleClassName?uncap_first}Service.query(0, 10, ${simpleClassName?uncap_first});
        assertNotNull(result.getList());
    }

    /**
    * 读取JSON文件测试
    */
    @Test
    public void testReadDataFromJson() throws JsonProcessingException {
        String path = ""; // json File Path
        String json = FileUtil.readString(path, Charset.defaultCharset());
        Collection<${simpleClassName}> ${simpleClassName?uncap_first}s = ${simpleClassName?uncap_first}Service.readDataFromJson(json);
        assertNotNull(${simpleClassName?uncap_first}s);
        log.info("{}", ${simpleClassName?uncap_first}s);
    }

    /**
    * 从JSON文件导入${chineseClassName}测试
    */
    @Test
    public void testImportDataFromJson() throws JsonProcessingException {
        String path = ""; // json File Path
        String json = FileUtil.readString(path, Charset.defaultCharset());
        Collection<${simpleClassName}> ${simpleClassName?uncap_first}s = ${simpleClassName?uncap_first}Service.importDataFromJson(json);
        assertNotNull(${simpleClassName?uncap_first}s);
        log.info("{}", ${simpleClassName?uncap_first}s);
    }

}