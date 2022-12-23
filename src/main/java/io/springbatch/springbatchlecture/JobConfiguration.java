package io.springbatch.springbatchlecture;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
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
    private final ExcutionContextTasklet1 excutionContextTasklet1;
    private final ExcutionContextTasklet2 excutionContextTasklet2;
    private final ExcutionContextTasklet3 excutionContextTasklet3;
    private final ExcutionContextTasklet4 excutionContextTasklet4;

    @Bean
    public Job job() {
        return jobBuilderFactory.get("jobExcution")
                .start(step1())
                .next(step2())
                .next(step3())
                .next(step4())
                .build();
    }

    private Step step1() {
        return stepBuilderFactory.get("step1")
                .tasklet(excutionContextTasklet1).build();
    }

    private Step step2() {
        return stepBuilderFactory.get("step2")
                .tasklet(excutionContextTasklet2).build();
    }
    private Step step3() {
        return stepBuilderFactory.get("step3")
                .tasklet(excutionContextTasklet3).build();
    }
    private Step step4() {
        return stepBuilderFactory.get("step4")
                .tasklet(excutionContextTasklet4).build();
    }
}
