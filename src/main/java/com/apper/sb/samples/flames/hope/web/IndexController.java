package com.apper.sb.samples.flames.hope.web;

import com.apper.sb.samples.flames.hope.entity.Crush;
import com.apper.sb.samples.flames.hope.entity.FlamesHopeRequest;
import com.apper.sb.samples.flames.hope.entity.FlamesHopeResponse;
import com.apper.sb.samples.flames.hope.entity.Person;
import com.apper.sb.samples.flames.hope.service.FlamesHopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private FlamesHopeService flamesHopeService;

    @PostMapping
    public FlamesHopeResponse compute(@RequestBody FlamesHopeRequest request) {
        Person person = new Person();
        person.setName(request.getName());
        person.setAge(request.getAge());

        Crush crush = new Crush();
        crush.setName(request.getCrushName());
        crush.setAge(request.getCrushAge());
        crush.setCrushPercentage(request.getCrushPercentage());

        int percentage = flamesHopeService.computeCompatibilityResult(person, crush);

        FlamesHopeResponse response = new FlamesHopeResponse();
        response.setPercentage(percentage);
        response.setMessage(percentage > 50 ? "Congrats":"Sad");

        return response;
    }

}
