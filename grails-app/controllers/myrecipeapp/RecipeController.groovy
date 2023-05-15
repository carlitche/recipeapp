package myrecipeapp

import grails.validation.ValidationException
import javassist.NotFoundException

import static org.springframework.http.HttpStatus.*

class RecipeController {
    static responseFormats = [ 'html', 'json']
    RecipeService recipeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond recipeService.list(params), model:[recipeCount: recipeService.count()]
    }

    def show(Long id) {
        respond recipeService.get(id)
    }

    def create() {
      respond new Recipe(params)
    }

    def save(Recipe recipe) {
        if (recipe == null) {
            notFound()
            return
        }

        try {
            recipeService.save(recipe)
        } catch (ValidationException e) {
            respond recipe.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message',
                                        args: [message(code: 'recipe.label',
                                                       default: 'Recipe'),
                                               recipe.id]
                                        )
                redirect recipe
            }
            '*' { respond recipe, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond recipeService.get(id)
    }

    def update(Recipe recipe) {
        if (recipe == null) {
            notFound()
            return
        }

//        try {
            recipeService.update(recipe)
//        } catch (ValidationException e)
//        {
//            respond recipe.errors, view:'edit'
//            return
//        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'recipe.label', default: 'Recipe'), recipe.id])
                redirect recipe
            }
            '*'{ respond recipe, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        recipeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'recipe.label', default: 'Recipe'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'recipe.label', default: 'Recipe'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

}
