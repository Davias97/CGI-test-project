package com.example.cgitestproject.controllers;

import com.example.cgitestproject.dtos.CircleRequestDTO;
import com.example.cgitestproject.dtos.CircleResponseDTO;
import com.example.cgitestproject.models.Circle;
import com.example.cgitestproject.models.Point;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircleRestController {

    @PostMapping("/circle/isInside")
    public CircleResponseDTO isInsideCircle(@RequestBody CircleRequestDTO circleRequestDTO) {

        Circle circle = new Circle(new Point(circleRequestDTO.getCentreX(), circleRequestDTO.getCentreY()), circleRequestDTO.getRadius());
        Point point = new Point(circleRequestDTO.getPointX(), circleRequestDTO.getPointY());

        CircleResponseDTO responseDTO = new CircleResponseDTO();
        responseDTO.setInsideCircle(circle.isInside(point));
        return responseDTO;
    }

}
