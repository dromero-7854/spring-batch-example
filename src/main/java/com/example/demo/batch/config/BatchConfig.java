package com.example.demo.batch.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.batch.item.processor.IBSClientRegisterProcessor;
import com.example.demo.batch.row.mapper.FTDReqRowMapper;
import com.example.demo.domain.FTDepositRequest;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public DataSource dataSource;

//	@Bean
//	public DataSource dataSource() {
//		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:h2:file:/home/usuario/Documents/data/demo");
//		dataSource.setUsername("sa");
//		dataSource.setPassword("password");
//		return dataSource;
//	}

	@Bean
	public JdbcCursorItemReader<FTDepositRequest> reader(){
		JdbcCursorItemReader<FTDepositRequest> reader = new JdbcCursorItemReader<FTDepositRequest>();
		reader.setDataSource(dataSource);
		reader.setSql("SELECT id, state, client_id, account, funds_requested, funds_loaded, last_activity FROM cmf_ftd_request ORDER BY id");
		reader.setRowMapper(new FTDReqRowMapper());
		return reader;
	}

	@Bean
	public IBSClientRegisterProcessor clientProcessor(){
		return new IBSClientRegisterProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<FTDepositRequest> writer() {
		return new JdbcBatchItemWriterBuilder<FTDepositRequest>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<FTDepositRequest>())
				.sql("UPDATE cmf_ftd_request SET state = :state,  client_id = :clientID, account = :account, funds_requested = :fundsRequested, "
						+ "funds_loaded = :fundsLoaded, last_activity = :lastActivity "
						+ "WHERE id = :id")
				.dataSource(dataSource)
				.build();
	}
	
	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<FTDepositRequest, FTDepositRequest> chunk(10)
				.reader(reader())
				.processor(clientProcessor())
				.writer(writer())
				.build();
	}
	
	@Bean
	public Job activities() {
		return jobBuilderFactory.get("activities")
				.incrementer(new RunIdIncrementer())
				.flow(step1())
				.end()
				.build();
	}

}
