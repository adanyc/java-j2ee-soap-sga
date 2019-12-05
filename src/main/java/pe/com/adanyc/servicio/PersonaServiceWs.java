package pe.com.adanyc.servicio;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import pe.com.adanyc.domain.Persona;

@WebService
public interface PersonaServiceWs {

	@WebMethod
	public List<Persona> listarPersonas();
}