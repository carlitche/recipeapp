package myrecipeapp

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/recipes" (resources:"recipe")
        "/ingredients"(resources: "ingredient")


        "/"(redirect: '/recipes')
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
