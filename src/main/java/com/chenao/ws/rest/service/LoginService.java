package com.chenao.ws.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.chenao.ws.rest.vo.UsuarioVo;

@Path("/PruebaChenao")
public class LoginService {

	@POST
	@Path("/validarUsuario")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public UsuarioVo validarUsuario(UsuarioVo usuarioVo) {
		if (usuarioVo.getUsuario().equals("Quevin") && usuarioVo.getPass().equals("12345")) {
			usuarioVo.setValidacion(true);
		}
		
		return usuarioVo;
	}
}
