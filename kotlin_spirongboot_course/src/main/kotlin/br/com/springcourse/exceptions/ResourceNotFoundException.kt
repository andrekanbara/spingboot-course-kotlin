package br.com.springcourse.exceptions

import java.lang.*

class ResourceNotFoundException(exception : String?) : RuntimeException(exception) {

}