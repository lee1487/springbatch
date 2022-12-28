package io.springbatch.springbatchlecture.batch.tasklet;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.repeat.RepeatStatus;

import io.springbatch.springbatchlecture.batch.domain.ApiRequestVO;
import io.springbatch.springbatchlecture.batch.domain.ProductVO;

public class ApiEndTasklet implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {

        return null;
    }

}
