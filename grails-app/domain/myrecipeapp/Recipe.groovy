package myrecipeapp

class Recipe {
    String name
    String description
    Integer timeCooking
    String mealType

    static hasMany = [ingredients: Ingredient]

    static constraints = {
        name(nullable: false)
        description(nullable: false)
        timeCooking(min: 1)
        mealType( inList: [ "Breakfast", "Lunch", "Dinner"])
    }

    @Override
    String toString() {
        "${name}"
    }
}
