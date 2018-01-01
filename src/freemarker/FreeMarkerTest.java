package freemarker;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerTest {

	public static void main(String[] args) throws Exception {
		
		
		Configuration cfg = new Configuration();

		//配置ftl查找目录
		cfg.setDirectoryForTemplateLoading(
		        new File("template"));
		//设置数据的抓取模式
		cfg.setObjectWrapper(new DefaultObjectWrapper());  
		
		// 构建数据
        Map latest = new HashMap();
        latest.put("url", "products/greenmouse.html");
        latest.put("name", "green mouse");
        latest.put("sex", 1);

		Map root = new HashMap();
        root.put("user", "Big Joe");
        root.put("latestProduct", latest);
		//实例化模板对象
		Template temp = cfg.getTemplate("freemarker.ftl");
		
		//生成html，输出到目标
		Writer out = new OutputStreamWriter(System.out);
		temp.process(root, out);
		out.flush();
	}

}
