package usuarios.utils;

import usuarios.Asistente;
import usuarios.Cliente;
import usuarios.Gerente;
import usuarios.Usuario;

import java.util.ArrayList;

public class UsuarioModel {
    private ArrayList<Cliente> clientes;
    private ArrayList<Asistente> asistentes;
    private ArrayList<Gerente> gerentes;

    public ArrayList<Cliente> getClientes() { return clientes; }

    public ArrayList<Asistente> getAsistentes() { return asistentes; }

    public ArrayList<Gerente> getGerentes() { return gerentes; }
}