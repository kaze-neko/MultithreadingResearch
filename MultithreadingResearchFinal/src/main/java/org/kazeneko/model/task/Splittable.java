package org.kazeneko.model.task;

import java.util.List;

public interface Splittable<T> {
    List<T> split(int numberOfParts);
}
