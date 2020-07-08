package com.lzpeng.minimal.common.core.util;

import cn.hutool.script.ScriptUtil;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;


/**
 * var imp = JavaImporter(
 *		Packages.java.lang,
 *		Packages.java.util,
 *		Packages.cn.hutool.extra.spring
 * );
 * with (imp) {
 *     var date = new Date();
 *     System.out.println(date);
 *     var bean = SpringUtil.getBean("beanName");
 * }
 * Nashorn脚本 执行工具
 * @author: Lzpeng
 * @link {https://www.jianshu.com/p/467aaf5254f8}
 */
public class NashornUtil {
	
	/**
	 * 动态执行 Nashorn 脚本
	 * @param script 脚本内容
	 * @param map 需要向脚本中注入的java对象
	 * @throws ScriptException 执行脚本出错
	 * @throws NoSuchMethodException 没有找到方法
	 * @return 脚本执行结果
	 */
	public static Object execute(String script, Map<String, Object> map) throws ScriptException, NoSuchMethodException {
		ScriptEngine nashorn = ScriptUtil.getScript("nashorn");
		StringBuilder builder = new StringBuilder();
		if (map != null) {
			builder.append("function _(");
			String params = String.join(", ", map.keySet());
			builder.append(params);
			builder.append(") {");
			builder.append(script);
			builder.append("}");
			nashorn.eval(builder.toString());
			Invocable invocable = (Invocable) nashorn;
			return invocable.invokeFunction("_", map.values().toArray());
		} else {
			builder.append(script);
			return nashorn.eval(builder.toString());
		}
	}
	
	/**
	 * 动态执行 Nashorn 脚本文件
	 * @param scriptFile 脚本文件
	 * @param map 需要向脚本中注入的java对象
	 * @throws IOException 读取文件异常
	 * @throws ScriptException 执行脚本出错
	 * @throws NoSuchMethodException 没有找到方法
	 * @return 脚本文件执行结果
	 */
	public static Object execute(File scriptFile, Map<String, Object> map) throws IOException, ScriptException, NoSuchMethodException {
		List<String> scripts = Files.readAllLines(scriptFile.toPath());
		String script = String.join(System.lineSeparator(), scripts);
		return execute(script, map);
	}


}
