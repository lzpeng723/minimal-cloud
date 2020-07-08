package com.lzpeng.minimal.common.jpa.support;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.db.meta.Column;
import cn.hutool.db.meta.MetaUtil;
import cn.hutool.db.meta.Table;
import com.lzpeng.minimal.common.core.domain.TableDictionary;
import com.lzpeng.minimal.common.core.domain.enums.IntEnum;
import com.lzpeng.minimal.common.jpa.annotation.BooleanValue;
import com.lzpeng.minimal.common.jpa.annotation.DefaultBooleanValue;
import com.lzpeng.minimal.common.jpa.annotation.IntValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.persister.entity.SingleTableEntityPersister;
import org.hibernate.persister.walking.spi.AttributeDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author:  Lzpeng
 * 数据字典工具类
 * 不使用懒加载会导致SessionFactory创建失败
 */
@Lazy
@Slf4j
@Service
public class DataDictionaryService {

    /**
     * hibernate SessionFactory
     */
    private final SessionFactoryImpl sessionFactory;

    /**
     * 数据源
     */
    private final DataSource dataSource;

    @Autowired
    public DataDictionaryService(EntityManagerFactory entityManagerFactory, DataSource dataSource) {
        this.dataSource = dataSource;
        this.sessionFactory = entityManagerFactory.unwrap(SessionFactoryImpl.class);
    }

    /**
     * 得到实体的数据字典
     * @param  entityClass 实体类
     * @return 实体的数据字典
     */
    @SneakyThrows
    public TableDictionary getTableDictionary(Class entityClass) {
        EntityPersister entityPersister = sessionFactory.getMetamodel().entityPersister(entityClass);
        return getTableDictionary((SingleTableEntityPersister) entityPersister);
    }


    /**
     * 得到所有实体的数据字典
     * @return 所有实体的数据字典
     */
    @SneakyThrows
    public List<TableDictionary> getTableDictionary() {
        List<TableDictionary> tableDictionaryList = new ArrayList<>();
        // 获取所有实体信息 key: entityClassName, value: EntityPersister
        Map<String, EntityPersister> entityPersisterMap = sessionFactory.getMetamodel().entityPersisters();
        for (EntityPersister entityPersister : entityPersisterMap.values()) {
            if (entityPersister instanceof SingleTableEntityPersister) {
                SingleTableEntityPersister persister = (SingleTableEntityPersister) entityPersister;
                TableDictionary tableDictionary = getTableDictionary(persister);
                tableDictionaryList.add(tableDictionary);
            }
        }
        return tableDictionaryList;
    }

    /**
     * 通过 persister 获取数据字典
     * @param persister SingleTableEntityPersister Hibernate对象 可以获取此实体对应表信息
     * @see SingleTableEntityPersister
     * @return 数据字典
     */
    private TableInfo getTableDictionary(SingleTableEntityPersister persister) throws Exception {
        // 表名
        String tableName = persister.getTableName();
        // 实体名
        String entityName = persister.getEntityName();
        // 表元数据
        Table tableMeta = MetaUtil.getTableMeta(dataSource, tableName);
        // 数据字典
        TableInfo tableDictionary = new TableInfo();
        // 实体类名
        tableDictionary.setClassName(entityName);
        // 表注释
        tableDictionary.setComment(tableMeta.getComment());
        // 表名
        tableDictionary.setTableName(tableName);
        // 实体类
        Class<?> entityClass = Class.forName(entityName);
        // 实体类上的ApiModel注解
        String apiModel = AnnotationUtil.getAnnotationValue(entityClass, ApiModel.class);
        tableDictionary.setApiModel(apiModel);
        List<ColumnInfo> columnInfos = getColumnInfos(persister, tableMeta, entityClass);
        tableDictionary.getColumns().addAll(columnInfos);
        return tableDictionary;
    }

