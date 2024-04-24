package com.mokcoding.ex03.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// root-context.xml과 동일

@Configuration
@ComponentScan(basePackages = {"com.mokcoding.ex03.service"})
@ComponentScan(basePackages = {"com.mokcoding.ex03.aspect"})
@EnableAspectJAutoProxy // AutoProxy 사용을 위한 어노테이션
@MapperScan(basePackages = {"com.mokcoding.ex03.persistence"}) // 패키지 경로로 Mapper 스캐닝
public class RootConfig {
	
	@Bean // 스프링 bean으로 설정. xml의 <bean> 태그와 동일
	public DataSource dataSource() {
		// 미리 bean instance 만들어놨다가 사용
		HikariConfig config = new HikariConfig();
		config.setDriverClassName("oracle.jdbc.OracleDriver"); // jdbc 드라이버 정보
		config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe"); // DB 연결 url
		config.setUsername("STUDY");
		config.setPassword("1234");
		
		config.setMaximumPoolSize(10); // 최대 풀 크기
		config.setConnectionTimeout(30000); // connection 타임 아웃 설정
		HikariDataSource ds = new HikariDataSource(config); 
		// config 객체를 참조하여 DataSource 객체 생성
		
		return ds;
	} // end dataSource
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		
		SqlSessionFactoryBean sqlSessionFactoryBean
			= new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		return (SqlSessionFactory) sqlSessionFactoryBean.getObject();
	} // end sqlSessionFactory
	
	
	// 트랜잭션 매니저 객체를 빈으로 등록
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
} // end RootConfig
