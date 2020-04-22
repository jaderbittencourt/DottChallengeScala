package bittencourt.jader.dottchallenge.validator

import java.util.regex.Pattern

object Validator {

  def containsCorrectAdditionalArguments(args: Array[String]): Boolean = {
    if (args.length <= 2) return false

    for (i <- 2 until args.length) {
      if (isAdditionalParameterIncorrect(args(i))) {
        printParameterMessage()
        return false
      }
    }
    true
  }

  private def isAdditionalParameterIncorrect(parameter: String): Boolean = {
    if (parameterDoesNotMatchesRegex(parameter) ||
      parameterDoesNotContainRightSymbol(parameter) ||
      isIncorrectIntervalParameter(parameter) ||
      isIncorrectGreaterThanParameter(parameter) ||
      isIncorrectLowerThanParameter(parameter))
      return true

    false
  }

  private def parameterDoesNotContainRightSymbol(parameter: String)
    = !parameter.contains("-") && !parameter.contains(">") && !parameter.contains("<")

  private def isIncorrectIntervalParameter(parameter: String): Boolean = {
    if (!parameter.contains("-")) return false
    val splitParameter = parameter.split("-")
    !(splitParameter.length == 2 && splitParameterContainsValidString(splitParameter))
  }

  private def isIncorrectGreaterThanParameter(parameter: String): Boolean = {
    if (!parameter.contains(">")) return false
    val splitParameter = parameter.split(">")
    !(splitParameter.length == 2 && splitParameter(0) == "" && parameterContainsValidString(splitParameter(1)))
  }

  private def isIncorrectLowerThanParameter(parameter: String): Boolean = {
    if (!parameter.contains("<")) return false
    val splitParameter = parameter.split("<")
    !(splitParameter.length == 2 && splitParameter(0) == "" && parameterContainsValidString(splitParameter(1)))
  }

  private def parameterDoesNotMatchesRegex(parameter: String) = !Pattern.matches("^[0-9\\-><]+$", parameter)

  private def splitParameterContainsValidString(splitParameter: Array[String]): Boolean = {
    for (s <- splitParameter) {
      if (!Pattern.matches("^[0-9]+$", s)) return false
    }
    true
  }

  private def parameterContainsValidString(parameter: String) = Pattern.matches("^[0-9]+$", parameter)

  private def printParameterMessage(): Unit = {
    println("Additional interval parameter incorrect.")
    println("Interval parameter must match the following pattern:")
    println("x-y for interval between months: 1-3 represents between one and three months")
    println(">x for interval older than x: >12 represents older than twelve months")
    println("<x for interval younger than x: <12 represents younger than twelve months")
  }
}