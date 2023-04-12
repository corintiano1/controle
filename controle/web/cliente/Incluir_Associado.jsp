<%-- 
    Document   : Incluir_Associado
    Created on : 4 de abr. de 2023, 14:29:40
    Author     : andre_s_lima
--%>

<%@page import="classes.DAO.Cadastro_associadoDAO"%>
<%@page import="classes.DTO.Cadastro_associadoDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%
            try {
                    Cadastro_associadoDTO objCadastra = new Cadastro_associadoDTO();
            objCadastra.setNome_completo(request.getParameter("nome"));
            objCadastra.setCpf(request.getParameter("cpf"));
            objCadastra.setTelefone(request.getParameter("telefone"));
            objCadastra.setEmail(request.getParameter("email"));
          
            Cadastro_associadoDAO objLivroDAO = new Cadastro_associadoDAO();
            objLivroDAO.incluirAssociado(objCadastra);
                } catch (Exception e) {
                }
        %>
    </body>
</html>
