<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>registro.jsp</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
    <!-- action= ruta donde enviamos los parametros-->
    <!--method= forma como se envian get y post-->
    <!-- get muestra los paerametros 
    post envia los parametros ocultos
    -->
<div class="container-fluid">
<h2>Formulario de Registro</h2>

<!-- Esto es un placeholder del msg error -->
    	<c:if test="${msgError!=null}">
    		<div class="alert alert-danger" role="alert">
				<c:out value="${msgError}"></c:out>
			</div>
    	</c:if>

<div class="card text-bg-primary mb-3" style="max-width: 18rem;">
  <div class="card-header">Registro</div>
  <div class="card-body">
    <h5 class="card-title">Ingrese sus datos</h5>
    <div class="card-text">  
    <!--Action = a la ruta que definimos en los Controller.  -->
      <form action="/registro/usuario" method="post">
        <!-- Etiquetas, el id debe ser único para cada input.-->
        <label for="nombre" class="form-label">Nombre:</label>
        <input type="text" id="nombre" name="nombre" class="form-control">
        <br>
        <label for="nick" class="form-label">Nick:</label>
        <input type="text" id="nick" name="nick" class="form-control">
        <br>
        <label for="correo" class="form-label">Email:</label>
        <input type="email" id="email" name="email" class="form-control">
        <br>
        <label for="password" class="form-label">Ingrese Contraseña</label>
        <input type="password" id="pass" name="password" placeholder="Ingrese password" class="form-control">        
		<br>
		<label for="password2" class="form-label">Confirme Contraseña</label>
      	<input type="password" id="pass2" name="password2" placeholder="Ingrese password" class="form-control">
        <br>
       <input type="submit" class="btn btn-secondary" value="Enviar">
       <a class="btn btn-primary" href="/registro/login" role="button">Link</a>
       
    </form>
    </div>
   </div>
    
    
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>