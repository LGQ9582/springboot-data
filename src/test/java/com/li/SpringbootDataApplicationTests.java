package com.li;

import com.li.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest(classes = SpringbootDataApplication.class)
@RunWith(SpringRunner.class)
public class SpringbootDataApplicationTests {


	@Autowired
	javax.sql.DataSource dataSource;

	@Autowired
	UserMapper userMapper;

	@Autowired
	JavaMailSenderImpl mailSender;


	/**
	 *
	 * 简单邮件发送
	 */
	@Test
	public void contextLoads() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("你好呀，我猜你不好！");//标题
		message.setText("谢谢你的课程，内容部分！");//内容

		message.setTo("1220398992@qq.com");
		message.setFrom("1175785980@qq.com");
		mailSender.send(message);
	}

	/**
	 *
	 * 复杂邮件发送
	 * @throws MessagingException
	 */
	@Test
	public void contextLoads2() throws MessagingException {

		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

		helper.setSubject("你好呀，我猜你不好！");
		helper.setText("<p style='color:red'>谢谢你的课程，内容部分！</p>",true);

		//附件
		helper.addAttachment("6.jpg",new File("C:\\Users\\Administrator\\Desktop\\image\\6.jpg"));

		helper.setTo("1175785980@qq.com");
		helper.setFrom("1175785980@qq.com");
		mailSender.send(mimeMessage);
	}
	
	
	@Test
	public void test() throws Exception {
		System.out.println(dataSource.getClass());
		System.out.println(dataSource.getConnection());

		//获得数据库连接
		/*Connection connection = dataSource.getConnection();
		System.out.println(connection);
		connection.close();*/
	}
}
