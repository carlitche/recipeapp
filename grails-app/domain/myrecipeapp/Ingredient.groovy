package myrecipeapp

class Ingredient {
    String name
    Integer amount
    Boolean toDelete = false
    static transients = [ 'toDelete']

    static belongsTo = [ recipe: Recipe]

    static constraints = {
        name(nullable: false)
        amount(min: 1, nullable: false)
    }

    @Override
    String toString() {
        "${name}" + " - " + "${amount}"
    }
}
