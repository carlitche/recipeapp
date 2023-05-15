package myrecipeapp

import grails.gorm.services.Service
import grails.gorm.transactions.Transactional


@Service(Recipe)
abstract class RecipeService implements RecipeServiceInt {

    @Transactional
    @Override
    Recipe update(Recipe recipe) {

        def ingredients = recipe.ingredients
        ingredients.each{ingredient ->
            ingredient.save();
        }

        recipe.save()

    }
}
