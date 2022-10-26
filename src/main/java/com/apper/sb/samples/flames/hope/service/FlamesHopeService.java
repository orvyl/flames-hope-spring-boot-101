package com.apper.sb.samples.flames.hope.service;

import com.apper.sb.samples.flames.hope.entity.Crush;
import com.apper.sb.samples.flames.hope.entity.Person;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class FlamesHopeService {
    public int computeCompatibilityResult(Person person, Crush crush) {
        Random rn = new Random();
        int randomNumber = rn.nextInt(100 - 1) + 1;

        int avg = (crush.getCrushPercentage() + randomNumber)/2;

        return crush.getCrushPercentage() > randomNumber ? randomNumber : avg;
    }
}
