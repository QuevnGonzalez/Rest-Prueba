package com.chenao.ws.rest.client;

import javax.swing.JOptionPane;

import com.chenao.ws.rest.vo.UsuarioVo;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class ClienteRest {

	public static void main(String[] args) {
		
		String urlServicio="http://localhost:8080/RestPrueba/servicio/PruebaChenao/validarUsuario";
		System.out.println("Servicio: "+urlServicio);
		
		UsuarioVo usuario = new UsuarioVo();
		usuario.setUsuario(JOptionPane.showInputDialog("Ingrese el usuario"));
		usuario.setPass(JOptionPane.showInputDialog("Ingrese el password"));
		usuario.setValidacion(false);
		
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		
		Client cliente=Client.create(clientConfig);
		
		WebResource webResource = cliente.resource(urlServicio);
		
		ClientResponse respuesta = webResource.type("application/json").post(ClientResponse.class,usuario);
		usuario=respuesta.getEntity(UsuarioVo.class);
		
		System.out.println("Respuesta: [usuario: "+usuario.getUsuario()+"]");
		System.out.println("Respuesta: [usuario validado: "+usuario.isValidacion()+"]");

	}

}
