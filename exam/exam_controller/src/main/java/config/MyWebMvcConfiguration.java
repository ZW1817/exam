package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@EnableWebMvc
public class MyWebMvcConfiguration extends WebMvcConfigurationSupport {

//    private static final List<String> patterns = List.of("/account/**","/f/**");

    //    视图解析器
//    @Bean("resourceViewResoover")
//    public ViewResolver createViewResolver(){
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
////        viewResolver.setPrefix("/WEB-INF/");
////        viewResolver.setSuffix(".jsp");
//        return viewResolver;
//    }

    /**
     * 上传文件
     * */
    @Bean("multipartResolver")
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        return resolver;
    }

//    拦截器
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new MyInterceptor1()).addPathPatterns(patterns);
//        registry.addInterceptor(new MyInterceptor2()).addPathPatterns(patterns);
//    }

//  静态资源处理
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/js/**")
//                .addResourceLocations("/static/js/");
//
//        registry.addResourceHandler("/static/css/**")
//                .addResourceLocations("/static/css/");
//        registry.addResourceHandler("/static/img/**")
//                .addResourceLocations("/static/img/");
//
//    }
}
