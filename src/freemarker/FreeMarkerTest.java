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

		//����ftl����Ŀ¼
		cfg.setDirectoryForTemplateLoading(
		        new File("template"));
		//�������ݵ�ץȡģʽ
		cfg.setObjectWrapper(new DefaultObjectWrapper());  
		
		// ��������
        Map latest = new HashMap();
        latest.put("url", "products/greenmouse.html");
        latest.put("name", "green mouse");
        latest.put("sex", 1);

		Map root = new HashMap();
        root.put("user", "Big Joe");
        root.put("latestProduct", latest);
		//ʵ����ģ�����
		Template temp = cfg.getTemplate("freemarker.ftl");
		
		//����html�������Ŀ��
		Writer out = new OutputStreamWriter(System.out);
		temp.process(root, out);
		out.flush();
	}

}
