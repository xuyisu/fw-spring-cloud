//package com.yisu.apollo.client.config;
//
//import com.ctrip.framework.apollo.model.ConfigChangeEvent;
//import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//
//@Slf4j
//public class PropertiesRefresher implements ApplicationContextAware {
//
//
//    private ApplicationContext applicationContext;
//
//
//    @ApolloConfigChangeListener
//    public void onChange(ConfigChangeEvent changeEvent) {
//        refreshZuulProperties(changeEvent);
//    }
//
//    private void refreshZuulProperties(ConfigChangeEvent changeEvent) {
//        logger.info("Refreshing zuul properties!");
//
//        /**
//         * rebind configuration beans, e.g. ZuulProperties
//         * @see org.springframework.cloud.context.properties.ConfigurationPropertiesRebinder#onApplicationEvent
//         */
//        this.applicationContext.publishEvent(new EnvironmentChangeEvent(changeEvent.changedKeys()));
//
//        /**
//         * refresh routes
//         * @see org.springframework.cloud.netflix.zuul.ZuulServerAutoConfiguration.ZuulRefreshListener#onApplicationEvent
//         */
//        this.applicationContext.publishEvent(new RoutesRefreshedEvent(routeLocator));
//
//        logger.info("Zuul properties refreshed!");
//    }
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.applicationContext = applicationContext;
//    }
//}