package ${baseModulePackage}.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Generated;

import javax.transaction.Transactional;

/**
* ${chineseClassName} 业务层
* @author: ${author!'JpaCodeGenerator'}
*/
@Slf4j
@Service
@Transactional(rollbackOn = Exception.class)
@Generated(value = "${generateClassName}", date = "${.now?date} ${.now?time}", comments = "${chineseClassName} 业务层")
public class ${simpleClassName}Service extends Abstract${simpleClassName}Service {

}