    /**
     * 通过 persister 和 tableMeta 获取表的列详细信息
     * @param persister SingleTableEntityPersister Hibernate对象 可以获取此实体对应表信息
     * @param tableMeta 表元数据
     * @see SingleTableEntityPersister
     * @see Table
     * @return 所有列的信息
     */
    private List<ColumnInfo> getColumnInfos(SingleTableEntityPersister persister, Table tableMeta, Class<?> entityClass) {
        List<ColumnInfo> columnInfos = new ArrayList<>();
        for (AttributeDefinition attribute : persister.getAttributes()) {
            ColumnInfo columnInfo = new ColumnInfo();
            //在entity中的属性名称
            String propertyName = attribute.getName();
            //对应数据库表中的字段名
            String columnName = persister.getPropertyColumnNames(propertyName)[0];
            // 列元数据
            Column column = tableMeta.getColumn(columnName);
            //列名
            columnInfo.setColumnName(columnName);
            // 字段名
            columnInfo.setFieldName(propertyName);
            // 列注释
            columnInfo.setComment(column.getComment());
            // 是否可以为 null
            columnInfo.setNullable(column.isNullable());
            columnInfo.setSize(column.getSize());
            columnInfo.setType(column.getType());
            columnInfo.setTypeName(column.getTypeName());
            Field field = ReflectUtil.getField(entityClass, propertyName);
            columnInfo.setFieldName(field.getName());
            columnInfo.setClassName(field.getType().getName());
            String apiModelProperty = AnnotationUtil.getAnnotationValue(field, ApiModelProperty.class);
            columnInfo.setApiModelProperty(apiModelProperty);
            List<DictValue> dictValues = getDictValues(field);
            columnInfo.getDictValues().addAll(dictValues);
            columnInfos.add(columnInfo);
        }
        return columnInfos;
    }

    /**
     * 获取该成员变量可以存哪些值
     * @param field 成员变量
     * @return 成员变量值域
     */
    private List<DictValue> getDictValues(Field field) {
        List<DictValue> dictValues = new ArrayList<>();
        Class<?> type = field.getType();
        // 获得 int 型字段的数据字典
        if (int.class.isAssignableFrom(type) || Integer.class.isAssignableFrom(type)) {
            IntValue[] intValues = field.getAnnotationsByType(IntValue.class);
            if (intValues != null && intValues.length > 0){
                for (int i = 0; i < intValues.length; i++) {
                    IntValue intValue = intValues[i];
                    // 字典信息
                    DictValue dictValue = new DictValue();
                    // 数据库中存的值
                    dictValue.setKey(intValue.key());
                    // 前端展示的值
                    dictValue.setValue(intValue.value());
                    // 顺序号
                    dictValue.setOrderNum(i + 1);
                    dictValues.add(dictValue);
                }
            }
        }

        // 获得 枚举 型字段的数据字典
        if (IntEnum.class.isAssignableFrom(type) && type.isEnum()) {
            IntEnum[] enums = (IntEnum[]) type.getEnumConstants();
            for (IntEnum anEnum : enums) {
                // 字典信息
                DictValue dictValue = new DictValue();
                // 数据库中存的值
                dictValue.setKey(anEnum.getCode());
                // 前端展示的值
                dictValue.setValue(anEnum.getMessage());
                // 顺序号
                dictValue.setOrderNum(anEnum.getCode() + 1);
                dictValues.add(dictValue);
            }
        }
        // 获得 boolean 型字段的数据字典
        if (boolean.class.isAssignableFrom(type) || Boolean.class.isAssignableFrom(type)) {
            BooleanValue booleanValue = field.getAnnotation(BooleanValue.class);
            if (booleanValue == null) {
                booleanValue = new DefaultBooleanValue();
            }
            String trueValue = booleanValue.trueValue();
            String falseValue = booleanValue.falseValue();
            Boolean defaultValue = booleanValue.defaultValue();
            DictValue trueDictValue = new DictValue();
            trueDictValue.setKey(1);
            trueDictValue.setValue(trueValue);
            trueDictValue.setDefaulted(defaultValue);
            DictValue falseDictValue = new DictValue();
            falseDictValue.setKey(0);
            falseDictValue.setValue(falseValue);
            falseDictValue.setDefaulted(!defaultValue);
            dictValues.add(trueDictValue);
            dictValues.add(falseDictValue);
        }
        return dictValues;
    }

}
