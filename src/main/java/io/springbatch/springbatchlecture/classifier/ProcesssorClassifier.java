package io.springbatch.springbatchlecture.classifier;

import org.springframework.classify.Classifier;

public class ProcesssorClassifier<C, T> implements Classifier<C,T> {

    @Override
    public T classify(C c) {
        return null;
    }
}
