package com.example.context.plant.domain.crop.command;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class CreationCropCommand {
    private String name;
    private String weight;
}
