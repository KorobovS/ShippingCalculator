package ru.korobovs;

import lombok.*;

@AllArgsConstructor
@Getter
public class Cargo {

    private int distance;
    private boolean isBig;
    private boolean isFragile;
}