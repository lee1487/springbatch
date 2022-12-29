package io.springbatch.springbatchlecture;

import lombok.RequiredArgsConstructor;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.JobParametersValidator;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class JobConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job batchJob() {
        return jobBuilderFactory.get("batchJob")
                .start(step1())
                .next(step2())
                .next(step3())
                .incrementer(new RunIdIncrementer())
                .validator(new JobParametersValidator() {

					@Override
					public void validate(JobParameters parameters) throws JobParametersInvalidException {
						// TODO Auto-generated method stub

					}
				})
                .preventRestart()
                .listener(new JobExecutionListener() {

					@Override
					public void beforeJob(JobExecution jobExecution) {
						// TODO Auto-generated method stub

					}

					@Override
					public void afterJob(JobExecution jobExecution) {
						// TODO Auto-generated method stub

					}
				})
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println("step1 was executed");
                        return RepeatStatus.FINISHED;
                    }
                }).build();
    }

    @Bean
    public Step step2() {
        return stepBuilderFactory.get("step2")
                .tasklet((stepContribution, chunkContext) -> {
                	System.out.println("step2 was executed");
                	return RepeatStatus.FINISHED;
                })
                .build();
    }

    @Bean
    public Step step3() {
        return stepBuilderFactory.get("step3")
                .tasklet((stepContribution, chunkContext) -> {
                	chunkContext.getStepContext().getStepExecution().setStatus(BatchStatus.FAILED);
                	stepContribution.setExitStatus(ExitStatus.STOPPED);
                	System.out.println("step3 was executed");
                	return RepeatStatus.FINISHED;
                })
                .build();
    }


}
