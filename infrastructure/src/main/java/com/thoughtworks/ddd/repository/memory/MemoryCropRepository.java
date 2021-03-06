package com.thoughtworks.ddd.repository.memory;

import com.thoughtworks.ddd.domain.crop.model.Crop;
import com.thoughtworks.ddd.domain.crop.repository.CropRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryCropRepository implements CropRepository {
    final static List<Crop> CROP_LIST = new ArrayList<>();

    @Override
    public Crop find(String id) {
        return CROP_LIST.stream().filter(crop -> crop.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Crop save(Crop crop) {
        CROP_LIST.add(crop);
        return crop;
    }

    @Override
    public Crop update(Crop crop) {
        Crop oldCrop = this.find(crop.getId());
        oldCrop.setWeight(crop.getWeight());
        oldCrop.setName(crop.getName());
        return oldCrop;
    }

}
