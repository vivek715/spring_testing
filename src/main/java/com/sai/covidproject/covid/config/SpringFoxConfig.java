package com.sai.covidproject.covid.config;

import com.sai.covidproject.covid.entity.Employee;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


@Configuration
@EnableBatchProcessing
public class SpringFoxConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public DataSource dataSource;

   /* @Autowired
    public EmployeeService employeeService;*/

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverclass;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public DataSource getDataSource() {//throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driverclass);
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(userName);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();

    }

    @Bean
    public StaxEventItemReader<Employee> reader() {
        StaxEventItemReader<Employee> reader = new StaxEventItemReader<Employee>();
        reader.setResource(new ClassPathResource("employee.xml"));
        reader.setFragmentRootElementName("employee");


        Map<String, String> aliases = new HashMap<String, String>();
        aliases.put("employee", "sai.covidproject.covid.entity.Employee");

        XStreamMarshaller xStreamMarshaller = new XStreamMarshaller();
        xStreamMarshaller.setAliases(aliases);

        reader.setUnmarshaller(xStreamMarshaller);

        return reader;
    }

    //@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Bean
    public JdbcBatchItemWriter<Employee> writer() {
        JdbcBatchItemWriter<Employee> writer = new JdbcBatchItemWriter<Employee>();
        writer.setDataSource(dataSource);
        writer.setSql("insert into emp (empid,empname,empdoj,empsal,empdeptid) values (?,?,?,?,?)");
        writer.setItemPreparedStatementSetter(new UserItemPreparedStmSetter());

        return writer;
    }


    private class UserItemPreparedStmSetter implements ItemPreparedStatementSetter<Employee> {

        @Override
        public void setValues(Employee employee, PreparedStatement ps) throws SQLException {
            ps.setInt(1, employee.getEmpId());
            ps.setString(2, employee.getEmpName());
            ps.setDate(3,employee.getEmpDoj());
            ps.setFloat(4,employee.getEmpSal());
            ps.setInt(5,employee.getEmpDeptId()) ;
        }


    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Employee, Employee>chunk(10)
                .reader(reader())
                .writer(writer())
                .build();
    }

    @Bean
    public Job importUserJob() {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .flow(step1())
                .end()
                .build();

    }
}
