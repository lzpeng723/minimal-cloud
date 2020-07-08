package ${baseModulePackage}.controller;


import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Generated;

/**
* ${chineseClassName}Controller
* @author: ${author!'JpaCodeGenerator'}
*/
@Slf4j
@RestController
@RequestMapping("/${moduleName}/${simpleClassName?uncap_first}")
@Generated(value = "${generateClassName}", date = "${.now?date} ${.now?time}", comments = "${chineseClassName}控制层")
@Api(tags = "${chineseClassName}管理接口", value = "${chineseClassName}管理，提供${chineseClassName}的增、删、改、查等功能")
public class ${simpleClassName}Controller extends Abstract${simpleClassName}Controller {

}