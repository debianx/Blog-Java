<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="customTags"%>

<customTags:pagetemplate bodyClass="" title="">
	<form:form servletRelativeAction="/login"
		class="pure-form pure-form-stacked">
		<fieldset>
			<label for="email"></label>
			<input type="email" placeholder="Email" name='username' value=''>
			
			<label for="email"></label>
			<input type='password' placeholder="Senha" name='password' />

			<button type="submit" class="pure-button pure-button-primary">Entrar</button>
		</fieldset>
	</form:form>
</customTags:pagetemplate>