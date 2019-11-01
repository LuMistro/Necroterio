package br.com.necroterio.dao.util;

import javax.persistence.Persistence;

public class geraTabelas {
    public static void main(String[] args) {
        Persistence.createEntityManagerFactory("Necroterio-PU");
    }
}
