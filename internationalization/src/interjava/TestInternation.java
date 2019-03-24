package interjava;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class TestInternation {
	public static void main(String[] args) {
//		System.out.println("我要向不同国家的人民问好：您好！");
		//取得系统默认的国家语言环境
//		Locale lc = Locale.getDefault();
		Locale lc = new Locale("US");
		//根据国家语言环境加载资源文件
		ResourceBundle rb = ResourceBundle.getBundle("messageResource",lc);
		//打印出从资源文件中取得的信息
		System.out.println(rb.getString("hello"));
		//带占位符的国际化信息
		//从资源文件中取得的信息
		String msg = rb.getString("welcome");
		//替换消息文本中的占位符，消息文本中的数字占位符将按照参数的顺序
		//从第二个参数开始被替换，即“我”替换{0},"5"替换{1}
		String msgFor = MessageFormat.format(msg, "我","5");
		System.out.println(msgFor);
	}
}
