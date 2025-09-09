package com.github.sansarch.freelance_adm_platform.shared.application;

/**
 * A generic interface for use cases in the application layer.
 *
 * @param <I> the type of input to the use case
 * @param <O> the type of output from the use case
 */
public interface UseCaseInOut<I, O> {
    O execute(I input);
}
