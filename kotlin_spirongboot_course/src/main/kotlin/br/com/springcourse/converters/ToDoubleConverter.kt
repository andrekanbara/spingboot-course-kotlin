package br.com.springcourse.converters

class ToDoubleConverter {
    fun convertToDouble(strNumber: String?): Double {
        if (strNumber.isNullOrBlank()) return 0.0;
        return strNumber.replace(",".toRegex(),".").toDouble();
    }
}