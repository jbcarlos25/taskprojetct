package com.example.cursoMc;

import com.example.exception.UnsuportedMathOperationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {

    private Logger LOG = LoggerFactory.getLogger(MathController.class);

    @RequestMapping(value="/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
       if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
           throw new UnsuportedMathOperationException("Please set a numeric value! ");
       }
       Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
        return sum;
    }

    @RequestMapping(value="/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Please set a numeric value! ");
        }
        Double sub = convertToDouble(numberOne) - convertToDouble(numberTwo);
        return sub;
    }

    @RequestMapping(value="/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mult(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Please set a numeric value! ");
        }
        Double mult = convertToDouble(numberOne) * convertToDouble(numberTwo);
        return mult;
    }

    private Double convertToDouble(String strNumber) {
        if (strNumber == null) {
            return 0D;
        }
        String number = strNumber.replaceAll(",", ".");
        if(isNumeric(number)){
            return Double.parseDouble(number);
        }
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null){
            return false;
        }
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
