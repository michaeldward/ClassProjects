class Types{
    val cantChangeMe : String = "Immutable Value"
    var changeMe : String = "Mutable Value"
    var inferredInteger = 1
    var inferredString = "String"

    //cantChangeMe = "Trying to change"
    changeMe = "Changing you"
    //inferredString = inferredInteger
}