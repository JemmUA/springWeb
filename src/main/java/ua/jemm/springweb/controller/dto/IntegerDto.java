package ua.jemm.springweb.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class IntegerDto {
    @Override
    public String toString() {
        return "IntegerDto{" +
                "integer=" + integer +
                '}';
    }

    private Integer integer;
}
