<!DOCTYPE html>
<html>
<head>
  <meta name="layout" content="main"/>
  <g:set var="entityName" value="${message(code: 'recipe.label', default: 'Recipe')}"/>
  <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<div id="content" role="main">
  <div class="container">
    <section class="row">
      <a href="#show-recipe" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                                   default="Skip to content&hellip;"/></a>

      <div class="nav" role="navigation">
        <ul>
          <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
          <li><g:link class="list" action="index"><g:message code="default.list.label"
                                                             args="[entityName]"/></g:link></li>
          <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                                args="[entityName]"/></g:link></li>
        </ul>
      </div>
    </section>
    <section class="row">
      <div id="show-recipe" class="col-12 content scaffold-show" role="main">
        <h1><g:message code="default.show.label" args="[entityName]"/></h1>
        <g:if test="${flash.message}">
          <div class="message" role="status">${flash.message}</div>
        </g:if>
%{--        <f:display bean="recipe"/>--}%
        <ol class="property-list recipe">
          <li class="fieldcontain">
            <span id="name-label" class="property-label">Name</span>
            <div class="property-value" aria-labelledby="name-label">${recipe.name}</div>
          </li>

          <li class="fieldcontain">
            <span id="description-label" class="property-label">Description</span>
            <div class="property-value" aria-labelledby="description-label">${recipe.description}</div>
          </li>

          <li class="fieldcontain">
            <span id="timeCooking-label" class="property-label">Time Cooking</span>
            <div class="property-value" aria-labelledby="timeCooking-label">${recipe.timeCooking}</div>
          </li>

          <li class="fieldcontain">
            <span id="mealType-label" class="property-label">Meal Type</span>
            <div class="property-value" aria-labelledby="mealType-label">${recipe.mealType}</div>
          </li>

          <li class="fieldcontain">
            <span id="ingredients-label" class="property-label">Ingredients</span>
            <div class="property-value" aria-labelledby="ingredients-label">
              <table>
                <thead>
                <tr>
                  <th>Name</th>
                  <th>Amount</th>
                </tr>
                </thead>
                <tbody>
                <g:each in="${recipe.Ingredients}" var="it">
                  <tr>
                    <td>${it.name}</td>
                    <td>${it.amount}</td>
                  </tr>
                </g:each>
                </tbody>
              </table>
            </div>
          </li>

        </ol>
   
        <g:form resource="${this.recipe}" method="DELETE">
          <fieldset class="buttons">
            <g:link class="edit" action="edit" resource="${this.recipe}"><g:message code="default.button.edit.label"
                                                                                    default="Edit"/></g:link>
            <input class="delete" type="submit"
                   value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                   onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
          </fieldset>
        </g:form>
      </div>
    </section>
  </div>
</div>
</body>
</html>
