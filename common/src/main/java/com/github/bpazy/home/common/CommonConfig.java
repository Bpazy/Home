package com.github.bpazy.home.common;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configurable
@ComponentScan
public class CommonConfig implements WebMvcConfigurer {

}
