package pe.com.adanyc.servicio;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

import pe.com.adanyc.datos.PersonaDao;
import pe.com.adanyc.domain.Persona;

@Stateless
@WebService(endpointInterface = "pe.com.adanyc.servicio.PersonaServiceWs")
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaService, PersonaServiceWs {

    @Inject
    private PersonaDao personaDao;

    @Resource
    private SessionContext contexto;

    @Override
    public List<Persona> listarPersonas() {
        return personaDao.findAllPersonas();
    }

    @Override
    public Persona encontrarPersonaPorId(Persona persona) {
        return personaDao.findPersonaById(persona);
    }

    @Override
    public Persona encontrarPersonaPorEmail(Persona persona) {
        return personaDao.findPersonaByEmail(persona);
    }

    @Override
    public void registrarPersona(Persona persona) {
        personaDao.insertPersona(persona);
    }

    @Override
    public void modificarPersona(Persona persona) {
        try {
            personaDao.updatePersona(persona);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarPersona(Persona persona) {
        personaDao.deletePersona(persona);
    }

}

