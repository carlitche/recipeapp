package myrecipeapp

class BootStrap {

    def init = { servletContext ->
        // Create a Recipe
//        def recipe = new Recipe(name: "Tomato Soup", description:  "delicious tomato soup", timeCooking: 20, mealType: "Dinner")
//
//        // Create Ingredients
//        def tomatoes = new Ingredient(name: "Tomatoes", amount: 5)
//        recipe.addToIngredients(tomatoes)
//        def onion = new Ingredient(name: "Onion", amount: 1)
//        recipe.addToIngredients(onion)
//        def garlic = new Ingredient(name: "Garlic", amount: 1)
//        recipe.addToIngredients(garlic)
//        def vegetableBroth = new Ingredient(name: "Vegetable Broth", amount: 2)
//        recipe.addToIngredients(vegetableBroth)
//        def salt = new Ingredient(name: "Salt", amount: 1)
//        recipe.addToIngredients(salt)
//        def pepper = new Ingredient(name: "Pepper", amount: 1)
//        recipe.addToIngredients(pepper)
//
//        // Save the recipe
//        recipe.save()



        environments {
            production {
//                // Create Ingredients
//                def tomatoes = new Ingredient(name: "Tomatoes", amount: 5)
//                recipe.addToIngredients(tomatoes)
//                def onion = new Ingredient(name: "Onion", amount: 1)
//                recipe.addToIngredients(onion)
//                def garlic = new Ingredient(name: "Garlic", amount: 1)
//                recipe.addToIngredients(garlic)
//                def vegetableBroth = new Ingredient(name: "Vegetable Broth", amount: 2)
//                recipe.addToIngredients(vegetableBroth)
//                def salt = new Ingredient(name: "Salt", amount: 1)
//                recipe.addToIngredients(salt)
//                def pepper = new Ingredient(name: "Pepper", amount: 1)
//                recipe.addToIngredients(pepper)
//
//                // Save the recipe
//                recipe.save()
            }
            development {
                for (int i = 1; i <= 20; i++) {
                    def recipe = new Recipe(
                            name: "Recipe ${i}",
                            description: "Description ${i}",
                            timeCooking: 20,
                            mealType: "Dinner"
                    )

                    // Create Ingredients
                    def tomatoes = new Ingredient(name: "Tomatoes", amount: 5)
                    recipe.addToIngredients(tomatoes)
                    def onion = new Ingredient(name: "Onion", amount: 1)
                    recipe.addToIngredients(onion)
                    def garlic = new Ingredient(name: "Garlic", amount: 1)
                    recipe.addToIngredients(garlic)
                    def vegetableBroth = new Ingredient(name: "Vegetable Broth", amount: 2)
                    recipe.addToIngredients(vegetableBroth)
                    def salt = new Ingredient(name: "Salt", amount: 1)
                    recipe.addToIngredients(salt)
                    def pepper = new Ingredient(name: "Pepper", amount: 1)
                    recipe.addToIngredients(pepper)

                    // Save the recipe
                    recipe.save()
                }
            }
        }
    }
    def destroy = {
    }
}
