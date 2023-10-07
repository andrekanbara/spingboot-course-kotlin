package br.com.springcourse.controllers

import br.com.springcourse.exceptions.ResourceNotFoundException
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import br.com.springcourse.converters.ToDoubleConverter
import br.com.springcourse.validators.NumericValidator

@RestController
class MathController {
    val toDoubleConverter = ToDoubleConverter();
    val numericValidator = NumericValidator();

    @RequestMapping(value = ["sum/{numberOne}/{numberTwo}"])
    fun sum(@PathVariable(value = "numberOne") numberOne : String?, @PathVariable(value = "numberTwo") numberTwo : String?): Double {

        if(!numericValidator.isNumeric(numberOne) || !numericValidator.isNumeric(numberTwo)) {
            throw ResourceNotFoundException("please set a numeric value");
       }
        return toDoubleConverter.convertToDouble(numberOne) + toDoubleConverter.convertToDouble(numberTwo);
    }

    @RequestMapping(value = ["minus/{numberOne}/{numberTwo}"])
    fun minus(@PathVariable(value = "numberOne") numberOne: String?, @PathVariable(value = "numberTwo") numberTwo: String?): Double{
        if(!numericValidator.isNumeric(numberOne) || !numericValidator.isNumeric(numberTwo)){
            throw ResourceNotFoundException("please set a numeric value");
        }
        return toDoubleConverter.convertToDouble(numberOne) - toDoubleConverter.convertToDouble(numberTwo)
    }

    @RequestMapping(value = ["times/{numberOne}/{numberTwo}"])
    fun times(@PathVariable(value = "numberOne")numberOne: String?, @PathVariable(value = "numberTwo") numberTwo: String?) : Double{
        if(!numericValidator.isNumeric(numberOne) || !numericValidator.isNumeric(numberTwo)){
            throw ResourceNotFoundException("please set a numeric value");
        }
        return toDoubleConverter.convertToDouble(numberOne) * toDoubleConverter.convertToDouble(numberTwo)
    }

    @RequestMapping(value = ["division/{numberOne}/{numberTwo}"])
    fun division(@PathVariable(value = "numberOne")numberOne: String?, @PathVariable(value = "numberTwo") numberTwo: String?) : Double{
        if(!numericValidator.isNumeric(numberOne) || !numericValidator.isNumeric(numberTwo)){
            throw ResourceNotFoundException("please set a numeric value");
        }
        return toDoubleConverter.convertToDouble(numberOne) * toDoubleConverter.convertToDouble(numberTwo)
    }

    @RequestMapping(value = ["mean/{numberOne}/{numberTwo}"])
    fun mean(@PathVariable(value = "numberOne")numberOne: String?, @PathVariable(value = "numberTwo") numberTwo: String?) : Double{
        if(!numericValidator.isNumeric(numberOne) || !numericValidator.isNumeric(numberTwo)){
            throw ResourceNotFoundException("please set a numeric value");
        }
        return (toDoubleConverter.convertToDouble(numberOne) + toDoubleConverter.convertToDouble(numberTwo)/ 2)
    }

    @RequestMapping(value = ["squareroot/{number}"])
    fun squareRoot(@PathVariable(value = "number")number: String?) : Double{
        if(!numericValidator.isNumeric(number)){
            throw ResourceNotFoundException("please set a numeric value");
        }
        return Math.sqrt(toDoubleConverter.convertToDouble(number))
    }

}