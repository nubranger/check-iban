package lt.mano.iban.soap.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs

@Configuration

public class WebServiceConfig {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {

        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();

        messageDispatcherServlet.setApplicationContext(context);

        messageDispatcherServlet.setTransformWsdlLocations(true);

        return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");

    }

    @Bean(name = "soap")

    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema ibanSchema) {

        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();

        definition.setPortTypeName("IbanPort");

        definition.setTargetNamespace("http://iban.mano.lt/soap");

        definition.setLocationUri("/ws");

        definition.setSchema(ibanSchema);

        return definition;

    }

    @Bean

    public XsdSchema ibanSchema() {

        return new SimpleXsdSchema(new ClassPathResource("iban-check.xsd"));

    }

}
