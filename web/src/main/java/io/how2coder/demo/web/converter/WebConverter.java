package io.how2coder.demo.web.converter;

import java.util.Optional;
import java.util.function.Function;

public interface WebConverter<T> {

    T toObject(Function<String, Optional<String>> extractor);
}
