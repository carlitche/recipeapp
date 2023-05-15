package myrecipeapp

import grails.gorm.services.Service

interface RecipeServiceInt {

    Recipe get(Serializable id)

    List<Recipe> list(Map args)

    Long count()

    void delete(Serializable id)

    Recipe save(Recipe recipe)

    Recipe update(Recipe recipe)
}