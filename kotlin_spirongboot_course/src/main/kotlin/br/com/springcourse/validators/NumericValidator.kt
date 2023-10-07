package br.com.springcourse.validators

class NumericValidator {
    fun isNumeric(strNumber: String?): Boolean {
        if(strNumber.isNullOrBlank()) return false;
        return strNumber.replace(",".toRegex(),".").matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex());
    }
}