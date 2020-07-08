package ${baseModulePackage}.repository;

import ${fullClassName};
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
* ${chineseClassName} 数据层单元测试
* @author: ${author!'JpaCodeGenerator'}
*/
@Slf4j
@ExtendWith(SpringExtension.class)
@Generated(value = "${generateClassName}", date = "${.now?date} ${.now?time}", comments = "${chineseClassName} 数据层单元测试")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ${simpleClassName}RepositoryTest {

    /**
    * ${chineseClassName}Repository
    */
    @Autowired
    private ${simpleClassName}Repository ${simpleClassName?uncap_first}Repository;

    /**
    * 保存${chineseClassName}测试
    */
    @Test
    public void testSave(){
        ${simpleClassName} ${simpleClassName?uncap_first} = new ${simpleClassName}();
        ${simpleClassName?uncap_first} = ${simpleClassName?uncap_first}Repository.save(${simpleClassName?uncap_first});
        assertNotNull(${simpleClassName?uncap_first}.getId());
    }

    /**
    * 删除${chineseClassName}测试
    */
    @Test
    public void testDelete(){
        String id = "{}";
        ${simpleClassName?uncap_first}Repository.deleteById(id);
    }

    /**
    * 更新${chineseClassName}测试
    */
    @Test
    public void testUpdate(){
        String id = "{}";
        Optional<${simpleClassName}> optional = ${simpleClassName?uncap_first}Repository.findById(id);
        optional.ifPresent(${simpleClassName?uncap_first} -> {
            ${simpleClassName?uncap_first} = ${simpleClassName?uncap_first}Repository.save(${simpleClassName?uncap_first});
            assertEquals(${simpleClassName?uncap_first}.getId(), id);
        });
    }

    /**
    * 查询所有${chineseClassName}测试
    */
    @Test
    public void testFindAll(){
        Page<${simpleClassName}> ${simpleClassName?uncap_first}Page = ${simpleClassName?uncap_first}Repository.findAll(PageRequest.of(0, 10));
        assertNotNull(${simpleClassName?uncap_first}Page.getContent());
    }

    /**
    * 根据id查询${chineseClassName}测试
    */
    @Test
    public void testFindById(){
        String id = "{}";
        Optional<${simpleClassName}> optional = ${simpleClassName?uncap_first}Repository.findById(id);
        ${simpleClassName} ${simpleClassName?uncap_first} = optional.orElse(null);
        assertNotNull(${simpleClassName?uncap_first});
    }
}