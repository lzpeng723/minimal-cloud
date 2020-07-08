package ${baseModulePackage}.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import ${baseProjectPackage}.common.jpa.service.${entityType}Service;
import ${fullClassName};
import ${baseModulePackage}.repository.${simpleClassName}Repository;<#if entityType=="LeftTreeRightTable">
import ${leftTree.fullClassName};
import ${baseProjectPackage}.${leftTree.moduleName}.service.${leftTree.simpleClassName}Service;</#if>
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Generated;
import javax.transaction.Transactional;
import java.util.List;

/**
* ${chineseClassName} 抽象业务层 提供基于注解的缓存配置
* @author: ${author!'JpaCodeGenerator'}
*/
@Service
@Transactional(rollbackOn = Exception.class)
@Generated(value = "${generateClassName}", date = "${.now?date} ${.now?time}", comments = "${chineseClassName} 抽象业务层 提供基于注解的缓存配置")
public abstract class Abstract${simpleClassName}Service extends ${entityType}Service<<#if entityType=="LeftTreeRightTable">${leftTree.simpleClassName}, </#if>${simpleClassName}> {


    /**
    * ${chineseClassName}实体类类全路径
    */
    protected static final String ENTITY_NAME = "${fullClassName}";

    /**
    * ${chineseClassName}Repository
    */
    protected ${simpleClassName}Repository ${simpleClassName?uncap_first}Repository;<#if entityType=="LeftTreeRightTable">

    /**
    * ${leftTree.chineseClassName}Service(左树)
    */
    protected ${leftTree.simpleClassName}Service ${leftTree.simpleClassName?uncap_first}Service;</#if>

    /**
    * IOC自动注入${chineseClassName}Repository
    * @param ${simpleClassName?uncap_first}Repository ${chineseClassName}Repository
    */
    @Autowired
    public void set${simpleClassName}Repository(${simpleClassName}Repository ${simpleClassName?uncap_first}Repository) {
        this.baseRepository = ${simpleClassName?uncap_first}Repository;<#if entityType??>
        this.${entityType?uncap_first}Repository = ${simpleClassName?uncap_first}Repository;</#if>
        this.${simpleClassName?uncap_first}Repository = ${simpleClassName?uncap_first}Repository;
    }<#if entityType=="LeftTreeRightTable">

    /**
    * IOC自动注入${leftTree.chineseClassName}Service(左树)
    * @param ${leftTree.simpleClassName?uncap_first}Service ${leftTree.chineseClassName}Service(左树)
    */
    @Autowired
    public void set${leftTree.simpleClassName}Service(${leftTree.simpleClassName}Service ${leftTree.simpleClassName?uncap_first}Service) {
        this.treeService = ${leftTree.simpleClassName?uncap_first}Service;
        this.${leftTree.simpleClassName?uncap_first}Service = ${leftTree.simpleClassName?uncap_first}Service;
    }</#if>


    /**
    * 保存${chineseClassName}
    * @param ${simpleClassName?uncap_first} ${chineseClassName}数据
    * @return 保存之后的${chineseClassName}
    */
    @Override
    @CachePut(value = ENTITY_NAME, key = "#result.id", unless = "#result == null")
    public ${simpleClassName} save(${simpleClassName} ${simpleClassName?uncap_first}) {
        return super.save(${simpleClassName?uncap_first});
    }

    /**
    * 删除${chineseClassName}
    * @param id ${chineseClassName}id
    */
    @Override
    @CacheEvict(value = ENTITY_NAME, key = "#id")
    public void delete(String id) {
        super.delete(id);
    }

    /**
    * 根据 id 更新${chineseClassName}
    * @param id id ${chineseClassName}id
    * @param model 更新的${chineseClassName}
    * @return 更新后的结果
    */
    @Override
    @CachePut(value = ENTITY_NAME, key = "#id", unless = "#result == null")
    public ${simpleClassName} update(String id, ${simpleClassName} model) {
        return super.update(id, model);
    }

    /**
    * 根据ID查询${chineseClassName}
    * @param id ${chineseClassName}id
    * @return ${chineseClassName}
    */
    @Override
    @Cacheable(value = ENTITY_NAME, key = "#id", unless = "#result == null")
    public ${simpleClassName} findById(String id) {
        return super.findById(id);
    }

    /**
    * 从 json 读取实体列表
    * 必须重写此方法否则,TypeReference获取不到泛型参数
    * @param json json字符串
    * @return 实体列表
    * @throws JsonProcessingException json解析异常
    */
    @Override
    public List<${simpleClassName}> readDataFromJson(String json) throws JsonProcessingException {
        List<${simpleClassName}> list = objectMapper.readValue(json, new TypeReference<List<${simpleClassName}>>() {
        });
        return list;
    }

}
