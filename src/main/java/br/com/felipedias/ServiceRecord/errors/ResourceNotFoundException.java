package br.com.felipedias.ServiceRecord.errors;

import java.util.UUID;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(UUID uuid){
        super("RECURSO NÃO ENCONTRADO. ID: " + uuid);
    }

    public ResourceNotFoundException (String username){
        super("RECURSO NÃO ENCONTRADO. ID: " + username);
    }
}
