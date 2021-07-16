package spring.conf;



import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
public class SpringConfiguration {
	@Autowired
	private ApplicationContext applicationContext;
	@Bean
	public BasicDataSource dataSource(){
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		basicDataSource.setUsername("c##java");
		basicDataSource.setPassword("bit");
		basicDataSource.setMaxTotal(20);
		basicDataSource.setMaxIdle(3);
		
		return basicDataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("spring/mybatis-config.xml"));
		sqlSessionFactoryBean.setDataSource(dataSource());
		//sqlSessionFactoryBean.setMapperLocations(new ClassPathResource("member/dao/memberMapper.xml"));
		//하나짜리
		
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:*/dao/*Mapper.xml"));
		//여러개되는거
	
		return sqlSessionFactoryBean.getObject(); //SqlSessionFactory 리턴
	}
	
	@Bean
	public SqlSessionTemplate sqlSession() throws Exception{
		return new SqlSessionTemplate(sqlSessionFactory());
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager(){
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
		dataSourceTransactionManager.setDataSource(dataSource());
		return dataSourceTransactionManager;
	}
	
	
	
	
	
}














