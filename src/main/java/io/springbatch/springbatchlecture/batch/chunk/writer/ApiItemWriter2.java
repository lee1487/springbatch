package io.springbatch.springbatchlecture.batch.chunk.writer;

import io.springbatch.springbatchlecture.batch.domain.ApiRequestVO;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class ApiItemWriter2 implements ItemWriter<ApiRequestVO> {
    @Override
    public void write(List<? extends ApiRequestVO> list) throws Exception {
        
    }
}
