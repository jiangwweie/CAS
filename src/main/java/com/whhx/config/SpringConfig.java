package com.whhx.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: jw
 * @date: 2019/5/19
 * @description:
 *   这个配置是空值,是为了让spring 加载 这个包下 标注了  @Service @Component @Controller 等注解的Bean
 *   并需要在resource/META-INF/spring.factories 中配置
 */
@Configuration
@ComponentScan("com.whhx")
public class SpringConfig {

}
