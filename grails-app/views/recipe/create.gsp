<!DOCTYPE html>
<html>
<head>
  <meta name="layout" content="main"/>
  <g:set var="entityName" value="${message(code: 'recipe.label', default: 'Recipe')}"/>
  <title><g:message code="default.create.label" args="[entityName]"/></title>
</head>

<body>
<div id="content" role="main">
  <div class="container">
    <section class="row">
      <a href="#create-recipe" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                                     default="Skip to content&hellip;"/></a>
      
      <div class="nav" role="navigation">
        <ul>
          <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
          <li><g:link class="list" action="index"><g:message code="default.list.label"
                                                             args="[entityName]"/></g:link></li>
        </ul>
      </div>
    </section>
    <section class="row">
      <div id="create-recipe" class="col-12 content scaffold-create" role="main">
        <h1><g:message code="default.create.label" args="[entityName]"/></h1>
        <g:if test="${flash.message}">
          <div class="message" role="status">${flash.message}</div>
        </g:if>
        <g:hasErrors bean="${this.recipe}">
          <ul class="errors" role="alert">
          <g:eachError bean="${this.recipe}" var="error">
            <li<g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}" </g:if>>
              <g:message error="${error}"/>
            </li>
          </g:eachError>
          </ul>
        </g:hasErrors>
        <g:form resource="${this.recipe}" method="POST">
          <fieldset class="form">
            %{--                            <f:all bean="recipe"/>--}%
            <div class="fieldcontain required">
              <label>Name<span class="required-indicator">*</span></label>
              <g:textField name="name" value="${recipe.name}"></g:textField>
            </div>
            
            <div class="fieldcontain required">
              <label>Description<span class="required-indicator">*</span></label>
              <g:textField name="description" value="${recipe.description}"></g:textField>
            </div>
            
            <div class="fieldcontain required">
              <label>Time Cooking<span class="required-indicator">*</span></label>
              <g:field type="number" name="timeCooking" value="${recipe.timeCooking}"></g:field>
            </div>
            
            <div class="fieldcontain required">
              <label>Meal Type<span class="required-indicator">*</span></label>
              <g:select name="mealType" from="${['Breakfast', 'Lunch', 'Dinner']}" value="${recipe.mealType}"/>
            </div>
            
            <div class="fieldcontain" id="ingredientContainer">
              <label>Ingredients</label>
              <div class="ingredientRow">
                <g:textField name="ingredients[0].name" value=""/>
                <g:field type="number" name="ingredients[0].amount" value=""/>
              </div>
            </div>
            <button type="button" onclick="addIngredientRow()" style="alignment-baseline: bottom">Add Ingredient</button>
          </fieldset>
          <fieldset class="buttons">
            <g:submitButton name="create" class="save"
                            value="${message(code: 'default.button.create.label', default: 'Create')}"/>
          </fieldset>
        </g:form>
      </div>
    </section>
  </div>
</div>

<script>
    let ingredientCount = 1;

    function addIngredientRow() {
        const container = document.getElementById('ingredientContainer');
        const row = document.createElement('div');
        row.classList.add('ingredientRow');
        const input1 = document.createElement('input');
        input1.type = 'text';
        input1.name = 'ingredients[' + ingredientCount + '].name';
        row.appendChild(input1);
        container.appendChild(row);
        const input2 = document.createElement('input');
        input2.type = 'number';
        input2.name = 'ingredients[' + ingredientCount + '].amount';
        row.appendChild(input2);
        container.appendChild(row);
        ingredientCount++;
    }
</script>
</body>
</html>